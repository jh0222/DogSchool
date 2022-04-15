package com.ds.main;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ds.login.AccountDAO;



@WebServlet("/Noticeboard_deleteC")
public class Noticeboard_deleteC extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AccountDAO.loginCheckCheck(request);
		NoticeDAO.delete(request);
		NoticeDAO.showAll(request);
		PageDAO.pageView(request);
		PageDAO.page(request);
		request.setAttribute("contentPage", "main/Noticeboard_root_teacher.jsp");
		request.getRequestDispatcher("Index.jsp").forward(request, response); 
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
