/**
* Copyright (C) 2017 - Todos los derechos reservados.
* Universidad Tecnologica Equinoccial (UTE)
*/
package ec.edu.ecole.util;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.faces.context.FacesContext;
import javax.naming.InitialContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.apache.commons.lang3.StringUtils;
import org.primefaces.model.DefaultStreamedContent;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimpleXlsxReportConfiguration;

/**
 * Fecha de creacion: 10 oct. 2017
 *
 * @author guido.guerrero
 *
 */
public class ReporteUtil {
	private static final Logger LOG = Logger.getLogger(ReporteUtil.class.getName());
	private static final String JND_REPORTE = "java:jboss/datasources/schoolDS";
	private static final String CARACTER_BAJO = "_";

	public static void reporteXlsx(Map<String, Object> params, String reportPath, String fileXportedName,
			int filaFreeze) throws JRException, IOException {

		String realReportPath = FacesContext.getCurrentInstance().getExternalContext().getRealPath(reportPath);
		File archivo = new File(realReportPath);

		JasperPrint jasperPrint = JasperFillManager.fillReport(archivo.getPath(), params, conectarDS());
		HttpServletResponse httpServletResponse = (HttpServletResponse) FacesContext.getCurrentInstance()
				.getExternalContext().getResponse();
		httpServletResponse.addHeader("Content-Type",
				"application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
		httpServletResponse.addHeader("Content-disposition", "attachment; filename=" + fileXportedName);
		httpServletResponse.addCookie(new Cookie("descargaFileJsfNoAjax", "1"));
		ServletOutputStream outputStream = httpServletResponse.getOutputStream();

		JRXlsxExporter exporter = new JRXlsxExporter();
		exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
		exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(outputStream));

		SimpleXlsxReportConfiguration configuration = new SimpleXlsxReportConfiguration();

		configuration.setIgnorePageMargins(true);
		configuration.setIgnoreCellBackground(false);
		configuration.setIgnoreCellBorder(false);
		configuration.setRemoveEmptySpaceBetweenColumns(true);
		configuration.setRemoveEmptySpaceBetweenRows(true);
		configuration.setDetectCellType(true);
		configuration.setWhitePageBackground(false);
		configuration.setFreezeRow(filaFreeze);

		exporter.setConfiguration(configuration);

		exporter.exportReport();
		outputStream.flush();
		outputStream.close();
		FacesContext.getCurrentInstance().responseComplete();
	}

	/**
	 * 
	 * @param params
	 * @param ruta
	 * @param nombre
	 * @throws JRException
	 * @throws IOException
	 */
	public static void obtenerReporteExcel(String dataSource, Map<String, Object> params, String ruta, String nombre)
			throws JRException, IOException, SQLException {

		String realReportPath = FacesContext.getCurrentInstance().getExternalContext().getRealPath(ruta);
		File archivo = new File(realReportPath);

		Connection cnn = conectarDS();
		HttpServletResponse httpServletResponse = (HttpServletResponse) FacesContext.getCurrentInstance()
				.getExternalContext().getResponse();
		ServletOutputStream outputStream = httpServletResponse.getOutputStream();

		try {

			/* se obtiene el reporte */
			JasperPrint jasperPrint = JasperFillManager.fillReport(archivo.getPath(), params, cnn);

			httpServletResponse.addHeader("Content-Type",
					"application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
			httpServletResponse.addHeader("Content-disposition", "attachment; filename=" + nombre);

			httpServletResponse.addCookie(new Cookie("descargaFileJsfNoAjax", "1"));

			JRXlsxExporter exporter = new JRXlsxExporter();
			exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
			exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(outputStream));

			SimpleXlsxReportConfiguration configuration = new SimpleXlsxReportConfiguration();

			configuration.setIgnorePageMargins(true);
			configuration.setIgnoreCellBackground(false);
			configuration.setIgnoreCellBorder(false);
			configuration.setRemoveEmptySpaceBetweenColumns(true);
			configuration.setRemoveEmptySpaceBetweenRows(true);
			configuration.setDetectCellType(true);
			configuration.setWhitePageBackground(false);

			exporter.setConfiguration(configuration);

			exporter.exportReport();

		} catch (Exception e) {
			LOG.log(Level.SEVERE, "ReporteUtil::obtenerReporteExcel::Exception {0}", new Object[] { e.getMessage() });
		} finally {
			outputStream.flush();
			outputStream.close();
			cnn.close();
		}
		/* se mananda la respuesta al close */
		FacesContext.getCurrentInstance().responseComplete();

	}

