package com.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/UpdateCityId")
public class UpdateServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		int a=Integer.parseInt(request.getParameter("identify"));
		RequestDispatcher rd=request.getRequestDispatcher("UpdateCity.html");
		session.setAttribute("b", a);
		rd.forward(request, response);	
	}

}
