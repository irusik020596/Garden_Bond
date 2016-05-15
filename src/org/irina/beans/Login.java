package org.irina.beans;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.irina.dao.LoginDAO;

//@ManagedBean
//@SessionScoped
public class Login implements Serializable {

	private static final long serialVersionUID = 1094801825228386363L;
	
	
	private String pwd;
	private String pwd2;
	private String msg;
	private String user;
	private String email;
	private String phone;
	private String address;

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getPwd2() {
		return pwd2;
	}

	public void setPwd2(String pwd2) {
		this.pwd2 = pwd2;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	//validate login
	public String validateUsernamePassword() {
		boolean valid = LoginDAO.validateLogin(user, pwd);
		//valid = true;
		if (valid) {
			HttpSession session = SessionBean.getSession();
			session.setAttribute("username", user);
			return "admin";
		} else {
			FacesContext.getCurrentInstance().addMessage(
					/*null*/"loginform:password",
					new FacesMessage(FacesMessage.SEVERITY_WARN,
							"Incorrect Username and Passowrd",
							"Please enter correct username and Password"));
			return "login";
		}
	}
	
	public String validateRegistration() {
	 
		boolean ok=true;
			if (user.equals("")) {
			      //System.out.println("Please enter your name");
			      //user="";
				FacesContext.getCurrentInstance().addMessage(
						"registrationform:username",
						new FacesMessage(FacesMessage.SEVERITY_WARN,
								"Empty Username",
								"Please enter correct username"));
			      ok = false;
			    }
			if (pwd.equals("")) {
//				System.out.println("Please enter your password");
//			      pwd="";
				FacesContext.getCurrentInstance().addMessage(
						"registrationform:password",
						new FacesMessage(FacesMessage.SEVERITY_WARN,
								"Empty password",
								"Please enter correct password"));
			      ok = false;
			    }
			if (pwd2.equals("")) {
//				System.out.println("Please confirm your password");
//			      pwd2="";
				FacesContext.getCurrentInstance().addMessage(
						"registrationform:password2",
						new FacesMessage(FacesMessage.SEVERITY_WARN,
								"Empty Confirm password",
								"Please enter correct confirm password"));
			      ok = false;
			    }
			if(!pwd.equals(pwd2)){
				FacesContext.getCurrentInstance().addMessage(
						"registrationform:password2",
						new FacesMessage(FacesMessage.SEVERITY_WARN,
								"Incorrect confirm password",
								"Please enter correct confirm password"));
				ok = false;
			}
			if (email.equals("")) {
//				System.out.println("Please enter your email");
//			      email="";
				FacesContext.getCurrentInstance().addMessage(
						"registrationform:email",
						new FacesMessage(FacesMessage.SEVERITY_WARN,
								"Empty Email",
								"Please enter correct email"));
			      ok=false;
			    }
			if (phone.equals("")) {
//				System.out.println("Please enter your phone");
//			      phone="";
				FacesContext.getCurrentInstance().addMessage(
						"registrationform:phone",
						new FacesMessage(FacesMessage.SEVERITY_WARN,
								"Empty phone",
								"Please enter correct phone"));
			      ok=false;
			    }
			if (address.equals("")) {
//				System.out.println("Please enter your address");
//			      address="";
				FacesContext.getCurrentInstance().addMessage(
						"registrationform:address",
						new FacesMessage(FacesMessage.SEVERITY_WARN,
								"Empty address",
								"Please enter correct address"));
			      ok=false;
			    }
			if(LoginDAO.existUser(user)){
//				System.out.println("We already have such user");
				FacesContext.getCurrentInstance().addMessage(
						"registrationform:username",
						new FacesMessage(FacesMessage.SEVERITY_WARN,
								"We already have such user",
								"We already have such user. Please enter another name"));
				ok = false;
			}
			//ok = false;
			if(ok == true)
			{
				ok = LoginDAO.addUser(user,  pwd, email, phone, address);
			}
			if(ok == false)
			{
				return "registration";
			}
			else
			{
				System.out.println("You are successfully registred");
				
				return "login";
			}
			
	}
	public String onRegistration(){
		return "registration";
	}

	//logout event, invalidate session
	public String logout() {
		HttpSession session = SessionBean.getSession();
		session.invalidate();
		return "login";
	}
}
