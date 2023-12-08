<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="../common/head.jsp"%>
<title>神田英会話スクール</title>
</head>
<body>
	<div class="d-flex justify-content-end align-items-center my-3">
		<a href="<%=request.getContextPath()%>/view/home.jsp"
			style="margin-right: auto;"
			class="text-decoration-none text-reset fs-5 ms-3">
			<i class="fa-solid fa-graduation-cap"></i> 神田英会話スクール</a>
			<a href="<%=request.getContextPath()%>/view/inquiry.jsp" class="btn btn-primary">お問い合わせ</a>
			<a href="<%=request.getContextPath()%>/view/login.jsp" class="btn btn-primary mx-2">管理者ログイン</a>
	</div>
	<div class="d-flex justify-content-center align-items-center"
		style="background-image: url(images/banner.jpg); height: 600px; background-size: cover; background-position: 50% 50%;">
		<div class="container">
			<h1 class="text-light " style="text-shadow: 0 0 3px rgba(0, 0, 0, 0.8);">神田英会話スクール</h1>
			<p class="text-light" style="text-shadow: 0 0 3px rgba(0, 0, 0, 0.8);">自分に合ったコンテンツで楽しく英会話を学ぶ</p>
			<a href="<%=request.getContextPath()%>/view/inquiry.jsp" class="btn btn-primary shadow">お問い合わせ</a>
		</div>
	</div>
	<div class="container">
		<h3 class="text-decoration-underline my-3">仕組み</h3>
		<div class="row row-cols-1 row-cols-md-3 g-4">
			<div class="col">
				<div class="card h-100">
					<div class="fs-1 ps-3">
						<i class="fa-regular fa-file-lines"></i>
					</div>
					<div class="card-body">
						<h5 class="card-title">アセスメント</h5>
						<p class="card-text">経験豊富な講師が、会話、リスニング、読解、ライティングのスキルを評価します。
							このアセスメントにより、学習ニーズを把握し、あなたのレベルに合わせたプログラムを提供します。</p>
					</div>
				</div>
			</div>
			<div class="col">
				<div class="card h-100">
					<div class="fs-1 ps-3">
						<i class="fa-regular fa-pen-to-square"></i>
					</div>
					<div class="card-body">
						<h5 class="card-title">パーソナライズされた学習プラン</h5>
						<p class="card-text">アセスメントの結果を基に、パーソナライズされた学習プランを作成します。
							あなたの目標に合わせた具体的な目標、改善すべきポイント、おすすめのコース期間が含まれます。
							効果的かつ効率的な学習を実現するために、カスタマイズされたアプローチを採用しています。</p>
					</div>
				</div>
			</div>
			<div class="col">
				<div class="card h-100">
					<div class="fs-1 ps-3">
						<i class="fa-regular fa-calendar"></i>
					</div>
					<div class="card-body">
						<h5 class="card-title">柔軟なスケジュール</h5>
						<p class="card-text">自分の都合や学習スタイルに合わせたスケジュールを選択できます。
							午前、午後、夜のクラスなど、柔軟なオプションを提供しています。
							学習のペースと都合に合わせて、レッスンの頻度と時間を選ぶことができます。</p>
					</div>
				</div>
			</div>
			<div class="col">
				<div class="card h-100">
					<div class="fs-1 ps-3">
						<i class="fa-solid fa-school"></i>
					</div>
					<div class="card-body">
						<h5 class="card-title">豊富な学習資料</h5>
						<p class="card-text">レッスンプラン、音声録音、インタラクティブな演習など、さまざまな学習資料にアクセスできます。
							広範なトピック、文法、語彙、発音などをカバーしています。 ライブクラスに補完するために、自習資料を活用して学習を強化できます。</p>
					</div>
				</div>
			</div>
			<div class="col">
				<div class="card h-100">
					<div class="fs-1 ps-3">
						<i class="fa-solid fa-bars-progress"></i>
					</div>
					<div class="card-body">
						<h5 class="card-title">進捗の追跡</h5>
						<p class="card-text">定期的なアセスメントや講師からのフィードバックにより、進捗を確認できます。
							スピーキング、リスニング、読解、ライティングのスキルの向上を時間の経過とともに追跡します。
							言語の目標達成をサポートするために、講師がガイダンスとサポートを提供します。</p>
					</div>
				</div>
			</div>
			<div class="col">
				<div class="card h-100">
					<div class="fs-1 ps-3">
						<i class="fa-solid fa-headset"></i>
					</div>
					<div class="card-body">
						<h5 class="card-title">継続的なサポート</h5>
						<p class="card-text">学習の旅を通じてサポートを提供する専任のサポートチームがいます。
							質問や技術的な問題、追加のサポートが必要な場合は、いつでもお問い合わせください。</p>
					</div>
				</div>
			</div>
		</div>
		</div>
		<hr>
		<div class="mb-3 text-center">Copyright © 神田英会話スクール</div>
</body>
</html>