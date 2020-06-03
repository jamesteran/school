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
 * The persistent class for the sch_class_time_table_line database table.
 * 
 */
@Entity
@Table(name = "sch_class_time_table_line")
@NamedQuery(name = "ClassTimeTableLine.findAll", query = "SELECT s FROM ClassTimeTableLine s")
public class ClassTimeTableLine implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "tt_line_id")
	private int ttLineId;

	private String ttday;

	// bi-directional many-to-one association to DayPeriod
	@ManyToOne
	@JoinColumn(name = "dpid")
	private DayPeriod dayPeriod;

	// bi-directional many-to-one association to Subject
	@ManyToOne
	@JoinColumn(name = "subject_id")
	private Subject subject;

	// bi-directional many-to-one association to TeacherInfo
	@ManyToOne
	@JoinColumn(name = "teacher_id")
	private TeacherInfo teacherInfo;

	// bi-directional many-to-one association to TimeTable
	@ManyToOne
	@JoinColumn(name = "ttid")
	private TimeTable timeTable;

	public ClassTimeTableLine() {
	}

	public int getTtLineId() {
		return this.ttLineId;
	}

	public void setTtLineId(int ttLineId) {
		this.ttLineId = ttLineId;
	}

	public String getTtday() {
		return this.ttday;
	}

	public void setTtday(String ttday) {
		this.ttday = ttday;
	}

	public DayPeriod getDayPeriod() {
		return this.dayPeriod;
	}

	public void setDayPeriod(DayPeriod dayPeriod) {
		this.dayPeriod = dayPeriod;
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

	public TimeTable getTimeTable() {
		return this.timeTable;
	}

	public void setTimeTable(TimeTable timeTable) {
		this.timeTable = timeTable;
	}

}