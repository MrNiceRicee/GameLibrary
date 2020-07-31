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

import beans.Game;

/**
 * Session Bean implementation class DataAccessService
 */
@Stateless
@Local(UserDataAccessInterface.class)
@LocalBean
public class GameDataService implements GameDataAccessInterface<Game>{

    /**
     * Default constructor. 
     */
    public GameDataService() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public List<Game> findAll() {
		Connection conn = null;
		String url = "jdbc:postgresql://localhost:5432/postgres";
		String username = "postgres";
		String password = "root";
		
		String sql = "SELECT * from GameLibrary.Games";
		List<Game> games = new ArrayList<Game>();
		try {
			conn = DriverManager.getConnection(url,username,password);
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				games.add(new Game(rs.getInt("id"), rs.getString("GAME_NAME"), rs.getString("STUDIO"), rs.getString("GENRE"), rs.getFloat("PRICE") , rs.getDate("DATE_PUBLISHED"), rs.getInt("RATINGS"), rs.getInt("ITEMS_SOLD"), rs.getInt("PLAY_COUNT")));
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
		return games;
	}

	@Override
	public Game findById(int Id) {
		
		return null;
	}

	@Override
	public boolean create(Game game) {
		Connection conn = null;
		String url = "jdbc:postgresql://localhost:5432/postgres";
		String username = "postgres";
		String password = "root";
		try {
			conn = DriverManager.getConnection(url,username,password);
			Statement stmt = conn.createStatement();
			String sql = "";
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

	@Override
	public boolean update(Game game) {
		
		return true;
	}

	@Override
	public boolean delete(Game game) {
		Connection conn = null;
		String url = "jdbc:postgresql://localhost:5432/postgres";
		String username = "postgres";
		String password = "root";
		try {
			conn = DriverManager.getConnection(url,username,password);
			Statement stmt = conn.createStatement();
			String sql = "";
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