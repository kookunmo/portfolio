package com.scon.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.scon.domain.Criteria;
import com.scon.domain.NreplyVO;

public interface NreplyMapper {

	
	//등록
	public int insert (NreplyVO vo);
	
	//상세보기
	public NreplyVO read(Long rno);
	
	//삭제
	public int delete(Long rno);
	
	//수정
	public int update(NreplyVO vo);
	
	//목록 with paging . parameter 가 2개이상이면 param을 붙어줘야함
	public List<NreplyVO> getListWithPaging(@Param("cri") Criteria cri, @Param("bno") Long bno);
	
	//댓글갯수
	public int getCountByBno(Long bno);
	
}
