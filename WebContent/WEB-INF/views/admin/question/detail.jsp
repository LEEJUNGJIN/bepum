<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- 베푸미 공개 설정 및 자기소개 변경 -->
<link href="../../css/common_style.css" type="text/css" rel="stylesheet" />
<link href="../../css/style2.css" type="text/css" rel="stylesheet" />
<link href="../../css/admin.css" type="text/css" rel="stylesheet" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>
<body>
	<jsp:include page="../../inc/header.jsp"></jsp:include>

	<div id="body" class="body">
		<div class="content-container clearfix">
			<jsp:include page="../inc/aside.jsp"></jsp:include>
			<form method="post">
				<main id="main" class="main">
				<div class="detail-container">
					<div class="info-container">
						<div class="tr-info clearfix">
							<span class="title">${b.title}</span> <span class="reg-date"><fmt:formatDate
									value="${b.regDate}" pattern="YY-MM-dd HH:MM" var="regDate" />${regDate}</span></span>
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
							<c:if test="${sessionScope.id.equals(b.writerId)}">
								<a href="question-edit?no=${b.no}" class="btn">수정</a>
								<a href="question-del?no=${b.no}" class="btn">삭제</a>
							</c:if>
						</div>
					</div>
				</div>
				<div class="cmt-container">
					<c:if test="${b.countCmt==0}">
						<br />
					</c:if>
					<c:forEach items="${cmtList}" var="c" varStatus="i">
						<div class="cmt-row">
							<div class="cmt-info">
								<span><b>${i.count}. ${c.writerId}</b></span><span><fmt:formatDate
										value="${c.regDate}" pattern="YY-MM-dd HH:MM" var="regDate" />${regDate}</span>
								<c:if test="${c.writerId.equals(b.writerId)}">
									<div class="cmt-btn-wrapper">
										<span> <a href="question-cmt-edit?no=${c.no}"
											class="btn-a">수정</a> <a href="question-cmt-del?no=${c.no}"
											class="btn-a">삭제</a>
										</span>
									</div>
								</c:if>
							</div>
							<div class="cmt-content-container">${fn:replace(c.content, cn, br)}
							</div>
						</div>
					</c:forEach>
					<div class="cmt-reg">
						<textarea name="cmt"></textarea>
						<input type="submit" name="cmt-btn" value="등록"
							class="btn comment-btn">
					</div>
				</div>
				</main>
			</form>
		</div>
	</div>

	<jsp:include page="../../inc/footer.jsp"></jsp:include>

</body>
</html>