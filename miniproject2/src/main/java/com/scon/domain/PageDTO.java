package com.scon.domain;

import lombok.Data;

@Data
public class PageDTO {
	private Criteria cri;
	private int total;
	
	private int endPage;
	private int startPage;
	private boolean prev,next;
	
	
	public PageDTO(Criteria cri,int total) {
		this.cri = cri;//크리테리아 클래스
	    this.total = total;//전체 글수
	    //끝페이지 . 1,2,3,,,9,10에서 10
	    this.endPage = (int) (Math.ceil(cri.getPageNum() / 10.0)) * 10;
	    //시작페이지 1.2.3.4,,9,10,에서 1
	    this.startPage = this.endPage - 9;
	    //실제 끝페이지
	    int realEnd = (int) (Math.ceil((total * 1.0) / cri.getAmount()));
	    //실제 끝 페이지 보다 작으면
	    if(realEnd<=this.endPage) {
	    	this.endPage= realEnd; //끝페이지르 실제 끝페이지값으로 변경
	    }
	    this.prev = this.startPage > 1;

	    this.next = this.endPage < realEnd;
	}

}
