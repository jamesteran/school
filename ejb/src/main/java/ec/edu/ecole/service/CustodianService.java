package ec.edu.ecole.service;

import java.util.List;

import javax.ejb.Local;

import ec.edu.ecole.model.Custodian;

@Local
public interface CustodianService {

	public void guardar(Custodian custodian) throws Exception;

	public void actualizar(Custodian custodian) throws Exception;

	public List<Custodian> findAll();

	public Custodian findById(int id);

	public List<Custodian> buscarCustodiansByStdId(int stdId);

	public Custodian getCustodianByCedula(String cedula);

}
