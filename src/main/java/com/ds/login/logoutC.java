package com.ds.login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ds.main.NoticeDAO;
import com.ds.main.ScheduleDAO;
import com.ds.main.tpostscriptDAO;

@WebServlet("/logoutC")
public class logoutC extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		NoticeDAO.Showfive(request);
	    tpostscriptDAO.Showfive(request);
	    ScheduleDAO.Showtoday(request); 
		AccountDAO.logout(request);
		request.setAttribute("contentPage", "main/main.jsp");
		request.getRequestDispatcher("Index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
