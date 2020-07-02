package com.scientific.manage.dao;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("xmbgDao")
public class xmbgDao {
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	/**
	 * ����xmbg��Ϣ
	 * @param map
	 */
	public void save(Map<String, Object> map) {
		sqlSession.insert("com.xmbg.insertxmbg", map);
		
	}
	/**
	 * ɾ��aa
	 * @param id
	 */
	public void del(Integer id) {
		sqlSession.delete("com.xmbg.delxmbg", id);
	}

	/**
	 * �޸�xmbg��Ϣ
	 * @param map
	 */
	public void update(Map<String, Object> map) {
		sqlSession.update("com.xmbg.updatexmbg", map);
	}

	/**
	 * ��ѯxmbg��Ϣ
	 * @param id
	 * @return 
	 */
	public List<Map<String, Object>> select(Integer id) {
		return sqlSession.selectList("com.xmbg.selectxmbg", id) ; 
	}
	/**
	 * ��ѯxmbg��Ϣ
	 * 
	 * @return 
	 */
	public List<Map<String, Object>> selectAll(Map<String, Object> map) {
		return sqlSession.selectList("com.xmbg.selectall", map) ; 
	}

}
