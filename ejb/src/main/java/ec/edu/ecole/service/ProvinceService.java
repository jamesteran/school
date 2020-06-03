package ec.edu.ecole.service;

import java.util.List;
import javax.ejb.Local;

import ec.edu.ecole.model.Province;

@Local
public interface ProvinceService { 	

	public void guardar(Province province) throws Exception;
	
	public void actualizar(Province province) throws Exception;	
	
	public List<Province> findAll();
	
	public Province findById(long id);
	
}
