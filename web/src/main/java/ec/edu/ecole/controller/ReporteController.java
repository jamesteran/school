/**
* Copyright (C) 2017 - Todos los derechos reservados.
* Universidad Tecnologica Equinoccial (UTE)
*/
package ec.edu.ecole.controller;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.model.StreamedContent;

import ec.edu.ecole.user.LoginBean;
import ec.edu.ecole.util.ConstantesUtil;
import ec.edu.ecole.util.JsfUtil;
import ec.edu.ecole.util.ReporteUtil;

@Named("reporteController")
@SessionScoped
public class ReporteController implements Serializable {

	private static final Logger LOG = Logger.getLogger(ReporteController.class.getName());
	private static final long serialVersionUID = 9007889208503522536L;

	@Inject
	private LoginBean loginBean;

	private Date fechaInicio;
	private Date fechaFin;
	private String ticket;
	private String direccionIp = "10.10.101.38";
	private String sitio = "Test_seguridad";
	private String urlTableau;
	private StreamedContent content;

	@PostConstruct
	public void init() {

		String idNumber = loginBean.getIdNumber();

	}

	public void reporteDocentes() {

		Map<String, Object> params = new HashMap<>();
		params.put("fechaInicio", this.fechaInicio);
		try {
			ReporteUtil.obtenerReporteExcel(ConstantesUtil.REPORTE_DS_DW, params,
					"/resources/reportes/jasper/Matriculas.jasper",
					ReporteUtil.obtenerNombreReporte("reporteMatriculas", ConstantesUtil.EXTENSION_XLSX));

		} catch (Exception e) {
			LOG.log(Level.SEVERE, "Error al generar el reporte: " + e.getMessage());
			JsfUtil.presentarMensajeError("Se produjo un error al generar el reporte.");
		}
	}

	/*
	 * Opción que permite visualizar el reporte de matrículas
	 */
	public void visualizarReporteMatriculas() {

		Map<String, Object> params = new HashMap<>();
		params.put("fechaInicio", this.fechaInicio);
		try {
			content = ReporteUtil.obtenerReportePdfParaPagina(ConstantesUtil.REPORTE_DS_DW, params,
					"/resources/reportes/jasper/Matriculas.jasper",
					ReporteUtil.obtenerNombreReporte("reporteMatriculas", ConstantesUtil.EXTENSION_PDF));

		} catch (Exception e) {
			LOG.log(Level.SEVERE, "Error al generar el reporte: " + e.getMessage());
			JsfUtil.presentarMensajeError("Se produjo un error al generar el reporte.");
		}
	}

	/**
	 * @return the content
	 */
	public StreamedContent getContent() {
		return content;
	}

	/**
	 * @param content
	 *            the content to set
	 */
	public void setContent(StreamedContent content) {
		this.content = content;
	}

	/**
	 * @return the urlTableau
	 */
	public String getUrlTableau() {
		return urlTableau;
	}

	/**
	 * @param urlTableau
	 *            the urlTableau to set
	 */
	public void setUrlTableau(String urlTableau) {
		this.urlTableau = urlTableau;
	}

	/**
	 * @return the sitio
	 */
	public String getSitio() {
		return sitio;
	}

	/**
	 * @param sitio
	 *            the sitio to set
	 */
	public void setSitio(String sitio) {
		this.sitio = sitio;
	}

	/**
	 * @return the ticket
	 */
	public String getTicket() {
		return ticket;
	}

	/**
	 * @param ticket
	 *            the ticket to set
	 */
	public void setTicket(String ticket) {
		this.ticket = ticket;
	}

	/**
	 * @return the direccionIp
	 */
	public String getDireccionIp() {
		return direccionIp;
	}

	/**
	 * @param direccionIp
	 *            the direccionIp to set
	 */
	public void setDireccionIp(String direccionIp) {
		this.direccionIp = direccionIp;
	}

	/**
	 * @return the urlReporteTableau
	 */
	public String getUrlReporteTableau() {
		return ticket;
	}

	/**
	 * @param urlReporteTableau
	 *            the urlReporteTableau to set
	 */
	public void setUrlReporteTableau(String urlReporteTableau) {
		this.ticket = urlReporteTableau;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

}
