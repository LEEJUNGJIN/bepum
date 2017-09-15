package com.bepum.web.controller.member;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.taglibs.standard.tag.el.fmt.ParseDateTag;

import com.bepum.web.dao.MemberDao;
import com.bepum.web.dao.jdbc.JdbcMemberDao;
import com.bepum.web.entity.Member;

@WebServlet("/member/sign")
public class SignController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uri = request.getRequestURI();

		request.setAttribute("uri", uri);
		request.getRequestDispatcher("/WEB-INF/views/member/sign.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		int result =0;
		int grade = 000;
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String pwd = request.getParameter("pw");
		String gender = request.getParameter("gender");
		String birthday_year = request.getParameter("birthday_year");
		String birthday_month = request.getParameter("birthday_month");
		String birthday_day = request.getParameter("birthday_day");
		String phone_num1 = request.getParameter("phone_num1");
		String phone_num2 = request.getParameter("phone_num2");
		String phone_num3 = request.getParameter("phone_num3");
		String address1 = request.getParameter("address1");
		String address2 = request.getParameter("address2");
		/*idDuplication*/
		String idDuplication = request.getParameter("idDuplication");
		System.out.println(idDuplication);//idCheck or idUncheck
		
		String email = request.getParameter("email");
		String pwdCheck = request.getParameter("pwd-check");//��й�ȣȮ�ΰ� ��ġȮ��
		String phone="";
		String address="";
		String birth="";
		
		if(name == null || name.equals("")) {
			out.println("<script>alert('�̸��� �Է����ּ���.');location.href='sign?error=non';</script>");
			
		}else if(id == null || id.equals("")) {
			out.println("<script>alert('���̵� �Է����ּ���.');history.go(-1);</script>");
			
		}else if(idDuplication.equals("idUncheck")) {
			out.println("<script>alert('���̵� �ߺ�Ȯ���� ���ּ���.');history.go(-1);</script>");
			
		}else if(pwd == null || pwd.equals("")) {
			out.println("<script>alert('��й�ȣ�� �Է����ּ���.');history.go(-1);</script>");
			
		}else if(pwdCheck.equals("no")) {
			out.println("<script>alert('��й�ȣ�� ���� �ʽ��ϴ�.');history.go(-1);</script>");
			
		}else if(email == null || email.equals("")) {
			out.println("<script>alert('�̸����� �Է����ּ���.');history.go(-1);</script>");
			
		}else if(phone_num2 == null || phone_num2.equals("") 
				||phone_num3 == null || phone_num3.equals("")) {
			out.println("<script>alert('��ȭ��ȣ�� �Է����ּ���.');history.go(-1);</script>");
		
		}else if(address1 == null || address1.equals("") 
				||address2 == null || address2.equals("")) {
			out.println("<script>alert('�ּҸ� �Է����ּ���.');history.go(-1);</script>");
		
		}else if(birthday_year == null || birthday_year.equals("") 
				||birthday_month == null || birthday_month.equals("") 
				||birthday_day == null || birthday_day.equals("")){
			out.println("<script>alert('��������� �Է����ּ���.');history.go(-1);</script>");
			
		}else {
			if(phone_num1 == null || phone_num1.equals(""))
				phone_num1 = "010";
			phone= phone_num1+"-"+phone_num2+"-"+phone_num3;
			birth = birthday_year+"-"+birthday_month+"-"+birthday_day;
			address= address1+" "+address2;
			
		
		//System.out.println(id+", "+name+", "+pwd+", "+Integer.parseInt(gender)+", "+birth+", "+email+", "+grade);
		
		MemberDao memberDao = new JdbcMemberDao();
		Member member = new Member(id, name, pwd, Integer.parseInt(gender), birth, email,phone,address, grade, new Date());
		result = memberDao.insert(member);
		
		if(result>0) {
			out.println("<script>alert('��ǰ�� ȸ�������� �Ϸ�Ǿ����ϴ�. �α����� �̿����ּ���.');location.href='sign';</script>");
		}else {
			out.println("<script>alert('ȸ�������� ������ �߻��Ͽ����ϴ�. �ٽ� �õ��� �ּ���');history.go(-1);</script>");
		}
		
		
		
		}
		
		
		
	}
}
