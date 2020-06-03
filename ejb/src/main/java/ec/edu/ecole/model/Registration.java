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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the sch_std_registration database table.
 * 
 */
@Entity
@Table(name = "sch_std_registration")
@NamedQuery(name = "Registration.findAll", query = "SELECT s FROM Registration s")
public class Registration implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "reg_id")
	private int regId;

	@Temporal(TemporalType.DATE)
	@Column(name = "reg_date")
	private Date regDate;

	@Column(name = "std_roll_no")
	private int stdRollNo;

	@Column(name = "reg_cod")
	private String regCod;

	@Column(name = "active")
	private int active;

	// bi-directional many-to-one association to RegFee
	@OneToMany(mappedBy = "registration")
	private List<RegFee> regFees;

	// bi-directional many-to-one association to AcademicYear
	@ManyToOne
	@JoinColumn(name = "acyid")
	private AcademicYear academicYear;

	// bi-directional many-to-one association to Group
	@ManyToOne
	@JoinColumn(name = "group_id")
	private Group group;

	// bi-directional many-to-one association to SectionName
	@ManyToOne
	@JoinColumn(name = "section_id")
	private SectionName sectionName;

	// bi-directional many-to-one association to StudentInfo
	@ManyToOne
	@JoinColumn(name = "std_id")
	private StudentInfo studentInfo;

	public Registration() {
	}

	public int getRegId() {
		return this.regId;
	}

	public void setRegId(int regId) {
		this.regId = regId;
	}

	public Date getRegDate() {
		return this.regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public int getStdRollNo() {
		return this.stdRollNo;
	}

	public void setStdRollNo(int stdRollNo) {
		this.stdRollNo = stdRollNo;
	}

	public List<RegFee> getRegFees() {
		return this.regFees;
	}

	public void setRegFees(List<RegFee> regFees) {
		this.regFees = regFees;
	}

	public RegFee addRegFee(RegFee regFee) {
		getRegFees().add(regFee);
		regFee.setStdRegistration(this);

		return regFee;
	}

	public RegFee removeRegFee(RegFee regFee) {
		getRegFees().remove(regFee);
		regFee.setStdRegistration(null);

		return regFee;
	}

	public AcademicYear getAcademicYear() {
		return this.academicYear;
	}

	public void setAcademicYear(AcademicYear academicYear) {
		this.academicYear = academicYear;
	}

	public Group getStdGroup() {
		return this.group;
	}

	public void setStdGroup(Group group) {
		this.group = group;
	}

	public SectionName getSectionName() {
		return this.sectionName;
	}

	public void setSectionName(SectionName sectionName) {
		this.sectionName = sectionName;
	}

	public StudentInfo getStudentInfo() {
		return this.studentInfo;
	}

	public void setStudentInfo(StudentInfo studentInfo) {
		this.studentInfo = studentInfo;
	}

	public String getRegCod() {
		return regCod;
	}

	public void setRegCod(String regCod) {
		this.regCod = regCod;
	}

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}

}