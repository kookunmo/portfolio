<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>

<!DOCTYPE html>
<html>
  <head>
  	<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <title>로그인 폼</title>
    <link rel="stylesheet" type="text/css" href="css/member.css">
    
  </head>
	
  <body cellpadding="0" cellspacing="0" marginleft="0" margintop="0" width="100%" height="100%" align="center">

	<div class="card align-middle" style="width:25rem;">
		<div class="card-title" style="margin-top:30px;">
			<h2 class="card-title" style="color:#f58b34;"></h2>
		</div>
      <form action="LoginServlet.do" class="login" method="post">
		
		
		
		<div class="card-body">
        	<input value="${userid}" type="text" name="userid" id="Id" class="form-control" placeholder="아이디" autofocus required><BR>
        	<input type="password" name="pwd" id="Pw" class="form-control" placeholder="비밀번호"  required><br>
         	<p id="check" class="check">${login_msg}</p><br/>
        	<input id="btn-Yes" class="btn btn-lg btn-primary btn-block" type="submit" value="로 그 인">
        	${message}
        	
        	<c:if test="${joinfinish == 1}">
    		<script>
       			 alert("회원가입이 완료되었습니다.");
    		</script>
			</c:if>
			
			<c:if test="${joinfinish == -1}">
    		<script>
       			 alert("회원가입이 실패함.");
    		</script>
			</c:if>
      	</div>
      </form>
        <div class="links">
            <a href="FindIDServlet.do">아이디 찾기</a> | <a href="FindPassServlet.do">비밀번호 찾기</a> | <a href="JoinServlet.do">회원가입</a>
	
        </div>
	</div>
   
   
  </body>
</html>



