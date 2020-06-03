package ec.edu.ecole.dao.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.ecole.dao.MedicalAnswerDAO;
import ec.edu.ecole.model.MedicalAnswer;

@Stateless
public class MedicalAnswerDAOImpl extends GenericDAOImpl<MedicalAnswer, Integer> implements MedicalAnswerDAO {

	@SuppressWarnings("unchecked")
	@Override
	public List<MedicalAnswer> getMedicalAnswerByStdId(int stdId) {
		try {
			Query q = em.createQuery("Select distinct e From MedicalAnswer e " + " join fetch e.studentInfo s "
					+ " where s.stdId = :stdId ").setParameter("stdId", stdId);
			return q.getResultList();
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public MedicalAnswer getMedicalAnswerByStdidAndQuizid(int stdId, int quizId) {
		try {
			Query q = em.createQuery(
					"Select distinct e From MedicalAnswer e  join fetch e.studentInfo s join fetch e.medicalQuiz q"
							+ " where s.stdId = :stdId and q.quizId = :quizId")
					.setParameter("stdId", stdId).setParameter("quizId", quizId);
			return (MedicalAnswer) q.getSingleResult();
		} catch (Exception e) {
			return null;
		}
	}

}
