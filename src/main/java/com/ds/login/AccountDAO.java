package com.ds.login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.ds.ct.DBManager;
import com.ds.main.NoticeDAO;
import com.ds.main.ScheduleDAO;
import com.ds.main.tpostscriptDAO;




public class AccountDAO {
	
		public static void loginCheckCheck(HttpServletRequest request) {
			//Account a = (Account) request.getAttribute("accountInfo");
			
			HttpSession hs = request.getSession();
			Account r = (Account) hs.getAttribute("raccountInfo");
			Account u = (Account) hs.getAttribute("uaccountInfo");
			Account t = (Account) hs.getAttribute("taccountInfo");		
			
			if(r==null && u==null && t==null) {
				NoticeDAO.Showfive(request);
			    tpostscriptDAO.Showfive(request);
			    ScheduleDAO.Showtoday(request);    
				request.setAttribute("loginPage", "account/logout.jsp");
				request.setAttribute("contentPage", "main/main.jsp");
			} else if(r!=null) {
				 NoticeDAO.Showfive(request);
			     tpostscriptDAO.Showfive(request);
			     ScheduleDAO.Showtoday(request); 
				request.setAttribute("loginPage", "account/RootAccount.jsp");
				request.setAttribute("contentPage", "main/rootmain.jsp");
			} else if(u!=null) {
				 NoticeDAO.Showfive(request);
			     tpostscriptDAO.Showfive(request);
			     ScheduleDAO.Showtoday(request); 
				request.setAttribute("loginPage", "account/UserAccount.jsp");
				request.setAttribute("contentPage", "main/usermain.jsp");
			} else if(t!=null) {
				 NoticeDAO.Showfive(request);
			     tpostscriptDAO.Showfive(request);
			     ScheduleDAO.Showtoday(request); 
				request.setAttribute("loginPage", "account/TeacherAccount.jsp");
				request.setAttribute("contentPage", "main/teachermain.jsp");
			}
		}
	
		public static void loginCheck(HttpServletRequest request) {
			Connection con=null;
			PreparedStatement pstmt=null;
			ResultSet rs=null;
			
			//우선 로그인 페이지로 넘어가서 로그인 값을 받아오고 그 값으로 utr을 구분해서 화면을 보여준다..
			String id = request.getParameter("id");
			String pw = request.getParameter("pw");
			
			String idd =(String) request.getAttribute("idd");
			String pww =(String) request.getAttribute("pww");
			
			if(idd != null) {
				id = idd;
				pw = pww;
			}
			
			System.out.println(id);
			System.out.println(pw);
	
			try {
				if(id.equals("root")) {
					
					if(pw.equals("1234")) {
						Account a=new Account();
						
						a.setR_id(id);
						a.setR_pw(pw);
						
						HttpSession hs = request.getSession();
						hs.setAttribute("raccountInfo", a);
						hs.setMaxInactiveInterval(300);					
					}else {
						request.setAttribute("r", "비밀번호가 틀렸습니다.");
					}
				}else {
					String sql="select * from User_table where u_id=?";
					con=DBManager.connect();
					pstmt=con.prepareStatement(sql);
					pstmt.setString(1, id);
					rs=pstmt.executeQuery();
					
					if(rs.next()) {
						String db_pw=rs.getString("u_pw");
						if(pw.equals(db_pw)) {
							Account a=new Account();
							
							a.setU_id(rs.getString("u_id"));
							a.setU_pw(rs.getString("u_pw"));
							a.setU_name(rs.getString("u_name"));
							a.setU_phonenumber(rs.getString("u_phonenumber"));
							
							HttpSession hs = request.getSession();
							hs.setAttribute("uaccountInfo", a);
							hs.setMaxInactiveInterval(300);
						}else {
							request.setAttribute("r", "비밀번호가 틀렸습니다.");
						}
					}else {
						String sql2="select * from teacher_table where t_id=?";
						pstmt=con.prepareStatement(sql2);
						pstmt.setString(1, id);
						rs=pstmt.executeQuery();
						
						if(rs.next()) {
							String db_pw=rs.getString("t_pw");
							if(pw.equals(db_pw)) {
								Account a=new Account();
			
								a.setT_id(rs.getString("t_id"));
								a.setT_pw(rs.getString("t_pw"));
								a.setT_name(rs.getString("t_name"));
								a.setT_phonenumber(rs.getString("t_phonenumber"));
								a.setT_text(rs.getString("t_text"));
								
								HttpSession hs = request.getSession();
								hs.setAttribute("taccountInfo", a);
								hs.setMaxInactiveInterval(300);					
							}else {
								request.setAttribute("r", "비밀번호가 틀렸습니다.");
							}
						}else {
							request.setAttribute("r", "잘못된 아이디 입니다.");
						}
					}
				}	
				
			} catch(Exception e) {
				request.setAttribute("db서버오류", "result");
				e.printStackTrace();
			} finally {
				DBManager.close(con, pstmt, rs);
			}
			
			
		}
	
