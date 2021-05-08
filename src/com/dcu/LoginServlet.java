package com.dcu;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.*;
import java.sql.*;
import oracle.jdbc.driver.*;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

	 private static final long serialVersionUID = 2L;
	 private String email;
	 private String password;
	       
	 public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	
		email = req.getParameter("email");
		password = req.getParameter("password");
		PrintWriter out = res.getWriter();

		 
	     User user = null;
		try {
			user = validateUser(email, password);
		} 
		catch (SQLException e) {
			System.out.println("A wee error at the validate user method at Login Servlet");
			e.printStackTrace();
		}
		System.out.println(user);
		
	    if (user!=null) {   
	    	 // login succeeded
	    	 HttpSession session = req.getSession();
	    	 session.setAttribute("id", user.getid()); 
	    	 session.setAttribute("name", user.getFirstname());
	    	 System.out.println(user.getFirstname());
	    	 res.sendRedirect("home.jsp");
	     }
	     else {   
	    	 res.setStatus(400);
	     }
	 }
	    

	 private static User validateUser(String email,String password) throws SQLException {
	    
		Statement stmt = DBConnection.open();
	    ResultSet rs = stmt.executeQuery("SELECT * FROM mulraneyUsers");
	    while(rs.next()) {
	     if(rs.getString("password").contentEquals(password) && rs.getString("email").contentEquals(email) ) {
	    	User user =  new User(Integer.parseInt(rs.getString("id")), rs.getString("surname"), rs.getString("firstname"),  
	    			rs.getString("password"), rs.getString("email"));
		    rs.close();
		    stmt.close();
	    	DBConnection.close();
            System.out.println("User Created");

	    	return user;
	     }
	     else {
		 
	     }
	    }
	    rs.close();
	    stmt.close();
	    DBConnection.close();
	    return null;
	    
	    }
}
