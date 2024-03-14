<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>뉴스 등록</title>
<!-- Bootstrap core JS-->
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
<!-- Core theme JS-->
<script src="/resources/js/scripts.js"></script>
<link href="/resources/css/styles.css" rel="stylesheet" />
<style>
* {
	padding: 0;
	margin: 0;
	text-decoration: none;
}

.file-wrap {
	display: flex;
	justify-content: flex-end;
	align-items: center
}

 .file-wrap input { 
 	display: none; 
 }

.file-wrap button {
	margin-left: 10px;
	padding: 2px 10px;
}

/*네비게이션 바***********************************/
#contentbox {
	margin: 1rem 0;
}

.btn-wrapper {
	margin-bottom: 1rem
}
</style>
</head>
<body>
	<%@ include file="header.jsp"%>

	<!-- Page content-->
	<div class="container mt-4 text-center">
		<div class="row justify-content-center">
			<div class="col-lg-8">
				<form action="/insert" method="post" enctype="multipart/form-data">
					<!-- Post content-->
					<article>
						<input type="hidden" name="readcount" value="0">
						<!-- Post title-->
						<div class="container">
							<div class="row">
								<!-- 카테고리 -->
								<div class="container">
									<div class="row">
										<!-- 카테고리 선택란 -->
										<div class="col-md-3 mb-3">
											<div class="row">
												<div class="col-md-12">
													<select class="form-select custom-select d-block" id="hint"
														name="ccode" required>
														<option value="" disabled selected>카테고리</option>
														<option value="1">AI</option>
														<option value="2">IT</option>
														<option value="3">우주</option>
														<option value="4">자연</option>
													</select>
												</div>
											</div>
										</div>
										<!-- 제목 입력란 -->
										<div class="col-md-9 mb-3">
											<div class="row">
												<div class="col">
													<div class="input-form-backgroud">
														<div class="input-form">

															<div align="center" id="titlebox">
																<div class="form-group">
																	<input class="form-control box1" type="text"
																		name="title" placeholder="제목을 입력하세요" required>
																</div>
															</div>

														</div>
													</div>
												</div>
											</div>
										</div>
									</div>
								</div>

								<!-- 사진 input 창 -->
								<div class="container">
									<div class="row">
										<div class="col-md-3">
											<div class="input-form-backgroud">
												<div class="input-form">
													<div align="center" id="titlebox">
														<div class="form-group">
															<input class="form-control box1" type="text"
																name="writer" placeholder="기자이름" required>
														</div>
													</div>
												</div>
											</div>
										</div>
										<div class="col-md-9 mb-2">
											<div class="form-group">
												<input class="form-control box1" type="text" name="newlink"
													placeholder="원본 링크" required>
											</div>
										</div>
									</div>
								</div>

								<!-- 파일 업로드 input 필드 -->
								<div class="file-wrap mb-2">
									<input type="file" id="fileInput" name="fileurl" required> 
									<span class="file-name">선택된 파일 없음</span>
									<button type="button" class="file-btn btn btn-primary" onclick="chooseFile()">파일 선택</button>
								</div>

								<script>
									function chooseFile() {
										document.getElementById('fileInput')
												.click();
										// 파일 선택 버튼을 클릭하면 숨겨진 input 요소가 클릭됩니다.
									}

									// 파일이 선택되면 미리보기를 표시하고 파일 이름을 표시합니다.
									document
											.getElementById('fileInput')
											.addEventListener(
													'change',
													function() {
														var file = this.files[0];
														var reader = new FileReader();

														reader.onload = function(
																event) {
															var imagePreview = document
																	.getElementById('imagePreview');
															imagePreview.innerHTML = ''; // 기존 미리보기 제거

															var imgElement = document
																	.createElement('img');
															imgElement.src = event.target.result;
															imgElement.style.maxWidth = '100%';
															imgElement.style.height = 'auto';
															imagePreview
																	.appendChild(imgElement);

															var fileNameSpan = document
																	.querySelector('.file-name');
															fileNameSpan.textContent = file.name; // 선택된 파일명 표시
														};

														reader
																.readAsDataURL(file);
													});
								</script>


								<figure class="text-center mb-4" id="imagePreview">
									<img class="img-fluid rounded"
										src="https://dummyimage.com/900x400/ced4da/6c757d.jpg"
										alt="..." />
								</figure>

								<div class="col">
									<div class="input-form-backgroud">
										<div class="input-form">

											<div align="center" id="titlebox">
												<div class="form-group">
													<input class="form-control box1" type="text"
														name="fileinfo" placeholder="사진 설명란" required>
												</div>
											</div>

										</div>
									</div>
								</div>
							</div>
							<!-- Post content-->
							<div class="form-group" id="contentbox">
								<textarea class="form-control" cols="80" rows="10"
									id="contentbox" name="content" placeholder="내용을 입력하세요" required></textarea>
							</div>


							<!-- Comments section-->

							<div class="btn-wrapper">
								<input type="submit" class="btn btn-md btn-primary  mr-2"
									style="color: white;" value="등록"> <input type="button"
									class="btn btn-md btn-primary  mr-2" style="color: white;"
									value="취소" onclick="location.href='/main'">
							</div>
						</div>


					</article>
				</form>
			</div>
		</div>
	</div>
</body>
</html>