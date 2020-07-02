package com.scientific.manage.dao;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("cqjbDao")
public class cqjbDao {
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	/**
	 * ����cqjb��Ϣ
	 * @param map
	 */
	public void save(Map<String, Object> map) {
		sqlSession.insert("com.cqjb.insertcqjb", map);
		
	}
	/**
	 * ɾ��aa
	 * @param id
	 */
	public void del(Integer id) {
		sqlSession.delete("com.cqjb.delcqjb", id);
	}

	/**
	 * �޸�cqjb��Ϣ
	 * @param map
	 */
	public void update(Map<String, Object> map) {
		sqlSession.update("com.cqjb.updatecqjb", map);
	}

	/**
	 * ��ѯcqjb��Ϣ
	 * @param id
	 * @return 
	 */
	public List<Map<String, Object>> select(Integer id) {
		return sqlSession.selectList("com.cqjb.selectcqjb", id) ; 
	}
	/**
	 * ��ѯcqjb��Ϣ
	 * 
	 * @return 
	 */
	public List<Map<String, Object>> selectAll(Map<String, Object> map) {
		return sqlSession.selectList("com.cqjb.selectall", map) ; 
	}

}
