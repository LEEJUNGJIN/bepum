package com.bepum.web.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.bepum.web.dao.BepumiRequestDao;

public class JdbcBepumiRequestDao implements BepumiRequestDao {

	@Override
	public int insert(String applicationFormCopy, String applicationForm, String hCCopy, String hC, String fRCCopy,
			String fRC, String vCCopy, String vC) {
		
		int result = 0;
		String url = "jdbc:mysql://211.238.142.247/bepumdb?autoReconnect=true&amp;useSSL=false&characterEncoding=UTF-8";

		// JDBC ����̹� �ε�
		try {
			Class.forName("com.mysql.jdbc.Driver");

			String sql = "INSERT INTO BepumiRequest(no, reqID, reqDate, applicationForm, applicationForm_copy, HC, HC_copy, FRC, FRC_copy, VC, VC_copy) VALUES ((select IFNULL(max(cast(no as unsigned)), 0)+1 from BepumiRequest br), ?, sysdate(), ?, ?, ?, ?, ?, ?, ?, ?)";
			Connection con = DriverManager.getConnection(url, "bepum", "bepum123");
			/* Statement st = con.createStatement(); */
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, "testpumi");
			st.setString(2, applicationForm);
			st.setString(3, applicationFormCopy);
			st.setString(4, hC);
			st.setString(5, hCCopy);
			st.setString(6, fRC);
			st.setString(7, fRCCopy);
			st.setString(8, vC);
			st.setString(9, vCCopy);
			

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

	//�ڰݽɻ� �����Ȳ���������� update�� �Ҽ��ְ� �ؾߵ�
}
