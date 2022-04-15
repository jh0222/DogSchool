package com.ds.m1;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ds.login.AccountDAO;


@WebServlet("/nnotebooklist")
public class nnotebooklist extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AccountDAO.loginCheckCheck(request);
		notice_notebookDAO.getnnALL(request);
		notice_notebookDAO.getTotal(request);
		notice_notebookDAO.pageView(request);
		notice_notebookDAO.page(request);
		request.setAttribute("contentPage", "mypet/notice_notebookllist.jsp");
		request.getRequestDispatcher("Index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
