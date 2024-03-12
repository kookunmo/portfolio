<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">

<head>
	  <meta charset="UTF-8">
	  <meta http-equiv="X-UA-Compatible" content="IE=edge">
	  <meta name="viewport" content="width=device-width, initial-scale=1.0">
	  <title>회원가입 폼</title>
	
	  <!-- Bootstrap CSS -->
	 <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	<script type="text/javascript" src="script/member.js"></script>
  	<link rel="stylesheet" type="text/css" href="css/join.css">
</head>

<body>
  <div class="container">
    <div class="input-form-backgroud row">
      <div class="input-form col-md-12 mx-auto">
        <h4 class="mb-3" style="color: #f58b34;">회원가입</h4>
        <form method="post" class="validation-form" name="frm" novalidate>
                    <div class="mb-3">
            <label for="name">이름</label>
            <input type="text" class="form-control" name="name" id="name" placeholder="이름을 입력해주세요" required>
            <div class="invalid-feedback">
              이름을 입력해주세요.
            </div>
          </div>

          <div class="mb-3">
            <label for="nickname">닉네임</label>
            <input type="text" class="form-control" name="nickname" id="nickname" placeholder="닉네임을 입력해주세요" required>
            <div class="invalid-feedback">
              닉네임을 입력해주세요.
            </div>
          </div>
          
             <div class="mb-3">
            <label for="phone">전화번호</label>
            <input type="text" class="form-control" name="phone" id="phone" placeholder="전화번호를 입력해주세요" required>
            <div class="invalid-feedback">
              전화번호를 입력해주세요.
            </div>
          </div>
          
            <div class="mb-3">
            <label for="email">이메일</label>
            <input type="email" class="form-control"  name="email" id="email" placeholder="you@example.com" required>
            <div class="invalid-feedback">
              이메일을 입력해주세요.
            </div>
          </div>
        
      <div class="row">
           <div class="col-md-12 mb-3">
             <label for="usedid">아이디</label>
             <div class="input-group">
          <input type="text" class="form-control" name="userid" id="userid" placeholder="아이디를 입력해주세요" required>
          <input type="hidden" name="reid" size="20">
          <div class="invalid-feedback">
            아이디를 입력해주세요.
          </div>
           <div class="input-group-append">
        <button class="btn btn-outline-secondary" type="button" onclick="idCheck()">중복확인</button>
      </div>
    </div>
        </div>
            
           <div class="col-md-12 mb-3">
              <label for="pwd">비밀번호</label>
              <input type="text" class="form-control" name="pwd" id="pwd" placeholder="비밀번호를 입력해주세요." value="" required>
              <div class="invalid-feedback">
                비밀번호를 입력해주세요.
              </div>
            </div>
          </div>

          <div class="row">
           <div class="col-md-12 mb-3">
              <label for="hint">비밀번호 힌트</label>
              <select class="custom-select d-block w-100" id="hint" name="hint">
                <option value=""disabled selected>비밀번호 힌트를 선택해주세요.</option>
                <option value="1">가장 좋아하는 색깔은?</option>
                <option value="2">가장 좋아하는 음식은?</option>
                <option value="3">가장 좋아하는 동물은?</option>
              </select>
              <div class="invalid-feedback">
                비밀번호 힌트를 선택해주세요.
              </div>
            </div>
            
              <div class="col-md-12 mb-3">
              <label for="pwd_answer">비밀번호 답</label>
              <input type="text" class="form-control" name="pwanswer" id="pwd_answer" placeholder="힌트 정답을 입력해주세요"value="" required>
              <div class="invalid-feedback">
                힌트 정답을 입력해주세요.
              </div>
            </div>
          </div>

          <hr class="mb-4">
          <div class="custom-control custom-checkbox">
            <input type="checkbox" class="custom-control-input" id="provision" required>
            <label class="custom-control-label" for="provision">블로그 이용약관에 동의합니다.</label>
          </div>
          <textarea rows="10" rows="40" class="w-100" placeholder="제1장 총칙
제1조 (목적)
이 약관은 전기통신사업법령 및 정보통신망이용촉진 및 정보보호 등에 관한 법률에 따라 한겨레신문㈜ 및 관계사{씨네21 ㈜(이상, 자회사) ㈜한겨레플러스(이상, 제휴사)} (이하 `회사`)에서 제공하는 모든 서비스(이하 `서비스`)의 이용절차,조건등 서비스 이용과 관련한 회사와 회원의 권리 및 의무에 관련된 사항을 규정함을 목적으로 합니다.

