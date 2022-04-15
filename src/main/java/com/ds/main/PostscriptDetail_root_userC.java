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

@WebServlet("/PostscriptDetail_root_userC")
public class PostscriptDetail_root_userC extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AccountDAO.loginCheckCheck(request);

		HttpSession hs = request.getSession();
		Account r = (Account) hs.getAttribute("raccountInfo");
		Account u = (Account) hs.getAttribute("uaccountInfo");
		
		if(r!=null) {
			tpostscriptDAO.showOne(request);
			request.setAttribute("contentPage", "main/TeacherpostscriptDetail_root_user.jsp");
			request.getRequestDispatcher("Index.jsp").forward(request, response);
		} else if(u!=null) {
			String id=request.getParameter("id");
			if(id.equals(u.getU_id())) {
				tpostscriptDAO.showOne(request);
				request.setAttribute("contentPage", "main/TeacherpostscriptDetail_root_user.jsp");
				request.getRequestDispatcher("Index.jsp").forward(request, response);
			} else {
				tpostscriptDAO.showOne(request);
				request.setAttribute("contentPage", "main/TeacherpostscriptDetail.jsp");
				request.getRequestDispatcher("Index.jsp").forward(request, response); 
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
