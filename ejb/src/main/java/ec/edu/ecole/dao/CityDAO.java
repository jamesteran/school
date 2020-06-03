package ec.edu.ecole.dao;

import javax.ejb.Local;

import ec.edu.ecole.model.City;

/**
 * 
 * @author jt
 */
@Local
public interface CityDAO extends GenericDAO<City, Long> {

}
