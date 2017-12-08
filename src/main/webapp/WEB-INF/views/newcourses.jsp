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
2018년 1학기 신청 내역 조회

	<table class="formtable" border="1">
	<tr><td>수강년도</td><td>학기</td><td>교과코드</td><td>교과목명</td><td>구분</td><td>학점</td><br></tr>
	<c:forEach var="newcourse"
		items="${newcourses}">
		<!-- offer컨트롤러에서 넘겨준 키값 offers -->
			<tr>
				<td class="label">${newcourse.years}</td>
				<td class="label">${newcourse.semester}</td>
				<td class="label">${newcourse.coursecode}</td>
				<td class="label">${newcourse.coursename}</td>
				<td class="label">${newcourse.division}</td>
				<td class="label">${newcourse.grades}</td>
			<br>
			</tr>
	</c:forEach>
	</table>

	<%-- <c:forEach var="newcourse" items="${newcourses}">
		<!-- offer컨트롤러에서 넘겨준 키값 offers -->
		<p>
			<c:out value="${newcourse}"></c:out>
		</p>
		
	</c:forEach> --%>
</body>
</html>