package ec.edu.ecole.dao.impl;

import java.util.List;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.ecole.dao.CustodianDAO;
import ec.edu.ecole.model.Custodian;

@Stateless
public class CustodianDAOImpl extends GenericDAOImpl<Custodian, Integer> implements CustodianDAO {
	private static final Logger LOG = Logger.getLogger(CustodianDAOImpl.class.getName());

	@SuppressWarnings("unchecked")
	@Override
	public List<Custodian> buscarCustodiansByStdId(int stdId) {
		try {
			Query q = em.createQuery(
					"Select distinct e From Custodian e  join fetch e.studentInfo s where s.stdId = :stdId and e.active = 1 ")
					.setParameter("stdId", stdId);
			return q.getResultList();
		} catch (Exception e) {
			LOG.severe(String.format("buscarCustodiansByStdId():Exception: " + e.getMessage(), ""));
			return null;
		}
	}

	@Override
	public Custodian getCustodianByCedula(String cedula) {
		try {
			Query q = em.createQuery("Select distinct c From Custodian c  where c.idNumber = :cedula ")
					.setParameter("cedula", cedula);
			return (Custodian) q.getSingleResult();
		} catch (Exception e) {
			LOG.severe(String.format("getCustodianByCedula():Exception: " + e.getMessage(), ""));
			return null;
		}
	}
}
