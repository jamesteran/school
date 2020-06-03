package ec.edu.ecole.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.MissingResourceException;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.primefaces.PrimeFaces;

import ec.edu.ecole.enums.AccionesUtilEnum;
import ec.edu.ecole.enums.PropiedadesWebUtilEnum;
import ec.edu.ecole.dto.UsuarioPrincipalDTO;

public class JsfUtil {

	private JsfUtil() {
	}

	private static final Logger LOG = Logger.getLogger(JsfUtil.class.getName());
	public static final String TMPL_ERRO = "mensaje.error";
	public static final String TMPL_AVIS = "mensaje.aviso";
	public static final String TMPL_INFO = "mensaje.info";
	public static final String TMPL_ALER = "mensaje.alerta";
	public static final String TMPL_FATAL = "mensaje.fatal";
	public static final String TMPL_SIN_CAMBIOS = "mensaje.sin.cambios";

	/**
	 * 
	 * @param entities
	 * @param selectOne
	 * @return
	 */
	public static SelectItem[] getSelectItems(List<?> entities, boolean selectOne) {
		int size = selectOne ? entities.size() + 1 : entities.size();
		SelectItem[] items = new SelectItem[size];
		int i = 0;
		if (selectOne) {
			items[0] = new SelectItem("", "---");
			i++;
		}
		for (Object x : entities) {
			items[i++] = new SelectItem(x, x.toString());
		}
		return items;
	}

	/**
	 * Permite obtener una lista de numeros por un rang
	 * 
	 * @param desde
	 * @param hasta
	 * @return
	 */
	public static List<SelectItem> getNumerosRango(Integer desde, Integer hasta) {
		List<SelectItem> items = new ArrayList<>();

		for (Integer i = desde; i <= hasta; i++) {
			items.add(new SelectItem(i, i.toString()));
		}

		return items;
	}

	private static void presentarMensaje(FacesMessage facesMessage) {
		FacesContext.getCurrentInstance().addMessage(null, facesMessage);
	}

	public static void presentarMensajes(List<FacesMessage> facesMessages) {
		facesMessages.forEach(JsfUtil::presentarMensaje);
	}

	public static void presentarMensajeError(String mensaje) {
		JsfUtil.presentarMensaje(crearMensajeError(mensaje));
	}

	public static void presentarMensajeInformacion(String mensaje) {
		JsfUtil.presentarMensaje(crearMensajeInformacion(mensaje));
	}

	public static void presentarMensajeAdvertencia(String mensaje) {
		JsfUtil.presentarMensaje(crearMensajeAdvertencia(mensaje));
	}

	public static FacesMessage crearMensajeError(String mensaje) {
		return new FacesMessage(FacesMessage.SEVERITY_ERROR,
				JsfUtil.getValorPropepiedad(PropiedadesWebUtilEnum.TEMPLATE, JsfUtil.TMPL_ERRO), mensaje);
	}

	public static FacesMessage crearMensajeInformacion(String mensaje) {
		return new FacesMessage(FacesMessage.SEVERITY_INFO,
				JsfUtil.getValorPropepiedad(PropiedadesWebUtilEnum.TEMPLATE, JsfUtil.TMPL_INFO), mensaje);
	}

	public static FacesMessage crearMensajeAdvertencia(String mensaje) {
		return new FacesMessage(FacesMessage.SEVERITY_WARN,
				JsfUtil.getValorPropepiedad(PropiedadesWebUtilEnum.TEMPLATE, JsfUtil.TMPL_AVIS), mensaje);
	}

	/**
	 * 
	 * @param severity
	 * @return
	 */
	private static String fabricaTitulosSeverity(Severity severity) {
		Integer sSeverity = severity.getOrdinal();
		String titulo = null;

		switch (sSeverity) {
		case 0:
			titulo = getValorPropepiedad(PropiedadesWebUtilEnum.TEMPLATE, JsfUtil.TMPL_INFO);
			break;
		case 1:
			titulo = getValorPropepiedad(PropiedadesWebUtilEnum.TEMPLATE, JsfUtil.TMPL_ALER);
			break;
		case 2:
			titulo = getValorPropepiedad(PropiedadesWebUtilEnum.TEMPLATE, JsfUtil.TMPL_ERRO);
			break;
		case 3:
			titulo = getValorPropepiedad(PropiedadesWebUtilEnum.TEMPLATE, JsfUtil.TMPL_FATAL);
			break;
		default:
			titulo = null;
			break;
		}
		return titulo;
	}

	/**
	 * 
	 * @param bean
	 * @param key
	 * @return
	 */
	public static String getValorPropepiedad(PropiedadesWebUtilEnum bean, String key) {
		try {
			FacesContext context = FacesContext.getCurrentInstance();
			return context.getApplication().getResourceBundle(context, bean.getValue()).getString(key);
		} catch (MissingResourceException e) {
			LOG.info("Etiqueta no encotrada " + key + "En el contexto " + bean.getValue());
			return '!' + key + '!';
		}
	}

	/**
	 * 
	 * @param key
	 * @return
	 */
	public static String obtenerParametroRequest(String key) {
		return FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get(key);
	}

	/**
	 * Obtiene los parametros del XML
	 * 
	 * @param parametro
	 * @return
	 */
	public static String obtenerParametroDeContexto(String parametro) {
		return FacesContext.getCurrentInstance().getExternalContext().getInitParameter(parametro);
	}

