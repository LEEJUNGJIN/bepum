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
	public List<SearchingBepumiView> getList(int page) {
		 List<SearchingBepumiView> list = null;
		int offset = (page-1)*9; // 0,10,20,30, .. . .
		String sql = "SELECT * FROM SearchingBepumiView limit ?,9";
		String url = "jdbc:mysql://211.238.142.247/bepumdb?autoReconnect=true&amp;useSSL=false&characterEncoding=UTF-8";
		
		
		   	 // Jdbc ����̹� �ε�
		    try {
		       Class.forName("com.mysql.jdbc.Driver");

			   // ���� / ����
			   Connection con = DriverManager.getConnection(url, "bepum", "bepum123"); // dclass

			   // ����
			   //Statement st = con.createStatement();
			   PreparedStatement st = con.prepareStatement(sql);

			   st.setInt(1, offset);
			   
			   // ��� ��������
			   ResultSet rs = st.executeQuery();
			   //ResultSet rs = st.executeQuery(sql);

			   
			   //MODEL
			   list = new ArrayList<>();
		
			   
			   //�������ϱ�
			   while (rs.next()) {
				  SearchingBepumiView n = new SearchingBepumiView();
			      
				  n.setName(rs.getString("name"));
				  n.setBirth(rs.getString("birthday"));			      
			      n.setGrade(rs.getInt("grade"));			   
			      n.setStrTime(rs.getString("startTime"));
			      n.setEndTime(rs.getString("endTime"));
			      n.setBepumDay(rs.getString("bepumDay"));
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
	public int getCount() {
		 int count =0;
		 
		String sqlcount = "select count(ID) count from SearchingBepumiView";
		String url = "jdbc:mysql://211.238.142.247/bepumdb?autoReconnect=true&amp;useSSL=false&characterEncoding=UTF-8";
		
		
		   	 // Jdbc ����̹� �ε�
		    try {
		       Class.forName("com.mysql.jdbc.Driver");

			   // ���� / ����
			   Connection con = DriverManager.getConnection(url, "bepum", "bepum123"); // dclass

			   // ���� (COUNT)
			   Statement st = con.createStatement(); // �Ķ���͸� ������ ���� �����ϱ� pre �ʿ����!
			  
			// ��� ��������
			   ResultSet rs = st.executeQuery(sqlcount);
			   rs.next();
			  count = rs.getInt("count");
			   
			   rs.close(); 
			   st.close();
			   con.close();
			   //list�� �����ؼ� st close ���ص� �ȴ�
		     } catch (ClassNotFoundException e) {
		        e.printStackTrace();
		     } catch (SQLException e) {
		        e.printStackTrace();
		     }
		
		
		return count;
		
	}

}

