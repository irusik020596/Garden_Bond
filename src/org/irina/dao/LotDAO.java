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
			ps = con.prepareStatement("Select id, description from Lots where owner = ?");
			ps.setString(1, user);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String key1 = rs.getString(1);
				String desc = rs.getString(2);
				Item it = new Item(key1,desc);
				list.add(it);
			}
			if(rs != null) rs.close();
			if(ps != null) ps.close();

		} catch (SQLException ex) {
			System.out.println("Lot error -->" + ex.getMessage());
		}
		return list;
	}
	public static String addLot(String user, String key, String description)
	{
		Connection con = null;
		PreparedStatement ps = null;
		boolean ok = true;
		
		try {
			con = DataConnect.getConnection();
			ps = con.prepareStatement("insert into Lots(owner, id, description) values(?, ?, ?)");
			ps.setString(1, user);
			ps.setString(2, key);
			ps.setString(3, description);
			ok = ps.execute();
			ok = true;
			if(ps != null) ps.close();
		} catch (SQLException ex) {
			ok = false;
		}
		if(ok)
			return key;
		return null;
	}
	public static String editLot(String key, String description)
	{
		Connection con = null;
		PreparedStatement ps = null;
		boolean ok = true;
		try {
			con = DataConnect.getConnection();
			ps = con.prepareStatement("update Lots set description = ? where id = ?");
			ps.setString(1, description);
			ps.setString(2, key);
			ok = ps.execute();
			ok = true;
			if(ps != null) ps.close();
		} catch (SQLException ex) {
			ok = false;
		}
		if(ok)
			return key;
		return null;
	}
	public static String deleteLot(String key)
	{
		Connection con = null;
		PreparedStatement ps = null;
		boolean ok = true;
		try {
			con = DataConnect.getConnection();
			ps = con.prepareStatement("delete from Lots where id = ?");
			ps.setString(1, key);
			ok = ps.execute();
			ok = true;
			if(ps != null) ps.close();
		} catch (SQLException ex) {
			ok = false;
		}
		if(ok)
			return key;
		return null;
	}

}