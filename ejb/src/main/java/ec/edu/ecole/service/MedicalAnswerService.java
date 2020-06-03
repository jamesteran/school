package ec.edu.ecole.service;

import java.util.List;

import javax.ejb.Local;

import ec.edu.ecole.model.MedicalAnswer;

@Local
public interface MedicalAnswerService {

	public void guardar(MedicalAnswer medicalAnswer) throws Exception;

	public void actualizar(MedicalAnswer medicalAnswer) throws Exception;

	public List<MedicalAnswer> findAll();

	public MedicalAnswer findById(int id);

	public List<MedicalAnswer> getMedicalAnswerByStdId(int stdId);

	public MedicalAnswer getMedicalAnswerByStdidAndQuizid(int stdId, int quizId);

}
