package ec.edu.ecole.service.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import ec.edu.ecole.exception.EducacionPersistException;
import ec.edu.ecole.exception.EducacionUpdateException;

import ec.edu.ecole.dao.ParroquiaDAO;
import ec.edu.ecole.model.Parroquia;
import ec.edu.ecole.service.ParroquiaService;


@Stateless
public class ParroquiaServiceImpl implements ParroquiaService {
	
	@EJB
	private ParroquiaDAO ParroquiaDAO;
	
	public List<Parroquia> findAll(){
		return ParroquiaDAO.findAll();
	}

		
	@Override
	public Parroquia findById(long id ){
		return ParroquiaDAO.findById(id);
	}


	@Override
	public void guardar(Parroquia parroquia) throws Exception {
		try {
			ParroquiaDAO.persist(parroquia);	
		} catch (EducacionPersistException e) {
			throw new Exception(e);
		}
	}


	@Override
	public void actualizar(Parroquia parroquia) throws Exception {
		try {
			ParroquiaDAO.update(parroquia);
		} catch (EducacionUpdateException e) {
			throw new Exception(e);
		}
	}
	
	
	public List<Parroquia> getByCityName(String cityName ){
		return ParroquiaDAO.getByCityName(cityName);
	}
	
}

