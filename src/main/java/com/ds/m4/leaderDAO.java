package com.ds.m4;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import com.ds.ct.DBManager;
import com.ds.m5.applyBean;


public class leaderDAO {

	public static void leaderAll(HttpServletRequest request) {
		Connection con = null;
		PreparedStatement prsmt = null;
		ResultSet rs = null;
		
		
		try {
			con = DBManager.connect();
			String sql = "select * from apply_table where a_agree=0 and a_end >= sysdate";
			prsmt = con.prepareStatement(sql);
			rs = prsmt.executeQuery();
			
			ArrayList<applylist> lists = new ArrayList<applylist>();
			applylist l = null;
			while(rs.next()) {
				l = new applylist();
				l.setA_no(rs.getInt("a_no"));
				l.setA_id(rs.getString("a_id"));
				l.setA_name(rs.getString("a_name"));
				l.setA_gender(rs.getString("a_gender"));
				l.setA_start(rs.getDate("a_start"));
				l.setA_end(rs.getDate("a_end"));
				l.setA_age(rs.getInt("a_age"));
				l.setA_img(rs.getString("a_img"));
				l.setA_tname(rs.getString("a_tname"));
				l.setA_agree(rs.getInt("a_agree"));
				lists.add(l);
			}
			request.setAttribute("lists", lists);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			DBManager.close(con, prsmt, rs);
		}	
	}

	public static void delete(HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		int a_no = Integer.parseInt(request.getParameter("a_no"));
		String a_id = request.getParameter("a_id");
		String a_name = request.getParameter("a_name");
		System.out.println(a_no);
		System.out.println(a_id);
		System.out.println(a_name);
		
		try {
			con=DBManager.connect();
			String sql="delete from apply_table where a_no=? and a_id=? and a_name=?";
			pstmt= con.prepareStatement(sql);
			
			pstmt.setInt(1, a_no);
			pstmt.setString(2, a_id);
			pstmt.setString(3, a_name);
			
			int row = pstmt.executeUpdate();
			
			if(row == 1) {
				request.setAttribute("r", "삭제성공");
			}else {
				request.setAttribute("r", "삭제실패");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public static void leaderupdate(HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		int a_no = Integer.parseInt(request.getParameter("a_no"));
		String a_id = request.getParameter("a_id");
		String a_name = request.getParameter("a_name");
		System.out.println(a_no);
		System.out.println(a_id);
		System.out.println(a_name);
		
		try {
			con=DBManager.connect();
			String sql="update apply_table set a_agree=1 where a_no=? and a_id =?and a_name=?";
			pstmt= con.prepareStatement(sql);
			
			pstmt.setInt(1, a_no);
			pstmt.setString(2, a_id);
			pstmt.setString(3, a_name);
			
			int row = pstmt.executeUpdate();
			
			if(row == 1) {
				request.setAttribute("r", "수락성공");
			}else {
				request.setAttribute("r", "수락실패");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	public static int leader_getTotal() {
        int cnt = 0;

        String sql = "Select count(*) cnt from apply_table where a_agree=0 ";
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {

            con = DBManager.connect();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if(rs.next()) {
                cnt = rs.getInt("cnt");
                System.out.println("총게시물수 : "+cnt);
            }//if
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            DBManager.close(con, ps, rs);
        }
        return cnt;

    }
	
	public static void pageView(HttpServletRequest request) {
        
    	String strPg = request.getParameter("pg");
   	 
	    int rowSize = 10; //한페이지에 보여줄 글의 수
	    int pg = 1; //페이지 , list.jsp로 넘어온 경우 , 초기값 =1
	   
	    if(strPg != null){ //list.jsp?pg=2
	        pg = Integer.parseInt(strPg); //.저장
	    }

	    int from = (pg * rowSize) - (rowSize-1); //(1*10)-(10-1)=10-9=1 //from
	    int to=(pg * rowSize); //(1*10) = 10 //to
    	
        ArrayList<applylist> list = new ArrayList<applylist>();
       
        System.out.println(from);
        System.out.println(to);
        
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
       
        //String sql = "select * from board order by num desc";
        String sql = "select rn,a_no,a_id,a_name,a_gender,a_start,a_end,a_age,a_img,a_tname,a_agree"
        		+ " from (select Rownum as rn,a_no,a_id,a_name,a_gender,a_start,a_end,a_age,a_img,a_tname,a_agree"
        		+ " from (select a_no,a_id,a_name,a_gender,a_start,a_end,a_age,a_img,a_tname,a_agree"
        		+ " from apply_table"
        		+ " where a_agree=0"
        		+ " order by a_no desc))"
        		+ " where RN >=? and RN <=?";
  
        try {
           
            con = DBManager.connect();
            ps = con.prepareStatement(sql);
            ps.setInt(1, from);
            ps.setInt(2, to);
           
            rs = ps.executeQuery();
           
            while(rs.next()) {
               
            	applylist a = new applylist();

				a.setA_no(rs.getInt("a_no"));
				a.setA_id(rs.getString("a_id"));
				a.setA_name(rs.getString("a_name"));
				a.setA_gender(rs.getString("a_gender"));
				a.setA_start(rs.getDate("a_start"));
				a.setA_end(rs.getDate("a_end"));
				a.setA_age(rs.getInt("a_age"));
				a.setA_img(rs.getString("a_img"));
				a.setA_tname(rs.getString("a_tname"));
				a.setA_agree(rs.getInt("a_agree"));
				
				list.add(a);
            }
            
           request.setAttribute("list", list);
           
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            DBManager.close(con, ps, rs);
        }
      
    }
	
	public static void page(HttpServletRequest request) {
		String strPg = request.getParameter("pg");
	   	 
	    int rowSize = 10; //한페이지에 보여줄 글의 수
	    int pg = 1; //페이지 , list.jsp로 넘어온 경우 , 초기값 =1
	   
	    if(strPg != null){ //list.jsp?pg=2
	        pg = Integer.parseInt(strPg); //.저장
	    }
	   
	    int total = leader_getTotal(); //총 게시물 수
	    int allPage = (int) Math.ceil(total/(double)rowSize); //페이지수
	    //int totalPage = total/rowSize + (total%rowSize==0?0:1);
	    int block = 10; //한페이지에 보여줄  범위 << [1] [2] [3] [4] [5] [6] [7] [8] [9] [10] >>

	    int fromPage = ((pg-1)/block*block)+1;  //보여줄 페이지의 시작
	    int toPage = ((pg-1)/block*block)+block; //보여줄 페이지의 끝
	    if(toPage> allPage){ // 예) 20>17
	        toPage = allPage;
	    }

	    request.setAttribute("pg", pg);
	    request.setAttribute("block", block);
	    request.setAttribute("fromPage", fromPage);
	    request.setAttribute("toPage", toPage);
	    request.setAttribute("allPage", allPage);
	}
	
	public static void enddate_delete(HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con=DBManager.connect();
			String sql="delete from apply_table where a_end <= sysdate";
			pstmt= con.prepareStatement(sql);

			int row = pstmt.executeUpdate();
			
			if(row == 1) {
				request.setAttribute("r", "삭제성공");
			}else {
				request.setAttribute("r", "삭제실패");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
