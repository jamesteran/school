package ec.edu.ecole.service;

import java.util.List;

import javax.ejb.Local;

import ec.edu.ecole.model.AcademicYear;

@Local
public interface AcademicYearService {

	public void guardar(AcademicYear envoice) throws Exception;

	public void actualizar(AcademicYear envoice) throws Exception;

	public List<AcademicYear> findAll();

	public AcademicYear findById(int id);

	public AcademicYear getAcademicYearBySec(int sec);

}
