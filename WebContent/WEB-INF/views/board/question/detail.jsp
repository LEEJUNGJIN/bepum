<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- 베푸미 공개 설정 및 자기소개 변경 -->
<link href="../css/common_style.css" type="text/css" rel="stylesheet" />
<link href="../css/style2.css" type="text/css" rel="stylesheet" />
<link href="../css/board.css" type="text/css" rel="stylesheet" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>
<body>
	<jsp:include page="../../inc/header.jsp"></jsp:include>

	<div id="body">
		<div class="content-container">
			<main id="main" class="main"> 
			<c:if test="${empty b.privateKey && isSecret == 1}">
				<div>
					이 글은 비밀글입니다.
					<form method="post">
						<input type="password" alt="글비밀번호" name = "secretKey" />
						<input type="submit" alt="확인" value = "submit" />
					</form>
				</div>
			</c:if>
			<c:if test="${not empty b.privateKey || isSecret == 0}">
				<div class="detail-container">
					<div class="info-container">
						<div class="tr-info clearfix">
							<span class="title">${b.title}</span> <span class="reg-date">${b.regDate}</span>
						</div>
						<div class="wch-info clearfix">
							<span class="writer">${b.writerId}</span>
							<div class="ch-wrapper">
								<span class="comment-num">댓글 수 ${b.countCmt} </span> <span
									class="hit">조회수 ${b.hit}</span>
							</div>
						</div>
					</div>
					<div class="detail-content">${fn:replace(b.content, cn, br)}
					</div>
					<div>
						<a href="question" class="btn">목록</a>
						<div class="ed-wrapper">
							<a href="question-edit?no=${b.no}" class="btn">수정</a> <a
								href="question-del?no=${b.no}" class="btn">삭제</a>
						</div>
					</div>

				</div>
			</c:if> </main>
		</div>
	</div>

	<jsp:include page="../../inc/footer.jsp"></jsp:include>

</body>
</html>