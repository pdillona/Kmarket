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
                <a href="../index.html" class="logo"><img src="../img/admin_logo.png" alt="admin_logo"/></a>
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
            <section id="admin-config-userAdmin">
                <nav>
                    <h3>관리자</h3>
                    <p>
                        HOME > 환경설정 > <strong>관리자</strong>
                    </p>
                </nav>
                <!-- 상품목록 컨텐츠 시작 -->                                
                <section>
                    <div>
                        <select name="search">
                            <option value="search1">관리자아이디</option>
                            <option value="search1">관리자이름</option>
                        </select>
                        <input type="text" name="search">
                    </div>
                    <table>
                        <tr>
                            <th><input type="checkbox" name="all"/></th>
                            <th>아이디</th>
                            <th>이름</th>
                            <th>이메일</th>
                            <th>휴대폰</th>
                            <th>관리</th>
                        </tr>

                        <tr>
                            <td><input type="checkbox" name="아이디"/></td>
                            <td>hong123</td>
                            <td>홍길동</td>
                            <td>hong@naver.com</td>
                            <td>010-2434-3243</td>
                            <td>
                                <a href="#">[삭제]</a>
                                <a href="#">[수정]</a>
                            </td>
                        </tr>
                        <tr>
                            <td><input type="checkbox" name="아이디"/></td>
                            <td>hong123</td>
                            <td>홍길동</td>
                            <td>hong@naver.com</td>
                            <td>010-2434-3243</td>
                            <td>
                                <a href="#">[삭제]</a>
                                <a href="#">[수정]</a>
                            </td>
                        </tr>
                        <tr>
                            <td><input type="checkbox" name="아이디"/></td>
                            <td>hong123</td>
                            <td>홍길동</td>
                            <td>hong@naver.com</td>
                            <td>010-2434-3243</td>
                            <td>
                                <a href="#">[삭제]</a>
                                <a href="#">[수정]</a>
                            </td>
                        </tr>
                    </table>

                    
                    <input class="btnDelete" type="button" value="선택삭제" />                          
                    <input class="btnRegister" type="button" value="관리자 등록" />                          


                    <div class="paging">
                        <span class="prev">
                            <a href="#"><&nbsp;이전</a>
                        </span>
                        <span class="num">
                            <a href="#" class="on">1</a>
                            <a href="#">2</a>
                            <a href="#">3</a>
                            <a href="#">4</a>
                            <a href="#">5</a>
                            <a href="#">6</a>
                            <a href="#">7</a>
                        </span>
                        <span class="next">
                            <a href="#">다음&nbsp;></a>
                        </span>
                        </div>

                </section>                

                
                <p class="ico info">
                    <strong>Tip!</strong>
                    입퇴사 시 수정, 삭제 반영 당일에 해주세요.
                </p>

                

                <!-- 상품목록 컨텐츠 끝 -->
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