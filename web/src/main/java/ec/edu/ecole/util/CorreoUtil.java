package ec.edu.ecole.util;

import java.io.IOException;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.apache.commons.lang3.StringUtils;

//import ec.edu.ute.util.model.CorreoUtilModelo;

/**
 * 
 * Actualización de creacion: 4 mar. 2020
 *
 * @author 
 *
 */
public class CorreoUtil {

	private CorreoUtil() {

	}

	private static final Logger LOG = Logger.getLogger(CorreoUtil.class.getName());
	/*
	 * Fin Configuracion envio mail, utilizando properties en standalone
	 */

	private static final String EXPRESION_REGULAR_EMAIL = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

	public static boolean validarEmail(String email) {
		// Envio inicializacion de expresion regular.
		Pattern pattern = Pattern.compile(EXPRESION_REGULAR_EMAIL);
		// Realiza un match entre el email enviado y la expresion regular
		Matcher matcher = pattern.matcher(email);
		return matcher.matches();
	}

	/**
	 * <b> Metodo para envio de mail en formato html. </b>
	 *
	 * @param emailSesion
	 *            sesion de correo obtenido desde el servidor
	 * @param emailEnvia
	 *            email de quien envia el mensaje
	 * @param nombreEmailEnvia
	 *            nombre de quien envia el emensaje
	 * @param emailEnviarPrincipal
	 *            correo electronico a quien se va a enviar el email
	 * @param emailCopias
	 *            correos electronicos a quien se enviara copias
	 * @param asunto
	 *            el asunto del email
	 * @param mensaje
	 *            mensaje del correo
	 * @param parametros
	 *            mapa de parametros para ser reemplazados del mensaje
	 */
	public static void enviarEmail(Session emailSesion, String emailEnvia, String nombreEmailEnvia,
			String emailEnviarPrincipal, String[] emailCopias, String asunto, String mensaje,
			Map<String, String> parametros, String[] ubicacionArchivosAdjuntos) {
		try {
			Iterator<String> claves = parametros.keySet().iterator();
			while (claves.hasNext()) {
				String clave = claves.next();
				mensaje = mensaje.replace(clave, parametros.get(clave));
			}
			MimeMessage mimeMessage = new MimeMessage(emailSesion);

			armarDestinatarios(mimeMessage, emailEnviarPrincipal, emailCopias);

			MimeBodyPart messageBodyPart = new MimeBodyPart();
			messageBodyPart.setContent(mensaje, "text/html; charset=" + ConstantesUtil.CODIFICACION_UTF_8);

			// creates multi-part
			Multipart multipart = new MimeMultipart();
			multipart.addBodyPart(messageBodyPart);

			if (null != ubicacionArchivosAdjuntos && ubicacionArchivosAdjuntos.length > 0) {
				for (String filePath : ubicacionArchivosAdjuntos) {
					MimeBodyPart attachPart = new MimeBodyPart();
					try {
						attachPart.attachFile(filePath);
					} catch (IOException ex) {
						ex.printStackTrace();
					}
					multipart.addBodyPart(attachPart);
				}
			}

			// sets the multi-part as e-mail's content
			mimeMessage.setContent(multipart);

			mimeMessage.setSubject(asunto);
			mimeMessage.setFrom(new InternetAddress(emailEnvia, nombreEmailEnvia, ConstantesUtil.CODIFICACION_UTF_8));
			mimeMessage.setSentDate(new Date());
			Transport.send(mimeMessage);

			LOG.log(Level.INFO, "Correo enviado al mail:{0} ", new Object[] { emailEnviarPrincipal });

		} catch (Exception e) {
			LOG.log(Level.SEVERE, "Error al enviar el mail a: " + emailEnviarPrincipal + ", asunto: " + asunto, e);
		}
	}

