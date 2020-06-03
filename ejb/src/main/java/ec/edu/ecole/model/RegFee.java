package ec.edu.ecole.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the sch_reg_fee database table.
 * 
 */
@Entity
@Table(name = "sch_reg_fee")
@NamedQuery(name = "RegFee.findAll", query = "SELECT s FROM RegFee s")
public class RegFee implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "fee_id")
	private int feeId;

	@Column(name = "fee_amount")
	private double feeAmount;

	@Temporal(TemporalType.DATE)
	@Column(name = "pay_date")
	private Date payDate;

	// bi-directional many-to-one association to Registration
	@ManyToOne
	@JoinColumn(name = "reg_id")
	private Registration registration;

	public RegFee() {
	}

	public int getFeeId() {
		return this.feeId;
	}

	public void setFeeId(int feeId) {
		this.feeId = feeId;
	}

	public double getFeeAmount() {
		return this.feeAmount;
	}

	public void setFeeAmount(double feeAmount) {
		this.feeAmount = feeAmount;
	}

	public Date getPayDate() {
		return this.payDate;
	}

	public void setPayDate(Date payDate) {
		this.payDate = payDate;
	}

	public Registration getStdRegistration() {
		return this.registration;
	}

	public void setStdRegistration(Registration registration) {
		this.registration = registration;
	}

}