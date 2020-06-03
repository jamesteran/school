package ec.edu.ecole.service.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import ec.edu.ecole.dao.MedicalQuizDAO;
import ec.edu.ecole.exception.EducacionPersistException;
import ec.edu.ecole.exception.EducacionUpdateException;
import ec.edu.ecole.model.MedicalQuiz;
import ec.edu.ecole.service.MedicalQuizService;

@Stateless
public class MedicalQuizServiceImpl implements MedicalQuizService {

	@EJB
	private MedicalQuizDAO MedicalQuizDAO;

	public List<MedicalQuiz> findAll() {
		return MedicalQuizDAO.findAll();
	}

	public List<MedicalQuiz> findAllActive() {
		return MedicalQuizDAO.findAllActive();
	}

	@Override
	public MedicalQuiz findById(int id) {
		return MedicalQuizDAO.findById(id);
	}

	@Override
	public void guardar(MedicalQuiz medicalQuiz) throws Exception {
		try {
			MedicalQuizDAO.persist(medicalQuiz);
		} catch (EducacionPersistException e) {
			throw new Exception(e);
		}
	}

	@Override
	public void actualizar(MedicalQuiz medicalQuiz) throws Exception {
		try {
			MedicalQuizDAO.update(medicalQuiz);
		} catch (EducacionUpdateException e) {
			throw new Exception(e);
		}
	}

}
