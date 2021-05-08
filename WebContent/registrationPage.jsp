<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Joe's DVD Buy & Sell</title>
<link rel="stylesheet" type="text/css" href="res/registrationStyle.css">
</head>

<body>
	<div class="registerbox">
		<h1>Register an Account here<br>Please fill in the forms below</h1>
		<form method="POST" action="/BuyAndSell/RegistrationServlet" name="registerform">
			<p>First Name:</p>
			<input type="text" name="firstname" placeholder="Enter your first name"/>
			<p>Surname:</p>
			<input type="text" name="surname" placeholder="Enter your Surname"/>
			<p>Email:</p>
			<input type="text" name="email" placeholder="Enter Email"/>
			<p>Password:</p>
			<input type="password" name="password" placeholder="Enter Password"/>
			<br>
			<br>
			<input type="submit" name="submit" value="Login"/>
		</form>
	</div>

</body>
</html>