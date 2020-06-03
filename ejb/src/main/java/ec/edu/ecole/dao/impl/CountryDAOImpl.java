package ec.edu.ecole.dao.impl;

import javax.ejb.Stateless;

import ec.edu.ecole.dao.CountryDAO;
import ec.edu.ecole.model.Country;

@Stateless
public class CountryDAOImpl extends GenericDAOImpl<Country, Long> implements CountryDAO {

}