제2조 (약관의 효력과 변경)
1.본 약관은 회원이 `내 블로그 만들기` 절차에 따라 블로그 개설시 약관에 동의합니까 라는 물음에 회원이 동의 버튼을 클릭하는 것으로 효력이 발생됩니다.
2.회사는 필요한 경우 약관을 변경할 수 있으며, 변경된 약관은 적용일 전 7일간 온라인 상의 공지나 전자 우편 등의 방법을 통해 회원에게 공지되고 적용일에 효력이 발생됩니다.
3.회원은 변경된 약관에 동의하지 않을 경우, 블로그 또는 팀블로그를 폐쇄하고 본 서비스이용을 중단할 수 있습니다.
4.약관이 변경된 이후에도 계속적으로 서비스를 이용하는 경우에는 회원이 약관의 변경 사항에 동의한 것으로 봅니다.
제3조 (약관 외 준칙)
이 약관에 명시되지 않은 사항이 전기통신기본법, 전기통신사업법, 기타 관계법령에 규정 되어 있을 경우에는 그 규정에 따릅니다.

제4조 (용어의 정의)
1.'블로그’라 함은 회원 개인이 글이나 그림 등을 올릴 수 있는 공간입니다.
2.`팀블로그`라 함은 서비스에서 회원이 만든 특정한 팀블로그를 말합니다.
3.`팀블로그 회원`이라 함은 블로그를 개설한 후 특정 팀블로그에 가입되어 팀블로그를 이용하는 회원을 말합니다.
4.`팀지기`라 함은 서비스에서 팀블로그를 개설하거나 전임 팀지기로부터 권한을 위임 받은 자로서 개설한 팀블로그의 운영 전반에 책임을 지는 팀블로그를 대표하는 회원을말합니다.
5.`버금지기`이라 함은 서비스에서 팀지기가 선정한 팀블로그 운영자를 말합니다."></textarea>
          
            <hr class="mb-4">
          <div class="custom-control custom-checkbox">
            <input type="checkbox" class="custom-control-input" id="Personal information" required>
            <label class="custom-control-label" for="Personal information">개인정보 수집 및 이용에 동의합니다.</label>
          </div>
          <textarea rows="10" rows="40" class="w-100" placeholder="개인정보보호법에 따라 회원가입 신청하시는 분께 수집하는 개인정보의 항목, 개인정보의 수집 및 이용목적, 개인정보의 보유 및 이용기간, 동의 거부권 및 동의 거부 시 불이익에 관한 사항을 안내 드리오니 자세히 읽은 후 동의하여 주시기 바랍니다.
1. 수집하는 개인정보
이용자는 회원가입을 하지 않아도 정보 검색, 뉴스 보기 등 대부분의 네이버 서비스를 회원과 동일하게 이용할 수 있습니다. 이용자가 메일, 캘린더, 카페, 블로그 등과 같이 개인화 혹은 회원제 서비스를 이용하기 위해 회원가입을 할 경우, 네이버는 서비스 이용을 위해 필요한 최소한의 개인정보를 수집합니다.

회원가입 시점에 이용자로부터 수집하는 개인정보는 아래와 같습니다.
- 회원 가입 시 필수항목으로 아이디, 비밀번호, 이름, 생년월일, 성별, 휴대전화번호를, 선택항목으로 이메일주소를 수집합니다. 실명 인증된 아이디로 가입 시, 암호화된 동일인 식별정보(CI), 중복가입 확인정보(DI), 내외국인 정보를 함께 수집합니다. 만 14세 미만 아동의 경우, 법정대리인 정보(법정대리인의 이름, 생년월일, 성별, 중복가입확인정보(DI), 휴대전화번호)를 추가로 수집합니다.
- 비밀번호 없이 회원 가입 시에는 필수항목으로 아이디, 이름, 생년월일, 휴대전화번호를, 선택항목으로 비밀번호를 수집합니다.
- 단체 회원가입 시 필수 항목으로 단체아이디, 비밀번호, 단체이름, 이메일주소, 휴대전화번호를, 선택항목으로 단체 대표자명을 수집합니다.
서비스 이용 과정에서 이용자로부터 수집하는 개인정보는 아래와 같습니다.
- 회원정보 또는 개별 서비스에서 프로필 정보(별명, 프로필 사진)를 설정할 수 있습니다. 회원정보에 별명을 입력하지 않은 경우에는 마스킹 처리된 아이디가 별명으로 자동 입력됩니다.
- 개별 서비스 이용, 이벤트 응모 및 경품 신청 과정에서 해당 서비스의 이용자에 한해 추가 개인정보 수집이 발생할 수 있습니다. 추가로 개인정보를 수집할 경우에는 해당 개인정보 수집 시점에서 이용자에게 ‘수집하는 개인정보 항목, 개인정보의 수집 및 이용목적, 개인정보의 보관기간’에 대해 안내 드리고 동의를 받습니다.



