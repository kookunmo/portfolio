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
    <title>비밀번호 찾기</title>
    <link rel="stylesheet" type="text/css" href="css/member.css">
  </head>
   
  <body cellpadding="0" cellspacing="0" marginleft="0" margintop="0" width="100%" height="100%" align="center">

	<div class="card align-middle" style="width:25rem;">
	<div class="card-title" style="margin-top:30px;">
		<h2 class="card-title" style="color:#f58b34;"></h2>
	</div>
	
	
	
	<div class="card-body">
      	<form action="FindPassServlet.do" class="form-signin" method="POST">
        	<input type="text" name="userid" id="member_id" class="form-control" placeholder="아이디" required><br>
        	
        	<select class="custom-select d-block w-100" id="hint" name="Pwhint">
                <option value="" disabled selected>비밀번호 힌트를 선택해주세요.</option>
                <option value="1">가장 좋아하는 색깔은?</option>
                <option value="2">가장 좋아하는 음식은?</option>
                <option value="3">가장 좋아하는 동물은?</option>
              </select>
              <br>
        	<input type="text" name="Pwanswer" id="hint" class="form-control" placeholder="힌트 값" required><br>
        	<p class="checks" id="checks">${message}</p><br/>
        	<button id="btn-Yes" class="btn btn-lg btn-primary btn-block" type="submit">비밀번호 찾기</button>
     	</form>      
	</div>
        <div class="links">
            <a href="FindIDServlet.do">아이디 찾기</a> | <a href="LoginServlet.do">로그인</a> | <a href="JoinServlet.do">회원가입</a>

        </div>
	</div>
  
  </body>
    <script type="text/javascript">

	
	  	//아이디 정규식
		var idJ = /^[a-z0-9]{5,20}$/;
		
  		$("#member_id").focusout(function(){
	     if($('#member_id').val() == ""){
	   		$('#checks').text('아이디를 입력해주세요.');
	   	  	$('#checks').css('color', 'red');
	     }
	     });
  		
  		$("#member_id").focusout(function(){
  			if(!idJ.test($(this).val())){
  			$('#checks').text('5~20자의 영문 소문자, 숫자만 사용가능합니다');
  			$('#checks').css('color', 'red');
  		}
  		 });
  		
  		$("#name").focusout(function(){
	     if($('#name').val() == ""){
	   		$('#checks').text('이름을 입력해주세요.');
	   	  	$('#checks').css('color', 'red');
	     }
	     });
	     
  		$("#email").focusout(function(){
	     if($('#email').val() == ""){
	   		$('#checks').text('이메일을 입력해주세요');
	   	  	$('#checks').css('color', 'red');
	     }
	     });
  
  </script>
</html>