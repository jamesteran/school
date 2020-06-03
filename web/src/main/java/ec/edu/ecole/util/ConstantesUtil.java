package ec.edu.ecole.util;

import java.text.SimpleDateFormat;
import java.util.Properties;
import java.util.concurrent.ThreadLocalRandom;

public class ConstantesUtil {

	private ConstantesUtil() {
		super();
	}
	
	public static final String REPORTE_DS = "DS_MSSQL_REPORTE";

	public static final String REPORTE_DS_DW = "REPORTE_DS_DW";

	public static final String ENCUESTAS_DS = "encuestaDS";

	/* IDENTIFICADOR PARA SEDES */
	public static final Long ID_QUITO = 1L;
	public static final Long ID_ECUADOR = 1L;
	public static final Long ID_SANTO_DOMINGO = 2L;
	public static final Long ID_SALINAS = 3L;
	public static final Long ID_TIPO_ESCUELA_CARRERA = 1L;
	public static final Long ID_FACULTAD_CIENCIAS_SALUD_UIO = 14L;
	public static final Long ID_FACULTAD_CIENCIAS_SALUD_STO = 37L;

	public static final double LATI_QUITO = -0.225219;
	public static final double LONG_QUITO = -78.5248;

	public static final String SEPARADOR_CARPETA_ARCHIVO = System.getProperty("file.separator");
	public static final String DS_ENCUESTAS = "encuestaDS";

	public static final String URL_SRI_WS_RECEPCION = System.getProperty("url.sri.ws.recepcion");
	public static final String URL_BASE_XML_SAP = System.getProperty("url.base.xml.sap");
	public static final String CLAVE_FIRMA_UTE = System.getProperty("clave.firma.ute");
	public static final String CERTIFICADO_FIRMA_UTE = System.getProperty("certificado.firma.ute");
	public static final String MAIL_TECNICOS_UTE = System.getProperty("mail.tecnicos.ute");
	public static final String MAIL_DTIC = System.getProperty("mail.ute.dtic");
	public static final String MAIL_UTE_UIO_BECAS = System.getProperty("mail.ute.uio.becas");
	public static final String MAIL_UTE_STO_BECAS = System.getProperty("mail.ute.sto.becas");
	public static final String URL_BASE_XML_FIRMADO = System.getProperty("url.base.xml.firmado");
	public static final String SISTEMA_PRUEBAS = System.getProperty("mostrar.mensaje.sistema.pruebas");
	public static final String URL_SRI_WS_AUTORIZACION = System.getProperty("url.sri.ws.autorizacion");
	public static final String URL_FISICA_POSGRADO = System.getProperty("url.base.formularios");

	public static Properties PROPIEDADES_MAIL = new Properties();
	private static final String HOST_MAIL = System.getProperty("mail.smtp.host");
	private static final String PORT_MAIL = System.getProperty("mail.smtp.port");
	private static final String SENDER_MAIL = System.getProperty("mail.smtp.mail.sender");

	public static final String USUARIO_MAIL = System.getProperty("mail.smtp.user");
	public static final String PASSWORD_MAIL = System.getProperty("mail.smtp.pass");

	public static final String EMAIL_ENVIADO_DE = "noreply@ute.edu.ec";
	public static final String EMAIL_ENVIADO_DE_NOMBRE = "Universidad - UTE";
	public static final String EMAIL_ASUNTO_ERROR_TECNICO = "ERROR TECNICO";

	public static final String CODIFICACION_UTF_8 = "UTF-8";
	public static final String CODIFICACION_UTF8 = "UTF8";

	public static final byte[] CODIFICACION_UTF8_BOM = { (byte) 0xEF, (byte) 0xBB, (byte) 0xBF };

	public static final String EXTENSION_XML = ".xml";
	public static final String EXTENSION_PDF = ".pdf";
	public static final String EXTENSION_ZIP = ".zip";
	public static final String EXTENSION_XLSX = ".xlsx";

	public static final String SEPARADOR_PUNTO_COMA = ";";
	public static final String SALTO_LINEA = "\r\n";
	public static final String SEPARADOR_NUEVA_LINEA = "\n";

	public static final SimpleDateFormat DATE_FORMAT_YYYY_MM_DD = new SimpleDateFormat("yyyy/MM/dd");
	public static final SimpleDateFormat DATE_FORMAT_DD_MM_YYYY = new SimpleDateFormat("dd/MM/yyyy");
	public static final SimpleDateFormat DATE_FORMAT_DD_MM_YYYY_HH_MM_SS = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	public static final SimpleDateFormat DATE_FORMAT_DD_MM_YYYY_HH_MM_SS_SSS = new SimpleDateFormat(
			"dd/MM/yyyy HH:mm:ss.SSS");