	/**
	 * 
	 * @return
	 */
	public static HttpServletRequest obtenerRequest() {
		return (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
	}

	/**
	 * Método que permite presentar u ocultar los dialogos
	 * 
	 * @param dialog
	 *            widget
	 * @param state
	 */
	public static void mostrarOcultarDialogo(String dialog, Boolean state) {
		StringBuilder script = new StringBuilder();
		script.append("PF('").append(dialog).append("').");
		script.append(state ? "show()" : "hide()");

		JsfUtil.ejecutarJavaScriptDeVista(script.toString());

	}

	public static void ejecutarJavaScriptDeVista(String script) {
		PrimeFaces.current().executeScript(script);

	}

	/**
	 * 
	 * @param accion
	 */
	public static void presentarMensaje(AccionesUtilEnum accion) {
		FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO,
				fabricaTitulosSeverity(FacesMessage.SEVERITY_INFO), obtenerCRUDMensaje(accion));

		FacesContext.getCurrentInstance().addMessage(null, facesMessage);
	}

	/**
	 * 
	 * @param accion
	 * @return
	 */
	private static String obtenerCRUDMensaje(AccionesUtilEnum accion) {
		String mensaje = "";

		if (AccionesUtilEnum.C.equals(accion)) {
			mensaje = getValorPropepiedad(PropiedadesWebUtilEnum.TEMPLATE, "crud.event.create");
		}
		if (AccionesUtilEnum.R.equals(accion)) {
			mensaje = getValorPropepiedad(PropiedadesWebUtilEnum.TEMPLATE, "crud.event.read");
		}
		if (AccionesUtilEnum.U.equals(accion)) {
			mensaje = getValorPropepiedad(PropiedadesWebUtilEnum.TEMPLATE, "crud.event.update");
		}
		if (AccionesUtilEnum.D.equals(accion)) {
			mensaje = getValorPropepiedad(PropiedadesWebUtilEnum.TEMPLATE, "crud.event.delete");
		}
		if (AccionesUtilEnum.N.equals(accion)) {
			mensaje = getValorPropepiedad(PropiedadesWebUtilEnum.TEMPLATE, "crud.event.sin_cambios");
		}
		return mensaje;
	}

	/**
	 * Busca en un mapa si tiene las llaves que existen en una cadena que están
	 * separados por una cadena
	 * 
	 * @param llaves
	 *            conjunto de llaves separadas por un caracter
	 * @param separador
	 *            caracter que separa las cadenas , por defecto "," (coma)
	 * @param arreglo
	 * @return
	 */
	public static Boolean mapaContieneLlaves(String llaves, String separador, Set<String> arreglo) {

		String sep = separador;
		if (StringUtils.isEmpty(sep)) {
			sep = ",";
		}
		String[] lstRoles = llaves.split(sep);

		Boolean ban = Boolean.FALSE;
		for (int i = 0; i <= lstRoles.length - 1; i++) {
			ban = ban || arreglo.contains(lstRoles[i]);
		}

		return ban;
	}

	/**
	 * 
	 * 
	 * @param llaves
	 *            , string conjunto de llaves seprardas por un caractesr
	 * @param separador
	 *            caracter que separa las cadenas , por defecto "," (coma)
	 * @param arreglo
	 * @return
	 */
	public static Map<String, Object> mapaDeLlaves(String llaves, String separador, Map<String, Boolean> arreglo) {
		String sep = separador;
		if (StringUtils.isEmpty(sep)) {
			sep = ",";
		}

		String[] lstLlaves = llaves.split(sep);

		Map<String, Object> nuevoMapa = new HashMap<>();

		for (int i = 0; i <= lstLlaves.length - 1; i++) {
			if (arreglo.containsKey(lstLlaves[i])) {
				nuevoMapa.put(lstLlaves[i], arreglo.get(lstLlaves[i]));
			}
		}
		return nuevoMapa;
	}

	public static String obtenerUsuarioPrincipal() {
		HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext()
				.getRequest();
		return request.getUserPrincipal().getName();
	}

	public static UsuarioPrincipalDTO obtenerPrincipal() {
		HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext()
				.getRequest();
		return obtenerUsuarioPrincipalDTO(request.getUserPrincipal());
	}

	/**
	 * 
	 * @param principal
	 * @return
	 */

	public static UsuarioPrincipalDTO obtenerUsuarioPrincipalDTO(Object principal) {
		UsuarioPrincipalDTO usuario = new UsuarioPrincipalDTO();

		try {
			/* Se utiliza reflect para conseguir los datos del principal, */
			/* problemas al realizar el cast */
			if (principal != null) {

				usuario.setTipoUsuario((String) principal.getClass().getMethod("getTipoUsuario").invoke(principal));
				usuario.setIdentificacion(
						(String) principal.getClass().getMethod("getIdentificacion").invoke(principal));
				usuario.setIdUsuario((String) principal.getClass().getMethod("getIdUsuario").invoke(principal));
				usuario.setUsuario((String) principal.getClass().getMethod("getUsuario").invoke(principal));
				usuario.setIdSede((Integer) principal.getClass().getMethod("getIdSede").invoke(principal));
				usuario.setNombreUsuario((String) principal.getClass().getMethod("getNombreUsuario").invoke(principal));
				/**/
				usuario.setIpIngreso((String) principal.getClass().getMethod("getIpIngreso").invoke(principal));
			}
		} catch (Exception e) {
			LOG.log(Level.SEVERE, "Error al obtener el usuario principal desde SeguridadFilter ");
		}
		return usuario;
	}

	/**
	 * 
	 * @return
	 */
	public static String obtenerIpCliente() {
		HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext()
				.getRequest();

		String ipCliente = request.getHeader("X-FORWARDED-FOR");
		if (ipCliente == null) {
			ipCliente = request.getRemoteAddr();
		}
		return ipCliente;
	}

}
