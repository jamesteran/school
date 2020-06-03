package ec.edu.ecole.service.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import ec.edu.ecole.exception.EducacionPersistException;
import ec.edu.ecole.exception.EducacionUpdateException;

import ec.edu.ecole.dao.SiblingDAO;
import ec.edu.ecole.model.Sibling;
import ec.edu.ecole.service.SiblingService;


@Stateless
public class SiblingServiceImpl implements SiblingService {
	
	@EJB
	private SiblingDAO SiblingDAO;
	
	public List<Sibling> findAll(){
		return SiblingDAO.findAll();
	}

		
	@Override
	public Sibling findById(long id ){
		return SiblingDAO.findById(id);
	}


	@Override
	public void guardar(Sibling sibling) throws Exception {
		try {
			SiblingDAO.persist(sibling);	
		} catch (EducacionPersistException e) {
			throw new Exception(e);
		}
	}


	@Override
	public void actualizar(Sibling sibling) throws Exception {
		try {
			SiblingDAO.update(sibling);
		} catch (EducacionUpdateException e) {
			throw new Exception(e);
		}
	}
	
	
}

