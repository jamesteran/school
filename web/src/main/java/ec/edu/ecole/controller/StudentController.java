/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ecole.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.component.datatable.DataTable;
import org.primefaces.event.CellEditEvent;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.UploadedFile;

import ec.edu.ecole.enumerator.BloodGrpEnum;
import ec.edu.ecole.enumerator.EstadoCivilEnum;
import ec.edu.ecole.enumerator.GeneroEnum;
import ec.edu.ecole.enumerator.NivelEducacionEnum;
import ec.edu.ecole.enumerator.ParentescoEnum;
import ec.edu.ecole.model.AcademicYear;
import ec.edu.ecole.model.Custodian;
import ec.edu.ecole.model.EnvoiceClient;
import ec.edu.ecole.model.Group;
import ec.edu.ecole.model.MedicalAnswer;
import ec.edu.ecole.model.MedicalQuiz;
import ec.edu.ecole.model.Parent;
import ec.edu.ecole.model.ParentType;
import ec.edu.ecole.model.Parroquia;
import ec.edu.ecole.model.Registration;
import ec.edu.ecole.model.SectionName;
import ec.edu.ecole.model.StudentInfo;
import ec.edu.ecole.model.Transport;
import ec.edu.ecole.model.User;
import ec.edu.ecole.model.UserRole;
import ec.edu.ecole.service.AcademicYearService;
import ec.edu.ecole.service.ClassService;
import ec.edu.ecole.service.CustodianService;
import ec.edu.ecole.service.EnvoiceClientService;
import ec.edu.ecole.service.EstudianteService;
import ec.edu.ecole.service.MedicalAnswerService;
import ec.edu.ecole.service.MedicalQuizService;
import ec.edu.ecole.service.ParentService;
import ec.edu.ecole.service.ParentTypeService;
import ec.edu.ecole.service.ParroquiaService;
import ec.edu.ecole.service.RegistrationService;
import ec.edu.ecole.service.SectionService;
import ec.edu.ecole.service.TransportService;
import ec.edu.ecole.service.UserService;
import ec.edu.ecole.user.LoginBean;
import ec.edu.ecole.util.Constantes;
import ec.edu.ecole.util.ImageUtil;

/**
 *
 * @author jaimet
 */
@Named
@ViewScoped
public class StudentController extends BaseController implements java.io.Serializable {

	private static final Logger LOG = Logger.getLogger(StudentController.class.getName());
	private static final long serialVersionUID = 1L;

	@Inject
	private EstudianteService estudianteService;

	@Inject
	private ParentService parentService;

	@Inject
	private ParentTypeService parentTypeService;

	@Inject
	private ParroquiaService parroquiaService;

	@Inject
	private UserService userService;

	@Inject
	private EnvoiceClientService envoiceService;

	@Inject
	private TransportService transportService;

	@Inject
	private MedicalQuizService medicalQuizService;

	@Inject
	private MedicalAnswerService medicalAnswerService;

	@Inject
	private CustodianService custodianService;

	@Inject
	private RegistrationService registratioService;

	@Inject
	private ClassService classService;

	@Inject
	private AcademicYearService academicYearService;

	@Inject
	private SectionService sectionService;

	@Inject
	private LoginBean loginBean;

	private StudentInfo studentInfo;
	private Parent parentMon = new Parent();
	private Parent parentPha = new Parent();
	private Parent phather = new Parent();
	private Parent mather = new Parent();
	private User userPha = new User();
	private User userMa = new User();
	private Custodian representante = new Custodian();
	private User personaRecibe = new User();
	private User hermano = new User();
	private EnvoiceClient envoice = new EnvoiceClient();
	private Transport transport = new Transport();
	private MedicalAnswer medicalAnswer = new MedicalAnswer();
	private Registration matriculaActual = new Registration();
	private Registration matriculaProxima = new Registration();

	private List<StudentInfo> students = new ArrayList<>();
	private List<Parroquia> parroquias = new ArrayList<>();
	private List<Custodian> representantes = new ArrayList<>();
	private List<Custodian> personasRecibe = new ArrayList<>();
	private List<Custodian> hermanos = new ArrayList<>();
	private List<Parent> parents = new ArrayList<>();
	private List<ParentType> parentTypes = new ArrayList<>();
	private List<MedicalQuiz> medicalQuizes = new ArrayList<>();
	private List<MedicalAnswer> medicalAnswers = new ArrayList<>();

