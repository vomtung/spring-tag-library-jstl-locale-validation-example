<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<html>
<body>
<h2>Check box example</h2>

<form:form commandName="user" method="POST"  action="${pageContext.servletContext.contextPath}/index/submit">
		<table border="0">
			<tr>
				<td>Checkbox</td>
				<td><form:checkbox path="solved" />Solved<br/></td>
			</tr>
			<tr>
				<td>Username</td>
				<td><form:input path="username" /></td>
				<td><form:errors path="username" ></form:errors></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><form:password path="password" /></td>
				<td><form:errors path="password" ></form:errors></td>
			</tr>
		</table>
		<br>
		<form:textarea path="result" readonly="true" ></form:textarea>
		<br>
		<input type="submit" value="Submit" /><br/>
	</form:form>
</body>
</html>