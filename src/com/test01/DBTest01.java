package com.test01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBTest01 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// 1.드라이버 등록
		Class.forName("oracle.jdbc.driver.OracleDriver");

		// 2.DB연결
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "KH", "KH");

		// 3.SQL 실행
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM EMP");

		// SELECT 는 RESULT SET을 되돌려준다.
		// ResultSet 타입의 rs 에 담아준다.

		// 4.결과 리턴
		while (rs.next()) { // 데이터 유무에 따라 true, false 리턴
			int empno = rs.getInt(1);
			// 현재 커서가 가르키는 컬럼 1번을 가져옴
			String ename = rs.getString(2);
			// 현재 커서가 가르키는 컬럼 2번을 가져옴
			int sal = rs.getInt("SAL");
			// 현재 커서가 가르키는 컬럼 SAL을 가져옴
			System.out.println(empno + " " + ename + " " + sal);
			// 이후 반복
		}

		// 5.종료
		rs.close();
		stmt.close();
		con.close();
	}

}
