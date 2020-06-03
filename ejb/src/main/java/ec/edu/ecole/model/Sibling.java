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
 * The persistent class for the sch_sibling database table.
 * 
 */
@Entity
@Table(name = "sch_sibling")
@NamedQuery(name = "Sibling.findAll", query = "SELECT s FROM Sibling s")
public class Sibling implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "sib_id")
	private int sibId;

	private byte active;

	// bi-directional many-to-one association to StudentInfo
	@ManyToOne
	@JoinColumn(name = "std_id")
	private StudentInfo studentInfo1;

	// bi-directional many-to-one association to StudentInfo
	@ManyToOne
	@JoinColumn(name = "sib_std_id")
	private StudentInfo studentInfo2;

	public Sibling() {
	}

	public int getSibId() {
		return this.sibId;
	}

	public void setSibId(int sibId) {
		this.sibId = sibId;
	}

	public byte getActive() {
		return this.active;
	}

	public void setActive(byte active) {
		this.active = active;
	}

	public StudentInfo getStudentInfo1() {
		return this.studentInfo1;
	}

	public void setStudentInfo1(StudentInfo schStudentInfo1) {
		this.studentInfo1 = schStudentInfo1;
	}

	public StudentInfo getStudentInfo2() {
		return this.studentInfo2;
	}

	public void setStudentInfo2(StudentInfo schStudentInfo2) {
		this.studentInfo2 = schStudentInfo2;
	}

}