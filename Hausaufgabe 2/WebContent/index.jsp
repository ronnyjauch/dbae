<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Login</title>
	</head>
	<body>
		<form action="LoginServlet" method="post">
			<label>Name: </label>
			<input name="name" type="text" placeholder="Ihr Name..."><br>
			<label>Passwort: </label>
			<input name="password" type="password" placeholder="Ihr Passwort"><br>
			<button type="submit">Absenden!</button>
		</form>
		<label>${message}</label>
	</body>
</html>