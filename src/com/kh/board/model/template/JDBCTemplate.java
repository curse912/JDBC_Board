package com.kh.board.model.template;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

// JDBC의 주요 메서드들을 정의한 클래스
// getConnection, close, commit, rollback 메서드를 정의
// 단, db와의 연결정보는 resources/driver.properties에서 관리한다.
public class JDBCTemplate {
	//getConnection
		public static Connection getConnection() {
			
			Connection conn = null;
			Properties prop = new Properties();
			
			try {
				prop.load(new FileInputStream("resources/driver.properties"));
				Class.forName(prop.getProperty("driver"));
				conn = DriverManager.getConnection(
						prop.getProperty("url"),
						prop.getProperty("username"),
						prop.getProperty("password")
						);
				
				conn.setAutoCommit(false);
				
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return conn;
			
		}
		
		//close
		public static void close(Connection conn) {
			try {
				if(conn != null && !conn.isClosed()) {
					conn.close();				
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		public static void close(Statement stmt) {
			try {
				if(stmt != null && !stmt.isClosed()) {
					stmt.close();				
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		public static void close(ResultSet rset) {
			try {
				if(rset != null && !rset.isClosed()) {
					rset.close();				
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		//commit
		
		//rollback

}
