package com.ds.m1;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ds.login.AccountDAO;

@WebServlet("/commentC")
public class commentC extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		AccountDAO.loginCheckCheck(request);
		CommentDAO.commentinsert(request);
		CommentDAO.getcommentALL(request);
		notice_notebookDAO.getnn(request);
		request.setAttribute("contentPage", "mypet/noticeDetailC.jsp");
		request.getRequestDispatcher("Index.jsp").forward(request, response);
	}

}
