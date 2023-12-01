<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="../common/head.jsp"%>
<title>お問い合わせありがとうございました。</title>
</head>
<body>
	<div class="container text-center">
		<h3 class="my-3">お問い合わせありがとうございました。</h3>
		<p>3営業日以内にご連絡いたしますので、今しばらくお待ちくださいませ。</p>
		<a class="btn btn-primary" href="<%= request.getContextPath() %>/view/inquiry.jsp">戻る</a>
	</div>

</body>
</html>