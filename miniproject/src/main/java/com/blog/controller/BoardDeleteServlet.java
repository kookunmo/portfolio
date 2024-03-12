package com.blog.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blog.dao.BlogBoardDAO;

/**
 * Servlet implementation class BoardDeleteServlet
 */
@WebServlet("/BoardDeleteServlet.do")//서블릿 주소
public class BoardDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String num=request.getParameter("num");//제일 기본이 됨 ! 정보를 받아옴 . request.getParameter는 계속 나오는데 jsp에서부터 정보를 받아오고 어떤 정보를 어떤곳에 저장할지 !
		BlogBoardDAO bDao=BlogBoardDAO.getInstance();// dao가 지금 싱글턴패턴이라 이렇게 getInstance를 실행해주고 원하는 매서드 사용!
		bDao.deleteBlogBoard(num);//삭제 메서드를 사용
		response.sendRedirect("http://localhost:8081/MiniProject2/BoardViewServlet.do?num=0");// 경로 이동!
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
