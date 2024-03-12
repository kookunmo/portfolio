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
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String url ="blogmember/login.jsp";//경로이동 1
			HttpSession session = request.getSession();//세션읽기
			if (session.getAttribute("loginUser") != null) {// 이미 로그인 된 사용자이면 바로 메인페이지가게
				
				//40~43번라인은 세션자체에 들어있는 정보를 수정하는 코드들! 세션에서 수정안하면 
				//정보수정을 햇을 때 로그아웃하고 다시 로그인하지않으면 정보가 수정이 안되어보임 . 하지만 db에는 수정이 되어있음
				BlogMemberVO aa = (BlogMemberVO)session.getAttribute("loginUser");
				BlogMemberDAO mDao = BlogMemberDAO.getInstance();
				session.setAttribute("loginUser", mDao.getBlogMember(aa.getName()));//
				session.setAttribute("loginUser", mDao.getBlogMember(aa.getUserid()));//	

				url = "index.jsp"; // 메인 페이지로 이동한다.
				RequestDispatcher dispatcher = request.getRequestDispatcher(url);//경로이동 2
				dispatcher.forward(request, response);//경로이동 3
				return ;
			}
		
		System.out.println("여긴 실행이 되니?");//디버깅
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);//경로이동 2
		dispatcher.forward(request, response);//경로이동 3
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "blogmember/login.jsp";//경로이동 1
		String userid = request.getParameter("userid");
		String pwd = request.getParameter("pwd");
		BlogMemberDAO mDao = BlogMemberDAO.getInstance();
		int result = mDao.userCheck(userid, pwd);//여기서 1,0,-1 의 값이 나오게 매서드에서 설정해놓음
		System.out.println(result);
		if (result == 1) {// 그 값들로 3가지 형태로 나뉨 성공하면 1 비번틀리면 0 아예 존재안하면 -1 그래서 알맞게 알람띄워줌
			BlogMemberVO mVo = mDao.getBlogMember(userid);
			HttpSession session = request.getSession();// 세션을 가져오는 거
			session.setAttribute("loginUser", mVo);// 그렇게 가져온 세션을 여기서 셋어트리뷰트! 이러면 세션에 등록이 됨
			request.setAttribute("message", "회원 가입에 성공했습니다.");
			url = "index.jsp";
		} else if (result == 0) {
			request.setAttribute("message", "비밀번호가 맞지 않습니다.");
		} else if (result == -1) {
			request.setAttribute("message", "존재하지 않는 회원입니다.");
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);//경로이동 2
		dispatcher.forward(request, response);//경로이동 3
		
	}

}
