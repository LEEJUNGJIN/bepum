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


@WebServlet("/member/idcheck")
public class IdCheckController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int result=0;//��밡�ɾ��̵��ΰ��1
		
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		
		String id =request.getParameter("id");
		MemberDao memberDao = new JdbcMemberDao();
		result = memberDao.checkId(id);
		if(result == 1) {
			request.setAttribute("result", result);
			out.println("1");
		}else if (result == 0) {
			request.setAttribute("result", result);
			out.println("0");
		}
		
		/*if(member == null || member.getGrade() == 44444 || !member.getPwd().equals(pwd)) 
			out.println("<script>alert('���̵� �Ǵ� ��й�ȣ�� Ȯ���ϼ���');history.go(-1);</script>");
		else {
			request.getSession().setAttribute("id", id);
			request.getSession().setAttribute("grade", member.getGrade());
			request.getSession().setAttribute("name", member.getName());
			
			out.println("<script>alert('"+member.getName()+"�� �α��εǾ����ϴ�.');window.close();window.opener.location.reload();</script>");
		}
		*/
	}
}
