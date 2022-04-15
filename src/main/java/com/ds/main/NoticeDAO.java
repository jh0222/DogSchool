package com.ds.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.ds.ct.DBManager;
import com.ds.login.Account;
import com.ds.login.AccountDAO;

public class NoticeDAO {

	public static void showAll(HttpServletRequest request) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="select * from notice_table order by n_no desc";
		try {
			con=DBManager.connect();
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			Notice n = null;
			ArrayList<Notice> notice = new ArrayList<Notice>();
			while(rs.next()) {
				n = new Notice();

				n.setN_no(rs.getInt("n_no"));
				n.setN_id(rs.getString("n_id"));
				n.setN_title(rs.getString("n_title"));
				n.setN_txt(rs.getString("n_txt"));
				n.setN_date(rs.getDate("n_date"));
				notice.add(n);				
			}
			
			request.setAttribute("n", notice);
			
		} catch(Exception e) {
			request.setAttribute("result", "db서버 오류");
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, rs);
		}
		
		
	}

	public static void showOne(HttpServletRequest request) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="select * from notice_table where n_no=?";
		try {
			con=DBManager.connect();
			pstmt=con.prepareStatement(sql);
			int no = Integer.parseInt(request.getParameter("no"));
			pstmt.setInt(1, no);
			rs=pstmt.executeQuery();

			Notice n = null;			
			if(rs.next()) {
				n = new Notice();
				n.setN_no(rs.getInt("n_no"));
				n.setN_id(rs.getString("n_id"));
				n.setN_title(rs.getString("n_title"));
				n.setN_txt(rs.getString("n_txt"));
				n.setN_date(rs.getDate("n_date"));				
			}
			
			request.setAttribute("n", n);
			
		} catch(Exception e) {
			request.setAttribute("result", "db서버 오류");
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, rs);
		}
		
	}

	public static void Showfive(HttpServletRequest request) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql = "select *"
	               + "from(select * from notice_table order by n_no desc )"
	               + "where rownum <= 5";
		try {
			con=DBManager.connect();
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			Notice n = null;
			ArrayList<Notice> notice = new ArrayList<Notice>();
			while(rs.next()) {
				n = new Notice();

				n.setN_no(rs.getInt("n_no"));
				n.setN_id(rs.getString("n_id"));
				n.setN_title(rs.getString("n_title"));
				n.setN_txt(rs.getString("n_txt"));
				n.setN_date(rs.getDate("n_date"));
				notice.add(n);				
			}
			
			request.setAttribute("n", notice);
			
		} catch(Exception e) {
			request.setAttribute("result", "db서버 오류");
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, rs);
		}
		
		
	}

	public static void insert(HttpServletRequest request) {
		Connection con=null;
		PreparedStatement pstmt=null;
		String sql="insert into notice_table values((select NVL(max(n_no),0)+1 from notice_table),?,?,?,sysdate)";
		try {
			con=DBManager.connect();
			pstmt=con.prepareStatement(sql);
			
			HttpSession hs = request.getSession();
			Account r = (Account) hs.getAttribute("raccountInfo");
			Account t = (Account) hs.getAttribute("taccountInfo");
			
			String id=null;
			if(r!=null) {
				id=r.getR_id();
			} else if(t!=null) {
				id=t.getT_id();
			}

			String title=request.getParameter("title");
			String txt=request.getParameter("txt");
			
			pstmt.setString(1, id);
			pstmt.setString(2, title);
			pstmt.setString(3, txt);
			
			int row = pstmt.executeUpdate();						 
			if(row == 1) {
				request.setAttribute("result", "등록 성공");
			} else {
				request.setAttribute("result", "등록 실패");
			}
			
		} catch(Exception e) {
			request.setAttribute("result", "db 서버 오류");
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, null);
		}
		
	}

	public static void update(HttpServletRequest request) {
		Connection con=null;
		PreparedStatement pstmt=null;
		String sql="update notice_table set n_title=?,n_txt=?,n_date=sysdate where n_no=?";
		try {
			con=DBManager.connect();
			pstmt=con.prepareStatement(sql);
			
			int no = Integer.parseInt(request.getParameter("no"));
			
			pstmt.setString(1, request.getParameter("title"));
			pstmt.setString(2, request.getParameter("txt"));
			pstmt.setInt(3, no);
			
			if(pstmt.executeUpdate() == 1) {
				request.setAttribute("reasult", "수정 성공");
			}else {
				request.setAttribute("reasult", "수정 실패");
			}
			
		} catch(Exception e) {
			request.setAttribute("reasult", "db서버 오류");
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, null);
		}
		
	}

	public static void delete(HttpServletRequest request) {
		Connection con=null;
		PreparedStatement pstmt=null;
		String sql="delete from notice_table where n_no=?";
		try {
			con=DBManager.connect();
			pstmt=con.prepareStatement(sql);
			
			int no = Integer.parseInt(request.getParameter("no"));
			pstmt.setInt(1, no);
			
			if(pstmt.executeUpdate() == 1) {
				request.setAttribute("reasult", "삭제 성공");
			}else {
				request.setAttribute("reasult", "삭제 실패");
			}
			
		} catch(Exception e) {
			request.setAttribute("reasult", "db서버 오류");
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, null);
		}
		
	}

}
