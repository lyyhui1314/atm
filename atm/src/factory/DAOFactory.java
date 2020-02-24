package factory;

import dao.IUserDAO;
import dao.proxy.UserDAOProxy;

/**
 * ������
 */
public class DAOFactory {
	public static IUserDAO getIUSerDAOInstance() {		//ȡ��userdaoʵ��
		return new UserDAOProxy();		//���ش���ʵ��
	}
}
