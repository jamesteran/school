/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ecole.academic;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ec.edu.ecole.controller.StudentController;
import ec.edu.ecole.model.AcademicYear;
import ec.edu.ecole.service.AcademicYearService;

/**
 *
 * @author
 */
@Named
@ViewScoped
public class AcademicYearController implements Serializable {

	private static final Logger LOG = Logger.getLogger(StudentController.class.getName());
	private static final long serialVersionUID = 1L;

	@Inject
	private AcademicYearService academicYearService;

	private List<AcademicYear> academicYears = new ArrayList<>();

	private int acyid;
	private int acyear;
	private int newAcyear;
	private int numberOfExam;
	private boolean closed;
	private int acyearNo;
	private AcademicYear selectedRow;
	private AcademicYear academicYear = new AcademicYear();

	/** Creates a new instance of AcademicYearBean */
	public AcademicYearController() {
	}

	@PostConstruct
	public void init() {
		buscarAllAcademicYears();
	}

	public void buscarAllAcademicYears() {
		academicYears = academicYearService.findAll();
	}

	public void saveAcyear() {
		if (academicYear != null) {
			try {
				academicYearService.guardar(academicYear);
				buscarAllAcademicYears();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void updateAcyear() {
		System.out.println("ROW__________" + selectedRow.getAcyid());
		if (selectedRow != null) {
			try {
				academicYearService.actualizar(selectedRow);
				buscarAllAcademicYears();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void newAcademicYear() {
		academicYear = new AcademicYear();
	}

	public void editAcademicYear() {
		System.out.println("SELECTED ROW----------" + selectedRow.getAcyear());
	}

	public int getAcyear() {
		return acyear;
	}

	public void setAcyear(int acyear) {
		this.acyear = acyear;
	}

	public int getAcyid() {
		return acyid;
	}

	public void setAcyid(int acyid) {
		this.acyid = acyid;
	}

	public boolean isClosed() {
		return closed;
	}

	public void setClosed(boolean closed) {
		this.closed = closed;
	}

	public int getNewAcyear() {
		return newAcyear;
	}

	public void setNewAcyear(int newAcyear) {
		this.newAcyear = newAcyear;
	}

	public int getNumberOfExam() {
		return numberOfExam;
	}

	public void setNumberOfExam(int numberOfExam) {
		this.numberOfExam = numberOfExam;
	}

	public int getAcyearNo() {
		return acyearNo;
	}

	public void setAcyearNo(int acyearNo) {
		this.acyearNo = acyearNo;
	}

	public AcademicYear getSelectedRow() {
		return selectedRow;
	}

	public void setSelectedRow(AcademicYear selectedRow) {
		this.selectedRow = selectedRow;
	}

	public List<AcademicYear> getAcademicYears() {
		return academicYears;
	}

	public void setAcademicYears(List<AcademicYear> academicYears) {
		this.academicYears = academicYears;
	}

	public AcademicYear getAcademicYear() {
		return academicYear;
	}

	public void setAcademicYear(AcademicYear academicYear) {
		this.academicYear = academicYear;
	}

}
