package com.scientific.manage.controller;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.scientific.manage.dao.glyDao;
import com.scientific.manage.entity.gly;
import com.scientific.manage.util.DBO;
import com.scientific.manage.util.StaticMethod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value="/gly")
public class glyAction {

	@Resource
	glyDao glydao;
	@RequestMapping(value="/addPage")
	public String addPage(gly gly, HttpServletRequest request){
		Map<String,Object> map= new HashMap<String,Object>();
		
		System.out.println("addPageok");
		return "gly/glyadd";
	}
	
	@RequestMapping(value="/add")
	public String add(gly gly,HttpServletRequest request){
		Map<String,Object> map= new HashMap<String,Object>();
		//String name=(String)request.getParameter("name");

		map.put("glyid", gly.getGlyid());//����Ա���

		map.put("yhm", gly.getYhm());//�û���

		map.put("mm", StaticMethod.MD5(gly.getMm()));//����

		map.put("xm", gly.getXm());//����

		
		
		
		String sql="select count(1) as num from gly where yhm='"+gly.getYhm()+"'";
		ResultSet rs=null;
		int a=0;
		DBO db=new DBO();
		try{
			rs=db.query(sql);
			if(rs.next()){
				a=rs.getInt("num");
				
			}
			
			if(a==0){
				
				glydao.save(map);
				
				
				request.setAttribute("msg", "<script>alert('��ӳɹ�');</script>");
			}else{
				
				
				request.setAttribute("msg", "<script>alert('���ʧ�ܡ��û����ظ�');</script>");
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		
		//request.setAttribute("msg", "<script>alert('��ӳɹ�');</script>");
		System.out.println("addok");
		return "gly/glyadd";
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
		glydao.del(id);
		return selectall(null,map,request);
	}
	/**
	 * �޸�gly��Ϣ
	 */
	@RequestMapping(value="/update")
	public String update(gly gly,HttpServletRequest request,Map<String,Object> map1){
		Map<String,Object> map= new HashMap<String,Object>();
		map.put("glyid", gly.getGlyid());//����Ա���

		map.put("yhm", gly.getYhm());//�û���

		map.put("mm", gly.getMm());//����

		map.put("xm", gly.getXm());//����

		request.setAttribute("msg", "<script>alert('�޸ĳɹ�');</script>");
		glydao.update(map);
		return selectall(null,map1,request);
	}
	/**
	 * ��ѯgly��Ϣ
	 */
	@RequestMapping(value="/modify")
	public String modify(Integer id,Map<String,Object> map,HttpServletRequest request){
		String keyid=(String)request.getParameter("keyid");
		List<Map<String,Object>> list= new  ArrayList<Map<String,Object>>();
		list=glydao.select(Integer.parseInt(keyid));
		request.setAttribute("glyid", list.get(0).get("glyid"));//����Ա���

		request.setAttribute("yhm", list.get(0).get("yhm"));//�û���

		request.setAttribute("mm", list.get(0).get("mm"));//����

		request.setAttribute("xm", list.get(0).get("xm"));//����

		
		return "gly/glymodify";
	}
	
	@RequestMapping(value="/detail")
	public String detail(Integer id,Map<String,Object> map,HttpServletRequest request){
		String keyid=(String)request.getParameter("keyid");
		List<Map<String,Object>> list= new  ArrayList<Map<String,Object>>();
		list=glydao.select(Integer.parseInt(keyid));
		request.setAttribute("glyid", list.get(0).get("glyid"));//����Ա���

		request.setAttribute("yhm", list.get(0).get("yhm"));//�û���

		request.setAttribute("mm", list.get(0).get("mm"));//����

		request.setAttribute("xm", list.get(0).get("xm"));//����

		return "gly/glydetail";
	}
	
	/**
	 * ��ѯgly��Ϣ
	 */
	@RequestMapping(value="/selectall")
	public String selectall(Integer id,Map<String,Object> map,HttpServletRequest request){
		List<Map<String,Object>> list= new  ArrayList<Map<String,Object>>();
	Map<String,Object> map1= new HashMap<String,Object>();
		list=glydao.selectAll(map1);
		System.out.println("listsize="+list.size());
		
		map.put("mylist", list);
		return "gly/glylist";
	}
}
