/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ecole.student;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import ec.edu.ecole.academic.AcademicYearBean;
import ec.edu.ecole.academic.ClassBean;
import ec.edu.ecole.academic.GroupBean;
import ec.edu.ecole.academic.SectionBean;
import ec.edu.ecole.user.UserBean;
import ec.edu.ecole.user.UserRoleBean;
import ec.edu.ecole.util.DBConnect;

/**
 *
 * @author MASHUK
 */
public class DisplayStudentInfo implements java.io.Serializable {

  private static final long serialVersionUID = 1L;
  private StudentBean studentBean;
  private StudentContactBean contactBean;
  private StudentRegistrationBean registrationBean;
  private StudentRagistrationFeeBean feeBean;
  private UserBean userBean;

  /** Creates a new instance of DisplayStudentInfo */
  public DisplayStudentInfo() {
  }

  public StudentContactBean getContactBean() {
    return contactBean;
  }

  public void setContactBean(StudentContactBean contactBean) {
    this.contactBean = contactBean;
  }

  public StudentRagistrationFeeBean getFeeBean() {
    return feeBean;
  }

  public void setFeeBean(StudentRagistrationFeeBean feeBean) {
    this.feeBean = feeBean;
  }

  public StudentRegistrationBean getRegistrationBean() {
    return registrationBean;
  }

  public void setRegistrationBean(StudentRegistrationBean registrationBean) {
    this.registrationBean = registrationBean;
  }

  public StudentBean getStudentBean() {
    return studentBean;
  }

  public void setStudentBean(StudentBean studentBean) {
    this.studentBean = studentBean;
  }

  public UserBean getUserBean() {
    return userBean;
  }

  public void setUserBean(UserBean userBean) {
    this.userBean = userBean;
  }

  
}
