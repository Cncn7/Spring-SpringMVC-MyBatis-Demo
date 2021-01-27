package com.chinasoft.MyBatisDemo.servlet;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.chinasoft.MyBatisDemo.config.MyBatisConfig;
import com.chinasoft.MyBatisDemo.dao.IAdminDao;

public class DemoServlet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
  SqlSession  session=MyBatisConfig.openMyBatis();
    /*dao�� ����ʵ����*/
    IAdminDao mapper=session.getMapper(IAdminDao.class);
    /*����dao�� ִ�ж�Ӧ��SQL����*/
   /* List<Map<String,Object>>  list=mapper.selectGoodsAll();
    System.out.println(list);
    System.out.println("SQLָ��ִ�гɹ�");
    
    List<Map<String,Object>> userList=mapper.selectGoodsAll();
    System.out.println(userList);*/
    for(int i=0;i<50;i++){
    	List<Map<String,Object>>  list=mapper.selectGoodsAll();
    	System.out.println(list);
        System.out.println("SQLָ��ִ�гɹ�����"+i+"��");
    }
    
    
    MyBatisConfig.closeMyBatis(session); 
		 
	}

}
