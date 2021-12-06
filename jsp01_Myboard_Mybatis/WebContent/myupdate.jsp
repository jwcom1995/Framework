<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>

<%@page import = "com.my.dao.MyBoardDao" %>
<%@page import = "com.my.dto.MyBoardDto" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	int myno = Integer.parseInt(request.getParameter("myno"));
	MyBoardDao dao = new MyBoardDao();
	MyBoardDto dto = dao.selectOne(myno);
%>

<form action="myupdate_res.jsp" method="post">
	<table>
		<input type="hidden" name="myno" value="<%= dto.getMyno()%>">
		<!-- 화면에 보여주기 싫으나 전송시 같이 넘어가야될 값 처리 -->
		
		<tr>
			<th>NAME : </th>
			<td><%= dto.getMyname() %></td>
		</tr>
		<tr>
			<th>TITLE : </th>
			<td><input type="text" name="mytitle" value="<%= dto.getMytitle()%>"></td>
		</tr>
		<tr>
			<th>CONTENT : </th>
			<td><textarea rows="10" cols="60" name="mycontent"><%= dto.getMycontent()%></textarea></td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" value="수정">
				<!-- 이전 페이지 이동 방법 
				1. location.href= ""       	이전 페이지 주소를 입력
				2. history.back() 			이전 페이지로 이동
				3. history.go(-1)			원하는만큼 페이지 이동
				
				<input type="button" value="취소" onclick="location.href='selectone.jsp?myno=<%= dto.getMyno() %>'">
				<input type="button" value="취소" onclick="history.back()"> -->
		
				<input type="button" value="취소" onclick="history.go(-1)">
			</td>
		</tr>
	</table>
</form>
</body>
</html>