package org.irina.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.irina.beans.Condition;
import org.irina.util.DataConnect;

public class ConditionDAO {

	public static List<Condition> getConditions(String ruleId) {
		Connection con = null;
		PreparedStatement ps = null;
		List<Condition> list = new ArrayList<Condition>();

		try {
			con = DataConnect.getConnection();
			ps = con.prepareStatement("Select id, sensorId, op, datavalue from Conditions where ruleId = ?");
			ps.setString(1, ruleId);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Condition c = new Condition(rs.getString(1), rs.getString(2), rs.getString(3), "" + rs.getDouble(4));
				list.add(c);
			}

			if (rs != null)
				rs.close();
			if (ps != null)
				ps.close();
		} catch (SQLException ex) {
			System.out.println("Conditions error -->" + ex.getMessage());
		}
		return list;
	}

	public static String addCondition(String ruleId, String key, String sensorId, String operation, String limit) {
		Connection con = null;
		PreparedStatement ps = null;
		boolean ok = true;

		try {
			con = DataConnect.getConnection();
			ps = con.prepareStatement(
					"insert into Conditions(ruleId, id, sensorId, op, datavalue) values(?, ?, ?, ?, ?)");
			double d = Double.parseDouble(limit);
			ps.setString(1, ruleId);
			ps.setString(2, key);
			ps.setString(3, sensorId);
			ps.setString(4, operation);
			ps.setDouble(5, d);
			ok = ps.execute();
			ok = true;
			if (ps != null)
				ps.close();
		} catch (SQLException ex) {
			System.out.println("addCondition=" + ex.getMessage());
			ok = false;
		}
		if (ok)
			return key;
		return null;
	}

	public static String editCondition(String key, String sensorId, String operation, String limit) {
		Connection con = null;
		PreparedStatement ps = null;
		boolean ok = true;
		try {
			con = DataConnect.getConnection();
			ps = con.prepareStatement("update Conditions set sensorId = ?, op = ?, datavalue = ? where id = ?");
			double d = Double.parseDouble(limit);
			ps.setString(1, sensorId);
			ps.setString(2, operation);
			ps.setDouble(3, d);
			ps.setString(4, key);
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

	public static String deleteCondition(String key) {
		Connection con = null;
		PreparedStatement ps = null;
		boolean ok = true;
		try {
			con = DataConnect.getConnection();
			ps = con.prepareStatement("delete from Conditions where id = ?");
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

	public static List<Condition> getConditionsBySensor(String sensorId) {
		Connection con = null;
		PreparedStatement ps = null;
		List<Condition> list = new ArrayList<Condition>();

		try {
			con = DataConnect.getConnection();
			ps = con.prepareStatement("Select id, op, datavalue from Conditions where sensorId = ?");
			ps.setString(1, sensorId);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Condition c = new Condition(rs.getString(1), sensorId, rs.getString(2), "" + rs.getDouble(3));
				list.add(c);
			}

			if (rs != null)
				rs.close();
			if (ps != null)
				ps.close();
		} catch (SQLException ex) {
			System.out.println("Conditions getConditionsBySensor -->" + ex.getMessage());
		}
		return list;
	}

	public static String getRuleByCoditionId(String id) {
		Connection con = null;
		PreparedStatement ps = null;
		String ruleName = "";

		try {
			con = DataConnect.getConnection();
			ps = con.prepareStatement("Select name from rules where id =( Select ruleId from Conditions where id = ?)");
			ps.setString(1, id);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ruleName = rs.getString(1);
			}
			if (rs != null)
				rs.close();
			if (ps != null)
				ps.close();
		} catch (SQLException ex) {
			System.out.println("Conditions getRuleByCoditionId -->" + ex.getMessage());
		}
		return ruleName;
	}
	public static String getLotByCoditionId(String id) {
		Connection con = null;
		PreparedStatement ps = null;
		String lotName = "";

		try {
			con = DataConnect.getConnection();
			ps = con.prepareStatement("Select description from lots where lots.id = (Select lotid from rules where id =( Select ruleId from Conditions where id = ?))");
			ps.setString(1, id);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				lotName = rs.getString(1);
			}
			if (rs != null)
				rs.close();
			if (ps != null)
				ps.close();
		} catch (SQLException ex) {
			System.out.println("Conditions getLotByCoditionId -->" + ex.getMessage());
		}
		return lotName;
	}
}