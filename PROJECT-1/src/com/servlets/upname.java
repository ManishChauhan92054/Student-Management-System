package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/upname")
public class upname extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		int c=(int)session.getAttribute("b");
		String f=request.getParameter("name");
		
		Connection con=null;
		PreparedStatement ps=null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project-1","root","12345");
			
			String sql=("update student_management_system set S_Name=? where S_Id=?");
			ps=con.prepareStatement(sql);
			
			ps.setString(1, f);
			ps.setInt(2, c);
			
			int up=ps.executeUpdate();
			
			if(up>0) {
				RequestDispatcher rd=request.getRequestDispatcher("index5.html");
				rd.forward(request, response);
			}else {
				RequestDispatcher rd=request.getRequestDispatcher("index4.html");
				rd.forward(request, response);
			}
			
		} catch (Exception z) {
			RequestDispatcher rd=request.getRequestDispatcher("index2.html");
			rd.forward(request, response);
		}
	}
}