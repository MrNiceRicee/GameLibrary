package business;

import java.util.List;

import beans.Game;
import beans.User;
import data.UserDataService;

public interface BusinessInterface {

	public void test();
	public List<Game> getGames();
	public void createUser(User user);
}
