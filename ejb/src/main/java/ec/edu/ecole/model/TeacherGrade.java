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
 * The persistent class for the sch_teacher_grade database table.
 * 
 */
@Entity
@Table(name = "sch_teacher_grade")
@NamedQuery(name = "TeacherGrade.findAll", query = "SELECT s FROM TeacherGrade s")
public class TeacherGrade implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "teacher_grade_id")
	private int teacherGradeId;

	@Column(name = "teacher_grade")
	private String teacherGrade;

	// bi-directional many-to-one association to TeacherInfo
	@OneToMany(mappedBy = "teacherGrade")
	private List<TeacherInfo> teacherInfos;

	public TeacherGrade() {
	}

	public int getTeacherGradeId() {
		return this.teacherGradeId;
	}

	public void setTeacherGradeId(int teacherGradeId) {
		this.teacherGradeId = teacherGradeId;
	}

	public String getTeacherGrade() {
		return this.teacherGrade;
	}

	public void setTeacherGrade(String teacherGrade) {
		this.teacherGrade = teacherGrade;
	}

	public List<TeacherInfo> getTeacherInfos() {
		return this.teacherInfos;
	}

	public void setTeacherInfos(List<TeacherInfo> teacherInfos) {
		this.teacherInfos = teacherInfos;
	}

	public TeacherInfo addTeacherInfo(TeacherInfo teacherInfo) {
		getTeacherInfos().add(teacherInfo);
		teacherInfo.setTeacherGrade(this);

		return teacherInfo;
	}

	public TeacherInfo removeTeacherInfo(TeacherInfo teacherInfo) {
		getTeacherInfos().remove(teacherInfo);
		teacherInfo.setTeacherGrade(null);

		return teacherInfo;
	}

}