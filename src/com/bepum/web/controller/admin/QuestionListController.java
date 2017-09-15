package com.bepum.web.controller.admin;

import java.io.IOException;
import java.io.PrintWriter;
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

import com.bepum.web.dao.BoardDao;
import com.bepum.web.dao.MemberRoleDao;
import com.bepum.web.dao.SecretBoardDao;
import com.bepum.web.dao.jdbc.JdbcBoardDao;
import com.bepum.web.dao.jdbc.JdbcMemberRoleDao;
import com.bepum.web.dao.jdbc.JdbcSecretBoardDao;
import com.bepum.web.entity.Board;

@WebServlet("/admin/question/list")
public class QuestionListController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();

		Object _adminId = session.getAttribute("id");

		if (_adminId == null)
			out.write("<script> alert('�α����� �ʿ��� ��û�Դϴ�.'); history.back(); </script>");
		else {
			String adminId = _adminId.toString();
			MemberRoleDao roleDao = new JdbcMemberRoleDao();
			int role = roleDao.getRole(adminId);

			if (role == 999) {

				String _cName = request.getParameter("search-sel");
				String _query = request.getParameter("search");

				String _page = request.getParameter("p");

				int page = 1;
				if (_page != null && !(_page.equals("")))
					page = Integer.parseInt(_page);

				String query = "";
				if (_query != null && !(_query.equals("")))
					query = _query;

				String cName = "writerId";
				if (_cName != null && !(_cName.equals("")))
					cName = _cName;

				SecretBoardDao dao = new JdbcSecretBoardDao();

				request.setAttribute("list", dao.getList(page, cName, query, "FAQ"));
				request.setAttribute("count", dao.getCount("FAQ"));

				/* response.sendRedirect("notice.jsp"); */
				request.getRequestDispatcher("/WEB-INF/views/admin/question/list.jsp").forward(request, response);
			} else {
				out.write("<script> alert('�߸��� �����Դϴ�.'); history.back(); </script>");
			}
		}
	}
}
