package com.blog.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.blog.dto.BlogMemberVO;

import util.DBManager;

public class BlogMemberDAO {
	private BlogMemberDAO() {}

	private static BlogMemberDAO instance = new BlogMemberDAO();
	public static BlogMemberDAO getInstance() {
		return instance;
	}

	// 사용자 인증시 사용하는 메소드
	public int userCheck(String userid, String pwd) {
		int result = -1;
		String sql = "select pwd from BlogMember where userid=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				if (rs.getString("pwd") != null
						&& rs.getString("pwd").equals(pwd)) {
					result = 1;
				} else {
					result = 0;
				}
			} else {
				result = -1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return result;
	}

	// 아이디로 회원 정보 가져오는 메소드
	public BlogMemberVO getBlogMember(String userid) {
		BlogMemberVO mVo = null;
		String sql = "select * from Blogmember where userid=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				mVo = new BlogMemberVO();
				mVo.setName(rs.getString("name"));
				mVo.setNickname(rs.getString("nickname"));
				mVo.setUserid(rs.getString("userid"));
				mVo.setPwd(rs.getString("pwd"));
				mVo.setEmail(rs.getString("email"));
				mVo.setPhone(rs.getString("phone"));
				mVo.setPwanswer(rs.getString("Pwanswer"));
				mVo.setPwhint(rs.getString("Pwhint"));
				mVo.setJoindate(rs.getTimestamp("joindate"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return mVo;
	}

	//아이디 확인하너느거
	public int confirmID(String userid) {
		int result = -1;
		String sql = "select userid from Blogmember where userid=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				result = 1;
			} else {
				result = -1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}

		return result;
	}

	//블로그멤버 추가하는 거
	public int insertBlogMember(BlogMemberVO mVo) {
		int result = -1;
		String sql = "insert into Blogmember(name,nickname,userid,pwd,email,phone,pwhint,pwanswer) values(?, ?, ?, ?, ?, ?, ?, ?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mVo.getName());
			pstmt.setString(2, mVo.getNickname());
			pstmt.setString(3, mVo.getUserid());
			pstmt.setString(4, mVo.getPwd());
			pstmt.setString(5, mVo.getEmail());
			pstmt.setString(6, mVo.getPhone());
			pstmt.setString(7, mVo.getPwhint());
			pstmt.setString(8, mVo.getPwanswer());

			result = pstmt.executeUpdate();//영향을 받은 행의 수. insert하면 1행이 추가되므로 1이 리턴됨 즉 1이나온거면 정상적으로 값이 들어간거다!

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		return result;
	}

	//회원정보수정하는 거
	public int updateMember(BlogMemberVO mVo) {
		int result = -1;
		String sql = " update Blogmember set pwd=?, email=?,"
				+ " phone=? ,name=?,pwanswer=?,pwhint=? where userid=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mVo.getPwd());
			pstmt.setString(2, mVo.getEmail());
			pstmt.setString(3, mVo.getPhone());
			pstmt.setString(4, mVo.getName());
			pstmt.setString(5, mVo.getPwanswer());
			pstmt.setString(6, mVo.getPwhint());
			pstmt.setString(7, mVo.getUserid());
			System.out.println("여기");
			System.out.println(mVo.getUserid());
			System.out.println(mVo.getPwd());
			System.out.println(mVo.getEmail());
			System.out.println(mVo.getPhone());
			System.out.println(mVo.getPwanswer());
			System.out.println(mVo.getName());
			System.out.println(mVo.getPwhint());
			System.out.println("여기");
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		return result;
	}
	
	public BlogMemberVO getBlogMemberID(String name,String email) {
		BlogMemberVO mVo = null;
		String sql = "select * from Blogmember where name=? and email=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, email);
			rs = pstmt.executeQuery();
			mVo = new BlogMemberVO();
			if (rs.next()) {
				mVo.setName(rs.getString("name"));
				mVo.setNickname(rs.getString("nickname"));
				mVo.setUserid(rs.getString("userid"));
				mVo.setPwd(rs.getString("pwd"));
				mVo.setEmail(rs.getString("email"));
				mVo.setPhone(rs.getString("phone"));
				mVo.setPwanswer(rs.getString("Pwanswer"));
				mVo.setPwhint(rs.getString("Pwhint"));
				
			}else {
				mVo.setUserid("없음");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return mVo;
	}
	public BlogMemberVO getBlogMemberPass(String userid,String Pwanswer,String Pwhint) {
		BlogMemberVO mVo = null;
		String sql = "select * from Blogmember where userid=? and Pwanswer=? and Pwhint=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			mVo = new BlogMemberVO();
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			pstmt.setString(2, Pwanswer);
			pstmt.setString(3, Pwhint);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				mVo.setName(rs.getString("name"));
				mVo.setNickname(rs.getString("nickname"));
				mVo.setUserid(rs.getString("userid"));
				mVo.setPwd(rs.getString("pwd"));
				mVo.setEmail(rs.getString("email"));
				mVo.setPhone(rs.getString("phone"));
				mVo.setPwanswer(rs.getString("Pwanswer"));
				mVo.setPwhint(rs.getString("Pwhint"));
				
			}else {
				mVo.setPwhint("0");//에러 시 쓸라고
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		
		return mVo;
	}
	
	
}
