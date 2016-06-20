package org.irina.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.irina.beans.Item;
import org.irina.beans.Problem;
import org.irina.beans.Statistic;
import org.irina.util.DataConnect;

public class StatisticDAO {

	public static List<Statistic> getStatistics() {
		Connection con = null;
		PreparedStatement ps = null;
		List<Statistic> statistics = new ArrayList<Statistic>();

		try {
			con = DataConnect.getConnection();
			ps = con.prepareStatement(
					"Select L.description, S.name, P.sensorid, count(*) as C from lots L, sensors S, problems P, rules R where P.ruleid = R.id and L.id = R.lotid and S.id = P.sensorid group by L.description, S.name, P.sensorid order by L.description, S.name");

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String description = rs.getString(1);
				String sensorName = rs.getString(2);
				String sensorId = rs.getString(3);
				String problemsCount = rs.getString(4);
				Statistic s = new Statistic(description, sensorId, sensorName, Integer.parseInt(problemsCount));
				statistics.add(s);
			}
			if (rs != null)
				rs.close();
			if (ps != null)
				ps.close();

		} catch (SQLException ex) {
			System.out.println("Statistics error getStatistics-->" + ex.getMessage());
		}
		return statistics;
	}
	
	public static List<Problem> getPrevProblems(String sensorId) {
		Connection con = null;
		PreparedStatement ps = null;
		List<Problem> list = new ArrayList<Problem>();
		try {
			con = DataConnect.getConnection();
			ps = con.prepareStatement(
					"SELECT P.id, to_char(P.attime, 'DD.MM.YYYY:HH24')||'h' as attime, P.notes, R.name, L.description, P.sensorid FROM problems P, rules R, lots L where P.ruleId=R.id and R.lotId=L.id and P.sensorId=? order by attime");
			ps.setString(1, sensorId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Problem p = new Problem(rs.getString(1), rs.getString(5), rs.getString(4), rs.getString(2),
						rs.getString(3), rs.getString(6));
				list.add(p);
			}
			if (rs != null)
				rs.close();
			if (ps != null)
				ps.close();

		} catch (SQLException ex) {
			System.out.println("Statistics error getPrevProblems-->" + ex.getMessage());
		}
		return list;
	}
	
}