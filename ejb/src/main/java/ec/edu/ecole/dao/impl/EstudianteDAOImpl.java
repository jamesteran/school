package ec.edu.ecole.dao.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.ecole.dao.EstudianteDAO;
import ec.edu.ecole.model.StudentInfo;

@Stateless
public class EstudianteDAOImpl extends GenericDAOImpl<StudentInfo, Long> implements EstudianteDAO {

	@Override
	public StudentInfo getByUsuario(String usuario) {
		try {
			Query q = em.createQuery(
					"Select distinct e From StudentInfo e " + " join fetch s.user u " + " where u.uname = :usuario ")
					.setParameter("usuario", usuario);
			return (StudentInfo) q.getSingleResult();
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<StudentInfo> getAllStudentData() {
		try {
			Query q = em.createQuery("Select distinct s From StudentInfo s  ");
			return q.getResultList();
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	@Override
	public StudentInfo getByCedula(String cedula) {
		try {
			System.out.println("CEDULA: " + cedula);
			Query q = em.createQuery("Select distinct s From StudentInfo s" + " join fetch s.user u "
					+ " where u.idNumber = :cedula " + " and s.stdStatus = 1").setParameter("cedula", cedula);
			return (StudentInfo) q.getSingleResult();
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

}
