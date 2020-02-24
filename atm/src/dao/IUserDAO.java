package dao;

import vo.*;

public interface IUserDAO {
	  /** 
     * �û���¼��֤ 
     * @param user ����vo���� 
     * @return ��֤������� 
     * @throws Exception 
     */  
    public boolean findLogin(User user) throws Exception; 
    
    /**
     * ��ѯ���
     */
    public Double inqMoney(User user)throws Exception; 
    
    /**
     * ���
     */
    public boolean addMoney(User user, Double m)throws Exception; 
    
    /**
     * ȡ��
     */
    public boolean redMoney(User user, Double m)throws Exception ;
    
    /**
     * ����˻��Ƿ����
     */
    public boolean checkId(String id)throws Exception;
    
    /**
     * ��id�����û���
     */
    public String getTraname(String traid)throws Exception;
    
    /**
     * ת��
     */
    public boolean traMoney(User user, String traid, Double tramo)throws Exception; 
    
    /**
     * ��ȡ����
     */
    public String getPass(User user)throws Exception;
    
    /**
     * ��������
     */
    public boolean setPass(User user, String pass)throws Exception;
}