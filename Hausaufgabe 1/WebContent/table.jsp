<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Tabelle</title>
	</head>
	<body>
		<ol>
			<li>
				Text: ${text}
			</li>
			<li>
				Password: ${password}
			</li>
			<li>
				Email: ${email}
			</li>
			<li>
				Zugriff: ${zugriff}
			</li>
		</ol>
		<table>
			<tr>
				<th>Name</th>
				<th>Prozent</th>
				<th>Fehlerquote</th>
			</tr><tr>
				<td>Dennis</td>
				<td>${proz0}%</td>
				<td>${fehlerquote0}</td>
			</tr><tr>
				<td>Lissi</td>
				<td>${proz1}%</td>
				<td>${fehlerquote1}</td>
			</tr><tr>
				<td>Tobias</td>
				<td>${proz2}%</td>
				<td>${fehlerquote2}</td>
			</tr>
		</table>
		${serverzeit}
		<a href="http://localhost:8080/Hausaufgabe_1/index.html" type="Hausaufgabe">Zurueck</a>
	
	</body>
</html>