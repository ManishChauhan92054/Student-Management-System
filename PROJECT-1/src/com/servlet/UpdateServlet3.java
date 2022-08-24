package com.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/UpdateMobileId")
public class UpdateServlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		int a=Integer.parseInt(request.getParameter("identify"));
		RequestDispatcher rd=request.getRequestDispatcher("UpdateMobile.html");
		session.setAttribute("b", a);
		rd.forward(request, response);
	}

}
