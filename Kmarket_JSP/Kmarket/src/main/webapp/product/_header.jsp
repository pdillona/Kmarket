<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctxPath" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Product</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"/>
    <script src="https://kit.fontawesome.com/20962f3e4b.js" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="${ctxPath}/product/css/product.css">
    <link rel="stylesheet" href="${ctxPath}/css/common.css">
</head>
<body>
    <div id="wrapper">
        <header>
            <div class="top">
                <div>
                    <a href="#">로그인</a>
                    <a href="#">회원가입</a>
                    <a href="#">마이페이지</a>
                    <a href="#"><i class="fa fa-shopping-cart" aria-hidden="true"></i>&nbsp;장바구니</a>
                </div>
            </div>
            <div class="logo">
                <div>
                    <a href="#"><img src="../img/header_logo.png" alt="로고"/></a>
                    <form action="#">
                        <input type="text" name="keyword"/>
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
                        <li><a href="#">쿠폰존</a></li>
                        <li><a href="#">사용후기</a></li>
                        <li><a href="#">개인결제</a></li>
                        <li><a href="${ctxPath}/cs/index.do">고객센터</a></li>
                        <li><a href="${ctxPath}/cs/faq.do">FAQ</a></li>
                    </ul>
                </div>
            </div>
        </header>