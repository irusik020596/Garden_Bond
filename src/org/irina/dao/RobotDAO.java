package org.irina.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.irina.beans.Robot;
import org.irina.util.DataConnect;

public class RobotDAO {

	public static List<Robot> getRobots(String lotId) {
		Connection con = null;
		PreparedStatement ps = null;
		List<Robot> list = new ArrayList<Robot>();

		try {
			con = DataConnect.getConnection();
			ps = con.prepareStatement("Select id, name, description, type, status, state from Robots where lotId = ?");
			ps.setString(1, lotId);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String key1 = rs.getString(1);
				String name = rs.getString(2);
				Robot s = new Robot(key1, name, rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
				list.add(s);
			}
			if(rs != null) rs.close();
			if(ps != null) ps.close();

		} catch (SQLException ex) {
			System.out.println("Sensors error -->" + ex.getMessage());
		}
		return list;
	}
	public static String addRobot(String lotId, String key, String name, String description, String type, String status, String state)
	{
		Connection con = null;
		PreparedStatement ps = null;
		boolean ok = true;
		
		try {
			con = DataConnect.getConnection();
			ps = con.prepareStatement("insert into Robots(lotId, id, name, description, type, status, state) values(?, ?, ?, ?, ?, ?, ?)");
			ps.setString(1, lotId);
			ps.setString(2, key);
			ps.setString(3, name);
			ps.setString(4, description);
			ps.setString(5, type);
			ps.setString(6, status);
			ps.setString(7, state);
			ok = ps.execute();
			ok = true;
			if(ps != null) ps.close();

			
		} catch (SQLException ex) {
			System.out.println("addRobot=" + ex.getMessage());
			ok = false;
		}
		if(ok)
			return key;
		return null;
	}
	public static String editRobot(String key, String name, String description, String type, String status, String state)
	{
		Connection con = null;
		PreparedStatement ps = null;
		boolean ok = true;
		try {
			con = DataConnect.getConnection();
			ps = con.prepareStatement("update Robots set name = ?, description = ?, type = ?, status = ?, tate = ? where id = ?");
			ps.setString(1, name);
			ps.setString(2, description);
			ps.setString(3, type);
			ps.setString(4, status);
			ps.setString(5, state);
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
	public static String deleteRobot(String key)
	{
		Connection con = null;
		PreparedStatement ps = null;
		boolean ok = true;
		try {
			con = DataConnect.getConnection();
			ps = con.prepareStatement("delete from Robots where id = ?");
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
	public static String[] getRules(String robotId)
	{
		Connection con = null;
		PreparedStatement ps = null;
		ArrayList<String> l = new ArrayList<String>();
		try {
			con = DataConnect.getConnection();
			ps = con.prepareStatement("Select ruleId from Links where robotId = ?");
			ps.setString(1, robotId);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				l.add(rs.getString(1));
			}
			if(rs != null) rs.close();
			if(ps != null) ps.close();

		} catch (SQLException ex) {
			System.out.println("getRules error -->" + ex.getMessage());
		}

		return l.toArray(new String[l.size()]);
	}
	public static String setRules(String robotId, String[] rules)
	{
		Connection con = null;
		PreparedStatement ps = null;
		PreparedStatement ps2 = null;
		boolean ok = true;
		try {
			con = DataConnect.getConnection();
			ps = con.prepareStatement("delete from Links where robotId = ?");
			ps.setString(1, robotId);
			ok = ps.execute();
//			ps.close();
			ps2 = con.prepareStatement("insert into Links(robotId, ruleId) values(?, ?)");
			ps2.setString(1, robotId);
			for(int i = 0; i < rules.length; i++)
			{
				ps2.setString(2, rules[i]);
				ok = ps2.execute();
			}
			ok = true;
			if(ps != null) ps.close();
			if(ps2 != null) ps2.close();
		} catch (SQLException ex) {
			ok = false;
		}
		if(ok)
			return robotId;
		return null;
		
	}
	private static String setRobotStatus(String key, String status)
	{
		Connection con = null;
		PreparedStatement ps = null;
		boolean ok = true;
		try {
			con = DataConnect.getConnection();
			ps = con.prepareStatement("update Robots set status = ? where id = ?");
			ps.setString(1, status);
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
	public static String setRobotActive(String key)
	{
		return setRobotStatus(key, "a");
	}
	public static String setRobotPassive(String key)
	{
		return setRobotStatus(key, "p");
	}
	private static String setRobotState(String key, String state)
	{
		Connection con = null;
		PreparedStatement ps = null;
		boolean ok = true;
		try {
			con = DataConnect.getConnection();
			ps = con.prepareStatement("update Robots set state = ? where id = ?");
			ps.setString(1, state);
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
	public static String setRobotOn(String key)
	{
		return setRobotState(key, "o");
	}
	public static String setRobotOff(String key)
	{
		return setRobotState(key, "f");
	}
}
