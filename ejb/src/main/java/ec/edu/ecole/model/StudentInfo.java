package ec.edu.ecole.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the sch_student_info database table.
 * 
 */
@Entity
@Table(name = "sch_student_info")
@NamedQuery(name = "StudentInfo.findAll", query = "SELECT s FROM StudentInfo s")
public class StudentInfo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "std_id")
	private int stdId;

	@Column(name = "std_age")
	private int stdAge;

	@Column(name = "std_birth_place")
	private String stdBirthPlace;

	@Temporal(TemporalType.DATE)
	@Column(name = "std_dob")
	private Date stdDob;

	@Column(name = "std_email")
	private String stdEmail;

	@Column(name = "std_gender")
	private String stdGender;

	@Column(name = "std_language")
	private String stdLanguage;

	@Column(name = "std_nac")
	private String stdNac;

	@Column(name = "std_name")
	private String stdName;

	@Column(name = "id_number")
	private String idNumber;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "std_zona")
	private String stdZona;

	@Column(name = "std_sector")
	private String stdSector;

	@Column(name = "std_vive_con")
	private String stdViveCon;

	@Column(name = "std_dir")
	private String stdDir;

	@Column(name = "std_dir_ref")
	private String stdDirRef;

	@Column(name = "std_color_casa")
	private String stdColorCasa;

	@Column(name = "std_piso_casa")
	private int stdPisoCasa;

	@Column(name = "std_mobile")
	private String stdMobil;

	@Column(name = "std_phone")
	private String stdPhone;

	@Column(name = "std_huerfano")
	private String stdHuerfano;

	@Lob
	@Column(name = "std_photo")
	private byte[] stdPhoto;

	@Column(name = "std_sib_in_sch")
	private Integer stdSibInSch;

	@Column(name = "std_sib_place")
	private Integer stdSibPlace;

	@Column(name = "std_siblings")
	private Integer stdSiblings;

	@Column(name = "std_status")
	private byte stdStatus;

	@Column(name = "std_blood_grp")
	private String stdBloodGrp;

	// bi-directional many-to-one association to Custodian
	@OneToMany(mappedBy = "studentInfo")
	private List<Custodian> custodians;

	// bi-directional many-to-one association to EnvoiceClient
	@OneToMany(mappedBy = "studentInfo")
	private List<EnvoiceClient> envoiceClients;

	// bi-directional many-to-one association to MedicalAnswer
	@OneToMany(mappedBy = "studentInfo")
	private List<MedicalAnswer> medicalAnswers;

	// bi-directional many-to-one association to Sibling
	@OneToMany(mappedBy = "studentInfo1")
	private List<Sibling> siblings1;

	// bi-directional many-to-one association to Sibling
	@OneToMany(mappedBy = "studentInfo2")
	private List<Sibling> siblings2;

	// bi-directional many-to-one association to StdAttendance
	@OneToMany(mappedBy = "studentInfo")
	private List<StdAttendance> stdAttendances;

	// bi-directional many-to-one association to StdContactInfo
	@OneToMany(mappedBy = "studentInfo")
	private List<StdContactInfo> stdContactInfos;

	// bi-directional many-to-one association to Registration
	@OneToMany(mappedBy = "studentInfo")
	private List<Registration> registrations;

	// bi-directional many-to-one association to Registration
	// @OneToMany(mappedBy="studentInfo")
	// private List<Parent> parents;

	// bi-directional many-to-one association to Parroquia
	@ManyToOne
	@JoinColumn(name = "parroquia_id")
	private Parroquia parroquia;

	// bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	// bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name = "mom_id", insertable = false, updatable = false)
	private Parent mom;

	// bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name = "pha_id", insertable = false, updatable = false)
	private Parent pha;

	// bi-directional many-to-one association to Transport
	@OneToMany(mappedBy = "studentInfo")
	private List<Transport> transports;

	public StudentInfo() {
	}

	public int getStdId() {
		return this.stdId;
	}

	public void setStdId(int stdId) {
		this.stdId = stdId;
	}

	public int getStdAge() {
		return this.stdAge;
	}

	public void setStdAge(int stdAge) {
		this.stdAge = stdAge;
	}

	public String getStdBirthPlace() {
		return this.stdBirthPlace;
	}

	public void setStdBirthPlace(String stdBirthPlace) {
		this.stdBirthPlace = stdBirthPlace;
	}

	public Date getStdDob() {
		return this.stdDob;
	}

	public void setStdDob(Date stdDob) {
		this.stdDob = stdDob;
	}

	public String getStdEmail() {
		return this.stdEmail;
	}

	public void setStdEmail(String stdEmail) {
		this.stdEmail = stdEmail;
	}

	public String getStdGender() {
		return this.stdGender;
	}

	public void setStdGender(String stdGender) {
		this.stdGender = stdGender;
	}

	public String getStdLanguage() {
		return this.stdLanguage;
	}

	public void setStdLanguage(String stdLanguage) {
		this.stdLanguage = stdLanguage;
	}

	public String getStdNac() {
		return this.stdNac;
	}

	public void setStdNac(String stdNac) {
		this.stdNac = stdNac;
	}

	public String getStdName() {
		return this.stdName;
	}

	public void setStdName(String stdName) {
		this.stdName = stdName;
	}

	public byte[] getStdPhoto() {
		return this.stdPhoto;
	}

	public void setStdPhoto(byte[] stdPhoto) {
		this.stdPhoto = stdPhoto;
	}

	public Integer getStdSibInSch() {
		return this.stdSibInSch;
	}

	public void setStdSibInSch(Integer stdSibInSch) {
		this.stdSibInSch = stdSibInSch;
	}

	public Integer getStdSibPlace() {
		return this.stdSibPlace;
	}

	public void setStdSibPlace(Integer stdSibPlace) {
		this.stdSibPlace = stdSibPlace;
	}

	public Integer getStdSiblings() {
		return this.stdSiblings;
	}

	public void setStdSiblings(Integer stdSiblings) {
		this.stdSiblings = stdSiblings;
	}

	public byte getStdStatus() {
		return this.stdStatus;
	}

	public void setStdStatus(byte stdStatus) {
		this.stdStatus = stdStatus;
	}

	public List<Custodian> getCustodians() {
		return this.custodians;
	}

	public void setCustodians(List<Custodian> custodians) {
		this.custodians = custodians;
	}

	public Custodian addCustodian(Custodian custodian) {
		getCustodians().add(custodian);
		custodian.setSchStudentInfo(this);

		return custodian;
	}

	public Custodian removeCustodian(Custodian custodian) {
		getCustodians().remove(custodian);
		custodian.setSchStudentInfo(null);

		return custodian;
	}

	public List<EnvoiceClient> getEnvoiceClients() {
		return this.envoiceClients;
	}

	public void setEnvoiceClients(List<EnvoiceClient> envoiceClients) {
		this.envoiceClients = envoiceClients;
	}

	public EnvoiceClient addEnvoiceClient(EnvoiceClient envoiceClient) {
		getEnvoiceClients().add(envoiceClient);
		envoiceClient.setSchStudentInfo(this);

		return envoiceClient;
	}

	public EnvoiceClient removeEnvoiceClient(EnvoiceClient envoiceClient) {
		getEnvoiceClients().remove(envoiceClient);
		envoiceClient.setSchStudentInfo(null);

		return envoiceClient;
	}

	public List<MedicalAnswer> getMedicalAnswers() {
		return this.medicalAnswers;
	}

	public void setMedicalAnswers(List<MedicalAnswer> medicalAnswers) {
		this.medicalAnswers = medicalAnswers;
	}

	public MedicalAnswer addMedicalAnswer(MedicalAnswer medicalAnswer) {
		getMedicalAnswers().add(medicalAnswer);
		medicalAnswer.setSchStudentInfo(this);

		return medicalAnswer;
	}

	public MedicalAnswer removeMedicalAnswer(MedicalAnswer medicalAnswer) {
		getMedicalAnswers().remove(medicalAnswer);
		medicalAnswer.setSchStudentInfo(null);

		return medicalAnswer;
	}

	public List<Sibling> getSiblings1() {
		return this.siblings1;
	}

	public void setSiblings1(List<Sibling> schSiblings1) {
		this.siblings1 = schSiblings1;
	}

	public Sibling addSiblings1(Sibling schSiblings1) {
		getSiblings1().add(schSiblings1);
		schSiblings1.setStudentInfo1(this);

		return schSiblings1;
	}

	public Sibling removeSiblings1(Sibling schSiblings1) {
		getSiblings1().remove(schSiblings1);
		schSiblings1.setStudentInfo1(null);

		return schSiblings1;
	}

	public List<Sibling> getSiblings2() {
		return this.siblings2;
	}

	public void setSiblings2(List<Sibling> schSiblings2) {
		this.siblings2 = schSiblings2;
	}

	public Sibling addSiblings2(Sibling schSiblings2) {
		getSiblings2().add(schSiblings2);
		schSiblings2.setStudentInfo2(this);

		return schSiblings2;
	}

	public Sibling removeSiblings2(Sibling schSiblings2) {
		getSiblings2().remove(schSiblings2);
		schSiblings2.setStudentInfo2(null);

		return schSiblings2;
	}

	public List<StdAttendance> getStdAttendances() {
		return this.stdAttendances;
	}

	public void setStdAttendances(List<StdAttendance> stdAttendances) {
		this.stdAttendances = stdAttendances;
	}

	public StdAttendance addStdAttendance(StdAttendance stdAttendance) {
		getStdAttendances().add(stdAttendance);
		stdAttendance.setStudentInfo(this);

		return stdAttendance;
	}

	public StdAttendance removeStdAttendance(StdAttendance stdAttendance) {
		getStdAttendances().remove(stdAttendance);
		stdAttendance.setStudentInfo(null);

		return stdAttendance;
	}

	public List<StdContactInfo> getStdContactInfos() {
		return this.stdContactInfos;
	}

	public void setStdContactInfos(List<StdContactInfo> stdContactInfos) {
		this.stdContactInfos = stdContactInfos;
	}

	public StdContactInfo addStdContactInfo(StdContactInfo stdContactInfo) {
		getStdContactInfos().add(stdContactInfo);
		stdContactInfo.setStudentInfo(this);

		return stdContactInfo;
	}

	public StdContactInfo removeStdContactInfo(StdContactInfo stdContactInfo) {
		getStdContactInfos().remove(stdContactInfo);
		stdContactInfo.setStudentInfo(null);

		return stdContactInfo;
	}

	public List<Registration> getStdRegistrations() {
		return this.registrations;
	}

	public void setStdRegistrations(List<Registration> registrations) {
		this.registrations = registrations;
	}

	public Registration addStdRegistration(Registration registration) {
		getStdRegistrations().add(registration);
		registration.setStudentInfo(this);

		return registration;
	}

	public Registration removeStdRegistration(Registration registration) {
		getStdRegistrations().remove(registration);
		registration.setStudentInfo(null);

		return registration;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Transport> getTransports() {
		return this.transports;
	}

	public void setTransports(List<Transport> transports) {
		this.transports = transports;
	}

	public Transport addTransport(Transport transport) {
		getTransports().add(transport);
		transport.setStudentInfo(this);

		return transport;
	}

	public Transport removeTransport(Transport transport) {
		getTransports().remove(transport);
		transport.setStudentInfo(null);

		return transport;
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

	public Parent getMom() {
		return mom;
	}

	public void setMom(Parent mom) {
		this.mom = mom;
	}

	public Parent getPha() {
		return pha;
	}

	public void setPha(Parent pha) {
		this.pha = pha;
	}

	public Parroquia getParroquia() {
		return parroquia;
	}

	public void setParroquia(Parroquia parroquia) {
		this.parroquia = parroquia;
	}

	public String getStdZona() {
		return stdZona;
	}

	public void setStdZona(String stdZona) {
		this.stdZona = stdZona;
	}

	public String getStdSector() {
		return stdSector;
	}

	public void setStdSector(String stdSector) {
		this.stdSector = stdSector;
	}

	public String getStdViveCon() {
		return stdViveCon;
	}

	public void setStdViveCon(String stdViveCon) {
		this.stdViveCon = stdViveCon;
	}

	public String getStdDir() {
		return stdDir;
	}

	public void setStdDir(String stdDir) {
		this.stdDir = stdDir;
	}

	public String getStdColorCasa() {
		return stdColorCasa;
	}

	public void setStdColorCasa(String stdColorCasa) {
		this.stdColorCasa = stdColorCasa;
	}

	public int getStdPisoCasa() {
		return stdPisoCasa;
	}

	public void setStdPisoCasa(int stdPisoCasa) {
		this.stdPisoCasa = stdPisoCasa;
	}

	public String getStdMobil() {
		return stdMobil;
	}

	public void setStdMobil(String stdMobil) {
		this.stdMobil = stdMobil;
	}

	public String getStdDirRef() {
		return stdDirRef;
	}

	public void setStdDirRef(String stdDirRef) {
		this.stdDirRef = stdDirRef;
	}

	public String getStdPhone() {
		return stdPhone;
	}

	public void setStdPhone(String stdPhone) {
		this.stdPhone = stdPhone;
	}

	public String getStdHuerfano() {
		return stdHuerfano;
	}

	public void setStdHuerfano(String stdHuerfano) {
		this.stdHuerfano = stdHuerfano;
	}

	public List<Registration> getRegistrations() {
		return registrations;
	}

	public void setRegistrations(List<Registration> registrations) {
		this.registrations = registrations;
	}

	public String getStdBloodGrp() {
		return stdBloodGrp;
	}

	public void setStdBloodGrp(String stdBloodGrp) {
		this.stdBloodGrp = stdBloodGrp;
	}

}