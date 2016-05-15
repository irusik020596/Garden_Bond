package org.irina.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.irina.beans.Rule;
import org.irina.util.DataConnect;

public class RuleDAO {

	public static List<Rule> getRules(String lotId) {
		Connection con = null;
		PreparedStatement ps = null;
		List<Rule> list = new ArrayList<Rule>();

		try {
			con = DataConnect.getConnection();
			ps = con.prepareStatement("Select id, name, description, smsnote, emailnote, type from Rules where lotId = ?");
			ps.setString(1, lotId);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String key1 = rs.getString(1);
				String name = rs.getString(2);
				Rule r = new Rule(key1, name, rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
				list.add(r);
			}
			if(rs != null) rs.close();
			if(ps != null) ps.close();

		} catch (SQLException ex) {
			System.out.println("Rules error -->" + ex.getMessage());
		}
		return list;
	}
	public static String addRule(String lotId, String key, String name, String description, String smsnote, String emailnote, String type)
	{
		Connection con = null;
		PreparedStatement ps = null;
		boolean ok = true;
		
		try {
			con = DataConnect.getConnection();
			ps = con.prepareStatement("insert into Rules(lotId, id, name, description, smsnote, emailnote, type) values(?, ?, ?, ?, ?, ?, ?)");
			ps.setString(1, lotId);
			ps.setString(2, key);
			ps.setString(3, name);
			ps.setString(4, description);
			ps.setString(5, smsnote);
			ps.setString(6, emailnote);
			ps.setString(7, type);
			ok = ps.execute();
			ok = true;
			if(ps != null) ps.close();
		} catch (SQLException ex) {
			System.out.println("addRule=" + ex.getMessage());
			ok = false;
		}
		if(ok)
			return key;
		return null;
	}
	public static String editRule(String key, String name, String description, String smsnote, String emailnote, String type)
	{
		Connection con = null;
		PreparedStatement ps = null;
		boolean ok = true;
		try {
			con = DataConnect.getConnection();
			ps = con.prepareStatement("update Rules set name = ?, description = ?, smsnote = ?, emailnote = ?, type = ? where id = ?");
			ps.setString(1, name);
			ps.setString(2, description);
			ps.setString(3, smsnote);
			ps.setString(4, emailnote);
			ps.setString(5, type);
			ps.setString(6, key);
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
	public static String deleteRule(String key)
	{
		Connection con = null;
		PreparedStatement ps = null;
		boolean ok = true;
		try {
			con = DataConnect.getConnection();
			ps = con.prepareStatement("delete from Rules where id = ?");
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
