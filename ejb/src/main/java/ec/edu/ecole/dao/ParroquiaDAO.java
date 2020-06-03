package ec.edu.ecole.dao;



import java.util.List;

import javax.ejb.Local;

import ec.edu.ecole.model.Parroquia;

/**
 * 
 * @author jt
 */
@Local
public interface ParroquiaDAO extends GenericDAO<Parroquia, Long>{
	
	public List<Parroquia> getByCityName(String cityName );
	

}
