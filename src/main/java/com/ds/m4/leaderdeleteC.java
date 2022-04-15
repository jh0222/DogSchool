package com.ds.m4;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ds.login.AccountDAO;

@WebServlet("/leaderdeleteC")
public class leaderdeleteC extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		AccountDAO.loginCheckCheck(request);
		//list랑 신청한 내용 삭제하는 일
		leaderDAO.delete(request);
		leaderDAO.leaderAll(request);
		leaderDAO.pageView(request);
		leaderDAO.page(request);
		request.setAttribute("contentPage", "Menu4/leaderlist.jsp");
		request.getRequestDispatcher("Index.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
