package com.ds.login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/u_idcheck")
public class u_idcheck extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(AccountDAO.idcheck(request) == 1) {
			request.setAttribute("idcheck", "../login/u_idcheck.jsp");
		}else {
			request.setAttribute("idcheck", "../login/idcheckcomplete.jsp");
		}	
		
		request.getRequestDispatcher("login/u_signup.jsp").forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
