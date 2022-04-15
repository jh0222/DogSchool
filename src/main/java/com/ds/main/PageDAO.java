package com.ds.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import com.ds.ct.DBManager;

public class PageDAO {
	
	//전체 글의 수 얻기
	   
    public static int getTotal() {
        int cnt = 0;
       
        String sql = "Select count(*) cnt from notice_table";
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
    
    public static int postscript_getTotal() {
        int cnt = 0;
       
        String sql = "Select count(*) cnt from postscript_table";
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
    	
        ArrayList<Notice> list = new ArrayList<Notice>();
       
        System.out.println(from);
        System.out.println(to);
        
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
       
        //String sql = "select * from board order by num desc";
        String sql = "select rn, n_no,n_id,n_title,n_txt,n_date"
        		+ " from (select Rownum as rn,n_no,n_id,n_title,n_txt,n_date"
        		+ " from (select n_no,n_id,n_title,n_txt,n_date"
        		+ " from notice_table"
        		+ " order by n_no desc))"
        		+ " where RN >=? and RN <=?";
  
        try {
           
            con = DBManager.connect();
            ps = con.prepareStatement(sql);
            ps.setInt(1, from);
            ps.setInt(2, to);
           
            rs = ps.executeQuery();
           
            while(rs.next()) {
               
                Notice n = new Notice();
                
                n.setN_no(rs.getInt("n_no"));
                n.setN_id(rs.getString("n_id"));
                n.setN_title(rs.getString("n_title"));
                n.setN_txt(rs.getString("n_txt"));
                n.setN_date(rs.getDate("n_date"));
                
				list.add(n);
            }
            
           request.setAttribute("list", list);
           
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            DBManager.close(con, ps, rs);
        }
      
    }
    
    public static void postscript_pageView(HttpServletRequest request) {
        
    	String strPg = request.getParameter("pg");
   	 
	    int rowSize = 10; //한페이지에 보여줄 글의 수
	    int pg = 1; //페이지 , list.jsp로 넘어온 경우 , 초기값 =1
	   
	    if(strPg != null){ //list.jsp?pg=2
	        pg = Integer.parseInt(strPg); //.저장
	    }

	    int from = (pg * rowSize) - (rowSize-1); //(1*10)-(10-1)=10-9=1 //from
	    int to=(pg * rowSize); //(1*10) = 10 //to
    	
        ArrayList<Postscript> list = new ArrayList<Postscript>();
       
        System.out.println(from);
        System.out.println(to);
        
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
       
        //String sql = "select * from board order by num desc";
        String sql = "select rn, p_no,p_id,p_title,p_txt,p_date"
        		+ " from (select Rownum as rn,p_no,p_id,p_title,p_txt,p_date"
        		+ " from (select p_no,p_id,p_title,p_txt,p_date"
        		+ " from postscript_table"
        		+ " order by p_no desc))"
        		+ " where RN >=? and RN <=?";
  
        try {
           
            con = DBManager.connect();
            ps = con.prepareStatement(sql);
            ps.setInt(1, from);
            ps.setInt(2, to);
           
            rs = ps.executeQuery();
           
            while(rs.next()) {
               
            	Postscript p = new Postscript();
                
            	p.setP_no(rs.getInt("p_no"));
				p.setP_id(rs.getString("p_id"));
				p.setP_title(rs.getString("p_title"));
				p.setP_txt(rs.getString("p_txt"));
				p.setP_date(rs.getDate("p_date"));
				list.add(p);
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
	   
	    int total = getTotal(); //총 게시물 수
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
	
	public static void postscript_page(HttpServletRequest request) {
		String strPg = request.getParameter("pg");
	   	 
	    int rowSize = 10; //한페이지에 보여줄 글의 수
	    int pg = 1; //페이지 , list.jsp로 넘어온 경우 , 초기값 =1
	   
	    if(strPg != null){ //list.jsp?pg=2
	        pg = Integer.parseInt(strPg); //.저장
	    }
	   
	    int total = postscript_getTotal(); //총 게시물 수
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
}
