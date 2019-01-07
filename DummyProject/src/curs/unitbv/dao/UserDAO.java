package curs.unitbv.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import curs.unitbv.beans.UserBean;
import curs.unitbv.database.DatabaseConnection;

@Repository
public class UserDAO {

	public ArrayList<UserBean> getUsers() {
		ArrayList<UserBean> users = new ArrayList<>();
		Connection conn = null;
		try {
			DatabaseConnection dbConnection = DatabaseConnection.getInstance();
			conn = dbConnection.getConnection();
			Statement stmt = conn.createStatement();
			String sql = "SELECT * FROM users";
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				UserBean user = new UserBean();
				// Retrieve by column name
				user.setId(rs.getInt("id"));
				user.setFirstName(rs.getString("firstName"));
				user.setLastName(rs.getString("lastName"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				// Add data to the list
				users.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return users;
	}

	public UserBean findUser(String userId) {
		UserBean user = null;
		Connection conn = null;
		try {
			DatabaseConnection dbConnection = DatabaseConnection.getInstance();
			conn = dbConnection.getConnection();
			Statement stmt = conn.createStatement();
			String sql = "SELECT * FROM users where username=" + "'" + userId + "'";
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				user = new UserBean();
				// Retrieve by column name
				user.setId(rs.getInt("id"));
				user.setFirstName(rs.getString("firstName"));
				user.setLastName(rs.getString("lastName"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				// Add data to the list
				break;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return user;
	}

}
