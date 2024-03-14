package com.scon.domain;

import java.util.Date;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class NboardVO {
	private Long bno;
	private String title;
	private String content;
	private String writer;
	private int readcount;
	private int ccode;
	private String fileurl;
	private String fileinfo;
	private String newlink;
	private Date wdate;
	
}