	private BloodGrpEnum[] bloodGrp;
	private GeneroEnum[] genero;
	private NivelEducacionEnum[] nivEducacion;
	private EstadoCivilEnum[] estadoCivil;
	private ParentescoEnum[] parentesco;

	private String parentescoRep;
	private String parentescoHermano;
	private String parentescoPersonRecibe;
	private StreamedContent studentImage;
	private StreamedContent parentImage;
	private StreamedContent custodianImage;
	private UploadedFile studentPhoto;
	private UploadedFile parentPhoto;
	private UploadedFile custodianPhoto;
	private byte[] studentImageByte;
	private byte[] parentImageByte;
	private byte[] custodianImageByte;
	private String studentPic;
	private String parentPic;
	private String custodianPic;
	private String saveParent = "S";
	private String saveCustodian = "S";
	private boolean needTransport = false;
	private boolean morningTransport = false;
	private boolean noonTransport = false;

	@PostConstruct
	public void init() {

		representantes = new ArrayList<>();
		studentInfo = new StudentInfo();
		parents = new ArrayList<>();
		studentInfo.setParroquia(new Parroquia());
		newParent();
		findParroquiasByCityName();
		findPrentTypes();
		buscarStudentByIdNumber();

	}

	public void buscarStudentByIdNumber() {

		String idNumber = loginBean.getIdNumber();
		System.out.println("tttttttttttttt  " + loginBean.getIdNumber());
		studentInfo = estudianteService.getByCedula(idNumber);

		if (studentInfo != null) {
			if (studentInfo.getUser().getUserPhoto() != null) {
				InputStream isStudent = new ByteArrayInputStream((byte[]) studentInfo.getUser().getUserPhoto());
				studentImage = new DefaultStreamedContent(isStudent, "image/png", "imgstudent.png");
				studentPic = Base64.getEncoder().encodeToString((byte[]) studentInfo.getUser().getUserPhoto());
			}

			if (studentInfo.getMom() != null) {
				buscarParentPha(studentInfo.getMom().getParentId());
				if (parentPha != null) {
					parents.add(parentPha);
				}
			}

			if (studentInfo.getPha() != null) {
				buscarParentPha(studentInfo.getPha().getParentId());
				if (parentPha != null) {
					parents.add(parentPha);
				}
			}

			buscarRepresentantes(studentInfo.getStdId());
			if (!(representantes != null && representantes.size() > 0)) {
				representantes = new ArrayList<>();
			}

			if (studentInfo.getParroquia() == null) {
				studentInfo.setParroquia(new Parroquia());
				System.out.println("--------------" + studentInfo.getParroquia());
			}

			buscarEnvoiceClient(studentInfo.getStdId());
			if (envoice == null) {
				System.out.println("Factura Nula >>>>>>>>>>>>>>>" + studentInfo.getStdId());
				envoice = new EnvoiceClient();
			}

			buscarTransport(studentInfo.getStdId());
			if (transport == null) {
				transport = new Transport();
			}

			buscarFichaMedica(studentInfo.getStdId());
			if (medicalAnswers != null && medicalAnswers.size() > 0) {

			} else {
				medicalQuizes = medicalQuizService.findAllActive();
				if (medicalQuizes != null && medicalQuizes.size() > 0) {
					medicalAnswers = new ArrayList<>();
					for (MedicalQuiz quiz : medicalQuizes) {
						MedicalAnswer answer = new MedicalAnswer();
						answer.setSchMedicalQuiz(quiz);
						medicalAnswers.add(answer);
					}
				}
			}

			buscarMatricula(studentInfo.getStdId());

		} else {
			agregarMensajeError("Error", "No se encontró información del estudiante.");
		}
	}