	public static final String PATH_FOLDER_FACTURA = "reportes/factura/";
	public static final String PATH_FOLDER_NOTA_CREDITO = "reportes/notaCredito/";
	public static final String PATH_FOLDER_NOTA_DEBITO = "reportes/notaDebito/";
	public static final String PATH_FOLDER_RETENCION = "reportes/retencion/";

	public static final String TRUE = "true";
	public static final String FALSE = "false";

	public static final String OPCION_SI_TEXTUAL = "SI";
	public static final String OPCION_NO_TEXTUAL = "NO";

	public static final String JNDI_MAIL_UTE = "java:jboss/mail/correoUte";

	public static final String NOMBRE_ARCHIVO_P12 = "archivoUte.p12";

	// Definicion del tipo de algoritmo de cifrado a utilizar (AES, DES, RSA)
	public static final String CIFRADO_ALGORITMO = "AES";
	// Definicion del modo de cifrado a utilizar
	public static final String CIFRADO_MODO = "AES/CBC/PKCS5Padding";
	// Llave de cifrado debe tener 16 caracteres
	public static final String CIFRADO_CLAVE = "92AME31A79FEEB2A";
	// Vector de inicializacion de cifrado debe tener 16 caracteres
	public static final String CIFRADO_VECTOR_INICIALIZACION = "9876543210ZYXWVU";
	//
	public static final String CARACTERES_CONTRASENIA_GENERADA_SOLO_NUMEROS = "0123456789";

	// Carpeta Error
	public static final String NOMBRE_CARPETA_ERROR = "ERROR";
	public static final String VERSION_XML = "1.0.0";

	public static final String ID_FICTICIO_CONSUMIDOR_FINAL = "9999999999999";
	public static final String RAZON_SOCIAL_CONSUMIDOR_FINAL = "CONSUMIDOR FINAL";
	public static final String AUTORIDAD_CERT_NO_DISPONIBLE = "61";

	public static final Integer LONGITUD_CLAVE_CONTINGENCIA = Integer.valueOf(37);

	public static final String MENSAJE_ERROR_GENERAL_USUARIO = "Error, comun\u00EDquese con el Administrador del sistema.";

	public static final int NUMERO_INTENTOS_CONEXION_WS = 3;
	// Utilizado para el error 70
	public static final int NUMERO_INTENTOS_AUTORIZACION = 3;
	public static final int TIEMPO_ESPERA_CONEXION_WS = 10000;
	public static final int TIEMPO_EJECUCION_BATCH_RECONEXION = 5;
	public static final int TIEMPO_ESPERA_REPROCESO = 90;

	public static final String EMAIL_ASUNTO_COMPROBANTE_ELECTRONICO = "Comprobante Electr\u00F3nico";

	public static final String SEPARADOR_CSV = ";";
	public static final String CODIGO_IMPUESTO_IVA = "2";

	public static final String CONSULTA_TODOS = "TODOS";
	public static final String CONSULTA_TODAS = "TODAS";

	public static final String CODIGOS_SRI_TECNICOS = "33;35;36;39;40;42;48;49;50;58;";
	public static final String CODIGOS_SRI_NEGOCIO = "28;37;42;56;57;63;";
	public static final String CODIGOS_SRI_REINTENTO = "50;70;";
	public static final String CODIGOS_SRI_INFORMATIVOS = "67;45;43;";

	public static final String COMPROBANTE_NO_ENCONTRADO = "Comprobante no encontrado.";
	public static final String TIPO_USUARIO_INTERNO = "INTERNO";
	public static final String TIPO_USUARIO_INSCRITO = "INSCRITO";
	public static final char[] ABECEDARIO_Y_NUMEROS = { 'A', 'B', 'C', 'D', 'E', 'F', 'F', 'H', 'I', 'J', 'K', 'L', 'M',
			'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '0', '1', '2', '3', '4', '5', '6', '7',
			'8', '9' };

	/**
	 * <b> Enumeracion que maneja las descripciones del tipo de comprobante.
	 * </b>
	 * 
	 */
	public enum TipoComprobanteEnum {
				COMPR_FACTU("FACTURA", "factura"),
				COMPR_CREDI("NOTA DE CREDITO", "notaCredito"),
				COMPR_RETEN("COMPROBANTE DE RETENCION", "comprobanteRetencion"),
				COMPR_DEBIT("NOTA DE DEBITO", "notaDebito");

		private final String tipoComprobante;
		private final String tipoComprobantexml;

