<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.ArrayList,bean.*,java.time.format.DateTimeFormatter"%>
<%
	//リクエストスコープからのデータの取得
	ArrayList<Reply> list = (ArrayList<Reply>) request.getAttribute("list");

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
			<h3 class="my-3">#<%= inquiry.getInquiryId() %> <%= subject %></h3>
			<div class="d-flex justify-content-between align-items-center">
				<form action="<%= request.getContextPath() %>/list" method="POST" class="mx-3">
					<button type="submit" class="btn btn-primary">一覧へ <i class="fa-solid fa-list"></i></button>
				</form>
				<form action="<%= request.getContextPath() %>/logout" method="POST">
					<button type="submit" class="btn btn-primary">ログアウト <i class="fa-solid fa-arrow-right-from-bracket"></i></button>
				</form>
			</div>
		</div>
		<div class="card border-secondary mb-3">
			<div class="card-header">
				<span class="fw-bold"><i class="fa-regular fa-user"></i> <%= inquiry.getName() %></span>&emsp;
				<span><%= inquiry.getEmail() %></span>&emsp;
				<span><%= dateTimeString %></span>
			</div>
			<div class="card-body">
				<%= inquiry.getContents() %>
			</div>
		</div>
		<% if (list != null) {
			for (int i = 0; i < list.size(); i++) {
				Reply reply = (Reply) list.get(i);
				String repliedAt = reply.getRepliedAt().format(formatter);
				String contents = reply.getContents();
				contents = contents.replace("\n", "<br>");
			%>
				<div class="card border-secondary mb-3">
					<div class="card-header">
						<span class="fw-bold"><i class="fa-regular fa-comments"></i> 担当者</span>&emsp;
						<span><%= repliedAt %></span>
					</div>
					<div class="card-body">
						<%= contents %>
					</div>
				</div>
			<% } %>
		<% } %>
		<div class="card border-secondary">
			<div class="card-header">
				<span class="fw-bold"><i class="fa-solid fa-reply"></i> 返信欄</span>
			</div>
			<div class="card-body">
				<form action="<%= request.getContextPath() %>/reply" method="GET">
					<div class="mb-3">
						<textarea required class="form-control" name="contents" rows="8"></textarea>
					</div>
					<input type="hidden" name="email" value="<%= inquiry.getEmail() %>">
					<input type="hidden" name="id" value="<%= inquiry.getInquiryId() %>">
					<input type="hidden" name="subject" value="<%= subject %>">
					<button type="submit" class="btn btn-primary">送信 <i class="fa-regular fa-paper-plane"></i></button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>