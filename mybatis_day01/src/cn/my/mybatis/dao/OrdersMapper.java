package cn.my.mybatis.dao;

import cn.my.mybatis.domain.Orders;
import cn.my.mybatis.domain.OrdersExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrdersMapper {

 Orders findOrder(int id);
}