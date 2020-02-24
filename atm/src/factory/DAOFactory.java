package factory;

import dao.IUserDAO;
import dao.proxy.UserDAOProxy;

/**
 * 工厂类
 */
public class DAOFactory {
	public static IUserDAO getIUSerDAOInstance() {		//取得userdao实例
		return new UserDAOProxy();		//返回代理实例
	}
}
