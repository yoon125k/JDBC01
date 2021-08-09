package com.test01;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import common.JDBCTemplate;

public class DBTest06 extends JDBCTemplate {
	public void selectAll() {
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;

		String sql = "SELECT * FROM MYTEST";

		try {
			con = getConnection();
			pstm = con.prepareStatement(sql);
			rs = pstm.executeQuery();

			while (rs.next()) {
				System.out.println(rs.getInt(1) + ":" + rs.getString(2) + ":" + rs.getString(3));

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstm);
			close(con);
		}

	}
}
