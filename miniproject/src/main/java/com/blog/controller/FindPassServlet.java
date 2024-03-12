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
 * Servlet implementation class MemberFindPassServlet
 */
@WebServlet("/FindPassServlet.do")
public class FindPassServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindPassServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url ="blogmember/findPass.jsp"; //이동하기위한 3줄
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url ="blogmember/findPass.jsp";// 이동위한 3줄중 첫쨰
		request.setCharacterEncoding("utf-8");// 한글번역
		String userid= request.getParameter("userid");//jsp에서 가져온 정보 저장해서 쓰려고
		String Pwhint=request.getParameter("Pwhint");//jsp에서 가져온 정보 저장해서 쓰려고
		String Pwanswer=request.getParameter("Pwanswer");//jsp에서 가져온 정보 저장해서 쓰려고
		BlogMemberDAO bDao = BlogMemberDAO.getInstance();//dao싱글턴패턴이라 쓰려고 !
		if(Pwanswer==null || Pwanswer.equals("")) {//만약Pwanswer입력안했으면 message에 힌트 선택하라고 하는 겁니다
			request.setAttribute("message", "힌트를 선택해주세요");//message에 힌트를 선택해주세요를 띄워주는!
			RequestDispatcher dispatcher = request.getRequestDispatcher(url);// 이동위한 3줄중 둘쨰
			dispatcher.forward(request, response);// 이동위한 3줄중 셋째
			
			return;// 리턴을 해버리면 밑으로 안내려가고 바로 경로이동하고 넘어가지는 ! 이게 없다면 경로이동도 못하고 밑으로 읽어지면서 충돌나고 에러먹어요!
		}
		BlogMemberVO bVo= bDao.getBlogMemberPass(userid,Pwanswer,Pwhint); // 3가지 정보를 가지고 정보 찾는 매서드! 가서 확인해보세요
		System.out.println(bVo.getName());// 디버깅^^
		if (bVo.getPwhint().equals("0")) { // getPwhint()이게 0이면 일치하는 값 없다고 하고 메세지들고 돌려보내기
			request.setAttribute("message", "일치하는 값이 없습니다.");
			RequestDispatcher dispatcher = request.getRequestDispatcher(url);
			dispatcher.forward(request, response);
			
			return; //주의! 
		}
		//쨋든 위에 이렇게 if 2개나주고 한게 입력 안했을 때 , 여러 알람띄워주려고한건데 이제 보니 js로 했으면 훨씬 깔끔하고 여기가 괜찮았을텐데 라는 생각이 드네요..
		System.out.println(bVo.getPwanswer());//디버깅
		System.out.println(bVo.getPwhint().length());//디버깅
		System.out.println("이프 밖");//디버깅
		int result= 0;
		if(bVo.getPwhint().length()!=0) {//이말인즉슨 ! 56번쨰줄에서 일치하는 정보를 찾았따는 뜻! 
			result=1;//1로 지정 가지고 가서 띄워줘야됨!
			request.setAttribute("result", result);//정보 바리바리 싸들고 넘어가기
			request.setAttribute("findPassbVo", bVo);//정보 바리바리 싸들고 넘어가기
			 url ="blogmember/navPass.jsp";//이동 첫째
			 System.out.println(url);//디버깅
			 System.out.println("이프 안");//디버깅
			
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);//이동 둘쨰
		dispatcher.forward(request, response);//이동 셋쨰
	
	}

}
