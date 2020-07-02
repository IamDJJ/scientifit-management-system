package com.scientific.manage.controller;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.scientific.manage.dao.cqjbDao;
import com.scientific.manage.entity.cqjb;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value="/cqjb")
public class cqjbAction {
	/**
	 * �Զ�ע��ҵ���߼��㣬ע�뷽ʽʹ����ע���Զ�ע��
	 */

	@Resource
	cqjbDao cqjbdao;
	@RequestMapping(value="/addPage")
	public String addPage(cqjb cqjb, HttpServletRequest request){
		Map<String,Object> map= new HashMap<String,Object>();
		
		System.out.println("addPageok");
		return "cqjb/cqjbadd";
	}
	
	@RequestMapping(value="/add")
	public String add(cqjb cqjb,HttpServletRequest request){
		Map<String,Object> map= new HashMap<String,Object>();
		//String name=(String)request.getParameter("name");

		map.put("cqjbid", cqjb.getCqjbid());//��Ȩ������

		map.put("jb", cqjb.getJb());//����

		cqjbdao.save(map);
		
		
		request.setAttribute("msg", "<script>alert('��ӳɹ�');</script>");
		System.out.println("addok");
		return "cqjb/cqjbadd";
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
		cqjbdao.del(id);
		return selectall(null,map,request);
	}
	/**
	 * �޸�cqjb��Ϣ
	 */
	@RequestMapping(value="/update")
	public String update(cqjb cqjb,HttpServletRequest request,Map<String,Object> map1){
		Map<String,Object> map= new HashMap<String,Object>();
		map.put("cqjbid", cqjb.getCqjbid());//��Ȩ������

		map.put("jb", cqjb.getJb());//����

		request.setAttribute("msg", "<script>alert('�޸ĳɹ�');</script>");
		cqjbdao.update(map);
		return selectall(null,map1,request);
	}
	/**
	 * ��ѯcqjb��Ϣ
	 */
	@RequestMapping(value="/modify")
	public String modify(Integer id,Map<String,Object> map,HttpServletRequest request){
		String keyid=(String)request.getParameter("keyid");
		List<Map<String,Object>> list= new  ArrayList<Map<String,Object>>();
		list=cqjbdao.select(Integer.parseInt(keyid));
		request.setAttribute("cqjbid", list.get(0).get("cqjbid"));//��Ȩ������

		request.setAttribute("jb", list.get(0).get("jb"));//����

		
		return "cqjb/cqjbmodify";
	}
	
	@RequestMapping(value="/detail")
	public String detail(Integer id,Map<String,Object> map,HttpServletRequest request){
		String keyid=(String)request.getParameter("keyid");
		List<Map<String,Object>> list= new  ArrayList<Map<String,Object>>();
		list=cqjbdao.select(Integer.parseInt(keyid));
		request.setAttribute("cqjbid", list.get(0).get("cqjbid"));//��Ȩ������

		request.setAttribute("jb", list.get(0).get("jb"));//����

		return "cqjb/cqjbdetail";
	}
	
	/**
	 * ��ѯcqjb��Ϣ
	 */
	@RequestMapping(value="/selectall")
	public String selectall(Integer id,Map<String,Object> map,HttpServletRequest request){
		List<Map<String,Object>> list= new  ArrayList<Map<String,Object>>();
	Map<String,Object> map1= new HashMap<String,Object>();
		list=cqjbdao.selectAll(map1);
		System.out.println("listsize="+list.size());
		
		map.put("mylist", list);
		return "cqjb/cqjblist";
	}
}
