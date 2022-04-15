package com.ds.m1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.ds.login.Account;
import com.ds.m4.applylist;

public class notice_notebookDAO {
	public static void nnoteinsert(HttpServletRequest request) {
		Connection con = null;
		PreparedStatement prst = null;
	
		System.out.println("----");
		String mp_title = request.getParameter("mp_title");
		String mp_condition = request.getParameter("mp_condition");
		String mp_condition1 = "특이사항 없음";
		int mp_meal = Integer.parseInt(request.getParameter("mp_meal"));
		int mp_defecate = Integer.parseInt(request.getParameter("mp_defecate"));
		String mp_supplies = request.getParameter("mp_supplies");
		String mp_supplies1 = "특이사항 없음";
		String mp_txt = request.getParameter("mp_txt");
		String mp_txt1 = "특이사항 없음";
		String mp_tid = request.getParameter("mp_tid");
		String mp_uid = request.getParameter("mp_uid");
		String mp_uname = request.getParameter("mp_uname");

		
		System.out.println(mp_title);
		System.out.println(mp_condition);
		System.out.println(mp_condition1);
		System.out.println(mp_meal);
		System.out.println(mp_defecate);
		System.out.println(mp_supplies);
		System.out.println(mp_supplies1);
		System.out.println(mp_txt);
		System.out.println(mp_txt1);
		System.out.println(mp_tid);
		System.out.println(mp_uid);
		System.out.println(mp_uname);
		
		try {
			con = DBManager.connect();
			String sql = "insert into mypet_table values(mypet_table_seq.nextval,?,?,?,?,?,?,?,?,?,sysdate)";
			prst = con.prepareStatement(sql);
			
			prst.setString(1,mp_title);
			
			if(mp_condition.equals("")) {
				prst.setString(2, mp_condition1);
			}else {
				prst.setString(2, mp_condition);
			}
			
			prst.setInt(3, mp_meal);
			prst.setInt(4, mp_defecate);
			
			if(mp_supplies.equals("")) {
				prst.setString(5, mp_supplies1);
			}else {
				prst.setString(5, mp_supplies);
			}
			
			if(mp_txt.equals("")) {
				prst.setString(6, mp_txt1);
			}else {
				prst.setString(6, mp_txt);
			}
			
			prst.setString(7, mp_tid);
			prst.setString(8, mp_uid);
			prst.setString(9, mp_uname);
			int row = prst.executeUpdate();
			
			if(row == 1) {
				request.setAttribute("r", "등록성공");
			}else {
				request.setAttribute("r", "등록실패");
			}
			
			
		} catch (Exception e) {
			e.getStackTrace();
			request.setAttribute("r", "DB문제");
			
		}finally {
			DBManager.close(con, prst, null);
		}
		
		
	}

	public static void getnndesc5(HttpServletRequest request) {
		Connection con = null;
		PreparedStatement prst = null;
		ResultSet rs = null;
		
		HttpSession session = request.getSession();
		applylist n = (applylist)session.getAttribute("applyBean");
		
		 String Mp_tid = n.getA_tname();
		 String Mp_uid = n.getA_id();
		 String Mp_uname = n.getA_name();
		 
		 System.out.println(Mp_tid);
		 System.out.println(Mp_uid);
		 System.out.println(Mp_uname);
		
		try {
			con = DBManager.connect();
			String sql = "select *"
					+ "from(select * from mypet_table where mp_tid=? and mp_uid=? and mp_uname=? order by mp_no desc )"
					+ "where rownum <= 5";
			prst = con.prepareStatement(sql);
			prst.setString(1, Mp_tid);
			prst.setString(2, Mp_uid);
			prst.setString(3, Mp_uname);
			
			
			rs = prst.executeQuery();
			
			ArrayList<nnotebook> nn = new ArrayList<nnotebook>();
			while(rs.next()) {
				nn.add(new nnotebook(rs.getInt("mp_no"),rs.getString("mp_title"),rs.getString("mp_condition"),rs.getInt("mp_meal"),rs.getInt("mp_defecate"),rs.getString("mp_supplies"),rs.getString("mp_txt"),rs.getString("mp_tid"),rs.getString("mp_uid"),rs.getString("mp_uname"),rs.getDate("mp_date")));
				request.setAttribute("nnotebook", nn);
			}
			
			request.setAttribute("r", "조회성공");
			
			
		} catch (Exception e) {
			e.getStackTrace();
			request.setAttribute("r", "DB문제");
			
		}finally {
			DBManager.close(con, prst, rs);
		}
		
	}

