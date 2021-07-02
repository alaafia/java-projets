package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import models.User;

public class UserDao {

	public UserDao() {

	}

	public List<User> getAllUsers() {
		List<User> listUsers = new ArrayList<User>();
		String sql = "SELECT * FROM Users";
		System.out.println(sql);
		try {
			Connection conn = DbConnector.getConn();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			// loop through the result set
			while (rs.next()) {
				User tempUser = new User(rs.getInt("id"), rs.getString("username"), rs.getString("name"),
						rs.getString("role"), rs.getString("password"));
				listUsers.add(tempUser);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return listUsers;
	}

	public User login(String username, String password) {
		String sql = "SELECT name,role,username,id FROM Users WHERE username='" + username + "' AND password='"
				+ password + "';";
		System.out.println(sql);
		try {
			Connection conn = DbConnector.getConn();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			// loop through the result set
			while (rs.next()) {
				System.out.println(rs.getString("name") + "\t" + rs.getString("role") + "  is Found");
				return new User(rs.getInt("id"), rs.getString("username"), rs.getString("name"), rs.getString("role"));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	public Boolean saveUser(User newUser) {
		String sql = "INSERT INTO Users(username,name,role,password) values (\"" + newUser.getUsername() + "\",\""
				+ newUser.getName() + "\",\"" + newUser.getRole() + "\",\"" + newUser.getPassword() + "\");";
		System.out.println(sql);
		try {
			Connection conn = DbConnector.getConn();
			Statement stmt = conn.createStatement();
			int rs = stmt.executeUpdate(sql);
			if (rs == 1)
				return true;

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

	public Boolean deleteUser(String id) {
		String sql = "DELETE FROM Users WHERE id=" + id + ";";
		System.out.println(sql);
		try {
			Connection conn = DbConnector.getConn();
			Statement stmt = conn.createStatement();
			int rs = stmt.executeUpdate(sql);
			if (rs == 1)
				return true;

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

	public Boolean isUsernameExists(String username) {
		String sql = "SELECT name,role,username,id FROM Users WHERE username='" + username + "';";
		System.out.println(sql);
		try {
			Connection conn = DbConnector.getConn();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			// loop through the result set
			if (rs.next()) {
				return true;
			}
			return false;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

	public Boolean updateUser(User newUser) {
		// TODO Auto-generated method stub
		String sql = "UPDATE Users SET name = '"+newUser.getName()+"', username = '"+newUser.getUsername()+"', password = '"+newUser.getPassword()+"' WHERE id = "+newUser.getId()+";";
		System.out.println(sql);
		try {
			Connection conn = DbConnector.getConn();
			Statement stmt = conn.createStatement();
			int rs = stmt.executeUpdate(sql);
			if (rs == 1)
				return true;

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

	public User getUser(Integer id) {
		String sql = "SELECT name,role,username,id FROM Users WHERE id=" + id + ";";
		System.out.println(sql);
		try {
			Connection conn = DbConnector.getConn();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			// loop through the result set
			while (rs.next()) {
				System.out.println(rs.getString("name") + "\t" + rs.getString("role") + "  is Found");
				return new User(rs.getInt("id"), rs.getString("username"), rs.getString("name"), rs.getString("role"));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

}
