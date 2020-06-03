package ec.edu.ecole.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the sch_transport database table.
 * 
 */
@Entity
@Table(name = "sch_transport")
@NamedQuery(name = "Transport.findAll", query = "SELECT s FROM Transport s")
public class Transport implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "transport_id")
	private int transportId;

	private byte active;

	@Column(name = "need_trans", columnDefinition = "INT(1)")
	private boolean needTrans;

	@Column(name = "pup_addr_morn")
	private String pupAddrMorn;

	@Column(name = "pup_addr_noon")
	private String pupAddrNoon;

	@Column(name = "pup_coord_morn")
	private String pupCoordMorn;

	@Column(name = "pup_coord_noon")
	private String pupCoordNoon;

	@Lob
	@Column(name = "trans_photo_morn")
	private byte[] transPhotoMorn;

	@Lob
	@Column(name = "trans_photo_noon")
	private byte[] transPhotoNoon;

	@Column(name = "trans_type")
	private String transType;

	// bi-directional many-to-one association to StudentInfo
	@ManyToOne
	@JoinColumn(name = "std_id")
	private StudentInfo studentInfo;

	public Transport() {
	}

	public int getTransportId() {
		return this.transportId;
	}

	public void setTransportId(int transportId) {
		this.transportId = transportId;
	}

	public byte getActive() {
		return this.active;
	}

	public void setActive(byte active) {
		this.active = active;
	}

	public String getPupAddrMorn() {
		return this.pupAddrMorn;
	}

	public void setPupAddrMorn(String pupAddrMorn) {
		this.pupAddrMorn = pupAddrMorn;
	}

	public String getPupAddrNoon() {
		return this.pupAddrNoon;
	}

	public void setPupAddrNoon(String pupAddrNoon) {
		this.pupAddrNoon = pupAddrNoon;
	}

	public String getPupCoordMorn() {
		return this.pupCoordMorn;
	}

	public void setPupCoordMorn(String pupCoordMorn) {
		this.pupCoordMorn = pupCoordMorn;
	}

	public String getPupCoordNoon() {
		return this.pupCoordNoon;
	}

	public void setPupCoordNoon(String pupCoordNoon) {
		this.pupCoordNoon = pupCoordNoon;
	}

	public byte[] getTransPhotoMorn() {
		return this.transPhotoMorn;
	}

	public void setTransPhotoMorn(byte[] transPhotoMorn) {
		this.transPhotoMorn = transPhotoMorn;
	}

	public byte[] getTransPhotoNoon() {
		return this.transPhotoNoon;
	}

	public void setTransPhotoNoon(byte[] transPhotoNoon) {
		this.transPhotoNoon = transPhotoNoon;
	}

	public String getTransType() {
		return this.transType;
	}

	public void setTransType(String transType) {
		this.transType = transType;
	}

	public StudentInfo getStudentInfo() {
		return this.studentInfo;
	}

	public void setStudentInfo(StudentInfo studentInfo) {
		this.studentInfo = studentInfo;
	}

	public boolean isNeedTrans() {
		return needTrans;
	}

	public void setNeedTrans(boolean needTrans) {
		this.needTrans = needTrans;
	}

}