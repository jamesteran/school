package ec.edu.ecole.service.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import ec.edu.ecole.exception.EducacionPersistException;
import ec.edu.ecole.exception.EducacionUpdateException;

import ec.edu.ecole.dao.ProvinceDAO;
import ec.edu.ecole.model.Province;
import ec.edu.ecole.service.ProvinceService;


@Stateless
public class ProvinceServiceImpl implements ProvinceService {
	
	@EJB
	private ProvinceDAO ProvinceDAO;
	
	public List<Province> findAll(){
		return ProvinceDAO.findAll();
	}

		
	@Override
	public Province findById(long id ){
		return ProvinceDAO.findById(id);
	}


	@Override
	public void guardar(Province province) throws Exception {
		try {
			ProvinceDAO.persist(province);	
		} catch (EducacionPersistException e) {
			throw new Exception(e);
		}
	}


	@Override
	public void actualizar(Province province) throws Exception {
		try {
			ProvinceDAO.update(province);
		} catch (EducacionUpdateException e) {
			throw new Exception(e);
		}
	}
	
	
}

