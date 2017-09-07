package com.bepum.web.controller.member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bepum.web.dao.MemberDao;
import com.bepum.web.dao.jdbc.JdbcMemberDao;
import com.bepum.web.entity.Member;


@WebServlet("/member/login")
public class LoginController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		
		String id =request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		MemberDao memberDao = new JdbcMemberDao();
		
		Member member = memberDao.get(id);
		if(member == null) 
			out.println("<script>alert('���̵� �Ǵ� ��й�ȣ�� Ȯ���ϼ���1');history.go(-1);</script>");
		else if(!member.getPwd().equals(pwd))
			out.println("<script>alert('���̵� �Ǵ� ��й�ȣ�� Ȯ���ϼ���2');history.go(-1);</script>");
		else {
			request.getSession().setAttribute("id", id);
			out.println("<script>alert('"+member.getName()+"�� �α��εǾ����ϴ�.');window.close();window.opener.location.reload();</script>");
		}
		
	}
}
