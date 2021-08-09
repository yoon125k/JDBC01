package com.test01;

import java.sql.SQLException;

public class DBTest05_Run {
	public static void main(String[] args) throws ClassNotFoundException, SQLException  {
		
		DBTest05 dt = new DBTest05();
		
//		dt.insert();
//		dt.delete();
//		dt.selectAll();
		dt.selectOne();
	}
}
