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
 * The persistent class for the sch_teacher_sub_assign database table.
 * 
 */
@Entity
@Table(name = "sch_teacher_sub_assign")
@NamedQuery(name = "TeacherSubAssign.findAll", query = "SELECT s FROM TeacherSubAssign s")
public class TeacherSubAssign implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "teach_sub_assign_id")
	private int teachSubAssignId;

	// bi-directional many-to-one association to SectionName
	@ManyToOne
	@JoinColumn(name = "section_id")
	private SectionName sectionName;

	// bi-directional many-to-one association to Subject
	@ManyToOne
	@JoinColumn(name = "subject_id")
	private Subject subject;

	// bi-directional many-to-one association to TeacherInfo
	@ManyToOne
	@JoinColumn(name = "teacher_id")
	private TeacherInfo teacherInfo;

	public TeacherSubAssign() {
	}

	public int getTeachSubAssignId() {
		return this.teachSubAssignId;
	}

	public void setTeachSubAssignId(int teachSubAssignId) {
		this.teachSubAssignId = teachSubAssignId;
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

	public TeacherInfo getTeacherInfo() {
		return this.teacherInfo;
	}

	public void setTeacherInfo(TeacherInfo teacherInfo) {
		this.teacherInfo = teacherInfo;
	}

}