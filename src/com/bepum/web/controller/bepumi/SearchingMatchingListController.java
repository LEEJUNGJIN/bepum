package com.bepum.web.controller.bepumi;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bepum.web.dao.BepumiMatchingDao;
import com.bepum.web.dao.SearchingMatchingDao;
import com.bepum.web.dao.jdbc.JdbcBepumiMatchingDao;
import com.bepum.web.dao.jdbc.JdbcSearchingMatchingDao;

@WebServlet("/searching/matching-list")
public class SearchingMatchingListController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		HttpSession session = request.getSession();

		//��û�� ���� �ҷ�����
		Object _id = session.getAttribute("id");
		String id = _id.toString();
		
		String _query = request.getParameter("arr");  //�� "��Ī�Ϸ�" �ƴϰ� "search"�� ������ �ñ��ϴ�
		
		String _page = request.getParameter("p");

		int page = 1;
		if (_page != null && !(_page.equals("")))
			page = Integer.parseInt(_page);
		
		String query = "";
		if (_query != null && !(_query.equals("")))
			query = _query;
		/*
		 * ��Ǫ�� ã�� - ��Ī ���� 
		 * ��Ī ��û 
		 * ���� �� -> ��û ���, ��Ī ���� 1
		 * ���� Ȯ�� -> ���� ���, ���� ����  2
		 *  ��Ī ���� -> ���� �Ϸ� 3
		 *  ��Ī �Ϸ� 4
		 */
		if (query.equals("3"))
			query = "�����Ϸ�";
		if (query.equals("4"))
			query = "��Ī�Ϸ�";

		SearchingMatchingDao dao = new JdbcSearchingMatchingDao();
		request.setAttribute("list", dao.getList(id, page, query));
		request.setAttribute("count", dao.getCount(id));
		
		request.getRequestDispatcher("/WEB-INF/views/searching/matching/list.jsp").forward(request, response);

	}
}