	public static void getnnALL(HttpServletRequest request) {
		Connection con = null;
		PreparedStatement prst = null;
		ResultSet rs = null;
		
		HttpSession session = request.getSession();
		applylist n = (applylist)session.getAttribute("applyBean");
		
		 String Mp_tid = n.getA_tname();
		 String Mp_uid = n.getA_id();
		 String Mp_uname = n.getA_name();
		 
		 System.out.println("all?");
		 System.out.println(Mp_tid);
		 System.out.println(Mp_uid);
		 System.out.println(Mp_uname);
		
		try {
			con = DBManager.connect();
			String sql = "select * from mypet_table where mp_tid=? and mp_uid=? and mp_uname=? order by mp_date desc";
	
			prst = con.prepareStatement(sql);
			prst.setString(1, Mp_tid);
			prst.setString(2, Mp_uid);
			prst.setString(3, Mp_uname);
			
			
			rs = prst.executeQuery();
			
			ArrayList<nnotebook> nn = new ArrayList<nnotebook>();
			while(rs.next()) {
				nn.add(new nnotebook(rs.getInt("mp_no"),rs.getString("mp_title"),rs.getString("mp_condition"),rs.getInt("mp_meal"),rs.getInt("mp_defecate"),rs.getString("mp_supplies"),rs.getString("mp_txt"),rs.getString("mp_tid"),rs.getString("mp_uid"),rs.getString("mp_uname"),rs.getDate("mp_date")));
				request.setAttribute("nnotebook", nn);
			}
			
			request.setAttribute("r", "조회성공");
			
			
		} catch (Exception e) {
			e.getStackTrace();
			request.setAttribute("r", "DB문제");
			
		}finally {
			DBManager.close(con, prst, rs);
		}
		
	}

	public static void getnn(HttpServletRequest request) {
		Connection con = null;
		PreparedStatement prst = null;
		ResultSet rs = null;
		
		try {
			con = DBManager.connect();
			String sql = "select * from mypet_table where mp_no =?";
			prst = con.prepareStatement(sql);
			int no = Integer.parseInt(request.getParameter("mp_no"));
			prst.setInt(1,no);
			
			rs = prst.executeQuery();
			
			
			if(rs.next()) {
				nnotebook nn = new nnotebook(rs.getInt("mp_no"),rs.getString("mp_title"),rs.getString("mp_condition"),rs.getInt("mp_meal"),rs.getInt("mp_defecate"),rs.getString("mp_supplies"),rs.getString("mp_txt"),rs.getString("mp_tid"),rs.getString("mp_uid"),rs.getString("mp_uname"),rs.getDate("mp_date"));
				request.setAttribute("nnotebook", nn);
			}
			
			request.setAttribute("r", "상세 조회성공");
			
			
		} catch (Exception e) {
			e.getStackTrace();
			request.setAttribute("r", "DB문제");
			
		}finally {
			DBManager.close(con, prst, rs);
		}
		
	}

