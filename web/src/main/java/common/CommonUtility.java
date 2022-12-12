package common;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.servlet.http.HttpServletRequest;

public class CommonUtility {
	static public String appUrl(HttpServletRequest request){
		// URL ▶ http://localhost/web/navercallback.mb
		String url = request.getRequestURL().toString();
		
		// servletPath ▶ /navercallback.mb
		String path = request.getServletPath();
		
		// 러턴할 값 ▶ http://localhost/web
		return url.replace(path, "");
	}
	
	static public String requestAPI(String apiURL) {
		//네이버 로그인 API 명세
		//네이버 로그인 접근토큰 획득 예제는 2개의 프로그램으로 구성되어 있습니다. (naverlogin.jsp, callback.jsp)
		//callback.jsp
		try {
		      URL url = new URL(apiURL);
		      HttpURLConnection con = (HttpURLConnection)url.openConnection();
		      con.setRequestMethod("GET");
		      int responseCode = con.getResponseCode();
		      BufferedReader br;
		      System.out.print("responseCode="+responseCode);
		      if(responseCode==200) { // 정상 호출 // 공식 문서에는 인코딩이 안적혀있다.
		    	/*br = new BufferedReader(new InputStreamReader(con.getInputStream()));*/
		        br = new BufferedReader(new InputStreamReader(con.getInputStream(),"UTF-8"));
		      } else {  // 에러 발생
				/* br = new BufferedReader(new InputStreamReader(con.getErrorStream())); */
		        br = new BufferedReader(new InputStreamReader(con.getErrorStream(), "UTF-8"));
		      }
		      String inputLine;
		      StringBuffer res = new StringBuffer();
		      while ((inputLine = br.readLine()) != null) {
		        res.append(inputLine);
		      }
		      br.close();
		      if(responseCode==200) {
				/* out.println(res.toString()); */
		    	System.out.print(res.toString());  
		      }
		      apiURL = res.toString();
		    } catch (Exception e) {
		      System.out.println(e);
		    }
		return apiURL;
	}
	
	/*추가*/
	static public String requestAPI(String apiURL, String property) {
		//네이버 로그인 API 명세
		//네이버 로그인 접근토큰 획득 예제는 2개의 프로그램으로 구성되어 있습니다. (naverlogin.jsp, callback.jsp)
		//callback.jsp
		try {
		      URL url = new URL(apiURL);
		      HttpURLConnection con = (HttpURLConnection)url.openConnection();
		      con.setRequestMethod("GET");
		      con.setRequestProperty("Authorization", property); /*추가*/
		      int responseCode = con.getResponseCode();
		      BufferedReader br;
		      System.out.print("responseCode="+responseCode);
		      if(responseCode==200) { // 정상 호출 // 공식 문서에는 인코딩이 안적혀있다.
		    	/*br = new BufferedReader(new InputStreamReader(con.getInputStream()));*/
		        br = new BufferedReader(new InputStreamReader(con.getInputStream(),"UTF-8"));
		      } else {  // 에러 발생
				/* br = new BufferedReader(new InputStreamReader(con.getErrorStream())); */
		        br = new BufferedReader(new InputStreamReader(con.getErrorStream(), "UTF-8"));
		      }
		      String inputLine;
		      StringBuffer res = new StringBuffer();
		      while ((inputLine = br.readLine()) != null) {
		        res.append(inputLine);
		      }
		      br.close();
		      if(responseCode==200) {
				/* out.println(res.toString()); */
		    	System.out.print(res.toString());  
		      }
		      apiURL = res.toString();
		    } catch (Exception e) {
		      System.out.println(e);
		    }
		return apiURL;
	}
}
