package com.scientific.manage.controller;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.scientific.manage.dao.htbgDao;
import com.scientific.manage.entity.htbg;
import com.scientific.manage.util.DBO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value="/htbg")
public class htbgAction {
	/**
	 * �Զ�ע��ҵ���߼��㣬ע�뷽ʽʹ����ע���Զ�ע��
	 */

	@Resource
	htbgDao htbgdao;
	@RequestMapping(value="/addPage")
	public String addPage(htbg htbg,HttpServletRequest request){
		Map<String,Object> map= new HashMap<String,Object>();
		
		System.out.println("addPageok");
		return "htbg/htbgadd";
	}
	
	@RequestMapping(value="/add")
	public String add(htbg htbg, HttpServletRequest request){
		Map<String,Object> map= new HashMap<String,Object>();
		//String name=(String)request.getParameter("name");

		map.put("htbgid", htbg.getHtbgid());//��ͬ������

		map.put("htbh", htbg.getHtbh());//��ͬ���

		map.put("bgsmbgr", htbg.getBgsmbgr());//���˵�������

		map.put("sj", htbg.getSj());//ʱ��

		map.put("zt", htbg.getZt());//״̬

		htbgdao.save(map);
		
		
		request.setAttribute("msg", "<script>alert('��ӳɹ�');</script>");
		System.out.println("addok");
		return "htbg/htbgadd";
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
		htbgdao.del(id);
		return selectall(null,map,request);
	}
	/**
	 * �޸�htbg��Ϣ
	 */
	@RequestMapping(value="/update")
	public String update(htbg htbg,HttpServletRequest request,Map<String,Object> map1){
		Map<String,Object> map= new HashMap<String,Object>();
		map.put("htbgid", htbg.getHtbgid());//��ͬ������

		map.put("htbh", htbg.getHtbh());//��ͬ���

		map.put("bgsmbgr", htbg.getBgsmbgr());//���˵�������

		map.put("sj", htbg.getSj());//ʱ��

		map.put("zt", htbg.getZt());//״̬
		
		String zt=(String)htbg.getZt();
		DBO db=new DBO();
		System.out.println("zt="+zt);
		
		
		String sql="";
		
		try{
			if(!zt.equals("δ���")){
				
				sql="update hetong set zt='"+zt+"' where htbh='"+htbg.getHtbh()+"'";
				System.out.println(sql);
				db.update(sql);
			}
			
		}catch(Exception e){
			e.printStackTrace();
			
		}
		request.setAttribute("msg", "<script>alert('�޸ĳɹ�');</script>");
		htbgdao.update(map);
		return selectall(null,map1,request);
	}
	/**
	 * ��ѯhtbg��Ϣ
	 */
	@RequestMapping(value="/modify")
	public String modify(Integer id,Map<String,Object> map,HttpServletRequest request){
		String keyid=(String)request.getParameter("keyid");
		List<Map<String,Object>> list= new  ArrayList<Map<String,Object>>();
		list=htbgdao.select(Integer.parseInt(keyid));
		request.setAttribute("htbgid", list.get(0).get("htbgid"));//��ͬ������

		request.setAttribute("htbh", list.get(0).get("htbh"));//��ͬ���

		request.setAttribute("bgsmbgr", list.get(0).get("bgsmbgr"));//���˵�������

		request.setAttribute("sj", list.get(0).get("sj"));//ʱ��

		request.setAttribute("zt", list.get(0).get("zt"));//״̬
	
		
		
		
		
		return "htbg/htbgmodify";
	}
	
	@RequestMapping(value="/detail")
	public String detail(Integer id,Map<String,Object> map,HttpServletRequest request){
		String keyid=(String)request.getParameter("keyid");
		List<Map<String,Object>> list= new  ArrayList<Map<String,Object>>();
		list=htbgdao.select(Integer.parseInt(keyid));
		request.setAttribute("htbgid", list.get(0).get("htbgid"));//��ͬ������

		request.setAttribute("htbh", list.get(0).get("htbh"));//��ͬ���

		request.setAttribute("bgsmbgr", list.get(0).get("bgsmbgr"));//���˵�������

		request.setAttribute("sj", list.get(0).get("sj"));//ʱ��

		request.setAttribute("zt", list.get(0).get("zt"));//״̬

		return "htbg/htbgdetail";
	}
	
	/**
	 * ��ѯhtbg��Ϣ
	 */
	@RequestMapping(value="/selectall")
	public String selectall(Integer id,Map<String,Object> map,HttpServletRequest request){
		List<Map<String,Object>> list= new  ArrayList<Map<String,Object>>();
	Map<String,Object> map1= new HashMap<String,Object>();
		list=htbgdao.selectAll(map1);
		System.out.println("listsize="+list.size());
		
		map.put("mylist", list);
		return "htbg/htbglist";
	}
}
