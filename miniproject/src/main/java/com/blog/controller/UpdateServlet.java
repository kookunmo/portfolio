package com.blog.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.blog.dao.BlogMemberDAO;
import com.blog.dto.BlogMemberVO;

/**
 * Servlet implementation class MemberUpdateServlet
 */
@WebServlet("/UpdateServlet.do")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userid = request.getParameter("userid");//jsp에서 받아온 정보 주입
		BlogMemberDAO mDao = BlogMemberDAO.getInstance();//dao쓰려고
		BlogMemberVO mVo = mDao.getBlogMember(userid);//userid로 정보불러와서 정보들고 다른 jsp 이동
		request.setAttribute("mVo", mVo);
		RequestDispatcher dispatcher =request.getRequestDispatcher("blogmember/updatelogin.jsp");//경로이동 1, 2
		dispatcher.forward(request, response);//경로이동 3
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8"); // 한글 깨짐을 방지
		String name = request.getParameter("name");
		String userid = request.getParameter("userid");
		String pwd = request.getParameter("pwd");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String pwanswer = request.getParameter("pwanswer");
		String pwhint = request.getParameter("pwhint");
		BlogMemberVO mVo = new BlogMemberVO();
		mVo.setName(name);
		mVo.setUserid(userid);
		mVo.setPwd(pwd);
		mVo.setEmail(email);
		mVo.setPhone(phone);
		mVo.setPwanswer(pwanswer);
		mVo.setPwhint(pwhint);
		BlogMemberDAO mDao = BlogMemberDAO.getInstance();
		int result = mDao.updateMember(mVo);
		System.out.println("결과 : "+result);
		HttpSession session = request.getSession();
		BlogMemberVO aa = (BlogMemberVO)session.getAttribute("loginUser");
		//			mDao.getMember(aa.getName());	
		session.setAttribute("loginUser", mDao.getBlogMember(aa.getName()));
		session.setAttribute("loginUser", mDao.getBlogMember(aa.getUserid()));	
		RequestDispatcher dispatcher =request.getRequestDispatcher("index.jsp");
		dispatcher.forward(request, response);
		
	}

}
