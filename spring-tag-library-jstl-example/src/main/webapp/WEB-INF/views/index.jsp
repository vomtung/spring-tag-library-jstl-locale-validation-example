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
				<td><form:checkboxes items="${skillList}" path="skills" /></td>
			</tr>
			<tr>
				<td>Username</td>
				<td>form:input and form:errors</td>
				<td><form:input path="username" /><form:errors path="username" cssStyle="color:red"></form:errors></td>
			</tr>
			<tr>
				<td>Label</td>
				<td>form:label</td>
				<td><form:label path="label" >label</form:label></td>
			</tr>
			<tr>
				<td>Select</td>
				<td>form:select</td>
				<td>
					<form:select path="country" items="${countryList}" />
				</td>
			</tr>
			<tr>
				<td>Options</td>
				<td>form:select</td>
				<td>
					<form:select path="sex" >
						<form:options items="${sexList}"/> 
					</form:select> 
				</td>
			</tr>
			<tr>
				<td>Password</td>
				<td>form:password</td>
				<td><form:password path="password" /><form:errors path="password" cssStyle="color:red"></form:errors></td>
			</tr>
			<tr>
				<td>Relationship Status</td>
				<td>form:radio</td>
				<td>
				<c:forEach items="${relationshipStatusList}" var="entry">
					<form:radiobutton path="relationshipStatus" label="${entry.value }" value="${entry.key }"/>
				</c:forEach> 
				</td>
			</tr>
			<tr>
				<td>Color Eyes</td>
				<td>form:radios</td>
				<td>
				<form:radiobuttons path="colorEyes" items="${colorEyesList}"/>
				</td>
			</tr> 
			<tr style="background-color: #000000;color: #999999;">
				<td colspan="1">Result</td>
				<td colspan="2">form:textarea</td>
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
