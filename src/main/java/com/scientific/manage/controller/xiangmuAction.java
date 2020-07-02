package com.scientific.manage.controller;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.scientific.manage.dao.xiangmuDao;
import com.scientific.manage.entity.xiangmu;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value="/xiangmu")
public class xiangmuAction {
	/**
	 * �Զ�ע��ҵ���߼��㣬ע�뷽ʽʹ����ע���Զ�ע��
	 */

	@Resource
	xiangmuDao xiangmudao;
	@RequestMapping(value="/addPage")
	public String addPage(xiangmu xiangmu, HttpServletRequest request){
		Map<String,Object> map= new HashMap<String,Object>();
		
		System.out.println("addPageok");
		return "xiangmu/xiangmuadd";
	}
	
	@RequestMapping(value="/add")
	public String add(xiangmu xiangmu,HttpServletRequest request){
		Map<String,Object> map= new HashMap<String,Object>();
		//String name=(String)request.getParameter("name");

		map.put("xmid", xiangmu.getXmid());//��Ŀ���

		map.put("xmmc", xiangmu.getXmmc());//��Ŀ����

		map.put("fzr", xiangmu.getFzr());//������

		map.put("xmjd", xiangmu.getXmjd());//��Ŀ�׶�

		map.put("gs", xiangmu.getGs());//����

		map.put("lxsj", xiangmu.getLxsj());//����ʱ��

		map.put("js", xiangmu.getJs());//����

		map.put("yh", xiangmu.getYh());//�û�

		map.put("zt", xiangmu.getZt());//״̬
		map.put("fj", xiangmu.getFj());//״̬
		xiangmudao.save(map);
		
		
		request.setAttribute("msg", "<script>alert('��ӳɹ�');</script>");
		System.out.println("addok");
		return "xiangmu/xiangmuadd";
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
		xiangmudao.del(id);
		return selectall(null,map,request);
	}
	/**
	 * �޸�xiangmu��Ϣ
	 */
	@RequestMapping(value="/update")
	public String update(xiangmu xiangmu,HttpServletRequest request,Map<String,Object> map1){
		Map<String,Object> map= new HashMap<String,Object>();
		map.put("xmid", xiangmu.getXmid());//��Ŀ���

		map.put("xmmc", xiangmu.getXmmc());//��Ŀ����

		map.put("fzr", xiangmu.getFzr());//������

		map.put("xmjd", xiangmu.getXmjd());//��Ŀ�׶�

		map.put("gs", xiangmu.getGs());//����

		map.put("lxsj", xiangmu.getLxsj());//����ʱ��

		map.put("js", xiangmu.getJs());//����

		map.put("yh", xiangmu.getYh());//�û�

		map.put("zt", xiangmu.getZt());//״̬

		map.put("fj", xiangmu.getFj());//״̬
		request.setAttribute("msg", "<script>alert('�޸ĳɹ�');</script>");
		xiangmudao.update(map);
		return selectall(null,map1,request);
	}
	/**
	 * ��ѯxiangmu��Ϣ
	 */
	@RequestMapping(value="/modify")
	public String modify(Integer id,Map<String,Object> map,HttpServletRequest request){
		String keyid=(String)request.getParameter("keyid");
		List<Map<String,Object>> list= new  ArrayList<Map<String,Object>>();
		list=xiangmudao.select(Integer.parseInt(keyid));
		request.setAttribute("xmid", list.get(0).get("xmid"));//��Ŀ���

		request.setAttribute("xmmc", list.get(0).get("xmmc"));//��Ŀ����

		request.setAttribute("fzr", list.get(0).get("fzr"));//������

		request.setAttribute("xmjd", list.get(0).get("xmjd"));//��Ŀ�׶�

		request.setAttribute("gs", list.get(0).get("gs"));//����

		request.setAttribute("lxsj", list.get(0).get("lxsj"));//����ʱ��

		request.setAttribute("js", list.get(0).get("js"));//����

		request.setAttribute("yh", list.get(0).get("yh"));//�û�

		request.setAttribute("zt", list.get(0).get("zt"));//״̬

		request.setAttribute("fj", list.get(0).get("fj"));//״̬
		return "xiangmu/xiangmumodify";
	}
	
	@RequestMapping(value="/detail")
	public String detail(Integer id,Map<String,Object> map,HttpServletRequest request){
		String keyid=(String)request.getParameter("keyid");
		List<Map<String,Object>> list= new  ArrayList<Map<String,Object>>();
		list=xiangmudao.select(Integer.parseInt(keyid));
		request.setAttribute("xmid", list.get(0).get("xmid"));//��Ŀ���
	
		request.setAttribute("xmmc", list.get(0).get("xmmc"));//��Ŀ����

		request.setAttribute("fzr", list.get(0).get("fzr"));//������

		request.setAttribute("xmjd", list.get(0).get("xmjd"));//��Ŀ�׶�

		request.setAttribute("gs", list.get(0).get("gs"));//����

		request.setAttribute("lxsj", list.get(0).get("lxsj"));//����ʱ��

		request.setAttribute("js", list.get(0).get("js"));//����

		request.setAttribute("yh", list.get(0).get("yh"));//�û�

		request.setAttribute("zt", list.get(0).get("zt"));//״̬
		request.setAttribute("fj", list.get(0).get("fj"));//״̬
		return "xiangmu/xiangmudetail";
	}
	
	/**
	 * ��ѯxiangmu��Ϣ
	 */
	@RequestMapping(value="/selectall")
	public String selectall(Integer id,Map<String,Object> map,HttpServletRequest request){
		List<Map<String,Object>> list= new  ArrayList<Map<String,Object>>();
	Map<String,Object> map1= new HashMap<String,Object>();
		list=xiangmudao.selectAll(map1);
		System.out.println("listsize="+list.size());
		
		map.put("mylist", list);
		return "xiangmu/xiangmulist";
	}
	
	/**
	 * ��ѯxiangmu��Ϣ
	 */
	@RequestMapping(value="/myselectall")
	public String myselectall(Integer id,Map<String,Object> map,HttpServletRequest request){
		List<Map<String,Object>> list= new  ArrayList<Map<String,Object>>();
	Map<String,Object> map1= new HashMap<String,Object>();
String qx="",yhm="";
	
	if(request.getSession().getAttribute("yhm")!=null){
		qx=request.getSession().getAttribute("qx").toString();
		yhm=request.getSession().getAttribute("yhm").toString();
		if(!qx.equals("����Ա"))
		map1.put("yhm", yhm);//����
	}
	
	String xmmc=(String)request.getParameter("xmmc");
	System.out.println("xmmc="+xmmc);
	if(xmmc!=null&&!xmmc.equals("")){
		
		map1.put("xmmc", xmmc);//����
	}
		list=xiangmudao.selectAll(map1);
		System.out.println("listsize="+list.size());
		
		map.put("mylist", list);
		return "xiangmu/xiangmumylist";
	}
}
