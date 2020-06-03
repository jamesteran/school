package ec.edu.ecole.dao;

import javax.ejb.Local;

import ec.edu.ecole.model.AcademicYear;

/**
 * 
 * @author jt
 */
@Local
public interface AcademicYearDAO extends GenericDAO<AcademicYear, Integer> {
	public AcademicYear getAcademicYearBySec(int sec);

}
