package beans;

import java.util.ArrayList;
import java.util.List;

public class UserList {

	
	List<User> theList = new ArrayList<User>();
	
	public UserList() {
		theList.addAll(new UserGenerator().generateUsers(10));
		theList.add(new User("joshua", "santos", 23, "(623)-806-3837", "streetaddress", "someemail", "josh", "pass"));
	}
	
	public List<User>getUsers(){
		return theList;
	}
	
	public void setUsers(List<User> users) {
		this.theList = users;
	}
}
