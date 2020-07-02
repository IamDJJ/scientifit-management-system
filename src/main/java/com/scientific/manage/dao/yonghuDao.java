package com.scientific.manage.dao;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("yonghuDao")
public class yonghuDao {
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	/**
	 * ����yonghu��Ϣ
	 * @param map
	 */
	public void save(Map<String, Object> map) {
		sqlSession.insert("com.yonghu.insertyonghu", map);
		
	}
	/**
	 * ɾ��aa
	 * @param id
	 */
	public void del(Integer id) {
		sqlSession.delete("com.yonghu.delyonghu", id);
	}

	/**
	 * �޸�yonghu��Ϣ
	 * @param map
	 */
	public void update(Map<String, Object> map) {
		sqlSession.update("com.yonghu.updateyonghu", map);
	}

	/**
	 * ��ѯyonghu��Ϣ
	 * @param id
	 * @return 
	 */
	public List<Map<String, Object>> select(Integer id) {
		return sqlSession.selectList("com.yonghu.selectyonghu", id) ; 
	}
	/**
	 * ��ѯyonghu��Ϣ
	 * 
	 * @return 
	 */
	public List<Map<String, Object>> selectAll(Map<String, Object> map) {
		return sqlSession.selectList("com.yonghu.selectall", map) ; 
	}

}
