package dao;

import java.sql.Date;
/*import java.sql.PreparedStatement;*/

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import mybatis.MybatisFactory;

public class TestDAO {
	private SqlSession sql;
	
	/*  매퍼의 식별자 : namespace
	 * PreparedStatement에서의 메소드/ SqlSession에서의 메소드
	 * executeQuery() / selectOne, selectList("메퍼의namespace.쿼리태그id")
	 * executeUpdate() / update, insert, delete
	 */
	
	public Date select_today() {
		connect();
		Date today = sql.selectOne("test.select_today");
		return today;
	}
	
	public String select_now() {
		connect();
		String now = sql.selectOne("test.select_now");
		return now;
	}
	
	public int user_count() {
		connect();
		int count = sql.selectOne("test.user_count");
		return count;
	}
	
	// DB 연결
	void connect() {
		SqlSessionFactory factory =  MybatisFactory.getInstance();
		sql = factory.openSession(true);
		//sql.selectOne("");
		/*
		String resource = "mybatis/config.xml";
		InputStream inputStream = null;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			session = sqlSessionFactory.openSession(true); // auto commit
		
		} catch(IOException e) {
			System.out.println(e.getMessage());
		}
		*/
	}
	
	
	/*
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	
	// DB 연결
	void connect() {
		try {
			//context.xml에 선언한 Resource 찾기
			Context context = new InitialContext();
			DataSource ds = (DataSource)context.lookup("java:/comp/env/smart");
			conn = ds.getConnection();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}//connect()
	
	// 쿼리문 실행 후 자원회수
	void disconnect() {
		if(rs != null) {
			try {
				rs.close();
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}	
		}
		if(ps != null) {
			try {
				ps.close();
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}	
		}
		if(conn != null) {
			try {
				conn.close();
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}	
		}
	}//disconnect()
	
	// 오늘 날짜를 조회하는 메소드
	public Date select_today() {
		Date today = null; //java.sql.Date
		connect();
		String sql = "select sysdate from dual";
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			rs.next(); // 커서 이동
			today = rs.getDate("sysdate");
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}finally {
			disconnect();
		}
		return today;
	}//select_today()
	*/
}