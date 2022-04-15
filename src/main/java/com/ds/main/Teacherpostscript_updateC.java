package com.ds.main;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ds.login.AccountDAO;

@WebServlet("/Teacherpostscript_updateC")
public class Teacherpostscript_updateC extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AccountDAO.loginCheckCheck(request);
		tpostscriptDAO.showOne(request);
		request.setAttribute("contentPage", "main/TeacherpostscriptDetail_update.jsp");
		request.getRequestDispatcher("Index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		AccountDAO.loginCheckCheck(request);
		tpostscriptDAO.update(request);
		tpostscriptDAO.showAll(request);
		PageDAO.postscript_page(request);
		PageDAO.postscript_pageView(request);
		request.setAttribute("contentPage", "main/Teacherpostscript_root_user.jsp");
		request.getRequestDispatcher("Index.jsp").forward(request, response);
	}

}
