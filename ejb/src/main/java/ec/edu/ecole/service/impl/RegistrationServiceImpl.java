package ec.edu.ecole.service.impl;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import ec.edu.ecole.dao.RegistrationDAO;
import ec.edu.ecole.exception.EducacionPersistException;
import ec.edu.ecole.exception.EducacionUpdateException;
import ec.edu.ecole.model.Registration;
import ec.edu.ecole.service.RegistrationService;

@Stateless
public class RegistrationServiceImpl implements RegistrationService {

	@EJB
	private RegistrationDAO registrationDAO;

	public List<Registration> findAll() {
		return registrationDAO.findAll();
	}

	@Override
	public Registration findById(int id) {
		return registrationDAO.findById(id);
	}

	@Override
	public void guardar(Registration registr) throws Exception {
		try {
			Registration registration = getRegistrationByStdAndYear(registr.getStudentInfo().getStdId(),
					registr.getAcademicYear().getAcyid());
			if (registration == null) {
				registrationDAO.persist(registr);
				StringBuilder matCod = new StringBuilder();
				Date regFec = new Date();
				if (registr.getRegId() != 0) {
					String regSec = String.format("%04d", registr.getRegId());
					matCod.append("EFJJ-");
					matCod.append(regSec);
					matCod.append(registr.getAcademicYear().getAcyear());
					registr.setRegCod(matCod.toString());
					registr.setStdRollNo(registr.getRegId());
					registr.setRegDate(regFec);
					actualizar(registr);
				}
			}
		} catch (EducacionPersistException e) {
			throw new Exception(e);
		}
	}

	@Override
	public void actualizar(Registration parent) throws Exception {
		try {
			registrationDAO.update(parent);
		} catch (EducacionUpdateException e) {
			throw new Exception(e);
		}
	}

	@Override
	public List<Registration> getRegistrationByStdId(int stdId) {
		return registrationDAO.getRegistrationByStdId(stdId);
	}

	@Override
	public Registration getRegistrationByStdAndYear(int stdId, int acyid) {
		return registrationDAO.getRegistrationByStdAndYear(stdId, acyid);
	}
}