		/**
		 * @param tipoComprobante
		 *            codigo de tipo de comprobante del archivo
		 */
		TipoComprobanteEnum(String tipoComprobante, String tipoComprobantexml) {
			this.tipoComprobante = tipoComprobante;
			this.tipoComprobantexml = tipoComprobantexml;
		}

		public String getTipoComprobante() {
			return tipoComprobante;
		}

		/**
		 * @return the tipoComprobantexml
		 */
		public String getTipoComprobantexml() {
			return tipoComprobantexml;
		}

	}

	/**
	 * <b> Enumeraci�n tipo de identificaciones que tiene el SRI. </b>
	 * 
	 */
	public enum TipoIdentificacionEnum {
		RUC("04", "EMPRESA"), CEDULA("05", "CIUDADANO"), PASAPORTE("06", "EXTRANJERO"), EXTERIOR("08", "EXTRANJERO");

		private final String codigoSRI;
		private final String descripcionUte;

		TipoIdentificacionEnum(String codigoSRI, String descripcionUte) {
			this.codigoSRI = codigoSRI;
			this.descripcionUte = descripcionUte;
		}

		public String getCodigoSRI() {
			return codigoSRI;
		}

		public String getDescripcionUte() {
			return descripcionUte;
		}
	}

	/**
	 * <b> Enumeracion Estado interno de proceso de autorizacion del comprobante
	 * con el SRI. </b>
	 * 
	 */
	public enum EstadoProcesoAutorizacionEnum {
		INICIAL(0), PROCESADO(1), ERROR(2), RECIBIDO(3);

		private final Integer estadoProcesamiento;

		EstadoProcesoAutorizacionEnum(Integer estadoProcesamiento) {
			this.estadoProcesamiento = estadoProcesamiento;
		}

		public Integer getEstadoProcesamiento() {
			return estadoProcesamiento;
		}

	}

	/**
	 * <b> Enumeración de opciones permitidas de sedes de la universidad. </b>
	 * 
	 */
	public enum SedesEnum {

		QUITO(ID_QUITO), STO(ID_SANTO_DOMINGO);

		private final Integer sedeOpcion;

		SedesEnum(Long sede) {
			this.sedeOpcion = sede.intValue();
		}

		public Integer getSede() {
			return sedeOpcion;
		}

	}

	/**
	 * <b> Enumeracion Codigos y descripcion corta de errores y mensajes SAP.
	 * </b>
	 * 
	 */
	public enum sapCodigosEnum {
		ERROR_INTERNO_101(101, "ERROR INTERNO"),
		NO_DESCARGADO_102(102, "NO DESCARGADO"),
		ERROR_INTERNO_121(121, "ERROR INTERNO"),
		ERROR_INTERNO_141(141, "ERROR INTERNO"),
		ESTRUCTURA_INVALIDA_201(201, "ESTRUCTURA INVÁLIDA"),
		VALOR_CAMPO_INVALIDO_202(202, "VALOR CAMPO INVÁLIDO"),
		VALOR_CAMPO_INVALIDO_203(203, "VALOR CAMPO INVÁLIDO"),
		VALOR_CAMPO_INVALIDO_204(204, "VALOR CAMPO INVÁLIDO"),
		VALOR_CAMPO_INVALIDO_205(205, "VALOR CAMPO INVÁLIDO"),
		VALOR_CAMPO_INVALIDO_206(206, "VALOR CAMPO INVÁLIDO"),
		ESTRUCTURA_INVALIDA_301(301, "ESTRUCTURA INVÁLIDA"),
		PROVEEDOR_NO_RESPONDE_302(302, "PROVEEDOR NO RESPONDE"),
		ERROR_PROVEEDOR_303(303, "ERROR PROVEEDOR"),
		RECHAZADO_401(401, "RECHAZADO"),
		RECHAZADO_402(402, "RECHAZADO"),
		PENDIENTE_403(403, "PENDIENTE"),
		PENDIENTE_404(404, "PENDIENTE"),
		NEGADO_405(405, "NEGADO"),
		AUTORIZADO_406(406, "AUTORIZADO"),
		DESCARGADO_407(407, "DESCARGADO"),
		DESCARGADO_408(408, "DESCARGADO");

		private final int intCodigoSap;
		private final String strCodigoSap;

		sapCodigosEnum(int intCodigoSap, String strCodigoSap) {
			this.intCodigoSap = intCodigoSap;
			this.strCodigoSap = strCodigoSap;
		}

		/**
		 * @return the intCodigoSap
		 */
		public int getIntCodigoSap() {
			return intCodigoSap;
		}

