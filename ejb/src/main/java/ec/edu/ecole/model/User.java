package ec.edu.ecole.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the sch_user database table.
 * 
 */
@Entity
@Table(name="sch_user")
@NamedQuery(name="User.findAll", query="SELECT s FROM User s")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="user_id")
	private int userId;

	@Column(name="blood_grp")
	private String bloodGrp;

	@Column(name="first_name")
	private String firstName;

	@Column(name="full_uname")
	private String fullUname;

	@Column(name="id_number")
	private String idNumber;
	
	@Column(name="isactive")
	private Integer isactive;

	@Column(name="last_name")
	private String lastName;

	private String password;


	@Column(name="type_id_number")
	private Integer typeIdNumber;

	private String uname;

	@Temporal(TemporalType.DATE)
	@Column(name="user_dob")
	private Date userDob;

	@Lob
	@Column(name="user_photo")
	private byte[] userPhoto;

	
	//bi-directional many-to-one association to Parent
	@OneToMany(mappedBy="user")
	private List<Parent> parents;

	//bi-directional many-to-one association to StudentInfo
	@OneToMany(mappedBy="user")
	private List<StudentInfo> studentInfos;

	//bi-directional many-to-one association to TeacherInfo
	@OneToMany(mappedBy="user")
	private List<TeacherInfo> teacherInfos;

	//bi-directional many-to-one association to UserRole
	@ManyToOne
	@JoinColumn(name="role_id")
	private UserRole userRole;

	public User() {
	}

	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getBloodGrp() {
		return this.bloodGrp;
	}

	public void setBloodGrp(String bloodGrp) {
		this.bloodGrp = bloodGrp;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getFullUname() {
		return this.fullUname;
	}

	public void setFullUname(String fullUname) {
		this.fullUname = fullUname;
	}

	public String getIdNumber() {
		return this.idNumber;
	}

	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}

	public Integer getIsactive() {
		return this.isactive;
	}

	public void setIsactive(Integer isactive) {
		this.isactive = isactive;
	}

	

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	


	public Integer getTypeIdNumber() {
		return this.typeIdNumber;
	}

	public void setTypeIdNumber(Integer typeIdNumber) {
		this.typeIdNumber = typeIdNumber;
	}

	public String getUname() {
		return this.uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public Date getUserDob() {
		return this.userDob;
	}

	public void setUserDob(Date userDob) {
		this.userDob = userDob;
	}

	public byte[] getUserPhoto() {
		return this.userPhoto;
	}

	public void setUserPhoto(byte[] userPhoto) {
		this.userPhoto = userPhoto;
	}

	

	public List<Parent> getParents() {
		return this.parents;
	}

	public void setParents(List<Parent> parents) {
		this.parents = parents;
	}

	public Parent addParent(Parent parent) {
		getParents().add(parent);
		parent.setUser(this);

		return parent;
	}

	public Parent removeParent(Parent parent) {
		getParents().remove(parent);
		parent.setUser(null);

		return parent;
	}

	public List<StudentInfo> getStudentInfos() {
		return this.studentInfos;
	}

	public void setStudentInfos(List<StudentInfo> studentInfos) {
		this.studentInfos = studentInfos;
	}

	public StudentInfo addStudentInfo(StudentInfo studentInfo) {
		getStudentInfos().add(studentInfo);
		studentInfo.setUser(this);

		return studentInfo;
	}

	public StudentInfo removeStudentInfo(StudentInfo studentInfo) {
		getStudentInfos().remove(studentInfo);
		studentInfo.setUser(null);

		return studentInfo;
	}

	public List<TeacherInfo> getTeacherInfos() {
		return this.teacherInfos;
	}

	public void setTeacherInfos(List<TeacherInfo> teacherInfos) {
		this.teacherInfos = teacherInfos;
	}

	public TeacherInfo addTeacherInfo(TeacherInfo teacherInfo) {
		getTeacherInfos().add(teacherInfo);
		teacherInfo.setUser(this);

		return teacherInfo;
	}

	public TeacherInfo removeTeacherInfo(TeacherInfo teacherInfo) {
		getTeacherInfos().remove(teacherInfo);
		teacherInfo.setUser(null);

		return teacherInfo;
	}

	public UserRole getUserRole() {
		return this.userRole;
	}

	public void setUserRole(UserRole userRole) {
		this.userRole = userRole;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	
}