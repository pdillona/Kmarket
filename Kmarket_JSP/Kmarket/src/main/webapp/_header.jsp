<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="ctxPath" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>index</title>
    <!-- 
		날짜 : 2023/09/14
		이름 : 김무현
		내용 : include 작업
	 -->
    <link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/themes/smoothness/jquery-ui.css"/>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.css"/>
    <link rel="stylesheet" href="${ctxPath}/css/common.css">
    <script src="https://kit.fontawesome.com/20962f3e4b.js" crossorigin="anonymous"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js"></script>
	<script src="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.min.js"></script>
    <script src="${ctxPath}/js/index.js"></script>
    <script>
      $(function(){
        $('#bannerTop .btnClose').click(function(){
          $(this).closest('#bannerTop').removeClass('on');
        });
      });
	
     
    </script>
</head>
<body>
    <div id="bannerTop" class="on" style="background: #e4dfdf;">
      <article>
        <a href="#"><img src="./img/topBanner1.png"/></a>
        <button class="btnClose">close</button>
      </article>
    </div>
    <div id="wrapper">      
      <header>
        <div class="top">
          <div>
            <a href="${ctxPath}/member/login.do">로그인</a>
            <a href="${ctxPath}/member/join.do">회원가입</a>
            <a href="#">마이페이지</a>
            <c:if test="${not empty sessUser}">
<<<<<<< HEAD
            	<a href="${ctxPath}/user/logout.do">로그아웃</a>
            	<c:if test="${sessUser.type ne '1'}">
            	<a href="${ctxPath}/admin/index.do">관리자</a>
            	</c:if>
            </c:if>
=======
            	<a href="${ctxPath}/member/logout.do">로그아웃</a>
            	<c:if test="${sessUer.type eq 2}">
            	<a href="${ctxPath}/seller/index.do">판매자</a>
            	</c:if>
            </c:if> 
>>>>>>> 702d01685a1688bc124e6846bbd002dd2b22d6df
            <a href="#"
              ><i class="fa fa-shopping-cart" aria-hidden="true"></i
              >&nbsp;장바구니</a
            >
          </div>
        </div>
        <div class="logo">
          <div>
            <a href="${ctxPath}/index.do"><img src="./img/header_logo.png" alt="로고" /></a>
            <form action="#">
              <input type="text" name="search" />
              <button><i class="fa fa-search"></i></button>
            </form>
          </div>
        </div>
        <div class="menu">
          <div>
            <ul>
              <li><a href="#">히트상품</a></li>
              <li><a href="#">추천상품</a></li>
              <li><a href="#">최신상품</a></li>
              <li><a href="#">인기상품</a></li>
              <li><a href="#">할인상품</a></li>
            </ul>
            <ul>
              <li><a href="${ctxPath}/cs/notice.do?group=notice&aeName=all">공지사항</a></li>
              <li><a href="${ctxPath}/cs/faq.do?group=faq&aeName=all">자주묻는질문</a></li>
              <li><a href="${ctxPath}/cs/qna.do?group=qna&aeName=all">문의하기</a></li>
              <li><a href="${ctxPath}/cs/index.do">고객센터</a></li>
            </ul>
          </div>
        </div>
      </header>
