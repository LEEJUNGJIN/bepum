package com.bepum.web.controller.member;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bepum.web.dao.BoardDao;
import com.bepum.web.dao.jdbc.JdbcBoardDao;
import com.bepum.web.entity.Board;

@WebServlet("/board/free-edit")
public class FreeBoardEditController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String no = request.getParameter("no");
		String title = request.getParameter("title");
		/*title = title.replaceAll("\n", "<br>"); // �ٹٲ�ó��
		title = title.replaceAll("\u0020", "&nbsp;"); // �����̽��ٷ� ��� ����ó��*/		
		String content = request.getParameter("content");
		
		BoardDao dao = new JdbcBoardDao();
		int result = dao.update(no, title, content, "Free");

		response.sendRedirect("free-detail?no=" + no);
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String no = request.getParameter("no");

		BoardDao dao = new JdbcBoardDao();
		request.setAttribute("b", dao.get(no, "Free"));

		/* response.sendRedirect("notice.jsp"); */
		request.getRequestDispatcher("/WEB-INF/views/board/freeboard/edit.jsp").forward(request, response);

	}
}
