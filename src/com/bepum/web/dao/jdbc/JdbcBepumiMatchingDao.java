package com.bepum.web.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bepum.web.dao.BepumiMatchingDao;
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
			// BepumiMatchingView�� ��Ͽ����� �۵�... ��ܿ��� select �ϴ� �Ŵ� �ٸ� ��ü�� ����� ���� ���� �� �ƱⰡ 2�̻���
			// ���� �����ϱ�..
			String sql = "";
			if ((query.equals("") && !query.equals("���Ÿ�Ī") && !query.equals("��Ī����")) || query.equals("��û���"))
				sql = "select * from BepumiMatchingView where bepumiID = ? and status like ? order by reqDate desc limit ?, 15";
			else
				sql = "select * from BepumiMatchingView where bepumiID = ? and (status like ? or status like ?) order by reqDate desc limit ?, 15";
			Connection con = DriverManager.getConnection(url, "bepum", "bepum123");
			/* Statement st = con.createStatement(); */
			PreparedStatement st = con.prepareStatement(sql);

			st.setString(1, id);

			if ((query.equals("") && !query.equals("���Ÿ�Ī") && !query.equals("��Ī����") ) || query.equals("��û���")) {
				st.setString(2, String.format("%%%s%%", query));
				st.setInt(3, offset);
			} else if (query.equals("���Ÿ�Ī")) {
				st.setString(2, String.format("%%%s%%", "��Ī�Ϸ�"));
				st.setString(3, String.format("%%%s%%", "��Ī����"));
				st.setInt(4, offset);
			} else if (query.equals("��Ī����")) {
				st.setString(2, String.format("%%%s%%", "�������"));
				st.setString(3, String.format("%%%s%%", "�����Ϸ�"));
				st.setInt(4, offset);
			}
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
				m.setBepumiID(rs.getString("bepumiID"));
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
	public int getCount(String id) {
		String url = "jdbc:mysql://211.238.142.247/bepumdb?autoReconnect=true&amp;useSSL=false&characterEncoding=UTF-8";

		int count = 0;
		// JDBC ����̹� �ε�
		try {
			Class.forName("com.mysql.jdbc.Driver");

			String sqlCount = "SELECT count(no) as count FROM BepumiMatchingView where id = ?";

			Connection con = DriverManager.getConnection(url, "bepum", "bepum123");
			PreparedStatement stCount = con.prepareStatement(sqlCount);
			stCount.setString(1, id);

			/* Statement stCount = con.createStatement(); */
			ResultSet rsCount = stCount.executeQuery();

			if (rsCount.next())
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
	public MatchingView get(String no) {

		String url = "jdbc:mysql://211.238.142.247/bepumdb?autoReconnect=true&amp;useSSL=false&characterEncoding=UTF-8";
		MatchingView m = null;
		// JDBC ����̹� �ε�
		try {
			Class.forName("com.mysql.jdbc.Driver");
			// BepumiMatchingView�� ��Ͽ����� �۵�... ��ܿ��� select �ϴ� �Ŵ� �ٸ� ��ü�� ����� ���� ���� �� �ƱⰡ 2�̻���
			// ���� �����ϱ�..
			String sql = "SELECT * FROM BepumiMatchingDetailView where no = ?";
			Connection con = DriverManager.getConnection(url, "bepum", "bepum123");
			/* Statement st = con.createStatement(); */
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, no);
			/* st.setString(1, "%"+title+"%"); */

			// ��� ��������
			ResultSet rs = st.executeQuery();

			// model

			// ��� ���
			if (rs.next()) {
				m = new MatchingView();
				m.setNo(rs.getString("no"));
				m.setId(rs.getString("id"));
				m.setName(rs.getString("name"));
				m.setGrade(rs.getInt("grade"));
				m.setPhoneNum(rs.getString("phoneNum"));
				m.setAddress(rs.getString("address"));
				m.setReqDate(rs.getDate("reqDate"));
				m.setBepumDate(rs.getString("bepumDate"));
				m.setBepumiID(rs.getString("bepumiID"));
				m.setRequirement(rs.getString("requirement"));
				m.setStartTime(rs.getString("startTime"));
				m.setEndTime(rs.getString("endTime"));
				m.setStatus(rs.getString("status"));
				m.setProfilePic(rs.getString("profilePic"));
				m.setBabyName(rs.getString("babyName"));
				m.setBabyAge(rs.getInt("babyAge"));
				m.setBabyGender(rs.getInt("babyGender"));
				/*
				 * m.setBabyAge(rs.getInt("babyAge")); m.setBabyName(rs.getString("babyName"));
				 * m.setBabyGender(rs.getInt("babyGender"));
				 */
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

	@Override
	public int updateStatus(String no, String query) {
		int result = 0;
		String url = "jdbc:mysql://211.238.142.247/bepumdb?autoReconnect=true&amp;useSSL=false&characterEncoding=UTF-8";

		// JDBC ����̹� �ε�
		try {
			Class.forName("com.mysql.jdbc.Driver");

			String sql = "update MatchingSituation set status= ? where no = ?";
			Connection con = DriverManager.getConnection(url, "bepum", "bepum123");
			/* Statement st = con.createStatement(); */
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, query);
			st.setString(2, no);

			result = st.executeUpdate();
			// ������Ʈ�� row ���� �˷���

			st.close();

			sql = "update Matching set acceptDate = sysdate() where no = ?";
			/* Statement st = con.createStatement(); */
			PreparedStatement st2 = con.prepareStatement(sql);
			st2.setString(1, no);

			result += st2.executeUpdate();
			// ������Ʈ�� row ���� �˷���

			st2.close();
			con.close();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

}
