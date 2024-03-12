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
 * Servlet implementation class MemberFindIDServlet
 */
@WebServlet("/FindIDServlet.do")
public class FindIDServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindIDServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url ="blogmember/findID.jsp";//이동하기위한 3줄
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
	}
	// 이ㄱ
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");// 한글로 인코딩
		String name= request.getParameter("name");//jsp에서 가져온 정보 저장해서 쓰려고
		String email= request.getParameter("email");//jsp에서 가져온 정보 저장해서 쓰려고
		BlogMemberDAO bDao= BlogMemberDAO.getInstance();//dao싱글턴패턴이라 쓰려고 !
		BlogMemberVO bVo = bDao.getBlogMemberID(name,email);//바로 함수 사용! 저 매서드가 이름이랑 이메일 가지고 둘다 일치하는 사람을 찾아서 아이디 가져다주는거
		int result= 0;// 기본값
		if(bVo.getUserid().equals("없음")) {//getUserid()가 없음 즉 ,getBlogMemberID(name,email)이거로 일치하는거 못가져온거
			result=1;
		}else {
			result=-1;//있으면 -1 !!
		}
		System.out.println(result);//디버깅
		request.setAttribute("result", result);////jsp에서 가져온거 다시 세팅해서 들고 다른 jsp로 이동
		request.setAttribute("findIDbVo", bVo);//jsp에서 가져온거 다시 세팅해서 들고 다른 jsp로 이동
		String url ="blogmember/findID.jsp";//이동하기위한 3줄
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
		
	}

}