		/**
		 * @return the strCodigoSap
		 */
		public String getStrCodigoSap() {
			return strCodigoSap;
		}

	}

	/**
	 * 
	 * @param soloLetras,
	 *            null -> numeros y letras, true-> solo letras, false -> solo
	 *            números
	 * @param longitud
	 *            numero de caracteres solicitado
	 * @return
	 */
	public static String obtenerCadenaRamdom(Boolean soloLetras, Integer longitud) {
		char[] cadena = new char[longitud];

		for (int i = 0; i < longitud; i++) {

			if (null == soloLetras) {
				cadena[i] = ABECEDARIO_Y_NUMEROS[ThreadLocalRandom.current().nextInt(0, 35)];
			} else

			if (null != soloLetras && soloLetras) {
				cadena[i] = ABECEDARIO_Y_NUMEROS[ThreadLocalRandom.current().nextInt(0, 25)];

			} else {
				cadena[i] = ABECEDARIO_Y_NUMEROS[ThreadLocalRandom.current().nextInt(25, 35)];

			}
		}

		return new String(cadena);
	}

	/*
	 * 
	 */
	public enum sriErrorCodigosEnum {
		ARGUMENTOS_NULOS_49(49, "Argumentos que envían al WS nulos"),
		COMPROBANTE_NO_EXISTE(47, "Tipo de comprobante no existe");

		private final int intSriErrorCodigos;
		private final String strSriErrorCodigos;

		/**
		 * 
		 */
		private sriErrorCodigosEnum(int intSriErrorCodigos, String strSriErrorCodigos) {
			this.intSriErrorCodigos = intSriErrorCodigos;
			this.strSriErrorCodigos = strSriErrorCodigos;
		}

		/**
		 * @return the intSriErrorCodigos
		 */
		public int getIntSriErrorCodigos() {
			return intSriErrorCodigos;
		}

		/**
		 * @return the strSriErrorCodigos
		 */
		public String getStrSriErrorCodigos() {
			return strSriErrorCodigos;
		}

	}

	/**
	 * <b> Enumeracion Estado SRI de proceso de autorizacion del comprobante.
	 * </b>
	 * 
	 */
	public enum sriEstadoComprobanteEnum {
		EN_PROCESAMIENTO(1, "EN PROCESAMIENTO"), AUTORIZADO(2, "AUTORIZADO"), NO_AUTORIZADO(3, "NO AUTORIZADO");

		private final int intEstadoComprobante;
		private final String strEstadoComprobante;

		sriEstadoComprobanteEnum(int intEstadoComprobante, String strEstadoComprobante) {
			this.intEstadoComprobante = intEstadoComprobante;
			this.strEstadoComprobante = strEstadoComprobante;
		}

		/**
		 * @return the intEstadoComprobante
		 */
		public int getIntEstadoComprobante() {
			return intEstadoComprobante;
		}

		/**
		 * @return the strEstadoComprobante
		 */
		public String getStrEstadoComprobante() {
			return strEstadoComprobante;
		}

	}

	public enum estadoTransaccionComprobanteEnum {
		TRANSACCION_RECIBIDO("RECIBIDA"),
		TRANSACCION_ERROR_CONEXION("ERROR CONEXION"),
		TRANSACCION_DEVUELTO("DEVUELTA");

		private final String transaccionEstadoComprobante;

		estadoTransaccionComprobanteEnum(String transaccionEstadoComprobante) {
			this.transaccionEstadoComprobante = transaccionEstadoComprobante;
		}

		/**
		 * @return the strEstadoComprobante
		 */
		public String getTransaccionEstadoComprobante() {
			return transaccionEstadoComprobante;
		}

	}

	public enum sapCategoriaMensajesEnum {
		ERROR("ERROR"), MENSAJE("MENSAJE");

		private final String categoriaMensaje;

		sapCategoriaMensajesEnum(String categoriaMensaje) {
			this.categoriaMensaje = categoriaMensaje;
		}

		/**
		 * @return the strEstadoComprobante
		 */
		public String getCategoriaMensaje() {
			return categoriaMensaje;
		}

	}

	static {
		PROPIEDADES_MAIL.put("mail.smtp.host", HOST_MAIL);
		PROPIEDADES_MAIL.put("mail.smtp.port", PORT_MAIL);
		PROPIEDADES_MAIL.put("mail.smtp.mail.sender", SENDER_MAIL);
		PROPIEDADES_MAIL.put("mail.smtp.starttls.enable", "true");
		PROPIEDADES_MAIL.put("mail.smtp.auth", "true");

	}
}
