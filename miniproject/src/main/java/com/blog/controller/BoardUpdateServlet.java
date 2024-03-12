package com.blog.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blog.dao.BlogBoardDAO;
import com.blog.dto.BlogBoardVO;

/**
 * Servlet implementation class BoardUpdateServlet
 */
@WebServlet("/BoardUpdateServlet.do")
public class BoardUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/blogboard/updateboard.jsp"; // 단순히 urp을 저런 문자열로 지정해놓은거 이건 단순히 문자열일뿐
		String num = request.getParameter("num"); // num을 jsp에서 받아서 여기서 쓰려고 주입중! 
		BlogBoardDAO bDao = BlogBoardDAO.getInstance();//똑같이 싱글턴패턴이라 쓰게됨
		BlogBoardVO bVo = bDao.selectOneBoardByNum(num);//selectOneBoardByNum라는 매서드는 결과값을 리턴하는 것이 있기때문에 저장할 vo를 만들고 저장!
		request.setAttribute("blogboard", bVo);//그렇게 저장한 bvo를 세팅해서 넘겨준다!(위에 url로!)
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);//썜이 말하신 경로이동하는 두줄이 이거임//
		dispatcher.forward(request, response);                           //////////////////////////////////
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		BlogBoardVO bVo = new BlogBoardVO();
		bVo.setNum(Integer.parseInt(request.getParameter("num")));
		bVo.setTitle(request.getParameter("title"));
		bVo.setContent(request.getParameter("content"));
		BlogBoardDAO bDao = BlogBoardDAO.getInstance();
		bDao.updateBlogBoard(bVo);
		response.sendRedirect("http://localhost:8081/MiniProject2/BoardViewServlet.do?num=0");
		
	}

}
