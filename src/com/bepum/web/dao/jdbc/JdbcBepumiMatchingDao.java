package com.bepum.web.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bepum.web.dao.BepumiMatchingDao;
import com.bepum.web.entity.BoardView;
import com.bepum.web.entity.MatchingView;

public class JdbcBepumiMatchingDao implements BepumiMatchingDao {

	@Override
	public List<MatchingView> getList(String id, int page, String query) {
		String url = "jdbc:mysql://211.238.142.247/bepumdb?autoReconnect=true&amp;useSSL=false&characterEncoding=UTF-8";

		List<MatchingView> list = null;
		int offset = ((page - 1) * 15);

		// JDBC ����̹� �ε�
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			String sql = "select * from BepumiMatchingView where bepumiID = ? order by reqDate desc limit ?, 15";

			Connection con = DriverManager.getConnection(url, "bepum", "bepum123");
			/* Statement st = con.createStatement(); */
			PreparedStatement st = con.prepareStatement(sql);

			st.setString(1, id);
			st.setInt(2, offset);
			/* st.setString(1, "%"+title+"%"); */

			// ��� ��������
			ResultSet rs = st.executeQuery();

			// model
			list = new ArrayList<>();

			// ��� ���
			while (rs.next()) {
				MatchingView m = new MatchingView();
				m.setNo(rs.getString("no"));
				m.setId(rs.getString("id"));
				m.setName(rs.getString("name"));
				m.setGrade(rs.getInt("grade"));
				m.setReqDate(rs.getDate("reqDate"));
				m.setStartTime(rs.getString("startTime"));
				m.setEndTime(rs.getString("endTime"));
				m.setStatus(rs.getString("status"));
				list.add(m);
			}
			rs.close();
			st.close();
			con.close();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public int getCount() {
		String url = "jdbc:mysql://211.238.142.247/bepumdb?autoReconnect=true&amp;useSSL=false&characterEncoding=UTF-8";

		int count = 0;
		// JDBC ����̹� �ε�
		try {
			Class.forName("com.mysql.jdbc.Driver");

			String sqlCount = "SELECT count(no) as count FROM BepumiMatchingView";
			
			Connection con = DriverManager.getConnection(url, "bepum", "bepum123");
			/* Statement st = con.createStatement(); */

			/*st.setString(1, "%"+title+"%");*/

			Statement stCount = con.createStatement();
			ResultSet rsCount = stCount.executeQuery(sqlCount);
			
			if(rsCount.next())
				count = rsCount.getInt("count");
			
			// ��� ��������

			rsCount.close();
			stCount.close();
			con.close();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public MatchingView get(String id, String no) {
		MatchingView m = null;

		String url = "jdbc:mysql://211.238.142.247/bepumdb?autoReconnect=true&amp;useSSL=false&characterEncoding=UTF-8";

		// JDBC ����̹� �ε�
		try {
			Class.forName("com.mysql.jdbc.Driver");

			String sql = "SELECT * FROM BepumiMatchingView where no = ?";
			Connection con = DriverManager.getConnection(url, "bepum", "bepum123");
			/* Statement st = con.createStatement(); */
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, no);

			// ��� ��������
			ResultSet rs = st.executeQuery();

			// model

			// ��� ���
			while (rs.next()) {
				m = new MatchingView();
				m.setName(rs.getString("name"));
				m.setReviewNo(rs.getString("no"));
				m.setReviewTitle(rs.getString("title"));

			}

			rs.close();
			st.close();
			con.close();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return m;
	}

}