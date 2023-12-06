<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String error = (String) request.getAttribute("error");
	String cmd = (String) request.getAttribute("cmd");
%>
<!DOCTYPE html>
<html>
<head>
<%@include file="../common/head.jsp"%>
<title>エラー</title>
</head>
<body>
	<div class="container">
		<h3 class="my-3"><i class="fa-solid fa-triangle-exclamation"></i> エラー</h3>
		<% if (error != null) { %>
		<p><%= error %></p>
		<% } %>

		<% if (cmd != null & cmd.equals("logout")) { %>
			<a class="btn btn-primary" href="<%= request.getContextPath() %>/view/login.jsp">ログインページ</a>
		<% } else { %>
			<button class="btn btn-primary" onclick="history.back()">戻る</button>
		<% } %>
	</div>
</body>
</html>