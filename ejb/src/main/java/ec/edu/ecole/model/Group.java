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
 * The persistent class for the sch_std_group database table.
 * 
 */
@Entity
@Table(name = "sch_std_group")
@NamedQuery(name = "Group.findAll", query = "SELECT s FROM Group s")
public class Group implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "group_id")
	private int groupId;

	@Column(name = "group_name")
	private String groupName;

	@Column(name = "group_status")
	private byte groupStatus;

	// bi-directional many-to-one association to StdAttendance
	@OneToMany(mappedBy = "group")
	private List<StdAttendance> stdAttendances;

	// bi-directional many-to-one association to StdMark
	@OneToMany(mappedBy = "group")
	private List<StdMark> stdMarks;

	// bi-directional many-to-one association to Registration
	@OneToMany(mappedBy = "group")
	private List<Registration> registrations;

	// bi-directional many-to-one association to TimeTable
	@OneToMany(mappedBy = "group")
	private List<TimeTable> timeTables;

	public Group() {
	}

	public int getGroupId() {
		return this.groupId;
	}

	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}

	public String getGroupName() {
		return this.groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public byte getGroupStatus() {
		return this.groupStatus;
	}

	public void setGroupStatus(byte groupStatus) {
		this.groupStatus = groupStatus;
	}

	public List<StdAttendance> getStdAttendances() {
		return this.stdAttendances;
	}

	public void setStdAttendances(List<StdAttendance> stdAttendances) {
		this.stdAttendances = stdAttendances;
	}

	public StdAttendance addStdAttendance(StdAttendance stdAttendance) {
		getStdAttendances().add(stdAttendance);
		stdAttendance.setStdGroup(this);

		return stdAttendance;
	}

	public StdAttendance removeStdAttendance(StdAttendance stdAttendance) {
		getStdAttendances().remove(stdAttendance);
		stdAttendance.setStdGroup(null);

		return stdAttendance;
	}

	public List<StdMark> getStdMarks() {
		return this.stdMarks;
	}

	public void setStdMarks(List<StdMark> stdMarks) {
		this.stdMarks = stdMarks;
	}

	public StdMark addStdMark(StdMark stdMark) {
		getStdMarks().add(stdMark);
		stdMark.setStdGroup(this);

		return stdMark;
	}

	public StdMark removeStdMark(StdMark stdMark) {
		getStdMarks().remove(stdMark);
		stdMark.setStdGroup(null);

		return stdMark;
	}

	public List<Registration> getStdRegistrations() {
		return this.registrations;
	}

	public void setStdRegistrations(List<Registration> registrations) {
		this.registrations = registrations;
	}

	public Registration addStdRegistration(Registration registration) {
		getStdRegistrations().add(registration);
		registration.setStdGroup(this);

		return registration;
	}

	public Registration removeStdRegistration(Registration registration) {
		getStdRegistrations().remove(registration);
		registration.setStdGroup(null);

		return registration;
	}

	public List<TimeTable> getTimeTables() {
		return this.timeTables;
	}

	public void setTimeTables(List<TimeTable> timeTables) {
		this.timeTables = timeTables;
	}

	public TimeTable addTimeTable(TimeTable timeTable) {
		getTimeTables().add(timeTable);
		timeTable.setStdGroup(this);

		return timeTable;
	}

	public TimeTable removeTimeTable(TimeTable timeTable) {
		getTimeTables().remove(timeTable);
		timeTable.setStdGroup(null);

		return timeTable;
	}

}