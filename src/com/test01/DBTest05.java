package com.test01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DBTest05 {
	public void insert() throws ClassNotFoundException, SQLException {
		// 1.준비
		Connection con = null;
		PreparedStatement stmt = null;

		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String id = "KH";
		String pw = "KH";

		Scanner sc = new Scanner(System.in);

		System.out.print("번호 입력: ");
		int no = sc.nextInt();
		System.out.print("이름 입력: ");
		String name = sc.next();
		System.out.print("별명 입력: ");
		String nickname = sc.next();

		// String sql = "INSERT INTO MYTEST VALUES("+no+",'"+name+"','"+nickname+"')";
		String sql = "INSERT INTO MYTEST VALUES(?,?,?)";

		// 2.드라이버등록
		Class.forName(driver);

		// 3.db연결
		con = DriverManager.getConnection(url, id, pw);

		// 4.statement 준비
		stmt = con.prepareStatement(sql);
		stmt.setInt(1, no);
		stmt.setString(2, name);
		stmt.setString(3, nickname);

		// 5.query 실행
		int res = stmt.executeUpdate();

		// 6.결과
		if (res > 0) {
			System.out.println("insert 성공!");
		} else {
			System.out.println("isnert 실패!");
		}
		stmt.close();
		con.close();
		sc.close();

	}

	public void delete() throws SQLException, ClassNotFoundException {
		Connection con = null;
		PreparedStatement pstm = null;

		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String id = "KH";
		String pw = "KH";
		String sql = "DELETE FROM MYTEST WHERE MNO=?";

		Scanner sc = new Scanner(System.in);
		System.out.print("삭제할 번호: ");
		int no = sc.nextInt();

		//////////

		// 2.드라이버등록
		Class.forName(driver);

		// 3.db연결
		con = DriverManager.getConnection(url, id, pw);

		// 4.statement 준비
		pstm = con.prepareStatement(sql);
		pstm.setInt(1, no);

		// DELETE FROM MYTEST WHERE MNO=?
		// ==> DELETE FROM MYTEST WHERE MNO =no

		// 5.query 실행
		int res = pstm.executeUpdate();

		// 6.결과 처리
		if (res > 0) {
			System.out.println("delete 성공!");
		} else {
			System.out.println("delete 실패!");
		}
		// 7.db종료
		pstm.close();
		con.close();
		sc.close();

	}

	public void selectAll() throws ClassNotFoundException, SQLException {

		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;

		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String id = "KH";
		String pw = "KH";
		String sql = "SELECT * FROM MYTEST";

		Class.forName(driver);
		con = DriverManager.getConnection(url, id, pw);
		pstm = con.prepareStatement(sql);
		rs = pstm.executeQuery();

		while (rs.next()) {
			System.out.println(rs.getInt(1) + ":" + rs.getString(2) + ":" + rs.getString(3));
		}

		rs.close();
		pstm.close();
		con.close();

	}

	public void selectOne() throws ClassNotFoundException, SQLException {

		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;

		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String id = "KH";
		String pw = "KH";
		String sql = "SELECT * FROM MYTEST WHERE MNO=?";
		
		Scanner sc = new Scanner(System.in);
		System.out.print("번호 입력: ");
		int no = sc.nextInt();
		
		
		Class.forName(driver);

		con = DriverManager.getConnection(url,id,pw);
		pstm = con.prepareStatement(sql);
		pstm.setInt(1,no);
		
		rs = pstm.executeQuery();
		
		while(rs.next()) {
			System.out.println(rs.getInt(1) + ":" + rs.getString(2) + ":" + rs.getString(3));
		} 
		
		
		rs.close();
		pstm.close();
		con.close();
		sc.close();
		
		
		

	}
}
