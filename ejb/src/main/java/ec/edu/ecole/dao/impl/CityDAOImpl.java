package ec.edu.ecole.dao.impl;

import javax.ejb.Stateless;

import ec.edu.ecole.dao.CityDAO;
import ec.edu.ecole.model.City;

@Stateless
public class CityDAOImpl extends GenericDAOImpl<City, Long> implements CityDAO {

}
