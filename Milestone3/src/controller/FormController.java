package controller;


import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import beans.CustomRandomizer;
import beans.Game;
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
		
/*
		List<Game> generateGames = new ArrayList<Game>();
		generateGames.addAll(new CustomRandomizer().generateGames(99));
		String up = "";
		for (int i = 0; i < generateGames.size(); i++) {
			up += generateGames.get(i).getInsert() +" ";
		}
		System.out.println(up);

		*/
		
		return "MainUserScreen.xhtml";
	}
	
	public String userJustRegistered(User user) {
		service.createUser(user);
		return "LoginPage.xhtml";
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
