package com.bepum.web.controller.admin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bepum.web.dao.BepumiRequestDao;
import com.bepum.web.dao.jdbc.JdbcBepumiRequestDao;

@WebServlet("/admin/bepumi/request/detail")
public class BepumiRequestDetailController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");

		String id = request.getParameter("id");


		BepumiRequestDao dao = new JdbcBepumiRequestDao();
		request.setAttribute("profile", dao.get(id));
		
		request.getRequestDispatcher("/WEB-INF/views/admin/bepumi/request-list-detail.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String[] checkBoxes = request.getParameterValues("checkBox");
		String applicationFormStatus;
		String FRCStatus;
		String HCStatus;
		String VCStatus;

		
		//��ü���� �� 
		for(int i=0; i<checkBoxes.length; i++) {
			if(Integer.parseInt(checkBoxes[i])==i) {
				System.out.println(checkBoxes[i]);}
		}
			
		
/*		if(Integer.parseInt(checkBoxes[0])==0) {
			System.out.println("��ɻ� �ʿ�");			
			//applicationFormStatus = "��ɻ� �ʿ�";
		}else {
			System.out.println("�ɻ�Ϸ�");}
		//	applicationFormStatus = "�ɻ� �Ϸ�";}		
*/
		
		
		//üũ�� �ϸ� value�� �Ѿ��, ��ɻ簡 �ʿ�
		
		
/*		if(Integer.parseInt(checkBoxes[1])==1) {
			System.out.println("1");			
			//applicationFormStatus = "��ɻ� �ʿ�";
		}else {
			System.out.println("11");
		//	applicationFormStatus = "�ɻ� �Ϸ�";
		}
		
		if(Integer.parseInt(checkBoxes[2])==2) {
			System.out.println("2");			
			//applicationFormStatus = "��ɻ� �ʿ�";
		}else {
			System.out.println("22");
		//	applicationFormStatus = "�ɻ� �Ϸ�";
		}
		
		if(Integer.parseInt(checkBoxes[3])==3) {
			System.out.println("3");			
			//applicationFormStatus = "��ɻ� �ʿ�";
		}else {
			System.out.println("33");
		//	applicationFormStatus = "�ɻ� �Ϸ�";
		}*/
	
		
/*		if(checkBoxes[1]=="1") {
			FRCStatus = "�ɻ� �Ϸ�";
		}else {
			FRCStatus = "��ɻ� �ʿ�";
		}
		
		if(checkBoxes[2]=="2") {
			HCStatus = "�ɻ� �Ϸ�";
		}else {
			HCStatus = "��ɻ� �ʿ�";
		}
		
		if(checkBoxes[3]=="3") {
			VCStatus = "�ɻ� �Ϸ�";
		}else {
			VCStatus = "��ɻ� �ʿ�";
		}
		*/


		
		HttpSession session = request.getSession();
		Object _id = session.getAttribute("id");
		String reqID = _id.toString();

		
		BepumiRequestDao dao = new JdbcBepumiRequestDao();
	//	int result = dao.update(reqID, applicationFormStatus, FRCStatus, HCStatus, VCStatus);
		
		response.sendRedirect("list");
	}
}
