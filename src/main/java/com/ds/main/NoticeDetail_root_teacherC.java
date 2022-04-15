package com.ds.main;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ds.login.Account;
import com.ds.login.AccountDAO;

@WebServlet("/NoticeDetail_root_teacherC")
public class NoticeDetail_root_teacherC extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AccountDAO.loginCheckCheck(request);

		HttpSession hs = request.getSession();
		Account r = (Account) hs.getAttribute("raccountInfo");
		Account t = (Account) hs.getAttribute("taccountInfo");
		
		if(r!=null) {
			NoticeDAO.showOne(request);
			request.setAttribute("contentPage", "main/NoticeDetail_root_teacher.jsp");
			request.getRequestDispatcher("Index.jsp").forward(request, response);
		} else if(t!=null) {
			String id=request.getParameter("id");
			if(id.equals(t.getT_id())) {
				NoticeDAO.showOne(request);
				request.setAttribute("contentPage", "main/NoticeDetail_root_teacher.jsp");
				request.getRequestDispatcher("Index.jsp").forward(request, response);
			} else {
				NoticeDAO.showOne(request);
				request.setAttribute("contentPage", "main/NoticeDetail.jsp");
				request.getRequestDispatcher("Index.jsp").forward(request, response); 
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
