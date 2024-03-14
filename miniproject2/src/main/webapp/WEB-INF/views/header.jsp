<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <!-- Bootstrap core JS-->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
    <!-- Core theme JS-->
    <script src="/resources/js/scripts.js"></script>
    <link href="/resources/css/styles.css" rel="stylesheet" />
    <style>
        * {
            padding: 0;
            margin: 0;
            text-decoration: none;
        }

        /*헤더부분***********************************/
        #header {
            display: flex;
            justify-content:space-between;
            align-items:center;
            width: 100%;
            height: 160px;
            background: #212529;
            position: relative;
            padding:0 20px;
        }

        .logo {
            height: 80%;
        }

        .mypage {
           
            width: 50%;
            height: 100%;
            background: #212529;
        }

        /*헤더부분***********************************/
        #nav {
            display: block;
            width: 100%;
            height: 50px;
            background-color: blue;
            position: relative;
        }

        /*네비게이션 바***********************************/
 #contentbox{margin:1rem 0;} 
 .btn-wrapper{margin-bottom:1rem}
    </style>
</head>
<body>
<div id="header" class="text-center"><!--전체 감싸기-->
    <div class="logo">로고</div>
    <div class="logo2">
        <a href="/main">
            <img src="/resources/img/로고 copy.png" alt="로고 위치">
        </a>
    </div>
    

</div>
<!-- Responsive navbar-->
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container">
        <button class="navbar-toggler ml-auto" type="button" data-bs-toggle="collapse"
                data-bs-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        
    </div>
</nav>
</body>
</html>