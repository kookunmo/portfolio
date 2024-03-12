package com.blog.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blog.dao.BlogMemberDAO;
import com.blog.dto.BlogMemberVO;

/**
 * Servlet implementation class JoinServlet
 */
@WebServlet("/JoinServlet.do")
public class JoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JoinServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url ="blogmember/join.jsp";//주소이동 첫째
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);//주소이동 둘째
		dispatcher.forward(request, response);//주소이동 셋쨰
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8"); //한글번역
		BlogMemberVO bVo =new BlogMemberVO(); //정보 넣어줄 빈 브이오
		String name= request.getParameter("name");//jsp에서 가져온 정보 저장해서 쓰려고
		String userid= request.getParameter("userid");//jsp에서 가져온 정보 저장해서 쓰려고
		String nickname= request.getParameter("nickname");//jsp에서 가져온 정보 저장해서 쓰려고
		String pwd= request.getParameter("pwd");//jsp에서 가져온 정보 저장해서 쓰려고
		String phone= request.getParameter("phone");//jsp에서 가져온 정보 저장해서 쓰려고
		String email= request.getParameter("email");//jsp에서 가져온 정보 저장해서 쓰려고
		String hint= request.getParameter("hint");//jsp에서 가져온 정보 저장해서 쓰려고
		String pwanswer= request.getParameter("pwanswer");//jsp에서 가져온 정보 저장해서 쓰려고
		
		//빈 브이오에 다 쎗팅!
		bVo.setName(name);
		bVo.setNickname(nickname);
		bVo.setUserid(userid);
		bVo.setPwd(pwd);
		bVo.setEmail(email);
		bVo.setPhone(phone);
		bVo.setPwanswer(pwanswer);
		bVo.setPwhint(hint);
		System.out.println(bVo.getUserid());//디버깅
		
	
		BlogMemberDAO bDao = BlogMemberDAO.getInstance();//싱글턴패턴 사용해서 dao가져다쓰려고!
		int joinfinish=bDao.insertBlogMember(bVo);//위에 셋팅한 bvo를 db에 멤버테이블에 인설트! 하고나서 성공하면 1가져오고 실패하면 0인가 -1인가 가져옴
		System.out.println(joinfinish);//디버깅용
		request.setAttribute("message", "회원가입완료~!");// 메세지 띄워주기
		request.setAttribute("joinfinish",joinfinish);//정보 바리바리 싸들고 넘어가기
		String url ="blogmember/login.jsp";//경로이동 1
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);//경로이동 2
		dispatcher.forward(request, response);//경로이동 3
		
	
	}

}

