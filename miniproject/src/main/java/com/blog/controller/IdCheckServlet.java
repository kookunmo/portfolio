package com.blog.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blog.dao.BlogMemberDAO;

/**
 * Servlet implementation class MemberIdCheckServlet
 */
@WebServlet("/IdCheckServlet.do")
public class IdCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IdCheckServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userid = request.getParameter("userid");//jsp에서 가져온 정보 저장해서 쓰려고
		BlogMemberDAO mDao = BlogMemberDAO.getInstance();//싱글턴패턴 사용해서 dao가져다쓰려고!
		int result = mDao.confirmID(userid);//아이디확인하는 매서드사용하는데 값이 1,0,-1로 나옴! 매서드 참고!
		request.setAttribute("userid", userid);//정보 바리바리 싸들고 넘어가기
		request.setAttribute("result", result);//정보 바리바리 싸들고 넘어가기
		RequestDispatcher dispatcher = request.getRequestDispatcher("blogmember/idcheck.jsp");//주소이동 첫쨰와둘쨰
		dispatcher.forward(request, response);//주소이동 셋째
	
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
