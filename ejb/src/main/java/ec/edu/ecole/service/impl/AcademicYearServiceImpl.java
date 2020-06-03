package ec.edu.ecole.service.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import ec.edu.ecole.dao.AcademicYearDAO;
import ec.edu.ecole.exception.EducacionPersistException;
import ec.edu.ecole.exception.EducacionUpdateException;
import ec.edu.ecole.model.AcademicYear;
import ec.edu.ecole.service.AcademicYearService;

@Stateless
public class AcademicYearServiceImpl implements AcademicYearService {

	@EJB
	private AcademicYearDAO academicYearDAO;

	public List<AcademicYear> findAll() {
		return academicYearDAO.findAll();
	}

	@Override
	public AcademicYear findById(int id) {
		return academicYearDAO.findById(id);
	}

	@Override
	public void guardar(AcademicYear parent) throws Exception {
		try {
			academicYearDAO.persist(parent);
		} catch (EducacionPersistException e) {
			throw new Exception(e);
		}
	}

	@Override
	public void actualizar(AcademicYear parent) throws Exception {
		try {
			academicYearDAO.update(parent);
		} catch (EducacionUpdateException e) {
			throw new Exception(e);
		}
	}

	@Override
	public AcademicYear getAcademicYearBySec(int sec) {
		return academicYearDAO.getAcademicYearBySec(sec);
	}

}
