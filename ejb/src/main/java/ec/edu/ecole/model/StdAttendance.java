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
 * The persistent class for the sch_std_attendance database table.
 * 
 */
@Entity
@Table(name = "sch_std_attendance")
@NamedQuery(name = "StdAttendance.findAll", query = "SELECT s FROM StdAttendance s")
public class StdAttendance implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "attend_id")
	private int attendId;

	@Temporal(TemporalType.DATE)
	@Column(name = "attend_date")
	private Date attendDate;

	@Column(name = "attend_status")
	private byte attendStatus;

	private String reason;

	@Column(name = "std_roll_no")
	private int stdRollNo;

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

	public StdAttendance() {
	}

	public int getAttendId() {
		return this.attendId;
	}

	public void setAttendId(int attendId) {
		this.attendId = attendId;
	}

	public Date getAttendDate() {
		return this.attendDate;
	}

	public void setAttendDate(Date attendDate) {
		this.attendDate = attendDate;
	}

	public byte getAttendStatus() {
		return this.attendStatus;
	}

	public void setAttendStatus(byte attendStatus) {
		this.attendStatus = attendStatus;
	}

	public String getReason() {
		return this.reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public int getStdRollNo() {
		return this.stdRollNo;
	}

	public void setStdRollNo(int stdRollNo) {
		this.stdRollNo = stdRollNo;
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

}