package ec.edu.ecole.service.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import ec.edu.ecole.exception.EducacionPersistException;
import ec.edu.ecole.exception.EducacionUpdateException;

import ec.edu.ecole.dao.ParentDAO;
import ec.edu.ecole.model.Parent;
import ec.edu.ecole.service.ParentService;


@Stateless
public class ParentServiceImpl implements ParentService {
	
	@EJB
	private ParentDAO parentDAO;
		
		
	public List<Parent> findAll(){
		return parentDAO.findAll();
	}
	
	
	@Override
	public Parent findById(int id ){
		return parentDAO.findById(id);
	}


	@Override
	public void guardar(Parent parent) throws Exception {			
		try {
			parentDAO.persist(parent);
		} catch (EducacionPersistException e) {
			throw new Exception(e);
		}
	}


	@Override
	public void actualizar(Parent parent) throws Exception {
		try {
			parentDAO.update(parent);
		} catch (EducacionUpdateException e) {
			throw new Exception(e);
		}
	}
	
	@Override
	public Parent getPhaByStudentAdnType(int studenId, int prntType)throws Exception {
		return	parentDAO.getPhaByStudentAdnType(studenId, prntType);		
	}
	
	@Override
	public Parent getPharentByCedula(String cedula ) {		
		return parentDAO.getPharentByCedula(cedula);		
	}
}

