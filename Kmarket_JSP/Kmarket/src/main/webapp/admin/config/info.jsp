<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>케이마켓::관리자</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js"></script>
    <script src="https://kit.fontawesome.com/20962f3e4b.js" crossorigin="anonymous"></script>    
    <script src="../js/gnb.js"></script>
    <link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/themes/smoothness/jquery-ui.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"/>
    <link rel="stylesheet" href="../css/admin.css">
</head>
<body>
    <div id="admin-wrapper">
        <header>
            <div>
                <a href="./index.html" class="logo"><img src="../img/admin_logo.png" alt="admin_logo"/></a>
                <p>
                    <span>홍길동님 반갑습니다.</span>
                    <a href="#">HOME |</a>
                    <a href="#">로그아웃 |</a>
                    <a href="#">고객센터</a>
                </p>
            </div>
        </header>
        <main>
            <aside>
                <!-- Global Navigation Bar -->
                <ul id="gnb">
                    <li>
                        <a href="#"><i class="fa fa-cogs" aria-hidden="true"></i>환경설정</a>
                        <ol>
                            <li><a href="/admin/config/info.html">기본환경정보</a></li>
                            <li><a href="/admin/config/userAdmin.html">관리자</a></li>
                            <li><a href="/admin/config/banner.html">디자인관리</a></li>
                        </ol>
                    </li>
                    <li>
                        <a href="#"><i class="fas fa-store" aria-hidden="true"></i>상점관리</a>
                        <ol>
                            <li><a href="/admin/store/userSeller.html">판매자관리</a></li>
                            <li><a href="/admin/store/list.html">상품관리</a></li>
                        </ol>
                    </li>
                    <li>
                        <a href="#"><i class="fa fa-users" aria-hidden="true"></i>회원관리</a>
                        <ol>
                            <li><a href="/admin/user/user.html">회원정보관리</a></li>
                            <li><a href="/admin/user/point.html">포인트관리</a></li>
                            <li><a href="/admin/user/accessorTotal.html">접속자집계</a></li>
                        </ol>
                    </li>
                    <li>
                        <a href="#"><i class="fa fa-pencil-square-o" aria-hidden="true"></i>게시판관리</a>
                        <ol>
                            <li><a href="/admin/board/notice.html">공지사항</a></li>
                        </ol>
                    </li>
                </ul>
            </aside>
            <section id="admin-config-info">
                <nav>
                    <h3>기본환경정보</h3>
                    <p>
                        HOME > 환경설정 > <strong>기본환경정보</strong>
                    </p>
                </nav>
                <!-- 상품등록 컨텐츠 시작 -->
                <article>
                    <form action="#">

                        <section>
                            <h4>기본정보</h4>
                            <p>
                                기본분류는 반드시 선택하셔야 합니다. 하나의 상품에 1개의 분류를 지정 합니다.
                            </p>
                            <table>
                                <tr>
                                    <td>쇼핑몰 이름</td>
                                    <td>
                                        케이마켓 (영문:Kmarket)
                                    </td>
                                </tr>
                                <tr>
                                    <td>부제</td>
                                    <td>
                                        대한민국 1등 온라인 쇼핑몰
                                    </td>
                                </tr>
                                <tr>
                                    <td>버전</td>
                                    <td>
                                        v1.0.1
                                    </td>
                                </tr>
                            </table>
                        </section>
                        
                        <section>
                            <h4>이용약관</h4>
                            <p>
                                기본정보는 반드시 입력해야 합니다.
                            </p>
                            <table>
                                <tr>
                                    <td>1조</td>
                                    <td><textarea name="art1"></textarea></td>
                                </tr>
                                <tr>
                                    <td>1조</td>
                                    <td><textarea name="art1"></textarea></td>
                                </tr>
                                <tr>
                                    <td>1조</td>
                                    <td><textarea name="art1"></textarea></td>
                                </tr>
                                <tr>
                                    <td>1조</td>
                                    <td><textarea name="art1"></textarea></td>
                                </tr>
                            </table>                                
                        </section>                                                
                    </form>
                </article>

                <p class="ico alert">
                    <strong>Warning!</strong>
                    전자상거래 등에서의 상품 등의 정보제공에 관한 고시에 따라 총 35개 상품군에 대해 상품 특성 등을 양식에 따라 입력할 수 있습니다.
                </p>
                <!-- 상품등록 컨텐츠 끝 -->
            </section>
        </main>
        <footer>
            <div>
                <p>Copyright ©kmarket.co.kr All rights reserved. KMARKET ADMINISTRATOR Version 5.4.1.2</p>
            </div>
        </footer>
    </div>    
</body>
</html>