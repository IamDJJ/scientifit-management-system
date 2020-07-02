package com.scientific.manage.controller;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.scientific.manage.dao.xmbgDao;
import com.scientific.manage.entity.xmbg;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value="/xmbg")
public class xmbgAction {
	/**
	 * �Զ�ע��ҵ���߼��㣬ע�뷽ʽʹ����ע���Զ�ע��
	 */

	@Resource
	xmbgDao xmbgdao;
	@RequestMapping(value="/addPage")
	public String addPage(xmbg xmbg, HttpServletRequest request){
		Map<String,Object> map= new HashMap<String,Object>();
		
		System.out.println("addPageok");
		return "xmbg/xmbgadd";
	}
	
	@RequestMapping(value="/add")
	public String add(xmbg xmbg,HttpServletRequest request){
		Map<String,Object> map= new HashMap<String,Object>();
		//String name=(String)request.getParameter("name");

		map.put("xmbgid", xmbg.getXmbgid());//��Ŀ������

		map.put("xm", xmbg.getXm());//��Ŀ

		map.put("bgnr", xmbg.getBgnr());//�������

		map.put("xmsm", xmbg.getXmsm());//��Ŀ˵��

		xmbgdao.save(map);
		
		
		request.setAttribute("msg", "<script>alert('��ӳɹ�');</script>");
		System.out.println("addok");
		return "xmbg/xmbgadd";
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
		xmbgdao.del(id);
		return selectall(null,map,request);
	}
	/**
	 * �޸�xmbg��Ϣ
	 */
	@RequestMapping(value="/update")
	public String update(xmbg xmbg,HttpServletRequest request,Map<String,Object> map1){
		Map<String,Object> map= new HashMap<String,Object>();
		map.put("xmbgid", xmbg.getXmbgid());//��Ŀ������

		map.put("xm", xmbg.getXm());//��Ŀ

		map.put("bgnr", xmbg.getBgnr());//�������

		map.put("xmsm", xmbg.getXmsm());//��Ŀ˵��

		request.setAttribute("msg", "<script>alert('�޸ĳɹ�');</script>");
		xmbgdao.update(map);
		return selectall(null,map1,request);
	}
	/**
	 * ��ѯxmbg��Ϣ
	 */
	@RequestMapping(value="/modify")
	public String modify(Integer id,Map<String,Object> map,HttpServletRequest request){
		String keyid=(String)request.getParameter("keyid");
		List<Map<String,Object>> list= new  ArrayList<Map<String,Object>>();
		list=xmbgdao.select(Integer.parseInt(keyid));
		request.setAttribute("xmbgid", list.get(0).get("xmbgid"));//��Ŀ������

		request.setAttribute("xm", list.get(0).get("xm"));//��Ŀ

		request.setAttribute("bgnr", list.get(0).get("bgnr"));//�������

		request.setAttribute("xmsm", list.get(0).get("xmsm"));//��Ŀ˵��

		
		return "xmbg/xmbgmodify";
	}
	
	@RequestMapping(value="/detail")
	public String detail(Integer id,Map<String,Object> map,HttpServletRequest request){
		String keyid=(String)request.getParameter("keyid");
		List<Map<String,Object>> list= new  ArrayList<Map<String,Object>>();
		list=xmbgdao.select(Integer.parseInt(keyid));
		request.setAttribute("xmbgid", list.get(0).get("xmbgid"));//��Ŀ������

		request.setAttribute("xm", list.get(0).get("xm"));//��Ŀ

		request.setAttribute("bgnr", list.get(0).get("bgnr"));//�������

		request.setAttribute("xmsm", list.get(0).get("xmsm"));//��Ŀ˵��

		return "xmbg/xmbgdetail";
	}
	
	/**
	 * ��ѯxmbg��Ϣ
	 */
	@RequestMapping(value="/selectall")
	public String selectall(Integer id,Map<String,Object> map,HttpServletRequest request){
		List<Map<String,Object>> list= new  ArrayList<Map<String,Object>>();
	Map<String,Object> map1= new HashMap<String,Object>();
String qx="",yhm="";
	
	if(request.getSession().getAttribute("yhm")!=null){
		qx=request.getSession().getAttribute("qx").toString();
		yhm=request.getSession().getAttribute("yhm").toString();
		if(!qx.equals("����Ա"))
		map1.put("yhm", yhm);//����
	}
		list=xmbgdao.selectAll(map1);
		System.out.println("listsize="+list.size());
		
		map.put("mylist", list);
		return "xmbg/xmbglist";
	}
}
