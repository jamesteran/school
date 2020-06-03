package ec.edu.ecole.dao.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.ecole.dao.ParroquiaDAO;
import ec.edu.ecole.model.Parroquia;

@Stateless
public class ParroquiaDAOImpl extends GenericDAOImpl<Parroquia, Long> implements ParroquiaDAO {

	@SuppressWarnings("unchecked")
	@Override
	public List<Parroquia> getByCityName(String cityCode) {
		try {
			Query q = em.createQuery("Select  p From Parroquia p " + " where p.cityCode = :cityCode "
					+ " and p.active = 1" + " ORDER BY p.parroquiaName").setParameter("cityCode", cityCode);
			return q.getResultList();
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

}
