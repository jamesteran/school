package ec.edu.ecole.dao.impl;

import java.util.List;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.ecole.dao.RegistrationDAO;
import ec.edu.ecole.model.Registration;

@Stateless
public class RegistrationDAOImpl extends GenericDAOImpl<Registration, Integer> implements RegistrationDAO {

	private static final Logger LOG = Logger.getLogger(RegistrationDAOImpl.class.getName());

	@SuppressWarnings("unchecked")
	@Override
	public List<Registration> getRegistrationByStdId(int stdId) {
		try {
			Query q = em
					.createQuery("Select distinct e From Registration e join fetch e.studentInfo s "
							+ "join fetch e.academicYear a where s.stdId = :stdId and e.active = 1 and a.open = 1")
					.setParameter("stdId", stdId);
			return q.getResultList();
		} catch (Exception e) {
			LOG.severe(String.format("getRegistrationByStdId():Exception: " + e.getMessage(), ""));
			return null;
		}
	}

	@Override
	public Registration getRegistrationByStdAndYear(int stdId, int acyid) {
		try {
			Query q = em.createQuery("Select distinct e From Registration e join fetch e.studentInfo s "
					+ "join fetch e.academicYear a where s.stdId = :stdId and e.active = 1 and a.acyid = :acyid")
					.setParameter("stdId", stdId).setParameter("acyid", acyid);
			return (Registration) q.getSingleResult();
		} catch (Exception e) {
			LOG.severe(String.format("getRegistrationByStdAndYear():Exception: " + e.getMessage(), ""));
			return null;
		}
	}
}
