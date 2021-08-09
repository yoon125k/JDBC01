package com.test01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DBTest03 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		Connection con = null;		
		Statement stmt =  null;
		
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String id = "KH";
		String pw = "KH";
		
		//입력
		int no = 0;
		String name = null;
		String nickname = null;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("번호입력: ");
		no = sc.nextInt();
		sc.nextLine();
		System.out.print("이름입력: ");
		name = sc.next();
		System.out.print("닉네임입력: ");
		nickname = sc.next();
		
		//INSERT INTO MYTEST VALUES(a,'a','a')
		String sql = "INSERT INTO MYTEST VALUES("+no+",'"+name+"','"+nickname+"')";
		System.out.println(sql);
		
		Class.forName(driver);
		con = DriverManager.getConnection(url,id,pw);
		stmt = con.createStatement();
		int res = stmt.executeUpdate(sql);
		
		if(res>0) {
			System.out.println("insert 성공");
		}else {
			System.out.println("insert 실패");
		}
		
		stmt.close();
		con.close();
		sc.close();
		
		


	}

}
