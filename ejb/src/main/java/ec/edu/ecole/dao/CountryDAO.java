package ec.edu.ecole.dao;

import javax.ejb.Local;

import ec.edu.ecole.model.Country;

/**
 * 
 * @author jt
 */
@Local
public interface CountryDAO extends GenericDAO<Country, Long> {

}
