package ec.edu.ecole.service.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import ec.edu.ecole.exception.EducacionPersistException;
import ec.edu.ecole.exception.EducacionUpdateException;
import ec.edu.ecole.dao.CityDAO;
import ec.edu.ecole.model.City;
import ec.edu.ecole.service.CityService;


@Stateless
public class CityServiceImpl implements CityService {
	
	@EJB
	private CityDAO cityDAO;
	
	public List<City> findAll(){
		return cityDAO.findAll();
	}

		
	@Override
	public City findById(long id ){
		return cityDAO.findById(id);
	}


	@Override
	public void guardar(City city) throws Exception {
		try {
			cityDAO.persist(city);	
		} catch (EducacionPersistException e) {
			throw new Exception(e);
		}
	}


	@Override
	public void actualizar(City city) throws Exception {
		try {
			cityDAO.update(city);
		} catch (EducacionUpdateException e) {
			throw new Exception(e);
		}
	}
	
	
}

