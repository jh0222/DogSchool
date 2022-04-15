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

public class tpostscriptDAO {

	public static void showAll(HttpServletRequest request) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="select * from postscript_table order by p_no desc";
		try {
			con=DBManager.connect();
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			Postscript p = null;
			ArrayList<Postscript> postscript = new ArrayList<Postscript>();
			while(rs.next()) {
				p = new Postscript();

				p.setP_no(rs.getInt("p_no"));
				p.setP_id(rs.getString("p_id"));
				p.setP_title(rs.getString("p_title"));
				p.setP_txt(rs.getString("p_txt"));
				p.setP_date(rs.getDate("p_date"));
				postscript.add(p);				
			}
			
			request.setAttribute("p", postscript);
			
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
		String sql="select * from postscript_table where p_no=?";
		try {
			con=DBManager.connect();
			pstmt=con.prepareStatement(sql);
			int no = Integer.parseInt(request.getParameter("no"));
			pstmt.setInt(1, no);
			rs=pstmt.executeQuery();

			Postscript p = null;			
			if(rs.next()) {
				p = new Postscript();
				p.setP_no(rs.getInt("p_no"));
				p.setP_id(rs.getString("p_id"));
				p.setP_title(rs.getString("p_title"));
				p.setP_txt(rs.getString("p_txt"));
				p.setP_date(rs.getDate("p_date"));
			}
			
			request.setAttribute("p", p);
			
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
	               + "from(select * from postscript_table order by p_no desc )"
	               + "where rownum <= 5";
		try {
			con=DBManager.connect();
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			Postscript p = null;
			ArrayList<Postscript> postscript = new ArrayList<Postscript>();
			while(rs.next()) {
				p = new Postscript();

				p.setP_no(rs.getInt("p_no"));
				p.setP_id(rs.getString("p_id"));
				p.setP_title(rs.getString("p_title"));
				p.setP_txt(rs.getString("p_txt"));
				p.setP_date(rs.getDate("p_date"));
				postscript.add(p);				
			}
			
			request.setAttribute("p", postscript);
			
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
		String sql="insert into postscript_table values((select NVL(max(p_no),0)+1 from postscript_table),?,?,?,sysdate)";
		try {
			con=DBManager.connect();
			pstmt=con.prepareStatement(sql);
			
			HttpSession hs = request.getSession();
			Account r = (Account) hs.getAttribute("raccountInfo");
			Account u = (Account) hs.getAttribute("uaccountInfo");
			
			String id=null;
			if(r!=null) {
				id=r.getR_id();
			} else if(u!=null) {
				id=u.getU_id();
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
		String sql="update postscript_table set p_title=?,p_txt=?,p_date=sysdate where p_no=?";
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
		String sql="delete from postscript_table where p_no=?";
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
