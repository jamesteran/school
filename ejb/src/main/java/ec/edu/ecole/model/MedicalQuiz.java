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
 * The persistent class for the sch_medical_quiz database table.
 * 
 */
@Entity
@Table(name = "sch_medical_quiz")
@NamedQuery(name = "MedicalQuiz.findAll", query = "SELECT s FROM MedicalQuiz s")
public class MedicalQuiz implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "quiz_id")
	private int quizId;

	private byte active;

	@Column(name = "quiz_message")
	private String quizMessage;

	@Column(name = "quiz_question")
	private String quizQuestion;

	// bi-directional many-to-one association to MedicalAnswer
	@OneToMany(mappedBy = "medicalQuiz")
	private List<MedicalAnswer> medicalAnswers;

	public MedicalQuiz() {
	}

	public int getQuizId() {
		return this.quizId;
	}

	public void setQuizId(int quizId) {
		this.quizId = quizId;
	}

	public byte getActive() {
		return this.active;
	}

	public void setActive(byte active) {
		this.active = active;
	}

	public String getQuizMessage() {
		return this.quizMessage;
	}

	public void setQuizMessage(String quizMessage) {
		this.quizMessage = quizMessage;
	}

	public String getQuizQuestion() {
		return this.quizQuestion;
	}

	public void setQuizQuestion(String quizQuestion) {
		this.quizQuestion = quizQuestion;
	}

	public List<MedicalAnswer> getSchMedicalAnswers() {
		return this.medicalAnswers;
	}

	public void setSchMedicalAnswers(List<MedicalAnswer> medicalAnswers) {
		this.medicalAnswers = medicalAnswers;
	}

	public MedicalAnswer addSchMedicalAnswer(MedicalAnswer medicalAnswer) {
		getSchMedicalAnswers().add(medicalAnswer);
		medicalAnswer.setSchMedicalQuiz(this);

		return medicalAnswer;
	}

	public MedicalAnswer removeSchMedicalAnswer(MedicalAnswer medicalAnswer) {
		getSchMedicalAnswers().remove(medicalAnswer);
		medicalAnswer.setSchMedicalQuiz(null);

		return medicalAnswer;
	}

}