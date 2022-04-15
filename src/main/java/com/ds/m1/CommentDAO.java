package com.ds.m1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.ds.m4.applylist;

public class CommentDAO {

	public static void commentinsert(HttpServletRequest request) {
		Connection con = null;
		PreparedStatement prst = null;
		
		HttpSession session = request.getSession();
		applylist n = (applylist)session.getAttribute("applyBean");
		
		int c_mp_no = Integer.parseInt(request.getParameter("mp_no"));		
		String c_tid = request.getParameter("a_tname"); 
		String c_uid = n.getA_id();
		String c_uname = n.getA_name();
		String c_txt = request.getParameter("c_txt");
		
		try {
			con = DBManager.connect();
			String sql = "insert into comment_table values(comment_table_seq.nextval,?,?,?,?,?,?,sysdate)";
			prst = con.prepareStatement(sql);
			
			prst.setInt(1, c_mp_no);
			prst.setString(2, c_tid);
			prst.setString(3, c_uid);
			prst.setString(4, c_uname);
			prst.setString(5, c_txt);
			prst.setString(6, c_tid);
			
			
			int row = prst.executeUpdate();
			
			if(row == 1) {
				request.setAttribute("c", "댓글등록성공");
			}else {
				request.setAttribute("c", "댓글등록실패");
			}
			
			
		} catch (Exception e) {
			e.getStackTrace();
			request.setAttribute("r", "DB문제");
			
		}finally {
			DBManager.close(con, prst, null);
		}
	}

	public static void getcommentALL(HttpServletRequest request) {
		Connection con = null;
		PreparedStatement prst = null;
		ResultSet rs = null;
		
		int c_mp_no = Integer.parseInt(request.getParameter("mp_no"));
		System.out.println(c_mp_no);
		
		try {
			con = DBManager.connect();
			String sql = "select * from comment_table where c_mp_no =? order by c_date desc ";
			prst = con.prepareStatement(sql);
			prst.setInt(1, c_mp_no);
			
			rs = prst.executeQuery();
			
			
			ArrayList<comment> cm = new ArrayList<comment>();
			while(rs.next()) {
				cm.add(new comment(rs.getInt("c_no"),rs.getInt("c_mp_no"),rs.getString("c_tid"),rs.getString("c_uid"),rs.getString("c_uname"),rs.getString("c_txt"),rs.getString("c_writer"),rs.getDate("c_date")));
				request.setAttribute("comment", cm);
			}
			
			request.setAttribute("r", "조회성공");
			
			
		} catch (Exception e) {
			e.getStackTrace();
			request.setAttribute("r", "DB문제");
			
		}finally {
			DBManager.close(con, prst, rs);
		}
		
	}
	
