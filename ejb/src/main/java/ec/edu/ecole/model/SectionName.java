package ec.edu.ecole.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * The persistent class for the sch_section_name database table.
 * 
 */
@Entity
@Table(name = "sch_section_name")
@NamedQuery(name = "SectionName.findAll", query = "SELECT s FROM SectionName s")
public class SectionName implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "section_id")
	private int sectionId;

	@Column(name = "section_name")
	private String sectionName;

	// bi-directional many-to-one association to AcademicYear
	@ManyToOne
	@JoinColumn(name = "acyid")
	private AcademicYear academicYear;

	// bi-directional many-to-one association to ClassName
	@ManyToOne
	@JoinColumn(name = "class_id")
	private ClassName className;

	// bi-directional many-to-one association to StdAttendance
	@OneToMany(mappedBy = "sectionName")
	private List<StdAttendance> stdAttendances;

	// bi-directional many-to-one association to StdMark
	@OneToMany(mappedBy = "sectionName")
	private List<StdMark> stdMarks;

	// bi-directional many-to-one association to Registration
	@OneToMany(mappedBy = "sectionName")
	private List<Registration> registrations;

	// bi-directional many-to-one association to TeacherSubAssign
	@OneToMany(mappedBy = "sectionName")
	private List<TeacherSubAssign> teacherSubAssigns;

	// bi-directional many-to-one association to TimeTable
	@OneToMany(mappedBy = "sectionName")
	private List<TimeTable> timeTables;

	public SectionName() {
	}

	public int getSectionId() {
		return this.sectionId;
	}

	public void setSectionId(int sectionId) {
		this.sectionId = sectionId;
	}

	public String getSectionName() {
		return this.sectionName;
	}

	public void setSectionName(String sectionName) {
		this.sectionName = sectionName;
	}

	public AcademicYear getAcademicYear() {
		return this.academicYear;
	}

	public void setAcademicYear(AcademicYear academicYear) {
		this.academicYear = academicYear;
	}

	public ClassName getClassName() {
		return this.className;
	}

	public void setClassName(ClassName className) {
		this.className = className;
	}

	public List<StdAttendance> getStdAttendances() {
		return this.stdAttendances;
	}

	public void setStdAttendances(List<StdAttendance> stdAttendances) {
		this.stdAttendances = stdAttendances;
	}

	public StdAttendance addStdAttendance(StdAttendance stdAttendance) {
		getStdAttendances().add(stdAttendance);
		stdAttendance.setSectionName(this);

		return stdAttendance;
	}

	public StdAttendance removeStdAttendance(StdAttendance stdAttendance) {
		getStdAttendances().remove(stdAttendance);
		stdAttendance.setSectionName(null);

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
		stdMark.setSectionName(this);

		return stdMark;
	}

	public StdMark removeStdMark(StdMark stdMark) {
		getStdMarks().remove(stdMark);
		stdMark.setSectionName(null);

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
		registration.setSectionName(this);

		return registration;
	}

	public Registration removeStdRegistration(Registration registration) {
		getStdRegistrations().remove(registration);
		registration.setSectionName(null);

		return registration;
	}

	public List<TeacherSubAssign> getTeacherSubAssigns() {
		return this.teacherSubAssigns;
	}

	public void setTeacherSubAssigns(List<TeacherSubAssign> teacherSubAssigns) {
		this.teacherSubAssigns = teacherSubAssigns;
	}

	public TeacherSubAssign addTeacherSubAssign(TeacherSubAssign teacherSubAssign) {
		getTeacherSubAssigns().add(teacherSubAssign);
		teacherSubAssign.setSectionName(this);

		return teacherSubAssign;
	}

	public TeacherSubAssign removeTeacherSubAssign(TeacherSubAssign teacherSubAssign) {
		getTeacherSubAssigns().remove(teacherSubAssign);
		teacherSubAssign.setSectionName(null);

		return teacherSubAssign;
	}

	public List<TimeTable> getTimeTables() {
		return this.timeTables;
	}

	public void setTimeTables(List<TimeTable> timeTables) {
		this.timeTables = timeTables;
	}

	public TimeTable addTimeTable(TimeTable timeTable) {
		getTimeTables().add(timeTable);
		timeTable.setSectionName(this);

		return timeTable;
	}

	public TimeTable removeTimeTable(TimeTable timeTable) {
		getTimeTables().remove(timeTable);
		timeTable.setSectionName(null);

		return timeTable;
	}

}