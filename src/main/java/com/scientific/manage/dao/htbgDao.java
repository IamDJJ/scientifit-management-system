package com.scientific.manage.dao;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("htbgDao")
public class htbgDao {
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	/**
	 * ����htbg��Ϣ
	 * @param map
	 */
	public void save(Map<String, Object> map) {
		sqlSession.insert("com.htbg.inserthtbg", map);
		
	}
	/**
	 * ɾ��aa
	 * @param id
	 */
	public void del(Integer id) {
		sqlSession.delete("com.htbg.delhtbg", id);
	}

	/**
	 * �޸�htbg��Ϣ
	 * @param map
	 */
	public void update(Map<String, Object> map) {
		sqlSession.update("com.htbg.updatehtbg", map);
	}

	/**
	 * ��ѯhtbg��Ϣ
	 * @param id
	 * @return 
	 */
	public List<Map<String, Object>> select(Integer id) {
		return sqlSession.selectList("com.htbg.selecthtbg", id) ; 
	}
	/**
	 * ��ѯhtbg��Ϣ
	 * 
	 * @return 
	 */
	public List<Map<String, Object>> selectAll(Map<String, Object> map) {
		return sqlSession.selectList("com.htbg.selectall", map) ; 
	}

}
