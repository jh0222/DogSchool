package com.ds.m3;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;


import com.ds.ct.DBManager;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class applyDAO {
	
	
	public static void reg(HttpServletRequest request) throws IOException {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		String path = request.getServletContext().getRealPath("file");
		MultipartRequest mr = new MultipartRequest(request, path, 31257280, "utf-8", new DefaultFileRenamePolicy());
		System.out.println(path);
		
		String a_id = mr.getParameter("id");
		String a_name = mr.getParameter("name");
		String a_gender = mr.getParameter("gender");
		String a_start = mr.getParameter("start");
		String a_end = mr.getParameter("end");
		int a_age =  Integer.parseInt(mr.getParameter("age"));
		String a_img = mr.getFilesystemName("img");
		String a_tname = mr.getParameter("tname");
		int a_agree = 0;
		
	
		System.out.println(a_id);
		System.out.println(a_name);
		System.out.println(a_gender);
		System.out.println(a_start);
		System.out.println(a_end);
		System.out.println(a_age);
		System.out.println(a_img);
		System.out.println(a_tname);
		System.out.println(a_agree);
        
		
		try {
			con = DBManager.connect();
			String sql = "insert into apply_table values(apply_table_seq.nextval,?, ?, ?, to_date(?,'YYYY-MM-DD'), to_date(?,'YYYY-MM-DD'),?, ?, ?,?)"; 
			pstmt = con.prepareStatement(sql);
			
			
			pstmt.setString(1, a_id);
			pstmt.setString(2, a_name);
			pstmt.setString(3, a_gender);
			pstmt.setString(4, a_start);
			pstmt.setString(5, a_end);
			pstmt.setInt(6, a_age);
			pstmt.setString(7, a_img);
			pstmt.setString(8, a_tname);
			pstmt.setInt(9, a_agree);
			
			
			
			if(pstmt.executeUpdate()==1) {
				request.setAttribute("apply", "신청 완료");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("apply", "신청 실패");
		}
		finally {
			DBManager.close(con, pstmt, null);
		}
	}
	
	public static void t_Search(HttpServletRequest request) {
		Connection con = null;
		PreparedStatement prst = null;
		ResultSet rs = null;
		
		try {
			con = DBManager.connect();
			String sql = "select * from teacher_table";
			prst = con.prepareStatement(sql);
			rs = prst.executeQuery();
			
			ArrayList<TAccount> ta = new ArrayList<TAccount>();
			while (rs.next()) {
				ta.add(new TAccount(rs.getString("t_id"),rs.getString("t_pw"),rs.getString("t_name"),rs.getString("t_phonenumber"),rs.getString("t_gender"),rs.getString("t_text")));
				request.setAttribute("ta", ta);
			}
			
		} catch (Exception e) {
			request.setAttribute("db서버오류", "r");
			e.printStackTrace();
		} finally {
			DBManager.close(con, prst, rs);
		}
	}
	
	public static void t_show(HttpServletRequest request) {
	 	Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            con = DBManager.connect();
            String sql = "select * from apply_table where a_agree=1";
            pstmt = con.prepareStatement(sql);
            rs = pstmt.executeQuery();

            ArrayList<applyBean> applyBeans = new ArrayList<applyBean>();
            
            while (rs.next()) {
            	String id = rs.getString("a_id");
            	String name = rs.getString("a_name");
            	String gender = rs.getString("a_gender");
            	Date start = rs.getDate("a_start");
            	Date end = rs.getDate("a_end");
            	int age = rs.getInt("a_age");
            	String img = rs.getString("a_img");
            	String tname = rs.getString("a_tname");
            	int agree = rs.getInt("a_agree");
            	
            	applyBean a = new applyBean(id, name, gender, start, end, age, tname, img, agree);
            	applyBeans.add(a);
            }
            request.setAttribute("applyBeans", applyBeans);

        } catch (Exception e) {
            request.setAttribute("db서버오류", "r");
            e.printStackTrace();
        } finally {
            DBManager.close(con, pstmt, rs);
        }
    }

public static void t_del(HttpServletRequest request) {
	Connection con = null;
    PreparedStatement pstmt = null;

    try {
        con = DBManager.connect();
        String sql = "delete from apply_table where a_id=?";
        pstmt = con.prepareStatement(sql);
        String id = request.getParameter("id");
        System.out.println(id);
        pstmt.setString(1, id);
	
        if(pstmt.executeUpdate() ==1) {
        	request.setAttribute("r", "삭제성공");
        }else {
        	request.setAttribute("r", "실패");
        }
	} catch (Exception e) {
		request.setAttribute("r", "db문제");
		e.printStackTrace();
	}
}

public static void t_get(HttpServletRequest request) {
	Connection con = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    try {
        con = DBManager.connect();
        String sql = "select * from apply_table where a_id=?";
        pstmt = con.prepareStatement(sql);

        pstmt.setString(1, request.getParameter("id"));
        rs = pstmt.executeQuery();
        applyBean a = null;
        if (rs.next()) {
        	a = new applyBean();
        	a.setA_id(rs.getString("a_id"));
        	a.setA_name(rs.getString("a_name"));
        	a.setA_gender(rs.getString("a_gender"));
        	a.setA_start(rs.getDate("a_start"));
        	a.setA_end(rs.getDate("a_end"));
        	a.setA_age(rs.getInt("a_age"));
        	a.setA_img(rs.getString("a_img"));
        }
        request.setAttribute("applybean", a);
    }catch (Exception e) {
    	e.printStackTrace();
	}
	
}

public static void t_update(HttpServletRequest request) throws IOException {
	 	Connection con = null;
        PreparedStatement pstmt = null;
        
        try {
            con = DBManager.connect();
            String sql = "update apply_table set a_id=?, a_name=?, a_gender=?, a_start=?, a_end=?, a_age=?, a_img=?"
            		+ " where a_id=?";
            pstmt = con.prepareStatement(sql);
            
            String path = request.getServletContext().getRealPath("file");
	        MultipartRequest mr = new MultipartRequest(request, path, 31257280, "utf-8", new DefaultFileRenamePolicy());
	        System.out.println(path);

	        String id = mr.getParameter("id");
	        String name = mr.getParameter("name");
	        String gender = mr.getParameter("gender");
	        String start = mr.getParameter("start");
	        String end = mr.getParameter("end");
	        int age = Integer.parseInt(mr.getParameter("age"));
	        String oldimg = mr.getParameter("img");
	        String newimg = mr.getFilesystemName("img2");

	        System.out.println(id);
	        System.out.println(name);
	        System.out.println(gender);
	        System.out.println(start);
	        System.out.println(end);
	        System.out.println(age);
	        System.out.println(oldimg); 
	        System.out.println(newimg);
	        System.out.println(id);
            
            pstmt.setString(1, id);
            pstmt.setString(2, name);
            pstmt.setString(3, gender);
            pstmt.setString(4, start);
            pstmt.setString(5, end);
            pstmt.setInt(6, age);
            pstmt.setString(8, id);
             
            if(newimg == null) {
            	pstmt.setString(7, oldimg);
            }else {
            	pstmt.setString(7, newimg);
            	String delFile = path +"/" + oldimg;
            	File f = new File(delFile);
            	f.delete();
            }
            
			if (pstmt.executeUpdate() == 1) {
				request.setAttribute("r", "수정 성공");
			} else {
				request.setAttribute("r", "수정 실패");
			}
		} catch (Exception e) {
			request.setAttribute("r", "db문제");
			e.printStackTrace();
		}

		finally {
			DBManager.close(con, pstmt, null);
		}
	}

}
