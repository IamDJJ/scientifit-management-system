package com.scientific.manage.controller;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.scientific.manage.dao.yonghuDao;
import com.scientific.manage.entity.yonghu;
import com.scientific.manage.util.DBO;
import com.scientific.manage.util.StaticMethod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value="/yonghu")
public class yonghuAction {
	/**
	 * �Զ�ע��ҵ���߼��㣬ע�뷽ʽʹ����ע���Զ�ע��
	 */

	@Resource
	yonghuDao yonghudao;
	@RequestMapping(value="/addPage")
	public String addPage(yonghu yonghu, HttpServletRequest request){
		Map<String,Object> map= new HashMap<String,Object>();
		
		System.out.println("addPageok");
		return "yonghu/yonghuadd";
	}
	
	@RequestMapping(value="/add")
	public String add(yonghu yonghu,HttpServletRequest request){
		Map<String,Object> map= new HashMap<String,Object>();
		//String name=(String)request.getParameter("name");

		map.put("yhid", yonghu.getYhid());//�û����

		map.put("yhm", yonghu.getYhm());//�û���

		map.put("mm", StaticMethod.MD5(yonghu.getMm()));//����

		map.put("xm", yonghu.getXm());//����

		map.put("xy", yonghu.getXy());//ѧԺ

		map.put("QQ", yonghu.getQQ());//QQ

		map.put("dh", yonghu.getDh());//�绰

		map.put("xb", yonghu.getXb());//�Ա�

		map.put("nl", yonghu.getNl());//����

		
		String sql="select count(1) as num from yonghu where yhm='"+yonghu.getYhm()+"'";
		ResultSet rs=null;
		int a=0;
		DBO db=new DBO();
		try{
			rs=db.query(sql);
			if(rs.next()){
				a=rs.getInt("num");
				
			}
			
			if(a==0){
				
				yonghudao.save(map);
				
				
				request.setAttribute("msg", "<script>alert('��ӳɹ�');</script>");
			}else{
				
				
				request.setAttribute("msg", "<script>alert('���ʧ�ܡ��û����ظ�');</script>");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		

		System.out.println("addok");
		return "yonghu/yonghuadd";
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
		yonghudao.del(id);
		return selectall(null,map,request);
	}
	/**
	 * �޸�yonghu��Ϣ
	 */
	@RequestMapping(value="/update")
	public String update(yonghu yonghu,HttpServletRequest request,Map<String,Object> map1){
		Map<String,Object> map= new HashMap<String,Object>();
		map.put("yhid", yonghu.getYhid());//�û����

		map.put("yhm", yonghu.getYhm());//�û���

		map.put("mm", yonghu.getMm());//����

		map.put("xm", yonghu.getXm());//����

		map.put("xy", yonghu.getXy());//ѧԺ

		map.put("QQ", yonghu.getQQ());//QQ

		map.put("dh", yonghu.getDh());//�绰

		map.put("xb", yonghu.getXb());//�Ա�

		map.put("nl", yonghu.getNl());//����

		request.setAttribute("msg", "<script>alert('�޸ĳɹ�');</script>");
		yonghudao.update(map);
		return selectall(null,map1,request);
	}
	/**
	 * ��ѯyonghu��Ϣ
	 */
	@RequestMapping(value="/modify")
	public String modify(Integer id,Map<String,Object> map,HttpServletRequest request){
		String keyid=(String)request.getParameter("keyid");
		List<Map<String,Object>> list= new  ArrayList<Map<String,Object>>();
		list=yonghudao.select(Integer.parseInt(keyid));
		request.setAttribute("yhid", list.get(0).get("yhid"));//�û����

		request.setAttribute("yhm", list.get(0).get("yhm"));//�û���

		request.setAttribute("mm", list.get(0).get("mm"));//����

		request.setAttribute("xm", list.get(0).get("xm"));//����

		request.setAttribute("xy", list.get(0).get("xy"));//ѧԺ

		request.setAttribute("QQ", list.get(0).get("QQ"));//QQ

		request.setAttribute("dh", list.get(0).get("dh"));//�绰

		request.setAttribute("xb", list.get(0).get("xb"));//�Ա�

		request.setAttribute("nl", list.get(0).get("nl"));//����

		
		return "yonghu/yonghumodify";
	}
	
	@RequestMapping(value="/detail")
	public String detail(Integer id,Map<String,Object> map,HttpServletRequest request){
		String keyid=(String)request.getParameter("keyid");
		List<Map<String,Object>> list= new  ArrayList<Map<String,Object>>();
		list=yonghudao.select(Integer.parseInt(keyid));
		request.setAttribute("yhid", list.get(0).get("yhid"));//�û����

		request.setAttribute("yhm", list.get(0).get("yhm"));//�û���

		request.setAttribute("mm", list.get(0).get("mm"));//����

		request.setAttribute("xm", list.get(0).get("xm"));//����

		request.setAttribute("xy", list.get(0).get("xy"));//ѧԺ

		request.setAttribute("QQ", list.get(0).get("QQ"));//QQ

		request.setAttribute("dh", list.get(0).get("dh"));//�绰

		request.setAttribute("xb", list.get(0).get("xb"));//�Ա�

		request.setAttribute("nl", list.get(0).get("nl"));//����

		return "yonghu/yonghudetail";
	}
	
	/**
	 * ��ѯyonghu��Ϣ
	 */
	@RequestMapping(value="/selectall")
	public String selectall(Integer id,Map<String,Object> map,HttpServletRequest request){
		List<Map<String,Object>> list= new  ArrayList<Map<String,Object>>();
	Map<String,Object> map1= new HashMap<String,Object>();
		list=yonghudao.selectAll(map1);
		System.out.println("listsize="+list.size());
		
		map.put("mylist", list);
		return "yonghu/yonghulist";
	}
}
