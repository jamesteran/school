package ec.edu.ecole.service;

import java.util.List;

import javax.ejb.Local;

import ec.edu.ecole.model.EnvoiceClient;

@Local
public interface EnvoiceClientService {

	public void guardar(EnvoiceClient envoice) throws Exception;

	public void actualizar(EnvoiceClient envoice) throws Exception;

	public List<EnvoiceClient> findAll();

	public EnvoiceClient findById(int id);

	public EnvoiceClient getEnvoiceByStdId(int stdId);

}
