package org.irina.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.irina.beans.Problem;
import org.irina.util.DataConnect;

public class ProblemDAO {

	public static List<Problem> getActiveProblems(String user) {
		Connection con = null;
		PreparedStatement ps = null;
		List<Problem> list = new ArrayList<Problem>();

		try {
			con = DataConnect.getConnection();
			ps = con.prepareStatement(
					"SELECT P.id, to_char(P.attime, 'DD.MM.YYYY:HH24')||'h' as attime, P.notes, R.name, L.description" 
					+ " FROM problems P, rules R, lots L"
					+ " where P.ruleId=R.id and R.lotId=L.id and P.state='a' and L.owner= ?"
							);
			ps.setString(1, user);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Problem p = new Problem(rs.getString(1), rs.getString(5), rs.getString(4), rs.getString(2), rs.getString(3));
				list.add(p);
			}
			if(rs != null) rs.close();
			if(ps != null) ps.close();

		} catch (SQLException ex) {
			System.out.println("Problems error -->" + ex.getMessage());
		}
		return list;
	}
	public static String checkProblem(String key)
	{
		Connection con = null;
		PreparedStatement ps = null;
		boolean ok = true;
		try {
			con = DataConnect.getConnection();
			ps = con.prepareStatement("update Problems set state='c' where id = ?");
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
	public static String newProblem(String key, String ruleId, String notes)
	{
		Connection con = null;
		PreparedStatement ps = null;
		boolean ok = true;
		try {
			con = DataConnect.getConnection();
			ps = con.prepareStatement("insert into Problems(id, ruleId, notes) values(?, ?, ?)");
			ps.setString(1, key);
			ps.setString(2,ruleId);
			ps.setString(3,notes);
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
