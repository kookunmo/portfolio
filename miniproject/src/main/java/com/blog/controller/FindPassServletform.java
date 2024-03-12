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
 * Servlet implementation class FindPassServletform
 */
@WebServlet("/FindPassServletform.do")
public class FindPassServletform extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FindPassServletform() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url ="blogmember/login.jsp";//이동첫째
		String pw= request.getParameter("pw");//jsp에서 가져온 정보 저장해서 쓰려고
		String member_id=request.getParameter("member_id");//jsp에서 가져온 정보 저장해서 쓰려고
		BlogMemberDAO bDao= BlogMemberDAO.getInstance();//dao싱글턴패턴이라 쓰려고 !
		
		BlogMemberVO bVo = bDao.getBlogMember(member_id);//getBlogMember라는 매서드 사용해서 비번이랑 업뎃멤버
		bVo.setPwd(pw);//bVo여기에 비번만 바꿔줌!
		bDao.updateMember(bVo);//바뀐 비번 업데이트 멤버 이용해서 비번 변경!
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);//이동둘쨰
		dispatcher.forward(request, response);//이동셋쨰
	}

}
