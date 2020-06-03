package ec.edu.ecole.service;

import java.util.List;
import javax.ejb.Local;

import ec.edu.ecole.model.StudentInfo;

@Local
public interface EstudianteService { 	

	public void guardar(StudentInfo empleado) throws Exception;
	
	public void actualizar(StudentInfo empleado) throws Exception;	
	
	public List<StudentInfo> findAll();
	
	public StudentInfo getByUsuario(String usuario );
	
	public List<StudentInfo> getAllStudentData();
	
	public StudentInfo getByCedula(String cedula );
	
}
