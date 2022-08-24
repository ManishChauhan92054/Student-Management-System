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

@WebServlet("/test-5")
public class SearchID extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String a=request.getParameter("cd");
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		out.println("<p align='center'>");
		out.println("<font size='7' style='color: #D4AC0D'>");
		out.println("<b>");
		out.println("<u>");
		out.println("RECORD FETCHED!");
		out.println("</u></b></font></p>");
		out.println("<table align='center' border='1' style='border: 10px groove #2874A6 ; background-color: #D4EFDF; margin-top: 25vh'>");
		out.println("<tr><th>Student-Id</th><th>Student-Name</th><th>Student-City</th><th>Student-Course</th><th>Student-Mobile</th></tr>");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project-1","root","12345");
			String sql=("select * from student_management_system where S_Id=?");
			ps=con.prepareStatement(sql);
			ps.setString(1, a);
			
			rs=ps.executeQuery();
			if(rs.next()) {
				out.println("<tr><td>");
				out.println(rs.getInt(1));
				out.println("</td>");
				out.println("<td>");
				out.println(rs.getString(2));
				out.println("</td>");
				out.println("<td>");
				out.println(rs.getString(3));
				out.println("</td>");
				out.println("<td>");
				out.println(rs.getString(4));
				out.println("</td>");
				out.println("<td>");
				out.println(rs.getLong(5));
				out.println("</td>");
			}else {
				RequestDispatcher rd=request.getRequestDispatcher("index4.html");
				rd.forward(request, response);
			}
			RequestDispatcher rd=request.getRequestDispatcher("Home.html");
			rd.include(request, response);
			
			
		} catch (Exception e) {
			RequestDispatcher rd=request.getRequestDispatcher("index2.html");
			rd.forward(request, response);
		}
		out.println("</table>");
	}

}
