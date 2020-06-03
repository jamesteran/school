package ec.edu.ecole.service;

import java.util.List;

import javax.ejb.Local;

import ec.edu.ecole.model.User;

@Local
public interface UserService {

	public void guardar(User user) throws Exception;

	public void actualizar(User user) throws Exception;

	public List<User> findAll();

	public User findById(long id);

	public User getByCedula(String cedula);

	public User getUserNadPassword(String username, String password);

	public void actualizarPassword(User user) throws Exception;

}
