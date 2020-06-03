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
 * The persistent class for the sch_std_marks database table.
 * 
 */
@Entity
@Table(name = "sch_std_marks")
@NamedQuery(name = "StdMark.findAll", query = "SELECT s FROM StdMark s")
public class StdMark implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "marks_id")
	private int marksId;

	@Column(name = "marks_obtain")
	private int marksObtain;

	@Column(name = "std_roll_no")
	private int stdRollNo;

	@Column(name = "sub_grade")
	private String subGrade;

	// bi-directional many-to-one association to AcademicYear
	@ManyToOne
	@JoinColumn(name = "acyid")
	private AcademicYear academicYear;

	// bi-directional many-to-one association to ExamTitle
	@ManyToOne
	@JoinColumn(name = "ex_tt_id")
	private ExamTitle examTitle;

	// bi-directional many-to-one association to Group
	@ManyToOne
	@JoinColumn(name = "group_id")
	private Group group;

	// bi-directional many-to-one association to SectionName
	@ManyToOne
	@JoinColumn(name = "section_id")
	private SectionName sectionName;

	// bi-directional many-to-one association to Subject
	@ManyToOne
	@JoinColumn(name = "subject_id")
	private Subject subject;

	public StdMark() {
	}

	public int getMarksId() {
		return this.marksId;
	}

	public void setMarksId(int marksId) {
		this.marksId = marksId;
	}

	public int getMarksObtain() {
		return this.marksObtain;
	}

	public void setMarksObtain(int marksObtain) {
		this.marksObtain = marksObtain;
	}

	public int getStdRollNo() {
		return this.stdRollNo;
	}

	public void setStdRollNo(int stdRollNo) {
		this.stdRollNo = stdRollNo;
	}

	public String getSubGrade() {
		return this.subGrade;
	}

	public void setSubGrade(String subGrade) {
		this.subGrade = subGrade;
	}

	public AcademicYear getAcademicYear() {
		return this.academicYear;
	}

	public void setAcademicYear(AcademicYear academicYear) {
		this.academicYear = academicYear;
	}

	public ExamTitle getExamTitle() {
		return this.examTitle;
	}

	public void setExamTitle(ExamTitle examTitle) {
		this.examTitle = examTitle;
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

	public Subject getSubject() {
		return this.subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

}