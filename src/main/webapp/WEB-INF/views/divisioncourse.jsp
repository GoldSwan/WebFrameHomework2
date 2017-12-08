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
	이수 구분별 학점 조회

	<table class="formtable" border="1">
		<tr>
			<td>교필</td>
			<td>일교</td>
			<td>전기</td>
			<td>핵교A</td>
			<td>핵교B</td>
			<td>전선</td>
			<td>자율</td>
			<td>인재</td>
			<td>총점</td>
			<br>
		</tr>
		<tr>
			<td class="label">${splitGrades.divisiongrades1}</td>
			<td class="label">${splitGrades.divisiongrades2}</td>
			<td class="label">${splitGrades.divisiongrades3}</td>
			<td class="label">${splitGrades.divisiongrades4}</td>
			<td class="label">${splitGrades.divisiongrades5}</td>
			<td class="label">${splitGrades.divisiongrades6}</td>
			<td class="label">${splitGrades.divisiongrades7}</td>
			<td class="label">${splitGrades.divisiongrades8}</td>
			<td class="label">${splitGrades.totalDivisionGrades}</td>
		</tr>
	</table>

</body>
</html>