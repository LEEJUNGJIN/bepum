package com.bepum.web.controller.admin;

import java.io.IOException;
import java.io.PrintWriter;
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
import javax.servlet.http.HttpSession;

import com.bepum.web.dao.BoardCmtDao;
import com.bepum.web.dao.BoardDao;
import com.bepum.web.dao.MemberRoleDao;
import com.bepum.web.dao.jdbc.JdbcBoardCmtDao;
import com.bepum.web.dao.jdbc.JdbcBoardDao;
import com.bepum.web.dao.jdbc.JdbcMemberRoleDao;
import com.bepum.web.entity.Board;
import com.bepum.web.entity.BoardComment;

@WebServlet("/admin/question/cmt-edit")
public class QuestionCommentEditController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String no = request.getParameter("no");
		/*
		 * title = title.replaceAll("\n", "<br>"); // �ٹٲ�ó�� title =
		 * title.replaceAll("\u0020", "&nbsp;"); // �����̽��ٷ� ��� ����ó��
		 */
		String content = request.getParameter("content");

		BoardCmtDao dao = new JdbcBoardCmtDao();
		int result = dao.update(no, content, "FAQ");
		Object _return = request.getSession().getAttribute("returnURI");
		if (_return != null)
			response.sendRedirect(_return.toString());
		else
			response.sendRedirect("list");
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		session.setAttribute("returnURI", request.getHeader("Referer"));
		Object _id = session.getAttribute("id");

		if (_id == null)
			out.write("<script> alert('�α����� �ʿ��� ��û�Դϴ�.'); history.back(); </script>");
		else {
			String id = _id.toString();
			MemberRoleDao roleDao = new JdbcMemberRoleDao();
			int role = roleDao.getRole(id);

			if (role == 999) {

				String no = request.getParameter("no");

				BoardCmtDao dao = new JdbcBoardCmtDao();
				BoardComment b = dao.get(no, "FAQ");
				if (id.equals(b.getWriterId())) {
					request.setAttribute("b", b);
					/* response.sendRedirect("notice.jsp"); */
					request.getRequestDispatcher("/WEB-INF/views/admin/question/cmt-edit.jsp").forward(request,
							response);
				} else {
					out.write("<script> alert('�߸��� �����Դϴ�.'); history.back(); </script>");
				}
			} else {
				out.write("<script> alert('�߸��� �����Դϴ�.'); history.back(); </script>");
			}
		}
	}
}
