package ec.edu.ecole.dao.impl;

import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.ecole.dao.ClassDAO;
import ec.edu.ecole.model.ClassName;

@Stateless
public class ClassDAOImpl extends GenericDAOImpl<ClassName, Integer> implements ClassDAO {

	@Override
	public ClassName getClassByNivel(int nivel) {
		try {
			Query q = em.createQuery("Select distinct c From ClassName  c  where c.classNivel = :nivel ")
					.setParameter("nivel", nivel);
			return (ClassName) q.getSingleResult();
		} catch (Exception e) {
			return null;
		}
	}
}
