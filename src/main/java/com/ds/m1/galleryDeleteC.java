package com.ds.m1;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ds.login.AccountDAO;


@WebServlet("/galleryDeleteC")
public class galleryDeleteC extends HttpServlet {
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AccountDAO.loginCheckCheck(request);
		GalleryDAO.galleryDetaildelete(request);
		notice_notebookDAO.getnndesc5(request);
		GalleryDAO.getgrdesc5(request);
		request.setAttribute("contentPage", "mypet/mypet.jsp");
		request.getRequestDispatcher("Index.jsp").forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
