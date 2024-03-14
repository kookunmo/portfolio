package com.scon.controller;


import java.io.IOException;
import java.net.URI;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.util.UriComponentsBuilder;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.scon.domain.Criteria;
import com.scon.domain.NboardVO;
import com.scon.domain.PageDTO;
import com.scon.service.NboardService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/*")
@AllArgsConstructor
public class NboardController {

	//자동주입
	private NboardService service;

	//목록 GET -- main page
	@GetMapping("/main")
	public void main(Criteria cri, Model model , @RequestParam(value = "ccode", defaultValue = "0") String ccode) {
		log.info("ccode는 : "+ ccode);
		log.info("cri는 : "+ cri);
		if(ccode.equals("0")){
			model.addAttribute("list", service.getList(cri));
		}
		else{model.addAttribute("list", service.getListCategory(cri,ccode));
		}



		model.addAttribute("IT", service.getIT());
		model.addAttribute("AI", service.getAI());
		model.addAttribute("SPACE", service.getSPACE());
		model.addAttribute("NATURE", service.getNATURE());
		model.addAttribute("ccode",ccode);
		int total = service.getTotal(cri); //전체글수
		log.info(cri);
		model.addAttribute("pageMaker", new PageDTO(cri, total));
	}

	////////////////////////////////////////////////////////////////////////////
	//등록 GET
	//등록 GET
	@GetMapping("/insert")
	public void register() {}

	//등록 POST
	@PostMapping("/insert")
	   public String register(RedirectAttributes rttr, HttpServletRequest request) throws ServletException, IOException {
	       request.setCharacterEncoding("UTF-8");
	       System.out.println("아왜안돼");
	       String path = request.getSession().getServletContext().getRealPath("/resources/img");
	       System.out.println(path);
	       String encType = "UTF-8";
	       int sizeLimit = 20 * 1024 * 1024;

	       System.out.println("dkdhodkseho");
	       MultipartRequest multi = new MultipartRequest(request, path, sizeLimit, encType, new DefaultFileRenamePolicy());

	       
	       String title = multi.getParameter("title");
	       String content = multi.getParameter("content");
	       String writer = multi.getParameter("writer");
	       int ccode = Integer.parseInt(multi.getParameter("ccode"));
	       String fileurl = multi.getFilesystemName("fileurl");
	       String fileinfo = multi.getParameter("fileinfo");
	       String newlink = multi.getParameter("newlink");

	       // NboardVO 객체에 값 설정
	       NboardVO board = new NboardVO();
	       
	       board.setTitle(title);
	       System.out.println(title);
	       board.setContent(content);
	       System.out.println(content);
	       board.setWriter(writer);
	       System.out.println(writer);
	       board.setCcode(ccode);
	       System.out.println(ccode);
	       board.setFileurl(fileurl);
	       System.out.println(fileurl);
	       board.setFileinfo(fileinfo);
	       System.out.println(fileinfo);
	       board.setNewlink(newlink);
	       System.out.println(newlink);

	       service.register(board);
	       return "redirect:/main";
	   }

	////////////////////////////////////////////////////////////////////////////


	//상세보기 GET  
	@GetMapping({"/get"})
	public void get(@RequestParam("bno") Long bno, @RequestParam(value = "ccode", defaultValue = "0") String ccode,@ModelAttribute("cri") Criteria cri , Model model ) {
		service.updateReadCount(bno);
		model.addAttribute("board", service.get(bno)); // 특정 게시글을 모델에 추가

		model.addAttribute("IT", service.getIT());
		model.addAttribute("AI", service.getAI());
		model.addAttribute("SPACE", service.getSPACE());
		model.addAttribute("NATURE", service.getNATURE());
		model.addAttribute("ccode",ccode);


	}

	// 수정 GET
	@GetMapping({"/modify"})
	public void modify(@RequestParam("bno") Long bno, @ModelAttribute("cri") Criteria cri , Model model ) { 
		model.addAttribute("board", service.get(bno));
	}

	// 수정 POST
	@PostMapping("/modify")
	public String modify(RedirectAttributes rttr,HttpServletRequest request) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
	       System.out.println("아왜안돼");
	       String path = request.getSession().getServletContext().getRealPath("/resources/img");
	       System.out.println(path);
	       String encType = "UTF-8";
	       int sizeLimit = 20 * 1024 * 1024;

	       System.out.println("dkdhodkseho");
	       MultipartRequest multi = new MultipartRequest(request, path, sizeLimit, encType, new DefaultFileRenamePolicy());

	       long bno =Long.parseLong(multi.getParameter("bno"));
	       String title = multi.getParameter("title");
	       String content = multi.getParameter("content");
	       String writer = multi.getParameter("writer");
	       int ccode = Integer.parseInt(multi.getParameter("ccode"));
	       String fileurl = multi.getFilesystemName("fileurl");
	       String fileinfo = multi.getParameter("fileinfo");
	       String newlink = multi.getParameter("newlink");

	       // NboardVO 객체에 값 설정
	       NboardVO board = new NboardVO();
	       
	       board.setTitle(title);
	       System.out.println(title);
	       board.setContent(content);
	       System.out.println(content);
	       board.setWriter(writer);
	       System.out.println(writer);
	       board.setCcode(ccode);
	       System.out.println(ccode);
	       board.setFileurl(fileurl);
	       System.out.println(fileurl);
	       board.setFileinfo(fileinfo);
	       System.out.println(fileinfo);
	       board.setNewlink(newlink);
	       System.out.println(newlink);
	       board.setBno(bno);
	       
	       if(service.modify(board)) { //수정처리가 되었으면
				rttr.addFlashAttribute("result", "수정완료");
			}
		
		return "redirect:/get?bno=" + board.getBno();
	}

	// 삭제 POST
	@GetMapping("/remove")
	public String remove(@RequestParam("bno") Long bno,  RedirectAttributes rttr) {
		if(service.remove(bno)) { //삭제처리가 되었으면
			rttr.addFlashAttribute("result", "삭제완료");
		}
		return "redirect:/main";
	}

	@PostMapping("/naver") // POST 요청을 처리하는 엔드포인트로 변경
	public ResponseEntity<String> naver(@RequestParam("keyword") String keyword) { // 클라이언트로부터 키워드를 받아오도록 변경
	    String clientId = "dHwdDPbb9iAjG9saNc6x";
	    String clientSecret = "qJxymTizDi";
	    URI uri = UriComponentsBuilder.fromUriString("https://openapi.naver.com/")
	            .path("v1/search/local.json")
	            .queryParam("query", keyword) // 클라이언트로부터 받은 키워드를 사용합니다.
	            .queryParam("display", 10)
	            .queryParam("start", 1)
	            .queryParam("sort", "random")
	            .build(true) // URI를 인코딩합니다.
	            .toUri();

	    HttpHeaders headers = new HttpHeaders();
	    headers.set("X-Naver-Client-Id", clientId);
	    headers.set("X-Naver-Client-Secret", clientSecret);

	    HttpEntity<Void> req = new HttpEntity<>(headers);

	    RestTemplate restTemplate = new RestTemplate();
	    ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, req, String.class);

	    return result;
	}

	// 관리자 페이지로 이동하는 메서드
			@PostMapping("/admin")
			public String adminPage(@RequestParam("password") String password, RedirectAttributes rttr) {
			    // 비밀번호 확인
			    if (service.checkPassword(password)) {
			        // 비밀번호가 일치하면 관리자 페이지로 이동
			        return "redirect:/insert";
			    } else{
			        // 비밀번호가 일치하지 않으면 오류 메시지 전달 후 페이지 반환
			    	rttr.addFlashAttribute("adminx", "x");
			        log.info(rttr);
			    	return "redirect:/main"; // 여기에 해당하는 메인 페이지로 이동
			    }
			    
			}
			
			
			@PostMapping("/admin1")
			public String adminPage1(@RequestParam("password") String password,@RequestParam("bno") Long bno, RedirectAttributes rttr) {
			    // 비밀번호 확인
			    if (service.checkPassword(password)) {
			        // 비밀번호가 일치하면 관리자 페이지로 이동
			    	return "redirect:/insert";
			    } else{
			        // 비밀번호가 일치하지 않으면 오류 메시지 전달 후 페이지 반환
			    	rttr.addFlashAttribute("adminx", "x");
			        log.info(rttr);
			    	return "redirect:/get?bno=" + bno; 
			    }
			    
			}
			
			@PostMapping("/admin2")
			public String adminPage2(@RequestParam("password") String password,@RequestParam("bno") Long bno, RedirectAttributes rttr) {
			    // 비밀번호 확인
			    if (service.checkPassword(password)) {
			        // 비밀번호가 일치하면 관리자 페이지로 이동
			    	return "redirect:/modify?bno=" + bno;
			    } else{
			        // 비밀번호가 일치하지 않으면 오류 메시지 전달 후 페이지 반환
			    	rttr.addFlashAttribute("adminx", "x");
			        log.info(rttr);
			    	return "redirect:/get?bno=" + bno; 
			    }
			    
			}
			
			@PostMapping("/admin3")
			public String adminPage3(@RequestParam("password") String password,@RequestParam("bno") Long bno, RedirectAttributes rttr) {
			    // 비밀번호 확인
			    if (service.checkPassword(password)) {
			        // 비밀번호가 일치하면 관리자 페이지로 이동
			        return "redirect:/remove?bno=" + bno;
			    } else{
			        // 비밀번호가 일치하지 않으면 오류 메시지 전달 후 페이지 반환
			    	rttr.addFlashAttribute("adminx", "x");
			        log.info(rttr);
			    	return "redirect:/get?bno=" + bno; 
			    }
			    
			}

}