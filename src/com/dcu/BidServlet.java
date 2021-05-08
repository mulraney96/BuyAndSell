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

/**
 * Servlet implementation class BidServlet
 */
@WebServlet("/BidServlet")
public class BidServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private String bid; 
    private String itemID;
	
    public BidServlet() {
        super();
    }

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		HttpSession session = req.getSession();
		PrintWriter out = res.getWriter();

		bid = req.getParameter("PlaceBid");
		itemID = req.getParameter("ItemId");
		
		String responseText;
		int response;
		try {
			response = placeBid(bid, itemID);
			if(response==0) {
				responseText = "<p>Your bid was not high enough</p>";
			}
			else if(response==1) {
				responseText = "<p>Bid Placed</p>";
			}
			else {
				responseText = "<p>Error, please ensure number entered is correct</p>";
			}
			out.println(responseText);
			out.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}


	private int placeBid(String bid, String itemId) throws SQLException{
		Statement stmt = DBConnection.open();
		ResultSet rs = stmt.executeQuery("SELECT highestBid FROM mulraneyItems WHERE itemID='"+itemID+"'");
		while(rs.next()) {
			int temp = Integer.parseInt(rs.getString("highestBid"));
			int newBid = Integer.parseInt(bid);
			if(newBid<=temp) {
				rs.close();
				stmt.close();
				DBConnection.close();
				return 0;
			}
			else if(newBid>=temp){
				ResultSet rs2 = stmt.executeQuery("UPDATE mulraneyItems SET highestBid='"+bid+"' WHERE itemId='"+itemId+"'");
				rs2.next();
				rs.close();
				rs2.close();
				stmt.close();
				DBConnection.close();
				return 1;
			}
			else {
				rs.close();
				stmt.close();
				DBConnection.close();
				return -1;
			}
		}
		
		return 0;
	}
}
