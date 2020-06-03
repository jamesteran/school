package ec.edu.ecole.dao.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.ecole.dao.SectionDAO;
import ec.edu.ecole.model.SectionName;

@Stateless
public class SectionDAOImpl extends GenericDAOImpl<SectionName, Integer> implements SectionDAO {

	@SuppressWarnings("unchecked")
	@Override
	public List<SectionName> getSectionByYeacId(int yearId) {
		try {
			Query q = em.createQuery("Select distinct e From SectionName e  join fetch e.className c "
					+ " join fetch e.academicYear a  where a.acyid = :yearId ").setParameter("yearId", yearId);
			return q.getResultList();
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public SectionName getSectionByYearClass(int yearSec, int classNivel, String section) {
		try {
			Query q = em.createQuery("Select distinct s From SectionName s  join fetch s.className c "
					+ " join fetch s.academicYear a  where a.acySec = :yearSec and c.classNivel = :classNivel and s.sectionName = :section")
					.setParameter("yearSec", yearSec).setParameter("classNivel", classNivel)
					.setParameter("section", section);
			return (SectionName) q.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
