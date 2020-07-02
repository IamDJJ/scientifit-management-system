package com.scientific.manage.controller;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.scientific.manage.dao.leixingDao;
import com.scientific.manage.entity.leixing;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value="/leixing")
public class leixingAction {
	/**
	 * �Զ�ע��ҵ���߼��㣬ע�뷽ʽʹ����ע���Զ�ע��
	 */

	@Resource
	leixingDao leixingdao;
	@RequestMapping(value="/addPage")
	public String addPage(leixing leixing, HttpServletRequest request){
		Map<String,Object> map= new HashMap<String,Object>();
		
		System.out.println("addPageok");
		return "leixing/leixingadd";
	}
	
	@RequestMapping(value="/add")
	public String add(leixing leixing,HttpServletRequest request){
		Map<String,Object> map= new HashMap<String,Object>();
		//String name=(String)request.getParameter("name");

		map.put("lxid", leixing.getLxid());//���ͱ��

		map.put("lx", leixing.getLx());//����

		leixingdao.save(map);
		
		
		request.setAttribute("msg", "<script>alert('��ӳɹ�');</script>");
		System.out.println("addok");
		return "leixing/leixingadd";
	}
	
	/**ɾ�� 
	 * 
	 */
	@RequestMapping(value="/del")
	public String  del(Integer id,HttpServletRequest request,Map<String,Object> map){
	//	Map<String,Object> map= new HashMap<String,Object>();
		String a=(String)request.getParameter("keyid");
		id=Integer.parseInt(a);
		request.setAttribute("msg", "<script>alert('ɾ���ɹ�');</script>");
		leixingdao.del(id);
		return selectall(null,map,request);
	}
	/**
	 * �޸�leixing��Ϣ
	 */
	@RequestMapping(value="/update")
	public String update(leixing leixing,HttpServletRequest request,Map<String,Object> map1){
		Map<String,Object> map= new HashMap<String,Object>();
		map.put("lxid", leixing.getLxid());//���ͱ��

		map.put("lx", leixing.getLx());//����

		request.setAttribute("msg", "<script>alert('�޸ĳɹ�');</script>");
		leixingdao.update(map);
		return selectall(null,map1,request);
	}
	/**
	 * ��ѯleixing��Ϣ
	 */
	@RequestMapping(value="/modify")
	public String modify(Integer id,Map<String,Object> map,HttpServletRequest request){
		String keyid=(String)request.getParameter("keyid");
		List<Map<String,Object>> list= new  ArrayList<Map<String,Object>>();
		list=leixingdao.select(Integer.parseInt(keyid));
		request.setAttribute("lxid", list.get(0).get("lxid"));//���ͱ��

		request.setAttribute("lx", list.get(0).get("lx"));//����

		
		return "leixing/leixingmodify";
	}
	
	@RequestMapping(value="/detail")
	public String detail(Integer id,Map<String,Object> map,HttpServletRequest request){
		String keyid=(String)request.getParameter("keyid");
		List<Map<String,Object>> list= new  ArrayList<Map<String,Object>>();
		list=leixingdao.select(Integer.parseInt(keyid));
		request.setAttribute("lxid", list.get(0).get("lxid"));//���ͱ��

		request.setAttribute("lx", list.get(0).get("lx"));//����

		return "leixing/leixingdetail";
	}
	
	/**
	 * ��ѯleixing��Ϣ
	 */
	@RequestMapping(value="/selectall")
	public String selectall(Integer id,Map<String,Object> map,HttpServletRequest request){
		List<Map<String,Object>> list= new  ArrayList<Map<String,Object>>();
	Map<String,Object> map1= new HashMap<String,Object>();
		list=leixingdao.selectAll(map1);
		System.out.println("listsize="+list.size());
		
		map.put("mylist", list);
		return "leixing/leixinglist";
	}
}
