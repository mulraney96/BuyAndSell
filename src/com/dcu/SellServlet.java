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
import javax.servlet.http.HttpSession;

@WebServlet("/SellServlet")
public class SellServlet extends HttpServlet{


	private static final long serialVersionUID = 1L;
	private String category;
	private String itemName;
	private String itemDescription;
	private int sellerID;
	
	
	 public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		 res.setContentType("text/html");
		 PrintWriter out = res.getWriter();

		 HttpSession session = req.getSession();
		 
		 
		 category = req.getParameter("category");
		 itemName = req.getParameter("itemName");
		 itemDescription = req.getParameter("itemDescription");
		 sellerID = (int)session.getAttribute("id");
		 
		 System.out.println(category);
		 System.out.println(itemName);
		 System.out.println(itemDescription);
		 System.out.println(sellerID);

		 
		 try {
			registerItem(category, itemName, itemDescription, sellerID);
			res.sendRedirect("home.jsp");

		} catch (SQLException e) {
			System.out.println("Error Registering User");
			e.printStackTrace();
		}
	 }
	 
	 public void registerItem(String category, String itemName, String itemDescription, int sellerID) throws SQLException {
		 Statement stmt = DBConnection.open();
		 String newItem = "INSERT INTO mulraneyItems (category, itemName, itemDescription, sellerID, highestBid)"
			 		+ " VALUES ( '"+category+"' , '"+itemName+"' , '"+itemDescription+"' , '"+sellerID+"' , '0' )";
		 ResultSet rs = stmt.executeQuery(newItem);
		 rs.next();
		 rs.close();
		 stmt.close();
		 DBConnection.close(); 
	 }
	 


}
