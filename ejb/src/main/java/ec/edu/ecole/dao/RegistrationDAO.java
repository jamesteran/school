package ec.edu.ecole.dao;

import java.util.List;

import javax.ejb.Local;

import ec.edu.ecole.model.Registration;

/**
 * 
 * @author jt
 */
@Local
public interface RegistrationDAO extends GenericDAO<Registration, Integer> {

	public List<Registration> getRegistrationByStdId(int stdId);

	public Registration getRegistrationByStdAndYear(int stdId, int acyid);

}
