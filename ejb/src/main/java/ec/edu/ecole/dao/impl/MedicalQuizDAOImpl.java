package ec.edu.ecole.dao.impl;

import javax.ejb.Stateless;

import ec.edu.ecole.dao.MedicalQuizDAO;
import ec.edu.ecole.model.MedicalQuiz;

@Stateless
public class MedicalQuizDAOImpl extends GenericDAOImpl<MedicalQuiz, Integer> implements MedicalQuizDAO {

}
