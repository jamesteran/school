package ec.edu.ecole.dao.impl;

import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.ecole.dao.UserDAO;
import ec.edu.ecole.model.User;

@Stateless
public class UserDAOImpl extends GenericDAOImpl<User, Long> implements UserDAO {

	@Override
	public User getByCedula(String cedula) {
		try {
			Query q = em
					.createQuery(
							"Select distinct u From User u" + " where u.idNumber = :cedula " + " and u.isactive = 1")
					.setParameter("cedula", cedula);
			return (User) q.getSingleResult();
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	@Override
	public User getUserNadPassword(String username, String password) {
		try {
			Query q = em
					.createQuery("Select distinct u From User u" + " join fetch u.userRole r "
							+ " where u.uname = :username " + " and u.password = :password")
					.setParameter("username", username).setParameter("password", password);
			return (User) q.getSingleResult();
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

}
