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
    <title>아이디 찾기</title>
    <link rel="stylesheet" type="text/css" href="css/member.css">
    <script type="text/javascript" src="script/member.js"></script>
  </head>

  <body cellpadding="0" cellspacing="0" marginleft="0" margintop="0" width="100%" height="100%" align="center">

	<div class="card align-middle" style="width:25rem;">
		<div class="card-title" style="margin-top:30px;">
			<h2 class="card-title" style="color:#f58b34;"></h2> 
		</div>
        
		<div class="card-body">
      <form name="frm" action="FindIDServlet.do" class="form-signin" method="POST">
  		 <p class="text2"> ${findid2}</p>
        <input type="text" name="name" id="name" class="form-control" placeholder="이름" required autofocus><BR>
        <input type="email" name="email" id="email" class="form-control" placeholder="이메일" required><br>
        	<c:if test="${result==-1}">
				<p>아이디는 <span style="color:red;"><b>${findIDbVo.userid}</b></span> 입니다.</p>
   			</c:if>
   			<c:if test="${result==1}">
				<p>일치하는 정보가 없습니다.</p>
   			</c:if>
   			
        <button id="btn-Yes" class="btn btn-lg btn-primary btn-block" type="submit" onclick="FindIdCheck()">아 이 디 찾 기</button>
      
      </form>
        
		</div>
        <div class="links">
            <a href="FindPassServlet.do">비밀번호 찾기</a> | <a href="LoginServlet.do">로그인</a> | <a href="JoinServlet.do">회원가입</a>

        </div>
	</div>
   
  </body>
  <script type="text/javascript">
		
  		
  
  		$("#name").focusout(function(){
  			
	     if($('#name').val() == ""){
	   		$('#check').text('이름을 입력해주세요.');
	   	  	$('#check').css('color', 'red');
	   
	     }else{
	    	 $('#check').hide();
	     }
	     });
	     
  		$("#email").focusout(function(){
	     if($('#email').val() == ""){
	   		$('#check').text('이메일을 입력해주세요');
	   	  	$('#check').css('color', 'red');
	     }else{
	    	 $('#check').hide();
	     }
	     });
  
  </script>
</html>