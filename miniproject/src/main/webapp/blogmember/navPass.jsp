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
    <title>비밀번호 변경</title>
    <link rel="stylesheet" type="text/css" href="css/member.css">
  </head>

  <body cellpadding="0" cellspacing="0" marginleft="0" margintop="0" width="100%" height="100%" align="center">
		
		 <%
		 Object data = session.getAttribute("findid");
		 String finduid = (String)data;
  		 %>
  		 
	<div class="card align-middle" style="width:25rem;">
		<div class="card-title" style="margin-top:30px;">
			<h2 class="card-title" style="color:#f58b34;"></h2>
		</div>
        
		<div class="card-body">
      <form action="FindPassServletform.do" class="form-signin" method="POST">
      <input type="hidden" name="member_id" value="${findPassbVo.userid}">
      <p class="check" id="check">내 아이디 : ${findPassbVo.userid} </p><br/>
        <input type="password" name="pw" id="pw" class="form-control" placeholder="비밀번호" required ><BR>
        <input type="password" name="pw2" id="pw2" class="form-control" placeholder="비밀번호 재확인" required><br>
        <p class="check" id="check2">${resetpw_check}</p><br/>
        <button type="submit"  id="btn-Yes" onclick="regist()" class="btn btn-lg btn-primary btn-block">비밀번호 재설정</button>
      </form>
        
		</div>
        <div class="links">
            <a href="memberId">아이디 찾기</a> | <a href="memberLogin">로그인</a> | <a href="memberRegist">회원가입</a>

        </div>
	</div>
  
   		
  </body>
  
  <script >
	
  	var check2 = "${findpw_checkt}";
	if(check2 != ""){
	 	alert(check2);
	}
	
	// 비밀번호 정규식
	var pwJ = /^[a-z0-9]{6,20}$/; 
	var pwc = false;
	var pwc2 = false;
	
	$("#pw").focusout(function(){
	     if($('#pw').val() == ""){
	   		$('#check').text('비밀번호를 입력해주세요.');
	   	  	$('#check').css('color', 'red');
	   	  	
	     }else if(!pwJ.test($(this).val())){
			$('#check').text('6~20자의 영문 소문자, 숫자만 사용가능합니다');
			$('#check').css('color', 'red');
	     }else{
	    	 pwc2 = true;
	    	 $('#check').hide();
	     }
	  });
	
	$("#pw2").focusout(function(){
	     if($('#pw2').val() == ""){
	   		$('#check').text('필수 정보입니다.')
	   	  	$('#check').css('color', 'red')
	 	}else
   	 	$('#check').hide()
	  });
	
	$("#pw2").keyup(function(){
		   
	    if($(this).val()!=$("#pw").val()){
	        $("#check2").html("비밀번호가 다릅니다");
	        $("#check2").css("color",'red');
	        pwc = false;
	
	    }else{
	        $("#check2").html("비밀번호가 일치합니다");
	        $("#check2").css("color",'blue');
	        pwc = true;
	    }
	});
	
	$("#pw").keyup(function(){
		     
	    if($(this).val()!=$("#pw2").val()){
	        $("#check2").html("비밀번호가 다릅니다");
	        $("#check2").css("color",'red');
	        pwc = false;
	
	    }else{
	        $("#check2").html("비밀번호가 일치합니다");
	        $("#check2").css("color",'blue');
	        pwc = true;
	    }
	});

	function regist(){
		if(('#pw2').val() == ('#pw1').val()){
		      alert('비밀번호 변경이 완료되었습니다.')
		      $('form').submit();
		      <%session.invalidate();%>
		 }else if(('#pw2').val() != ('#pw1').val() ){
			  	alert('비번확인이랑 비번이 달라요')
		}
		};
  </script>
</html>