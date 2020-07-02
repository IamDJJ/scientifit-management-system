package com.scientific.manage.dao;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("hetongDao")
public class hetongDao {
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	/**
	 * ����hetong��Ϣ
	 * @param map
	 */
	public void save(Map<String, Object> map) {
		sqlSession.insert("com.hetong.inserthetong", map);
		
	}
	/**
	 * ɾ��aa
	 * @param id
	 */
	public void del(Integer id) {
		sqlSession.delete("com.hetong.delhetong", id);
	}

	/**
	 * �޸�hetong��Ϣ
	 * @param map
	 */
	public void update(Map<String, Object> map) {
		sqlSession.update("com.hetong.updatehetong", map);
	}

	/**
	 * ��ѯhetong��Ϣ
	 * @param id
	 * @return 
	 */
	public List<Map<String, Object>> select(Integer id) {
		return sqlSession.selectList("com.hetong.selecthetong", id) ; 
	}
	/**
	 * ��ѯhetong��Ϣ
	 * 
	 * @return 
	 */
	public List<Map<String, Object>> selectAll(Map<String, Object> map) {
		return sqlSession.selectList("com.hetong.selectall", map) ; 
	}

}
