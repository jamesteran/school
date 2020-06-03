package ec.edu.ecole.service;

import java.util.List;
import javax.ejb.Local;

import ec.edu.ecole.model.Parroquia;

@Local
public interface ParroquiaService { 	

	public void guardar(Parroquia parroquia) throws Exception;
	
	public void actualizar(Parroquia parroquia) throws Exception;	
	
	public List<Parroquia> findAll();
	
	public Parroquia findById(long id);
	
	public List<Parroquia> getByCityName(String cityName );
	
}
