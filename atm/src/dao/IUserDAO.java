package dao;

import vo.*;

public interface IUserDAO {
	  /** 
     * 用户登录验证 
     * @param user 传入vo对象 
     * @return 验证操作结果 
     * @throws Exception 
     */  
    public boolean findLogin(User user) throws Exception; 
    
    /**
     * 查询余额
     */
    public Double inqMoney(User user)throws Exception; 
    
    /**
     * 存款
     */
    public boolean addMoney(User user, Double m)throws Exception; 
    
    /**
     * 取款
     */
    public boolean redMoney(User user, Double m)throws Exception ;
    
    /**
     * 检查账户是否存在
     */
    public boolean checkId(String id)throws Exception;
    
    /**
     * 由id返回用户名
     */
    public String getTraname(String traid)throws Exception;
    
    /**
     * 转账
     */
    public boolean traMoney(User user, String traid, Double tramo)throws Exception; 
    
    /**
     * 获取密码
     */
    public String getPass(User user)throws Exception;
    
    /**
     * 更新密码
     */
    public boolean setPass(User user, String pass)throws Exception;
}