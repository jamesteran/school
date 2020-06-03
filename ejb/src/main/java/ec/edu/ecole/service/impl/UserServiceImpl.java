package ec.edu.ecole.service.impl;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.logging.Logger;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import ec.edu.ecole.dao.UserDAO;
import ec.edu.ecole.exception.EducacionPersistException;
import ec.edu.ecole.exception.EducacionUpdateException;
import ec.edu.ecole.model.User;
import ec.edu.ecole.resources.EncryptUtils;
import ec.edu.ecole.service.UserService;

@Stateless
public class UserServiceImpl implements UserService {

	private static final Logger LOG = Logger.getLogger(UserServiceImpl.class.getName());

	@EJB
	private UserDAO userDAO;

	public List<User> findAll() {
		return userDAO.findAll();
	}

	@Override
	public User findById(long id) {
		return userDAO.findById(id);
	}

	@Override
	public void guardar(User user) throws Exception {
		try {
			String claveEncriptada = EncryptUtils.applyAlgorithm(user.getPassword(), EncryptUtils.MD5,
					EncryptUtils.UTF);
			user.setPassword(claveEncriptada);
			userDAO.persist(user);
		} catch (EducacionPersistException e) {
			throw new Exception(e);
		}
	}

	@Override
	public void actualizar(User user) throws Exception {
		try {
			userDAO.update(user);
		} catch (EducacionUpdateException e) {
			throw new Exception(e);
		}
	}

	@Override
	public User getByCedula(String cedula) {
		return userDAO.getByCedula(cedula);
	}

	@Override
	public User getUserNadPassword(String username, String password) {
		String claveEncriptada = password;
		try {
			claveEncriptada = EncryptUtils.applyAlgorithm(password, EncryptUtils.MD5, EncryptUtils.UTF);
		} catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
			LOG.info(e.getMessage());
		}

		return userDAO.getUserNadPassword(username, password);
	}

	@Override
	public void actualizarPassword(User user) throws Exception {
		try {
			String claveEncriptada = EncryptUtils.applyAlgorithm(user.getPassword(), EncryptUtils.MD5,
					EncryptUtils.UTF);
			user.setPassword(claveEncriptada);
			userDAO.update(user);
		} catch (EducacionUpdateException e) {
			throw new Exception(e);
		}
	}
}