	/**
	 * 
	 * @param nombre
	 * @param extension
	 * @return
	 */
	public static String obtenerNombreReporte(String nombre, String extension) {
		StringBuilder sb = new StringBuilder();
		/* nombre del archivo */
		if (!StringUtils.isEmpty(nombre)) {
			sb.append(nombre).append(CARACTER_BAJO);
		} else {
			sb.append("REPORTE").append(CARACTER_BAJO);

		}
		/* Fecha de generacion */
		sb.append(FechaUtil.fechaActualUnderscore()).append(".");

		/* la extension */
		if (StringUtils.isEmpty(extension)) {
			/* por defecto le creo en PDF */
			sb.append("pdf");
		} else {
			sb.append(extension);
		}

		return sb.toString().replaceAll(" ", "_");
	}

	// utiliza la conexion del wildfly
	public static Connection conectarDS() {
		Connection conn = null;
		InitialContext ctx;
		try {
			ctx = new InitialContext();
			DataSource ds = (DataSource) ctx.lookup(JND_REPORTE);
			conn = ds.getConnection();
			LOG.info("Conexion correcta con Jndi.");
		} catch (Exception e) {
			LOG.info("Error al establecer la conexion JNDI");
		}
		return conn;

	}

	public static void obtenerReportePdf(String dataSource, Map<String, Object> params, String nombreArchivoJasper,
			String nombreArchivoDescarga) throws JRException, IOException, SQLException {

		String realReportPath = FacesContext.getCurrentInstance().getExternalContext().getRealPath(nombreArchivoJasper);
		File archivo = new File(realReportPath);

		Connection cnn = conectarDS();
		HttpServletResponse httpServletResponse = (HttpServletResponse) FacesContext.getCurrentInstance()
				.getExternalContext().getResponse();
		ServletOutputStream outputStream = httpServletResponse.getOutputStream();
		try {

			/* En caso de no enviar DataSource "new JREmptyDataSource()" */
			JasperPrint jasperPrint = JasperFillManager.fillReport(archivo.getPath(), params, cnn);

			httpServletResponse.addHeader("Content-Type",
					"application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
			httpServletResponse.addHeader("Content-disposition", "attachment; filename=" + nombreArchivoDescarga);

			httpServletResponse.addCookie(new Cookie("descargaFileJsfNoAjax", "1"));

			JRPdfExporter exporter = new JRPdfExporter();

			exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
			exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(outputStream));

			exporter.exportReport();
		} catch (Exception e) {
			LOG.log(Level.SEVERE, "ReporteUtil::obtenerReportePdf::Exception {0}", new Object[] { e.getMessage() });
		} finally {
			outputStream.flush();
			outputStream.close();
			cnn.close();
		}
		/* se mananda la respuesta al close */
		FacesContext.getCurrentInstance().responseComplete();

	}

	/*
	 * Generador de PDF para presentarlo en pantalla
	 */
	public static DefaultStreamedContent obtenerReportePdfParaPagina(String dataSource, Map<String, Object> params,
			String ruta, String nombre) throws JRException, IOException, SQLException {

		String realReportPath = FacesContext.getCurrentInstance().getExternalContext().getRealPath(ruta);
		File archivo = new File(realReportPath);
		Connection cnn = conectarDS();
		try {
			JasperPrint jasperPrint = JasperFillManager.fillReport(archivo.getPath(), params, cnn);
			byte[] documento = JasperExportManager.exportReportToPdf(jasperPrint);
			return new DefaultStreamedContent(new ByteArrayInputStream(documento));

		} catch (Exception e) {
			LOG.log(Level.SEVERE, "ReporteUtil::obtenerReportePdfParaCorreo::Exception {0}",
					new Object[] { e.getMessage() });
		} finally {
			cnn.close();
		}
		return null;
	}

}
