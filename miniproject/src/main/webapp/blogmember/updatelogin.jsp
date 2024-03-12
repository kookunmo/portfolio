<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>회원정보 폼</title>

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
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
				<h4 class="mb-3" style="color: #f58b34;">회원정보</h4>
				<form name="frm" class="validation-form" novalidate
					action="UpdateServlet.do" method="post">
					<div class="mb-3">
						<label for="name">이름</label> <input type="text"
							class="form-control" name="name" id="name" value="${mVo.name}"
							required>
					</div>

					<div class="row">
						<div class="col-md-12 mb-3">
							<label for="userid">아이디</label>
							<div class="input-group">
								<input type="text" class="form-control" name="userid"
									id="userid" value="${mVo.userid}" readonly required>
							</div>
						</div>

						<div class="col-md-12 mb-3">
							<label for="pwd">비밀번호</label> <input type="text"
								class="form-control" name="pwd" id="pwd" value="" required>
						</div>

						<div class="col-md-12 mb-3">
							<label for="pwdanswer">비밀번호 확인</label> <input type="text"
								class="form-control" name="xx" id="pwdanswer" value="" required>
						</div>
						<div class="col-md-12 mb-3">
							<label for="hint">비밀번호 힌트</label> <select
								class="custom-select d-block w-100" id="hint" name="pwhint">
								<option value="0" disabled selected>비밀번호 힌트를 선택해주세요.</option>
								<option value="1">가장 좋아하는 색깔은?</option>
								<option value="2">가장 좋아하는 음식은?</option>
								<option value="3">가장 좋아하는 동물은?</option>
							</select>
							<div class="invalid-feedback">비밀번호 힌트를 선택해주세요.</div>
						</div>

						<div class="col-md-12 mb-3">
							<label for="pwd_answer">비밀번호 답</label> <input type="text"
								class="form-control" name="pwanswer" id="pwd_answer"
								value="${mVo.pwanswer}" required>
							<div class="invalid-feedback">힌트 정답을 입력해주세요.</div>
						</div>


						<div class="col-md-12 mb-3">
							<label for="nickname">닉네임</label> <input type="text"
								class="form-control" name="nickname" id="nickname"
								value="${mVo.nickname}" required>
						</div>

						<div class="col-md-12 mb-3">
							<label for="phone">전화번호</label> <input type="text"
								class="form-control" name="phone" id="phone"
								value="${mVo.phone}" required>
						</div>

						<div class="col-md-12 mb-3">
							<label for="email">이메일</label> <input type="email"
								class="form-control" name="email" id="email"
								value="${mVo.email}" required>
						</div>
					</div>

					<div class="mb-4">

						<!-- 수정 완료 버튼 -->
						
						
						<button class="btn btn-md flex-fill mr-2" type="submit"
							style="background-color: #f58b34; color: white;"
							onclick="return hintcheck()">수정 완료</button>

						<!-- 취소 버튼 -->
						<button class="btn btn-md flex-fill" type="button"
							onclick="location.href='BoardViewServlet.do?num=0'"
							style="background-color: #f58b34; color: white;">취소</button>
					</div>
				</form>

			</div>
		</div>
	</div>

	<div class="mb-4">
		<footer class="my-3 text-center text-small">
			<p class="mb-1">&copy; 2024</p>
		</footer>
	</div>
	</div>

	<script>
    window.addEventListener('load', () => {
      const forms = document.getElementsByClassName('validation-form');

      Array.prototype.filter.call(forms, (form) => {
        form.addEventListener('submit', function (event) {
          if (form.checkValidity() === false) {
            event.preventDefault();
            event.stopPropagation();
          }

          form.classList.add('was-validated');
        }, false);
      });
    }, false);
  </script>
</body>
</html>