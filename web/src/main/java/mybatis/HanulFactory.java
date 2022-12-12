package mybatis;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class HanulFactory {
	
	public static SqlSessionFactory factory;
	public static SqlSessionFactory getInstance() {
		
		if(factory == null) {
			String resource = "mybatis/hanul_config.xml";
			InputStream inputStream = null;
			try {
				inputStream = Resources.getResourceAsStream(resource);
				factory = new SqlSessionFactoryBuilder().build(inputStream);
			
			} catch(IOException e) {
				System.out.println(e.getMessage());
			}	
		}
		
		return factory;
	}
	
}
