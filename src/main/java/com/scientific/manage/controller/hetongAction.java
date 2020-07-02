package com.scientific.manage.controller;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.scientific.manage.dao.hetongDao;
import com.scientific.manage.entity.hetong;
import com.scientific.manage.util.DBO;
import com.scientific.manage.util.StaticMethod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value="/hetong")
public class hetongAction {
	/**
	 * �Զ�ע��ҵ���߼��㣬ע�뷽ʽʹ����ע���Զ�ע��
	 */

	@Resource
	hetongDao hetongdao;
	@RequestMapping(value="/addPage")
	public String addPage(hetong hetong, HttpServletRequest request){
		Map<String,Object> map= new HashMap<String,Object>();
		
		System.out.println("addPageok");
		return "hetong/hetongadd";
	}
	
	@RequestMapping(value="/add")
	public String add(hetong hetong,HttpServletRequest request){
		Map<String,Object> map= new HashMap<String,Object>();
		//String name=(String)request.getParameter("name");

		map.put("htid", hetong.getHtid());//��ͬ���

		map.put("htbt", hetong.getHtbt());//��ͬ����

		map.put("htbh", hetong.getHtbh());//��ͬ���

		map.put("htnr", hetong.getHtnr());//��ͬ����

		map.put("qcsj", hetong.getQcsj());//���ʱ��

		map.put("qcr", hetong.getQcr());//�����

		map.put("jf", hetong.getJf());//�׷�

		map.put("jflxfs", hetong.getJflxfs());//�׷���ϵ��ʽ

		map.put("yf", hetong.getYf());//�ҷ�

		map.put("yflxfs", hetong.getYflxfs());//�ҷ���ϵ��ʽ

		map.put("zt", hetong.getZt());//״̬
		
		map.put("fj", hetong.getFj());//״̬

		hetongdao.save(map);
		
		
		request.setAttribute("msg", "<script>alert('��ӳɹ�');</script>");
		System.out.println("addok");
		return "hetong/hetongadd";
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
		hetongdao.del(id);
		return selectall(null,map,request);
	}
	/**
	 * �޸�hetong��Ϣ
	 */
	@RequestMapping(value="/update")
	public String update(hetong hetong,HttpServletRequest request,Map<String,Object> map1){
		Map<String,Object> map= new HashMap<String,Object>();
		map.put("htid", hetong.getHtid());//��ͬ���

		map.put("htbt", hetong.getHtbt());//��ͬ����

		map.put("htbh", hetong.getHtbh());//��ͬ���

		map.put("htnr", hetong.getHtnr());//��ͬ����

		map.put("qcsj", hetong.getQcsj());//���ʱ��

		map.put("qcr", hetong.getQcr());//�����

		map.put("jf", hetong.getJf());//�׷�

		map.put("jflxfs", hetong.getJflxfs());//�׷���ϵ��ʽ

		map.put("yf", hetong.getYf());//�ҷ�

		map.put("yflxfs", hetong.getYflxfs());//�ҷ���ϵ��ʽ

		map.put("zt", hetong.getZt());//״̬

		
		map.put("fj", hetong.getFj());//״̬
		request.setAttribute("msg", "<script>alert('�޸ĳɹ�');</script>");
		hetongdao.update(map);
		return selectall(null,map1,request);
	}
	/**
	 * ��ѯhetong��Ϣ
	 */
	@RequestMapping(value="/modify")
	public String modify(Integer id,Map<String,Object> map,HttpServletRequest request){
		String keyid=(String)request.getParameter("keyid");
		List<Map<String,Object>> list= new  ArrayList<Map<String,Object>>();
		list=hetongdao.select(Integer.parseInt(keyid));
		request.setAttribute("htid", list.get(0).get("htid"));//��ͬ���

		request.setAttribute("htbt", list.get(0).get("htbt"));//��ͬ����

		request.setAttribute("htbh", list.get(0).get("htbh"));//��ͬ���

		request.setAttribute("htnr", list.get(0).get("htnr"));//��ͬ����

		request.setAttribute("qcsj", list.get(0).get("qcsj"));//���ʱ��

		request.setAttribute("qcr", list.get(0).get("qcr"));//�����

		request.setAttribute("jf", list.get(0).get("jf"));//�׷�

		request.setAttribute("jflxfs", list.get(0).get("jflxfs"));//�׷���ϵ��ʽ

		request.setAttribute("yf", list.get(0).get("yf"));//�ҷ�

		request.setAttribute("yflxfs", list.get(0).get("yflxfs"));//�ҷ���ϵ��ʽ

		request.setAttribute("zt", list.get(0).get("zt"));//״̬
		request.setAttribute("fj", list.get(0).get("fj"));//״̬
		
		return "hetong/hetongmodify";
	}
	
	
	/**
	 * �޸�hetong��Ϣ
	 */
	@RequestMapping(value="/updatea")
	public String updatea(hetong hetong,HttpServletRequest request,Map<String,Object> map1){
		Map<String,Object> map= new HashMap<String,Object>();
		map.put("htid", hetong.getHtid());//��ͬ���

		map.put("htbt", hetong.getHtbt());//��ͬ����

		map.put("htbh", hetong.getHtbh());//��ͬ���

		map.put("htnr", hetong.getHtnr());//��ͬ����

		map.put("qcsj", hetong.getQcsj());//���ʱ��

		map.put("qcr", hetong.getQcr());//�����

		map.put("jf", hetong.getJf());//�׷�

		map.put("jflxfs", hetong.getJflxfs());//�׷���ϵ��ʽ

		map.put("yf", hetong.getYf());//�ҷ�

		map.put("yflxfs", hetong.getYflxfs());//�ҷ���ϵ��ʽ

		map.put("fj", hetong.getFj());//�ҷ���ϵ��ʽ
		String zt=hetong.getZt();
		
		
		String bgjl=(String)request.getParameter("bgjl");
		DBO db=new DBO();
		String sql="";
		try{
		if(zt.equals("δ���")){
		//ֻ��¼ �������������������Ҫ �Ա����¼��� ��������
			
			map.put("zt", hetong.getZt());//״̬ //״̬
			
			 sql="insert into htbg(htbh,bgsmbgr,sj,zt) values('"+hetong.getHtbh()+"','"+bgjl+"','"+ StaticMethod.getStringDate()+"','ͨ��')";//δ�������Ĳ���Ҫ��ˣ�ֱ��Ĭ�� ͨ��
			
		}else{
			//����Ѿ���˹�����ô ��� ԭ����ͬ��Ϣ����������ˣ���Ҫ�Ա����¼��Ϣ��ˣ����ͨ���ˣ����ܶ���Ч��ͬ��¼
			map.put("zt", "���δ���");//״̬ //״̬
			 sql="insert into htbg(htbh,bgsmbgr,sj,zt) values('"+hetong.getHtbh()+"','"+bgjl+"','" + StaticMethod.getStringDate()+"','δ���')";//ֱ�ӶԱ����¼������Ϣ��ˣ����ǲ��ܶԺ�ͬ�����
		}
		
		db.update(sql);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		

		request.setAttribute("msg", "<script>alert('�޸ĳɹ�');</script>");
		hetongdao.update(map);
		return myselectall(null,map1,request);
	}
	/**
	 * ��ѯhetong��Ϣ
	 */
	@RequestMapping(value="/modifya")
	public String modifya(Integer id,Map<String,Object> map,HttpServletRequest request){
		String keyid=(String)request.getParameter("keyid");
		List<Map<String,Object>> list= new  ArrayList<Map<String,Object>>();
		list=hetongdao.select(Integer.parseInt(keyid));
		request.setAttribute("htid", list.get(0).get("htid"));//��ͬ���

		request.setAttribute("htbt", list.get(0).get("htbt"));//��ͬ����

		request.setAttribute("htbh", list.get(0).get("htbh"));//��ͬ���

		request.setAttribute("htnr", list.get(0).get("htnr"));//��ͬ����

		request.setAttribute("qcsj", list.get(0).get("qcsj"));//���ʱ��

		request.setAttribute("qcr", list.get(0).get("qcr"));//�����

		request.setAttribute("jf", list.get(0).get("jf"));//�׷�

		request.setAttribute("jflxfs", list.get(0).get("jflxfs"));//�׷���ϵ��ʽ

		request.setAttribute("yf", list.get(0).get("yf"));//�ҷ�

		request.setAttribute("yflxfs", list.get(0).get("yflxfs"));//�ҷ���ϵ��ʽ

		request.setAttribute("zt", list.get(0).get("zt"));//״̬
		request.setAttribute("fj", list.get(0).get("fj"));//״̬
		
		return "hetong/modify";
	}
	
	@RequestMapping(value="/detail")
	public String detail(Integer id,Map<String,Object> map,HttpServletRequest request){
		String keyid=(String)request.getParameter("keyid");
		List<Map<String,Object>> list= new  ArrayList<Map<String,Object>>();
		list=hetongdao.select(Integer.parseInt(keyid));
		request.setAttribute("htid", list.get(0).get("htid"));//��ͬ���
		request.setAttribute("keyid", keyid);//��ͬ���
		request.setAttribute("htbt", list.get(0).get("htbt"));//��ͬ����

		request.setAttribute("htbh", list.get(0).get("htbh"));//��ͬ���

		request.setAttribute("htnr", list.get(0).get("htnr"));//��ͬ����

		request.setAttribute("qcsj", list.get(0).get("qcsj"));//���ʱ��

		request.setAttribute("qcr", list.get(0).get("qcr"));//�����

		request.setAttribute("jf", list.get(0).get("jf"));//�׷�

		request.setAttribute("jflxfs", list.get(0).get("jflxfs"));//�׷���ϵ��ʽ

		request.setAttribute("yf", list.get(0).get("yf"));//�ҷ�

		request.setAttribute("yflxfs", list.get(0).get("yflxfs"));//�ҷ���ϵ��ʽ

		request.setAttribute("zt", list.get(0).get("zt"));//״̬
		request.setAttribute("fj", list.get(0).get("fj"));//״̬
		return "hetong/hetongdetail";
	}
	
	/**
	 * ��ѯhetong��Ϣ
	 */
	@RequestMapping(value="/selectall")
	public String selectall(Integer id,Map<String,Object> map,HttpServletRequest request){
		List<Map<String,Object>> list= new  ArrayList<Map<String,Object>>();
	Map<String,Object> map1= new HashMap<String,Object>();
		list=hetongdao.selectAll(map1);
		System.out.println("listsize="+list.size());
		
		map.put("mylist", list);
		return "hetong/hetonglist";
	}
	
	
	/**
	 * ��ѯhetong��Ϣ
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
	
	String htmc=(String)request.getParameter("htmc");
	System.out.println("htmc="+htmc);
	if(htmc!=null&&!htmc.equals("")){
		
		map1.put("htmc", htmc);//����
	}
	
		list=hetongdao.selectAll(map1);
		System.out.println("listsize11="+list.size());
		
		map.put("mylist", list);
		return "hetong/hetongmylist";
	}
}
