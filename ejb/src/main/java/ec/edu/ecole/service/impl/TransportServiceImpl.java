package ec.edu.ecole.service.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import ec.edu.ecole.dao.TransportDAO;
import ec.edu.ecole.exception.EducacionPersistException;
import ec.edu.ecole.exception.EducacionUpdateException;
import ec.edu.ecole.model.Transport;
import ec.edu.ecole.service.TransportService;

@Stateless
public class TransportServiceImpl implements TransportService {

	@EJB
	private TransportDAO transportDAO;

	public List<Transport> findAll() {
		return transportDAO.findAll();
	}

	@Override
	public Transport findById(int id) {
		return transportDAO.findById(id);
	}

	@Override
	public void guardar(Transport transport) throws Exception {
		try {
			Transport trans = getTransportByStdId(transport.getStudentInfo().getStdId());
			if (trans == null) {
				transportDAO.persist(transport);
			}
		} catch (EducacionPersistException e) {
			throw new Exception(e);
		}
	}

	@Override
	public void actualizar(Transport transport) throws Exception {
		try {
			transportDAO.update(transport);
		} catch (EducacionUpdateException e) {
			throw new Exception(e);
		}
	}

	@Override
	public Transport getTransportByStdId(int stdId) {
		return transportDAO.getTransportByStdId(stdId);
	}
}
