package com.bepum.web.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.bepum.web.dao.MemberDao;
import com.bepum.web.entity.Member;

public class JdbcMemberDao implements MemberDao {

	@Override
	public List<Member> getList(int page, String query, String cName) {
		String url = "jdbc:mysql://211.238.142.247/bepumdb?autoReconnect=true&amp;useSSL=false&characterEncoding=UTF-8";

		List<Member> list = null;
		int offset = ((page - 1) * 15);

		// JDBC ����̹� �ε�
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			String sql = "SELECT * FROM Member where "+cName+" like ? order by regDate desc limit ?, 15";

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
				Member m = new Member(); 
				m.setId(rs.getString("id"));
				m.setName(rs.getString("name"));
				m.setGender(rs.getInt("gender")); 
				m.setBirth(rs.getString("birthday"));
				m.setEmail(rs.getString("email")); 
				m.setGrade(rs.getInt("grade"));
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
	public int insert(Member member) {
		int result =0;
		
		String sql = "INSERT INTO Member(ID, name, pwd, gender, birthday, email, grade) VALUES(?,?,?,?,?,?,?)";
		/*String sql = "INSERT INTO Member(ID, name, pwd, gender) VALUES(?,?,?,?)";*/
		
		String url = "jdbc:mysql://211.238.142.247/bepumdb?autoReconnect=true&amp;useSSL=false&characterEncoding=UTF-8";
		try {
			Class.forName("com.mysql.jdbc.Driver");

			Connection con = DriverManager.getConnection(url, "bepum", "bepum123");
			
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, member.getId());
			st.setString(2, member.getName());
			st.setString(3, member.getPwd());
			st.setInt(4, member.getGender());
			st.setString(5, member.getBirth());
			st.setString(6, member.getEmail());
			st.setInt(7, member.getGrade());
			
			result = st.executeUpdate();
			st.close();
			con.close();

		} catch (Exception e) {
		}
		
		System.out.println(result);
		return result;
	}

	@Override
	public Member get(String id) {
		String sql = "SELECT * FROM Member where id=?";
		Member m = null;
		String url = "jdbc:mysql://211.238.142.247/bepumdb?autoReconnect=true&amp;useSSL=false&characterEncoding=UTF-8";
		try {
			Class.forName("com.mysql.jdbc.Driver");

			Connection con = DriverManager.getConnection(url, "bepum", "bepum123");

			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, id);
			ResultSet rs = st.executeQuery();
			/* list = new ArrayList<>(); */
			while (rs.next()) { 
				m = new Member(rs.getString("id"), rs.getString("name"), rs.getString("pwd"), rs.getInt("gender"),
						rs.getString("birthday"), rs.getString("email"), rs.getInt("grade"),rs.getDate("regDate"));
			}
			
//			System.out.println(m.getId());
			rs.close();
			st.close();
			con.close();

		} catch (Exception e) {
		}
		return m;
	}
}
