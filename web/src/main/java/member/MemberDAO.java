package member;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import mybatis.HanulFactory;

public class MemberDAO {
	private SqlSession sql;
	
	// 회원 정보 신규 저장
	public void member_insert(MemberDTO dto) {
		connect();
		sql.insert("member.insert", dto);
		sql.close();
	}
	
	// 회원 정보 변경 저장
	public void member_update(MemberDTO dto) {
		connect();
		sql.update("member.update", dto);
		sql.close();
	}
	
	// 아이디 존재여부확인 메소드
	public int idExist(String id) {
		connect();
		int count = sql.selectOne("member.userid_exist", id);
		return count;
	}
	
	// 로그인 메소드
	public MemberDTO login(String id, String pw) {
		connect();
		// 쿼리실행 메소드의 파라미터는 2개만 지정할 수 있다.
		// 전달한 데이터에 해당하는 파라미터가 여러 개의 값이라면,
		// 데이터 객체(DTO)를 사용하거나, HashMap을 지정한다.
		//sql.selectOne("member.login",id,pw);//불가
		HashMap<String,String> map = new HashMap<String,String>();
		map.put("id", id);
		map.put("pw", pw);
		
		MemberDTO dto = sql.selectOne("member.login",map);
		sql.close();
		return dto;
	}
	
	private void connect() {
		SqlSessionFactory factory = HanulFactory.getInstance();
		sql = factory.openSession(true);
	}
}
