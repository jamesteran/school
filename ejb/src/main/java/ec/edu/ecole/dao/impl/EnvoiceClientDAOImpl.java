package ec.edu.ecole.dao.impl;

import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.ecole.dao.EnvoiceClientDAO;
import ec.edu.ecole.model.EnvoiceClient;

@Stateless
public class EnvoiceClientDAOImpl extends GenericDAOImpl<EnvoiceClient, Integer> implements EnvoiceClientDAO {

	@Override
	public EnvoiceClient getEnvoiceByStdId(int stdId) {
		System.out.println("ENTRA FACTURA");
		try {
			Query q = em.createQuery("Select distinct e From EnvoiceClient e " + " join fetch e.studentInfo s "
					+ " where s.stdId = :stdId ").setParameter("stdId", stdId);
			return (EnvoiceClient) q.getSingleResult();
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
}
