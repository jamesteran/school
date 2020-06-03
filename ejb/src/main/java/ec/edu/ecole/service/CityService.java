package ec.edu.ecole.service;

import java.util.List;
import javax.ejb.Local;

import ec.edu.ecole.model.City;

@Local
public interface CityService { 	

	public void guardar(City city) throws Exception;
	
	public void actualizar(City city) throws Exception;	
	
	public List<City> findAll();
	
	public City findById(long id);
	
}
