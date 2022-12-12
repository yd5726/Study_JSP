package mybatis;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisFactory {
	private static SqlSessionFactory factory;
	
	static {
		String resource = "mybatis/config.xml";
		InputStream inputStream;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			factory = new SqlSessionFactoryBuilder().build(inputStream);
		
		} catch(IOException e) {
			System.out.println(e.getMessage());
		}	
	}
	
	public static SqlSessionFactory getInstance() {
		/*
		if(factory == null) {
			String resource = "mybatis/config.xml";
			InputStream inputStream = null;
			try {
				inputStream = Resources.getResourceAsStream(resource);
				//SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
				//session = sqlSessionFactory.openSession(true); // auto commit
				factory = new SqlSessionFactoryBuilder().build(inputStream);
			
			} catch(IOException e) {
				System.out.println(e.getMessage());
			}	
		}
		*/
		return factory;
	}
}
