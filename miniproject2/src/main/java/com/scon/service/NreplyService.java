package com.scon.service;

import java.util.List;

import com.scon.domain.Criteria;
import com.scon.domain.NreplyVO;
import com.scon.domain.ReplyPageDTO;

public interface NreplyService {

	public int register(NreplyVO vo);

	public NreplyVO get(Long rno);

	public int modify(NreplyVO vo);

	public int remove(Long rno);

	public List<NreplyVO> getList(Criteria cri, Long bno);
	
	public ReplyPageDTO getListPage(Criteria cri, Long bno);

}
