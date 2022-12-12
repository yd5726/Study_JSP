package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import dto.UserDTO;
import mybatis.MybatisFactory;

public class UserDAO {
	private SqlSession sql;
	
	public UserDTO select_user_info(String id) {
		connect();
		UserDTO dto = sql.selectOne("user.user_info",id);
		return dto;
	}

	public List<UserDTO> select_user_list() {
		connect();
		List<UserDTO> list = sql.selectList("user.select_user_list");
		return list;
	}
	
	public List<String> select_name_all() {
		connect();
		List<String> list = sql.selectList("user.select_name_all");
		return list;
	}
	
	public String select_name() {
		connect();
		String name = sql.selectOne("user.select_name");
		return name;
	}
	
	public int select_money() {
		connect();
		int money = sql.selectOne("user.select_money");
		return money;
	}
	
	void connect() {
		SqlSessionFactory factory =  MybatisFactory.getInstance();
		sql = factory.openSession(true);
	}
}
