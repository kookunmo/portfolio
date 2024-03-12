<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>I아이디 중복확인</title>
 <!-- Latest compiled and minified CSS -->
   <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
   <!-- jQuery library -->
   <script src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.slim.min.js"></script>
   <!-- Popper JS -->
   <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
   <!-- Latest compiled JavaScript -->
   <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
<script type="text/javascript" src="script/member.js"></script>
<style>
    body {
      min-height: 100vh;
      background: #ffffff;
    }

    .input-form {
      max-width: 480px;
      margin-top: 80px;
      padding: 24px;
      background: #fff;
      border-radius: 10px;
      box-shadow: 0 8px 20px 0 rgba(0, 0, 0, 0.15);
    }
     
  </style>
</head>

<body>
  <div class="container">
    <div class="input-form-backgroud row">
      <div class="input-form col-md-12 mx-auto">
        <h4 class="mb-3" style="color: #f58b34;">아이디 중복확인</h4>
        
        <form action="IdCheckServlet.do" class="validation-form" novalidate method="get" name="frm">
       <div class="input-group">
       <input type="text" class="form-control" name="userid" id="userid" value="${userid}" required>
      <div class="input-group-append">
        <button class="btn btn-outline-secondary" type="submit">중복확인</button>
      </div>
      </div>
      
      <div style="color: #f58b34;">   
      <c:if test="${result == 1}">
         <script type="text/javascript">
            opener.document.frm.userid.value = "";
         </script>
         <br/>
         ${userid}는 이미 사용 중인 아이디입니다.
      </c:if>
      <c:if test="${result==-1}"><br/>
        ${userid}는 사용 가능한 아이디입니다. <input type="button" value="사용" class="btn btn-outline-secondary" onclick="idok('${userid}')">
      </c:if>
      </div>
   </form>
   </div>
   </div>
  </div>
</body>
</html>