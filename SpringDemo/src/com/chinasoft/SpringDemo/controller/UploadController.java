package com.chinasoft.SpringDemo.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;

@Controller
@RequestMapping("/upload")
public class UploadController {

	@RequestMapping(value="/file",method=RequestMethod.POST)
	public ModelAndView fileUpload(HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam Map<String,Object> map,
			MultipartFile uploadfile){
		 /*���Ȼ�ȡ  ԭ�ϴ��ļ��ĺ�׺��*/
		System.out.println(uploadfile.getOriginalFilename().substring(uploadfile.getOriginalFilename().lastIndexOf(".")));
		
		/*�������ļ���   һ��ԭ�� ���ļ��������ظ�*/
		String newFileName=UUID.randomUUID().toString().replaceAll("-", "")+uploadfile.getOriginalFilename().substring(uploadfile.getOriginalFilename().lastIndexOf("."));
		 /*���� ���ļ����ϴ�·��*/
	/*	String newFilePath=request.getSession().getServletContext().getRealPath("/upload/")+newFileName;*/
		/*ע���ϴ��ļ�λ������ �����ϴ����ļ�Դ��λ��  ��Ҫ�ϴ�tomcat����λ��*/
		String newFilePath="D:\\apache-tomcat-9.0.41\\upload\\"+newFileName;
		/*�ļ�����λ�� �ϴ�tomcat��*/
		String newFilePath1=request.getSession().getServletContext()
				.getRealPath("/upload/")+newFileName;
		
		/*���ļ� ����ʵ����*/
		File newFile=new File(newFilePath);
		 /*���ļ����� ����ʵ����*/
		File newFile1=new File(newFilePath1);
		/*����Spring��ܵĸ����ļ�����  ��ԭ�ļ��ַ����� ���Ƹ��µ� ʵ�����ļ�����*/
		try {
			uploadfile.transferTo(newFile);
			uploadfile.transferTo(newFile1);
			System.out.println("�ϴ��ļ��ɹ���");
			request.setAttribute("msg", "�ϴ��ļ��ɹ���");
			request.setAttribute("newFilePath", "/SpringDemo/upload/"+newFileName);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			request.setAttribute("msg", "�ϴ��ļ�ʧ�ܣ���");
		} 
		/*ע��ͬ����ת  ���첽���� �ص����ݵ�����
		 * ͬ����ת  ��request���δ�ֵ
		 * �첽����  ����json��ʽ����*/
		return new ModelAndView("success");
	}
	
	@RequestMapping(value="/axiosFile",method=RequestMethod.POST)
	@ResponseBody
	public void axiosFile(HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam Map<String,Object> map,
			MultipartFile uploadfile){
		 /*���Ȼ�ȡ  ԭ�ϴ��ļ��ĺ�׺��*/
		System.out.println(uploadfile.getOriginalFilename().substring(uploadfile.getOriginalFilename().lastIndexOf(".")));
		
		/*�������ļ���   һ��ԭ�� ���ļ��������ظ�*/
		String newFileName=UUID.randomUUID().toString().replaceAll("-", "")+uploadfile.getOriginalFilename().substring(uploadfile.getOriginalFilename().lastIndexOf("."));
		 /*���� ���ļ����ϴ�·��*/
	/*	String newFilePath=request.getSession().getServletContext().getRealPath("/upload/")+newFileName;*/
		/*ע���ϴ��ļ�λ������ �����ϴ����ļ�Դ��λ��  ��Ҫ�ϴ�tomcat����λ��*/
		String newFilePath="D:\\apache-tomcat-9.0.41\\upload\\"+newFileName;
		/*�ļ�����λ�� �ϴ�tomcat��*/
		String newFilePath1=request.getSession().getServletContext()
				.getRealPath("/upload/")+newFileName;
		
		/*���ļ� ����ʵ����*/
		File newFile=new File(newFilePath);
		 /*���ļ����� ����ʵ����*/
		File newFile1=new File(newFilePath1);
		/*����Spring��ܵĸ����ļ�����  ��ԭ�ļ��ַ����� ���Ƹ��µ� ʵ�����ļ�����*/
		response.setContentType("application/json;charset=utf-8");
		PrintWriter out=null;
		JSONObject json=new JSONObject();
		try {
			out=response.getWriter();
			uploadfile.transferTo(newFile);
			uploadfile.transferTo(newFile1);
			System.out.println("�ϴ��ļ��ɹ���");
		/*	request.setAttribute("msg", "�ϴ��ļ��ɹ���");
			request.setAttribute("newFilePath", "/SpringDemo/upload/"+newFileName);*/
			 json.put("msg", "�ϴ��ļ��ɹ���");
			 json.put("newFilePath", "/SpringDemo/upload/"+newFileName);
			 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//request.setAttribute("msg", "�ϴ��ļ�ʧ�ܣ���");
			 json.put("msg","�ϴ��ļ�ʧ�ܣ���");
		}finally{
			if(out!=null){
				out.print(json.toJSONString());
				out.flush();
				out.close();
			}
			 
		} 
		/*ע��ͬ����ת  ���첽���� �ص����ݵ�����
		 * ͬ����ת  ��request���δ�ֵ
		 * �첽����  ����json��ʽ����*/
		/*return new ModelAndView("success");*/
	}
	
	
}
