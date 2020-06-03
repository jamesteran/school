package ec.edu.ecole.dao;

import javax.ejb.Local;

import ec.edu.ecole.model.ClassName;

/**
 * 
 * @author jt
 */
@Local
public interface ClassDAO extends GenericDAO<ClassName, Integer> {
	public ClassName getClassByNivel(int nivel);

}
