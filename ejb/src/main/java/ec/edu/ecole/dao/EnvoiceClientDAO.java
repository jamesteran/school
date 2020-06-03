package ec.edu.ecole.dao;

import javax.ejb.Local;

import ec.edu.ecole.model.EnvoiceClient;

/**
 * 
 * @author jt
 */
@Local
public interface EnvoiceClientDAO extends GenericDAO<EnvoiceClient, Integer> {

	public EnvoiceClient getEnvoiceByStdId(int stdId);

}
