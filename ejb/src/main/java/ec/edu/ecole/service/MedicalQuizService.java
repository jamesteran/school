package ec.edu.ecole.service;

import java.util.List;

import javax.ejb.Local;

import ec.edu.ecole.model.MedicalQuiz;

@Local
public interface MedicalQuizService {

	public void guardar(MedicalQuiz medicalQuiz) throws Exception;

	public void actualizar(MedicalQuiz medicalQuiz) throws Exception;

	public List<MedicalQuiz> findAll();

	public List<MedicalQuiz> findAllActive();

	public MedicalQuiz findById(int id);

}
