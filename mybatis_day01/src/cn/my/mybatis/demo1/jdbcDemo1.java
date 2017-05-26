package cn.my.mybatis.demo1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class jdbcDemo1 {
	public static void main(String[] args) {
		ResultSet resultSet=null;
		Connection connection=null;
		PreparedStatement prepareStatement=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mybatis","root","1234");
			prepareStatement = connection.prepareStatement("select * from user where id=?");
			prepareStatement.setInt(1, 1);
			resultSet = prepareStatement.executeQuery();
			System.out.println("resultSet:"+resultSet);
			while(resultSet.next()){
				System.out.println(resultSet.getString("username"));
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}finally {
			if(resultSet!=null){
				try {
					resultSet.close();
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
			}
			if(prepareStatement!=null){
				try {
					prepareStatement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(connection!=null){
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
