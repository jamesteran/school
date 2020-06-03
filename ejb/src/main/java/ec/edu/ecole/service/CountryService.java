package ec.edu.ecole.service;

import java.util.List;
import javax.ejb.Local;

import ec.edu.ecole.model.Country;

@Local
public interface CountryService { 	

	public void guardar(Country country) throws Exception;
	
	public void actualizar(Country country) throws Exception;	
	
	public List<Country> findAll();
	
	public Country findById(long id);
	
}
