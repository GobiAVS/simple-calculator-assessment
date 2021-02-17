<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


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
			<div class="padding">${resultPage}${result}</div>
		</div>
		<div class="padding">
			<h2>Calculation History</h2>
			<table>
					<tr>
						<th>OPERATION</th>
						<th>SOURCE ONE</th>
						<th>SOURCE TWO</th>
						<th>RESULT</th>
					</tr>
					<c:forEach var="calculation" items="${getAllCalculations}"> 
						<tr>
							<td><c:out value="${calculation.operation}"/></td>
							<td><c:out value="${calculation.sourceOne}"/></td>
							<td><c:out value="${calculation.sourceTwo}"/></td>
							<td><c:out value="${calculation.result}"/></td>
						</tr>            
					</c:forEach>
				</table>		
		</div>
		<div>
			<div class="padding"><input type="submit" name="action" value="Calculate Again"></div> 
		</div>
	</form>
</body>
</html>