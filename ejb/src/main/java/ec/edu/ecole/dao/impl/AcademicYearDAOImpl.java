package ec.edu.ecole.dao.impl;

import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.ecole.dao.AcademicYearDAO;
import ec.edu.ecole.model.AcademicYear;

@Stateless
public class AcademicYearDAOImpl extends GenericDAOImpl<AcademicYear, Integer> implements AcademicYearDAO {

	@Override
	public AcademicYear getAcademicYearBySec(int sec) {
		try {
			Query q = em.createQuery("Select distinct c From AcademicYear  c  where c.acySec = :sec ")
					.setParameter("sec", sec);
			return (AcademicYear) q.getSingleResult();
		} catch (Exception e) {
			return null;
		}
	}

}
