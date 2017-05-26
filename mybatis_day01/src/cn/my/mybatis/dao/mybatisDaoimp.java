package cn.my.mybatis.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import cn.my.mybatis.domain.User;

public class mybatisDaoimp implements mybatisDao {

	private SqlSessionFactory sessionFactory;
	public mybatisDaoimp(SqlSessionFactory sessionFactory) {
		this.sessionFactory=sessionFactory;
	}
	@Override
	public User findbyid(int id) {
		SqlSession openSession = sessionFactory.openSession();
		User user = openSession.selectOne("findUserById", id);
		openSession.close();
		return user;
	}

}
