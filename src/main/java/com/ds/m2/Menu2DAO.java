package com.ds.m2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import com.ds.ct.DBManager;
import com.ds.login.Account;

public class Menu2DAO {

	public static void u_select(HttpServletRequest request) {
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

	public static void T_Menu2deleteC(HttpServletRequest request) {
		Connection con = null;
		PreparedStatement prst = null;
		

		String t_name = request.getParameter("name");

		
		System.out.println("삭제 파라메터 확인");
		System.out.println("--------");
		System.out.println(t_name);

		try {
			con = DBManager.connect();
			String sql = "delete from teacher_table where t_name=?";
			prst = con.prepareStatement(sql);

			prst.setString(1, t_name);
			
			int row = prst.executeUpdate();
			
			if(row == 1) {
				request.setAttribute("r", "선생님 정보가 삭제되었습니다.");
			}else {
				request.setAttribute("r", "선생님 정보가 삭제되었습니다.");
			}
			
			
		} catch (Exception e) {
			e.getStackTrace();
			request.setAttribute("r", "DB문제");
			
		}finally {
			DBManager.close(con, prst, null);
		}	
		
	}
}
