package ec.edu.ecole.model;

import java.io.Serializable;
import java.util.List;

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
 * The persistent class for the sch_time_table database table.
 * 
 */
@Entity
@Table(name = "sch_time_table")
@NamedQuery(name = "TimeTable.findAll", query = "SELECT s FROM TimeTable s")
public class TimeTable implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ttid;

	// bi-directional many-to-one association to ClassTimeTableLine
	@OneToMany(mappedBy = "timeTable")
	private List<ClassTimeTableLine> classTimeTableLines;

	// bi-directional many-to-one association to ClassName
	@ManyToOne
	@JoinColumn(name = "class_id")
	private ClassName className;

	// bi-directional many-to-one association to Group
	@ManyToOne
	@JoinColumn(name = "group_id")
	private Group group;

	// bi-directional many-to-one association to SectionName
	@ManyToOne
	@JoinColumn(name = "section_id")
	private SectionName sectionName;

	public TimeTable() {
	}

	public int getTtid() {
		return this.ttid;
	}

	public void setTtid(int ttid) {
		this.ttid = ttid;
	}

	public List<ClassTimeTableLine> getClassTimeTableLines() {
		return this.classTimeTableLines;
	}

	public void setClassTimeTableLines(List<ClassTimeTableLine> classTimeTableLines) {
		this.classTimeTableLines = classTimeTableLines;
	}

	public ClassTimeTableLine addClassTimeTableLine(ClassTimeTableLine classTimeTableLine) {
		getClassTimeTableLines().add(classTimeTableLine);
		classTimeTableLine.setTimeTable(this);

		return classTimeTableLine;
	}

	public ClassTimeTableLine removeClassTimeTableLine(ClassTimeTableLine classTimeTableLine) {
		getClassTimeTableLines().remove(classTimeTableLine);
		classTimeTableLine.setTimeTable(null);

		return classTimeTableLine;
	}

	public ClassName getClassName() {
		return this.className;
	}

	public void setClassName(ClassName className) {
		this.className = className;
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

}