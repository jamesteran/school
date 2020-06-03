package ec.edu.ecole.service;

import java.util.List;
import javax.ejb.Local;

import ec.edu.ecole.model.Sibling;

@Local
public interface SiblingService { 	

	public void guardar(Sibling sibling) throws Exception;
	
	public void actualizar(Sibling sibling) throws Exception;	
	
	public List<Sibling> findAll();
	
	public Sibling findById(long id);
	
}
