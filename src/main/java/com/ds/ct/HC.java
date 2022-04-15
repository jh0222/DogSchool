package com.ds.ct;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ds.login.AccountDAO;
import com.ds.main.NoticeDAO;
import com.ds.main.ScheduleDAO;
import com.ds.main.tpostscriptDAO;


@WebServlet("/HC")
public class HC extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 NoticeDAO.Showfive(request);
	     tpostscriptDAO.Showfive(request);
	     ScheduleDAO.Showtoday(request);
	     AccountDAO.loginCheckCheck(request);      
	     request.getRequestDispatcher("Index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
