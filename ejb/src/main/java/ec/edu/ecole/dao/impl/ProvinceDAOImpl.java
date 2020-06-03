package ec.edu.ecole.dao.impl;

import javax.ejb.Stateless;

import ec.edu.ecole.dao.ProvinceDAO;
import ec.edu.ecole.model.Province;

@Stateless
public class ProvinceDAOImpl extends GenericDAOImpl<Province, Long> implements ProvinceDAO {

}
