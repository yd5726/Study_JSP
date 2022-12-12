package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import dto.ProductDTO;
import mybatis.MybatisFactory;

public class ProductDAO {
	private SqlSession sql;
	
	public ProductDTO select_product_info(int num) {
		connect();
		ProductDTO dto = sql.selectOne("product.product_info",num);
		return dto;
	}
	
	public List<ProductDTO> select_product_all() {
		connect();
		List<ProductDTO> list = sql.selectList("product.select_product_list");
		return list;
	}
	
	void connect() {
		SqlSessionFactory factory =  MybatisFactory.getInstance();
		sql = factory.openSession(true);
	}
}
