package com.test01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBTest02 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		// 자바에서 디비로 SELECT
		// 디비에서 자바로 RESULT SET
		// 그걸로 작성

		// 0.준비
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;

		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String id = "KH";
		String pw = "KH";
		String sql = "SELECT * FROM DEPT";

		// 1. 드라이버 등록
		Class.forName(driver);

		// 2.db연결
		con = DriverManager.getConnection(url, id, pw);

		// 3.sql 실행
		stmt = con.createStatement();
		rs = stmt.executeQuery(sql);

		// 4.결과
		while (rs.next()) {
			System.out.println(rs.getInt(1) + ":" + rs.getString(2) + ":\t[" + rs.getString("LOC") + "]");
			// 커서가 가르키고 있는 곳의 첫번째 컬럼값
		}

		// 5.종료
		rs.close();
		stmt.close();
		con.close();

	}
}
