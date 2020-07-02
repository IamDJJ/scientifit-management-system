package com.scientific.manage.dao;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("xmzjDao")
public class xmzjDao {
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	/**
	 * ����xmzj��Ϣ
	 * @param map
	 */
	public void save(Map<String, Object> map) {
		sqlSession.insert("com.xmzj.insertxmzj", map);
		
	}
	/**
	 * ɾ��aa
	 * @param id
	 */
	public void del(Integer id) {
		sqlSession.delete("com.xmzj.delxmzj", id);
	}

	/**
	 * �޸�xmzj��Ϣ
	 * @param map
	 */
	public void update(Map<String, Object> map) {
		sqlSession.update("com.xmzj.updatexmzj", map);
	}

	/**
	 * ��ѯxmzj��Ϣ
	 * @param id
	 * @return 
	 */
	public List<Map<String, Object>> select(Integer id) {
		return sqlSession.selectList("com.xmzj.selectxmzj", id) ; 
	}
	/**
	 * ��ѯxmzj��Ϣ
	 * 
	 * @return 
	 */
	public List<Map<String, Object>> selectAll(Map<String, Object> map) {
		return sqlSession.selectList("com.xmzj.selectall", map) ; 
	}

}
