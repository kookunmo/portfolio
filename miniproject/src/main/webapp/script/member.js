function loginCheck(){
	if(document.frm.userid.value.length==0){
		alert("id를 입력하세요");
		frm.userid.focus();
		return false;
	}
	if(document.frm.pwd.value==""){
		alert("pw를 입력하세요");
		frm.pwd.focus();
		return false;
	}
}

function FindIdCheck(){
	if(document.frm.name.value.length==0){
		alert("이름을 입력하세요.");
		frm.userid.focus();
		return false;
	}
	if(document.frm.email.value==""){
		alert("이메일을 입력하세요");
		frm.pwd.focus();
		return false;
	}
}


function idCheck(){
	if(document.frm.userid.value==""){
		alert('아이디를 입력하여 주십시오.');
		document.formm.userid.focus();
		return;
	}
	var url= "IdCheckServlet.do?userid=" + document.frm.userid.value;
	window.open(url,"_blank_1","resizable=no, width=550, height=400 , top=270, left=600");
}
function idok(userid){
	opener.frm.userid.value=document.frm.userid.value;
	opener.frm.reid.value=document.frm.userid.value;
	self.close();
	
}
function joinCheck(){
	if (document.frm.name.value.length == 0) {
		alert("이름을 써주세요.");
		frm.name.focus();
		return false;
	}
	if (document.frm.userid.value.length == 0) {
		alert("아이디를 써주세요");
		frm.userid.focus();
		return false;
	}
	if (document.frm.userid.value.length < 3) {
		alert("아이디는 3글자이상이어야 합니다.");
		frm.userid.focus();
		return false;
	}
	if (document.frm.pwd.value == "") {
		alert("암호는 반드시 입력해야 합니다.");
		frm.pwd.focus();
		return false;
	}
	if (document.frm.pwd.value != document.frm.pwd_check.value) {
		alert("암호가 일치하지 않습니다.");
		frm.pwd.focus();
		return false;
	}
	if (document.frm.reid.value.length != document.frm.userid.value.length) {
		alert("중복 체크를 해주세요!!!!!!!!!!!!!!!!!!!!!!!");
		frm.userid.focus();
		return false;
	}
	return true;
}

/*질문을 선택 안했으면 리턴폴스를 줘서 알람띄워주고 입력하게 포커스 맞춰주는 펑션입니다*/
function hintcheck(){
	if(document.frm.hint.value==("0")|| document.frm.hint.value==""){
		alert("질문을 선택해주세요");
		frm.hint.focus();
		return false;
	}
	
	return true;
}
	
	
