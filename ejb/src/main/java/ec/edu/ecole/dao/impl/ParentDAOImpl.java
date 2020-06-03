package ec.edu.ecole.dao.impl;

import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.ecole.dao.ParentDAO;
import ec.edu.ecole.model.Parent;

@Stateless
public class ParentDAOImpl extends GenericDAOImpl<Parent, Integer> implements ParentDAO {

	private static final Logger LOG = Logger.getLogger(ParentDAOImpl.class.getName());

	@Override
	public Parent getPhaByStudentAdnType(int studenId, int prntType) {
		try {
			Query q = em.createQuery("Select distinct p From Parent p " + " join fetch p.student s "
					+ " join fetch p.parentType pt " + " where s.stdId = :studenId " + " and pt.prntypeId = :prntType")
					.setParameter("studenId", studenId).setParameter("prntType", prntType);
			return (Parent) q.getSingleResult();
		} catch (Exception e) {
			LOG.severe(String.format("getPhaByStudentAdnType():Exception: " + e.getMessage(), ""));
			return null;
		}
	}

	@Override
	public Parent getPharentByCedula(String cedula) {
		try {
			Query q = em
					.createQuery("Select distinct p From Parent p " + " join fetch p.user u "
							+ " join fetch p.parroquia pa " + " where p.idNumber = :cedula ")
					.setParameter("cedula", cedula);
			return (Parent) q.getSingleResult();
		} catch (Exception e) {
			LOG.severe(String.format("getPharentByCedula():Exception: " + e.getMessage(), ""));
			return null;
		}
	}
}
