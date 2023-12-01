<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.ArrayList,bean.Inquiry,java.time.format.DateTimeFormatter" %>
<%
	ArrayList<Inquiry> list = (ArrayList<Inquiry>) request.getAttribute("list");
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
%>
<!DOCTYPE html>
<html>
<head>
<%@include file= "../common/head.jsp" %>
<title>お問い合わせ一覧</title>
</head>
<body>
	<div class="container">
		<div class="d-flex justify-content-between align-items-center">
			<h1 class="my-3">お問い合わせ一覧</h1>
			<form action="<%= request.getContextPath() %>/logout" method="POST">
				<button type="submit" class="btn btn-primary">ログアウト <i class="fa-solid fa-arrow-right-from-bracket"></i></button>
			</form>
		</div>
		<table class="table table-striped table-hover">
			<thead>
				<tr>
					<th scope="col">No.</th>
					<th scope="col">名前</th>
					<th scope="col">種類</th>
					<th scope="col">お問い合わせ日時</th>
					<th scope="col">お問い合わせ内容</th>
				</tr>
			</thead>
			<tbody class="table-group-divider">
				<%
				if (list != null) {
					for (int i = 0; i < list.size(); i++) {
						Inquiry inquiry = (Inquiry) list.get(i);
						String dateTimeString = inquiry.getSentAt().format(formatter);

						String title = inquiry.getContents().substring(0, 46);

						int categoryId = inquiry.getCategory();
						String categoryBadge = null;

						switch(categoryId) {
						case 1:
							categoryBadge = "<span class='badge rounded-pill text-bg-warning'>料金・お支払い</span>";
							break;
						case 2:
							categoryBadge = "<span class='badge rounded-pill text-bg-primary'>講座・コース・教材</span>";
							break;
						case 3:
							categoryBadge = "<span class='badge rounded-pill text-bg-secondary'>学習の進め方</span>";
							break;
						case 4:
							categoryBadge = "<span class='badge rounded-pill text-bg-info'>受講期限</span>";
							break;
						case 5:
							categoryBadge = "<span class='badge rounded-pill text-bg-dark'>受講終了後のサポート</span>";
							break;
						case 6:
							categoryBadge = "<span class='badge rounded-pill text-bg-light'>その他</span>";
							break;
						}

						int isReplied = inquiry.getIsReplied();
						String repliedBadge = null;

						switch(isReplied) {
						case 0:
							repliedBadge = "<span class='badge rounded-pill text-bg-danger'>未返信 <i class='fa-regular fa-envelope-open'></i></span>";
							break;
						case 1:
							repliedBadge = "<span class='badge rounded-pill text-bg-success'>返信済 <i class='fa-regular fa-envelope'></i></span>";
							break;
						}
				%>
				<tr style="cursor: pointer;" onclick="document.location = 'https://www.google.com/';">
					<th scope="row"><%= inquiry.getInquiryId() %></th>
					<td><%= inquiry.getName() %></td>
					<td><%= categoryBadge %></td>
					<td><%= dateTimeString %></td>
					<td><%= title %>...</td>
					<td><%= repliedBadge %></td>
				</tr>
				<% 	} %>
				<% } %>
			</tbody>
		</table>
	</div>
</body>
</html>