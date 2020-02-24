package dao.proxy;

import dao.IUserDAO;

import dbc.DatabaseConnection;
import dao.impl.UserDAOImpl;
import vo.User;

/**
 * 代理类，要找到真实主题
 */
public class UserDAOProxy implements IUserDAO {
	private DatabaseConnection dbc = null;
	private IUserDAO dao = null;

	public UserDAOProxy() { // 构造方法，实例化连接和dao对象
		try {
			this.dbc = new DatabaseConnection(); // 链接数据库
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.dao = new UserDAOImpl(this.dbc.getConnection()); // 实例化真实类
	}

	public boolean findLogin(User user) throws Exception {		//检查id和密码
		boolean flg = false;
		try {
			flg = this.dao.findLogin(user); // 调用真实主题
		} catch (Exception e) {
			throw e; // 向上抛出异常
		} finally {
			this.dbc.close();
		}
		return flg;
	}
	
	public Double inqMoney(User user)throws Exception {		//查询余额
		return this.dao.inqMoney(user);
	}
	
	public boolean addMoney(User user, Double m) throws Exception {
		boolean flg = false;
		try {
			if(this.dao.addMoney(user, m))
				flg = true;
		} catch (Exception e) {
			throw e; // 向上抛出异常
		}
		
		return flg;
	}
	
	public boolean redMoney(User user, Double m)throws Exception {		//取款
		boolean flg = false;
		try {
			if(this.dao.redMoney(user, m))
				flg = true;
		} catch (Exception e) {
			throw e;
		}
		return flg;
	}
	
	public boolean checkId(String id) throws Exception {		//检查账户是否存在
		boolean flg = false;
		try {
			if(this.dao.checkId(id))
				flg = true;
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		}
		return flg;
	}
	
	public String getTraname(String traid)throws Exception {	//由id返回用户名
		String traname = "";
		try {
			traname = this.dao.getTraname(traid);
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		}
		return traname;
	}
	
	public boolean traMoney(User user, String traid, Double tramo) throws Exception {		//转账
		boolean flg = false;
		try {
			if(this.dao.traMoney(user, traid, tramo))
				flg = true;
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		}
		return flg;
	}
	
	public String getPass(User user) throws Exception {
		String pass = "";
		try {
			pass = this.dao.getPass(user);
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		}
		return pass;
	}
	
	public boolean setPass(User user, String pass)throws Exception {
		boolean flg = false;
		try {
			if(this.dao.setPass(user, pass))
				flg = true;
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		}
		return flg;
	}
}
