package ec.edu.ecole.service.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import ec.edu.ecole.dao.CustodianDAO;
import ec.edu.ecole.exception.EducacionPersistException;
import ec.edu.ecole.exception.EducacionUpdateException;
import ec.edu.ecole.model.Custodian;
import ec.edu.ecole.service.CustodianService;

@Stateless
public class CustodianServiceImpl implements CustodianService {

	@EJB
	private CustodianDAO CustodianDAO;

	public List<Custodian> findAll() {
		return CustodianDAO.findAll();
	}

	@Override
	public Custodian findById(int id) {
		return CustodianDAO.findById(id);
	}

	@Override
	public void guardar(Custodian custodian) throws Exception {
		try {
			CustodianDAO.persist(custodian);
		} catch (EducacionPersistException e) {
			throw new Exception(e);
		}
	}

	@Override
	public void actualizar(Custodian custodian) throws Exception {
		try {
			CustodianDAO.update(custodian);
		} catch (EducacionUpdateException e) {
			throw new Exception(e);
		}
	}

	@Override
	public List<Custodian> buscarCustodiansByStdId(int stdId) {
		return CustodianDAO.buscarCustodiansByStdId(stdId);
	}

	@Override
	public Custodian getCustodianByCedula(String cedula) {
		return CustodianDAO.getCustodianByCedula(cedula);
	}
}
