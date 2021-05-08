<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.dcu.Item" %>
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Insert title here</title>
	<script src="ajax.js"></script>
	<link rel="stylesheet" type="text/css" href="res/homeStyle.css">
	
</head>


<body onLoad="init()">
	<header>
		<div class="wrapper">
			<div class="heading">
				<h1>Joe's Classic DVD Buy & Sell</h1>
			</div>
				<ul class="nav-area">
					<li><a href="login.jsp">Login</a></li>
					<li><a href="registrationPage.jsp">Register an Account</a></li>
					<li><a href="sellPage.html">Place an Advertisement</a>
					<li><%String name=(String)session.getAttribute("name");
							out.print("Welcome back "+ name); %></li>			
				</ul>
		</div>		
	</header>
	
	
	
	<div class="middle" >
		<p>Welcome, take a look through our library or search for a movie you want</p>
            <input type="text" id="search" name="search" placeholder="Search Item"/>
            <input type="submit" onClick="fillTable(document.getElementById('search'))" name="" value="Search"/>
		
		<h4 id='bidResponse'></h4>
		
		<div class="table-wrapper">
			<table class="itemList" id="itemList">	
			</table>
		</div>
	</div>
	
	
	
	<div class="Footer">
		<h1></h1>
		
	</div>
</body>
</html>