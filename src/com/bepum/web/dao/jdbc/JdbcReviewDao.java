package com.bepum.web.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bepum.web.dao.ReviewDao;
import com.bepum.web.entity.BoardView;
import com.bepum.web.entity.ReviewView;

public class JdbcReviewDao implements ReviewDao {

	@Override
	public List<ReviewView> getList(int page, String cName, String query) {
		String url = "jdbc:mysql://211.238.142.247/bepumdb?autoReconnect=true&amp;useSSL=false&characterEncoding=UTF-8";

		List<ReviewView> list = null;
		int offset = ((page - 1) * 15);

		// JDBC ����̹� �ε�
		try {
			Class.forName("com.mysql.jdbc.Driver");
			// BepumiMatchingView�� ��Ͽ����� �۵�... ��ܿ��� select �ϴ� �Ŵ� �ٸ� ��ü�� ����� ���� ���� �� �ƱⰡ 2�̻���
			// ���� �����ϱ�..
			String sql = "select * from ReviewView where "+cName+" like ? order by regDate desc limit ?, 15";

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
				ReviewView m = new ReviewView();
				m.setNo(rs.getString("no"));
				m.setBepumiID(rs.getString("bepumiID"));
				m.setWriterID(rs.getString("writerID"));
				m.setTitle(rs.getString("title"));
				m.setRegDate(rs.getTimestamp("regDate"));
				m.setHit(rs.getInt("hit"));
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

			String sqlCount = "SELECT count(no) as count FROM ReviewView";
			
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
	public ReviewView get(String no) {
		ReviewView r = null;

		String url = "jdbc:mysql://211.238.142.247/bepumdb?autoReconnect=true&amp;useSSL=false&characterEncoding=UTF-8";

		// JDBC ����̹� �ε�
		try {
			Class.forName("com.mysql.jdbc.Driver");

			String sql = "SELECT * FROM ReviewView where no = ?";
			Connection con = DriverManager.getConnection(url, "bepum", "bepum123");
			/* Statement st = con.createStatement(); */
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, no);

			// ��� ��������
			ResultSet rs = st.executeQuery();

			// model

			// ��� ���
			while (rs.next()) {
				r = new ReviewView();
				r.setNo(rs.getString("no"));
				r.setTitle(rs.getString("title"));
				r.setContent(rs.getString("content"));
				r.setBepumiID(rs.getString("bepumiID"));
				r.setWriterID(rs.getString("writerID"));
				r.setRegDate(rs.getTimestamp("regDate"));
				r.setHit(rs.getInt("hit"));
				r.setBepumDate(rs.getString("bepumDate"));
				r.setRequirement(rs.getString("requirement"));
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
		return r;
	}
	
	@Override
	public int updateHit(String no) {
		int result = 0;
		String url = "jdbc:mysql://211.238.142.247/bepumdb?autoReconnect=true&amp;useSSL=false&characterEncoding=UTF-8";

		// JDBC ����̹� �ε�
		try {
			Class.forName("com.mysql.jdbc.Driver");

			String sql = "update Review set hit = hit+1 where no = ?";
			Connection con = DriverManager.getConnection(url, "bepum", "bepum123");
			/* Statement st = con.createStatement(); */
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, no);

			result = st.executeUpdate();
			// ������Ʈ�� row ���� �˷���

			st.close();
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

	@Override
	public int insert(String id, String no, int rating, String reviewTitle, String reviewContent) {
		int result = 0;
		String url = "jdbc:mysql://211.238.142.247/bepumdb?autoReconnect=true&amp;useSSL=false&characterEncoding=UTF-8";

		// JDBC ����̹� �ε�
		try {
			Class.forName("com.mysql.jdbc.Driver");

			String sql = "INSERT INTO Review(no, writerID, matchingNo, rating, title, content) VALUES ((select IFNULL(max(cast(no as unsigned)), 0)+1 from Review r), ?, ?, ?, ?, ?)";
			Connection con = DriverManager.getConnection(url, "bepum", "bepum123");
			/* Statement st = con.createStatement(); */
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, id);
			st.setString(2, no);
			st.setInt(3, rating);
			st.setString(4, reviewTitle);
			st.setString(5, reviewContent);

			/* st.setString(1, "%"+title+"%"); */

			// ��� ��������
			result = st.executeUpdate();
			// ������Ʈ�� row ���� �˷���

			st.close();
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

	@Override
	public int update(String id, String no, int rating, String reviewTitle, String reviewContent) {
		int result = 0;
		String url = "jdbc:mysql://211.238.142.247/bepumdb?autoReconnect=true&amp;useSSL=false&characterEncoding=UTF-8";

		// JDBC ����̹� �ε�
		try {
			Class.forName("com.mysql.jdbc.Driver");

			String sql = "update Review set rating = ?, title  = ?, content  = ? where matchingNo = ?";
			Connection con = DriverManager.getConnection(url, "bepum", "bepum123");
			/* Statement st = con.createStatement(); */
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, rating);
			st.setString(2, reviewTitle);
			st.setString(3, reviewContent);
			st.setString(4, no);

			result = st.executeUpdate();
			// ������Ʈ�� row ���� �˷���

			st.close();
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

	@Override
	public List<ReviewView> getListByBepumi(String id) {
		String url = "jdbc:mysql://211.238.142.247/bepumdb?autoReconnect=true&amp;useSSL=false&characterEncoding=UTF-8";

		List<ReviewView> list = null;
		//int offset = ((page - 1) * 5);

		// JDBC ����̹� �ε�
		try {
			Class.forName("com.mysql.jdbc.Driver");
			// BepumiMatchingView�� ��Ͽ����� �۵�... ��ܿ��� select �ϴ� �Ŵ� �ٸ� ��ü�� ����� ���� ���� �� �ƱⰡ 2�̻���
			// ���� �����ϱ�..
			String sql = "select * from ReviewView where bepumiID = ? order by regDate desc limit 0, 5";

			Connection con = DriverManager.getConnection(url, "bepum", "bepum123");
			/* Statement st = con.createStatement(); */
			PreparedStatement st = con.prepareStatement(sql);

			st.setString(1, id);
			//st.setInt(2, offset);
			/* st.setString(1, "%"+title+"%"); */

			// ��� ��������
			ResultSet rs = st.executeQuery();

			// model
			list = new ArrayList<>();

			// ��� ���
			while (rs.next()) {
				ReviewView m = new ReviewView();
				m.setNo(rs.getString("no"));
				m.setBepumiID(rs.getString("bepumiID"));
				m.setWriterID(rs.getString("writerID"));
				m.setTitle(rs.getString("title"));
				m.setRegDate(rs.getTimestamp("regDate"));
				m.setHit(rs.getInt("hit"));
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

	

}
