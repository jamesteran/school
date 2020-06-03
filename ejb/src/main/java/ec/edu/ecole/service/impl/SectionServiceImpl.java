package ec.edu.ecole.service.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import ec.edu.ecole.dao.SectionDAO;
import ec.edu.ecole.exception.EducacionPersistException;
import ec.edu.ecole.exception.EducacionUpdateException;
import ec.edu.ecole.model.SectionName;
import ec.edu.ecole.service.SectionService;

@Stateless
public class SectionServiceImpl implements SectionService {

	@EJB
	private SectionDAO sectionDAO;

	public List<SectionName> findAll() {
		return sectionDAO.findAll();
	}

	@Override
	public SectionName findById(int id) {
		return sectionDAO.findById(id);
	}

	@Override
	public void guardar(SectionName parent) throws Exception {
		try {
			sectionDAO.persist(parent);
		} catch (EducacionPersistException e) {
			throw new Exception(e);
		}
	}

	@Override
	public void actualizar(SectionName parent) throws Exception {
		try {
			sectionDAO.update(parent);
		} catch (EducacionUpdateException e) {
			throw new Exception(e);
		}
	}

	@Override
	public List<SectionName> getSectionByYeacId(int yearId) {
		return sectionDAO.getSectionByYeacId(yearId);
	}

	@Override
	public SectionName getSectionByYearClass(int yearSec, int classNivel, String section) {
		return sectionDAO.getSectionByYearClass(yearSec, classNivel, section);
	}
}
