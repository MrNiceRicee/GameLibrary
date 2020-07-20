package controller;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import beans.User;
import beans.UserList;
import business.BusinessInterface;
import business.BusinessService;
@ManagedBean
@ViewScoped
public class FormController {
	@Inject
	BusinessInterface service;
	static UserList uList = new UserList();
	
	
	public String onSubmit(User user) {
		//Forward to Test Response View along with the User Managed Bean
		service.test();
		FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("user", user);
		return "MainUserScreen.xhtml";
	}
	
	public BusinessInterface getService() {
		return service;
	}
	
	public String index() {
		return "LoginPage.xhtml";
	}
	
	public String register() {
		return "Register.xhtml";
	}
}
