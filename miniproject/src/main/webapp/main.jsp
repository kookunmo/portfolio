<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>홍종효의 코딩 블로그</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css"
	integrity="sha512-DTOQO9RWCH3ppGqcWaEA1BIZOC6xxalwEsw9c2QQeAIftl+Vegovlnee1c9QX4TctnWMn13TZye+giMm8e2LwA=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css"
	integrity="sha512-DTOQO9RWCH3ppGqcWaEA1BIZOC6xxalwEsw9c2QQeAIftl+Vegovlnee1c9QX4TctnWMn13TZye+giMm8e2LwA=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">

<script type="text/javascript" src="script/board.js"></script>
<link rel="stylesheet" type="text/css" href="css/main.css">


</head>
<body>

	<!--<h2 align="right" width="80%">전체보기</h2> -->

	<div id="header">
		<c:choose>
			<c:when test="${loginUser.userid=='hjh'}">
				<input type="hidden" name="userid" value="${loginUser.userid}">
				<div>
					<span>${loginUser.name}님 안녕하세요!</span>
					<a href="UpdateServlet.do?userid=${loginUser.userid}">정보수정</a>
					<a href="LogoutServlet.do">로그아웃 </a>
				</div>
			</c:when>
			<c:otherwise>

				<c:if test="${loginUser.userid!='hjh' && loginUser.userid!=null}">
					<input type="hidden" name="userid" value="${loginUser.userid}">

					<div>
						<span>${loginUser.name}님 안녕하세요!</span>
						<a href="UpdateServlet.do?userid=${loginUser.userid}">정보수정</a>
						<a href="LogoutServlet.do">로그아웃 </a>
					</div>
				</c:if>

				<c:if test="${loginUser.userid==null}">
					<a href="LoginServlet.do">로그인</a>
				</c:if>
			</c:otherwise>
		</c:choose>
	</div>

	<div id="mainBanner">
		<div>Fire Punch 홍종효`s Coding Life</div>
	</div>


	<div class="listBtn" style="margin: 10px auto 10px; width: 100%; max-width:1220px;"   align="right">
		<a id="listp" href="#" onclick="hiddenclick()">목록닫기</a>

	</div>
	<div id="blogtable" style="display: block" class="table">

		<ul class="tableHeader">
			<li>제목</li>
			<li>조회수</li>
			<li>작성일</li>
		</ul>
		<c:forEach var="BlogBoard" items="${BlogBoardList}">
			<ul class="tableSub">
				<li><a href="BoardViewServlet.do?num=${BlogBoard.num}">${BlogBoard.title}</a></li>
				<li>${BlogBoard.readcount}</li>
				<li><fmt:formatDate value="${BlogBoard.writedate}" /></li>
			</ul>
		</c:forEach>
		<!--  paging ------------------------------------------------------------------------------>
		<div class="pasing" align="center">${map.pagingString}</div>
		<!--  paging.end -->
		<!-- command를 숨겨서 넘김 -->
		<!--<input type="hidden" name="command" value="board_list"> -->
		<div class="container mt-3" style="width: 40%; height: 30px;">
			<form method="get">
				<input type="hidden" name="num" value="0">
				<div class="input-group mt-3 mb-3" style="height: 30px;">
					<div class="input-group-prepend">
						<select class="form-control" name="searchField"
							style="height: 30px;">
							<option value="title">제목</option>
							<option value="content">내용</option>
						</select>
					</div>
					<input type="text" class="form-control" placeholder="검색어를 입력하세요"
						name="searchWord">
					<div class="input-group-append">
						<button class="btn btn-outline-secondary" type="submit">검색</button>
					</div>
				</div>
			</form>
		</div>

	</div>

	<br />
	<div id="content">
		<div id="con_header">
			
			<div id="title">${selectboard.title}</div>
			<div class="titleSub">
				<div id="userImg">
					<img src="img/firepunch.jpg" width="27px" height="27px" />
				</div>
				<p id="user">불주먹</p>
				<p id="writeDate">
					<fmt:formatDate value="${selectboard.writedate}" /><span>  조회수 : ${selectboard.readcount}</span>
				</p>
				
				<c:if test="${loginUser.userid=='hjh'}">
					<ul class="con_iud">
						<li><a href="BoardDeleteServlet.do?num=${selectboard.num}"
							onclick="return deleteclick()">글삭제</a></li>
						<li><a href="BoardUpdateServlet.do?num=${selectboard.num}">글수정</a></li>
						<li><a href="BoardWriteServlet.do">글쓰기</a></li>
					</ul>
				</c:if>
			</div>
		</div>
		<pre class="mainSection">${selectboard.content}</pre>
	</div>

	<footer>
		<div class="footCon">
			<ul class="footTerms">
				<li><a href="footer/termsOfUse.jsp" target="_blank">이용약관</a></li>
				<li><a href="footer/privacyPolicy.jsp" target="_blank">개인정보처리방침</a></li>
			</ul>
			<div class="footThx">Thanks. KKM, JDE, HJH, PJH, PSM</div>
			<div class="footThx" align="center">
				<i class="fa-solid fa-circle-up" style="color: #bec2ca;"
					onclick="scrollToTop()"><a href="#" onclick="scrollToTop()"></a></i>
			</div>
		</div>
	</footer>
</body>
</html>