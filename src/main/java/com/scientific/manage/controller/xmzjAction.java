package com.scientific.manage.controller;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.scientific.manage.dao.xmzjDao;
import com.scientific.manage.entity.xmzj;
import com.scientific.manage.util.DBO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value="/xmzj")
public class xmzjAction {
	/**
	 * �Զ�ע��ҵ���߼��㣬ע�뷽ʽʹ����ע���Զ�ע��
	 */

	@Resource
	xmzjDao xmzjdao;
	@RequestMapping(value="/addPage")
	public String addPage(xmzj xmzj, HttpServletRequest request){
		Map<String,Object> map= new HashMap<String,Object>();
		
		System.out.println("addPageok");
		return "xmzj/xmzjadd";
	}
	
	@RequestMapping(value="/add")
	public String add(xmzj xmzj,HttpServletRequest request){
		Map<String,Object> map= new HashMap<String,Object>();
		//String name=(String)request.getParameter("name");

		map.put("xmzjid", xmzj.getXmzjid());//��Ŀ�м���

		map.put("xm", xmzj.getXm());//��Ŀ

		map.put("zjnr", xmzj.getZjnr());//�м�����

		map.put("yh", xmzj.getYh());//�û�

		map.put("sj", xmzj.getSj());//ʱ��

		xmzjdao.save(map);
		
		try{
		String sql="update xiangmu set xmjd='�м�' where xmid='"+xmzj.getXm()+"'";
		DBO db=new DBO();
		db.update(sql);
		}catch(Exception e){
			
			e.printStackTrace();
		}
		
		
		request.setAttribute("msg", "<script>alert('��ӳɹ�');</script>");
		System.out.println("addok");
		return "xmzj/xmzjadd";
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
		xmzjdao.del(id);
		return selectall(null,map,request);
	}
	/**
	 * �޸�xmzj��Ϣ
	 */
	@RequestMapping(value="/update")
	public String update(xmzj xmzj,HttpServletRequest request,Map<String,Object> map1){
		Map<String,Object> map= new HashMap<String,Object>();
		map.put("xmzjid", xmzj.getXmzjid());//��Ŀ�м���

		map.put("xm", xmzj.getXm());//��Ŀ

		map.put("zjnr", xmzj.getZjnr());//�м�����

		map.put("yh", xmzj.getYh());//�û�

		map.put("sj", xmzj.getSj());//ʱ��

		request.setAttribute("msg", "<script>alert('�޸ĳɹ�');</script>");
		xmzjdao.update(map);
		return selectall(null,map1,request);
	}
	/**
	 * ��ѯxmzj��Ϣ
	 */
	@RequestMapping(value="/modify")
	public String modify(Integer id,Map<String,Object> map,HttpServletRequest request){
		String keyid=(String)request.getParameter("keyid");
		List<Map<String,Object>> list= new  ArrayList<Map<String,Object>>();
		list=xmzjdao.select(Integer.parseInt(keyid));
		request.setAttribute("xmzjid", list.get(0).get("xmzjid"));//��Ŀ�м���

		request.setAttribute("xm", list.get(0).get("xm"));//��Ŀ

		request.setAttribute("zjnr", list.get(0).get("zjnr"));//�м�����

		request.setAttribute("yh", list.get(0).get("yh"));//�û�

		request.setAttribute("sj", list.get(0).get("sj"));//ʱ��

		
		return "xmzj/xmzjmodify";
	}
	
	@RequestMapping(value="/detail")
	public String detail(Integer id,Map<String,Object> map,HttpServletRequest request){
		String keyid=(String)request.getParameter("keyid");
		List<Map<String,Object>> list= new  ArrayList<Map<String,Object>>();
		list=xmzjdao.select(Integer.parseInt(keyid));
		request.setAttribute("xmzjid", list.get(0).get("xmzjid"));//��Ŀ�м���

		request.setAttribute("xm", list.get(0).get("xm"));//��Ŀ

		request.setAttribute("zjnr", list.get(0).get("zjnr"));//�м�����

		request.setAttribute("yh", list.get(0).get("yh"));//�û�

		request.setAttribute("sj", list.get(0).get("sj"));//ʱ��

		return "xmzj/xmzjdetail";
	}
	
	/**
	 * ��ѯxmzj��Ϣ
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
		list=xmzjdao.selectAll(map1);
		System.out.println("listsize="+list.size());
		
		map.put("mylist", list);
		return "xmzj/xmzjlist";
	}
}
