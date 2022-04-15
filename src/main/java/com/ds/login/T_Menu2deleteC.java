package com.ds.login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ds.m2.Menu2DAO;


@WebServlet("/T_Menu2deleteC")
public class T_Menu2deleteC extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Menu2DAO.T_Menu2deleteC(request);
		AccountDAO.loginCheckCheck(request);
		Menu2DAO.u_select(request);
		request.setAttribute("contentPage", "Menu2/Menu2_Root.jsp");
		request.getRequestDispatcher("Index.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
