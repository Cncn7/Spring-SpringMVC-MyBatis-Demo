package com.chinasoft.SpringDemo.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class DemoInterceptor implements HandlerInterceptor{

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		 
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub
	 
	}

	@Override
	public boolean preHandle(HttpServletRequest request, 
			HttpServletResponse response, Object arg2) throws Exception {
		// TODO Auto-generated method stub
		/*������ ִ�����ع���  ������Ҫ�ĺ�������
		 * ע���������������������  ������ ǰ�˾�̬��Դ+��˷�������ͬʱ����
		 * ��������ΪIOC  ֻ���� ���˵�Get post�ȷ��ʽ�������*/
		System.out.println("������ �������������");
		HttpSession session=request.getSession();
		
		/* ����Ŀ����  ����·��
		 * String url=request.getRequestURI();*/
		String path=request.getServletPath();
		/*String contextPath=request.getContextPath();
		 * ��˻�ȡ��Ŀ��*/
		
		 System.out.println(path+">>>>>>>>>>>>>");
		 
		 /*ע�� ��������������  ֻ����url����JSPҳ��  ��������ִ��
		  * ���� ���ʺ�˽ӿ�IOC������·��������html�ļ�������ͼƬ��js�Ⱦ�̬��Դ 
		  * ��������������ͬʱ����  ͬʱ����ִ�� ���ҹ�������ִ�й��� ��������ִ������
		  * 
		  * ����url��ʱ��  ������������� ����url(����������̬��Դ��)֮ǰ ִ�й���
		  *                            �������� ����� ����url(����������̬��Դ��)֮�� �������� ǲ��
		  *                            ���������� Ҫֱ���ض��� 404ҳ�棡
		  *                      ��Ҳ���� Ϊʲô  ִ�е��Ⱥ�˳��һ��  */
		return true;
	}
	

}
