package dao.impl;

import java.sql.*;

import dao.IUserDAO;
import vo.User;

/**
 * DAO实现类，实现方法，但不负责数据库的具体连接
 */
public class UserDAOImpl implements IUserDAO {
	private Connection conn = null; // 定义数据库的连接对象
	private PreparedStatement pstmt = null; // 定义数据库操作对象

	public UserDAOImpl(Connection conn) { // 构造方法，设置数据库连接
		this.conn = conn;
	}
	
	public boolean addMoney(User user, Double m) throws Exception {
		boolean flg = false;
		try {
			String sql = "update User set banlance = banlance + ? WHERE id = ?";
			this.pstmt = this.conn.prepareStatement(sql); // 实例化操作
			this.pstmt.setDouble(1, m);
			this.pstmt.setString(2, user.getId()); // 设置用户id
			int num = this.pstmt.executeUpdate(); // 取得更新结果
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
	 * 具体操作方法：查询
	 */
	public boolean findLogin(User user) throws Exception {
		boolean flag = false; // 定义标志位
		try {
			String sql = "SELECT * FROM User WHERE id = ? AND password = ?";
			this.pstmt = this.conn.prepareStatement(sql); // 实例化操作
			this.pstmt.setString(1, user.getId()); // 设置用户id
			this.pstmt.setString(2, user.getPassword()); // 设置password
			ResultSet rs = this.pstmt.executeQuery(); // 取得查询结果
			if (rs.next()) {
				user.setUsername(rs.getString(3)); // 取得姓名
				user.setBanlance(rs.getDouble(4)); // 取得账户余额
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
				this.pstmt = this.conn.prepareStatement(sql); // 实例化操作
				this.pstmt.setDouble(1, m);
				this.pstmt.setString(2, user.getId()); // 设置用户id
				int num = this.pstmt.executeUpdate(); // 取得更新结果
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
			this.pstmt = this.conn.prepareStatement(sql); // 实例化操作
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
				traname = rs.getString(1); // 取得用户名
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
				rs = pstmt.executeUpdate(); // 保存本账户转账结果
				if (rs > 0) {
					user.setBanlance(user.getBanlance() - tramo);
					this.pstmt = this.conn.prepareStatement(sql);
					this.pstmt.setDouble(1, tramo);
					this.pstmt.setString(2, traid);
					rs = this.pstmt.executeUpdate(); // 保存转账账户转账结果
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

	public String getPass(User user) throws Exception { // 获取密码
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
