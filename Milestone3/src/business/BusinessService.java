package business;

import java.io.Console;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;

import beans.CustomRandomizer;
import beans.Game;
import beans.User;
import data.GameDataService;
import data.UserDataService;

/**
 * Session Bean implementation class BusinessService
 */
@Stateless
@Local(BusinessInterface.class)
@LocalBean
@Alternative
public class BusinessService implements BusinessInterface {

	@EJB
	UserDataService userservice;
	
	@EJB
	GameDataService gameservice;
	
	List<Game> games = new ArrayList<Game>();
	
    public BusinessService() {
        //games.addAll(new CustomRandomizer().generateGames(20));
        System.out.println("There are "+games.size()+" games generated");
    }

	@Override
	public void test() {
		System.out.println("Hello this is from BusinessService");
		
	}

	@Override
	public List<Game> getGames() {
		return gameservice.findAll();
	}

	@Override
	public void createUser(User user) {
		userservice.create(user);
	}

}
