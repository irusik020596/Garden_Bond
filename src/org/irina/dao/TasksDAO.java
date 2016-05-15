package org.irina.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.irina.util.DataConnect;
import org.irina.util.Measurement;
//import org.irina.util.Sensor;

public class TasksDAO {

	public static List<String> getLots(int hour) {
		Connection con = null;
		PreparedStatement ps = null;
		List<String> list = new ArrayList<String>();

		try {
			con = DataConnect.getConnection();
			ps = con.prepareStatement("Select lotId from Schedule where atHour = ?");
			ps.setInt(1, hour);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				list.add(rs.getString(1));
			}
			if(rs != null) rs.close();
			if(ps != null) ps.close();

		} catch (SQLException ex) {
			System.out.println("getLots error -->" + ex.getMessage());
		}
		return list;
	}
	public static List<Measurement> getSensors(String lotId) {
		Connection con = null;
		PreparedStatement ps = null;
		List<Measurement> list = new ArrayList<Measurement>();

		try {
			con = DataConnect.getConnection();
			ps = con.prepareStatement("Select id, type, host, port from Sensors where lotId = ? and status = 'a'");
			ps.setString(1, lotId);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Measurement m = new Measurement(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
				list.add(m);
			}
			if(rs != null) rs.close();
			if(ps != null) ps.close();

		} catch (SQLException ex) {
			System.out.println("getSensors error -->" + ex.getMessage());
		}
		return list;
	}
}
