package ec.edu.ecole.service.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import ec.edu.ecole.dao.EnvoiceClientDAO;
import ec.edu.ecole.exception.EducacionPersistException;
import ec.edu.ecole.exception.EducacionUpdateException;
import ec.edu.ecole.model.EnvoiceClient;
import ec.edu.ecole.service.EnvoiceClientService;

@Stateless
public class EnvoiceClientServiceImpl implements EnvoiceClientService {

	@EJB
	private EnvoiceClientDAO envoiceClientDAO;

	public List<EnvoiceClient> findAll() {
		return envoiceClientDAO.findAll();
	}

	@Override
	public EnvoiceClient findById(int id) {
		return envoiceClientDAO.findById(id);
	}

	@Override
	public void guardar(EnvoiceClient parent) throws Exception {
		try {
			envoiceClientDAO.persist(parent);
		} catch (EducacionPersistException e) {
			throw new Exception(e);
		}
	}

	@Override
	public void actualizar(EnvoiceClient parent) throws Exception {
		try {
			envoiceClientDAO.update(parent);
		} catch (EducacionUpdateException e) {
			throw new Exception(e);
		}
	}

	@Override
	public EnvoiceClient getEnvoiceByStdId(int stdId) {
		return envoiceClientDAO.getEnvoiceByStdId(stdId);
	}
}
