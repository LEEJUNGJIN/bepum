package com.bepum.web.controller.admin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bepum.web.dao.MemberRoleDao;
import com.bepum.web.dao.jdbc.JdbcMemberRoleDao;

@WebServlet("/admin/index")
public class IndexController extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();

		Object _adminId = session.getAttribute("id");

		if (_adminId == null)
			out.write("<script> alert('로그인이 필요한 요청입니다.'); history.back(); </script>");
		else {
			String adminId = _adminId.toString();
			MemberRoleDao roleDao = new JdbcMemberRoleDao();
			int role = roleDao.getRole(adminId);

			if (role == 999) {

				request.getRequestDispatcher("/WEB-INF/views/admin/index.jsp").forward(request, response);
			} else {
				out.write("<script> alert('잘못된 접근입니다.'); history.back(); </script>");
			}
		}
	}

}
