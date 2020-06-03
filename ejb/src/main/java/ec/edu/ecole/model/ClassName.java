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
 * The persistent class for the sch_class_name database table.
 * 
 */
@Entity
@Table(name = "sch_class_name")
@NamedQuery(name = "ClassName.findAll", query = "SELECT s FROM ClassName s")
public class ClassName implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "class_id")
	private int classId;

	@Column(name = "class_name")
	private String className;

	@Column(name = "class_desc")
	private String classDesc;

	@Column(name = "class_nivel")
	private int classNivel;

	// bi-directional many-to-one association to SectionName
	@OneToMany(mappedBy = "className")
	private List<SectionName> sectionNames;

	// bi-directional many-to-one association to TimeTable
	@OneToMany(mappedBy = "className")
	private List<TimeTable> timeTables;

	public ClassName() {
	}

	public int getClassId() {
		return this.classId;
	}

	public void setClassId(int classId) {
		this.classId = classId;
	}

	public String getClassName() {
		return this.className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public List<SectionName> getSectionNames() {
		return this.sectionNames;
	}

	public void setSectionNames(List<SectionName> sectionNames) {
		this.sectionNames = sectionNames;
	}

	public SectionName addSectionName(SectionName sectionName) {
		getSectionNames().add(sectionName);
		sectionName.setClassName(this);

		return sectionName;
	}

	public SectionName removeSectionName(SectionName sectionName) {
		getSectionNames().remove(sectionName);
		sectionName.setClassName(null);

		return sectionName;
	}

	public List<TimeTable> getTimeTables() {
		return this.timeTables;
	}

	public void setTimeTables(List<TimeTable> timeTables) {
		this.timeTables = timeTables;
	}

	public TimeTable addTimeTable(TimeTable timeTable) {
		getTimeTables().add(timeTable);
		timeTable.setClassName(this);

		return timeTable;
	}

	public TimeTable removeSchTimeTable(TimeTable timeTable) {
		getTimeTables().remove(timeTable);
		timeTable.setClassName(null);

		return timeTable;
	}

	public String getClassDesc() {
		return classDesc;
	}

	public void setClassDesc(String classDesc) {
		this.classDesc = classDesc;
	}

	public int getClassNivel() {
		return classNivel;
	}

	public void setClassNivel(int classNivel) {
		this.classNivel = classNivel;
	}

}