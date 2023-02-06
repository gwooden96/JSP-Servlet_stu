package com.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.board.vo.UserVO;

import utill.DBManger;

public class UserDAO {
	
private UserDAO() {
		
	}
	
	private static UserDAO instance = new UserDAO();
	
	public static UserDAO getInstance() {
		return instance;
	}
	
	public UserVO checkLogin(String id, String pw) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		UserVO vo = null; //add
		
		String sql = "select * from boarduser where id=? and pw=?";
		
		try {
			conn = DBManger.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				vo = new UserVO();
				
				vo.setId(rs.getString("id"));
				vo.setPw(rs.getString("pw"));
				vo.setName(rs.getString("name"));
				vo.setRegidate(rs.getDate("regidate"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManger.close(conn, pstmt, rs);
		}
		
		return vo;
	}
	
	

//	public int checkLogin(String id, String pw) {
//		
//		int result = 0;
//		
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		
//		UserVO = null; //add
//		
//		String sql = "select * from boarduser where id=?";
//		
//		try {
//			conn = DBManger.getConnection();
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, id);
//			
//			rs = pstmt.executeQuery();
//			
//			if(rs.next()) {
//				if(pw.equals(rs.getString("pw"))) {
//					result = 1;
//				} else {
//					result = -1;
//				}
//			} else {
//				result = 0;
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			DBManger.close(conn, pstmt, rs);
//		}
//		
//		return result;
//	}
//	

	
//	public UserVO getUser(String id) {
//		
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		
//		UserVO vo = null;
//		
//		String sql = "select * from boarduser where id=?";
//		
//		try {
//			conn = DBManger.getConnection();
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, id);
//			
//			rs = pstmt.executeQuery();
//			
//			if(rs.next()) {
//				vo = new UserVO();
//				
//				vo.setId(rs.getString("id"));
//				vo.setPw(rs.getString("pw"));
//				vo.setName(rs.getString("name"));
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			DBManger.close(conn, pstmt, rs);
//		}
//		
//		return vo;
//	}
}
