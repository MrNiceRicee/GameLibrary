package data;

import java.io.Console;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import beans.User;

/**
 * Session Bean implementation class DataAccessService
 */
@Stateless
@Local(UserDataAccessInterface.class)
@LocalBean
public class UserDataService implements UserDataAccessInterface<User>{

    /**
     * Default constructor. 
     */
    public UserDataService() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public List<User> findAll() {
		Connection conn = null;
		String url = "jdbc:postgresql://localhost:5432/postgres";
		String username = "postgres";
		String password = "root";
		
		String sql = "SELECT * from GameLibrary.Users";
		List<User> orders = new ArrayList<User>();
		try {
			conn = DriverManager.getConnection(url,username,password);
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				orders.add(new User(rs.getString("firstname"), rs.getString("lastname"), rs.getInt("age"), rs.getString("phonenumber"), rs.getString("address"), rs.getString("email"),
						rs.getString("username"), rs.getString("password")));
			}
			rs.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return orders;
	}

	@Override
	public User findById(int Id) {
		
		return null;
	}

	@Override
	public boolean create(User user) {
		Connection conn = null;
		String url = "jdbc:postgresql://localhost:5432/postgres";
		String username = "postgres";
		String password = "root";
		System.out.println("This is from UserDataService: create, pre try.");
		try {
			conn = DriverManager.getConnection(url,username,password);
			Statement stmt = conn.createStatement();
			String sql = "INSERT INTO \"GameLibrary\".\"Users\"(" + 
					"id, \"FIRST_NAME\", \"LAST_NAME\", \"AGE\", \"PHONE_NUMBER\", \"ADDRESS\", \"EMAIL\", \"USERNAME\", \"PASSWORD\")"
					+ "VALUES(DEFAULT, '"+user.firstname+"', '"+user.lastname+"', "+user.age+", '"+user.phoneNumber+"', '"+user.address+"', '"+user.email+"', '"+user.userName+"' , '"+user.password+"' );";
			
			String sql2 = "INSERT INTO GameLibrary.Users(id, FIRST_NAME, LAST_NAME, AGE, PHONE_NUMBER, ADDRESS, EMAIL, USERNAME, PASSWORD)"
					+ "VALUES (DEFAULT, '"+user.firstname+"', '"+user.lastname+"', "+user.age+", '"+user.phoneNumber+"', '"+user.address+"', '"+user.email+"', '"+user.userName+"', '"+user.password+"' );";
			
			String sql3 = "INSERT INTO GameLibrary.Users(id, FIRST_NAME, LAST_NAME, AGE, PHONE_NUMBER, ADDRESS, EMAIL, USERNAME, PASSWORD)"
					+ "VALUES (DEFAULT, "+user.firstname+", "+user.lastname+", "+user.age+", "+user.phoneNumber+", "+user.address+", "+user.email+", "+user.userName+", "+user.password+" );";
			
			System.out.println("This is from UserDataService: creating "+user.userName);
			stmt.execute(sql3);
		}catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return true;
	}

	@Override
	public boolean update(User user) {
		
		return true;
	}

	@Override
	public boolean delete(User user) {
		Connection conn = null;
		String url = "jdbc:postgresql://localhost:5432/postgres";
		String username = "postgres";
		String password = "root";
		try {
			conn = DriverManager.getConnection(url,username,password);
			Statement stmt = conn.createStatement();
			System.out.println("Message from OrderDataService.delete: deleting: "+user.userName);
			String sql = "DELETE FROM GameLibrary.Users WHERE USERNAME='"+user.userName+"' AND PASSWORD='"+user.password+"';";
			stmt.execute(sql);
		}catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return true;
	}

}
