package com.ds.m1;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ds.login.AccountDAO;


@WebServlet("/galleryinsertC")
public class galleryinsertC extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		AccountDAO.loginCheckCheck(request);
		GalleryDAO.galleryinsert(request);
		GalleryDAO.getgrdesc5(request);
		notice_notebookDAO.getnndesc5(request);
		request.setAttribute("contentPage", "mypet/mypet.jsp");
		request.getRequestDispatcher("Index.jsp").forward(request, response);
	}

}