	public void buscarParentPha(int phaId) {
		try {
			parentPha = parentService.findById(phaId);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void findParroquiasByCityName() {
		parroquias = parroquiaService.getByCityName(Constantes.CODIGO_CANTON_CUENCA);
	}

	public void findPrentTypes() {
		parentTypes = parentTypeService.findAll();
	}

	public void buscarEnvoiceClient(int stdId) {
		envoice = envoiceService.getEnvoiceByStdId(stdId);
	}

	public void buscarTransport(int stdId) {
		transport = transportService.getTransportByStdId(stdId);
	}

	public void buscarFichaMedica(int stdId) {
		medicalAnswers = medicalAnswerService.getMedicalAnswerByStdId(stdId);
	}

	public void buscarRepresentantes(int stdId) {
		representantes = custodianService.buscarCustodiansByStdId(stdId);
	}

	public void buscarParentByCedula() {
		String id = parentPha.getIdNumber();
		parentPha = parentService.getPharentByCedula(id);
		if (parentPha == null) {
			parentPha = new Parent();
			parentPha.setIdNumber(id);
			parentPha.setParroquia(new Parroquia());
			parentPha.setParentType(new ParentType());
			User user = userService.getByCedula(id);
			if (user != null) {
				parentPha.setIdNumber(user.getIdNumber());
				parentPha.setFirstName(user.getFirstName());
				parentPha.setLastName(user.getLastName());
			}
		} else {
			if (parentPha.getUser().getUserPhoto() != null) {
				InputStream is = new ByteArrayInputStream((byte[]) parentPha.getUser().getUserPhoto());
				parentImage = new DefaultStreamedContent(is, "image/png");
				parentPic = Base64.getEncoder().encodeToString((byte[]) parentPha.getUser().getUserPhoto());
			}
		}
	}

	public void buscarCustodianByCedula() {
		String id = representante.getIdNumber();
		representante = custodianService.getCustodianByCedula(id);
		System.out.println("--------------" + representante.getIdNumber());
		if (representante == null) {
			representante = new Custodian();
			representante.setIdNumber(id);
		} else {
			if (representante.getCustPhoto() != null) {
				InputStream is = new ByteArrayInputStream((byte[]) representante.getCustPhoto());
				custodianImage = new DefaultStreamedContent(is, "image/png");
				custodianPic = Base64.getEncoder().encodeToString((byte[]) representante.getCustPhoto());
			}
		}
	}

	public void buscarMatricula(int stdId) {
		System.out.println("Entra matricula ------------------------");
		List<Registration> listRegistration = registratioService.getRegistrationByStdId(stdId);
		matriculaProxima = new Registration();
		if (listRegistration != null && listRegistration.size() > 0) {
			matriculaActual = listRegistration.get(0);

			// ClassName className = classService
			// .getClassByNivel(matriculaActual.getSectionName().getClassName().getClassNivel()
			// + 1);
			Group group = new Group();
			group.setGroupId(1);
			AcademicYear acyYear = academicYearService
					.getAcademicYearBySec(matriculaActual.getAcademicYear().getAcySec() + 1);
			if (acyYear != null) {
				System.out.println("Año ------------------------" + acyYear.getAcySec());
				System.out.println("Nivel ------------------------"
						+ matriculaActual.getSectionName().getClassName().getClassNivel() + 1);
				System.out.println(
						"Paralelo ------------------------" + matriculaActual.getSectionName().getSectionName());
				SectionName section = sectionService.getSectionByYearClass(acyYear.getAcySec(),
						matriculaActual.getSectionName().getClassName().getClassNivel() + 1,
						matriculaActual.getSectionName().getSectionName());
				if (section != null) {
					matriculaProxima.setStdGroup(group);
					matriculaProxima.setAcademicYear(acyYear);
					matriculaProxima.setStudentInfo(studentInfo);
					matriculaProxima.setActive(1);
					matriculaProxima.setSectionName(section);
				}
			}

		}

	}

	public void editParent() {
		String id = parentPha.getIdNumber();
		System.out.println("--------------" + parentPha.getIdNumber());
		saveParent = "E";
		parentPha = parentService.getPharentByCedula(id);
		if (parentPha == null) {
			parentPha = new Parent();
			parentPha.setIdNumber(id);
			parentPha.setParroquia(new Parroquia());
			parentPha.setParentType(new ParentType());
		} else {
			if (parentPha.getUser().getUserPhoto() != null) {
				InputStream is = new ByteArrayInputStream((byte[]) parentPha.getUser().getUserPhoto());
				parentImage = new DefaultStreamedContent(is, "image/png");
				parentPic = Base64.getEncoder().encodeToString((byte[]) parentPha.getUser().getUserPhoto());
			}
		}
	}

	public void editCustodian() {
		String id = representante.getIdNumber();
		saveCustodian = "E";
		representante = custodianService.getCustodianByCedula(id);
		if (representante == null) {
			representante = new Custodian();
			representante.setIdNumber(id);
		} else {
			if (representante.getCustPhoto() != null) {
				InputStream is = new ByteArrayInputStream((byte[]) representante.getCustPhoto());
				custodianImage = new DefaultStreamedContent(is, "image/png");
				custodianPic = Base64.getEncoder().encodeToString((byte[]) representante.getCustPhoto());
			}
		}
	}

	public void deleteParent() {
		parents.remove(parentPha);
	}

	public void newParent() {
		parentPha = new Parent();
		parentPha.setParroquia(new Parroquia());
		parentPha.setParentType(new ParentType());
		saveParent = "S";
		parentImageByte = null;
	}

	public void newRepresentante() {
		representante = new Custodian();
		custodianImageByte = null;
		saveCustodian = "S";
		custodianPic = null;
	}

	public void addParent() {
		System.out.println("entra en metodo");
		if (parentPic != null) {
			User parentUser = userService.getByCedula(parentPha.getIdNumber());
			if (parents.stream().filter(parent -> parentPha.getIdNumber().equals(parent.getIdNumber())).findAny()
					.orElse(null) == null) {
				System.out.println("No es repetido");
				if (parentUser != null) {
					if (parentImageByte != null) {
						System.out.println("SSSSSSSSSSSSSS" + parentImageByte.toString());
						parentUser.setUserPhoto((byte[]) parentImageByte);
						parentPha.setUser(parentUser);
						try {
							userService.actualizar(parentUser);
						} catch (Exception e) {
							LOG.severe(
									String.format("addParent():Exception: al actualizar parent" + e.getMessage(), ""));
						}
					}
				}
				if (parentUser == null) {
					UserRole userRole = new UserRole();
					User user = new User();
					userRole.setRoleId(4);
					user.setUserRole(userRole);
					user.setFirstName(parentPha.getFirstName());
					user.setLastName(parentPha.getLastName());
					user.setIdNumber(parentPha.getIdNumber());
					user.setUname(parentPha.getIdNumber());
					user.setPassword(parentPha.getIdNumber());
					user.setFullUname(parentPha.getFirstName() + " " + parentPha.getLastName());
					user.setIsactive(1);
					user.setUserDob(new Date());
					user.setUserPhoto((byte[]) parentImageByte);
					try {
						userService.guardar(user);
					} catch (Exception e) {
						agregarMensajeError("ERROR", "Existio un error al agregar el progenitor");
						LOG.severe(String.format(
								"addParent():Exception: Error en guardar nuevo usuario: " + e.getMessage(), ""));
					}

					User user1 = userService.getByCedula(parentPha.getIdNumber());
					if (user1 != null) {
						parentPha.setUser(user1);
					}
				}

				if (parentPha.getParentId() == 0) {
					try {
						parentService.guardar(parentPha);
					} catch (Exception e) {
						agregarMensajeError("ERROR", "Existio un error al agregar el progenitor");
						LOG.severe(
								String.format("addParent():Exception: Error en guardar parent: " + e.getMessage(), ""));
					}
				}

				Parent parent1 = parentService.getPharentByCedula(parentPha.getIdNumber());
				if (parent1 != null && parents.size() < 2) {
					parents.add(parent1);

					if (parentPha.isRetStudent()) {
						Custodian cust = new Custodian();
						cust.setActive(1);
						cust.setCustCelular(parentPha.getParentMobil());
						cust.setCustDirTrabajo(parentPha.getWorkDir());
						cust.setCustEmail(parentPha.getParentEmail());
						cust.setCustTelefono(parentPha.getParentPhone());
						cust.setCustParent((parentPha.getParentType().getPrntypeId() == 1) ? "PADRE" : "MADRE");
						cust.setCustLugTrabajo(parentPha.getWorkPlace());
						cust.setCustPhoto(parentPha.getUser().getUserPhoto());
						cust.setFirstName(parentPha.getFirstName());
						cust.setLastName(parentPha.getLastName());
						cust.setIdNumber(parentPha.getIdNumber());
						this.setRepresentante(cust);
						addCustodian();
					}
				}
			}
		} else {
			System.out.println("No tiene foto");
			agregarMensajeError("Campo Requerido", "Debe agregar una foto carnet.");
		}

		// newParent();
	}

	public void addCustodian() {
		if (representantes.stream().filter(rep -> representante.getIdNumber().equals(rep.getIdNumber())).findAny()
				.orElse(null) == null) {
			if (custodianImageByte != null) {
				representante.setCustPhoto((byte[]) parentImageByte);
			}
			if (representante != null) {
				try {
					representante.setStudentInfo(studentInfo);
					custodianService.guardar(representante);
					representantes.add(representante);
				} catch (Exception e) {
					agregarMensajeError("ERROR", "Existio un error al agregar el registro");
					LOG.severe(String
							.format("addCustodian():Exception: Error en guardar el regsitro: " + e.getMessage(), ""));
				}
			}
		}
		newRepresentante();
	}

	public void updateParent() {
		User parentUser = userService.getByCedula(parentPha.getIdNumber());

		if (parentUser != null) {

			if (parentImageByte != null) {
				parentUser.setUserPhoto((byte[]) parentImageByte);
				parentPha.setUser(parentUser);
				try {
					userService.actualizar(parentUser);
					parentService.actualizar(parentPha);
				} catch (Exception e) {
					agregarMensajeError("ERROR", "Existió un error al actualizar el progenitor");
					LOG.severe(String.format("addParent():Exception: Error en actualizar  usuario: " + e.getMessage(),
							""));
				}
			} else if (parentUser.getUserPhoto() != null) {
				try {
					parentService.actualizar(parentPha);
					if (parentPha.isRetStudent()) {
						Custodian cust = new Custodian();
						cust.setActive(1);
						cust.setCustCelular(parentPha.getParentMobil());
						cust.setCustDirTrabajo(parentPha.getWorkDir());
						cust.setCustEmail(parentPha.getParentEmail());
						cust.setCustTelefono(parentPha.getParentPhone());
						cust.setCustParent((parentPha.getParentType().getPrntypeId() == 1) ? "PADRE" : "MADRE");
						cust.setCustLugTrabajo(parentPha.getWorkPlace());
						cust.setCustPhoto(parentPha.getUser().getUserPhoto());
						cust.setFirstName(parentPha.getFirstName());
						cust.setLastName(parentPha.getLastName());
						cust.setIdNumber(parentPha.getIdNumber());
						this.setRepresentante(cust);
						addCustodian();
					}
				} catch (Exception e) {
					LOG.severe(String.format("addParent():Exception: Error en actualizar  usuario: " + e.getMessage(),
							""));
				}
			} else {
				agregarMensajeError("ERROR", "Debe agregar una fotografía tamaño carnet");
			}
		}
	}

	public void updateCustodian() {

		if (custodianImageByte != null) {
			representante.setCustPhoto((byte[]) custodianImageByte);
		}
		try {
			custodianService.actualizar(representante);
		} catch (Exception e) {
			LOG.severe(String.format("updateCustodian():Exception: Error en actualizar el registro: " + e.getMessage(),
					""));
		}
		newRepresentante();
	}

	public void deleteCustodian() {

		representante.setActive(0);
		try {
			custodianService.actualizar(representante);
			buscarRepresentantes(studentInfo.getStdId());
		} catch (Exception e) {
			LOG.severe(String.format("updateCustodian():Exception: Error en actualizar el registro: " + e.getMessage(),
					""));
		}
		// newRepresentante();
	}

	public void changeStudentPhoto(FileUploadEvent e) {
		this.studentPhoto = e.getFile();
		InputStream streamFile;
		ImageUtil imgUtil = new ImageUtil();
		try {
			streamFile = this.getStudentPhoto().getInputstream();
			studentImage = new DefaultStreamedContent(streamFile, "image/png", "imgstudent.png");
			studentImageByte = this.getStudentPhoto().getContents();
			studentPic = Base64.getEncoder().encodeToString((byte[]) studentImageByte);
		} catch (Exception ex) {
			LOG.severe(String.format("addParent():Exception: Error conversion imagen: " + ex.getMessage(), ""));
		}
	}

	public void changeParentPhoto(FileUploadEvent e) {
		this.parentPhoto = e.getFile();
		InputStream streamFile;
		try {
			streamFile = this.getParentPhoto().getInputstream();
			parentImage = new DefaultStreamedContent(streamFile, "image/png");
			parentImageByte = this.getParentPhoto().getContents();
			parentPic = Base64.getEncoder().encodeToString((byte[]) parentImageByte);
		} catch (IOException ex) {
			LOG.severe(String.format("addParent():Exception: Error en conversion imagen: " + ex.getMessage(), ""));
		}
	}

	public void changeRepresentantePhoto(FileUploadEvent e) {
		this.custodianPhoto = e.getFile();
		InputStream streamFile;
		try {
			streamFile = this.getCustodianPhoto().getInputstream();
			custodianImage = new DefaultStreamedContent(streamFile, "image/png");
			custodianImageByte = this.getCustodianPhoto().getContents();
			custodianPic = Base64.getEncoder().encodeToString((byte[]) custodianImageByte);
		} catch (Exception ex) {
			LOG.severe(String.format(
					"changeRepresentantePhoto():Exception: Error en conversion imagen: " + ex.getMessage(), ""));
		}
	}

	public void onAnswerEdit(CellEditEvent value) {
		Object newValue = value.getNewValue();
		System.out.println("Rowwwwwwwwww " + medicalAnswer.getQuizAnswer() + newValue.toString());
		DataTable table = (DataTable) value.getSource();
		List<?> elements = (List<?>) table.getValue();
		MedicalAnswer obj = (MedicalAnswer) elements.get(value.getRowIndex());
		// System.out.println("------------"+obj.getSchMedicalQuiz().getQuizId());
		medicalAnswers.replaceAll(answer -> {
			if (answer.getSchMedicalQuiz().getQuizId() == obj.getSchMedicalQuiz().getQuizId())
				answer.setQuizAnswer(newValue.toString());
			return answer;
		});
		// FacesMessage msg = new FacesMessage("Car Edited",
		// event.getObject().getId());
		// FacesContext.getCurrentInstance().addMessage(null, msg);n
	}

	public void guardarEstudiante() {
		if (validarCampos()) {
			System.out.println("CAMPOS VALIDADOS---------------------");
			if (matriculaProxima != null) {
				try {
					for (MedicalAnswer answer : medicalAnswers) {
						medicalAnswerService.guardar(answer);
					}

					if (transport != null && transport.isNeedTrans()) {
						transportService.guardar(transport);
					}

					for (Parent parent : parents) {
						if (parent.getParentType().getPrntypeId() == 1)
							studentInfo.setMom(parent);
						if (parent.getParentType().getPrntypeId() == 2)
							studentInfo.setPha(parent);
					}

					User user = userService.getByCedula(studentInfo.getIdNumber());
					if (studentImageByte != null && user != null) {
						user.setUserPhoto((byte[]) studentImageByte);
						studentInfo.setUser(user);
					}

					if (envoice != null) {
						if (envoice.getEnvcliId() == 0)
							envoiceService.guardar(envoice);
						else
							envoiceService.actualizar(envoice);
					}

					estudianteService.actualizar(studentInfo);

					if (matriculaProxima != null) {
						registratioService.guardar(matriculaProxima);
					}

				} catch (Exception ex) {
					Logger.getLogger(StudentController.class.getName()).log(Level.SEVERE, null, ex);
				}
			} else {
				agregarMensajeError("Error", "No tiene una matrícula asignada.");
			}
		}

	}

	public boolean validarCampos() {
		boolean validado = true;
		System.out.println("CAMPOS VALIDADOS---------------------");
		if (studentPic == null) {
			agregarMensajeError("Campo Requerido", "Debe agregar una foto carnet de estudiante.");
			validado = false;
		}

		return validado;
	}

	// Inicio getter and setters
	public List<StudentInfo> getStudents() {
		return students;
	}

	public void setStudents(List<StudentInfo> students) {
		this.students = students;
	}

	public StudentInfo getStudentInfo() {
		return studentInfo;
	}

	public void setStudentInfo(StudentInfo studentInfo) {
		this.studentInfo = studentInfo;
	}

	public String goEditPage() {
		return "editStudent";
	}

	public Parent getPhather() {
		return phather;
	}

	public void setPhather(Parent phather) {
		this.phather = phather;
	}

	public Parent getMather() {
		return mather;
	}

	public void setMather(Parent mather) {
		this.mather = mather;
	}

	public User getUserPha() {
		return userPha;
	}

	public void setUserPha(User userPha) {
		this.userPha = userPha;
	}

	public User getUserMa() {
		return userMa;
	}

	public void setUserMa(User userMa) {
		this.userMa = userMa;
	}

	public List<Parroquia> getParroquias() {
		return parroquias;
	}

	public void setParroquias(List<Parroquia> parroquias) {
		this.parroquias = parroquias;
	}

	public BloodGrpEnum[] getBloodGrp() {
		return BloodGrpEnum.values();
	}

	public GeneroEnum[] getGenero() {
		return GeneroEnum.values();
	}

	public Parent getParentMon() {
		return parentMon;
	}

	public void setParentMon(Parent parentMon) {
		this.parentMon = parentMon;
	}

	public Parent getParentPha() {
		return parentPha;
	}

	public void setParentPha(Parent parentPha) {
		this.parentPha = parentPha;
	}

	public NivelEducacionEnum[] getNivEducacion() {
		return NivelEducacionEnum.values();
	}

	public void setNivEducacion(NivelEducacionEnum[] nivEducacion) {
		this.nivEducacion = nivEducacion;
	}

	public EstadoCivilEnum[] getEstadoCivil() {
		return EstadoCivilEnum.values();
	}

	public void setEstadoCivil(EstadoCivilEnum[] estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public User getPersonaRecibe() {
		return personaRecibe;
	}

	public void setPersonaRecibe(User personaRecibe) {
		this.personaRecibe = personaRecibe;
	}

	public User getHermano() {
		return hermano;
	}

	public void setHermano(User hermano) {
		this.hermano = hermano;
	}

	public List<Custodian> getRepresentantes() {
		return representantes;
	}

	public void setRepresentantes(List<Custodian> representantes) {
		this.representantes = representantes;
	}

	public List<Custodian> getPersonasRecibe() {
		return personasRecibe;
	}

	public void setPersonasRecibe(List<Custodian> personasRecibe) {
		this.personasRecibe = personasRecibe;
	}

	public List<Custodian> getHermanos() {
		return hermanos;
	}

	public void setHermanos(List<Custodian> hermanos) {
		this.hermanos = hermanos;
	}

	public ParentescoEnum[] getParentesco() {
		return ParentescoEnum.values();
	}

	public void setParentesco(ParentescoEnum[] parentesco) {
		this.parentesco = parentesco;
	}

	public String getParentescoRep() {
		return parentescoRep;
	}

	public void setParentescoRep(String parentescoRep) {
		this.parentescoRep = parentescoRep;
	}

	public String getParentescoHermano() {
		return parentescoHermano;
	}

	public void setParentescoHermano(String parentescoHermano) {
		this.parentescoHermano = parentescoHermano;
	}

	public String getParentescoPersonRecibe() {
		return parentescoPersonRecibe;
	}

	public void setParentescoPersonRecibe(String parentescoPersonRecibe) {
		this.parentescoPersonRecibe = parentescoPersonRecibe;
	}

	public Custodian getRepresentante() {
		return representante;
	}

	public void setRepresentante(Custodian representante) {
		this.representante = representante;
	}

	public void setGenero(GeneroEnum[] genero) {
		this.genero = genero;
	}

	public List<Parent> getParents() {
		return parents;
	}

	public void setParents(List<Parent> parents) {
		this.parents = parents;
	}

	public List<ParentType> getParentTypes() {
		return parentTypes;
	}

	public void setParentTypes(List<ParentType> parentTypes) {
		this.parentTypes = parentTypes;
	}

	public StreamedContent getStudentImage() {
		return studentImage;
	}

	public void setStudentImage(StreamedContent studentImage) {
		this.studentImage = studentImage;
	}

	public UploadedFile getStudentPhoto() {
		return studentPhoto;
	}

	public void setStudentPhoto(UploadedFile studentPhoto) {
		this.studentPhoto = studentPhoto;
	}

	public StreamedContent getParentImage() {
		return parentImage;
	}

	public void setParentImage(StreamedContent parentImage) {
		this.parentImage = parentImage;
	}

	public StreamedContent getCustodianImage() {
		return custodianImage;
	}

	public void setCustodianImage(StreamedContent custodianImage) {
		this.custodianImage = custodianImage;
	}

	public UploadedFile getParentPhoto() {
		return parentPhoto;
	}

	public void setParentPhoto(UploadedFile parentPhoto) {
		this.parentPhoto = parentPhoto;
	}

	public UploadedFile getCustodianPhoto() {
		return custodianPhoto;
	}

	public void setCustodianPhoto(UploadedFile custodianPhoto) {
		this.custodianPhoto = custodianPhoto;
	}

	public EnvoiceClient getEnvoice() {
		return envoice;
	}

	public void setEnvoice(EnvoiceClient envoice) {
		this.envoice = envoice;
	}

	public byte[] getParentImageByte() {
		return parentImageByte;
	}

	public void setParentImageByte(byte[] parentImageByte) {
		this.parentImageByte = parentImageByte;
	}

	public String getStudentPic() {
		return studentPic;
	}

	public void setStudentPic(String studentPic) {
		this.studentPic = studentPic;
	}

	public byte[] getStudentImageByte() {
		return studentImageByte;
	}

	public void setStudentImageByte(byte[] studentImageByte) {
		this.studentImageByte = studentImageByte;
	}

	public byte[] getCustodianImageByte() {
		return custodianImageByte;
	}

	public void setCustodianImageByte(byte[] custodianImageByte) {
		this.custodianImageByte = custodianImageByte;
	}

	public String getSaveParent() {
		return saveParent;
	}

	public void setSaveParent(String saveParent) {
		this.saveParent = saveParent;
	}

	public String getParentPic() {
		return parentPic;
	}

	public void setParentPic(String parentPic) {
		this.parentPic = parentPic;
	}

	public String getCustodianPic() {
		return custodianPic;
	}

	public void setCustodianPic(String custodianPic) {
		this.custodianPic = custodianPic;
	}

	public Transport getTransport() {
		return transport;
	}

	public void setTransport(Transport transport) {
		this.transport = transport;
	}

	public boolean isNeedTransport() {
		return needTransport;
	}

	public void setNeedTransport(boolean needTransport) {
		this.needTransport = needTransport;
	}

	public boolean isMorningTransport() {
		return morningTransport;
	}

	public void setMorningTransport(boolean morningTransport) {
		this.morningTransport = morningTransport;
	}

	public boolean isNoonTransport() {
		return noonTransport;
	}

	public void setNoonTransport(boolean noonTransport) {
		this.noonTransport = noonTransport;
	}

	public List<MedicalQuiz> getMedicalQuizes() {
		return medicalQuizes;
	}

	public void setMedicalQuizes(List<MedicalQuiz> medicalQuizes) {
		this.medicalQuizes = medicalQuizes;
	}

	public List<MedicalAnswer> getMedicalAnswers() {
		return medicalAnswers;
	}

	public void setMedicalAnswers(List<MedicalAnswer> medicalAnswers) {
		this.medicalAnswers = medicalAnswers;
	}

	public MedicalAnswer getMedicalAnswer() {
		return medicalAnswer;
	}

	public void setMedicalAnswer(MedicalAnswer medicalAnswer) {
		this.medicalAnswer = medicalAnswer;
	}

	public String getSaveCustodian() {
		return saveCustodian;
	}

	public void setSaveCustodian(String saveCustodian) {
		this.saveCustodian = saveCustodian;
	}

	public Registration getMatriculaActual() {
		return matriculaActual;
	}

	public void setMatriculaActual(Registration matriculaActual) {
		this.matriculaActual = matriculaActual;
	}

	public Registration getMatriculaProxima() {
		return matriculaProxima;
	}

	public void setMatriculaProxima(Registration matriculaProxima) {
		this.matriculaProxima = matriculaProxima;
	}

}
