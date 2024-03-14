package com.scon.controller;


import java.util.List;

import javax.xml.stream.events.Comment;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.scon.domain.Criteria;
import com.scon.domain.NreplyVO;
import com.scon.domain.ReplyPageDTO;
import com.scon.service.NreplyService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@RequestMapping("/replies")
@RestController
@Log4j
@AllArgsConstructor
@ResponseBody

public class NreplyController {
   private NreplyService service;
   
   //////댓글등록///////
   @PostMapping(value="/new", consumes ="application/json", produces = { MediaType.TEXT_PLAIN_VALUE})
   public ResponseEntity<String> create(@RequestBody NreplyVO vo){
      log.info("ReplyVO: " + vo);
      int insertCount = service.register(vo);
      log.info("ReplyVO: " + vo);
      return insertCount ==1 ?
             new ResponseEntity<String>("success~!",HttpStatus.OK)
            :new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR); 
   } 
   
   //////댓글상세보기///////
   @GetMapping(value="/{rno}")
   public ResponseEntity<NreplyVO> get(@PathVariable("rno") Long rno){
      
      return new ResponseEntity<>(service.get(rno), HttpStatus.OK);
   }
   
   
   //////댓글수정///////
   @RequestMapping(method = {RequestMethod.PUT,RequestMethod.PATCH} , value="/{rno}", consumes ="application/json")
   public ResponseEntity<String> modify(@RequestBody NreplyVO vo,@PathVariable("rno") Long rno){
      // 기존 댓글 정보 가져오기
       NreplyVO existingReply = service.get(rno);
       
       // 사용자가 입력한 비밀번호
       String userPassword = vo.getPassword();
       // 기존 댓글의 비밀번호
       String existingPassword = existingReply.getPassword();
       System.out.println("입력한 비밀번호: "+userPassword);
       System.out.println("기존 비밀번호: "+existingPassword);
       System.out.println("rno: "+rno);
       HttpHeaders resHeaders = new HttpHeaders();
       resHeaders.add("Content-Type", "text/plain;charset=UTF-8");
       // 비밀번호 확인
       if(userPassword.equals(existingPassword)) {
           // 비밀번호가 일치할 경우 댓글 수정
           vo.setBno(rno);
           return service.modify(vo)==1
                   ? new ResponseEntity<String>("댓글이 수정되었습니다",resHeaders, HttpStatus.OK)
                   : new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
       } else {
           // 비밀번호가 일치하지 않을 경우 수정 거부
           return new ResponseEntity<String>("비밀번호가 일치하지 않습니다.", resHeaders, HttpStatus.UNAUTHORIZED);
       }
   }
   ///////댓글 삭제/////// 
   @DeleteMapping(value = "/{rno}", produces = MediaType.TEXT_PLAIN_VALUE)
   public ResponseEntity<String> remove(@PathVariable("rno") Long rno , @RequestBody NreplyVO vo) {
       // 사용자가 입력한 비밀번호
       String userPassword = vo.getPassword();
       System.out.println("rno"+rno);
       System.out.println("입력한 비밀번호:"+vo.getPassword());
       // 기존 댓글 정보 가져오기
       NreplyVO existingReply = service.get(rno);
       // 기존 댓글의 비밀번호
       String existingPassword = existingReply.getPassword();
       HttpHeaders resHeaders = new HttpHeaders();
       resHeaders.add("Content-Type", "text/plain;charset=UTF-8");
       // 비밀번호 확인
       if (userPassword.equals(existingPassword)) {
           // 비밀번호가 일치할 경우 댓글 삭제
           return service.remove(rno) == 1
                   ? new ResponseEntity<String>("댓글이 삭제되었습니다.", resHeaders, HttpStatus.OK)
                   : new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
       } else {
           // 비밀번호가 일치하지 않을 경우 삭제 거부
           return new ResponseEntity<String>("비밀번호가 일치하지 않습니다. ", resHeaders, HttpStatus.OK);
       }
   }



   //////댓글 페이징처리///////
   @GetMapping(value = "/pages/{bno}/{page}", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_UTF8_VALUE })
   public ResponseEntity<ReplyPageDTO> getList(@PathVariable("page") int page, @PathVariable("bno") Long bno) {

      Criteria cri = new Criteria(page,10);
      log.info("get Reply List bno: " + bno);
      log.info("cri:" + cri);
      return new ResponseEntity<ReplyPageDTO>(service.getListPage(cri, bno), HttpStatus.OK);
   }

}