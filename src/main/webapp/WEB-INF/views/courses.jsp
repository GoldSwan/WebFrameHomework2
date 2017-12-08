<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/main.css">
</head>
<body>
<h2>학년/학기별 이수 총 학점</h2>
	<table class="formtable" border="1">
	<tr><td>년도</td><td>학기</td><td>이수 학점</td><td>상세보기</td><br></tr>
	<c:forEach var="splitCourseBySemester"
		items="${splitCourseBySemesters}">
		<!-- offer컨트롤러에서 넘겨준 키값 offers -->
			<tr>
				<td class="label">${splitCourseBySemester.years}</td>
				<td class="label">${splitCourseBySemester.semester}</td>
				<td class="label">${splitCourseBySemester.totalGrades}</td>
				<td class="label"><a href="${pageContext.request.contextPath}/detailcourse?years=${splitCourseBySemester.years} 
				&semester=${splitCourseBySemester.semester}">링크</a></td>
				<br>
			</tr>
	</c:forEach>
	</table>
</body>
</html>