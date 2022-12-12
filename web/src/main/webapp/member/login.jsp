<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <title>스마트웹&amp;앱</title>
      	<link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
		<link href="css/styles.css" rel="stylesheet" />
		<link href="css/common.css?<%=new java.util.Date() %>" rel="stylesheet" />

		<script src="https://code.jquery.com/jquery-3.6.1.min.js"></script>
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
		<script src="js/scripts.js"></script>
		<style>
			/* https://developers.naver.com/docs/login/devguide/devguide.md */
			/*3.4 네이버 로그인 연동 개발하기*/
			.naver{
				background: url("images/naverlogin.png") center;
				background-size: cover;
			}
			.kakao{
				background: url("images/kakaologin.png") center;
				background-size: cover;
			}
		</style>
    </head>
    <body>
        <div class="d-flex" id="wrapper">
            <!-- Sidebar-->
            
            <!-- Page content wrapper-->
            <div id="page-content-wrapper">
                <!-- Top navigation-->
                
                <!-- Page content-->
                <div class="container-fluid center">
                    <!-- <h2 class="mt-4">로그인</h2> -->
                    <a href='<c:url value="/index"/>'><img src='<c:url value="/images/hanul.logo.png"/>'></a>
                    <div class='box'>
						<ul>
							<li><input type='text' id='userid' class='chk' placeholder='아이디'></li>
							<li><input type='password' id='userpw' class='chk' placeholder='비밀번호'></li>
							<li><input onclick="fn_login()" class='btn btn-primary' type='button' value='로그인'></li>
							<li><hr></li>
							<li><input type='button' class='btn btn-secondary naver'></li>
							<li><input type='button' class='btn btn-secondary kakao'></li>
						</ul>
					</div>

                </div>
            </div>
        </div>
        <!-- https://mvnrepository.com/artifact/com.fasterxml.jackson.core/jackson-databind/2.13.4.2 -->
		<script>
			/* 제이슨 문법 사용, 아이디 비밀번호 일치 여부 확인*/
			function fn_login(){
				// 아이디, 비밀번호가 모두 입력되었는지 확인
				if(!emptyCheck()){
					return;
				}
				$.ajax({
					url: 'smartLogin.mb',
					data: {id: $('#userid').val(), pw: $('#userpw').val()},
					success: function(response){
						console.log(response);
						/* if(response=='true'){ */
						/* if(response){ */
						if(JSON.parse(response)){
							location ='<c:url value="/"/>';
						}else{
							alert("아이디나 비밀번호가 일치하지 않습니다.");
						}
					},error: function(req, text){
						alert(text + ':' + req.status);
					}
				});
			}
			/* 아이디 입력 후 엔터 치면 비밀번호 칸으로 포커스 이동*/
			$('#userid').keypress(function(e){
				if(e.keyCode==13){
					$('#userpw').focus();
				}
			});
			/* 엔터키만 누르면 로그인 되게*/
			/* $('#userpw').keyup(function(e){ */
			$('#userpw').keypress(function(e){
				if(e.keyCode==13){
					fn_login();
				}
			});
			function emptyCheck(){
				var ok = true;
				$('.chk').each(function(){
					if($(this).val()==''){
						var tag = $(this).attr('placeholder');
						alert(tag + ' 입력하세요..!');
						$(this).focus();
						ok = false;
						return ok;
					}
				});
				return ok;
			}
			/*네이버 로그인 버튼 클릭 시*/
			$('.naver').click(function(){
				location='naverlogin.mb';
			});
			/*카카오 로그인 버튼 클릭 시*/
			$('.kakao').click(function(){
				location='kakaologin.mb';
			});
		</script>
    </body>
</html>
