package com.scientific.manage.controller;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.scientific.manage.dao.zscqDao;
import com.scientific.manage.entity.zscq;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value="/zscq")
public class zscqAction {
	/**
	 * �Զ�ע��ҵ���߼��㣬ע�뷽ʽʹ����ע���Զ�ע��
	 */

	@Resource
	zscqDao zscqdao;
	@RequestMapping(value="/addPage")
	public String addPage(zscq zscq, HttpServletRequest request){
		Map<String,Object> map= new HashMap<String,Object>();
		
		System.out.println("addPageok");
		return "zscq/zscqadd";
	}
	
	@RequestMapping(value="/add")
	public String add(zscq zscq,HttpServletRequest request){
		Map<String,Object> map= new HashMap<String,Object>();
		//String name=(String)request.getParameter("name");

		map.put("zscqid", zscq.getZscqid());//֪ʶ��Ȩ���

		map.put("cqmc", zscq.getCqmc());//��Ȩ����

		map.put("lx", zscq.getLx());//����

		map.put("fj", zscq.getFj());//����

		map.put("nr", zscq.getNr());//����

		map.put("cqjb", zscq.getCqjb());//��Ȩ����

		map.put("ytcg", zscq.getYtcg());//���гɹ�

		map.put("djr", zscq.getDjr());//�Ǽ���

		map.put("djsj", zscq.getDjsj());//�Ǽ�ʱ��

		zscqdao.save(map);
		
		
		request.setAttribute("msg", "<script>alert('��ӳɹ�');</script>");
		System.out.println("addok");
		return "zscq/zscqadd";
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
		zscqdao.del(id);
		return selectall(null,map,request);
	}
	/**
	 * �޸�zscq��Ϣ
	 */
	@RequestMapping(value="/update")
	public String update(zscq zscq,HttpServletRequest request,Map<String,Object> map1){
		Map<String,Object> map= new HashMap<String,Object>();
		map.put("zscqid", zscq.getZscqid());//֪ʶ��Ȩ���

		map.put("cqmc", zscq.getCqmc());//��Ȩ����

		map.put("lx", zscq.getLx());//����

		map.put("fj", zscq.getFj());//����

		map.put("nr", zscq.getNr());//����

		map.put("cqjb", zscq.getCqjb());//��Ȩ����

		map.put("ytcg", zscq.getYtcg());//���гɹ�

		map.put("djr", zscq.getDjr());//�Ǽ���

		map.put("djsj", zscq.getDjsj());//�Ǽ�ʱ��

		request.setAttribute("msg", "<script>alert('�޸ĳɹ�');</script>");
		zscqdao.update(map);
		return selectall(null,map1,request);
	}
	/**
	 * ��ѯzscq��Ϣ
	 */
	@RequestMapping(value="/modify")
	public String modify(Integer id,Map<String,Object> map,HttpServletRequest request){
		String keyid=(String)request.getParameter("keyid");
		List<Map<String,Object>> list= new  ArrayList<Map<String,Object>>();
		list=zscqdao.select(Integer.parseInt(keyid));
		request.setAttribute("zscqid", list.get(0).get("zscqid"));//֪ʶ��Ȩ���

		request.setAttribute("cqmc", list.get(0).get("cqmc"));//��Ȩ����

		request.setAttribute("lx", list.get(0).get("lx"));//����

		request.setAttribute("fj", list.get(0).get("fj"));//����

		request.setAttribute("nr", list.get(0).get("nr"));//����

		request.setAttribute("cqjb", list.get(0).get("cqjb"));//��Ȩ����

		request.setAttribute("ytcg", list.get(0).get("ytcg"));//���гɹ�

		request.setAttribute("djr", list.get(0).get("djr"));//�Ǽ���

		request.setAttribute("djsj", list.get(0).get("djsj"));//�Ǽ�ʱ��

		
		return "zscq/zscqmodify";
	}
	
	@RequestMapping(value="/detail")
	public String detail(Integer id,Map<String,Object> map,HttpServletRequest request){
		String keyid=(String)request.getParameter("keyid");
		List<Map<String,Object>> list= new  ArrayList<Map<String,Object>>();
		list=zscqdao.select(Integer.parseInt(keyid));
		request.setAttribute("zscqid", list.get(0).get("zscqid"));//֪ʶ��Ȩ���

		request.setAttribute("cqmc", list.get(0).get("cqmc"));//��Ȩ����

		request.setAttribute("lx", list.get(0).get("lx"));//����

		request.setAttribute("fj", list.get(0).get("fj"));//����

		request.setAttribute("nr", list.get(0).get("nr"));//����

		request.setAttribute("cqjb", list.get(0).get("cqjb"));//��Ȩ����

		request.setAttribute("ytcg", list.get(0).get("ytcg"));//���гɹ�

		request.setAttribute("djr", list.get(0).get("djr"));//�Ǽ���

		request.setAttribute("djsj", list.get(0).get("djsj"));//�Ǽ�ʱ��

		return "zscq/zscqdetail";
	}
	
	/**
	 * ��ѯzscq��Ϣ
	 */
	@RequestMapping(value="/selectall")
	public String selectall(Integer id,Map<String,Object> map,HttpServletRequest request){
		List<Map<String,Object>> list= new  ArrayList<Map<String,Object>>();
	Map<String,Object> map1= new HashMap<String,Object>();
		list=zscqdao.selectAll(map1);
		System.out.println("listsize="+list.size());
		String qx="",yhm="";
		
		if(request.getSession().getAttribute("yhm")!=null){
			qx=request.getSession().getAttribute("qx").toString();
			yhm=request.getSession().getAttribute("yhm").toString();
			if(!qx.equals("����Ա"))
			map1.put("yhm", yhm);//����
		}
		map.put("mylist", list);
		return "zscq/zscqlist";
	}
}
