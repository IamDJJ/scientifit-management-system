package com.scientific.manage.dao;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("xmjxDao")
public class xmjxDao {
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	/**
	 * ����xmjx��Ϣ
	 * @param map
	 */
	public void save(Map<String, Object> map) {
		sqlSession.insert("com.xmjx.insertxmjx", map);
		
	}
	/**
	 * ɾ��aa
	 * @param id
	 */
	public void del(Integer id) {
		sqlSession.delete("com.xmjx.delxmjx", id);
	}

	/**
	 * �޸�xmjx��Ϣ
	 * @param map
	 */
	public void update(Map<String, Object> map) {
		sqlSession.update("com.xmjx.updatexmjx", map);
	}

	/**
	 * ��ѯxmjx��Ϣ
	 * @param id
	 * @return 
	 */
	public List<Map<String, Object>> select(Integer id) {
		return sqlSession.selectList("com.xmjx.selectxmjx", id) ; 
	}
	/**
	 * ��ѯxmjx��Ϣ
	 * 
	 * @return 
	 */
	public List<Map<String, Object>> selectAll(Map<String, Object> map) {
		return sqlSession.selectList("com.xmjx.selectall", map) ; 
	}

}
