package com.scon.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.scon.domain.Criteria;
import com.scon.domain.NreplyVO;
import com.scon.domain.ReplyPageDTO;
import com.scon.mapper.NreplyMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Service
@Log4j
@AllArgsConstructor
public class NreplyServiceImpl implements NreplyService{

	private NreplyMapper mapper;

	@Override
	public int register(NreplyVO vo) {
		log.info("register..........");
		return mapper.insert(vo);
	}

	@Override
	public NreplyVO get(Long rno) {

		return mapper.read(rno);
	}

	@Override
	public int modify(NreplyVO vo) {
		// TODO Auto-generated method stub
		return mapper.update(vo);
	}

	@Override
	public int remove(Long rno) {
		// TODO Auto-generated method stub
		return mapper.delete(rno);
	}

	@Override
	public List<NreplyVO> getList(Criteria cri, Long bno) {
		// TODO Auto-generated method stub
		return mapper.getListWithPaging(cri, bno);
	}

	@Override
	public ReplyPageDTO getListPage(Criteria cri, Long bno) {

		return new ReplyPageDTO(
				mapper.getCountByBno(bno),
				mapper.getListWithPaging(cri, bno)
				);
	}


}
