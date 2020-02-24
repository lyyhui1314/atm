package dbc;

import java.sql.*;

public class DatabaseConnection {
	// �������ݿ����
	private static final String DBDRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String DBURL = "jdbc:mysql://localhost:3306/test?useSSL=false&serverTimezone=UTC";

	private static final String DBUSER = "root"; // ���ݿ������û���
	private static final String DBPASSWORD = "root"; // ���ݿ���������

	private Connection conn = null; // �������ݿ����Ӷ���

	public DatabaseConnection() throws Exception { // ���캯��
		try {
			Class.forName(DBDRIVER); // ���ز�ע����������
			this.conn = DriverManager.getConnection(DBURL, DBUSER, DBPASSWORD); // �������ݿ�
		} catch (Exception e) {
			throw e;
		}
	}

	public Connection getConnection() { // ȡ�����ݿ�����
		return this.conn;
	}

	public void close() throws Exception { // �ر����ݿ����
		if (this.conn != null) { // ����NullPointerException
			try {
				this.conn.close(); // �ر����ݿ�
			} catch (Exception e) {
				throw e; // �׳��쳣
			}
		}
	}
}
