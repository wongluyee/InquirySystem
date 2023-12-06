<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="bean.Inquiry,java.time.format.DateTimeFormatter"%>
<%
	//リクエストスコープからのデータの取得
	Inquiry inquiry = (Inquiry) request.getAttribute("inquiry");

	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	String dateTimeString = inquiry.getSentAt().format(formatter);

	int categoryId = inquiry.getCategory();
	String subject = null;

	switch(categoryId) {
	case 1:
		subject = "料金・お支払いについて";
		break;
	case 2:
		subject = "講座・コース・教材について";
		break;
	case 3:
		subject = "学習の進め方について";
		break;
	case 4:
		subject = "受講期限について";
		break;
	case 5:
		subject = "受講終了後のサポートについて";
		break;
	case 6:
		subject = "その他";
		break;
	}
%>
<!DOCTYPE html>
<html>
<head>
<%@include file="../common/head.jsp"%>
<title>お問い合わせ詳細：#<%= inquiry.getInquiryId() %> | <%= subject %></title>
</head>
<body>
	<div class="container">
		<div class="d-flex justify-content-between align-items-center">
			<h1 class="my-3">No.<%= inquiry.getInquiryId() %> <%= subject %></h1>
			<div class="d-flex justify-content-between align-items-center">
				<form action="<%= request.getContextPath() %>/list" method="POST" class="mx-3">
					<button type="submit" class="btn btn-primary">一覧へ <i class="fa-solid fa-list"></i></button>
				</form>
				<form action="<%= request.getContextPath() %>/logout" method="POST">
					<button type="submit" class="btn btn-primary">ログアウト <i class="fa-solid fa-arrow-right-from-bracket"></i></button>
				</form>
			</div>
		</div>
		<div class="card border-secondary">
			<div class="card-header">
				<span class="fw-bold"><i class="fa-regular fa-user"></i> <%= inquiry.getName() %></span>&emsp;
				<span><%= inquiry.getEmail() %></span>&emsp;
				<span><%= dateTimeString %></span>
			</div>
			<div class="card-body">
				<%= inquiry.getContents() %>
			</div>
		</div>
		<br>
		<div class="card border-secondary">
			<div class="card-header">
				<span class="fw-bold"><i class="fa-solid fa-reply"></i> 返信欄</span>
			</div>
			<div class="card-body">
				<form>
					<div class="mb-3">
						<textarea class="form-control" rows="8"></textarea>
					</div>
					<button type="submit" class="btn btn-primary">送信 <i class="fa-regular fa-paper-plane"></i></button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>