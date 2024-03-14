package com.scon.domain;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NreplyVO {
	private Long rno;
	private Long bno;
	private String reply;
	private String replyer;
	private String password;
	private Date rdate;
	private Date updatedate;
	
}
