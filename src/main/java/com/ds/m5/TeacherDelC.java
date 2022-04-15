package com.ds.m5;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ds.login.AccountDAO;

@WebServlet("/TeacherDelC")
public class TeacherDelC extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AccountDAO.loginCheckCheck(request);
		applyDAO.t_del(request);
		applyDAO.t_show(request);
		applyDAO.pageView(request);
		applyDAO.page(request);
		request.setAttribute("contentPage", "Menu5/dog.jsp");
		request.getRequestDispatcher("Index.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
