<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../_header.jsp" %>
<%@ include file="../_aside.jsp" %>
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
                        <form id="formSearch" action="/Kmarket/seller/product/list.do" method="get">
			           		<input type="hidden" name="seller" value="${sessUser.company}"/>
				           	<select name="search">
				                  <option value="search1">상품명</option>
				                  <option value="search2">상품코드</option>                               
				                  <option value="search3">담당자명</option>                               
				           </select>
				           <input type="text" name="search_text">
				           <button id="btnSearch">검색</button>
           				</form>
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
<%@ include file="../_footer.jsp" %>
