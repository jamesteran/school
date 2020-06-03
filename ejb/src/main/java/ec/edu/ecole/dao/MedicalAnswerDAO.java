package ec.edu.ecole.dao;

import java.util.List;

import javax.ejb.Local;

import ec.edu.ecole.model.MedicalAnswer;

/**
 * 
 * @author jt
 */
@Local
public interface MedicalAnswerDAO extends GenericDAO<MedicalAnswer, Integer> {

	public List<MedicalAnswer> getMedicalAnswerByStdId(int stdId);

	public MedicalAnswer getMedicalAnswerByStdidAndQuizid(int stdId, int quizId);

}
