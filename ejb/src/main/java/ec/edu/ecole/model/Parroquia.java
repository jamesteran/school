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
 * The persistent class for the sch_parroquia database table.
 * 
 */
@Entity
@Table(name = "sch_parroquia")
@NamedQuery(name = "Parroquia.findAll", query = "SELECT s FROM Parroquia s")
public class Parroquia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "parroquia_id")
	private Integer parroquiaId;

	private byte active;

	@Column(name = "country_code")
	private String countryCode;

	@Column(name = "province_code")
	private String province_code;

	@Column(name = "city_code")
	private String cityCode;

	@Column(name = "parroquia_name")
	private String parroquiaName;

	// bi-directional many-to-one association to Parent
	@OneToMany(mappedBy = "parroquia")
	private List<Parent> parents;

	// bi-directional many-to-one association to Parent
	@OneToMany(mappedBy = "parroquia")
	private List<Parent> students;

	public Parroquia() {
	}

	public Integer getParroquiaId() {
		return this.parroquiaId;
	}

	public void setParroquiaId(Integer parroquiaId) {
		this.parroquiaId = parroquiaId;
	}

	public byte getActive() {
		return this.active;
	}

	public void setActive(byte active) {
		this.active = active;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getProvince_code() {
		return province_code;
	}

	public void setProvince_code(String province_code) {
		this.province_code = province_code;
	}

	public String getCityCode() {
		return cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	public String getParroquiaName() {
		return parroquiaName;
	}

	public void setParroquiaName(String parroquiaName) {
		this.parroquiaName = parroquiaName;
	}

	public List<Parent> getParents() {
		return this.parents;
	}

	public void setParents(List<Parent> parents) {
		this.parents = parents;
	}

	public Parent addParent(Parent parent) {
		getParents().add(parent);
		parent.setParroquia(this);

		return parent;
	}

	public Parent removeParent(Parent parent) {
		getParents().remove(parent);
		parent.setParroquia(null);

		return parent;
	}

	public List<Parent> getStudents() {
		return students;
	}

	public void setStudents(List<Parent> students) {
		this.students = students;
	}

}