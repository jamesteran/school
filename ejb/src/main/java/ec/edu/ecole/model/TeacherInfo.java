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
 * The persistent class for the sch_teacher_info database table.
 * 
 */
@Entity
@Table(name = "sch_teacher_info")
@NamedQuery(name = "TeacherInfo.findAll", query = "SELECT s FROM TeacherInfo s")
public class TeacherInfo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "teacher_id")
	private int teacherId;

	private byte active;

	@Column(name = "depart_date")
	private String departDate;

	private byte ispresent;

	@Column(name = "teacher_addr")
	private String teacherAddr;

	@Column(name = "teacher_email")
	private String teacherEmail;

	@Temporal(TemporalType.DATE)
	@Column(name = "teacher_join_date")
	private Date teacherJoinDate;

	@Column(name = "teacher_mobile")
	private String teacherMobile;

	@Column(name = "teacher_name")
	private String teacherName;

	@Lob
	@Column(name = "teacher_photo")
	private byte[] teacherPhoto;

	// bi-directional many-to-one association to ClassTimeTableLine
	@OneToMany(mappedBy = "teacherInfo")
	private List<ClassTimeTableLine> classTimeTableLines;

	// bi-directional many-to-one association to Subject
	@ManyToOne
	@JoinColumn(name = "subject_id")
	private Subject subject;

	// bi-directional many-to-one association to TeacherGrade
	@ManyToOne
	@JoinColumn(name = "teacher_grade_id")
	private TeacherGrade teacherGrade;

	// bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	// bi-directional many-to-one association to TeacherSubAssign
	@OneToMany(mappedBy = "teacherInfo")
	private List<TeacherSubAssign> teacherSubAssigns;

	public TeacherInfo() {
	}

	public int getTeacherId() {
		return this.teacherId;
	}

	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}

	public byte getActive() {
		return this.active;
	}

	public void setActive(byte active) {
		this.active = active;
	}

	public String getDepartDate() {
		return this.departDate;
	}

	public void setDepartDate(String departDate) {
		this.departDate = departDate;
	}

	public byte getIspresent() {
		return this.ispresent;
	}

	public void setIspresent(byte ispresent) {
		this.ispresent = ispresent;
	}

	public String getTeacherAddr() {
		return this.teacherAddr;
	}

	public void setTeacherAddr(String teacherAddr) {
		this.teacherAddr = teacherAddr;
	}

	public String getTeacherEmail() {
		return this.teacherEmail;
	}

	public void setTeacherEmail(String teacherEmail) {
		this.teacherEmail = teacherEmail;
	}

	public Date getTeacherJoinDate() {
		return this.teacherJoinDate;
	}

	public void setTeacherJoinDate(Date teacherJoinDate) {
		this.teacherJoinDate = teacherJoinDate;
	}

	public String getTeacherMobile() {
		return this.teacherMobile;
	}

	public void setTeacherMobile(String teacherMobile) {
		this.teacherMobile = teacherMobile;
	}

	public String getTeacherName() {
		return this.teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public byte[] getTeacherPhoto() {
		return this.teacherPhoto;
	}

	public void setTeacherPhoto(byte[] teacherPhoto) {
		this.teacherPhoto = teacherPhoto;
	}

	public List<ClassTimeTableLine> getClassTimeTableLines() {
		return this.classTimeTableLines;
	}

	public void setClassTimeTableLines(List<ClassTimeTableLine> classTimeTableLines) {
		this.classTimeTableLines = classTimeTableLines;
	}

	public ClassTimeTableLine addClassTimeTableLine(ClassTimeTableLine classTimeTableLine) {
		getClassTimeTableLines().add(classTimeTableLine);
		classTimeTableLine.setTeacherInfo(this);

		return classTimeTableLine;
	}

	public ClassTimeTableLine removeClassTimeTableLine(ClassTimeTableLine classTimeTableLine) {
		getClassTimeTableLines().remove(classTimeTableLine);
		classTimeTableLine.setTeacherInfo(null);

		return classTimeTableLine;
	}

	public Subject getSubject() {
		return this.subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public TeacherGrade getTeacherGrade() {
		return this.teacherGrade;
	}

	public void setTeacherGrade(TeacherGrade teacherGrade) {
		this.teacherGrade = teacherGrade;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<TeacherSubAssign> getTeacherSubAssigns() {
		return this.teacherSubAssigns;
	}

	public void setTeacherSubAssigns(List<TeacherSubAssign> teacherSubAssigns) {
		this.teacherSubAssigns = teacherSubAssigns;
	}

	public TeacherSubAssign addTeacherSubAssign(TeacherSubAssign teacherSubAssign) {
		getTeacherSubAssigns().add(teacherSubAssign);
		teacherSubAssign.setTeacherInfo(this);

		return teacherSubAssign;
	}

	public TeacherSubAssign removeTeacherSubAssign(TeacherSubAssign teacherSubAssign) {
		getTeacherSubAssigns().remove(teacherSubAssign);
		teacherSubAssign.setTeacherInfo(null);

		return teacherSubAssign;
	}

}