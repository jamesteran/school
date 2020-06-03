package ec.edu.ecole.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * The persistent class for the sch_academic_year database table.
 * 
 */
@Entity
@Table(name = "sch_academic_year")
@NamedQuery(name = "AcademicYear.findAll", query = "SELECT s FROM AcademicYear s")
public class AcademicYear implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int acyid;

	private String acyear;

	@Column(name = "open", columnDefinition = "INT(1)")
	private boolean open;

	@Column(name = "no_of_exam")
	private int noOfExam;

	@Column(name = "acy_sec")
	private int acySec;

	// bi-directional many-to-one association to SectionName
	@OneToMany(mappedBy = "academicYear")
	private List<SectionName> sectionNames;

	// bi-directional many-to-one association to StdAttendance
	@OneToMany(mappedBy = "academicYear")
	private List<StdAttendance> stdAttendances;

	// bi-directional many-to-one association to StdMark
	@OneToMany(mappedBy = "academicYear")
	private List<StdMark> stdMarks;

	// bi-directional many-to-one association to Registration
	@OneToMany(mappedBy = "academicYear")
	private List<Registration> registrations;

	public AcademicYear() {
	}

	public int getAcyid() {
		return this.acyid;
	}

	public void setAcyid(int acyid) {
		this.acyid = acyid;
	}

	public String getAcyear() {
		return this.acyear;
	}

	public void setAcyear(String acyear) {
		this.acyear = acyear;
	}

	public int getNoOfExam() {
		return this.noOfExam;
	}

	public void setNoOfExam(int noOfExam) {
		this.noOfExam = noOfExam;
	}

	public List<SectionName> getSectionNames() {
		return this.sectionNames;
	}

	public void setSectionNames(List<SectionName> sectionNames) {
		this.sectionNames = sectionNames;
	}

	public SectionName addSectionName(SectionName sectionName) {
		getSectionNames().add(sectionName);
		sectionName.setAcademicYear(this);

		return sectionName;
	}

	public SectionName removeSectionName(SectionName sectionName) {
		getSectionNames().remove(sectionName);
		sectionName.setAcademicYear(null);

		return sectionName;
	}

	public List<StdAttendance> getStdAttendances() {
		return this.stdAttendances;
	}

	public void setStdAttendances(List<StdAttendance> stdAttendances) {
		this.stdAttendances = stdAttendances;
	}

	public StdAttendance addStdAttendance(StdAttendance stdAttendance) {
		getStdAttendances().add(stdAttendance);
		stdAttendance.setAcademicYear(this);

		return stdAttendance;
	}

	public StdAttendance removeStdAttendance(StdAttendance stdAttendance) {
		getStdAttendances().remove(stdAttendance);
		stdAttendance.setAcademicYear(null);

		return stdAttendance;
	}

	public List<StdMark> getStdMarks() {
		return this.stdMarks;
	}

	public void setStdMarks(List<StdMark> stdMarks) {
		this.stdMarks = stdMarks;
	}

	public StdMark addStdMark(StdMark stdMark) {
		getStdMarks().add(stdMark);
		stdMark.setAcademicYear(this);

		return stdMark;
	}

	public StdMark removeStdMark(StdMark stdMark) {
		getStdMarks().remove(stdMark);
		stdMark.setAcademicYear(null);

		return stdMark;
	}

	public List<Registration> getStdRegistrations() {
		return this.registrations;
	}

	public void setStdRegistrations(List<Registration> registrations) {
		this.registrations = registrations;
	}

	public Registration addStdRegistration(Registration registration) {
		getStdRegistrations().add(registration);
		registration.setAcademicYear(this);

		return registration;
	}

	public Registration removeStdRegistration(Registration registration) {
		getStdRegistrations().remove(registration);
		registration.setAcademicYear(null);

		return registration;
	}

	public int getAcySec() {
		return acySec;
	}

	public void setAcySec(int acySec) {
		this.acySec = acySec;
	}

	public List<Registration> getRegistrations() {
		return registrations;
	}

	public void setRegistrations(List<Registration> registrations) {
		this.registrations = registrations;
	}

	public boolean isOpen() {
		return open;
	}

	public void setOpen(boolean open) {
		this.open = open;
	}

}