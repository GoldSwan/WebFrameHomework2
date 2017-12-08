<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
상세 
	<c:forEach var="detailCourse" items="${detailCourses}">
		<!-- offer컨트롤러에서 넘겨준 키값 offers -->
		<p>
			<c:out value="${detailCourse}"></c:out>
		</p>
		
	</c:forEach>
	
	<table class="formtable" border="1">
	<tr><td>수강년도</td><td>학기</td><td>교과코드</td><td>교과목명</td><td>구분</td><td>학점</td><br></tr>
	<c:forEach var="detailCourse"
		items="${detailCourses}">
		<!-- offer컨트롤러에서 넘겨준 키값 offers -->
			<tr>
				<td class="label">${detailCourse.years}</td>
				<td>${splitCourseBySemester.semester}</td>
				<td>${splitCourseBySemester.totalGrades}</td>
				<td><a href="${pageContext.request.contextPath}/detailcourse?years=${splitCourseBySemester.years} 
				&semester=${splitCourseBySemester.semester}">링크</a></td>
				<br>
			</tr>
	</c:forEach>
	</table>
</body>
</html>