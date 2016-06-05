package org.irina.dao;

import java.rmi.server.UID;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import org.irina.util.DataConnect;

public class SubscriberDAO {
	public static void toInfosDatabase(Map<String, String> map, String domain, String id) {
		Connection con = null;
		PreparedStatement ps = null;
		boolean ok = true;
		//String id = "";
		try {
			//String id = getSensorId(domain, map.get("name"));
			/*con = DataConnect.getConnection();
			ps = con.prepareStatement(
					"SELECT S.id FROM sensors S, lots L WHERE S.lotid = L.id AND L.domain = ? and S.name = ?");
			ps.setString(1, domain);
			ps.setString(2, map.get("name"));
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				id = rs.getString(1);
			}
			rs.close();
			if (ps != null)
				ps.close();*/
			con = DataConnect.getConnection();
			ps = con.prepareStatement("insert into infos(id, sensorid, datavalue) values(?, ?, ?)");
			ps.setString(1, getPrimaryKey());
			ps.setString(2, id);
			ps.setInt(3, Integer.parseInt(map.get("datavalue")));
			ok = ps.execute();
			ok = true;
			if (ps != null)
				ps.close();
		} catch (SQLException ex) {
			ok = false;
			System.out.println("subscriber toInfosDatabase: " + ex.getMessage());
		}
	}

	public static String getSensorId(String domain, String name) {
		Connection con = null;
		PreparedStatement ps = null;
		boolean ok = true;
		String id = "";

		try {
			
			con = DataConnect.getConnection();
			ps = con.prepareStatement(
					"SELECT S.id FROM sensors S, lots L WHERE S.lotid = L.id AND L.domain = ? and S.name = ?");
			ps.setString(1, domain);
			ps.setString(2, name);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				id = rs.getString(1);
			}
			rs.close();
			if (ps != null)
				ps.close();
		} catch (SQLException ex) {
			ok = false;
			System.out.println("subscriber getSensorId: " + ex.getMessage());
		}
		return id;
	}

	public static String getPrimaryKey() {
		return new UID().toString();
	}
}
