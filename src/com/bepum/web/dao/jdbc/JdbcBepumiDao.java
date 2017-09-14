package com.bepum.web.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bepum.web.dao.BepumiDao;
import com.bepum.web.dao.MemberDao;
import com.bepum.web.entity.Bepumi;
import com.bepum.web.entity.Member;

public class JdbcBepumiDao implements BepumiDao {

	public List<Bepumi> getList(int page, String query, String cName) {
		String url = "jdbc:mysql://211.238.142.247/bepumdb?autoReconnect=true&amp;useSSL=false&characterEncoding=UTF-8";

		List<Bepumi> list = null;
		int offset = ((page - 1) * 15);

		// JDBC ����̹� �ε�
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			String sql = "SELECT * FROM Member where "+cName+" like ? and grade = 1 or grade = 2 order by regDate desc limit ?, 15";

			Connection con = DriverManager.getConnection(url, "bepum", "bepum123");
			/* Statement st = con.createStatement(); */
			PreparedStatement st = con.prepareStatement(sql);

			st.setString(1, String.format("%%%s%%", query));
			st.setInt(2, offset);
			/* st.setString(1, "%"+title+"%"); */

			// ��� ��������
			ResultSet rs = st.executeQuery();

			// model
			list = new ArrayList<>();

			// ��� ���
			while (rs.next()) {
				Bepumi b = new Bepumi(); 
				b.setId(rs.getString("id"));
				b.setName(rs.getString("name"));
				b.setGender(rs.getInt("gender")); 
				b.setBirth(rs.getString("birthday"));
				b.setEmail(rs.getString("email")); 
				b.setGrade(rs.getInt("grade"));
				list.add(b);
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

			String sqlCount = "SELECT count(id) as count FROM Member";
			
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
	public int insert(String reqID) {
		int result =0;
		
		String sql = "INSERT INTO Bepumi(ID, address, phoneNum) VALUES(?,?,?)";
		
		String url = "jdbc:mysql://211.238.142.247/bepumdb?autoReconnect=true&amp;useSSL=false&characterEncoding=UTF-8";
		try {
			Class.forName("com.mysql.jdbc.Driver");

			Connection con = DriverManager.getConnection(url, "bepum", "bepum123");
			
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, reqID);
			st.setString(2, "���� ������");
			st.setString(3, "010-1234-5678");

			
			result = st.executeUpdate();
			st.close();
			con.close();

		} catch (Exception e) {
		}
		
		System.out.println(result);
		return result;
	}
}
