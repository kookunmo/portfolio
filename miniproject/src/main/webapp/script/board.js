////////////////////////////////////
////////////////////////////////////
function boardCheck(){
	if(document.frm.name.value.length ==0){
		alert("작성자 입력안ㄴ함");
		document.frm.name.focus();
		return false;
	}
	if(document.frm.pass.value.length ==0){
		alert("비번 입력안ㄴ함")
		document.frm.pass.focus();
		return false;
	}
	if(document.frm.title.value ==""){
		alert("제목 입력안ㄴ함")
		document.frm.title.focus();
		return false;
	}
	if(document.frm.content.value ==""){
		alert("내용 입력안ㄴ함")
		document.frm.content.focus();
		return false;
	}
}
////////////////////////////////////
///////////////////////////////////
function open_win(url, name) {
	window.open(url, name, "width=500px, height=230px");
}
////////////////////////////////////
////////////////////////////////////
function deleteclick() {
	var isConfirmed = confirm("확인하시겠습니까?");
	if(isConfirmed){
		 return true;
	}else{
		 return false;
	}
}
/*이건 히든클릭으로 목록 여닫기할 떄 쓰는 펑션인데 목록자체를 하나의 div안에 넣고 
그 div의 display형태를 block,none 으로 와리가리 하게하는 펑션 */
function hiddenclick() {
 	 var blogtable = document.getElementById("blogtable");
	var listp = document.getElementById("listp");
  // 히든 타입을 변경
   if (blogtable.style.display === "none") {
    blogtable.style.display = "block";
    listp.textContent  ="목록닫기";
  } else {
    blogtable.style.display = "none";
    listp.textContent ="목록열기";
  }
}

/*메인페이지 맨 밑에 버튼누르면 위로올라가는건데 윈도우의 스크롤을 top 0 으로 조정한다는 뜻*/
function scrollToTop() {
  // 페이지의 맨 위로 스크롤
  window.scrollTo({
    top: 0,
    behavior: 'smooth'
  });
}
