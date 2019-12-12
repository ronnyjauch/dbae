<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Profil</title>
	</head>
	<body>
		<label>${message}</label>
		<form action="ProfilServlet" method="post">
			<label>Alter: </label>
			<input name="age" type="text" placeholder="Ihr Alter..." value="${age }"><br>
			<label>E-Mail: </label>
			<input name="email" type="text" placeholder="Ihre E-Mail..." value="${email }"><br>
			<label>Telefonnummer: </label>
			<input name="number" type="text" placeholder="Ihre Telefonnummer..." value="${number }"><br>
			<label>Passwort (neu): </label>
			<input name="password1" type="text" placeholder="Ihr neues Passwort..." value="${password1 }"><br>
			<label>Passwort (Wiederholung): </label>
			<input name="password2" type="text" placeholder="Bitte wiederholen Sie ihr neues Passwort..." value="${password2 }"><br>
			<input type="checkbox" name="agb" value="${agb }">AGB<br>
			<input type="checkbox" name="privacypolicies" value="${privacypolicies }">Datenschutzbestimmungen<br>
			<button type="submit">Absenden!</button>
		</form>
	</body>
</html>