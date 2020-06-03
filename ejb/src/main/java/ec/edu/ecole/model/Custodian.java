package ec.edu.ecole.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the sch_custodian database table.
 * 
 */
@Entity
@Table(name = "sch_custodian")
@NamedQuery(name = "Custodian.findAll", query = "SELECT s FROM Custodian s")
public class Custodian implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cust_id")
	private int custId;

	private int active;

	@Column(name = "cust_email")
	private String custEmail;

	@Column(name = "cust_parent")
	private String custParent;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "id_number")
	private String idNumber;

	@Column(name = "cust_type")
	private String custType;

	@Column(name = "cust_lug_trabajo")
	private String custLugTrabajo;

	@Column(name = "cust_dir_trabajo")
	private String custDirTrabajo;

	@Column(name = "cust_phone")
	private String custTelefono;

	@Column(name = "cust_mobil")
	private String custCelular;

	@Lob
	@Column(name = "cust_photo")
	private byte[] custPhoto;

	@Column(name = "cust_rep_legal", columnDefinition = "INT(1)")
	private boolean custRepLegal;

	// bi-directional many-to-one association to StudentInfo
	@ManyToOne
	@JoinColumn(name = "std_id")
	private StudentInfo studentInfo;

	public Custodian() {
	}

	public int getCustId() {
		return this.custId;
	}

	public void setCustId(int custId) {
		this.custId = custId;
	}

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}

	public String getCustEmail() {
		return this.custEmail;
	}

	public void setCustEmail(String custEmail) {
		this.custEmail = custEmail;
	}

	public String getCustParent() {
		return this.custParent;
	}

	public void setCustParent(String custParent) {
		this.custParent = custParent;
	}

	public String getCustType() {
		return this.custType;
	}

	public void setCustType(String custType) {
		this.custType = custType;
	}

	public StudentInfo getSchStudentInfo() {
		return this.studentInfo;
	}

	public void setSchStudentInfo(StudentInfo studentInfo) {
		this.studentInfo = studentInfo;
	}

	public String getCustLugTrabajo() {
		return custLugTrabajo;
	}

	public void setCustLugTrabajo(String custLugTrabajo) {
		this.custLugTrabajo = custLugTrabajo;
	}

	public String getCustDirTrabajo() {
		return custDirTrabajo;
	}

	public void setCustDirTrabajo(String custDirTrabajo) {
		this.custDirTrabajo = custDirTrabajo;
	}

	public String getCustTelefono() {
		return custTelefono;
	}

	public void setCustTelefono(String custTelefono) {
		this.custTelefono = custTelefono;
	}

	public String getCustCelular() {
		return custCelular;
	}

	public void setCustCelular(String custCelular) {
		this.custCelular = custCelular;
	}

	public StudentInfo getStudentInfo() {
		return studentInfo;
	}

	public void setStudentInfo(StudentInfo studentInfo) {
		this.studentInfo = studentInfo;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}

	public byte[] getCustPhoto() {
		return custPhoto;
	}

	public void setCustPhoto(byte[] custPhoto) {
		this.custPhoto = custPhoto;
	}

	public boolean isCustRepLegal() {
		return custRepLegal;
	}

	public void setCustRepLegal(boolean custRepLegal) {
		this.custRepLegal = custRepLegal;
	}

}