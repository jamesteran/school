package ec.edu.ecole.service;

import java.util.List;
import javax.ejb.Local;

import ec.edu.ecole.model.Parent;

@Local
public interface ParentService { 	

	public void guardar(Parent parent) throws Exception;
	
	public void actualizar(Parent parent) throws Exception;	
	
	public List<Parent> findAll();
	
	public Parent findById(int id);
	
	public Parent getPhaByStudentAdnType(int studenId, int prntType) throws Exception;
	
	public Parent getPharentByCedula(String cedula );
	
	
}
