package beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;

@ManagedBean
@ViewScoped
public class User {

	@NotNull(message = "Please enter a first name.")
	@Size(min=2,max=15,message = "Minimim: 2. Maximum: 15")
	public String firstname;
	@NotNull(message = "Please enter a last name.")
	@Size(min=2,max=15,message = "Minimim: 2. Maximum: 15")
	
	public String lastname;
	public int age;
	public String phoneNumber;
	public String address;
	public String email;
	
	@NotNull(message = "Please enter a username.")
	@Size(min=2,max=15,message = "Minimim: 5. Maximum: 15")
	public String userName;
	@NotNull(message = "Please enter a password.")
	@Size(min=2,max=15,message = "Minimim: 5. Maximum: 15")
	public String password;
	
	
	public User(String firstname, String lastname, int age, String phonenumber, String address, String email, String userName,
			String password) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.age = age;
		this.phoneNumber = phonenumber;
		this.address = address;
		this.email = email;
		this.userName = userName;
		this.password = password;
	}

	public User() {
		this.firstname = "";
		this.lastname = "";
		this.age = -1;
		this.phoneNumber = "";
		this.address = "";
		this.email = "";
		this.userName = "";
		this.password = "";
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phoneNumber = phonenumber;
	}
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}

