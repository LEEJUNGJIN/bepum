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

import com.bepum.web.dao.BoardCmtDao;
import com.bepum.web.dao.BoardDao;
import com.bepum.web.dao.jdbc.JdbcBoardCmtDao;
import com.bepum.web.dao.jdbc.JdbcBoardDao;
import com.bepum.web.entity.Board;

@WebServlet("/board/free-cmt-del")
public class FreeCommentDeleteController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String no = request.getParameter("no");
		/*title = title.replaceAll("\n", "<br>"); // �ٹٲ�ó��
		title = title.replaceAll("\u0020", "&nbsp;"); // �����̽��ٷ� ��� ����ó��*/		
		System.out.println(no);
		BoardCmtDao dao = new JdbcBoardCmtDao();
		int result = dao.delete(no, "Free");

		response.sendRedirect("free");
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String no = request.getParameter("no");

		BoardCmtDao dao = new JdbcBoardCmtDao();
		request.setAttribute("b", dao.get(no, "Free"));

		/* response.sendRedirect("notice.jsp"); */
		request.getRequestDispatcher("/WEB-INF/views/board/freeboard/cmt-del.jsp").forward(request, response);

	}
}
