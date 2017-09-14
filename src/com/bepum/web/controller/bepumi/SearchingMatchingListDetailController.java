package com.bepum.web.controller.bepumi;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bepum.web.dao.BepumiMatchingDao;
import com.bepum.web.dao.ReviewDao;
import com.bepum.web.dao.SearchingMatchingDao;
import com.bepum.web.dao.jdbc.JdbcBepumiMatchingDao;
import com.bepum.web.dao.jdbc.JdbcReviewDao;
import com.bepum.web.dao.jdbc.JdbcSearchingMatchingDao;

@WebServlet("/searching/matching-list-detail")
public class SearchingMatchingListDetailController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		String no = request.getParameter("no");
		Object _id = request.getSession().getAttribute("id");
		
		if (_id == null) {
			out.write("<script> alert('�α����� �ʿ��� ��û�Դϴ�.'); history.back(); </script>");
		} else {
			String id = _id.toString();
			String _rating = request.getParameter("rating");
			int rating = 0;
			if (_rating != null && !_rating.equals(""))
				rating = Integer.parseInt(_rating);
			String reviewTitle = request.getParameter("review-title");
			String reviewContent = request.getParameter("review-content");
			String btnOption = request.getParameter("rv-submit");
			System.out.println("btnOption"+btnOption);
			ReviewDao reviewDao = new JdbcReviewDao();
			int result = 0;
			if(btnOption.equals("���")) {
				result = reviewDao.insert(id, no, rating, reviewTitle, reviewContent);
			}
			else if(btnOption.equals("����")) {
				result = reviewDao.update(id, no, rating, reviewTitle, reviewContent);
			}
			response.sendRedirect(request.getHeader("Referer"));
		}	
		
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String no = request.getParameter("no");

		SearchingMatchingDao dao = new JdbcSearchingMatchingDao();
		String status = dao.get(no).getStatus();

		if (!status.equals("��û���") && !status.equals("��Ī����"))
			request.setAttribute("profile", dao.get(no));
		else {
			JdbcBepumiMatchingDao requestDao = new JdbcBepumiMatchingDao();
			request.setAttribute("profile", requestDao.get(no));
		}

		// ��Ī���¿� ���� �ٸ� ȭ�� ��ȯ�ϱ�

		/*
		 * request.getRequestDispatcher("/WEB-INF/views/searching/matching/detail1.jsp")
		 * .forward(request, response);
		 */
		request.getRequestDispatcher("/WEB-INF/views/searching/matching/detail.jsp").forward(request, response);
	}
}
