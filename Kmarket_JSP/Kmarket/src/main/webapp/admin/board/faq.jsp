<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../_header.jsp" %>
<%@ include file="../_aside.jsp" %>
            <section id="admin-board-notice">
                <nav>
                    <h3>자주묻는 질문</h3>
                    <p>
                        HOME > 게시판관리 > <strong>자주묻는 질문</strong>
                    </p>
                </nav>
                <!-- 공지사항 컨텐츠 시작 -->                                
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
                    <p class="sort">
                        <a href="#" class="on">전체&nbsp;|</a>
                        <a href="#" class="off">판매자&nbsp;|</a>
                        <a href="#" class="off">구매자&nbsp;|</a>
                    </p>
                    <table>
                        <tr>
                            <th><input type="checkbox" name="all"/></th>
                            <th>글번호</th>
                            <th>글제목</th>
                            <th>작성자</th>
                            <th>작성일자</th>
                            <th>관리</th>
                        </tr>

                        <tr>
                            <td><input type="checkbox" name="chk"></td>
                            <td>1</td>
                            <td>공지사항입니다.</td>
                            <td>홍길동</td>
                            <td>23-05-25</td>
                            <td>
                                <a href="#">[삭제]</a>
                                <a href="#">[수정]</a>
                            </td>
                        </tr>
                        <tr>
                            <td><input type="checkbox" name="chk"></td>
                            <td>1</td>
                            <td>공지사항입니다.</td>
                            <td>홍길동</td>
                            <td>23-05-25</td>
                            <td>
                                <a href="#">[삭제]</a>
                                <a href="#">[수정]</a>
                            </td>
                        </tr>
                        <tr>
                            <td><input type="checkbox" name="chk"></td>
                            <td>1</td>
                            <td>공지사항입니다.</td>
                            <td>홍길동</td>
                            <td>23-05-25</td>
                            <td>
                                <a href="#">[삭제]</a>
                                <a href="#">[수정]</a>
                            </td>
                        </tr>
                    </table>
                    <input class="btnDelete" type="button" value="선택삭제" />
                    <input class="btnWrite" type="button" value="글등록" />
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
                    공지사항 등록 시 판매자와 구매자 구분 작성이 필요합니다.
                </p>

                

                <!-- 공지사항 컨텐츠 끝 -->
            </section>
        </main>
<%@ include file="../_footer.jsp" %>
