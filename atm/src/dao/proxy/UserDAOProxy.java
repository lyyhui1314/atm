package dao.proxy;

import dao.IUserDAO;

import dbc.DatabaseConnection;
import dao.impl.UserDAOImpl;
import vo.User;

/**
 * �����࣬Ҫ�ҵ���ʵ����
 */
public class UserDAOProxy implements IUserDAO {
	private DatabaseConnection dbc = null;
	private IUserDAO dao = null;

	public UserDAOProxy() { // ���췽����ʵ�������Ӻ�dao����
		try {
			this.dbc = new DatabaseConnection(); // �������ݿ�
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.dao = new UserDAOImpl(this.dbc.getConnection()); // ʵ������ʵ��
	}

	public boolean findLogin(User user) throws Exception {		//���id������
		boolean flg = false;
		try {
			flg = this.dao.findLogin(user); // ������ʵ����
		} catch (Exception e) {
			throw e; // �����׳��쳣
		} finally {
			this.dbc.close();
		}
		return flg;
	}
	
	public Double inqMoney(User user)throws Exception {		//��ѯ���
		return this.dao.inqMoney(user);
	}
	
	public boolean addMoney(User user, Double m) throws Exception {
		boolean flg = false;
		try {
			if(this.dao.addMoney(user, m))
				flg = true;
		} catch (Exception e) {
			throw e; // �����׳��쳣
		}
		
		return flg;
	}
	
	public boolean redMoney(User user, Double m)throws Exception {		//ȡ��
		boolean flg = false;
		try {
			if(this.dao.redMoney(user, m))
				flg = true;
		} catch (Exception e) {
			throw e;
		}
		return flg;
	}
	
	public boolean checkId(String id) throws Exception {		//����˻��Ƿ����
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
	
	public String getTraname(String traid)throws Exception {	//��id�����û���
		String traname = "";
		try {
			traname = this.dao.getTraname(traid);
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		}
		return traname;
	}
	
	public boolean traMoney(User user, String traid, Double tramo) throws Exception {		//ת��
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
