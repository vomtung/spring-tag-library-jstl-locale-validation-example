<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<%@	taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
<h2>spring-form.tld Example</h2>

<form:form commandName="user" method="POST"  action="${pageContext.servletContext.contextPath}/index/submit">
		<table border="0" style="width: 100%">
			<tr style="background-color: #000000;color: #999999;">
				<td>Name</td>
				<td>Tag</td>
				<td>Value</td>
			</tr>
			<tr>
				<td>Favourite Skill</td>
				<td>form:checkbox</td>
				<td>
				<c:forEach items="${skillList}" var="skill">
					<form:checkbox path="favouriteSkill" label="${skill.value}" value="${skill.key}" />
				</c:forEach>
				</td>
			</tr>
			<tr>
				<td>Skills</td>
				<td>form:checkboxs</td>
				<td><form:checkboxes items="${skillList}" path="skills" /><br/></td>
			</tr>
			<tr>
				<td>Username</td>
				<td>form:input and form:errors</td>
				<td><form:input path="username" /><form:errors path="username" cssStyle="color:red"></form:errors></td>
			</tr>
			<tr>
				<td>Label</td>
				<td>form:label</td>
				<td><form:label path="label" >label</form:label><br/></td>
			</tr>
			<tr>
				<td>Password</td>
				<td>form:password</td>
				<td><form:password path="password" /><form:errors path="password" cssStyle="color:red"></form:errors></td>
			</tr>
			<tr style="background-color: #000000;color: #999999;">
				<td colspan="3">Result</td>
			</tr>
			<tr>
				<td colspan="3"><form:textarea path="result" readonly="true" style="width: 100%"></form:textarea></td>
			</tr>
		</table>
		<br>
		<br>
		<input type="submit" value="Submit" /><br/>
	</form:form>
</body>
</html>
