/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ecole.user;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

import ec.edu.ecole.controller.BaseController;
import ec.edu.ecole.model.User;
import ec.edu.ecole.service.UserService;
import ec.edu.ecole.util.LoginUtil;

/**
 *
 * @author
 */
@Named
@SessionScoped
public class LoginBean extends BaseController implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private String userName;
	private String password;
	private String roleName;
	private int roleId;
	private boolean showLogin = true;
	private boolean showLogout;
	private String name;
	private String menu = "";
	private int userId;
	private String idNumber;

	/** Creates a new instance of LoginBean */
	public LoginBean() {
	}

	@Inject
	private UserService UserService;

	public void doLogin() {
		String returnPage = "log_in.xhtml";

		try {
			User user = UserService.getUserNadPassword(getUserName(), getPassword());
			if (user != null) {
				int isActive = user.getIsactive();
				String userType = user.getUserRole().getRoleName();
				setUserId(user.getUserId());
				setIdNumber(user.getIdNumber());
				if (isActive > 0) {
					if (userType.equalsIgnoreCase("Admin")) {
						HttpSession session = LoginUtil.getSession();
						session.setAttribute("username", getUserName());
						session.setAttribute("roleName", userType);
						setRoleName(userType);
						setShowLogout(true);
						setName(user.getFirstName());
						setMenu("/includes/menuAdmin.xhtml");
						returnPage = "paginas/admin/adminPanel?faces-redirect=true";
						redireccionarPagina("/paginas/admin/adminPanel.xhtml");
					}
					if (userType.equalsIgnoreCase("Teacher")) {
						HttpSession session = LoginUtil.getSession();
						session.setAttribute("username", getUserName());
						session.setAttribute("roleName", userType);
						setRoleName(userType);
						setName(user.getFirstName());
						setShowLogout(true);
						setMenu("/includes/menuTeacher.xhtml");
						returnPage = "paginas/teacher/teacherHome?faces-redirect=true";
						redireccionarPagina("/paginas/teacher/teacherHome.xhtml");
					}
					if (userType.equalsIgnoreCase("Student")) {
						System.out.println("Estudiante");
						HttpSession session = LoginUtil.getSession();
						session.setAttribute("username", getUserName());
						session.setAttribute("roleName", userType);
						setRoleName(userType);
						setName(user.getFirstName());
						setShowLogout(true);
						setMenu("/includes/menuStudent.xhtml");
						returnPage = "paginas/student/studentHome?faces-redirect=true";
						redireccionarPagina("/paginas/student/studentHome.xhtml");
					}
				} else {
					FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Information", "Userio no activo");
					FacesContext.getCurrentInstance().addMessage("warn", msg);
				}
			} else {
				FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",
						"Usuario o contraseña incorrectos");
				FacesContext.getCurrentInstance().addMessage("warn", msg);
			}
		} catch (Exception ex) {
			Logger.getLogger(LoginBean.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			try {
				clear();
			} catch (Exception ex) {
				Logger.getLogger(LoginBean.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
		clear();

		System.out.println(returnPage);
		// return returnPage;
	}

	public String goMyHome() {
		String returnPage = null;
		String usertype = getRoleName();
		if (usertype.equalsIgnoreCase("admin")) {
			returnPage = "adminhome";
		} else if (usertype.equalsIgnoreCase("teacher")) {
			returnPage = "teacherhome";
		} else if (usertype.equalsIgnoreCase("student")) {
			returnPage = "studenthome";
		} else {
		}
		return returnPage;
	}

	public String logout() {
		HttpSession session = LoginUtil.getSession();
		session.invalidate();
		setShowLogin(true);
		setShowLogout(false);
		setMenu("/includes/menu.xhtml");
		return "logout";
	}

	void clear() {
		setUserName(null);
		setPassword(null);
	}

	public String getMenu() {
		return menu;
	}

	public void setMenu(String menu) {
		this.menu = menu;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isShowLogin() {
		return showLogin;
	}

	public void setShowLogin(boolean showLogin) {
		this.showLogin = showLogin;
	}

	public boolean isShowLogout() {
		return showLogout;
	}

	public void setShowLogout(boolean showLogout) {
		this.showLogout = showLogout;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}

}
