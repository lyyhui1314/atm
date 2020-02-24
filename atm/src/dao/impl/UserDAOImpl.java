package dao.impl;

import java.sql.*;

import dao.IUserDAO;
import vo.User;

/**
 * DAOʵ���࣬ʵ�ַ����������������ݿ�ľ�������
 */
public class UserDAOImpl implements IUserDAO {
	private Connection conn = null; // �������ݿ�����Ӷ���
	private PreparedStatement pstmt = null; // �������ݿ��������

	public UserDAOImpl(Connection conn) { // ���췽�����������ݿ�����
		this.conn = conn;
	}
	
	public boolean addMoney(User user, Double m) throws Exception {
		boolean flg = false;
		try {
			String sql = "update User set banlance = banlance + ? WHERE id = ?";
			this.pstmt = this.conn.prepareStatement(sql); // ʵ��������
			this.pstmt.setDouble(1, m);
			this.pstmt.setString(2, user.getId()); // �����û�id
			int num = this.pstmt.executeUpdate(); // ȡ�ø��½��
			if (num > 0) {
				flg = true;
				user.setBanlance(user.getBanlance() + m);
			}
		} catch (Exception e) {
			throw e;
		}
		return flg;
	}

	/**
	 * ���������������ѯ
	 */
	public boolean findLogin(User user) throws Exception {
		boolean flag = false; // �����־λ
		try {
			String sql = "SELECT * FROM User WHERE id = ? AND password = ?";
			this.pstmt = this.conn.prepareStatement(sql); // ʵ��������
			this.pstmt.setString(1, user.getId()); // �����û�id
			this.pstmt.setString(2, user.getPassword()); // ����password
			ResultSet rs = this.pstmt.executeQuery(); // ȡ�ò�ѯ���
			if (rs.next()) {
				user.setUsername(rs.getString(3)); // ȡ������
				user.setBanlance(rs.getDouble(4)); // ȡ���˻����
				flag = true;
			}
		} catch (Exception e) {
			throw e;
		}
		return flag;
	}

	public Double inqMoney(User user) throws Exception {
		return user.getBanlance();
	}

	public boolean redMoney(User user, Double m) throws Exception {
		boolean flg = false;
		try {
			if (user.getBanlance() >= m) {
				String sql = "update User set banlance = banlance - ? WHERE id = ?";
				this.pstmt = this.conn.prepareStatement(sql); // ʵ��������
				this.pstmt.setDouble(1, m);
				this.pstmt.setString(2, user.getId()); // �����û�id
				int num = this.pstmt.executeUpdate(); // ȡ�ø��½��
				if (num > 0) {
					flg = true;
					user.setBanlance(user.getBanlance() - m);
				}
			}
		} catch (Exception e) {
			throw e;
		}
		return flg;
	}

	public boolean checkId(String id) throws Exception {
		boolean flg = false;
		try {
			String sql = "select count(id) from User WHERE id = ?";
			this.pstmt = this.conn.prepareStatement(sql); // ʵ��������
			this.pstmt.setString(1, id);
			ResultSet rs = this.pstmt.executeQuery();
			if (rs.next()) {
				if (rs.getInt(1) > 0)
					flg = true;
			}
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		}
		return flg;
	}

	public String getTraname(String traid) throws Exception {
		String traname = "";
		try {
			String sql = "select username from User WHERE id = ?";
			this.pstmt = this.conn.prepareStatement(sql);
			this.pstmt.setString(1, traid);
			ResultSet rs = this.pstmt.executeQuery();
			if (rs.next()) {
				traname = rs.getString(1); // ȡ���û���
			}
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		}
		return traname;
	}

	public boolean traMoney(User user, String traid, Double tramo) throws Exception {
		int rs = 0;
		boolean flg = false;
		try {
			if (user.getBanlance() >= tramo) {
				String sql = "update User set banlance = banlance + ? where id = ?";
				this.pstmt = this.conn.prepareStatement(sql);
				this.pstmt.setDouble(1, -tramo);
				this.pstmt.setString(2, user.getId());
				rs = pstmt.executeUpdate(); // ���汾�˻�ת�˽��
				if (rs > 0) {
					user.setBanlance(user.getBanlance() - tramo);
					this.pstmt = this.conn.prepareStatement(sql);
					this.pstmt.setDouble(1, tramo);
					this.pstmt.setString(2, traid);
					rs = this.pstmt.executeUpdate(); // ����ת���˻�ת�˽��
					if (rs > 0)
						flg = true;
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		}
		return flg;
	}

	public boolean setPass(User user, String pass) throws Exception {
		boolean flg = false;
		try {
			String sql = "update User set password = ? where id  = ?";
			this.pstmt = this.conn.prepareStatement(sql);
			this.pstmt.setString(1, pass);
			this.pstmt.setString(2, user.getId());
			int num = pstmt.executeUpdate();
			if (num > 0) {
				flg = true;
				user.setPassword(pass);
			}
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		}
		return flg;
	}

	public String getPass(User user) throws Exception { // ��ȡ����
		String pass = "";
		try {
			String sql = "select password from User where id = ?";
			this.pstmt = this.conn.prepareStatement(sql);
			this.pstmt.setString(1, user.getId());
			ResultSet rs = this.pstmt.executeQuery();
			if (rs.next()) {
				pass = rs.getString(1);
			}
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		}
		return pass;
	}
}
