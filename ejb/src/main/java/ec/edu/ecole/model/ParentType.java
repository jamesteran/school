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
 * The persistent class for the sch_parent_type database table.
 * 
 */
@Entity
@Table(name = "sch_parent_type")
@NamedQuery(name = "ParentType.findAll", query = "SELECT s FROM ParentType s")
public class ParentType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "prntype_id")
	private int prntypeId;

	private byte active;

	@Column(name = "prntype_name")
	private String prntypeName;

	// bi-directional many-to-one association to StudentInfo
	@OneToMany(mappedBy = "parentType")
	private List<Parent> parents;

	public ParentType() {
	}

	public byte getActive() {
		return this.active;
	}

	public void setActive(byte active) {
		this.active = active;
	}

	public int getPrntypeId() {
		return prntypeId;
	}

	public void setPrntypeId(int prntypeId) {
		this.prntypeId = prntypeId;
	}

	public String getPrntypeName() {
		return prntypeName;
	}

	public void setPrntypeName(String prntypeName) {
		this.prntypeName = prntypeName;
	}

	public List<Parent> getParents() {
		return parents;
	}

	public void setParents(List<Parent> parents) {
		this.parents = parents;
	}

}