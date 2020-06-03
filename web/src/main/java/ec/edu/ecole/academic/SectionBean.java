/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ecole.academic;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import ec.edu.ecole.model.AcademicYear;
import ec.edu.ecole.model.ClassName;
import ec.edu.ecole.model.SectionName;
import ec.edu.ecole.service.AcademicYearService;
import ec.edu.ecole.service.ClassService;
import ec.edu.ecole.service.SectionService;
import ec.edu.ecole.util.DBConnect;

/**
 *
 * @author
 */
@ManagedBean
@ViewScoped
public class SectionBean implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private int sectionId;
	private int classId;
	private int acyearId;
	private int acyear;
	private String className;
	private String sectionName;
	private SectionName section;
	private List<SectionName> sections = new ArrayList<>();
	private List<ClassName> classNames = new ArrayList<>();
	private List<AcademicYear> academicYears = new ArrayList<>();

	/** Creates a new instance of SectionBean */
	public SectionBean() {
	}

	@Inject
	private SectionService sectionService;

	@Inject
	private ClassService classService;

	@Inject
	private AcademicYearService academicYearService;

	@PostConstruct
	public void init() {

		getAllSectionName();
		getAllAcademicYears();
		getAllClassNames();

	}

	public List<SectionName> getAllSectionName() {
		sections = sectionService.getSectionByYeacId(1);
		if (sections == null) {

		}
		return sections;
	}

	public void getAllAcademicYears() {
		academicYears = academicYearService.findAll();
	}

	public void getAllClassNames() {
		classNames = classService.findAll();
	}

	public void prepareUpdate() {

		section = sectionService.findById(section.getSectionId());
		if (section != null) {
			setAcyear(section.getAcademicYear().getAcyid());
			setClassId(section.getClassName().getClassId());
		}
	}

	public void insertSection() {
		try {
			SectionName section = new SectionName();
			AcademicYear year = new AcademicYear();
			ClassName clas = new ClassName();

			clas.setClassId(this.getClassId());
			year.setAcyid(this.getAcyearId());

			section.setSectionName(this.getSectionName());
			section.setAcademicYear(year);
			section.setClassName(clas);
			sectionService.guardar(section);
			getAllSectionName();
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Información",
					"Regisro guardado correctamente");
			FacesContext.getCurrentInstance().addMessage(null, msg);

			clear();
		} catch (Exception ex) {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Error al guardar");
			FacesContext.getCurrentInstance().addMessage(null, msg);
			Logger.getLogger(SectionBean.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public void deleteSection() {
		String sql = "DELETE FROM sch_section_name WHERE section_name=? "
				+ "AND class_id=(SELECT class_id FROM sch_class_name WHERE class_name=?) "
				+ "AND acyid=(SELECT acyid FROM sch_academic_year WHERE acyear=?);";
		try {
			PreparedStatement ps = DBConnect.getConnection().prepareCall(sql);
			ps.setString(1, this.getSectionName());
			ps.setString(2, this.getClassName());
			ps.setInt(3, this.getAcyear());
			int i = ps.executeUpdate();
			if (i > 0) {
				FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Information", "One row deleted");
				FacesContext.getCurrentInstance().addMessage(null, msg);
			} else {
				FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Fail to delete data");
				FacesContext.getCurrentInstance().addMessage(null, msg);
			}
		} catch (SQLException ex) {
			Logger.getLogger(SectionBean.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public void updateSection() {
		section.getAcademicYear().setAcyid(acyear);
		section.getClassName().setClassId(classId);

		try {
			sectionService.actualizar(section);
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Información",
					"Regisro actualizado correctamente");
			FacesContext.getCurrentInstance().addMessage(null, msg);
			getAllSectionName();
			clear();
		} catch (Exception e) {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Falló la actualización");
			FacesContext.getCurrentInstance().addMessage(null, msg);
			e.printStackTrace();
		}
	}

	void clear() {
		setAcyear(0);
		setClassName("");
		setSectionName("");
		setClassId(0);
	}

	public int getAcyear() {
		return acyear;
	}

	public void setAcyear(int acyear) {
		this.acyear = acyear;
	}

	public int getAcyearId() {
		return acyearId;
	}

	public void setAcyearId(int acyearId) {
		this.acyearId = acyearId;
	}

	public int getClassId() {
		return classId;
	}

	public void setClassId(int classId) {
		this.classId = classId;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public int getSectionId() {
		return sectionId;
	}

	public void setSectionId(int sectionId) {
		this.sectionId = sectionId;
	}

	public String getSectionName() {
		return sectionName;
	}

	public void setSectionName(String sectionName) {
		this.sectionName = sectionName;
	}

	public SectionName getSection() {
		return section;
	}

	public void setSection(SectionName section) {
		this.section = section;
	}

	public List<SectionName> getSections() {
		return sections;
	}

	public void setSections(List<SectionName> sections) {
		this.sections = sections;
	}

	public List<ClassName> getClassNames() {
		return classNames;
	}

	public void setClassNames(List<ClassName> classNames) {
		this.classNames = classNames;
	}

	public List<AcademicYear> getAcademicYears() {
		return academicYears;
	}

	public void setAcademicYears(List<AcademicYear> academicYears) {
		this.academicYears = academicYears;
	}

}
