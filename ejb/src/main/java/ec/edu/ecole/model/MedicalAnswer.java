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
 * The persistent class for the sch_medical_answers database table.
 * 
 */
@Entity
@Table(name = "sch_medical_answers")
@NamedQuery(name = "MedicalAnswer.findAll", query = "SELECT s FROM MedicalAnswer s")
public class MedicalAnswer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "answer_id")
	private int answerId;

	private byte active;

	@Column(name = "quiz_answer")
	private String quizAnswer;

	// bi-directional many-to-one association to MedicalQuiz
	@ManyToOne
	@JoinColumn(name = "quiz_id")
	private MedicalQuiz medicalQuiz;

	// bi-directional many-to-one association to StudentInfo
	@ManyToOne
	@JoinColumn(name = "std_id")
	private StudentInfo studentInfo;

	public MedicalAnswer() {
	}

	public int getAnswerId() {
		return this.answerId;
	}

	public void setAnswerId(int answerId) {
		this.answerId = answerId;
	}

	public byte getActive() {
		return this.active;
	}

	public void setActive(byte active) {
		this.active = active;
	}

	public String getQuizAnswer() {
		return this.quizAnswer;
	}

	public void setQuizAnswer(String quizAnswer) {
		this.quizAnswer = quizAnswer;
	}

	public MedicalQuiz getSchMedicalQuiz() {
		return this.medicalQuiz;
	}

	public void setSchMedicalQuiz(MedicalQuiz medicalQuiz) {
		this.medicalQuiz = medicalQuiz;
	}

	public StudentInfo getSchStudentInfo() {
		return this.studentInfo;
	}

	public void setSchStudentInfo(StudentInfo studentInfo) {
		this.studentInfo = studentInfo;
	}

}