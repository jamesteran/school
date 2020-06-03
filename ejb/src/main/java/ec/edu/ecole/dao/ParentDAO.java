package ec.edu.ecole.dao;

import javax.ejb.Local;

import ec.edu.ecole.model.Parent;

/**
 * 
 * @author jt
 */
@Local
public interface ParentDAO extends GenericDAO<Parent, Integer> {

	public Parent getPhaByStudentAdnType(int studenId, int prntType);

	public Parent getPharentByCedula(String cedula);

}
