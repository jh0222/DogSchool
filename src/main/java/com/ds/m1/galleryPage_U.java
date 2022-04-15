package com.ds.m1;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ds.login.AccountDAO;


@WebServlet("/galleryPage_U")
public class galleryPage_U extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AccountDAO.loginCheckCheck(request);
		GalleryDAO.getgalleryAll(request);
		GalleryDAO.getTotal_gallery(request);
		GalleryDAO.pageView_gallery(request);
		GalleryDAO.page_gallery(request);
		request.setAttribute("contentPage", "mypet/galleryPage_U.jsp");
		request.getRequestDispatcher("Index.jsp").forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