서비스 이용 과정에서 IP 주소, 쿠키, 서비스 이용 기록, 기기정보, 위치정보가 생성되어 수집될 수 있습니다. 또한 이미지 및 음성을 이용한 검색 서비스 등에서 이미지나 음성이 수집될 수 있습니다.
구체적으로 1) 서비스 이용 과정에서 이용자에 관한 정보를 자동화된 방법으로 생성하여 이를 저장(수집)하거나, 2) 이용자 기기의 고유한 정보를 원래의 값을 확인하지 못 하도록 안전하게 변환하여 수집합니다.
서비스 이용 과정에서 위치정보가 수집될 수 있으며,
네이버에서 제공하는 위치기반 서비스에 대해서는 '네이버 위치기반서비스 이용약관'에서 자세하게 규정하고 있습니다.
이와 같이 수집된 정보는 개인정보와의 연계 여부 등에 따라 개인정보에 해당할 수 있고, 개인정보에 해당하지 않을 수도 있습니다.
생성정보 수집에 대한 추가 설명
- IP(Internet Protocol) 주소란?
IP 주소는 인터넷 망 사업자가 인터넷에 접속하는 이용자의 PC 등 기기에 부여하는 온라인 주소정보 입니다. IP 주소가 개인정보에 해당하는지 여부에 대해서는 각국마다 매우 다양한 견해가 있습니다.
- 서비스 이용기록이란?
네이버 접속 일시, 이용한 서비스 목록 및 서비스 이용 과정에서 발생하는 정상 또는 비정상 로그 일체,메일 수발신 과정에서 기록되는 이메일주소, 친구 초대하기 또는 선물하기 등에서 입력하는 휴대전화번호, 스마트스토어 판매자와 구매자간 상담내역(네이버톡톡 및 상품 Q&A 게시글) 등을 의미합니다.
- 기기정보란?
본 개인정보처리방침에 기재된 기기정보는 생산 및 판매 과정에서 기기에 부여된 정보뿐 아니라, 기기의 구동을 위해 사용되는 S/W를 통해 확인 가능한 정보를 모두 일컫습니다. OS(Windows, MAC OS 등) 설치 과정에서 이용자가 PC에 부여하는 컴퓨터의 이름, PC에 장착된 주변기기의 일련번호, 스마트폰의 통신에 필요한 고유한 식별값(IMEI, IMSI), AAID 혹은 IDFA, 설정언어 및 설정 표준시, USIM의 통신사 코드 등을 의미합니다. 단, 네이버는 IMEI와 같은 기기의 고유한 식별값을 수집할 필요가 있는 경우, 이를 수집하기 전에 네이버도 원래의 값을 알아볼 수 없는 방식으로 암호화 하여 식별성(Identifiability)을 제거한 후에 수집합니다.
- 쿠키(cookie)란?
쿠키는 이용자가 웹사이트를 접속할 때에 해당 웹사이트에서 이용자의 웹브라우저를 통해 이용자의 PC에 저장하는 매우 작은 크기의 텍스트 파일입니다. 이후 이용자가 다시 웹사이트를 방문할 경우 웹사이트 서버는 이용자 PC에 저장된 쿠키의 내용을 읽어 이용자가 설정한 서비스 이용 환경을 유지하여 편리한 인터넷 서비스 이용을 가능케 합니다. 또한 방문한 서비스 정보, 서비스 접속 시간 및 빈도, 서비스 이용 과정에서 생성된 또는 제공(입력)한 정보 등을 분석하여 이용자의 취향과 관심에 특화된 서비스(광고 포함)를 제공할 수 있습니다. 이용자는 쿠키에 대한 선택권을 가지고 있으며, 웹브라우저에서 옵션을 설정함으로써 모든 쿠키를 허용하거나, 쿠키가 저장될 때마다 확인을 거치거나, 아니면 모든 쿠키의 저장을 거부할 수도 있습니다. 다만, 쿠키의 저장을 거부할 경우에는 로그인이 필요한 네이버 일부 서비스의 이용에 불편이 있을 수 있습니다.
쿠키에 관한 자세한 내용(네이버 프라이버시 센터) 알아보기"></textarea>
          
          <div class="mb-4"></div>
          <button class="btn btn-lg btn-block" type="submit" style="background-color: #f58b34; color: white;">가입 완료</button>
        </form>
      </div>
    </div>
    <footer class="my-3 text-center text-small">
      <p class="mb-1">&copy; 2024</p>
    </footer>
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

          </div>

   </div>
   
   </form>
   </body>
</html>