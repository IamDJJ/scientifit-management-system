package com.scientific.manage.dao;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("xiangmuDao")
public class xiangmuDao {
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	/**
	 * ����xiangmu��Ϣ
	 * @param map
	 */
	public void save(Map<String, Object> map) {
		sqlSession.insert("com.xiangmu.insertxiangmu", map);
		
	}
	/**
	 * ɾ��aa
	 * @param id
	 */
	public void del(Integer id) {
		sqlSession.delete("com.xiangmu.delxiangmu", id);
	}

	/**
	 * �޸�xiangmu��Ϣ
	 * @param map
	 */
	public void update(Map<String, Object> map) {
		sqlSession.update("com.xiangmu.updatexiangmu", map);
	}

	/**
	 * ��ѯxiangmu��Ϣ
	 * @param id
	 * @return 
	 */
	public List<Map<String, Object>> select(Integer id) {
		return sqlSession.selectList("com.xiangmu.selectxiangmu", id) ; 
	}
	/**
	 * ��ѯxiangmu��Ϣ
	 * 
	 * @return 
	 */
	public List<Map<String, Object>> selectAll(Map<String, Object> map) {
		return sqlSession.selectList("com.xiangmu.selectall", map) ; 
	}

}
