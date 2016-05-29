package org.irina.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.irina.beans.Item;
import org.irina.util.DataConnect;

public class LotDAO {

	public static List<Item> getLots(String user) {
		Connection con = null;
		PreparedStatement ps = null;
		List<Item> list = new ArrayList<Item>();

		try {
			con = DataConnect.getConnection();
			ps = con.prepareStatement("Select id, description, domain, broker_url, broker_login, broker_password from Lots where owner = ?");
			ps.setString(1, user);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String key1 = rs.getString(1);
				String desc = rs.getString(2);
				String domain = rs.getString(3);
				String broker_url = rs.getString(4);
				String broker_login = rs.getString(5);
				String broker_password = rs.getString(6);
				Item it = new Item(key1, desc, domain, broker_url, broker_login, broker_password);
				list.add(it);
			}
			if (rs != null)
				rs.close();
			if (ps != null)
				ps.close();

		} catch (SQLException ex) {
			System.out.println("Lot error -->" + ex.getMessage());
		}
		return list;
	}
	public static List<Item> getAllLots() {
		Connection con = null;
		PreparedStatement ps = null;
		List<Item> list = new ArrayList<Item>();

		try {
			con = DataConnect.getConnection();
			ps = con.prepareStatement("Select id, description, domain, broker_url, broker_login, broker_password from Lots");

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String key1 = rs.getString(1);
				String desc = rs.getString(2);
				String domain = rs.getString(3);
				String broker_url = rs.getString(4);
				String broker_login = rs.getString(5);
				String broker_password = rs.getString(6);
				Item it = new Item(key1, desc, domain, broker_url, broker_login, broker_password);
				list.add(it);
			}
			if (rs != null)
				rs.close();
			if (ps != null)
				ps.close();

		} catch (SQLException ex) {
			System.out.println("AllLots error -->" + ex.getMessage());
		}
		return list;
	}

	public static String addLot(String user, String key, String description, String domain, String broker_url,
			String broker_login, String broker_password) {
		Connection con = null;
		PreparedStatement ps = null;
		boolean ok = true;

		try {
			con = DataConnect.getConnection();
			ps = con.prepareStatement(
					"insert into Lots(owner, id, description,domain,broker_url,broker_login,broker_password) values(?, ?, ?, ?, ?, ?, ?)");
			ps.setString(1, user);
			ps.setString(2, key);
			ps.setString(3, description);
			ps.setString(4, domain);
			ps.setString(5, broker_url);
			ps.setString(6, broker_login);
			ps.setString(7, broker_password);
			ok = ps.execute();
			ok = true;
			if (ps != null)
				ps.close();
		} catch (SQLException ex) {
			ok = false;
		}
		if (ok)
			return key;
		return null;
	}

	public static String editLot(String key, String description, String domain, String broker_url, String broker_login,
			String broker_password) {
		Connection con = null;
		PreparedStatement ps = null;
		boolean ok = true;
		try {
			con = DataConnect.getConnection();
			ps = con.prepareStatement(
					"update Lots set description = ?, domain = ?, broker_url = ?, broker_login = ?, broker_password = ? where id = ?");
			ps.setString(1, description);
			ps.setString(2, domain);
			ps.setString(3, broker_url);
			ps.setString(4, broker_login);
			ps.setString(5, broker_password);
			ps.setString(6, key);
			ok = ps.execute();
			ok = true;
			if (ps != null)
				ps.close();
		} catch (SQLException ex) {
			ok = false;
		}
		if (ok)
			return key;
		return null;
	}

	public static String deleteLot(String key) {
		Connection con = null;
		PreparedStatement ps = null;
		boolean ok = true;
		try {
			con = DataConnect.getConnection();
			ps = con.prepareStatement("delete from Lots where id = ?");
			ps.setString(1, key);
			ok = ps.execute();
			ok = true;
			if (ps != null)
				ps.close();
		} catch (SQLException ex) {
			ok = false;
		}
		if (ok)
			return key;
		return null;
	}

}