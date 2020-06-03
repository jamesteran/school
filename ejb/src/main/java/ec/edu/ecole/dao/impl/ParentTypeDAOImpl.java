package ec.edu.ecole.dao.impl;

import javax.ejb.Stateless;

import ec.edu.ecole.dao.ParentTypeDAO;
import ec.edu.ecole.model.ParentType;

@Stateless
public class ParentTypeDAOImpl extends GenericDAOImpl<ParentType, Integer> implements ParentTypeDAO {

}
