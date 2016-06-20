package org.irina.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.irina.beans.Problem;
import org.irina.util.DataConnect;

public class LoginDAO {

	public static boolean validateLogin(String user, String password) {
		Connection con = null;
		PreparedStatement ps = null;
		boolean ok = false;
		try {
			con = DataConnect.getConnection();
			ps = con.prepareStatement("Select uname, password from Users where uname = ? and password = ?");
			ps.setString(1, user);
			ps.setString(2, password);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				ok = true;
			}
			if (rs != null)
				rs.close();
			if (ps != null)
				ps.close();
		} catch (SQLException ex) {
			System.out.println("Login error -->" + ex.getMessage());
		}
		return ok;
	}

	public static boolean existUser(String user) {
		Connection con = null;
		PreparedStatement ps = null;
		boolean ok = false;
		try {
			con = DataConnect.getConnection();
			ps = con.prepareStatement("Select uname from Users where uname = ?");
			ps.setString(1, user);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				ok = true;
			}
			if (rs != null)
				rs.close();
			if (ps != null)
				ps.close();
		} catch (SQLException ex) {
			System.out.println("No user" + ex.getMessage());
			ok = false;
		}
		return ok;
	}

	public static boolean addUser(String user, String password, String email, String phone, String address) {
		Connection con = null;
		PreparedStatement ps = null;
		boolean ok = true;

		try {
			con = DataConnect.getConnection();
			ps = con.prepareStatement(
					"insert into Users(uname, password, email, phone, address) values(?, ?, ?, ?, ?)");
			ps.setString(1, user);
			ps.setString(2, password);
			ps.setString(3, email);
			ps.setString(4, phone);
			ps.setString(5, address);
			ok = ps.execute();
			ok = true;
			if (ps != null)
				ps.close();

		} catch (SQLException ex) {
			ok = false;
		}
		return ok;
	}

	public static List<String> getUserEmail(String sensorId) {
		Connection con = null;
		PreparedStatement ps = null;
		List<String> values = new ArrayList();
		try {
			con = DataConnect.getConnection();
			ps = con.prepareStatement("SELECT uname , email FROM users U,lots L,sensors S where "
					+ "S.id = ? and L.id = S.lotid and U.uname = L.owner");
			ps.setString(1, sensorId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				values.add(rs.getString(1));
				values.add(rs.getString(2));
			}
			if (rs != null)
				rs.close();
			if (ps != null)
				ps.close();

		} catch (SQLException ex) {
			System.out.println("LoginDAO error getUserEmail -->" + ex.getMessage());
		}
		return values;
	}

}