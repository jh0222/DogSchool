package com.ds.m5;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.ds.ct.DBManager;
import com.ds.login.Account;
import com.ds.login.TAccount;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;


public class applyDAO {
		
	public static void t_show(HttpServletRequest request) {
		 	Connection con = null;
	        PreparedStatement pstmt = null;
	        ResultSet rs = null;
	        
	        HttpSession hs = request.getSession();
	        Account t = (Account) hs.getAttribute("taccountInfo");	
	        
	        String a_tname = t.getT_name();
	        System.out.println(a_tname);
	        
	        try {
	            con = DBManager.connect();
	            String sql = "select * from apply_table where a_agree=1 and a_tname=?";
	            pstmt = con.prepareStatement(sql);
	            
	            pstmt.setString(1, a_tname);
	            
	            rs = pstmt.executeQuery();

	            ArrayList<applyBean> applyBeans = new ArrayList<applyBean>();
	            
	            while (rs.next()) {
	            	int no = rs.getInt("a_no");
	            	String id = rs.getString("a_id");
	            	String name = rs.getString("a_name");
	            	String gender = rs.getString("a_gender");
	            	Date start = rs.getDate("a_start");
	            	Date end = rs.getDate("a_end");
	            	int age = rs.getInt("a_age");
	            	String img = rs.getString("a_img");
	            	String tname = rs.getString("a_tname");
	            	int agree = rs.getInt("a_agree");
	            	
	            	applyBean a = new applyBean(no,id, name, gender, start, end, age, img, tname, agree);
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
        
		String a_id = request.getParameter("u_id");
		String a_name = request.getParameter("u_name");
		String a_tname = request.getParameter("t_id");
		
		System.out.println(a_id);
		System.out.println(a_name);
		System.out.println(a_tname);
		
        try {
            con = DBManager.connect();
            String sql = "delete from apply_table where a_id=? and a_name =? and a_tname =? ";
            pstmt = con.prepareStatement(sql);
            
			pstmt.setString(1, a_id);
			pstmt.setString(2, a_name);
			pstmt.setString(3, a_tname);
			
		
            if(pstmt.executeUpdate() ==1) {
            	 String sql1 = "delete from mypet_table where mp_tid=? and mp_uid=? and mp_uname=? ";
                 pstmt = con.prepareStatement(sql1);
                 
     			pstmt.setString(1, a_tname);
     			pstmt.setString(2, a_id);
     			pstmt.setString(3, a_name);
     			
	     			if (pstmt.executeUpdate() == 1) {
	               	 String sql2 = "delete from comment_table where c_tid=? and c_uid=? and c_uname=? ";
	                 pstmt = con.prepareStatement(sql2);
	                 
	     			pstmt.setString(1, a_tname);
	     			pstmt.setString(2, a_id);
	     			pstmt.setString(3, a_name);
	     			
		     			if (pstmt.executeUpdate() == 1) {
		     				 String sql3 = "delete from gallery_table where g_tid=? and g_uid=? and g_uname=? ";
			                 pstmt = con.prepareStatement(sql3);
			                 
			     			pstmt.setString(1, a_tname);
			     			pstmt.setString(2, a_id);
			     			pstmt.setString(3, a_name);
				     			if (pstmt.executeUpdate() == 1) {
				     				request.setAttribute("r", "성공");
								} else {
									request.setAttribute("r", "실패");
								}
						} else {
							request.setAttribute("r", "실패");
						}
	    
					} else {
						request.setAttribute("r", "실패");
					}    	
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
            String sql = "select * from apply_table where a_no=?";
            pstmt = con.prepareStatement(sql);
 
            pstmt.setString(1, request.getParameter("a_no"));
            
            rs = pstmt.executeQuery();
            applyBean a = null;
            if (rs.next()) {
            	a = new applyBean();
            	a.setA_no(rs.getInt("a_no"));
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
	            		+ " where a_no=?";
	            pstmt = con.prepareStatement(sql);
	            
	            String path = request.getServletContext().getRealPath("file");
		        MultipartRequest mr = new MultipartRequest(request, path, 31257280, "utf-8", new DefaultFileRenamePolicy());
		        System.out.println(path);
		        
		        int no = Integer.parseInt(mr.getParameter("no"));
		        String id = mr.getParameter("id");
		        String name = mr.getParameter("name");
		        String gender = mr.getParameter("gender");
		        String start = mr.getParameter("start");
		        String end = mr.getParameter("end");
		        int age = Integer.parseInt(mr.getParameter("age"));
		        String oldimg = mr.getParameter("img");
		        String newimg = mr.getFilesystemName("img2");
		        
		        System.out.println("번호"+no);
		        System.out.println(id);
		        System.out.println(name);
		        System.out.println(gender);
		        System.out.println(start);
		        System.out.println(end);
		        System.out.println(age);
		        System.out.println(oldimg); 
		        System.out.println(newimg);
		       
	            
	            pstmt.setString(1, id);
	            pstmt.setString(2, name);
	            pstmt.setString(3, gender);
	            pstmt.setString(4, start);
	            pstmt.setString(5, end);
	            pstmt.setInt(6, age);
	            pstmt.setInt(8, no);
	             
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
	public static int apply_getTotal(HttpServletRequest request) {
        int cnt = 0;

        HttpSession hs = request.getSession();
        Account t = (Account) hs.getAttribute("taccountInfo");

        String a_tname = t.getT_name();
        System.out.println(a_tname);

        String sql = "Select count(*) cnt from apply_table where a_agree=1 and a_tname=?";
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {

            con = DBManager.connect();
            ps = con.prepareStatement(sql);
            ps.setString(1, a_tname);

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
        HttpSession hs = request.getSession();
        Account t = (Account) hs.getAttribute("taccountInfo");    
        
        String a_tname = t.getT_name();
        System.out.println(a_tname);
        
        String strPg = request.getParameter("pg");
        
        int rowSize = 10; //한페이지에 보여줄 글의 수
        int pg = 1; //페이지 , list.jsp로 넘어온 경우 , 초기값 =1
       
        if(strPg != null){ //list.jsp?pg=2
            pg = Integer.parseInt(strPg); //.저장
        }

        int from = (pg * rowSize) - (rowSize-1); //(1*10)-(10-1)=10-9=1 //from
        int to=(pg * rowSize); //(1*10) = 10 //to
        
        ArrayList<applyBean> list = new ArrayList<applyBean>();
       
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
                + " where a_agree=1 and a_tname=?"
                + " order by a_no desc))"
                + " where RN >=? and RN <=?";
  
        try {
           
            con = DBManager.connect();
            ps = con.prepareStatement(sql);
            ps.setString(1, a_tname);
            ps.setInt(2, from);
            ps.setInt(3, to);
           
            rs = ps.executeQuery();
           
            while(rs.next()) {
               
                applyBean a = new applyBean();

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
	   
	    int total = apply_getTotal(request); //총 게시물 수
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

	public static void u_show(HttpServletRequest request) {
			Connection con = null;
	        PreparedStatement pstmt = null;
	        ResultSet rs = null;
	        
	        HttpSession hs = request.getSession();
	        Account u = (Account) hs.getAttribute("uaccountInfo");
	        
	        String a_id = u.getU_id();
	        System.out.println(a_id);
	        
	        try {
	            con = DBManager.connect();
	            String sql = "select * from apply_table where a_agree=1 and a_id=?";
	            pstmt = con.prepareStatement(sql);
	            
	            pstmt.setString(1, a_id);
	            
	            rs = pstmt.executeQuery();

	            ArrayList<applyBean> applyBeans = new ArrayList<applyBean>();
	            
	            while (rs.next()) {
	            	int no = rs.getInt("a_no");
	            	String id = rs.getString("a_id");
	            	String name = rs.getString("a_name");
	            	String gender = rs.getString("a_gender");
	            	Date start = rs.getDate("a_start");
	            	Date end = rs.getDate("a_end");
	            	int age = rs.getInt("a_age");
	            	String img = rs.getString("a_img");
	            	String tname = rs.getString("a_tname");
	            	int agree = rs.getInt("a_agree");
	            	
	            	applyBean a = new applyBean(no,id, name, gender, start, end, age, img, tname, agree);
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
		

}