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

import org.apache.catalina.ant.DeployTask;
import org.apache.jasper.tagplugins.jstl.core.Out;


@WebServlet("/Add_Student")
public class AddStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int a=Integer.parseInt(request.getParameter("id"));
		String b=request.getParameter("name");
		String c=request.getParameter("city");
		String d=request.getParameter("course");
		long e=Long.parseLong(request.getParameter("mob"));
		
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		
		Connection con=null;
		PreparedStatement ps=null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project-1","root","12345");
			
			String sql=("insert into student_management_system(S_Id,S_Name,S_City,S_Course,S_Mobile) values (?,?,?,?,?)");
			ps=con.prepareStatement(sql);
			
			ps.setInt(1, a);
			ps.setString(2, b);
			ps.setString(3, c);
			ps.setString(4, d);
			ps.setLong(5, e);
			
			int up=ps.executeUpdate();
			
			if(up>0) {
				RequestDispatcher rd=request.getRequestDispatcher("index1.html");
				rd.forward(request, response);
			}else {
				RequestDispatcher rd=request.getRequestDispatcher("index2.html");
				rd.forward(request, response);
			}
			
		} catch (Exception f) {
			RequestDispatcher rd=request.getRequestDispatcher("index2.html");
			rd.forward(request, response);
		}
	}

}