		public static void logout(HttpServletRequest request) {
			request.getSession().invalidate();
			request.getSession(true);
			request.setAttribute("loginPage", "account/logout.jsp");
		}
	
		public static void u_signup(HttpServletRequest request) {
			Connection con = null;
			PreparedStatement pstmt = null;
			
			
			String u_id = request.getParameter("id1");
			String u_pw = request.getParameter("password");
			String u_name = request.getParameter("name");
			String u_phonenumber = request.getParameter("phonefirst")
								 + request.getParameter("phonesecond")
								 + request.getParameter("phonethird");
			String u_gender = request.getParameter("gender");
	
			
			System.out.println("--------");
			System.out.println(u_id);
			System.out.println(u_pw);
			System.out.println(u_name);
			System.out.println(u_phonenumber);
			System.out.println(u_gender);
			
			try {
				con = DBManager.connect();
				String sql = "insert into User_table values(?,?,?,?,?)";
				pstmt = con.prepareStatement(sql);
				
				
				pstmt.setString(1, u_id);
				pstmt.setString(2, u_pw);
				pstmt.setString(3, u_name);
				pstmt.setString(4, u_phonenumber);
				pstmt.setString(5, u_gender);
		
				
				int row = pstmt.executeUpdate();
				if(row == 1) {
					request.setAttribute("r", "등록성공");
				}else {
					request.setAttribute("r", "등록실패");
				}
				
			} catch (Exception e) {
				e.getStackTrace();
				request.setAttribute("r", "DB문제");
			}finally {
				DBManager.close(con, pstmt, null);
			}
			
			
		}
	
		
		public static void t_signup(HttpServletRequest request) {
			Connection con = null;
			PreparedStatement pstmt = null;
			
			
			String t_id = request.getParameter("id1");
			String t_pw = request.getParameter("password");
			String t_name = request.getParameter("name");
			String t_phonenumber = request.getParameter("phonefirst")
								 + request.getParameter("phonesecond")
								 + request.getParameter("phonethird");
			String t_gender = request.getParameter("gender");
			String t_txt = request.getParameter("txt");
			String t_txt1 = "작성한 내용이 없습니다.";
			
			System.out.println("--------");
			System.out.println(t_id);
			System.out.println(t_pw);
			System.out.println(t_name);
			System.out.println(t_phonenumber);
			System.out.println(t_gender);
			System.out.println("txt" +t_txt);
			
			try {
				con = DBManager.connect();
				String sql = "insert into teacher_table values(?,?,?,?,?,?)";
				pstmt = con.prepareStatement(sql);
				
				
				pstmt.setString(1, t_id);
				pstmt.setString(2, t_pw);
				pstmt.setString(3, t_name);
				pstmt.setString(4, t_phonenumber);
				pstmt.setString(5, t_gender);
				if(t_txt.equals("")) {
					pstmt.setString(6, t_txt1);
				}else {
					pstmt.setString(6, t_txt);	
				}
				
				int row = pstmt.executeUpdate();
				if(row == 1) {
					request.setAttribute("r", "등록성공");
				}else {
					request.setAttribute("r", "등록실패");
				}
				
			} catch (Exception e) {
				e.getStackTrace();
				request.setAttribute("r", "DB문제");
			}finally {
				DBManager.close(con, pstmt, null);
			}
			
		}
		
		public static int idcheck(HttpServletRequest request) {
			Connection con = null;
			PreparedStatement prst = null;
			ResultSet rs = null;
			
			String id = request.getParameter("id");
			System.out.println(id);
			
			String root_id = "root";
			try {
				con = DBManager.connect();
				String sql = "select * from User_table where u_id=?";	
				prst = con.prepareStatement(sql);
				prst.setString(1,id);
				
				rs = prst.executeQuery();
			
				if(rs.next()) {
					request.setAttribute("result", "중복된 아이디입니다.");
					return 1;
				}else {
					String sql1 = "select * from teacher_table where t_id=?";
					prst = con.prepareStatement(sql1);
					prst.setString(1,id);
					
					rs = prst.executeQuery();
					if(rs.next()) {
						request.setAttribute("result", "중복된 아이디입니다.");
						return 1;
					}else {
						if(root_id.equals(id)) {
							request.setAttribute("result", "중복된 아이디입니다.");
							return 1;
						}else {
							request.setAttribute("result", "(사용가능한 아이디입니다.)");	
							request.setAttribute("result1", id);	
						}
					}		
				}
				
					
			} catch (Exception e) {
				e.getStackTrace();
				request.setAttribute("result", "DB문제");
				
			}finally {
				DBManager.close(con, prst, rs);
			}
			return 0;
		}

