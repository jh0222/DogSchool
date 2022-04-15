package com.ds.login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/t_idcheck")
public class t_idcheck extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(AccountDAO.idcheck(request) == 1) {
			request.setAttribute("idcheck", "../login/t_idcheck.jsp");
		}else {
			request.setAttribute("idcheck", "../login/idcheckcomplete.jsp");
		}	
		
		request.getRequestDispatcher("login/t_signup.jsp").forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
