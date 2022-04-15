package com.ds.m1;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ds.login.AccountDAO;


@WebServlet("/nnoteDetailC_U")
public class nnoteDetailC_U extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AccountDAO.loginCheckCheck(request);
		notice_notebookDAO.getnn(request);
		CommentDAO.getcommentALL(request);
		CommentDAO.getTotal_comment(request);
		CommentDAO.pageView_comment(request);
		CommentDAO.page_comment(request);
		request.setAttribute("contentPage", "mypet/noticeDetailC_U.jsp");
		request.getRequestDispatcher("Index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
