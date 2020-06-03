package ec.edu.ecole.service.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import ec.edu.ecole.exception.EducacionPersistException;
import ec.edu.ecole.exception.EducacionUpdateException;

import ec.edu.ecole.dao.EstudianteDAO;
import ec.edu.ecole.model.StudentInfo;
import ec.edu.ecole.service.EstudianteService;


@Stateless
public class EstudianteServiceImpl implements EstudianteService {
	
	@EJB
	private EstudianteDAO studentDAO;
	
	
	
	@Override
	public void guardar(StudentInfo empleado) throws Exception {
		try {
			studentDAO.persist(empleado);
		} catch (EducacionPersistException e) {
			throw new Exception(e);
		}
	}
	
	@Override
	public void actualizar(StudentInfo empleado) throws Exception {
		try {
			studentDAO.update(empleado);
		} catch (EducacionUpdateException e) {
			throw new Exception(e);
		}
	}
		
	@Override
	public StudentInfo getByUsuario(String usuario ){
		return studentDAO.getByUsuario(usuario);
	}
		
	public List<StudentInfo> findAll(){
		return studentDAO.findAll();
	}

	@Override
	public List<StudentInfo> getAllStudentData() {
		return studentDAO.getAllStudentData();
	}
	
	@Override
	public StudentInfo getByCedula(String cedula ){
		return studentDAO.getByCedula(cedula);
	}
	
	
}

