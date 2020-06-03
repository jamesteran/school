package ec.edu.ecole.service;

import java.util.List;

import javax.ejb.Local;

import ec.edu.ecole.model.Registration;

@Local
public interface RegistrationService {

	public void guardar(Registration envoice) throws Exception;

	public void actualizar(Registration envoice) throws Exception;

	public List<Registration> findAll();

	public Registration findById(int id);

	public List<Registration> getRegistrationByStdId(int stdId);

	public Registration getRegistrationByStdAndYear(int stdId, int acyid);

}