	/*
	 * Envía un correo con archivos adjuntos, a uno o varios destinatarios.
	 * 
	 * @param emailEnviarPrincipal se puede enviar a varios correos si se envía
	 * separado con ";"
	 */
	public static void enviarEmail(String emailEnvia, String emailRemitente, String emailEnviarPrincipal,
			String[] emailCopias, String asunto, String mensaje, Map<String, String> parametros,
			String[] ubicacionArchivosAdjuntos) {

		Session session = Session.getInstance(ConstantesUtil.PROPIEDADES_MAIL, new javax.mail.Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(ConstantesUtil.USUARIO_MAIL, ConstantesUtil.PASSWORD_MAIL);
			}
		});

		try {
			Iterator<String> claves = parametros.keySet().iterator();
			while (claves.hasNext()) {
				String clave = claves.next();
				mensaje = mensaje.replace(clave, parametros.get(clave));
			}
			MimeMessage mimeMessage = new MimeMessage(session);

			armarDestinatarios(mimeMessage, emailEnviarPrincipal, emailCopias);

			MimeBodyPart messageBodyPart = new MimeBodyPart();
			messageBodyPart.setContent(mensaje, "text/html; charset=" + ConstantesUtil.CODIFICACION_UTF_8);

			// creates multi-part
			Multipart multipart = new MimeMultipart();
			multipart.addBodyPart(messageBodyPart);

			if (ubicacionArchivosAdjuntos != null) {
				if (ubicacionArchivosAdjuntos != null && ubicacionArchivosAdjuntos.length > 0) {
					for (String filePath : ubicacionArchivosAdjuntos) {
						MimeBodyPart attachPart = new MimeBodyPart();
						try {
							attachPart.attachFile(filePath);
						} catch (IOException ex) {
							ex.printStackTrace();
						}
						multipart.addBodyPart(attachPart);
					}
				}
			}

			// sets the multi-part as e-mail's content
			mimeMessage.setContent(multipart);

			mimeMessage.setSubject(asunto);
			mimeMessage.setFrom(new InternetAddress(emailEnvia));
			mimeMessage.setSentDate(new Date());

			Transport.send(mimeMessage);
			LOG.log(Level.INFO, "Correo enviado al mail:{0} ", new Object[] { emailEnviarPrincipal });
		} catch (Exception e) {
			LOG.log(Level.SEVERE, "Error al enviar el mail a:{0} , asunto:{1}, error{2}",
					new Object[] { emailEnviarPrincipal, asunto, e });
		}
	}

	/**
	 * 
	 * @param mimeMessage
	 * @param principal
	 * @param recipentType
	 */
	public static void agregarDestinatarios(MimeMessage mimeMessage, String principal, RecipientType recipentType) {

		if (StringUtils.isNotBlank(principal)) {
			String[] correosPrincipal = principal.split(";");
			/* set */

			for (String correo : correosPrincipal) {
				if (StringUtils.isNotBlank(correo) && validarEmail(correo)) {
					try {
						mimeMessage.addRecipient(recipentType, new InternetAddress(correo));
					} catch (AddressException e) {
						e.printStackTrace();
					} catch (MessagingException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}

	/**
	 * 
	 * @param mimeMessage
	 * @param emailEnviarPrincipal
	 * @param emailCopias
	 * @return
	 * @throws Exception
	 */
	public static void armarDestinatarios(MimeMessage mimeMessage, String emailEnviarPrincipal, String[] emailCopias) {
		if (ConstantesUtil.SISTEMA_PRUEBAS.equals("true")) {

			/* PRINCIPAL */
			agregarDestinatarios(mimeMessage, ConstantesUtil.MAIL_TECNICOS_UTE, RecipientType.TO);

			/* EN TEST SOLO SE ENVIA EL PRINCIPAL */

		} else {
			/* PRINCIPAL */
			agregarDestinatarios(mimeMessage, emailEnviarPrincipal, RecipientType.TO);

			/* COPIAS */
			String emailsCopias = String.join(";", emailCopias);
			agregarDestinatarios(mimeMessage, emailsCopias, RecipientType.CC);

		}

	}

	/*
	 * Envía un correo a una dirección sin archivos adjuntos
	 */

	public static void enviarEmailConReporteAdjunto(CorreoUtilModelo emailConfigurado, String[] emailCopias,
			Map<String, String> parametros, DataSource adjunto, String nombreAdjunto) {

		String emailEnvia = emailConfigurado.getFrom();
		String emailEnviarPrincipal = emailConfigurado.getTo();
		String asunto = emailConfigurado.getSubject();
		String mensaje = emailConfigurado.getBody();

		Session session = Session.getInstance(ConstantesUtil.PROPIEDADES_MAIL, new javax.mail.Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(ConstantesUtil.USUARIO_MAIL, ConstantesUtil.PASSWORD_MAIL);
			}
		});

		try {
			Iterator<String> claves = parametros.keySet().iterator();
			while (claves.hasNext()) {
				String clave = claves.next();
				mensaje = mensaje.replace(clave, parametros.get(clave));
			}

			MimeMessage mimeMessage = new MimeMessage(session);

			armarDestinatarios(mimeMessage, emailEnviarPrincipal, emailCopias);

			MimeBodyPart messageBodyPart = new MimeBodyPart();
			messageBodyPart.setContent(mensaje, "text/html; charset=" + ConstantesUtil.CODIFICACION_UTF_8);

			/* creates multi-part */
			Multipart multipart = new MimeMultipart();
			multipart.addBodyPart(messageBodyPart);

			if (adjunto != null) {

				MimeBodyPart attachPart = new MimeBodyPart();
				attachPart.setDataHandler(new DataHandler(adjunto));
				attachPart.setFileName(nombreAdjunto);
				multipart.addBodyPart(attachPart);

			}

			/* sets the multi-part as e-mail's content */
			mimeMessage.setContent(multipart);

			mimeMessage.setSubject(asunto);
			mimeMessage.setFrom(new InternetAddress(emailEnvia));
			mimeMessage.setSentDate(new Date());

			Transport.send(mimeMessage);
			LOG.log(Level.INFO, "Correo enviado al mail:{0} ", new Object[] { emailEnviarPrincipal });
		} catch (Exception e) {
			LOG.log(Level.SEVERE, "Error al enviar el mail a:{0} , asunto:{1}, error{2}",
					new Object[] { emailEnviarPrincipal, asunto, e });
		}
	}

}
