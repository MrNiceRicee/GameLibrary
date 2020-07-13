package controller;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;


import beans.User;
import beans.UserList;
@ManagedBean
@ViewScoped
public class FormController {

	static UserList uList = new UserList();
	
	public String onSubmit(User user) {
		//Forward to Test Response View along with the User Managed Bean
		FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("user", user);		
		return "MainUserScreen.xhtml";
	}
	
	public String index() {
		return "LoginPage.xhtml";
	}
	
	public String register() {
		return "Register.xhtml";
	}
}
