package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import data.Benutzer;

public class DatabaseStatements {
	private static Connection con = null;
	
	public static void saveOrUpdate(String email, Benutzer user) {
		if(user.getEmail().isEmpty()) {
			return;
		}
		
		boolean exists = false;
		try {
			con = DatabaseConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement(
					"SELECT COUNT(*) FROM benutzer WHERE email = '"+ email +"'" 
			);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				exists = rs.getInt(1) > 0;
			}
		} catch (SQLException e) {
			System.err.println("Fehler beim Benutzer anlegen: " + e.getMessage());
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		if (!exists) {
			try {
				PreparedStatement createUser = con.prepareStatement(
						"INSERT INTO benutzer VALUES (default, ?, ?, ?, ? , ?, ?)" 
				);

				createUser.setString(1, user.getName());
				createUser.setInt(2, user.getAge());
				createUser.setString(3, user.getEmail());
				createUser.setString(4, user.getNumber());
				createUser.setBoolean(5, user.getAgb());
				createUser.setBoolean(6, user.getPrivacypolicies());
				
				createUser.executeQuery();
				
				PreparedStatement createPassword = con.prepareStatement(
						"INSERT INTO passwoerter VALUES (default, ?, ?, ?, ? , ?, ?)" 
				);
				
				
			} catch (SQLException e) {
				System.err.println("Fehler beim Benutzer anlegen: " + e.getMessage());
			} finally {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
