package com.ds.main;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ds.login.AccountDAO;

@WebServlet("/Noticeboard_updateC")
public class Noticeboard_updateC extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AccountDAO.loginCheckCheck(request);
		NoticeDAO.showOne(request);
		request.setAttribute("contentPage", "main/NoticeDetail_update.jsp");
		request.getRequestDispatcher("Index.jsp").forward(request, response);		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		AccountDAO.loginCheckCheck(request);
		NoticeDAO.update(request);
		NoticeDAO.showAll(request);
		PageDAO.pageView(request);
		PageDAO.page(request);
		request.setAttribute("contentPage", "main/Noticeboard_root_teacher.jsp");
		request.getRequestDispatcher("Index.jsp").forward(request, response); 
	}

}
