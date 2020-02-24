package dbc;

import java.sql.*;

public class DatabaseConnection {
	// 定义数据库程序
	private static final String DBDRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String DBURL = "jdbc:mysql://localhost:3306/test?useSSL=false&serverTimezone=UTC";

	private static final String DBUSER = "root"; // 数据库连接用户名
	private static final String DBPASSWORD = "root"; // 数据库连接密码

	private Connection conn = null; // 声明数据库连接对象

	public DatabaseConnection() throws Exception { // 构造函数
		try {
			Class.forName(DBDRIVER); // 加载并注册驱动程序
			this.conn = DriverManager.getConnection(DBURL, DBUSER, DBPASSWORD); // 链接数据库
		} catch (Exception e) {
			throw e;
		}
	}

	public Connection getConnection() { // 取得数据库连接
		return this.conn;
	}

	public void close() throws Exception { // 关闭数据库操作
		if (this.conn != null) { // 避免NullPointerException
			try {
				this.conn.close(); // 关闭数据库
			} catch (Exception e) {
				throw e; // 抛出异常
			}
		}
	}
}
