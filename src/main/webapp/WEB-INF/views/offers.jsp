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

	<c:forEach var="offer" items="${offers}">
		<p>
			<c:out value="${offer}"></c:out>
		</p>
	</c:forEach>
	<table>
		<tr>
			<td>년도</td>
			<td>학기</td>
			<td>이수 학점</td>
			<td>상세보기</td>
		</tr>
		<tr>
			<td>2012</td>
			<td>1</td>
			<td></td>
			<td></td>
		</tr>
		<tr>
			<td>2012</td>
			<td>2</td>
			<td>"${offer }"</td>
			<td></td>
		</tr>
		<tr>
			<td>2016</td>
			<td>1</td>
			<td></td>
			<td></td>
		</tr>
		<tr>
			<td>2016</td>
			<td>2</td>
			<td></td>
			<td></td>
		</tr>
		<tr>
			<td>2017</td>
			<td>1</td>
			<td></td>
			<td></td>
		</tr>

	</table>
</body>
</html>