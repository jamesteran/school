package ec.edu.ecole.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * The persistent class for the sch_day_period database table.
 * 
 */
@Entity
@Table(name = "sch_day_period")
@NamedQuery(name = "DayPeriod.findAll", query = "SELECT s FROM DayPeriod s")
public class DayPeriod implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int dpid;

	private String dptime;

	// bi-directional many-to-one association to ClassTimeTableLine
	@OneToMany(mappedBy = "dayPeriod")
	private List<ClassTimeTableLine> classTimeTableLines;

	public DayPeriod() {
	}

	public int getDpid() {
		return this.dpid;
	}

	public void setDpid(int dpid) {
		this.dpid = dpid;
	}

	public String getDptime() {
		return this.dptime;
	}

	public void setDptime(String dptime) {
		this.dptime = dptime;
	}

	public List<ClassTimeTableLine> getClassTimeTableLines() {
		return this.classTimeTableLines;
	}

	public void setClassTimeTableLines(List<ClassTimeTableLine> classTimeTableLines) {
		this.classTimeTableLines = classTimeTableLines;
	}

	public ClassTimeTableLine addClassTimeTableLine(ClassTimeTableLine classTimeTableLine) {
		getClassTimeTableLines().add(classTimeTableLine);
		classTimeTableLine.setDayPeriod(this);

		return classTimeTableLine;
	}

	public ClassTimeTableLine removeClassTimeTableLine(ClassTimeTableLine classTimeTableLine) {
		getClassTimeTableLines().remove(classTimeTableLine);
		classTimeTableLine.setDayPeriod(null);

		return classTimeTableLine;
	}

}