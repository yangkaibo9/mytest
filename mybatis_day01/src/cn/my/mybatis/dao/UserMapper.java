package cn.my.mybatis.dao;

import java.util.List;
import java.util.Map;

import cn.my.mybatis.domain.Orders;
import cn.my.mybatis.domain.Qureyvo;
import cn.my.mybatis.domain.User;

public interface UserMapper {
	public List<User> findUserByUsername(String username);
	public List<User> findQueryvoByUsername(Qureyvo queryvo);
	public int findByCount();
	public Map findMapById(int id);
	public User findNameById(int id);
	List<User> finduserandorders();
	void updateUser(User user);
}
