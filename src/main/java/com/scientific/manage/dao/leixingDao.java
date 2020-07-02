package com.scientific.manage.dao;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("leixingDao")
public class leixingDao {
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	/**
	 * ����leixing��Ϣ
	 * @param map
	 */
	public void save(Map<String, Object> map) {
		sqlSession.insert("com.leixing.insertleixing", map);
		
	}
	/**
	 * ɾ��aa
	 * @param id
	 */
	public void del(Integer id) {
		sqlSession.delete("com.leixing.delleixing", id);
	}

	/**
	 * �޸�leixing��Ϣ
	 * @param map
	 */
	public void update(Map<String, Object> map) {
		sqlSession.update("com.leixing.updateleixing", map);
	}

	/**
	 * ��ѯleixing��Ϣ
	 * @param id
	 * @return 
	 */
	public List<Map<String, Object>> select(Integer id) {
		return sqlSession.selectList("com.leixing.selectleixing", id) ; 
	}
	/**
	 * ��ѯleixing��Ϣ
	 * 
	 * @return 
	 */
	public List<Map<String, Object>> selectAll(Map<String, Object> map) {
		return sqlSession.selectList("com.leixing.selectall", map) ; 
	}

}
