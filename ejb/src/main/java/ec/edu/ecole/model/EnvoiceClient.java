package ec.edu.ecole.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the sch_envoice_client database table.
 * 
 */
@Entity
@Table(name = "sch_envoice_client")
@NamedQuery(name = "EnvoiceClient.findAll", query = "SELECT s FROM EnvoiceClient s")
public class EnvoiceClient implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "envcli_id")
	private int envcliId;

	private byte active;

	@Column(name = "envcli_addr")
	private String envcliAddr;

	@Column(name = "envcli_email")
	private String envcliEmail;

	@Column(name = "envcli_mobil")
	private String envcliMobil;

	@Column(name = "envcli_phone")
	private String envcliPhone;

	@Column(name = "envcli_razon_social")
	private String envcliRazonSocial;

	@Column(name = "envcli_ruc")
	private String envcliRuc;

	// bi-directional many-to-one association to StudentInfo
	@ManyToOne
	@JoinColumn(name = "std_id")
	private StudentInfo studentInfo;

	public EnvoiceClient() {
	}

	public int getEnvcliId() {
		return this.envcliId;
	}

	public void setEnvcliId(int envcliId) {
		this.envcliId = envcliId;
	}

	public byte getActive() {
		return this.active;
	}

	public void setActive(byte active) {
		this.active = active;
	}

	public String getEnvcliAddr() {
		return this.envcliAddr;
	}

	public void setEnvcliAddr(String envcliAddr) {
		this.envcliAddr = envcliAddr;
	}

	public String getEnvcliEmail() {
		return this.envcliEmail;
	}

	public void setEnvcliEmail(String envcliEmail) {
		this.envcliEmail = envcliEmail;
	}

	public String getEnvcliMobil() {
		return this.envcliMobil;
	}

	public void setEnvcliMobil(String envcliMobil) {
		this.envcliMobil = envcliMobil;
	}

	public String getEnvcliPhone() {
		return this.envcliPhone;
	}

	public void setEnvcliPhone(String envcliPhone) {
		this.envcliPhone = envcliPhone;
	}

	public String getEnvcliRazonSocial() {
		return this.envcliRazonSocial;
	}

	public void setEnvcliRazonSocial(String envcliRazonSocial) {
		this.envcliRazonSocial = envcliRazonSocial;
	}

	public String getEnvcliRuc() {
		return this.envcliRuc;
	}

	public void setEnvcliRuc(String envcliRuc) {
		this.envcliRuc = envcliRuc;
	}

	public StudentInfo getSchStudentInfo() {
		return this.studentInfo;
	}

	public void setSchStudentInfo(StudentInfo studentInfo) {
		this.studentInfo = studentInfo;
	}

}