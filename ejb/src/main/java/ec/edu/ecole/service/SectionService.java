package ec.edu.ecole.service;

import java.util.List;

import javax.ejb.Local;

import ec.edu.ecole.model.SectionName;

@Local
public interface SectionService {

	public void guardar(SectionName section) throws Exception;

	public void actualizar(SectionName section) throws Exception;

	public List<SectionName> findAll();

	public SectionName findById(int id);

	public List<SectionName> getSectionByYeacId(int yearId);

	public SectionName getSectionByYearClass(int yearSec, int classNivel, String section);

}