		public static void t_mypageUpdate(HttpServletRequest request) {
			Connection con = null;
			PreparedStatement prst = null;
			

			String t_id = request.getParameter("id1");
			String t_pw = request.getParameter("password");
			String t_name = request.getParameter("name");
			String t_phonenumber = request.getParameter("phonefirst")
					 			 + request.getParameter("phonesecond")
					 			 + request.getParameter("phonethird");
			String t_gender = request.getParameter("gender");
			String t_txt = request.getParameter("txt");
			String t_txt1 = "작성한 내용이 없습니다.";
			
			System.out.println("수정 파라메터 확인");
			System.out.println("--------");
			System.out.println(t_id);
			System.out.println(t_pw);
			System.out.println(t_name);
			System.out.println(t_phonenumber);
			System.out.println(t_gender);
			System.out.println(t_txt);
			
			try {
				con = DBManager.connect();
				String sql = "update teacher_table set t_pw=?,t_name=?,t_phonenumber=?,t_gender=?,t_text=? where t_id=?";
				prst = con.prepareStatement(sql);

				prst.setString(1, t_pw);
				prst.setString(2, t_name);
				prst.setString(3, t_phonenumber);
				prst.setString(4, t_gender);
				if(t_txt.equals("")) {
					prst.setString(5, t_txt1);
				}else {
					prst.setString(5, t_txt);
				}
				prst.setString(6, t_id);
			
				int row = prst.executeUpdate();
				
				request.setAttribute("idd", t_id);
				request.setAttribute("pww", t_pw);
				
				if(row == 1) {
					request.setAttribute("r", "수정이 완료되었습니다.");
				}else {
					request.setAttribute("r", "수정이 실패하였습니다.");
				}
				
				
			} catch (Exception e) {
				e.getStackTrace();
				request.setAttribute("r", "DB문제");
				
			}finally {
				DBManager.close(con, prst, null);
			}		
		}

		public static void T_mypageDelete(HttpServletRequest request) {
			Connection con = null;
			PreparedStatement prst = null;
			

			String t_id = request.getParameter("id");
	
			
			System.out.println("삭제 파라메터 확인");
			System.out.println("--------");
			System.out.println(t_id);
	
			try {
				con = DBManager.connect();
				String sql = "delete from teacher_table where t_id=?";
				prst = con.prepareStatement(sql);

				prst.setString(1, t_id);
				
				int row = prst.executeUpdate();
				
				if(row == 1) {
					request.setAttribute("r", "회원탈퇴 완료되었습니다.");
				}else {
					request.setAttribute("r", "회원탈퇴 실패하였습니다.");
				}
				
				
			} catch (Exception e) {
				e.getStackTrace();
				request.setAttribute("r", "DB문제");
				
			}finally {
				DBManager.close(con, prst, null);
			}	
			
		}

		public static void u_mypageUpdate(HttpServletRequest request) {
			Connection con = null;
			PreparedStatement prst = null;
			

			String u_id = request.getParameter("id1");
			String u_pw = request.getParameter("password");
			String u_name = request.getParameter("name");
			String u_phonenumber = request.getParameter("phonefirst")
								 + request.getParameter("phonesecond")
								 + request.getParameter("phonethird");
			String u_gender = request.getParameter("gender");

			
			System.out.println("수정 파라메터 확인");
			System.out.println("--------");
			System.out.println(u_id);
			System.out.println(u_pw);
			System.out.println(u_name);
			System.out.println(u_phonenumber);
			System.out.println(u_gender);
			
			try {
				con = DBManager.connect();
				String sql = "update User_table set u_pw=?,u_name=?,u_phonenumber=?,u_gender=? where u_id=?";
				prst = con.prepareStatement(sql);

				prst.setString(1, u_pw);
				prst.setString(2, u_name);
				prst.setString(3, u_phonenumber);
				prst.setString(4, u_gender);
				prst.setString(5, u_id);
			
				int row = prst.executeUpdate();
				
				request.setAttribute("idd", u_id);
				request.setAttribute("pww", u_pw);
				
				if(row == 1) {
					request.setAttribute("r", "수정이 완료되었습니다.");
				}else {
					request.setAttribute("r", "수정이 실패하였습니다.");
				}
				
				
			} catch (Exception e) {
				e.getStackTrace();
				request.setAttribute("r", "DB문제");
				
			}finally {
				DBManager.close(con, prst, null);
			}		
		}

