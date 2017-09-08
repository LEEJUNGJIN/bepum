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
import com.bepum.web.dao.SecretBoardDao;
import com.bepum.web.dao.jdbc.JdbcBoardDao;
import com.bepum.web.dao.jdbc.JdbcSecretBoardDao;
import com.bepum.web.entity.Board;

@WebServlet("/board/question-del")
public class QuestionDeleteController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String no = request.getParameter("no");
		/*title = title.replaceAll("\n", "<br>"); // �ٹٲ�ó��
		title = title.replaceAll("\u0020", "&nbsp;"); // �����̽��ٷ� ��� ����ó��*/		
		System.out.println(no);
		SecretBoardDao dao = new JdbcSecretBoardDao();
		int result = dao.delete(no, "FAQ");
		

		response.sendRedirect("question");
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String no = request.getParameter("no");

		SecretBoardDao dao = new JdbcSecretBoardDao();
		request.setAttribute("b", dao.get(no, "FAQ"));

		/* response.sendRedirect("notice.jsp"); */
		request.getRequestDispatcher("/WEB-INF/views/board/question/del.jsp").forward(request, response);

	}
}
