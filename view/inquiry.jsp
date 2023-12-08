<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="../common/head.jsp"%>
<title>お問い合わせフォーム</title>
</head>
<body>
	<div class="container">
		<div class="d-flex justify-content-between align-items-center">
			<h3 class="my-3">お問い合わせフォーム</h3>
			<a href="<%= request.getContextPath() %>/view/home.jsp" class="btn btn-primary">ホームへ戻る</a>
		</div>
		<form action="<%= request.getContextPath() %>/inquiry"  method="GET">
			<div class="form-group row mb-3">
				<label for="email" class="col-sm-2 col-form-label">メールアドレス <span class="text-danger">*</span></label>
				<div class="col-sm-10">
					<input required type="email" class="form-control" id="email" name="email"
						placeholder="email@example.com">
				</div>
			</div>
			<div class="form-group row mb-3">
				<label for="name" class="col-sm-2 col-form-label">名前 <span class="text-danger">*</span></label>
				<div class="col-sm-10">
					<input required type="text" class="form-control" id="name" name="name"
						placeholder="神田英語">
				</div>
			</div>
			<div class="form-group row mb-3">
				<label for="age" class="col-sm-2 col-form-label">年齢</label>
				<div class="col-sm-10">
					<select name="age" class="form-control">
						<option value="0~9">0~9</option>
						<option value="10~19">10~19</option>
						<option value="20~29">20~29</option>
						<option value="30~39">30~39</option>
						<option value="40~49">40~49</option>
						<option value="50~59">50~59</option>
						<option value="60~69">60~69</option>
						<option value="70~79">70~79</option>
						<option value="80~89">80~89</option>
						<option value="90~">90~</option>
					</select>
				</div>
			</div>
			<div class="form-group row mb-3">
				<label for="gender" class="col-sm-2 col-form-label">性別</label>
				<div class="col-sm-10">
					<div class="form-check form-check-inline">
						<input class="form-check-input" type="radio" name="gender"
							id="male" value="male">
						<label class="form-check-label" for="male">男</label>
					</div>
					<div class="form-check form-check-inline">
						<input class="form-check-input" type="radio" name="gender"
							id="female" value="female">
						<label class="form-check-label" for="female">女</label>
					</div>
					<div class="form-check form-check-inline">
						<input class="form-check-input" type="radio" name="gender"
							id="non-binary" value="non-binary">
						<label class="form-check-label"
							for="non-binary">ノンバイナリー</label>
					</div>
					<div class="form-check form-check-inline">
						<input class="form-check-input" type="radio" name="gender"
							id="other" value="other">
						<label class="form-check-label" for="other">その他</label>
					</div>
					<div class="form-check form-check-inline">
						<input class="form-check-input" type="radio" name="gender"
							id="no-answer" value="no-answer">
						<label class="form-check-label" for="no-answer">回答しない</label>
					</div>
				</div>
			</div>
			<div class="form-group row mb-3">
				<label for="address" class="col-sm-2 col-form-label">住所</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="address" name="address"
						placeholder="東京都千代田区紺屋町11">
				</div>
			</div>
			<div class="form-group row mb-3">
				<label for="category" class="col-sm-2 col-form-label">お問い合わせ項目</label>
				<div class="col-sm-10">
					<select name="category" class="form-control">
						<option value="1">料金・お支払いについて</option>
						<option value="2">講座・コース・教材について</option>
						<option value="3">学習の進め方について</option>
						<option value="4">受講期限について</option>
						<option value="5">受講終了後のサポートについて</option>
						<option value="6">その他</option>
					</select>
				</div>
			</div>
			<div class="form-group row mb-3">
				<label for="contents" class="col-sm-2 col-form-label">お問い合わせ記入欄 <span class="text-danger">*</span></label>
				<div class="col-sm-10">
					<textarea required class="form-control" id="contents" name="contents" rows="3"></textarea>
				</div>
			</div>
			<button type="submit" class="btn btn-primary" style="float: right">送信</button>
		</form>
	</div>
</body>
</html>