	public static void nnUpdate(HttpServletRequest request) {
		Connection con = null;
		PreparedStatement prst = null;
		
		HttpSession hs = request.getSession();
	    Account t = (Account) hs.getAttribute("taccountInfo");	
		
	    String t_id = t.getT_id();
	    String t_pw = t.getT_pw();
	    
	    
		int mp_no = Integer.parseInt(request.getParameter("mp_no"));
		String mp_title = request.getParameter("mp_title");
		String mp_condition = request.getParameter("mp_condition");
		String mp_condition1 = "특이사항 없음";
		int mp_meal = Integer.parseInt(request.getParameter("mp_meal"));
		int mp_defecate = Integer.parseInt(request.getParameter("mp_defecate"));
		String mp_supplies = request.getParameter("mp_supplies");
		String mp_supplies1 = "준비물 없음";
		String mp_txt = request.getParameter("mp_txt");
		String mp_txt1 = "특이사항 없음";

		
		try {
			con = DBManager.connect();
			String sql = "update mypet_table set mp_title=?,mp_condition=?,mp_meal=?,mp_defecate=?,mp_supplies=?,mp_txt=? where mp_no=?";
			prst = con.prepareStatement(sql);

			prst.setString(1,mp_title);
			
			if(mp_condition.equals("")) {
				prst.setString(2, mp_condition1);
			}else {
				prst.setString(2, mp_condition);
			}
			
			prst.setInt(3, mp_meal);
			prst.setInt(4, mp_defecate);
			
			if(mp_supplies.equals("")) {
				prst.setString(5, mp_supplies1);
			}else {
				prst.setString(5, mp_supplies);
			}
			
			if(mp_txt.equals("")) {
				prst.setString(6, mp_txt1);
			}else {
				prst.setString(6, mp_txt);
			}
			prst.setInt(7, mp_no);
			
			int row = prst.executeUpdate();
			
			if(row == 1) {
				request.setAttribute("r", "수정성공");
			}else {
				request.setAttribute("r", "수정실패");
			}
			
			request.setAttribute("idd", t_id);
			request.setAttribute("pww", t_pw);
			
		} catch (Exception e) {
			e.getStackTrace();
			request.setAttribute("r", "DB문제");
			
		}finally {
			DBManager.close(con, prst, null);
		}	
		
	}
	public static void nnDetaildelete(HttpServletRequest request) {
		Connection con = null;
		PreparedStatement prst = null;
		
		int mp_no = Integer.parseInt(request.getParameter("mp_no"));
		System.out.println("nnDetaildelete"+mp_no);
		
		try {
			con = DBManager.connect();
			String sql = "delete from mypet_table where mp_no =?";
			prst = con.prepareStatement(sql);
			int no = Integer.parseInt(request.getParameter("mp_no"));
			System.out.println(no);
			prst.setInt(1,no);
			
			
			
			int row = prst.executeUpdate();
			
			if(row == 1) {
				String sql1 = "delete from mypet_table where mp_no =?";
				
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
	
    public static int getTotal(HttpServletRequest request) {
		HttpSession session = request.getSession();
		applylist n = (applylist)session.getAttribute("applyBean");
		
		String Mp_tid = n.getA_tname();
		String Mp_uid = n.getA_id();
		String Mp_uname = n.getA_name();
		
        int cnt = 0;
       
        
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            con = DBManager.connect();

            String sql = "Select count(*) cnt from mypet_table where mp_tid=? and mp_uid=? and mp_uname=? ";
            ps = con.prepareStatement(sql);
           
            ps.setString(1, Mp_tid);
            ps.setString(2, Mp_uid);
            ps.setString(3, Mp_uname);
            
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
		HttpSession session = request.getSession();
		applylist n = (applylist)session.getAttribute("applyBean");
		
		String Mp_tid = n.getA_tname();
		String Mp_uid = n.getA_id();
		String Mp_uname = n.getA_name();
        
    	String strPg = request.getParameter("pg");
   	 
	    int rowSize = 5; //한페이지에 보여줄 글의 수
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
        String sql = "select rw, mp_no, mp_title, mp_condition, mp_meal, mp_defecate, mp_supplies, mp_txt, mp_tid,mp_uid,mp_uname, mp_date"
        		+ " from(select Rownum as rw, mp_no, mp_title, mp_condition, mp_meal, mp_defecate, mp_supplies, mp_txt,  mp_tid,mp_uid,mp_uname, mp_date"
        		+ "	 	from(select mp_no, mp_title, mp_condition, mp_meal, mp_defecate, mp_supplies, mp_txt, mp_tid,mp_uid,mp_uname, mp_date"
        		+ "				from mypet_table"
        		+ "				where mp_tid=? and mp_uid=? and mp_uname=?"
        		+ "				order by mp_no desc ))"
        		+ "where rw >= ? and rw <=?";
  
        try {
           
            con = DBManager.connect();
            ps = con.prepareStatement(sql);
            ps.setString(1, Mp_tid);
            ps.setString(2, Mp_uid);
            ps.setString(3, Mp_uname);
            ps.setInt(4, from);
            ps.setInt(5, to);
           
            rs = ps.executeQuery();
           
			ArrayList<nnotebook> nn = new ArrayList<nnotebook>();
			while(rs.next()) {
				nn.add(new nnotebook(rs.getInt("mp_no"),rs.getString("mp_title"),rs.getString("mp_condition"),rs.getInt("mp_meal"),rs.getInt("mp_defecate"),rs.getString("mp_supplies"),rs.getString("mp_txt"),rs.getString("mp_tid"),rs.getString("mp_uid"),rs.getString("mp_uname"),rs.getDate("mp_date")));
				request.setAttribute("nnotebook", nn);
			}
  
           
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            DBManager.close(con, ps, rs);
        }
      
    }
 
 public static void page(HttpServletRequest request) {
		String strPg = request.getParameter("pg");
	   	 
	    int rowSize = 5; //한페이지에 보여줄 글의 수
	    int pg = 1; //페이지 , list.jsp로 넘어온 경우 , 초기값 =1
	   
	    if(strPg != null){ //list.jsp?pg=2
	        pg = Integer.parseInt(strPg); //.저장
	    }
	   
	    int total = getTotal(request); //총 게시물 수
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
