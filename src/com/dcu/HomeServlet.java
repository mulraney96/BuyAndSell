package com.dcu;

import java.io.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;


@WebServlet("/HomeServlet")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String search;
	private ArrayList<Item> data;

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		res.setContentType("text/html");
		HttpSession session = req.getSession();
		
		search = req.getParameter("SearchString");
		
		PrintWriter out = res.getWriter();
		String responseText = new String("<tr><th>DVD</th>\r\n" + 
				"    <th>Category</th>\r\n" + 
				"    <th>Description</th>\r\n" + 
				"    <th>Highest Bid</th>\r\n" +
				"    <th>Place Bid</th>" +
				"  </tr>");
		

		try {
			if(search.equals(""))
				data = getItems();
			else
				data = getItems(search);
			 
			if(data!=null) {
				 int size = data.size()-1;
				 for(int i=0; i<=size; i++) {
					 Item item = data.get(i);
					 responseText = responseText + "<tr id='"+i+"'><td>"+item.getItemName()+"</td><td>"+item.getCategory()+
							 "</td><td>"+item.getItemDescription()+"</td><td>"+item.getHighestBid()+"</td><td>"
							 		+ "<input type='number' id='bid"+i+"' name='bid"+i+"' placeholder='Place Bid'/>"
							 		+ "<input type='submit' onClick=\"placeBid("+item.getItemID()+", 'bid"+i+"' )\" name='button"+i+"+"
							 		+ "' value='Bid'/></td></tr>";
				 }
				 
				 out.println(responseText);
				 out.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
				
		
	}
	
	public ArrayList<Item> getItems()throws SQLException{
		
		ArrayList<Item> allItems = new ArrayList<Item>();
		
		Statement stmt = DBConnection.open();
		ResultSet rs = stmt.executeQuery("SELECT * FROM mulraneyItems");
		while(rs.next()) {
			Item item = new Item(
					Integer.parseInt(rs.getString("itemID")),
					rs.getString("category"),
					rs.getString("itemName"),
					rs.getString("itemDescription"),
					Integer.parseInt(rs.getString("sellerID")),
					Integer.parseInt(rs.getString("highestBid"))
					);
			allItems.add(item);
		}
		rs.close();
		stmt.close();
		DBConnection.close();
		return allItems;
			
	}
	
public ArrayList<Item> getItems(String search)throws SQLException{
		
		ArrayList<Item> allItems = new ArrayList<Item>();
		
		Statement stmt = DBConnection.open();
		ResultSet rs = stmt.executeQuery("SELECT * FROM mulraneyItems WHERE itemName like '%"+search+"%'");
		while(rs.next()) {
			Item item = new Item(
					Integer.parseInt(rs.getString("itemID")),
					rs.getString("category"),
					rs.getString("itemName"),
					rs.getString("itemDescription"),
					Integer.parseInt(rs.getString("sellerID")),
					Integer.parseInt(rs.getString("highestBid"))
					);
			allItems.add(item);
		}
		rs.close();
		stmt.close();
		DBConnection.close();
		return allItems;
		
				
	}
	
}
