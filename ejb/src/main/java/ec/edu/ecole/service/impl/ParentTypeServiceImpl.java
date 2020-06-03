package ec.edu.ecole.service.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import ec.edu.ecole.exception.EducacionPersistException;
import ec.edu.ecole.exception.EducacionUpdateException;

import ec.edu.ecole.dao.ParentTypeDAO;
import ec.edu.ecole.model.ParentType;
import ec.edu.ecole.service.ParentTypeService;


@Stateless
public class ParentTypeServiceImpl implements ParentTypeService {
	
	@EJB
	private ParentTypeDAO parentTypeDAO;
		
		
	public List<ParentType> findAll(){
		return parentTypeDAO.findAll();
	}
	
	
	@Override
	public ParentType findById(int id ){
		return parentTypeDAO.findById(id);
	}


	@Override
	public void guardar(ParentType parent) throws Exception {			
		try {
			parentTypeDAO.persist(parent);
		} catch (EducacionPersistException e) {
			throw new Exception(e);
		}
	}


	@Override
	public void actualizar(ParentType parent) throws Exception {
		try {
			parentTypeDAO.update(parent);
		} catch (EducacionUpdateException e) {
			throw new Exception(e);
		}
	}
	
	
}

