<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Tabelle</title>
</head>
<body>

<form action="MyServlet" method="post">
<table>
<tr>
<th>Name</th>
<th>Prozent</th>
<th>Fehlerquote</th>
</tr><tr>
<td>${nameA}</td>
<td>${proA}%</td>
<td>${feh1}</td>
</tr><tr>
<td>${nameB}</td>
<td>${proB}%</td>
<td>${feh2}</td>
</tr><tr>
<td>${nameC}</td>
<td>${proC}%</td>
<td>${feh3}</td>
</tr>
</table>

<a href="http://localhost:8080/Hausaufgabe_1/index.html" type="Hausaufgabe">Zurueck</a>
</form>

</body>
</html>