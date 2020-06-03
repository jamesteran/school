package ec.edu.ecole.dao;



import javax.ejb.Local;

import ec.edu.ecole.model.Transport;
/**
 * 
 * @author jt
 */
@Local
public interface TransportDAO extends GenericDAO<Transport, Integer>{
	
		
	public Transport getTransportByStdId(int stdId );
	

}
