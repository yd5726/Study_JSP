package member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import common.Command;
import common.CommonUtility;
import member.MemberDAO;
import member.MemberDTO;

public class NaverCallback implements Command {

	// 3.4.3 네이버 로그인 연동 결과 Callback 정보 
	// API 요청 성공시 : http://콜백URL/redirect?code={code값}&state={state값}
	// API 요청 실패시 : http://콜백URL/redirect?state={state값}&error={에러코드값}&error_description={에러메시지}
	@Override
	public void exec(HttpServletRequest request, HttpServletResponse response) {
		String state = request.getParameter("state");
		String code = request.getParameter("code");
		
		// API 요청 성공하면 code 값이 있고, 실패하면 NULL
		// 세션에 저장(NaverLogin)해둔 state와 파라미터로 받은 state가 같은지 확인
		String session_state = (String)request.getSession().getAttribute("state");
		if(state.equals(session_state) && code != null) {
			// 3.4.4 접근 토큰 발급 요청
			// Callback으로 전달받은 'code' 값을 이용하여 '접근토큰발급API'를 호출하게 되면 API 응답으로 접근토큰에 대한 정보를 받을 수 있습니다.
			// 'code' 값을 이용한 API호출은 최초 1번만 수행할 수 있으며 접근 토큰 발급이 완료되면 사용된 'code'는 더 이상 재사용할수 없습니다.
			//https://nid.naver.com/oauth2.0/token?grant_type=authorization_code&client_id=jyvqXeaVOVmV&client_secret=527300A0_COq1_XV33cf&code=EIc5bFrl4RibFls1&state=9kgsGTfH4j7IyAkg
			//https://nid.naver.com/oauth2.0/token?grant_type=authorization_code
			//&client_id=jyvqXeaVOVmV
			//&client_secret=527300A0_COq1_XV33cf
			//&code=EIc5bFrl4RibFls1
			//&state=9kgsGTfH4j7IyAkg
			StringBuffer url = new StringBuffer("https://nid.naver.com/oauth2.0/token?grant_type=authorization_code");
			url.append("&client_id=").append((String)request.getAttribute("naver_id"));
			url.append("&client_secret=").append((String)request.getAttribute("naver_secret"));
			url.append("&code=").append(code);
			url.append("&state=").append(state);
			
			//네이버 로그인 API 명세
			//네이버 로그인 접근토큰 획득 예제는 2개의 프로그램으로 구성되어 있습니다. (naverlogin.jsp, callback.jsp)
			//callback.jsp
			//String --> JSON 6.2.2. 접근 토큰 발급 요청
			String tokens = CommonUtility.requestAPI(url.toString());
			/*
			 * { "access_token":
			 * "AAAAQosjWDJieBiQZc3to9YQp6HDLvrmyKC+6+iZ3gq7qrkqf50ljZC+Lgoqrg",
			 * "refresh_token":
			 * "c8ceMEJisO4Se7uGisHoX0f5JEii7JnipglQipkOn5Zp3tyP7dHQoP0zNKHUq2gY",
			 * "token_type":"bearer", "expires_in":"3600" }
			 */ 
			JSONObject json = new JSONObject(tokens);
			String access = json.getString("access_token");
			String type = json.getString("token_type");
			
			// 3.4.5 접근 토큰을 이용하여 프로필 API 호출하기
			// https://openapi.naver.com/v1/nid/me ▶ 프로필 정보 조회 URL
			url = new StringBuffer("https://openapi.naver.com/v1/nid/me");
			/* 사용자 프로필 조회 요청에 성공하면 다음과 같이 JSON 형식으로 된 결괏값을 반환받습니다. */
			/*
			 * { "resultcode": "00", 
			 *   "message": "success",
			 *   "response": { "email":"openapi@naver.com", "nickname": "OpenAPI", "profile_image":
			 * "https://ssl.pstatic.net/static/pwe/address/nodata_33x33.gif", "age":
			 * "40-49", "gender": "F", "id": "32742776", "name": "오픈 API", "birthday":
			 * "10-01" } }
			 */
			String profile = CommonUtility.requestAPI(url.toString(), type + " " + access);
			json = new JSONObject(profile);
			if(json.getString("resultcode").equals("00")) {
				json = json.getJSONObject("response");
				/*
				 * "response": { "email": "openapi@naver.com", "nickname": "OpenAPI",
				 * "profile_image":
				 * "https://ssl.pstatic.net/static/pwe/address/nodata_33x33.gif", "age":
				 * "40-49", "gender": "F", "id": "32742776", "name": "오픈 API", "birthday":
				 * "10-01" }
				 */
				/* json.getString("id"); */
				MemberDTO dto =new MemberDTO();
				dto.setSocial("N");
				dto.setUserid(json.getString("id"));
				dto.setEmail(json.getString("email"));
				dto.setName(json.getString("name"));
				
				if(dto.getName().isEmpty()) {
					dto.setName(json.getString("nickname"));
				}
				dto.setProfile( json.has("profile_image")? json.getString("profile_image") : "");
				// F:여, M:남
				dto.setGender(json.getString("gender").equals("F") ? "여" : "남");
				// "birthday" : "10-01"
				// "birthyear" : "2022"
				if(json.has("birthyear")) {
					dto.setBirth(json.getString("birthyear")+"-"+json.getString("birthday"));					
				}
				// "mobile" : "?"
				/* dto.setPhone(json.getString("mobile")); */
				dto.setPhone( json.has("mobile")? json.getString("mobile") : "");
				
				// DB에 해당 id가 존재하는지 파악
				MemberDAO dao = new MemberDAO();
				if(dao.idExist(dto.getUserid()) == 0) {
					// 네이버로 로그인한 적이 있는 경우 : update
					dao.member_insert(dto);
				}else {
					// 네이버로 로그인이 처음인 경우 : insert
					dao.member_update(dto);
				}
				request.getSession().setAttribute("loginInfo", dto);
			}
			
		}
	}

}
