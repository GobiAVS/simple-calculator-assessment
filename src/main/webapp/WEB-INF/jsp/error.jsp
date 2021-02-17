<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Simple Calculator</title>
<style type="text/css">
.linkCSS {
	cursor: pointer;
	text-decoration: none;
}

.padding {
	padding: 13px 0px 20px 145px;
}
</style>
</head>
<body>
	<center>
		<h2>${name}</h2>
	</center>
	<form method="post" action="welcome">
		<div>
			<table>
		   Please try again
			<tr>
				<td>Error</td>
				<td>${error}</td>
			</tr>
			<tr>
				<td>Status</td>
				<td>${status}</td>
			</tr>
			<tr>
				<td>Message</td>
				<td>${message}</td>
			</tr>
			</table>
		</div>
		<div>
			<div class="padding"><input type="submit" name="action" value="Calculate Again"></div> 
		</div>
	</form>
</body>
</html>