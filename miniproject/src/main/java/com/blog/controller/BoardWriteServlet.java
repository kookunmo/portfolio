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
 * Servlet implementation class BoardWriteServlet
 */
@WebServlet("/BoardWriteServlet.do")
public class BoardWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardWriteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url="/blogboard/writeboard.jsp"; //이동하기위한 3줄
		RequestDispatcher dispatcher=request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8"); // 한글로 인코딩
		String title = request.getParameter("title"); //jsp에서 가져온 정보 저장해서 쓰려고
		String content = request.getParameter("content"); //jsp에서 가져온 정보 저장해서 쓰려고
		BlogBoardDAO bbDao=BlogBoardDAO.getInstance();//dao싱글턴패턴이라 쓰려고 !
		BlogBoardVO bbVo=new BlogBoardVO();// 빈bbvo만들기!
		bbVo.setTitle(title);//jsp에서 가져온거 다시 세팅해서 들고 다른 jsp로 이동
		bbVo.setContent(content);//jsp에서 가져온거 다시 세팅해서 들고 다른 jsp로 이동
		
		bbDao.insertBlogBoard(bbVo);// 다른 jsp가기전에 db에 insert한번 해주고 넘어가기
		response.sendRedirect("http://localhost:8081/MiniProject2/BoardViewServlet.do?num=0");
		
	}

}
