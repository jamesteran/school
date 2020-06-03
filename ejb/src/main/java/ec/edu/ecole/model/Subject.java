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
 * The persistent class for the sch_subject database table.
 * 
 */
@Entity
@Table(name = "sch_subject")
@NamedQuery(name = "Subject.findAll", query = "SELECT s FROM Subject s")
public class Subject implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "subject_id")
	private int subjectId;

	private byte active;

	@Column(name = "subject_code")
	private int subjectCode;

	@Column(name = "subject_name")
	private String subjectName;

	// bi-directional many-to-one association to ClassTimeTableLine
	@OneToMany(mappedBy = "subject")
	private List<ClassTimeTableLine> classTimeTableLines;

	// bi-directional many-to-one association to StdMark
	@OneToMany(mappedBy = "subject")
	private List<StdMark> stdMarks;

	// bi-directional many-to-one association to TeacherInfo
	@OneToMany(mappedBy = "subject")
	private List<TeacherInfo> teacherInfos;

	// bi-directional many-to-one association to TeacherSubAssign
	@OneToMany(mappedBy = "subject")
	private List<TeacherSubAssign> teacherSubAssigns;

	public Subject() {
	}

	public int getSubjectId() {
		return this.subjectId;
	}

	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}

	public byte getActive() {
		return this.active;
	}

	public void setActive(byte active) {
		this.active = active;
	}

	public int getSubjectCode() {
		return this.subjectCode;
	}

	public void setSubjectCode(int subjectCode) {
		this.subjectCode = subjectCode;
	}

	public String getSubjectName() {
		return this.subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public List<ClassTimeTableLine> getClassTimeTableLines() {
		return this.classTimeTableLines;
	}

	public void setClassTimeTableLines(List<ClassTimeTableLine> classTimeTableLines) {
		this.classTimeTableLines = classTimeTableLines;
	}

	public ClassTimeTableLine addClassTimeTableLine(ClassTimeTableLine classTimeTableLine) {
		getClassTimeTableLines().add(classTimeTableLine);
		classTimeTableLine.setSubject(this);

		return classTimeTableLine;
	}

	public ClassTimeTableLine removeClassTimeTableLine(ClassTimeTableLine classTimeTableLine) {
		getClassTimeTableLines().remove(classTimeTableLine);
		classTimeTableLine.setSubject(null);

		return classTimeTableLine;
	}

	public List<StdMark> getStdMarks() {
		return this.stdMarks;
	}

	public void setStdMarks(List<StdMark> stdMarks) {
		this.stdMarks = stdMarks;
	}

	public StdMark addStdMark(StdMark stdMark) {
		getStdMarks().add(stdMark);
		stdMark.setSubject(this);

		return stdMark;
	}

	public StdMark removeStdMark(StdMark stdMark) {
		getStdMarks().remove(stdMark);
		stdMark.setSubject(null);

		return stdMark;
	}

	public List<TeacherInfo> getTeacherInfos() {
		return this.teacherInfos;
	}

	public void setTeacherInfos(List<TeacherInfo> teacherInfos) {
		this.teacherInfos = teacherInfos;
	}

	public TeacherInfo addTeacherInfo(TeacherInfo teacherInfo) {
		getTeacherInfos().add(teacherInfo);
		teacherInfo.setSubject(this);

		return teacherInfo;
	}

	public TeacherInfo removeTeacherInfo(TeacherInfo teacherInfo) {
		getTeacherInfos().remove(teacherInfo);
		teacherInfo.setSubject(null);

		return teacherInfo;
	}

	public List<TeacherSubAssign> getTeacherSubAssigns() {
		return this.teacherSubAssigns;
	}

	public void setTeacherSubAssigns(List<TeacherSubAssign> teacherSubAssigns) {
		this.teacherSubAssigns = teacherSubAssigns;
	}

	public TeacherSubAssign addTeacherSubAssign(TeacherSubAssign teacherSubAssign) {
		getTeacherSubAssigns().add(teacherSubAssign);
		teacherSubAssign.setSubject(this);

		return teacherSubAssign;
	}

	public TeacherSubAssign removeTeacherSubAssign(TeacherSubAssign teacherSubAssign) {
		getTeacherSubAssigns().remove(teacherSubAssign);
		teacherSubAssign.setSubject(null);

		return teacherSubAssign;
	}

}