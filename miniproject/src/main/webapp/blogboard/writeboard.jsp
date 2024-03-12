<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>홍종효의 코딩 블로그</title>
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
  <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="css/board.css">
</head>

<body>

   <form name="frm" method="post">
      <div align="center" id="titlebox">
      <div class="form-group">
         <input class="form-control box1" type="text" name="title" placeholder="제목을 입력하세요">
      </div>
      
      <div>
      <hr>
      </div>

      <div class="form-group">
        <textarea class="form-control"cols="80" rows="10" id="contentbox" name="content" placeholder="내용을 입력하세요" ></textarea>
      </div>
      
      <div class="btn-wrapper">
         <input type="submit" class="btn btn-md  mr-2" style="background-color: #f58b34; color: white;" value="등록" onclick="return boardCheck()"> 
         <input type="reset" class="btn btn-md  mr-2" style="background-color: #f58b34; color: white;" value="다시 작성"> 
         <input type="button" class="btn btn-md  mr-2" style="background-color: #f58b34; color: white;" value="취소" onclick="location.href='BoardViewServlet.do?num=0'">
      </div>
     
   </form>
</body>
</html>