package com.bepum.web.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bepum.web.dao.SearchingBepumiDao;
import com.bepum.web.entity.Profile;
import com.bepum.web.entity.SearchingBepumiView;

public class JdbcSearchingBepumiDao implements SearchingBepumiDao {

	@Override
	public List<SearchingBepumiView> getList(int page, int babyAge, String bepumDay1, String bepumDay2,
			String bepumDay3, String bepumDay4, String bepumDay5, String bepumDay6, String bepumDay7, String address, String startTime,
			String endTime) {
		List<SearchingBepumiView> list = null;
		int offset = (page - 1) * 9; // 0,10,20,30, .. . .
		String sql = "";
		if (startTime.equals(""))
			sql = "select * from SearchingBepumiView where (grade = 1 or grade = 2) and secret = 0 and (babyAge >= ? and babyAge <= ?) and (bepumDay like ? and bepumDay like ? and bepumDay like ? and bepumDay like ? and bepumDay like ? and bepumDay like ? and bepumDay like ?) and replace(address, ' ', '') like ? order by regDate desc limit ?,9";
		else
			sql = "select * from SearchingBepumiView where (grade = 1 or grade = 2) and secret = 0 and (babyAge >= ? and babyAge <= ?) and (bepumDay like ? and bepumDay like ? and bepumDay like ? and bepumDay like ? and bepumDay like ? and bepumDay like ? and bepumDay like ?) and  startTime <= ? and endTime >= ? and replace(address, ' ', '') like ? order by regDate desc limit ?,9";

		String url = "jdbc:mysql://211.238.142.247/bepumdb?autoReconnect=true&amp;useSSL=false&characterEncoding=UTF-8";

		// Jdbc ����̹� �ε�
		try {
			Class.forName("com.mysql.jdbc.Driver");

			// ���� / ����
			Connection con = DriverManager.getConnection(url, "bepum", "bepum123"); // dclass

			// ����
			// Statement st = con.createStatement();
			PreparedStatement st = con.prepareStatement(sql);
			if (babyAge == 0) {
				st.setInt(1, 0);
				st.setInt(2, 8);
			} else {
				st.setInt(1, babyAge);
				st.setInt(2, babyAge + 1);
			}
			st.setString(3, String.format("%%%s%%", bepumDay1));
			st.setString(4, String.format("%%%s%%", bepumDay2));
			st.setString(5, String.format("%%%s%%", bepumDay3));
			st.setString(6, String.format("%%%s%%", bepumDay4));
			st.setString(7, String.format("%%%s%%", bepumDay5));
			st.setString(8, String.format("%%%s%%", bepumDay6));
			st.setString(9, String.format("%%%s%%", bepumDay7));
			st.setString(10, String.format("%%%s%%", address));
			if (startTime.equals("")) {
				st.setInt(11, offset);
			} else {
				st.setString(11, startTime);
				st.setString(12, endTime);
				st.setInt(13, offset);
			}

			// ��� ��������
			ResultSet rs = st.executeQuery();
			// ResultSet rs = st.executeQuery(sql);

			// MODEL
			list = new ArrayList<>();

			// �������ϱ�
			while (rs.next()) {
				SearchingBepumiView n = new SearchingBepumiView();
				n.setId(rs.getString("ID"));
				n.setName(rs.getString("name"));
				n.setBirth(rs.getString("birthday"));
				n.setGrade(rs.getInt("grade"));
				n.setStrTime(rs.getString("startTime"));
				n.setEndTime(rs.getString("endTime"));
				n.setBepumDay(rs.getString("bepumDay"));
				n.setRegDate(rs.getDate("regDate"));
				n.setIntro(rs.getString("intro"));
				n.setEtc(rs.getString("etc"));
				n.setPay(rs.getString("pay"));
				n.setSecret(rs.getInt("secret"));
				n.setAddress(rs.getString("address"));
				n.setPhoneNum(rs.getString("phoneNum"));
				n.setCountReview(rs.getInt("reviewCount"));
				n.setProfilePic(rs.getString("profilePic"));
				list.add(n);
			}

			rs.close();
			st.close();
			con.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int getCount(int babyAge, String bepumDay1, String bepumDay2, String bepumDay3, String bepumDay4,
			String bepumDay5, String bepumDay6, String bepumDay7, String address, String startTime, String endTime) {
		int count = 0;
		String sqlcount = "";

		if (startTime.equals(""))
			sqlcount = "select count(ID) as count from SearchingBepumiView where (grade = 1 or grade = 2) and secret = 0 and (babyAge >= ? and babyAge <= ?) and (bepumDay like ? and bepumDay like ? and bepumDay like ? and bepumDay like ? and bepumDay like ? and bepumDay like ? and bepumDay like ?) and replace(address, ' ', '') like ?";
		else
			sqlcount = "select count(ID) as count from SearchingBepumiView where (grade = 1 or grade = 2) and secret = 0 and (babyAge >= ? and babyAge <= ?) and (bepumDay like ? and bepumDay like ? and bepumDay like ? and bepumDay like ? and bepumDay like ? and bepumDay like ? and bepumDay like ?) and  startTime <= ? and endTime >= ? and replace(address, ' ', '') like ?";
		String url = "jdbc:mysql://211.238.142.247/bepumdb?autoReconnect=true&amp;useSSL=false&characterEncoding=UTF-8";

		// Jdbc ����̹� �ε�
		try {
			Class.forName("com.mysql.jdbc.Driver");

			// ���� / ����
			Connection con = DriverManager.getConnection(url, "bepum", "bepum123"); // dclass

			// ���� (COUNT)
			PreparedStatement st = con.prepareStatement(sqlcount);
			if (babyAge == 0) {
				st.setInt(1, 0);
				st.setInt(2, 8);
			} else {
				st.setInt(1, babyAge);
				st.setInt(2, babyAge + 1);
			}
			st.setString(3, String.format("%%%s%%", bepumDay1));
			st.setString(4, String.format("%%%s%%", bepumDay2));
			st.setString(5, String.format("%%%s%%", bepumDay3));
			st.setString(6, String.format("%%%s%%", bepumDay4));
			st.setString(7, String.format("%%%s%%", bepumDay5));
			st.setString(8, String.format("%%%s%%", bepumDay6));
			st.setString(9, String.format("%%%s%%", bepumDay7));
			st.setString(10, String.format("%%%s%%", address));
			if (!startTime.equals("")) {
				st.setString(11, startTime);
				st.setString(12, endTime);
			}

			// ��� ��������
			ResultSet rs = st.executeQuery();
			rs.next();
			count = rs.getInt("count");

			rs.close();
			st.close();
			con.close();
			// list�� �����ؼ� st close ���ص� �ȴ�
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return count;
	}

}
