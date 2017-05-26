package cn.my.mybatis.demo2;


import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import cn.my.mybatis.dao.OrdersMapper;
import cn.my.mybatis.dao.UserMapper;
import cn.my.mybatis.dao.mybatisDao;
import cn.my.mybatis.dao.mybatisDaoimp;
import cn.my.mybatis.domain.Orders;
import cn.my.mybatis.domain.Qureyvo;
import cn.my.mybatis.domain.User;

public class mybatis_test_demo {
	private SqlSessionFactory sessionFactory;
	@Before
	public void init() throws IOException{
		String resource = "SqlMapConfig.xml";
		InputStream ips = Resources.getResourceAsStream(resource);
		sessionFactory = new SqlSessionFactoryBuilder().build(ips);
		ips.close();
		
	}
	@Test
	public void run1() throws IOException{
		String resource = "SqlMapConfig.xml";
		InputStream input = Resources.getResourceAsStream(resource);
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(input);
		SqlSession session = sessionFactory.openSession();
		User one = session.selectOne("findUserById", 10);
		System.out.println(one);
		session.close();
		input.close();
		
	}
	@Test
	public void run2() throws IOException{
		String resource  ="SqlMapConfig.xml";
		InputStream ips = Resources.getResourceAsStream(resource);
		SqlSessionFactory sessionFactory =  new SqlSessionFactoryBuilder().build(ips);
		SqlSession openSession = sessionFactory.openSession();
		List<User> user = openSession.selectList("findUserByUsername", "张");
		System.out.println(user);
		openSession.close();
		ips.close();
		
	}
	@Test
	public void run3() throws IOException{
		String resource  ="SqlMapConfig.xml";
		InputStream ips = Resources.getResourceAsStream(resource);
		SqlSessionFactory sessionFactory =  new SqlSessionFactoryBuilder().build(ips);
		SqlSession openSession = sessionFactory.openSession();
		User user = new User();
		user.setUsername("小红");
		user.setSex("1");
		openSession.insert("addUser",user);
		System.out.println(user.getId());
		openSession.commit();
		System.out.println("后："+user.getId());
		
		openSession.close();
		ips.close();
		
	}
	@Test
	public void run4(){
		mybatisDao dao = new mybatisDaoimp(sessionFactory);
		User user = dao.findbyid(10);
		System.out.println(user);
	}
	@Test
	public void run5(){
		SqlSession openSession = sessionFactory.openSession();
		UserMapper mapper = openSession.getMapper(UserMapper.class);
		List<User> list = mapper.findUserByUsername("张三");
		
		
		System.out.println(list);
	}
	@Test
	public void run6(){
		SqlSession openSession = sessionFactory.openSession();
		UserMapper mapper = openSession.getMapper(UserMapper.class);
		User user = new User();
		user.setUsername("张");
		Qureyvo q = new Qureyvo();
		q.setUser(user);
		List<User> list = mapper.findQueryvoByUsername(q);
		
		
		System.out.println(list);
	}
	@Test
	public void run7(){
		SqlSession openSession = sessionFactory.openSession();
		UserMapper mapper = openSession.getMapper(UserMapper.class);
		int count = mapper.findByCount();
		
		
		System.out.println(count);
	}
	@Test
	public void run8(){
		SqlSession openSession = sessionFactory.openSession();
		UserMapper mapper = openSession.getMapper(UserMapper.class);
		Map user = mapper.findMapById(10);		
		System.out.println(user);
	}
	@Test
	public void run9(){
		SqlSession openSession = sessionFactory.openSession();
		UserMapper mapper = openSession.getMapper(UserMapper.class);
		User user = mapper.findNameById(10);		
		System.out.println(user);
	}
	@Test
	public void run10(){
		SqlSession openSession = sessionFactory.openSession();
		OrdersMapper mapper = openSession.getMapper(OrdersMapper.class);
		Orders user = mapper.findOrder(3);		
		System.out.println(user);
	}
	@Test
	public void run11(){
		SqlSession openSession = sessionFactory.openSession();
		UserMapper mapper = openSession.getMapper(UserMapper.class);
		List<User> user = mapper.finduserandorders();		
		System.out.println(user);
	}
	@Test
	public void run12(){
		SqlSession openSession = sessionFactory.openSession();
		UserMapper mapper = openSession.getMapper(UserMapper.class);
		User user = new User();
		user.setId(33);
		user.setSex("1");
		int[] ids = {1,2,3};
		user.setIds(ids);
		mapper.updateUser(user);		
		
	}
	
}
