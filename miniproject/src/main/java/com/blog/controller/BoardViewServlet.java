package com.blog.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blog.dao.BlogBoardDAO;
import com.blog.dto.BlogBoardVO;

import util.BoardPage;

/**
 * Servlet implementation class BoardViewServlet
 */
@WebServlet("/BoardViewServlet.do")
public class BoardViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardViewServlet() {
    	
        super();
        // TODO Auto-generated constructor stub
 
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/main.jsp";//똑같이 이동할 경로 단순한 문자열로 지정해주고 밑에서 이용 
		BlogBoardDAO bDao = BlogBoardDAO.getInstance();//dao싱글턴패턴이라 똑같이 해주는중 
		
		Map<String,Object> map = new HashMap<String,Object>();//제네릭을 이용해서 string과 object라는 타입을 가지는 해쉬맵을 생성
		//검색을 위해서 map이라는 해쉬맵을 만들어줌
		String searchField = request.getParameter("searchField"); //메인 jsp에서 검색필드 ex)제목 or내용
		String searchWord = request.getParameter("searchWord"); // 검색입력내용들
		if(searchWord !=null) {//이 이프문은 검색을 했을 떄 ! 이 값이 차게되는데 그럼 map에 저 값들으 넣어주겟다. 왜냐면 밑에서 이용해야되거든 이라는 뜻임
			map.put("searchField", searchField);
			map.put("searchWord", searchWord);
		}
		int totalCount =bDao.selectCount(map);//selectCount라는 dao를 사용해서 총 갯수 세어줌 ! 이제 페이징처리해야돼서!
		/* 페이지 처리 start */
		int pageSize=6; // 우린 5개씩 나와야되는데 이거 뭐 -1씩나오길래 추가로 6으로 지정해줬삼
		int blockPage = 5;// 이건 밑에    이전 1 2 3 4 5 다음   여기 5개씩 보여주는 거!
		
		//현재 페이지 확인
		int pageNum = 1; // 처음 jsp실행했을 때 , 1번째 페이지를 봐야돼서 이렇게 지정! (초기페이지)
		String pageTemp = request.getParameter("pageNum"); //이건 페이지를 변경하면 pageNum이게 변해서 온다 
		if(pageTemp != null && !pageTemp.equals("")) {
			pageNum= Integer.parseInt(pageTemp);//첫 pageTemp는 1로 들어감
		}/// 처음엔 pageNum이걸 받지않아서  url은 http://localhost:8081/Board/BoardServlet?command=board_list 이렇게만 나옴
		//기본값이 pageNum= 1로 시작하는거
		//즉 String pageTemp = request.getParameter("pageNum"); 이줄은 번호를 클릭했을 때 , 저 값받아서 pageTemp에 pageNum값을 넣어주는역할
		
		 // 목록에 출력할 게시물 범위 계산
		int start = (pageNum-1)*pageSize +1; 
		int end = pageNum*pageSize;
		map.put("start", start);
        map.put("end", end);
		//페이지처리 end//
        
        //최근 페이지 상세보기//==>메모장 참고 읽고나서 진행!
        String num = request.getParameter("num");//게시판에서 글 선택을 안했을 때 , 기본값으로 num=0으로 선언됨
        if(num.equals("0")) { //num가 0이니깐 이떈 최신글을 불러오게 한다!
        	BlogBoardVO selectboard =bDao.selectRecentboard();//selectRecentboard이건 제일 최신글을 불러오는 dao ! 가서 한번 읽어보세요ㅕ
        	request.setAttribute("selectboard", selectboard);//그렇게 불러온 selectboard를 main에 넘겨주려고 셋어트리뷰트 하는 중
        }else {
        bDao.updateReadCount(num);// 아닐시엔 updateReadCount를 실행 ==> 조회수 1증가하는 거.
		BlogBoardVO selectboard = bDao.selectOneBoardByNum(num);//selectOneBoardByNum num으로 글찾아오는거고 찾아온거 selectboard에 넣어줌
		request.setAttribute("selectboard", selectboard);//selectboard를 넘겨줌
		}
        //최근 페이지 상세보기.end//
		//뷰에 전달할 매개변수 추가
		String pagingString="";
		if(searchWord != null) {//여긴 좀 복잡하고 그 보드페이지를 봐야됨 단순히 생각해서 여기는 검색을 했을 떄 ! 
			pagingString=BoardPage.pagingStr(totalCount, pageSize, blockPage, pageNum,
			"/MiniProject2/BoardViewServlet.do?num="+num+"&searchField="+searchField+"&searchWord="+searchWord);
		}else {//여기는 검색을 안햇을 때 !! 정도로 이해하면 됨 세세하게 알고싶으면 보드페이지 보시면 됨 보드페이지보고 이해안되면 물어보심 친절히 알려드립니다 ^_^ㅎㅎ;;ㅎ;ㅎ;ㅎ;ㅎ;;;ㅎ;ㅎ;ㅎ;
			pagingString = BoardPage.pagingStr(totalCount, pageSize, blockPage, pageNum, "/MiniProject2/BoardViewServlet.do?num="+num);
		}
		//이 밑에 4개 map.put하고 있는 이건 map 안에 정보들 다 넣어주고 있는거
		map.put("pagingString", pagingString);
		map.put("totalCount", totalCount);
		map.put("pageSize", pageSize);
		map.put("pageNum", pageNum);
		
		//그렇게 우겨넣은 정보들 셋어트리뷰트!!
		// 전달할 데이터를 request 영역에 저장 후 List.jsp로 포워드   
		request.setAttribute("map", map);
		//페이징처리끝
		
		
		List<BlogBoardVO> boardList=bDao.selectListPage(map);//목록조회
		request.setAttribute("BlogBoardList", boardList);//view 에 전달할 데이터
		
	
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);//목록페이지로 이동. 주소변경없음
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	
	
	}

}
