package ec.edu.ecole.dao;

import java.util.List;

import javax.ejb.Local;

import ec.edu.ecole.model.Custodian;

/**
 * 
 * @author jt
 */
@Local
public interface CustodianDAO extends GenericDAO<Custodian, Integer> {

	public List<Custodian> buscarCustodiansByStdId(int stdId);

	public Custodian getCustodianByCedula(String cedula);

}
