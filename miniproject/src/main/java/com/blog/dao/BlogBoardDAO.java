package com.blog.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.blog.dto.BlogBoardVO;

import util.DBManager;

public class BlogBoardDAO {
	private BlogBoardDAO() {}
	private static BlogBoardDAO instance = new BlogBoardDAO();

	public static BlogBoardDAO getInstance() {//외부에서는 BoardDAO.getInstance()형식으로 사용
		return instance;//instance 리턴
	}
	//블로그보드에 값 삽입!
	//블로그보드에 값 삽입!
		
	public void insertBlogBoard(BlogBoardVO bVo) {
		String sql = " insert into BlogBoard("
				+ " num, userid, title, content)"
				+ " values(BlogBoard_seq2.nextval,'hkd', ?, ?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
		//pstmt.setString(1, bVo.getUserid());
			pstmt.setString(1, bVo.getTitle());
			pstmt.setString(2, bVo.getContent());
			
			
			
			pstmt.executeUpdate(); // 바뀐 행의 수 ==1   이나올거에요 
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}
	
	//게시물 수 세는 카운트 매서드
	public int selectCount(Map<String, Object> map) {
        int totalCount = 0;
        String sql = "select count(*) from BlogBoard";
        
        if (map.get("searchWord") != null) {
            sql += " where " + map.get("searchField") + " "
                   + " like '%" + map.get("searchWord") + "%'";
        }
        Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
        try {
        	conn=DBManager.getConnection();
        	pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            if(rs.next()) {
            	totalCount = rs.getInt(1);
            }
        }
        catch (Exception e) {           
            e.printStackTrace();
        }finally {
        	DBManager.close(conn, pstmt, rs);
        }
        return totalCount;
    }
	//게시물 수 새는 카운트 매서드
	
	//페이징처리하기 위한 sql 개김 거따 물음표 두개 달아서 숫자 두개 입력할건데 섭르릿에서 불러서 ㄱㄱ
	public List<BlogBoardVO> selectListPage(Map<String,Object> map) {        
        String sql = "select * "
        			+ "from ( "
                     + "    select t.*, rownum rnum from ( "
                     + "        select * from BlogBoard ";

        if (map.get("searchWord") != null)
        {
            sql += " where " + map.get("searchField")
                   + " like '%" + map.get("searchWord") + "%' ";
        }

        sql += "        order by num desc "
               + "    ) t "
               + " 	where rownum < ?) "
               + "where rnum >= ?";
        
   
             
        List<BlogBoardVO> list = new ArrayList<BlogBoardVO>();
        Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
        try {
        	conn=DBManager.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, map.get("end").toString());
            pstmt.setString(2, map.get("start").toString());
            rs = pstmt.executeQuery();
            
            while (rs.next()) {                
            	BlogBoardVO bVo=new BlogBoardVO();
				bVo.setNum(rs.getInt("num"));
				bVo.setUserid(rs.getString("userid"));
				bVo.setTitle(rs.getString("title"));
				bVo.setContent(rs.getString("content"));
				bVo.setReadcount(rs.getInt("readcount"));
				bVo.setWritedate(rs.getTimestamp("writedate"));
				list.add(bVo);               
            }
        }
        catch (Exception e) {
            System.out.println("게시물 조회 중 예외 발생");
            e.printStackTrace();
        }finally {
        	DBManager.close(conn, pstmt, rs);
        }
        return list;
	}
	//페이징처리하기 위한 sql 개김 거따 물음표 두개 달아서 숫자 두개 입력할건데 섭르릿에서 불러서 ㄱㄱ
	
	//게시판 내용 수정
		public void updateBlogBoard(BlogBoardVO bVo) {
			String sql = "update Blogboard set "
					+ "title=?, content=? where num=?";
			Connection conn = null;
			PreparedStatement pstmt = null;
			try {
				conn = DBManager.getConnection();
				pstmt = conn.prepareStatement(sql);
				//pstmt.setString(1, bVo.getUserid());
				pstmt.setString(1, bVo.getTitle());
				pstmt.setString(2, bVo.getContent());
				pstmt.setInt(3, bVo.getNum());
				pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt);
			}
		}
		//수정하기////수정하기////수정하기////수정하기////수정하기////수정하기//
	
	//게시판 내용 삭제
		public void deleteBlogBoard(String num) {
			String sql = "delete BlogBoard where num=?";
			Connection conn = null;
			PreparedStatement pstmt = null;
			try {
				conn=DBManager.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, num);
				pstmt.executeUpdate();			
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		//삭제하기////삭제하기////삭제하기////삭제하기////삭제하기////삭제하기//
		
		public BlogBoardVO selectOneBoardByNum(String num) {
			String sql = "select * from BlogBoard where num=?";
			BlogBoardVO bVo = null;
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs =null;
			try {
				conn = DBManager.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, num);
				rs = pstmt.executeQuery();
				if(rs.next()) {
					bVo = new BlogBoardVO();
					bVo.setNum(rs.getInt("num"));
					bVo.setTitle(rs.getString("title"));
					bVo.setContent(rs.getString("content"));
					bVo.setWritedate(rs.getTimestamp("writedate"));
					bVo.setReadcount(rs.getInt("readcount"));
				}


			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				DBManager.close(conn, pstmt, rs);
			}
			return bVo;
		}
		
		public BlogBoardVO selectRecentboard() {
			String sql = "select * from BlogBoard order by num desc";
			BlogBoardVO bVo = null;
			Connection conn = null;
			Statement stmt = null;
			ResultSet rs =null;
			try {
				conn = DBManager.getConnection();
				stmt = conn.createStatement();
				rs = stmt.executeQuery(sql);
				if(rs.next()) {
					bVo = new BlogBoardVO();
					bVo.setNum(rs.getInt("num"));
					bVo.setTitle(rs.getString("title"));
					bVo.setContent(rs.getString("content"));
					bVo.setWritedate(rs.getTimestamp("writedate"));
					bVo.setReadcount(rs.getInt("readcount"));
				}


			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				DBManager.close(conn, stmt, rs);
			}
			return bVo;
		}
		
		public void updateReadCount(String num) {
			String sql = "update blogboard set readcount=readcount+1 where num=?";
			Connection conn = null;
			PreparedStatement pstmt = null;
			try {
				conn = DBManager.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, num);
				pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt);
			}
		}
}
