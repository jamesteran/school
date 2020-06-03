package ec.edu.ecole.service;

import java.util.List;

import javax.ejb.Local;

import ec.edu.ecole.model.ClassName;

@Local
public interface ClassService {

	public void guardar(ClassName envoice) throws Exception;

	public void actualizar(ClassName envoice) throws Exception;

	public List<ClassName> findAll();

	public ClassName findById(int id);

	public ClassName getClassByNivel(int nivel);

}
