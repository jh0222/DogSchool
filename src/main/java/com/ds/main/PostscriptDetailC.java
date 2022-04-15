package com.ds.main;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ds.login.AccountDAO;

@WebServlet("/PostscriptDetailC")
public class PostscriptDetailC extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AccountDAO.loginCheckCheck(request);
		tpostscriptDAO.showOne(request);
		request.setAttribute("contentPage", "main/TeacherpostscriptDetail.jsp");
		request.getRequestDispatcher("Index.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
