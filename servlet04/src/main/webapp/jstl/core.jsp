<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div><a href='<c:url value="/"/>'>홈으로</a></div>
<div><a href='<c:url value="/jstl/index.jsp"/>'>JSTL</a></div>
<hr>
<h3>코어 라이브러리 실습</h3>
<h4>1.변수</h4>
<c:set var='name' value="홍길동" />
<div>선언한 변수값 이름: ${name}</div>
<c:remove var='name'/>
<div>변수삭제후 값 이름: ${name}</div>
<hr>

<h4>2.조건문 - if문</h4>
<c:set var='no1' value='15000'/>
<c:set var='no2' value='30000'/>
<div>
${no1} 과 ${no2} 중 더 큰 수 : 
<c:if test='${no1 gt no2-0}'>${no1}
</c:if>
<c:if test="${no1-no2 lt 0}">${no2}
</c:if>
</div>
<hr>

<h4>3.조건문 - choose문</h4>
<c:set var='score' value='78'/>
<c:choose>
	<c:when test='${score >= 90}'><c:set var='grade' value="A"/> </c:when>
	<c:when test='${score ge 80}'><c:set var='grade' value="B"/> </c:when>
	<c:when test='${score ge 70}'><c:set var='grade' value="C"/> </c:when>
	<c:when test='${score ge 60}'><c:set var='grade' value="D"/> </c:when>
	<c:otherwise><c:set var='grade' value="F"/></c:otherwise>
</c:choose>
<div>성적 ${score} : ${grade}학점</div>
<%
int score = 88;
String grade="";


if( score>= 90)  grade ="A"; 
if( score>= 80)  grade ="B"; 
if( score>= 70)  grade ="C"; 
if( score>= 60)  grade ="D";
if( score<60)	 grade = "F";



if( score>= 90)  grade ="A"; 
else if( score>= 80)  grade ="B"; 
else if( score>= 70)  grade ="C"; 
else if( score>= 60)  grade ="D";
else				  grade = "F";
out.print( "성적 "+score+ " : " + grade +"학점" );
%>
<hr>
<h4>4.반복문 -기본for문</h4>
<div>1~10까지 출력:
	<c:forEach var='no' begin='1' end="10" step="1">
	${no}
	<c:set var='sum' value='${no+sum}'/>
	</c:forEach>
</div>
<div>1~10까지의 합: ${sum}</div>
<hr>
<h4>5.반복문 -향상된for문</h4>
<%
String subjects[] = { "java", "oracle", "html", "css", "jquery" };
request.setAttribute("subjects", subjects);
%>
<div>과목명: 
	<c:forEach items="${subjects}" var='subject'>
		${subject}
	</c:forEach>
</div>
<%
ArrayList<Integer> list = new ArrayList<Integer>();
list.add( 85 );
list.add( 92 );
list.add( 78 );
list.add( 63 );
list.add( 96 );
request.setAttribute("score_list", list);
%>
<div>성적: 
	<c:forEach items='${score_list}' var='score' varStatus='state'>
	${state.index eq 0 ? '' : ', ' }${score} 
	</c:forEach>
</div>

<%
HashMap<String, Integer> map = new HashMap<String, Integer>();
map.put("java", 85);
map.put("oracle", 92);
map.put("html", 81);
map.put("css", 76);
map.put("jquery", 93);
request.setAttribute("score_map", map);
%>
<div>과목별 성적:
	<c:forEach items='${score_map}' var='score' varStatus='state'>
	${state.first ? '' : ',' }${score.key}: ${score.value}
	${state.last ? '끝' : '' }
	</c:forEach>
</div>

<%
// for(int idx=0; idx<list.size(); idx++){
// 	list.get(idx);
// }

// for(int no : list){
// 	list.get(0)
// }

	int[] no = {10,20,30,40,50};
	request.setAttribute("no", no);
%>
<hr>
<div>JSTL forEach를 사용해 no에 있는 값을 출력</div>
<div>
	<c:forEach items="${no}" var="n" varStatus="state">
		${state.index eq 0 ? '시작>' : '' }${n}
	</c:forEach>
</div>
<hr>
<div>JSTL forEach를 사용해 구구단 3단 출력</div>
<c:forEach var="count" begin="1" end="9">
	<c:out value="3 * ${count} = ${3*count}"/>
	<br>
</c:forEach>
<c:out value="forEach를 사용해 3단을 출력..?"/>
<c:forEach var="count" begin="1" end="9">
	<p>3 * ${count} = ${3*count}</p>
</c:forEach>
<hr>
<c:out value="중첩 반복문/ 2단부터 9단까지"/><br>
<c:forEach var="i" begin="2" end="9">
	<c:forEach var="j" begin="1" end="9">
		<c:out value="${i} * ${j} = ${i*j}"/>
	</c:forEach>
		<br>	
</c:forEach>
<hr>
<h4>6.토큰분리</h4>
<%
	String data = "java,oracle?html,css/jquery";
	request.setAttribute("subject", data);
%>
<div>토큰 : ,</div>
<c:forTokens items="${subject}" delims="," var='s'>
	<div>${s}</div>
</c:forTokens>
<hr>
<div>토큰 : ,  ?</div>
<c:forTokens items="${subject}" delims=",?" var='s'>
	<div>${s}</div>
</c:forTokens>
<hr>
<div>토큰 : ,  ?  /</div>
<c:forTokens items="${subject}" delims=",?/" var='s'>
	<div>${s}</div>
</c:forTokens>
<hr>
<h4>7.페이지 이동, 링크 걸기</h4>
<div>
	상대경로
	<a href="<c:url value ='../param/form_result.jsp?name=심청&gender=남'/>">회원정보</a>
	절대경로
	<a href="<c:url value ='/param/form_result.jsp?name=심청&gender=남'/>">회원정보</a>
</div>















</body>
</html>