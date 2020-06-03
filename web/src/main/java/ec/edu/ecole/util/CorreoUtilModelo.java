/**
* Copyright (C) 2017 - Todos los derechos reservados.
* Universidad Tecnologica Equinoccial (UTE)
*/
package ec.edu.ecole.util;

import java.io.Serializable;
import java.util.List;

//import ec.edu.ute.util.StringToJsonUtil;

/**
 * Fecha de creacion: 14 jun. 2017
 *
 * @author guido.guerrero
 *
 */
public class CorreoUtilModelo implements Serializable {
	private static final long serialVersionUID = -8687794295876935425L;

	private String subject;
	private String body;
	private String to;
	private List<String> cc;
	private List<String> bcc;
	private String from;
	private String fromName;

	public CorreoUtilModelo() {

	}

	public CorreoUtilModelo(String subject, String body, String to, List<String> cc, List<String> bcc) {
		this.subject = subject;
		this.body = body;
		this.to = to;
		this.cc = cc;
		this.bcc = bcc;
	}

	/**
	 * @return the subject
	 */
	public String getSubject() {
		return subject;
	}

	/**
	 * @param subject
	 *            the subject to set
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}

	/**
	 * @return the body
	 */
	public String getBody() {
		return body;
	}

	/**
	 * @param body
	 *            the body to set
	 */
	public void setBody(String body) {
		this.body = body;
	}

	/**
	 * @return the to
	 */
	public String getTo() {
		return to;
	}

	/**
	 * @param to
	 *            the to to set
	 */
	public void setTo(String to) {
		this.to = to;
	}

	/**
	 * @return the cc
	 */
	public List<String> getCc() {
		return cc;
	}

	/**
	 * @param cc
	 *            the cc to set
	 */
	public void setCc(List<String> cc) {
		this.cc = cc;
	}

	/**
	 * @return the bcc
	 */
	public List<String> getBcc() {
		return bcc;
	}

	/**
	 * @param bcc
	 *            the bcc to set
	 */
	public void setBcc(List<String> bcc) {
		this.bcc = bcc;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bcc == null) ? 0 : bcc.hashCode());
		result = prime * result + ((body == null) ? 0 : body.hashCode());
		result = prime * result + ((cc == null) ? 0 : cc.hashCode());
		result = prime * result + ((subject == null) ? 0 : subject.hashCode());
		result = prime * result + ((to == null) ? 0 : to.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CorreoUtilModelo other = (CorreoUtilModelo) obj;
		if (bcc == null) {
			if (other.bcc != null)
				return false;
		} else if (!bcc.equals(other.bcc))
			return false;
		if (body == null) {
			if (other.body != null)
				return false;
		} else if (!body.equals(other.body))
			return false;
		if (cc == null) {
			if (other.cc != null)
				return false;
		} else if (!cc.equals(other.cc))
			return false;
		if (subject == null) {
			if (other.subject != null)
				return false;
		} else if (!subject.equals(other.subject))
			return false;
		if (to == null) {
			if (other.to != null)
				return false;
		} else if (!to.equals(other.to))
			return false;
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return StringToJsonUtil.stringToJ(this);
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getFromName() {
		return fromName;
	}

	public void setFromName(String fromName) {
		this.fromName = fromName;
	}

};