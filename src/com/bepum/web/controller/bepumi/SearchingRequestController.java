package com.bepum.web.controller.bepumi;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bepum.web.dao.MatchingDao;
import com.bepum.web.dao.MatchingSituationDao;
import com.bepum.web.dao.MemberDao;
import com.bepum.web.dao.MemberRoleDao;
import com.bepum.web.dao.ProfileDao;
import com.bepum.web.dao.SearchingBepumiDao;
import com.bepum.web.dao.jdbc.JdbcMatchingDao;
import com.bepum.web.dao.jdbc.JdbcMatchingSituationDao;
import com.bepum.web.dao.jdbc.JdbcMemberDao;
import com.bepum.web.dao.jdbc.JdbcMemberRoleDao;
import com.bepum.web.dao.jdbc.JdbcProfileDao;
import com.bepum.web.dao.jdbc.JdbcSearchingBepumiDao;


@WebServlet("/searching/request")
public class SearchingRequestController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		//���⼭ ��û�� ������ matching, matchingSituation�� insert �ϸ��
		

/*		String requestID = request.setAttribute("", );
		
		MatchingSituationDao dao = new JdbcMatchingSituationDao();		
		MatchingDao dao1 = new JdbcMatchingDao();
		
		int matching = dao.insert(status, requestID, bepumiID);*/
		
		
		
		// request.setAttribute("list", dao.getList(page));
				

	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		HttpSession session = request.getSession();

		//��û�� ������ �ҷ�����
		Object _id = session.getAttribute("id");
		String id = _id.toString();
		//������ ������ �ҷ�����
		String bepumID= request.getParameter("bepum-id");
		
		ProfileDao dao = new JdbcProfileDao();
		request.setAttribute("profile", dao.get(bepumID));
		request.setAttribute("reqprofile", dao.get(id));
				
		request.getRequestDispatcher("/WEB-INF/views/searching/bepumi/request.jsp").forward(request, response);

	}
}
