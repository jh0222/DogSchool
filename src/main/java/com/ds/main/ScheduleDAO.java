package com.ds.main;

import java.security.interfaces.RSAKey;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import com.ds.ct.DBManager;

public class ScheduleDAO {
	public static void insert(HttpServletRequest request) {
		Connection con=null;
		PreparedStatement pstmt=null;
		String sql="insert into schedule_table values(?,?,?,?,?,?,?)";
		
		//중복되는 시간 때는 추가가 안되도록
		try {
			request.setCharacterEncoding("UTF-8");
			con=DBManager.connect();
			pstmt=con.prepareStatement(sql);
			
			String mon="",tue="",wed="",thur="",fri="",sat="",sun="";
			for(int i=1; i<8; i++) {
				if(request.getParameter("mon"+Integer.toString(i))!=null) {
					mon += request.getParameter("mon"+Integer.toString(i))+",";
				} else {
					mon += ",";
				}
			}
			
			for(int i=1; i<8; i++) {
				if(request.getParameter("tue"+Integer.toString(i))!=null) {
					tue += request.getParameter("tue"+Integer.toString(i))+",";
				} else {
					tue += ",";
				}
			}
			
			for(int i=1; i<8; i++) {
				if(request.getParameter("wed"+Integer.toString(i))!=null) {
					wed += request.getParameter("wed"+Integer.toString(i))+",";
				} else {
					wed += ",";
				}
			}
			
			for(int i=1; i<8; i++) {
				if(request.getParameter("thur"+Integer.toString(i))!=null) {
					thur += request.getParameter("thur"+Integer.toString(i))+",";
				} else {
					thur += ",";
				}
			}
			
			for(int i=1; i<8; i++) {
				if(request.getParameter("fri"+Integer.toString(i))!=null) {
					fri += request.getParameter("fri"+Integer.toString(i))+",";
				} else {
					fri += ",";
				}
			}
			
			for(int i=1; i<8; i++) {
				if(request.getParameter("sat"+Integer.toString(i))!=null) {
					sat += request.getParameter("sat"+Integer.toString(i))+",";
				} else {
					sat += ",";
				}
			}
			
			for(int i=1; i<8; i++) {
				if(request.getParameter("sun"+Integer.toString(i))!=null) {
					sun += request.getParameter("sun"+Integer.toString(i))+",";
				} else {
					sun += ",";
				}
			}
			
			pstmt.setString(1, mon);
			pstmt.setString(2, tue);
			pstmt.setString(3, wed);
			pstmt.setString(4, thur);
			pstmt.setString(5, fri);
			pstmt.setString(6, sat);
			pstmt.setString(7, sun);
						
			int row = pstmt.executeUpdate();						 
			if(row == 1) {
				request.setAttribute("result", "등록 성공");
			} else {
				request.setAttribute("result", "등록 실패");
				
			}
			
		} catch (Exception e) {
			request.setAttribute("result", "db서버 오류");
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, null);
		}
		
	}

	public static int update(HttpServletRequest request) {		
		Connection con=null;
		PreparedStatement pstmt=null;
		String sql="update schedule_table set mon=?,tue=?,wed=?,thur=?,fri=?,sat=?,sun=?";
		
		//중복되는 시간 때는 추가가 안되도록
		try {
			request.setCharacterEncoding("UTF-8");
			con=DBManager.connect();
			pstmt=con.prepareStatement(sql);
			
			String mon="",tue="",wed="",thur="",fri="",sat="",sun="";
			for(int i=1; i<8; i++) {
				if(request.getParameter("mon"+Integer.toString(i))!=null) {
					mon += request.getParameter("mon"+Integer.toString(i))+",";
				} else {
					mon += ",";
				}
			}
			
			for(int i=1; i<8; i++) {
				if(request.getParameter("tue"+Integer.toString(i))!=null) {
					tue += request.getParameter("tue"+Integer.toString(i))+",";
				} else {
					tue += ",";
				}
			}
			
			for(int i=1; i<8; i++) {
				if(request.getParameter("wed"+Integer.toString(i))!=null) {
					wed += request.getParameter("wed"+Integer.toString(i))+",";
				} else {
					wed += ",";
				}
			}
			
			for(int i=1; i<8; i++) {
				if(request.getParameter("thur"+Integer.toString(i))!=null) {
					thur += request.getParameter("thur"+Integer.toString(i))+",";
				} else {
					thur += ",";
				}
			}
			
			for(int i=1; i<8; i++) {
				if(request.getParameter("fri"+Integer.toString(i))!=null) {
					fri += request.getParameter("fri"+Integer.toString(i))+",";
				} else {
					fri += ",";
				}
			}
			
			for(int i=1; i<8; i++) {
				if(request.getParameter("sat"+Integer.toString(i))!=null) {
					sat += request.getParameter("sat"+Integer.toString(i))+",";
				} else {
					sat += ",";
				}
			}
			
			for(int i=1; i<8; i++) {
				if(request.getParameter("sun"+Integer.toString(i))!=null) {
					sun += request.getParameter("sun"+Integer.toString(i))+",";
				} else {
					sun += ",";
				}
			}
			
			pstmt.setString(1, mon);
			pstmt.setString(2, tue);
			pstmt.setString(3, wed);
			pstmt.setString(4, thur);
			pstmt.setString(5, fri);
			pstmt.setString(6, sat);
			pstmt.setString(7, sun);
						
			int row = pstmt.executeUpdate();						 
			if(row == 1) {
				request.setAttribute("result", "등록 성공");
				return 1; 
			} else {
				request.setAttribute("result", "등록 실패");
				
			}
			
		} catch (Exception e) {
			request.setAttribute("result", "db서버 오류");
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, null);
		}
		return 0; 
	}
	
	public static void showAll(HttpServletRequest request) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="select * from schedule_table";
		try {
			con=DBManager.connect();
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
		
			if(rs.next()) {
				String mon=rs.getString("mon");
				String monday[] = mon.split(",");
				request.setAttribute("mon", monday);
				
				String tue=rs.getString("tue");
				String tuesday[] = tue.split(",");
				request.setAttribute("tue", tuesday);
				
				String wed=rs.getString("wed");
				String wednesday[] = wed.split(",");
				request.setAttribute("wed", wednesday);
				
				String thur=rs.getString("thur");
				String thursday[] = thur.split(",");
				request.setAttribute("thur", thursday);
				
				String fri=rs.getString("fri");
				String friday[] = fri.split(",");
				request.setAttribute("fri", friday);
				
				String sat=rs.getString("sat");
				String saturday[] = sat.split(",");
				request.setAttribute("sat", saturday);
				
				String sun=rs.getString("sun");
				String sunday[] = sun.split(",");
				request.setAttribute("sun", sunday);
			
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, rs);
		}
		
	}
	
	
	public static void Showtoday(HttpServletRequest request) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="select * from schedule_table";
		try {
			con=DBManager.connect();
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			String[] weekday = new String[7];
			
			Date currentDate = new Date();
			System.out.println(currentDate); 
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(currentDate);
			int dayOfWeekNumber = calendar.get(Calendar.DAY_OF_WEEK);
			
			if(rs.next()) {
				if(dayOfWeekNumber==2) {
					String day=rs.getString("mon");
					weekday = day.split(",");
				} else if(dayOfWeekNumber==3) {
					String day=rs.getString("tue");
					weekday = day.split(",");
				} else if(dayOfWeekNumber==4) {
					String day=rs.getString("wed");
					weekday = day.split(",");
				} else if(dayOfWeekNumber==5) {
					String day=rs.getString("thur");
					weekday = day.split(",");
				} else if(dayOfWeekNumber==6) {
					String day=rs.getString("fri");
					weekday = day.split(",");
				} else if(dayOfWeekNumber==7) {
					String day=rs.getString("sat");
					weekday = day.split(",");
				} else if(dayOfWeekNumber==1) {
					String day=rs.getString("sun");
					weekday = day.split(",");
				}
			}
			request.setAttribute("day", weekday);
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, rs);
		}
		
	}
	
	

}
