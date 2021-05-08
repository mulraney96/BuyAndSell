<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Joes Buy & Sell</title>
    <link rel="stylesheet" type="text/css" href="res/loginStyle.css">
	<script src="ajax.js"></script>
</head>
<body>
    <div class="loginbox">
        <h1>Welcome to Joe's DVD Buy & Sell<br>Login Here</h1>
        <h2 id="error"></h2>
            <p>Email</p>
            <input type="text" id="email" name="email" placeholder="Enter Email"/>
            <p>Password</p>
            <input type="password" id="password" name="password" placeholder="Enter Password"/>
            <input type="submit" onClick="logIn()" name="" value="Login"/>
            <a href="passwordRecovery.jsp">Forgot your Password?</a><br>
            <a href="registrationPage.jsp">Need to Register an Account?</a>
        </form>
    </div>
</body>
</html> 