package com.bepum.web.controller.member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bepum.web.dao.MemberDao;
import com.bepum.web.dao.jdbc.JdbcMemberDao;


@WebServlet("/member/delete")
public class DeleteController extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		int result =0;
		HttpSession session = request.getSession();
		Object _id = session.getAttribute("id");
		String id = _id.toString();
		String pwd = request.getParameter("pwd");
		
		MemberDao memberDao = new JdbcMemberDao();
		result =memberDao.delete(id,pwd);
		
		if(result>0) {
			session.invalidate();
			out.println("<script>alert('ȸ��Ż�� �Ϸ�Ǿ����ϴ�.');location.href='../index';</script>");
		}else {
			out.println("<script>alert('ȸ��Ż�� �����ϼ̽��ϴ�. �ٽ� �õ��� �ּ���');history.go(-1);</script>");
		}
		
	}
		
	
	
	
	
	
}
