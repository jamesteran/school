package ec.edu.ecole.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.edu.ecole.dao.GenericDAO;
import ec.edu.ecole.exception.EducacionDeleteException;
import ec.edu.ecole.exception.EducacionPersistException;
import ec.edu.ecole.exception.EducacionUpdateException;
import ec.edu.ecole.resources.Constantes;

/**
 * 
 * @author 
 */
public class GenericDAOImpl<T, ID extends Serializable> implements GenericDAO<T, ID> {

	private final Class<T> persistentClass;
	
	@PersistenceContext
	protected EntityManager em;

	@SuppressWarnings(Constantes.UNCHECKED)
	public GenericDAOImpl() {
		this.persistentClass = (Class<T>) ((ParameterizedType) getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
	}

	@Override
	public T findById(ID id) {
		return getEntityManager().find(persistentClass, id);
	}

	@SuppressWarnings(Constantes.UNCHECKED)
	@Override
	public List<T> findAll() {
		return getEntityManager().createQuery(
				"select o from " + persistentClass.getCanonicalName() + " o")
				.getResultList();
	}

	@SuppressWarnings(Constantes.UNCHECKED)
	@Override
	public List<T> findAllActive() {
		return getEntityManager().createQuery(
				"select o from " + persistentClass.getCanonicalName() + " o where o.active = 1")
				.getResultList();
	}

	@SuppressWarnings(Constantes.UNCHECKED)
	@Override
	public List<T> findByNamedQuery(String queryName, Object... params) {

		Query qry = getEntityManager().createNamedQuery(queryName);

		int index = 0;

		for (Object p : params) {
			qry.setParameter(index++, p);
		}

		return qry.getResultList();
	}

	@SuppressWarnings(Constantes.UNCHECKED)
	@Override
	public List<T> findByNamedQueryAndNamedParams(String queryName,
			Map<String, ? extends Object> params) {

		Query qry = getEntityManager().createNamedQuery(queryName);

		for (String key : params.keySet()) {
			qry.setParameter(key, params.get(key));
		}

		return qry.getResultList();

	}

	@Override
	public T update(T entity) throws EducacionUpdateException {
		try {
			return getEntityManager().merge(entity);
		} catch (Throwable ex) {
			throw new EducacionUpdateException(entity, ex);
		}
	}

	@Override
	public void delete(T entity) throws EducacionDeleteException {
		try {
			getEntityManager().remove(getEntityManager().merge(entity));
		} catch (Throwable ex) {
			throw new EducacionDeleteException(entity, ex);
		}
	}

	@Override
	public void delete(ID id) throws EducacionDeleteException {
		T obj = findById(id);
		delete(obj);
	}

	@Override
	public void persist(T entity) throws EducacionPersistException {
		try {
			getEntityManager().persist(entity);
			getEntityManager().flush();
		} catch (Throwable ex) {
			throw new EducacionPersistException(entity, ex);
		}
	}

	public EntityManager getEntityManager() {
		return this.em;
	}

	@Override
	public Long getSequence(String aciudUsuario, String idUsuario) {
		return (Long) getEntityManager().createQuery(
				"select max(o." + idUsuario + ") + 1 from "+ aciudUsuario + " o")
				.getSingleResult();
	}
	
}
