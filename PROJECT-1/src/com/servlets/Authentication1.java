package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Authentication1")
public class Authentication1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int a=Integer.parseInt(request.getParameter("id"));
		String b=request.getParameter("pass");
		int c=92054;
		String d="Admin@123";
			
		if((a==c)&&(b.equals(d))){
			RequestDispatcher rd=request.getRequestDispatcher("index.html");
			rd.forward(request, response);
		}else{
			RequestDispatcher rd=request.getRequestDispatcher("Failed1.html");
			rd.forward(request, response);
		}
	}
}