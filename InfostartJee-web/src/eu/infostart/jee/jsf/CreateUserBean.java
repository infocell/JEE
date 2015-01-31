package eu.infostart.jee.jsf;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import eu.infostart.ejb.entity.UserModel;
import eu.infostart.ejb.service.UserService;
//import eu.infostart.ejb.service.UserServiceImpl;

@ManagedBean
@RequestScoped
public class CreateUserBean {

	@EJB
	UserService userService;

	private String username;
	private String password;
	private String email;
	private String name;
	private Integer age;
	private String phone;
	private String address;

	public String saveUser() {

		if (email != null && !email.contains("@")) {
			FacesMessage errorMessage = new FacesMessage("Email must contain @");
			FacesContext.getCurrentInstance().addMessage(null, errorMessage);
			return null;
		}
//		if (null != userService.userName(username)) {
//			FacesMessage errorMessageUser = new FacesMessage(
//					"Username already exist! Please enter a different username.");
//			FacesContext.getCurrentInstance()
//					.addMessage(null, errorMessageUser);
//			return null;
//		} else if (email != null && !email.contains("@")) {
//
//			FacesMessage errorMessage = new FacesMessage(
//					"Email must containt '@'");
//			FacesContext.getCurrentInstance().addMessage(null, errorMessage);
//			return null;
//		}

		// UserServiceImpl takenUsername = new UserServiceImpl();
		// if(takenUsername.isAlreadyTakenUsername(username) == true) {
		//
		// }

		UserModel user = new UserModel();

		user.setUsername(username);
		user.setPassword(password);
		user.setEmail(email);
		user.setName(name);
		user.setAge(age);
		user.setPhone(phone);
		user.setAddress(address);

		userService.saveUser(user);

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
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

}
