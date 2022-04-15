package com.ds.m1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.ds.ct.DBManager;
import com.ds.login.Account;
import com.ds.m4.applylist;



public class MypetDAO {
	
	public static void userinformation(HttpServletRequest request) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		HttpSession hs = request.getSession();
	    Account t = (Account) hs.getAttribute("taccountInfo");	
	        
	    String a_tname = t.getT_name();
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		
		
		System.out.println(id);
		System.out.println(name);
		System.out.println(a_tname);
		
		
		
		try {
			con=DBManager.connect();
			String sql="select * from apply_table where a_id=? and a_name=? and a_tname=?";
			pstmt=con.prepareStatement(sql);
			
			pstmt.setString(1, id);
			pstmt.setString(2, name);
			pstmt.setString(3, a_tname);
			
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				applylist applyBean = new applylist(rs.getInt("a_no"),rs.getString("a_id"),rs.getString("a_name"),rs.getString("a_gender"),rs.getDate("a_start"),rs.getDate("a_end"),rs.getInt("a_age"),rs.getString("a_img"),rs.getString("a_tname"),rs.getInt("a_agree"));
			
				HttpSession session = request.getSession();
				session.setAttribute("applyBean", applyBean);
				session.setMaxInactiveInterval(3000);
			
			}
			
		}catch (Exception e) {

			request.setAttribute("a", "db문제");
			e.printStackTrace();
		}finally {
			
			DBManager.close(con, pstmt, null);
		}

	}

	public static void teacherinformation(HttpServletRequest request) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
        HttpSession hs = request.getSession();
        Account u = (Account) hs.getAttribute("uaccountInfo");
        
        String a_id = u.getU_id();
		String tname = request.getParameter("tname");
		String name = request.getParameter("name");
		
		
		System.out.println(a_id);
		System.out.println(tname);
		System.out.println(name);
		
		
		
		try {
			con=DBManager.connect();
			String sql="select * from apply_table where a_id=? and a_name=? and a_tname=?";
			pstmt=con.prepareStatement(sql);
			
			pstmt.setString(1, a_id);
			pstmt.setString(2, name);
			pstmt.setString(3, tname);
			
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				applylist applyBean = new applylist(rs.getInt("a_no"),rs.getString("a_id"),rs.getString("a_name"),rs.getString("a_gender"),rs.getDate("a_start"),rs.getDate("a_end"),rs.getInt("a_age"),rs.getString("a_img"),rs.getString("a_tname"),rs.getInt("a_agree"));
			
				HttpSession session = request.getSession();
				session.setAttribute("applyBean", applyBean);
				session.setMaxInactiveInterval(3000);
			
			}
			
		}catch (Exception e) {

			request.setAttribute("a", "db문제");
			e.printStackTrace();
		}finally {
			
			DBManager.close(con, pstmt, null);
		}
		
	}

}
