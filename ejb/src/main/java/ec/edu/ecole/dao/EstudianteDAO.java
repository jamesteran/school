package ec.edu.ecole.dao;



import java.util.List;

import javax.ejb.Local;

import ec.edu.ecole.model.StudentInfo;

/**
 * 
 * @author jt
 */
@Local
public interface EstudianteDAO extends GenericDAO<StudentInfo, Long>{
	
	public StudentInfo getByUsuario(String usuario );
	
	public List<StudentInfo> getAllStudentData();
	
	public StudentInfo getByCedula(String cedula );
	

}