	public static void Commentdelete(HttpServletRequest request) {
		Connection con = null;
		PreparedStatement prst = null;
		
		int mp_no = Integer.parseInt(request.getParameter("mp_no"));
		System.out.println(mp_no);
		int c_no = Integer.parseInt(request.getParameter("c_no"));
		System.out.println(c_no);
		
		try {
			con = DBManager.connect();
			String sql = "delete from comment_table where c_no =?";
			prst = con.prepareStatement(sql);

			prst.setInt(1,c_no);
			
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
	public static void Commentalldelete(HttpServletRequest request) {
		Connection con = null;
		PreparedStatement prst = null;
		
		int mp_no = Integer.parseInt(request.getParameter("mp_no"));
		System.out.println("Commentalldelete"+mp_no);
		
		try {
			con = DBManager.connect();
			String sql = "delete from comment_table where c_mp_no =?";
			prst = con.prepareStatement(sql);

			prst.setInt(1,mp_no);
			
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

	public static void CommentUpdate(HttpServletRequest request) {
		Connection con = null;
		PreparedStatement prst = null;
		
		
		int c_no = Integer.parseInt(request.getParameter("c_no"));
		String c_txt = request.getParameter("c_txt"); 
		String c_txt1 = " ";
		
		System.out.println("댓글번호");
		System.out.println(c_no);
		System.out.println(c_txt);
		
		try {
			con = DBManager.connect();
			String sql = "update comment_table set c_txt=? where c_no=?";
			prst = con.prepareStatement(sql);
			
			if(c_txt.equals("")) {
				prst.setString(1, c_txt1);
			}else {
				prst.setString(1, c_txt);
			}
			
			prst.setInt(2, c_no);
		
			int row = prst.executeUpdate();
			
			if(row == 1) {
				request.setAttribute("c", "댓글수정성공");
			}else {
				request.setAttribute("c", "댓글수정실패");
			}
			
			
		} catch (Exception e) {
			e.getStackTrace();
			request.setAttribute("c", "DB문제");
			
		}finally {
			DBManager.close(con, prst, null);
		}		
	}

	public static int getTotal_comment(HttpServletRequest request) {
		 int cnt = 0;
	     
			HttpSession session = request.getSession();
			applylist n = (applylist)session.getAttribute("applyBean");
			
			String Mp_tid = n.getA_tname();
			String Mp_uid = n.getA_id();
			String Mp_uname = n.getA_name();
	       
	        Connection con = null;
	        PreparedStatement ps = null;
	        ResultSet rs = null;
	       
	        try {
	            con = DBManager.connect();
	            String sql = "Select count(*) cnt from comment_table where c_tid=? and c_uid=? and c_uname=?";
	            ps = con.prepareStatement(sql);
	            
	            ps.setString(1, Mp_tid);
	            ps.setString(2, Mp_uid);
	            ps.setString(3, Mp_uname);
	            
	            rs = ps.executeQuery();
	            if(rs.next()) {
	                cnt = rs.getInt("cnt");
	                System.out.println("총 댓글수 : "+cnt);
	            }//if          
	        } catch (Exception e) {
	            e.printStackTrace();
	        }finally {         
	            DBManager.close(con, ps, rs);
	        }      
	        return cnt;
		
	}
	
	public static void pageView_comment(HttpServletRequest request) {
	   	String strPg = request.getParameter("pg");
	     	 
		    int rowSize = 5; //한페이지에 보여줄 글의 수
		    int pg = 1; //페이지 , list.jsp로 넘어온 경우 , 초기값 =1
		   
		    if(strPg != null){ //list.jsp?pg=2
		        pg = Integer.parseInt(strPg); //.저장
		    }

		    int from = (pg * rowSize) - (rowSize-1); //(1*10)-(10-1)=10-9=1 //from
		    int to=(pg * rowSize); //(1*10) = 10 //to
		    
			int c_mp_no = Integer.parseInt(request.getParameter("mp_no"));
			System.out.println(c_mp_no);
	      
	       System.out.println(from);
	       System.out.println(to);
	       
	       Connection con = null;
	       PreparedStatement ps = null;
	       ResultSet rs = null;
	      
	       //String sql = "select * from board order by num desc";
	       String sql = "select rw,c_no, c_mp_no, c_tid, c_uid,c_uname,c_txt,c_writer, c_date"
	       		+ " from(select Rownum as rw, c_no, c_mp_no, c_tid, c_uid,c_uname,c_txt,c_writer, c_date"
	       		+ "	 	from(select c_no, c_mp_no, c_tid, c_uid,c_uname,c_txt ,c_writer, c_date"
	       		+ "				from comment_table"
	       		+ "				where c_mp_no =?"	
	       		+ "				order by c_no DESC ))"
	       		+ "where rw >= ? and rw <=?";
	 
	       try {
	          
	           con = DBManager.connect();
	           ps = con.prepareStatement(sql);
	           ps.setInt(1, c_mp_no);
	           ps.setInt(2, from);
	           ps.setInt(3, to);
	          
	           rs = ps.executeQuery();
	          
	            ArrayList<comment> cm = new ArrayList<comment>();
				while(rs.next()) {
					cm.add(new comment(rs.getInt("c_no"),rs.getInt("c_mp_no"),rs.getString("c_tid"),rs.getString("c_uid"),rs.getString("c_uname"),rs.getString("c_txt"),rs.getString("c_writer"),rs.getDate("c_date")));
					request.setAttribute("comment", cm);
				}
	 
	          
	       } catch (Exception e) {
	           e.printStackTrace();
	       }finally {
	           DBManager.close(con, ps, rs);
			
		}
	}
	public static void page_comment(HttpServletRequest request) {
		String strPg = request.getParameter("pg");
	   	 
	    int rowSize = 5; //한페이지에 보여줄 글의 수
	    int pg = 1; //페이지 , list.jsp로 넘어온 경우 , 초기값 =1
	   
	    if(strPg != null){ //list.jsp?pg=2
	        pg = Integer.parseInt(strPg); //.저장
	    }
	   
	    int total = getTotal_comment(request); //총 게시물 수
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

	public static void commentinsert_U(HttpServletRequest request) {
		Connection con = null;
		PreparedStatement prst = null;
		
		HttpSession session = request.getSession();
		applylist n = (applylist)session.getAttribute("applyBean");
		
		int c_mp_no = Integer.parseInt(request.getParameter("mp_no"));		
		String c_tid = request.getParameter("a_tname"); 
		String c_uid = n.getA_id();
		String c_uname = n.getA_name();
		String c_txt = request.getParameter("c_txt");
		
		try {
			con = DBManager.connect();
			String sql = "insert into comment_table values(comment_table_seq.nextval,?,?,?,?,?,?,sysdate)";
			prst = con.prepareStatement(sql);
			
			prst.setInt(1, c_mp_no);
			prst.setString(2, c_tid);
			prst.setString(3, c_uid);
			prst.setString(4, c_uname);
			prst.setString(5, c_txt);
			prst.setString(6, c_uid);
			
			
			int row = prst.executeUpdate();
			
			if(row == 1) {
				request.setAttribute("c", "댓글등록성공");
			}else {
				request.setAttribute("c", "댓글등록실패");
			}
			
			
		} catch (Exception e) {
			e.getStackTrace();
			request.setAttribute("r", "DB문제");
			
		}finally {
			DBManager.close(con, prst, null);
		}
		
	}




}
