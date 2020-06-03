package ec.edu.ecole.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the sch_parent database table.
 * 
 */
@Entity
@Table(name = "sch_parent")
@NamedQuery(name = "Parent.findAll", query = "SELECT s FROM Parent s")
public class Parent implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "parent_id")
	private int parentId;

	private byte active;

	@Column(name = "blood_grp")
	private String bloodGrp;

	@Column(name = "civil_state")
	private String civilState;

	@Column(name = "degree_title")
	private String degreeTitle;

	@Column(name = "education_level")
	private String educationLevel;

	private byte ispresent;

	@Column(name = "parent_addr")
	private String parentAddr;

	@Column(name = "parent_email")
	private String parentEmail;

	@Column(name = "parent_gender")
	private String parentGender;

	@Column(name = "parent_mobil")
	private String parentMobil;

	@Column(name = "parent_nac")
	private String parentNac;

	@Column(name = "parent_phone")
	private String parentPhone;

	@Column(name = "parent_ruc")
	private String parentRuc;

	@Column(name = "work_charge")
	private String workCharge;

	@Column(name = "work_phone")
	private String workPhone;

	@Column(name = "work_phone_ext")
	private String workPhoneExt;

	@Column(name = "work_place")
	private String workPlace;

	@Column(name = "work_dir")
	private String workDir;

	@Column(name = "id_number")
	private String idNumber;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "profesion")
	private String profesion;

	@Column(name = "rep_legal", columnDefinition = "INT(1)")
	private boolean repLegal;

	@Column(name = "ret_student", columnDefinition = "INT(1)")
	private boolean retStudent;

	@Temporal(TemporalType.DATE)
	@Column(name = "parent_fec_nac")
	private Date parentFecNac;

	// bi-directional many-to-one association to Parroquia
	@ManyToOne
	@JoinColumn(name = "parroquia_id")
	private Parroquia parroquia;

	// bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	// bi-directional many-to-one association to User
	// @ManyToOne
	// @JoinColumn(name="std_id")
	// private StudentInfo studentInfo;

	// bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name = "prntype_id")
	private ParentType parentType;

	public Parent() {
	}

	public int getParentId() {
		return this.parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

	public byte getActive() {
		return this.active;
	}

	public void setActive(byte active) {
		this.active = active;
	}

	public String getBloodGrp() {
		return this.bloodGrp;
	}

	public void setBloodGrp(String bloodGrp) {
		this.bloodGrp = bloodGrp;
	}

	public String getCivilState() {
		return this.civilState;
	}

	public void setCivilState(String civilState) {
		this.civilState = civilState;
	}

	public String getDegreeTitle() {
		return this.degreeTitle;
	}

	public void setDegreeTitle(String degreeTitle) {
		this.degreeTitle = degreeTitle;
	}

	public String getEducationLevel() {
		return this.educationLevel;
	}

	public void setEducationLevel(String educationLevel) {
		this.educationLevel = educationLevel;
	}

	public byte getIspresent() {
		return this.ispresent;
	}

	public void setIspresent(byte ispresent) {
		this.ispresent = ispresent;
	}

	public String getParentAddr() {
		return this.parentAddr;
	}

	public void setParentAddr(String parentAddr) {
		this.parentAddr = parentAddr;
	}

	public String getParentEmail() {
		return this.parentEmail;
	}

	public void setParentEmail(String parentEmail) {
		this.parentEmail = parentEmail;
	}

	public String getParentGender() {
		return this.parentGender;
	}

	public void setParentGender(String parentGender) {
		this.parentGender = parentGender;
	}

	public String getParentMobil() {
		return this.parentMobil;
	}

	public void setParentMobil(String parentMobil) {
		this.parentMobil = parentMobil;
	}

	public String getParentNac() {
		return this.parentNac;
	}

	public void setParentNac(String parentNac) {
		this.parentNac = parentNac;
	}

	public String getParentPhone() {
		return this.parentPhone;
	}

	public void setParentPhone(String parentPhone) {
		this.parentPhone = parentPhone;
	}

	public String getParentRuc() {
		return this.parentRuc;
	}

	public void setParentRuc(String parentRuc) {
		this.parentRuc = parentRuc;
	}

	public String getWorkCharge() {
		return this.workCharge;
	}

	public void setWorkCharge(String workCharge) {
		this.workCharge = workCharge;
	}

	public String getWorkPhone() {
		return this.workPhone;
	}

	public void setWorkPhone(String workPhone) {
		this.workPhone = workPhone;
	}

	public String getWorkPhoneExt() {
		return this.workPhoneExt;
	}

	public void setWorkPhoneExt(String workPhoneExt) {
		this.workPhoneExt = workPhoneExt;
	}

	public String getWorkPlace() {
		return this.workPlace;
	}

	public void setWorkPlace(String workPlace) {
		this.workPlace = workPlace;
	}

	public Parroquia getParroquia() {
		return this.parroquia;
	}

	public void setParroquia(Parroquia parroquia) {
		this.parroquia = parroquia;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getIdNumber() {
		return this.idNumber;
	}

	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
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

	public void setLastName(String lasttName) {
		this.lastName = lasttName;
	}

	public ParentType getParentType() {
		return parentType;
	}

	public void setParentType(ParentType parentType) {
		this.parentType = parentType;
	}

	public String getProfesion() {
		return profesion;
	}

	public void setProfesion(String profesion) {
		this.profesion = profesion;
	}

	public boolean isRepLegal() {
		return repLegal;
	}

	public void setRepLegal(boolean repLegal) {
		this.repLegal = repLegal;
	}

	public boolean isRetStudent() {
		return retStudent;
	}

	public void setRetStudent(boolean retStudent) {
		this.retStudent = retStudent;
	}

	public String getWorkDir() {
		return workDir;
	}

	public void setWorkDir(String workDir) {
		this.workDir = workDir;
	}

	public Date getParentFecNac() {
		return parentFecNac;
	}

	public void setParentFecNac(Date parentFecNac) {
		this.parentFecNac = parentFecNac;
	}

}