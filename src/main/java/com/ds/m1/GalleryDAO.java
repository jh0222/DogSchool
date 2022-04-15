package com.ds.m1;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.ds.login.Account;
import com.ds.m4.applylist;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class GalleryDAO {

	public static void galleryinsert(HttpServletRequest request) throws IOException {
		String path = request.getSession().getServletContext().getRealPath("file");
		System.out.println(path);
		
		MultipartRequest mr = new MultipartRequest(request, path, 
				30*1024*1024, // 파일 최대 용량 30mb
				"UTF-8",
				new DefaultFileRenamePolicy());
		
		
		String g_title = mr.getParameter("g_title");
		String g_img = mr.getFilesystemName("g_img");
		String g_tid = mr.getParameter("g_tid");
		String g_uid = mr.getParameter("g_uid");
		String g_uname = mr.getParameter("g_uname");
		
		System.out.println(g_title);
		System.out.println(g_img);
		System.out.println(g_tid);
		System.out.println(g_uid);
		System.out.println(g_uname);
		
		Connection con = null;
		PreparedStatement prst = null;
		
		try {
			con = DBManager.connect();
			String sql = "insert into gallery_table values(gallery_table_seq.nextval,?,?,?,?,?,sysdate)";
			prst = con.prepareStatement(sql);
			
			prst.setString(1, g_title);
			prst.setString(2, g_img);
			prst.setString(3, g_tid);
			prst.setString(4, g_uid);
			prst.setString(5, g_uname);
			
			
			int row = prst.executeUpdate();
			
			if(row == 1) {
				request.setAttribute("r", "이미지등록성공");
			}else {
				request.setAttribute("r", "이미지등록실패");
			}
		} catch (Exception e) {
			e.getStackTrace();
			request.setAttribute("r", "DB문제");
		}finally {
			DBManager.close(con, prst, null);
		}
	}

	public static void getgrdesc5(HttpServletRequest request) {
		Connection con = null;
		PreparedStatement prst = null;
		ResultSet rs = null;
		
		HttpSession session = request.getSession();
		applylist n = (applylist)session.getAttribute("applyBean");
		
		String G_tid = n.getA_tname();
		String G_uid = n.getA_id();
		String G_uname = n.getA_name();
		
		 System.out.println(G_tid);
		 System.out.println(G_uid);
		 System.out.println(G_uname);
		
		 try {
				con = DBManager.connect();
				String sql = "select * from(select * from gallery_table where g_tid=? and g_uid=? and g_uname=? order by g_date desc )where rownum <= 5";
				prst = con.prepareStatement(sql);
				prst.setString(1, G_tid);
				prst.setString(2, G_uid);
				prst.setString(3, G_uname);
				
				rs = prst.executeQuery();
				
				ArrayList<gallery> gy = new ArrayList<gallery>();
				while(rs.next()) {
					gy.add(new gallery(rs.getInt("g_no"),rs.getString("g_title"),rs.getString("g_img"),rs.getString("g_tid"),rs.getString("g_uid"),rs.getString("g_uname"),rs.getDate("g_date")));
					request.setAttribute("gallery", gy);
				}
				
				request.setAttribute("r", "조회성공");
				
				
			} catch (Exception e) {
				e.getStackTrace();
				request.setAttribute("r", "DB문제");
				
			}finally {
				DBManager.close(con, prst, rs);
			}
	}

	public static void getgalleryAll(HttpServletRequest request) {
		Connection con = null;
		PreparedStatement prst = null;
		ResultSet rs = null;
		
		HttpSession session = request.getSession();
		applylist n = (applylist)session.getAttribute("applyBean");
		
		String G_tid = n.getA_tname();
		String G_uid = n.getA_id();
		String G_uname = n.getA_name();
		
		 System.out.println(G_tid);
		 System.out.println(G_uid);
		 System.out.println(G_uname);
		
		try {
			con = DBManager.connect();
			String sql = "select * from gallery_table where g_tid=? and g_uid=? and g_uname=? order by g_date desc";
			prst = con.prepareStatement(sql);
			prst.setString(1, G_tid);
			prst.setString(2, G_uid);
			prst.setString(3, G_uname);
			
			rs = prst.executeQuery();
			
			ArrayList<gallery> gy = new ArrayList<gallery>();
			while(rs.next()) {
				gy.add(new gallery(rs.getInt("g_no"),rs.getString("g_title"),rs.getString("g_img"),rs.getString("g_tid"),rs.getString("g_uid"),rs.getString("g_uname"),rs.getDate("g_date")));
				request.setAttribute("gallery", gy);
			}
			
			request.setAttribute("r", "상세 조회성공");
			
			
		} catch (Exception e) {
			e.getStackTrace();
			request.setAttribute("r", "DB문제");
			
		}finally {
			DBManager.close(con, prst, rs);
		}
		
		
	}

	public static void getgallery(HttpServletRequest request) {
		Connection con = null;
		PreparedStatement prst = null;
		ResultSet rs = null;
		

		int g_no = Integer.parseInt(request.getParameter("g_no"));
		System.out.println("getgallery: "+g_no);
		
		
		try {
			con = DBManager.connect();
			String sql = "select* from gallery_table where g_no =?";
			prst = con.prepareStatement(sql);
			
			prst.setInt(1, g_no);
		
			rs = prst.executeQuery();
			
			
			if(rs.next()) {
				gallery gy = new gallery(rs.getInt("g_no"),rs.getString("g_title"),rs.getString("g_img"),rs.getString("g_tid"),rs.getString("g_uid"),rs.getString("g_uname"),rs.getDate("g_date"));
				request.setAttribute("gallery", gy);
			}
			
			request.setAttribute("r", "상세 조회성공");
			
			
		} catch (Exception e) {
			e.getStackTrace();
			request.setAttribute("r", "DB문제");
			
		}finally {
			DBManager.close(con, prst, rs);
		}
		
	}

	public static void galleryDetaildelete(HttpServletRequest request) {
		Connection con = null;
		PreparedStatement prst = null;
		
		int g_no = Integer.parseInt(request.getParameter("g_no"));
		System.out.println(g_no);
		
		try {
			con = DBManager.connect();
			String sql = "delete from gallery_table where g_no =?";
			prst = con.prepareStatement(sql);
			prst.setInt(1,g_no);
			
			int row = prst.executeUpdate();
			
			if(row == 1) {
				request.setAttribute("r", "삭제성공");
			}else {
				request.setAttribute("r", "삭제실패");
			}
			
			
		} catch (Exception e) {
			e.getStackTrace();
			request.setAttribute("r", "DB문제");
			
		}finally {
			DBManager.close(con, prst, null);
		}
		
	}

	public static void galleryUpdate(HttpServletRequest request) throws IOException {
		String path = request.getSession().getServletContext().getRealPath("file");
		System.out.println(path);
		
		HttpSession hs = request.getSession();
	    Account t = (Account) hs.getAttribute("taccountInfo");	
		
	    String t_id = t.getT_id();
	    String t_pw = t.getT_pw();
	    
	    System.out.println(t_id);
	    System.out.println(t_pw);
	    
		MultipartRequest mr = new MultipartRequest(request, path, 
				30*1024*1024, // 파일 최대 용량 30mb
				"UTF-8",
				new DefaultFileRenamePolicy());
		
		int g_no = Integer.parseInt(mr.getParameter("g_no"));
		String g_title = mr.getParameter("g_title");
		String g_img = mr.getParameter("g_img");
		String g_img1 = mr.getFilesystemName("g_img1");
		
		System.out.println(g_no);
		System.out.println(g_title);
		System.out.println(g_img);
		System.out.println(g_img1);
		
		Connection con =null;
		PreparedStatement prst = null;
		try {
			con = DBManager.connect();
			String sql = "update gallery_table set g_title=?, g_img=? where g_no=?";
			prst = con.prepareStatement(sql);
		
			prst.setString(1, g_title);
			
			if(g_img1 == null) {
				prst.setString(2, g_img);
			}else {
				prst.setString(2, g_img1);
			}
			
			prst.setInt(3, g_no);
			
			int row =  prst.executeUpdate();
			
			if(row == 1) {
				request.setAttribute("check", "수정성공");
				
			}
			else {
				request.setAttribute("check", "수정실패");
			}
			
			request.setAttribute("idd", t_id);
			request.setAttribute("pww", t_pw);
			
		} catch (Exception e) {
			
			e.getStackTrace();
			request.setAttribute("check", "DB서버 문제");
		}finally {
			
			DBManager.close(con, prst, null);
		}
		
	}

	public static int getTotal_gallery(HttpServletRequest request) {
		 int cnt = 0;
		 
			HttpSession session = request.getSession();
			applylist n = (applylist)session.getAttribute("applyBean");
			
			String G_tid = n.getA_tname();
			String G_uid = n.getA_id();
			String G_uname = n.getA_name();
	       
	        Connection con = null;
	        PreparedStatement ps = null;
	        ResultSet rs = null;
	       
	        try {
	           
	            con = DBManager.connect();
		        String sql = "Select count(*) cnt from gallery_table where g_tid=? and g_uid=? and g_uname=? ";
	            ps = con.prepareStatement(sql);
	            
	            ps.setString(1, G_tid);
	            ps.setString(2, G_uid);
	            ps.setString(3, G_uname);
	            
	            rs = ps.executeQuery();
	            if(rs.next()) {
	                cnt = rs.getInt("cnt");
	                System.out.println("총 사진수 : "+cnt);
	            }//if          
	        } catch (Exception e) {
	            e.printStackTrace();
	        }finally {         
	            DBManager.close(con, ps, rs);
	        }      
	        return cnt;
		
	}

	public static void pageView_gallery(HttpServletRequest request) {
   	String strPg = request.getParameter("pg");
   	
		HttpSession session = request.getSession();
		applylist n = (applylist)session.getAttribute("applyBean");
		
		String G_tid = n.getA_tname();
		String G_uid = n.getA_id();
		String G_uname = n.getA_name();
		
		 System.out.println(G_tid);
		 System.out.println(G_uid);
		 System.out.println(G_uname);
     	 
	    int rowSize = 10; //한페이지에 보여줄 글의 수
	    int pg = 1; //페이지 , list.jsp로 넘어온 경우 , 초기값 =1
	   
	    if(strPg != null){ //list.jsp?pg=2
	        pg = Integer.parseInt(strPg); //.저장
	    }

	    int from = (pg * rowSize) - (rowSize-1); //(1*10)-(10-1)=10-9=1 //from
	    int to=(pg * rowSize); //(1*10) = 10 //to
   	
      
       System.out.println(from);
       System.out.println(to);
       
       Connection con = null;
       PreparedStatement ps = null;
       ResultSet rs = null;
      
       //String sql = "select * from board order by num desc";
       String sql = "select rw,g_no, g_title, g_img, g_tid,g_uid,g_uname , g_date"
       		+ " from(select Rownum as rw, g_no, g_title, g_img, g_tid,g_uid,g_uname , g_date"
       		+ "	 	from(select g_no, g_title, g_img, g_tid,g_uid,g_uname , g_date"
       		+ "				from gallery_table"
       		+ "				where g_tid=? and g_uid=? and g_uname=? "
       		+ "				order by g_no DESC ))"
       		+ "where rw >= ? and rw <=?";
 
       try {
          
           con = DBManager.connect();
           ps = con.prepareStatement(sql);
           ps.setString(1, G_tid);
           ps.setString(2, G_uid);
           ps.setString(3, G_uname);
           ps.setInt(4, from);
           ps.setInt(5, to);
          
           rs = ps.executeQuery();
          
			ArrayList<gallery> gy = new ArrayList<gallery>();
			while(rs.next()) {
				gy.add(new gallery(rs.getInt("g_no"),rs.getString("g_title"),rs.getString("g_img"),rs.getString("g_tid"),rs.getString("g_uid"),rs.getString("g_uname"),rs.getDate("g_date")));
				request.setAttribute("gallery", gy);
			}
 
          
       } catch (Exception e) {
           e.printStackTrace();
       }finally {
           DBManager.close(con, ps, rs);
		
	}
}

	public static void page_gallery(HttpServletRequest request) {
		String strPg = request.getParameter("pg");
	   	 
	    int rowSize = 10; //한페이지에 보여줄 글의 수
	    int pg = 1; //페이지 , list.jsp로 넘어온 경우 , 초기값 =1
	   
	    if(strPg != null){ //list.jsp?pg=2
	        pg = Integer.parseInt(strPg); //.저장
	    }
	   
	    int total = getTotal_gallery(request); //총 게시물 수
	    System.out.println(total);
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
