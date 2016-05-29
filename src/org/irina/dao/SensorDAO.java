package org.irina.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.irina.beans.Sensor;
import org.irina.util.DataConnect;

public class SensorDAO {

	public static List<Sensor> getSensors(String lotId) {
		Connection con = null;
		PreparedStatement ps = null;
		List<Sensor> list = new ArrayList<Sensor>();

		try {
			con = DataConnect.getConnection();
			ps = con.prepareStatement("Select id, name, description, type, sensorid, status from Sensors where lotId = ?");
			ps.setString(1, lotId);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String key1 = rs.getString(1);
				String name = rs.getString(2);
				Sensor s = new Sensor(key1, name, rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
				list.add(s);
			}
			if(rs != null) rs.close();
			if(ps != null) ps.close();

		} catch (SQLException ex) {
			System.out.println("Sensors error -->" + ex.getMessage());
		}
		return list;
	}
	public static String addSensor(String lotId, String key, String name, String description, String type, String sensorID, String status)
	{
		Connection con = null;
		PreparedStatement ps = null;
		boolean ok = true;
		
		try {
			con = DataConnect.getConnection();
			ps = con.prepareStatement("insert into Sensors(lotId, id, name, description, type, sensorid, status) values(?, ?, ?, ?, ?, ?, ?)");
			ps.setString(1, lotId);
			ps.setString(2, key);
			ps.setString(3, name);
			ps.setString(4, description);
			ps.setString(5, type);
			ps.setString(6, sensorID);
			ps.setString(7, status);
			ok = ps.execute();
			ok = true;
			if(ps != null) ps.close();

			
		} catch (SQLException ex) {
			System.out.println("addSensor=" + ex.getMessage());
			ok = false;
		}
		if(ok)
			return key;
		return null;
	}
	public static String editSensor(String key, String name, String description, String type, String sensorID, String status)
	{
		Connection con = null;
		PreparedStatement ps = null;
		boolean ok = true;
		try {
			con = DataConnect.getConnection();
			ps = con.prepareStatement("update Sensors set name = ?, description = ?, type = ?, sensorid = ?, status = ? where id = ?");
			ps.setString(1, name);
			ps.setString(2, description);
			ps.setString(3, type);
			ps.setString(4, sensorID);
			ps.setString(5, status);
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
	public static String deleteSensor(String key)
	{
		Connection con = null;
		PreparedStatement ps = null;
		boolean ok = true;
		try {
			con = DataConnect.getConnection();
			ps = con.prepareStatement("delete from Sensors where id = ?");
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
	/*public static String[] getHours(String lotId) {
		Connection con = null;
		PreparedStatement ps = null;
		List<String> h = new ArrayList<String>();

		try {
			con = DataConnect.getConnection();
			ps = con.prepareStatement("Select atHour from Schedule where lotId = ?");
			ps.setString(1, lotId);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				h.add(rs.getString(1));
			}
			if(rs != null) rs.close();
			if(ps != null) ps.close();

		} catch (SQLException ex) {
			System.out.println("Sensors error -->" + ex.getMessage());
		}
		return h.toArray(new String[h.size()]);
	}
	public static void setHours(String lotId, String[] hours)
	{
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = DataConnect.getConnection();
			ps = con.prepareStatement("delete from Schedule where lotId = ?");
			ps.setString(1, lotId);
			ps.execute();
			ps.close();
			if(hours != null)
			{
				ps = con.prepareStatement("insert into Schedule(lotId, athour) values(?, ?)");
				ps.setString(1, lotId);
				for(int i = 0; i < hours.length; i++)
				{
					int hr = Integer.parseInt(hours[i]);
					ps.setInt(2, hr);
					ps.execute();
				}
				ps.close();
			}

		} catch (SQLException ex) {
			System.out.println("setHours=" + ex.getMessage());
		}
		
	}*/
	private static String setSensorStatus(String key, String status)
	{
		Connection con = null;
		PreparedStatement ps = null;
		boolean ok = true;
		try {
			con = DataConnect.getConnection();
			ps = con.prepareStatement("update Sensors set status = ? where id = ?");
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
	public static String setSensorActive(String key)
	{
		return setSensorStatus(key, "a");
	}
	public static String setSensorPassive(String key)
	{
		return setSensorStatus(key, "p");
	}

}