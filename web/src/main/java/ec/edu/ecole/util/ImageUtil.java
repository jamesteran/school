package ec.edu.ecole.util;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.logging.Logger;

import javax.activation.MimetypesFileTypeMap;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.imageio.ImageIO;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.imgscalr.Scalr;
//import org.primefaces.context.RequestContext;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.UploadedFile;

public class ImageUtil {

	public ImageUtil() {
	}

	private static final Logger LOG = Logger.getLogger(ImageUtil.class.getName());
	public static final String FILE_SEPARATOR = "file.separator";

	/**
	 * @param input
	 */
	public void resizePhoto(InputStream input) {
		try {

			BufferedImage img = ImageIO.read(input);
			BufferedImage scaledImg;
			if (img.getWidth() >= img.getHeight())
				scaledImg = Scalr.resize(img, Scalr.Method.ULTRA_QUALITY, Scalr.Mode.FIT_TO_HEIGHT, 300, 400);
			else
				scaledImg = Scalr.resize(img, Scalr.Method.ULTRA_QUALITY, Scalr.Mode.FIT_TO_WIDTH, 400, 300);
			// ImageIO.write(scaledImg, "jpg", out);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public byte[] imageToByte(InputStream streamFile) {

		try {
			byte[] imageArray; // = new byte[(int) streamFile.available()];
			imageArray = IOUtils.toByteArray(streamFile);
			// streamFile.read(imageArray);
			// streamFile.close();
			return imageArray;
		} catch (IOException e) {
			e.printStackTrace();
		}
		;
		return null;
	}

	public String crearImagen(String fileName, UploadedFile uploadedFile) {
		String nombrePic = "student.png";

		/*
		 * if(uploadedFile != null) {
		 * System.out.println("lllllllllllll"+uploadedFile.getFileName()); try {
		 * uploadedFile.write(
		 * "C:\\opt\\ProyectosJava\\WorkspacesJdev\\sms\\school\\web\\src\\main\\webapp\\resources\\images\\carnets"
		 * + uploadedFile.getFileName()); //potential path traversal } catch
		 * (Exception e) { e.printStackTrace(); } }
		 * 
		 * try { copyFile(uploadedFile.getFileName(),
		 * uploadedFile.getInputstream()); } catch (IOException e) {
		 * e.printStackTrace(); }
		 */

		// System.out.println("lllllllllllll"+uploadedFile.getFileName());
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		externalContext.getRealPath("/resources/images/carnets");
		System.out.println("lllllllllllll" + externalContext.getRealPath("/resources/images/carnets"));

		System.out.println(Paths.get("/resources/images/carnets").toAbsolutePath().toString());
		System.out.println(this.getClass().getClassLoader().getResource("").getPath());
		String extension = FilenameUtils.getExtension(uploadedFile.getFileName());
		Path folder = Paths.get("/opt/images/" + fileName + "." + extension);
		String filename = FilenameUtils.getBaseName(uploadedFile.getFileName());

		try (InputStream input = uploadedFile.getInputstream()) {
			// Path file = Files.createTempFile(folder, filename+"-", "." +
			// extension);
			// System.out.println("lllllllllllll"+file.toString());
			Files.copy(input, folder, StandardCopyOption.REPLACE_EXISTING);
			nombrePic = fileName + "." + extension;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return nombrePic;
	}

	public void copyFile(String fileName, InputStream in) {
		try {

			// write the inputStream to a FileOutputStream
			OutputStream out = new FileOutputStream(new File("" + fileName));

			int read = 0;
			byte[] bytes = new byte[1024];

			while ((read = in.read(bytes)) != -1) {
				out.write(bytes, 0, read);
			}

			in.close();
			out.flush();
			out.close();

			System.out.println("New file created!");
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * Se envia nombre de archivo, contenido y ruta a guardar sin ultimo slash
	 * (/); interiormente se limpia el nombre de caracteres especiales y si
	 * reemplazable es true, se genera un nombre unico con formato
	 * "nombre_archivo_dd_MM_yyyy_HH_mm_ss_mmm.ext"
	 * 
	 * @param nombre
	 * @param contenido
	 * @param ruta
	 * @param *
	 * @param reemplazable
	 *            = indica si el archivo tendrá un nombre unico para evitar
	 *            reemplazos o no.
	 * @return
	 */
	public static String guardarArchivo(String ruta, String nombre, byte[] contenido, Boolean reemplazable) {

		FileOutputStream fos = null; // esta clase nos sirve para escribir en el
										// archivo creado, xq maneja los byte
		File carpetaPrincipal = new File(ruta);
		// tenemos un objeto de tipo file, aqui no se crea el archivo
		carpetaPrincipal.mkdirs(); // de no existir, se crea la carpeta

		/* limpia nombre y genera nombre unico */
		if (null != reemplazable && !reemplazable) {
			nombre = limpiaNombre(nombre, reemplazable);
		}
		File miArchivo = new File(ruta + nombre);

		try {
			/* se crea el archivo */
			miArchivo.createNewFile();

			fos = new FileOutputStream(miArchivo);

			/* En memoria se escribe el archivo */
			fos.write(contenido);

			/* Escribir en el disco */
			fos.flush();

			return nombre;

		} catch (IOException e) {
			LOG.severe("Error al crear el archivo: " + e.getMessage());
		} finally {
			try {
				if (fos != null) {
					/* permite liberar el archivo */
					fos.close();
				}

			} catch (IOException e1) {
				e1.printStackTrace();
			}

		}
		return null;
	}

	/**
	 * limpia el nombre de caracteres especiales y agrega la fecha actual
	 * 
	 * @param nombreArchivo
	 * @param reemplazable,
	 *            cuando es false, significa que no va a remplazar el archio
	 *            existente por lo que le crea una firma en funcion del tiempo
	 *            al final del nombre del archivo
	 * @return
	 */
	public static String limpiaNombre(String nombreArchivo, Boolean reemplazable) {

		String ext = nombreArchivo.substring(nombreArchivo.lastIndexOf('.'));
		nombreArchivo = nombreArchivo.substring(0, nombreArchivo.lastIndexOf('.'));

		if (null != reemplazable && !reemplazable) {
			nombreArchivo = nombreArchivo.replaceAll("[^\\p{Alpha}\\p{Digit}]+", "_");
			if (StringUtils.endsWith(nombreArchivo, "_")) {
				nombreArchivo = nombreArchivo.replace(nombreArchivo.substring(nombreArchivo.length() - 1), "");
			}
			nombreArchivo = nombreArchivo + "_" + FechaUtil.fechaActualUnderscore() + ext;
		} else {
			nombreArchivo = nombreArchivo.replaceAll("[^\\p{Alpha}\\p{Digit}]+", "_") + ext;
		}

		return nombreArchivo;
	}

	/**
	 * 
	 * @param pathArchivo
	 *            url.base.carga + constante_contexto + ruta
	 *            <p>
	 *            <b>Ejm:</b> <br/>
	 *            srvArchivos//aplicacion_contexto/carpeta/directorio/
	 *            </p>
	 *            <ul>
	 *            <li><b>url.base.carga:</b> Propiedad del standAlone</li>
	 *            <li><b>constante_contexto:</b> Constante o propiedad del
	 *            proyecto</li>
	 *            <li><b>ruta:</b> Camino hasta el archivo</li>
	 *            </ul>
	 * @param nombreArchivo
	 *            nombre original del archivo
	 * @return
	 */
	public static DefaultStreamedContent obtenerArchivo(String pathArchivo, String nombreArchivo) {
		byte[] archivo = null;
		if (existeArchivoFisico(pathArchivo)) {
			try {
				archivo = cargarArchivo(pathArchivo);
				if (archivo != null && archivo.length > 0) {
					InputStream myInputStream = new ByteArrayInputStream(archivo);
					return new DefaultStreamedContent(myInputStream, obternerExtensionMineType(nombreArchivo),
							nombreArchivo);
				}

			} catch (IOException e) {
				LOG.severe("Error al obtener el archivo para descarga: " + nombreArchivo);
			}

		} else {
			JsfUtil.presentarMensajeError("No se encuentra el archivo :" + nombreArchivo);
		}
		return null;

	}

	public static String obternerExtensionMineType(String nombre) {
		String tipo = URLConnection.guessContentTypeFromName(nombre);
		if (tipo == null) {
			tipo = MimetypesFileTypeMap.getDefaultFileTypeMap().getContentType(nombre);
		}
		return tipo;

	}

	public static Boolean existeArchivoFisico(String pathArchivo) {
		Path path = Paths.get(pathArchivo);
		return path.toFile().exists();
	}

	public static byte[] cargarArchivo(String pathArchivo) throws IOException {
		Path path = Paths.get(pathArchivo);
		return Files.readAllBytes(path);
	}

	/**
	 * 
	 * @param path
	 * @return
	 */
	public static Boolean eliminarArchivo(String path) {
		Path pathArchivo = Paths.get(path);
		try {
			Files.delete(pathArchivo);
			JsfUtil.presentarMensajeInformacion("Archivo eliminado con éxito!!");

			return Boolean.TRUE;
		} catch (java.nio.file.NoSuchFileException x) {

			JsfUtil.presentarMensajeError("No se pudo encontrar el archivo.");
		} catch (java.nio.file.DirectoryNotEmptyException x) {
			JsfUtil.presentarMensajeError("Directorio vacío.");
		} catch (IOException x) {
			JsfUtil.presentarMensajeError("Errores de permiso.");
		}
		return Boolean.FALSE;
	}

}
