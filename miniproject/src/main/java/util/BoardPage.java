package util;

public class BoardPage { ////////////////1///////////////2////////////3///////////4//////////////5//////////
	public static String pagingStr(int totalCount, int pageSize, int blockPage,int pageNum, String reqUrl) {
		String pagingStr = "";
		// 단계 3 : 전체 페이지 수 계산
		int totalPages = (int) (Math.ceil(((double) totalCount / pageSize)));
		////////////////////////////////////////////////   pageSize= 10 넣는거로 Math.ceil 은 올림처리
		// 단계 4 : '이전 페이지 블록 바로가기'        
		//blockPage는 5 pageTemp-- 현재페이지 느낌
		int pageTemp = (((pageNum - 1) / blockPage) * blockPage) + 1;
		///여기서 pageTemp는 5페이지 전 이면 1이되어버려서 if문 적용이안됨 -> 즉 첫페이지 이전블록이 생성되지 않는다.
		//pageTemp는 현재페이지를 뜻함
		if (pageTemp != 1) {
            pagingStr += "<a class=\"move\" href='" + reqUrl + "&pageNum=1'>처음</a>";
            pagingStr += "<a class=\"move\" href='" + reqUrl + "&pageNum=" + (pageTemp - 1)
                         + "'>이전</a>";
        }

		// 단계 5 : 각 페이지 번호 출력
		int blockCount = 1; // 
		
		// 왼쪽꺼 브레이크 걸리면 단계 6도 적용되는거고
		//오른쪽꺼 브레이크 걸리면 단계 6적용 안돼서 다읍페이지 블록 바로가기가
		//안나옴!!
		//그 블럭에서의 숫자 totalPages는 461임
		while (blockCount <= blockPage && pageTemp <= totalPages) {
			if (pageTemp == pageNum) {//
				// 현재 페이지는 링크를 걸지 않음 - 그러네
				pagingStr += "&nbsp; <b><span style='color:#e4932b; font-size:14px;'>" + pageTemp + "</span></b>&nbsp;";
			} else {// 다른 숫자들에는 링크들 다 걸어줌
				pagingStr += "&nbsp;<a href='" + reqUrl + "&pageNum=" + pageTemp
						+ "'>" + pageTemp + "</a>&nbsp;";
			}
			pageTemp++;
			blockCount++;
		}//pageTemp 10페이지지만 지금은 11로 되어있겠다. 블럭카운트도 6이 되어버려서 와일문에서 빠져나왔따 아하아하아하
		//

		// 단계 6 : '다음 페이지 블록 바로가기' 출력
		if (pageTemp <= totalPages) {
            pagingStr += "<a class=\"move\" href='" + reqUrl + "&pageNum=" + pageTemp
                         + "'>다음</a>";
            pagingStr += "<a class=\"move\" href='" + reqUrl + "&pageNum=" + totalPages
                         + "'>마지막</a>";
        }

		return pagingStr;
	}
}
