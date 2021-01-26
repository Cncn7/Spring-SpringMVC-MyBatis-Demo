package com.chinasoft.SpringDemo.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.chinasoft.SpringDemo.pojo.User;

@Controller
/*һ��ǰ������Ŀ¼ Ҳ�п��Ʋ����
 * ע�� һ������Ŀ¼ �Ͷ�������Ŀ¼ ����Ҫ��url����
 * ���Ծ���Сд*/
@RequestMapping("/demo")
public class DemoController  {

	/*���������� ��������Ŀ¼*/
	@RequestMapping("/test")
	@ResponseBody /*�ֲ��� �첽��������������*/
	public void test(HttpServletRequest request,HttpServletResponse response){
		//System.out.println("���Ǻ�˿�����  ִ���ˣ�������");
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("abc", "����˭��");
		map.put("bbb", "����");
		
		/*json�����첽��������*/
		JSONObject json=new JSONObject();
		json.put("map", map);
	PrintWriter  out=null;
		try {
			//response.setCharacterEncoding("utf-8");
		 	response.setContentType("application/json;charset=utf-8");
			out=response.getWriter();
			out.print(json.toJSONString());
		} catch ( Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(out!=null){
				out.flush();
				out.close();
			}
		}
		//return   JSONObject.toJSON(map);
	}
	
	/*get���� ��post���� ������˿����� ִ�д������*/
	@RequestMapping("/test1")
	public ModelAndView test1(HttpServletRequest request,
			@RequestParam Map<String,Object> map){
		/*ע����ʽ  ���ղ���*/
		System.out.println(map);
		System.out.println(map);
		System.out.println("����ȫ����תҳ�棡��");
		 /*�滻��request ��response��ԭʼ��ת����*/
		/*return �������������� ��ת*/
 	request.setAttribute("userMain", "IOC����ǰ��ֵ������Ϣ");
/*ModelAndView mo=new ModelAndView("test");
String userMain="IOC����ǰ��ֵ������Ϣ222";
mo.addObject(userMain);*/
 	return new ModelAndView("index");
		/*return new ModelAndView("forward:/demo/test2");*/
		/*redirect:/  forward:/
		 * ע������ǰ׺�� ��ǰĬ��Ϊ forward:/ request�ڲ���תΪ��
		 * */
	}
	
	@RequestMapping("/test2")
	public ModelAndView test2(HttpServletRequest request,
			@RequestParam Map<String,Object> map){
		/*ע����ʽ  ���ղ���*/
		 
		System.out.println("����ȫ����תҳ��  ���տ���������");
		System.out.println(map);
		System.out.println(map);
		 /*�滻��request ��response��ԭʼ��ת����*/
		/*return �������������� ��ת*/
		return new ModelAndView("redirect:/test.jsp");
		/*redirect:/  forward:/
		 * ע������ǰ׺�� ��ǰĬ��Ϊ forward:/ request�ڲ���תΪ��
		 * */
	}
	
	/*@RequestMapping(value={"/test3","/markTwoon"})*/
	/*���ڱȽ�������첽�ӿ�  ��һ��post�첽���� �������ƹ���*/
	@RequestMapping(params={"userName=л����","userAge=58"},
			value="/test112/{message}",method=RequestMethod.POST)
	@ResponseBody
	public void test3(HttpServletRequest request,HttpServletResponse response,
			@RequestParam Map<String,Object> map,
			  User user,@PathVariable("message") String message ){
		
		System.out.println(JSONObject.toJSON(user));
		System.out.println(JSONObject.toJSON(user));
		JSONObject json=new JSONObject();
		json.put("main", "���Ǻ���첽��������");
		json.put("message", message);
		json.put("user", user);
		PrintWriter out=null;
		try {
			response.setContentType("application/json;charset=utf-8");
			  out=response.getWriter();
			out.print(json.toJSONString());
		} catch ( Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(out!=null){
				out.flush();
				out.close();
			}
		}
	}
	
	
}
