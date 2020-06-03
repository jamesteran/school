package ec.edu.ecole.service;

import java.util.List;
import javax.ejb.Local;

import ec.edu.ecole.model.Transport;

@Local
public interface TransportService { 	

	public void guardar(Transport transport) throws Exception;
	
	public void actualizar(Transport transport) throws Exception;	
	
	public List<Transport> findAll();
	
	public Transport findById(int id);
	
	public Transport getTransportByStdId(int stdId );
	
	
}
