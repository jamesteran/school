/**
* Copyright (C) 2017 - Todos los derechos reservados.
* Universidad Tecnologica Equinoccial (UTE)
*/
package ec.edu.ecole.dto;

import java.io.Serializable;
import java.security.Principal;

/**
 * 
 *
 * @author 
 *
 */

public class UsuarioPrincipalDTO implements Principal, Serializable {
	private static final long serialVersionUID = -6878560258569389211L;
	private String usuario;
	private String idUsuario;
	private String identificacion;
	private String nombreUsuario;
	private String mail;
	private String ipIngreso;
	private Integer idSede;
	private String tipoUsuario;

	public UsuarioPrincipalDTO(String usuario, String idUsuario, String identificacion, String nombreUsuario,
			String mail) {
		setUsuario(usuario.trim());
		setIdUsuario(idUsuario.trim());
		setIdentificacion(identificacion.trim());
		setNombreUsuario(nombreUsuario.trim());
		setMail(mail.trim());
	}

	public UsuarioPrincipalDTO(String usuario, String ipIngreso) {
		setUsuario(usuario.trim());
		setIpIngreso(ipIngreso.trim());
	}

	public UsuarioPrincipalDTO() {
		setUsuario(null);
		setIdUsuario(null);
		setIdentificacion(null);
		setNombreUsuario(null);
		setMail(null);
		setIpIngreso(null);
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getIdUsuario() {
		return this.idUsuario;
	}

	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getIdentificacion() {
		return this.identificacion;
	}

	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}

	public String getNombreUsuario() {
		return this.nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getMail() {
		return this.mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getIpIngreso() {
		return ipIngreso;
	}

	public void setIpIngreso(String ipIngreso) {
		this.ipIngreso = ipIngreso;
	}

	/**
	 * @return the usuario
	 */
	public String getUsuario() {
		return usuario;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.security.Principal#getName()
	 */
	@Override
	public String getName() {
		return this.usuario;
	}

	/**
	 * @return the idSede
	 */
	public Integer getIdSede() {
		return idSede;
	}

	/**
	 * @param idSede
	 *            the idSede to set
	 */
	public void setIdSede(Integer idSede) {
		this.idSede = idSede;
	}

	/**
	 * @return the tipoUsuario
	 */
	public String getTipoUsuario() {
		return tipoUsuario;
	}

	/**
	 * @param tipoUsuario
	 *            the tipoUsuario to set
	 */
	public void setTipoUsuario(String tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

}