		public static void U_mypageDelete(HttpServletRequest request) {
			Connection con = null;
			PreparedStatement prst = null;
			

			String u_id = request.getParameter("id");
	
			
			System.out.println("삭제 파라메터 확인");
			System.out.println("--------");
			System.out.println(u_id);
	
			try {
				con = DBManager.connect();
				String sql = "delete from User_table where u_id=?";
				prst = con.prepareStatement(sql);

				prst.setString(1, u_id);
				
				int row = prst.executeUpdate();
				
				if(row == 1) {
					request.setAttribute("r", "회원탈퇴 완료되었습니다.");
				}else {
					request.setAttribute("r", "회원탈퇴 실패하였습니다.");
				}
				
				
			} catch (Exception e) {
				e.getStackTrace();
				request.setAttribute("r", "DB문제");
				
			}finally {
				DBManager.close(con, prst, null);
			}	
			
		}
		
		public static void Findid(HttpServletRequest request) {
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;

			String u_id = null;
			String t_id =null;
			String name = request.getParameter("name");
			String phonenumber = request.getParameter("phonenumber");

			System.out.println(name);
			System.out.println(phonenumber);

			try {
				con = DBManager.connect();
				String sql = "select u_id from User_table where u_name=? and u_phonenumber=?";
				pstmt = con.prepareStatement(sql);
				
				pstmt.setString(1, name);
				pstmt.setString(2, phonenumber);
				rs = pstmt.executeQuery();

				if (rs.next()) {
					u_id = rs.getString("u_id");
					Account a = new Account();
					a.setU_name("u_name");
					a.setU_phonenumber("u_phonenumber");

					request.setAttribute("a", u_id);
				} else{
					String sql1 = "select t_id from teacher_table where t_name=? and t_phonenumber=?";
					pstmt = con.prepareStatement(sql1);
					
					pstmt.setString(1, name);
					pstmt.setString(2, phonenumber);
					rs = pstmt.executeQuery();
					
					if (rs.next()) {
						t_id = rs.getString("t_id");
						Account a = new Account();
						a.setT_name("t_name");
						a.setT_phonenumber("t_phonenumber");
						
						request.setAttribute("a", t_id);
					} else{
						request.setAttribute("a", "없는 아이디 입니다.");
					}
				}
			} catch (Exception e) {
				request.setAttribute("db서버오류", "a");
				e.printStackTrace();
			} finally {
				DBManager.close(con, pstmt, rs);
			}

		}

		public static void Findpw(HttpServletRequest request) {
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;

			String u_pw = null;
			String t_pw =null;
			String id = request.getParameter("id");
			String name = request.getParameter("name");
			String phonenumber = request.getParameter("phonenumber");

			System.out.println(id);
			System.out.println(name);
			System.out.println(phonenumber);

			try {
				con = DBManager.connect();
				String sql = "select u_pw from User_table where u_id=? and u_name=? and u_phonenumber=?";
				pstmt = con.prepareStatement(sql);
				
				pstmt.setString(1, id);
				pstmt.setString(2, name);
				pstmt.setString(3, phonenumber);
				rs = pstmt.executeQuery();

				if (rs.next()) {
					u_pw = rs.getString("u_pw");
					Account a = new Account();
					a.setU_id("u_id");
					a.setU_name("u_name");
					a.setU_phonenumber("u_phonenumber");

					request.setAttribute("a", u_pw);
				} else{
					String sql1 = "select t_pw from teacher_table where t_id=? and t_name=? and t_phonenumber=?";
					pstmt = con.prepareStatement(sql1);
					
					pstmt.setString(1, id);
					pstmt.setString(2, name);
					pstmt.setString(3, phonenumber);
					rs = pstmt.executeQuery();
					
					if (rs.next()) {
						t_pw = rs.getString("t_pw");
						Account a = new Account();
						a.setT_id("t_id");
						a.setT_name("t_name");
						a.setT_phonenumber("t_phonenumber");
						
						request.setAttribute("a", t_pw);
					} else{
						request.setAttribute("a", "비밀번호를 찾을 수 없습니다.");
					}
				}
			} catch (Exception e) {
				request.setAttribute("db서버오류", "a");
				e.printStackTrace();
			} finally {
				DBManager.close(con, pstmt, rs);
			}

			
		}

}
