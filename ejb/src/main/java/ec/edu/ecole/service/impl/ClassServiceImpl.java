package ec.edu.ecole.service.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import ec.edu.ecole.dao.ClassDAO;
import ec.edu.ecole.exception.EducacionPersistException;
import ec.edu.ecole.exception.EducacionUpdateException;
import ec.edu.ecole.model.ClassName;
import ec.edu.ecole.service.ClassService;

@Stateless
public class ClassServiceImpl implements ClassService {

	@EJB
	private ClassDAO classDAO;

	public List<ClassName> findAll() {
		return classDAO.findAll();
	}

	@Override
	public ClassName findById(int id) {
		return classDAO.findById(id);
	}

	@Override
	public void guardar(ClassName parent) throws Exception {
		try {
			classDAO.persist(parent);
		} catch (EducacionPersistException e) {
			throw new Exception(e);
		}
	}

	@Override
	public void actualizar(ClassName parent) throws Exception {
		try {
			classDAO.update(parent);
		} catch (EducacionUpdateException e) {
			throw new Exception(e);
		}
	}

	public ClassName getClassByNivel(int nivel) {
		return classDAO.getClassByNivel(nivel);
	}

}
