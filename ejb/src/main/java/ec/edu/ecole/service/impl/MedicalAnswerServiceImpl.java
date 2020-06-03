package ec.edu.ecole.service.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import ec.edu.ecole.dao.MedicalAnswerDAO;
import ec.edu.ecole.exception.EducacionPersistException;
import ec.edu.ecole.exception.EducacionUpdateException;
import ec.edu.ecole.model.MedicalAnswer;
import ec.edu.ecole.service.MedicalAnswerService;

@Stateless
public class MedicalAnswerServiceImpl implements MedicalAnswerService {

	@EJB
	private MedicalAnswerDAO MedicalAnswerDAO;

	public List<MedicalAnswer> findAll() {
		return MedicalAnswerDAO.findAll();
	}

	@Override
	public MedicalAnswer findById(int id) {
		return MedicalAnswerDAO.findById(id);
	}

	@Override
	public void guardar(MedicalAnswer medicalAnswer) throws Exception {
		try {
			MedicalAnswer answer = getMedicalAnswerByStdidAndQuizid(medicalAnswer.getSchStudentInfo().getStdId(),
					medicalAnswer.getSchMedicalQuiz().getQuizId());
			if (answer == null) {
				MedicalAnswerDAO.persist(medicalAnswer);
			}
		} catch (EducacionPersistException e) {
			throw new Exception(e);
		}
	}

	@Override
	public void actualizar(MedicalAnswer medicalAnswer) throws Exception {
		try {
			MedicalAnswerDAO.update(medicalAnswer);
		} catch (EducacionUpdateException e) {
			throw new Exception(e);
		}
	}

	@Override
	public List<MedicalAnswer> getMedicalAnswerByStdId(int stdId) {
		return MedicalAnswerDAO.getMedicalAnswerByStdId(stdId);
	}

	@Override
	public MedicalAnswer getMedicalAnswerByStdidAndQuizid(int stdId, int quizId) {
		return MedicalAnswerDAO.getMedicalAnswerByStdidAndQuizid(stdId, quizId);
	}

}
