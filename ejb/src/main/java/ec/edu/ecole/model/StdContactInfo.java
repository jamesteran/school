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
 * The persistent class for the sch_std_contact_info database table.
 * 
 */
@Entity
@Table(name = "sch_std_contact_info")
@NamedQuery(name = "StdContactInfo.findAll", query = "SELECT s FROM StdContactInfo s")
public class StdContactInfo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "contact_id")
	private int contactId;

	@Column(name = "mobile_no")
	private String mobileNo;

	@Column(name = "parmanent_addr")
	private String parmanentAddr;

	@Column(name = "present_addr")
	private String presentAddr;

	@Column(name = "tel_no")
	private String telNo;

	// bi-directional many-to-one association to StudentInfo
	@ManyToOne
	@JoinColumn(name = "std_id")
	private StudentInfo studentInfo;

	public StdContactInfo() {
	}

	public int getContactId() {
		return this.contactId;
	}

	public void setContactId(int contactId) {
		this.contactId = contactId;
	}

	public String getMobileNo() {
		return this.mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getParmanentAddr() {
		return this.parmanentAddr;
	}

	public void setParmanentAddr(String parmanentAddr) {
		this.parmanentAddr = parmanentAddr;
	}

	public String getPresentAddr() {
		return this.presentAddr;
	}

	public void setPresentAddr(String presentAddr) {
		this.presentAddr = presentAddr;
	}

	public String getTelNo() {
		return this.telNo;
	}

	public void setTelNo(String telNo) {
		this.telNo = telNo;
	}

	public StudentInfo getStudentInfo() {
		return this.studentInfo;
	}

	public void setStudentInfo(StudentInfo studentInfo) {
		this.studentInfo = studentInfo;
	}

}