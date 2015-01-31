package eu.infostart.jee.jsf;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import eu.infostart.ejb.entity.UserModel;
import eu.infostart.ejb.service.UserService;

@ManagedBean(name="loginBean")
@RequestScoped
public class LoginBean {

	@EJB
	UserService userService;
	
	private String username;
	private String password;
	
	public String login() {
		
		UserModel loggedUser = userService.loginUser(username, password);
		
		if(null != loggedUser) {

			HttpServletRequest request = (HttpServletRequest) FacesContext
					.getCurrentInstance().getExternalContext().getRequest();

			HttpSession session = request.getSession();
			session.setAttribute("loggedUser", loggedUser);
			
			return "/faces/success.xhtml";
		} else {
			return "/faces/error.xhtml";
		}
		
	}
	
	public String logout() {
		HttpServletRequest request = (HttpServletRequest) FacesContext
				.getCurrentInstance().getExternalContext().getRequest();

		HttpSession session = request.getSession();
		session.invalidate();
		
		return "/faces/login.xhtml";
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}
