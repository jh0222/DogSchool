package com.ds.login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ds.m2.Menu2DAO;

@WebServlet("/T_Menu2UpdateC")
public class T_Menu2UpdateC extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		AccountDAO.t_mypageUpdate(request);
		AccountDAO.loginCheck(request);
		AccountDAO.loginCheckCheck(request);
		Menu2DAO.u_select(request);
		request.setAttribute("contentPage", "Menu2/Menu2_Teacher.jsp");
		request.getRequestDispatcher("Index.jsp").forward(request, response);
	}

}
