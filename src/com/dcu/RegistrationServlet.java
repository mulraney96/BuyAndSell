package com.dcu;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet{


	private static final long serialVersionUID = 1L;
	private String firstname;
	private String surname;
	private String email;
	private String password;
	
	 public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		 res.setContentType("text/html");
		 PrintWriter out = res.getWriter();
		 
		 firstname = req.getParameter("firstname");
		 surname = req.getParameter("surname");
		 email = req.getParameter("email");
		 password = req.getParameter("password");
		 
		 try {
			registerUser(firstname, surname, email, password);
	    	res.sendRedirect("home.jsp");
		} catch (SQLException e) {
			System.out.println("Error Registering User");
			e.printStackTrace();
		}
		 
	 }
	 
	 public void registerUser(String firstname, String surname, String email, String password) throws SQLException {
		 Statement stmt = DBConnection.open();
		 String newUser = "INSERT INTO mulraneyUsers (firstname, surname, email, password)"
			 		+ "VALUES ( '"+firstname+"' , '"+surname+"' , '"+email+"' , '"+password+"' )";
		 ResultSet rs = stmt.executeQuery(newUser);
		 rs.close();
		 stmt.close();
		 DBConnection.close();
		 
	 }

}
