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

@WebServlet("/Delete_Student")
public class DeleteStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int a=Integer.parseInt(request.getParameter("id"));
		
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		
		Connection con=null;
		PreparedStatement ps=null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project-1","root","12345");
			
			String sql=("delete from student_management_system where S_Id=?");
			ps=con.prepareStatement(sql);
			
			ps.setInt(1, a);
			
			int up=ps.executeUpdate();
			
			if(up>0) {
				RequestDispatcher rd=request.getRequestDispatcher("index3.html");
				rd.forward(request, response);
			}else {
				RequestDispatcher rd=request.getRequestDispatcher("index4.html");
				rd.forward(request, response);
			}
			
		} catch (Exception f) {
			f.printStackTrace();
			RequestDispatcher rd=request.getRequestDispatcher("index2.html");
			rd.forward(request, response);
		}
	}

}
