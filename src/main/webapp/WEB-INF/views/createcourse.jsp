<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/main.css">
</head>
<body>
<h2>수강신청</h2>
	<sf:form method="post"
		action="${pageContext.request.contextPath}/docreate" modelAttribute="course">

		<table class="formtable">
			<tr><td class="label">수강년도:</td><td><sf:input class="control" type="text" path="years" value="2018"/><br>
				<sf:errors path="years" class="error"/></td></tr>
			<tr><td class="label">학기:</td><td><sf:input class="control" type="text" path="semester" value="1"/><br>
				<sf:errors path="semester" class="error"/></td></tr>
			<tr><td class="label">교과코드:</td><td><sf:input class="control" type="text" path="coursecode"/><br>
				<sf:errors path="coursecode" class="error"/></td></tr>
			<tr><td class="label">교과목명:</td><td><sf:input class="control" type="text" path="coursename"/><br>
				<sf:errors path="coursename" class="error"/></td></tr>
			<tr><td class="label">구분:</td><td><sf:input class="control" type="text" path="division"/><br>
				<sf:errors path="division" class="error"/></td></tr>
			<tr><td class="label">학점:</td><td><sf:input class="control" type="text" path="grades" value="3"/><br>
				<sf:errors path="grades" class="error"/></td></tr>	
			<tr><td class="label"></td><td><input class="control" type="submit" value="수강 신청"></td></tr>
		</table>
	</sf:form>

</body>
</html>