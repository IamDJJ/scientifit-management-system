package com.scientific.manage.controller;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.scientific.manage.dao.xmjxDao;
import com.scientific.manage.entity.xmjx;
import com.scientific.manage.util.DBO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value="/xmjx")
public class xmjxAction {
	/**
	 * �Զ�ע��ҵ���߼��㣬ע�뷽ʽʹ����ע���Զ�ע��
	 */

	@Resource
	xmjxDao xmjxdao;
	@RequestMapping(value="/addPage")
	public String addPage(xmjx xmjx, HttpServletRequest request){
		Map<String,Object> map= new HashMap<String,Object>();
		
		System.out.println("addPageok");
		return "xmjx/xmjxadd";
	}
	
	@RequestMapping(value="/add")
	public String add(xmjx xmjx,HttpServletRequest request){
		Map<String,Object> map= new HashMap<String,Object>();
		//String name=(String)request.getParameter("name");

		map.put("xmjxid", xmjx.getXmjxid());//��Ŀ������

		map.put("xm", xmjx.getXm());//��Ŀ

		map.put("jxsm", xmjx.getJxsm());//����˵��

		map.put("yh", xmjx.getYh());//�û�

		map.put("sj", xmjx.getSj());//ʱ��

		map.put("bz", xmjx.getBz());//��ע

		xmjxdao.save(map);

		try{
		String sql="update xiangmu set xmjd='����' where xmid='"+xmjx.getXm()+"'";
		DBO db=new DBO();
		db.update(sql);
		}catch(Exception e){
			
			e.printStackTrace();
		}
		
		request.setAttribute("msg", "<script>alert('��ӳɹ�');</script>");
		System.out.println("addok");
		return "xmjx/xmjxadd";
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
		xmjxdao.del(id);
		return selectall(null,map,request);
	}
	/**
	 * �޸�xmjx��Ϣ
	 */
	@RequestMapping(value="/update")
	public String update(xmjx xmjx,HttpServletRequest request,Map<String,Object> map1){
		Map<String,Object> map= new HashMap<String,Object>();
		map.put("xmjxid", xmjx.getXmjxid());//��Ŀ������

		map.put("xm", xmjx.getXm());//��Ŀ

		map.put("jxsm", xmjx.getJxsm());//����˵��

		map.put("yh", xmjx.getYh());//�û�

		map.put("sj", xmjx.getSj());//ʱ��

		map.put("bz", xmjx.getBz());//��ע

		request.setAttribute("msg", "<script>alert('�޸ĳɹ�');</script>");
		xmjxdao.update(map);
		return selectall(null,map1,request);
	}
	/**
	 * ��ѯxmjx��Ϣ
	 */
	@RequestMapping(value="/modify")
	public String modify(Integer id,Map<String,Object> map,HttpServletRequest request){
		String keyid=(String)request.getParameter("keyid");
		List<Map<String,Object>> list= new  ArrayList<Map<String,Object>>();
		list=xmjxdao.select(Integer.parseInt(keyid));
		request.setAttribute("xmjxid", list.get(0).get("xmjxid"));//��Ŀ������

		request.setAttribute("xm", list.get(0).get("xm"));//��Ŀ

		request.setAttribute("jxsm", list.get(0).get("jxsm"));//����˵��

		request.setAttribute("yh", list.get(0).get("yh"));//�û�

		request.setAttribute("sj", list.get(0).get("sj"));//ʱ��

		request.setAttribute("bz", list.get(0).get("bz"));//��ע

		
		return "xmjx/xmjxmodify";
	}
	
	@RequestMapping(value="/detail")
	public String detail(Integer id,Map<String,Object> map,HttpServletRequest request){
		String keyid=(String)request.getParameter("keyid");
		List<Map<String,Object>> list= new  ArrayList<Map<String,Object>>();
		list=xmjxdao.select(Integer.parseInt(keyid));
		request.setAttribute("xmjxid", list.get(0).get("xmjxid"));//��Ŀ������

		request.setAttribute("xm", list.get(0).get("xm"));//��Ŀ

		request.setAttribute("jxsm", list.get(0).get("jxsm"));//����˵��

		request.setAttribute("yh", list.get(0).get("yh"));//�û�

		request.setAttribute("sj", list.get(0).get("sj"));//ʱ��

		request.setAttribute("bz", list.get(0).get("bz"));//��ע

		return "xmjx/xmjxdetail";
	}
	
	/**
	 * ��ѯxmjx��Ϣ
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
		list=xmjxdao.selectAll(map1);
		System.out.println("listsize="+list.size());
		
		map.put("mylist", list);
		return "xmjx/xmjxlist";
	}
}
