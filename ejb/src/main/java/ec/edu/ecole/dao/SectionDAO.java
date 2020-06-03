package ec.edu.ecole.dao;

import java.util.List;

import javax.ejb.Local;

import ec.edu.ecole.model.SectionName;

/**
 * 
 * @author jt
 */
@Local
public interface SectionDAO extends GenericDAO<SectionName, Integer> {

	public List<SectionName> getSectionByYeacId(int yearId);

	public SectionName getSectionByYearClass(int yearSec, int classNivel, String section);

}
