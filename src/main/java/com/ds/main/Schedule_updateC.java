package com.ds.main;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ds.login.AccountDAO;

@WebServlet("/Schedule_updateC")
public class Schedule_updateC extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AccountDAO.loginCheckCheck(request);
		ScheduleDAO.showAll(request);
		request.setAttribute("contentPage", "main/Schedule_root_teacher_insert.jsp");
		request.getRequestDispatcher("Index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AccountDAO.loginCheckCheck(request);

        if(ScheduleDAO.update(request) == 1) {
            ScheduleDAO.showAll(request);
            request.setAttribute("contentPage", "main/Schedule_root_teacher.jsp");
            request.getRequestDispatcher("Index.jsp").forward(request, response);
        }else {
            ScheduleDAO.insert(request);
            ScheduleDAO.showAll(request);
            request.setAttribute("contentPage", "main/Schedule_root_teacher.jsp");
            request.getRequestDispatcher("Index.jsp").forward(request, response);
        }
	}

}
