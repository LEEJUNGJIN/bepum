package com.bepum.web.controller.bepumi;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/searching/matching-list-detail")
public class SearchingMatchingListDetailController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*response.sendRedirect("notice.jsp");*/
		
		//��Ī���¿� ���� �ٸ� ȭ�� ��ȯ�ϱ�
		
		/*request.getRequestDispatcher("/WEB-INF/views/searching/matching/detail1.jsp").forward(request, response);*/
		request.getRequestDispatcher("/WEB-INF/views/searching/matching/detail3.jsp").forward(request, response);
	}
}
