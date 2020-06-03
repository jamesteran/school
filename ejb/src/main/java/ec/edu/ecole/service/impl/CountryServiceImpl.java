package ec.edu.ecole.service.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import ec.edu.ecole.exception.EducacionPersistException;
import ec.edu.ecole.exception.EducacionUpdateException;
import ec.edu.ecole.dao.CountryDAO;
import ec.edu.ecole.model.Country;
import ec.edu.ecole.service.CountryService;


@Stateless
public class CountryServiceImpl implements CountryService {
	
	@EJB
	private CountryDAO countryDAO;
	
	public List<Country> findAll(){
		return countryDAO.findAll();
	}

		
	@Override
	public Country findById(long id ){
		return countryDAO.findById(id);
	}


	@Override
	public void guardar(Country country) throws Exception {
		try {
			countryDAO.persist(country);	
		} catch (EducacionPersistException e) {
			throw new Exception(e);
		}
	}


	@Override
	public void actualizar(Country country) throws Exception {
		try {
			countryDAO.update(country);
		} catch (EducacionUpdateException e) {
			throw new Exception(e);
		}
	}
	
	
}

