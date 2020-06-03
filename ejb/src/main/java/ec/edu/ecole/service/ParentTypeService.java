package ec.edu.ecole.service;

import java.util.List;
import javax.ejb.Local;

import ec.edu.ecole.model.ParentType;

@Local
public interface ParentTypeService { 	

	public void guardar(ParentType parent) throws Exception;
	
	public void actualizar(ParentType parent) throws Exception;	
	
	public List<ParentType> findAll();
	
	public ParentType findById(int id);
	
		
	
}
