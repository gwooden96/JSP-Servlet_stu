package com.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.board.vo.BoardVO;

import util.DBManger;
import util.Paging;

public class BoardDAO {
	
	private BoardDAO() {
		
	}
	
	private static BoardDAO instance = new BoardDAO();
	
	public static BoardDAO getInstance() {
		return instance;
	}
	
	//게시글 목록 전체 조회 메서드
	public List<BoardVO> selectAllBoards(String search, Paging p) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		List<BoardVO> boards = new ArrayList<BoardVO>();
		
		String sql = "select * from ("
				+ "select tb.*, rownum rn from ("
				+ "select * from board";
		
		if(search != null) {
			//여기에 where문을 추가하는 코드
			sql += " where title like '%" + search + "%' ";
		}
		
		sql += " order by no desc) tb"
				+ ")where rn between ? and ?";
		
		try {
			conn = DBManger.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, p.getStart()); //paging 클래스에서 시작번호 가져오기
			pstmt.setInt(2, p.getEnd()); //paging 클래스에서 끝번호 가져오기
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				BoardVO vo = new BoardVO();
				
				vo.setNo(rs.getInt("no"));
				vo.setTitle(rs.getString("title"));
				vo.setContent(rs.getString("content"));
				vo.setId(rs.getString("id"));
				vo.setPostdate(rs.getDate("postdate"));
				vo.setVisitCount(rs.getInt("visitcount"));
				
				boards.add(vo);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManger.close(conn, pstmt, rs);
		}
		
		return boards;
	}
	

	
	/* 위에 메서드 하나로 조회, 검색 둘다 처리
	 * public List<BoardVO> searchBoard(String search) { Connection conn = null;
	 * PreparedStatement pstmt = null; ResultSet rs = null;
	 * 
	 * List<BoardVO> boards = new ArrayList<BoardVO>(); String sql =
	 * "select * from board where title like '%" + search + "%' order by desc";
	 * 
	 * try { conn = DBManger.getConnection(); pstmt = conn.prepareStatement(sql); rs
	 * = pstmt.executeQuery();
	 * 
	 * while(rs.next()) { BoardVO vo = new BoardVO();
	 * 
	 * vo.setNo(rs.getInt("no")); vo.setTitle(rs.getString("title"));
	 * vo.setContent(rs.getString("content")); vo.setId(rs.getString("id"));
	 * vo.setPostdate(rs.getDate("postdate"));
	 * vo.setVisitCount(rs.getInt("visitcount"));
	 * 
	 * boards.add(vo); } } catch (Exception e) { e.printStackTrace(); } finally {
	 * DBManger.close(conn, pstmt, rs); }
	 * 
	 * return boards; }
	 */
	
	
	//insert 추가 게시글 작성
	public void insertBoard(BoardVO vo) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "insert into board(no, title, content, id) values(board_seq.nextval, ?, ?, ?)";
		
		try {
			conn = DBManger.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getContent());
			pstmt.setString(3, vo.getId());
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManger.close(conn, pstmt);
		}
	}
	
	
	//특정 게시글 조회 메서드
	public BoardVO selectBoard(int no) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from board where no=?";
		
		BoardVO vo = new BoardVO();
		
		try {
			conn = DBManger.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				vo.setNo(rs.getInt("no")); //"no"
				vo.setTitle(rs.getString("title"));
				vo.setContent(rs.getString("content"));
				vo.setId(rs.getString("id"));
				vo.setPostdate(rs.getDate("postdate"));
				vo.setVisitCount(rs.getInt("visitcount"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManger.close(conn, pstmt);
		}
		
		return vo;
	}
	
	//게시글 조회할 때 마다 조회수 증가 메서드
	public void updateCnt(int no) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "update board set visitcount = visitcount+1 where no=?";
		
		try {
			conn = DBManger.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, no);
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManger.close(conn, pstmt);
		}
	}
	
	//게시글 삭제 메서드
	
	public void delete(int no) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "delete from board where no=?";
		
		try {
			conn = DBManger.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, no);
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManger.close(conn, pstmt);
		}
	}
	
	//업데이트 메서드
	public void updateBoard(BoardVO vo ) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "update board set title=?, content=? where no=?";
		try {
			conn = DBManger.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getContent());
			pstmt.setInt(3, vo.getNo());
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManger.close(conn, pstmt);
		}
		
	}
	
	
	//db에 있는 게시판 글 총 개수 구하는 메서드 쿼리문
	public int countAll(String search) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 0;
		
		String sql = "select count(*) from board";
		
		if(search != null) {
			//여기에 where문을 추가하는 코드
			sql += " where title like '%" + search + "%' ";
		}
		
		try {
			conn = DBManger.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next())
				result = rs.getInt(1);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManger.close(conn, pstmt, rs);
		}
		
		return result;
	}
	
	
}