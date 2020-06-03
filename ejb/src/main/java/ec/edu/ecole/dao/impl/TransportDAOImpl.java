package ec.edu.ecole.dao.impl;




import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.ecole.dao.TransportDAO;
import ec.edu.ecole.model.Transport;

@Stateless
public class TransportDAOImpl extends GenericDAOImpl<Transport, Integer> 
	implements TransportDAO {

	
	
	@Override
	public Transport getTransportByStdId(int stdId ){
		try {
			Query q = em.createQuery("Select distinct e From Transport e "
					+ " join fetch e.StudentInfo s " 
					+ " where s.StdId = :stdId ")
					.setParameter("stdId", stdId);
			return (Transport) q.getSingleResult();
		} catch (Exception e) {
			return null;
		}
	}
}
