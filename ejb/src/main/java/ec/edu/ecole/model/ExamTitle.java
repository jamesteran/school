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
 * The persistent class for the sch_exam_title database table.
 * 
 */
@Entity
@Table(name = "sch_exam_title")
@NamedQuery(name = "ExamTitle.findAll", query = "SELECT s FROM ExamTitle s")
public class ExamTitle implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ex_tt_id")
	private int exTtId;

	private String description;

	@Column(name = "exam_title")
	private String examTitle;

	// bi-directional many-to-one association to StdMark
	@OneToMany(mappedBy = "examTitle")
	private List<StdMark> stdMarks;

	public ExamTitle() {
	}

	public int getExTtId() {
		return this.exTtId;
	}

	public void setExTtId(int exTtId) {
		this.exTtId = exTtId;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getExamTitle() {
		return this.examTitle;
	}

	public void setExamTitle(String examTitle) {
		this.examTitle = examTitle;
	}

	public List<StdMark> getStdMarks() {
		return this.stdMarks;
	}

	public void setStdMarks(List<StdMark> stdMarks) {
		this.stdMarks = stdMarks;
	}

	public StdMark addStdMark(StdMark stdMark) {
		getStdMarks().add(stdMark);
		stdMark.setExamTitle(this);

		return stdMark;
	}

	public StdMark removeStdMark(StdMark stdMark) {
		getStdMarks().remove(stdMark);
		stdMark.setExamTitle(null);

		return stdMark;
	}

}