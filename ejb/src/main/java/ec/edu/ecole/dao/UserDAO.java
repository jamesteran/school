package ec.edu.ecole.dao;

import javax.ejb.Local;

import ec.edu.ecole.model.User;

/**
 * 
 * @author jt
 */
@Local
public interface UserDAO extends GenericDAO<User, Long> {

	public User getByCedula(String cedula);

	public User getUserNadPassword(String username, String password);

}
