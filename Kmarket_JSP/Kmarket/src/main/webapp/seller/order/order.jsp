<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../_header.jsp" %>
<%@ include file="../_aside.jsp"%>
            <section id="seller-order-order">
                <nav>
                    <h3>주문현황</h3>
                    <p>
                        HOME > 주문관리 > <strong>주문현황</strong>
                    </p>
                </nav>
                <!-- 주문현황 컨텐츠 시작 -->         
                <!-- ordNo, prodName, ordUid, ordDate, deliveryStatus, ordComplete(수정가능) -->                      
                <section>
                    <div>
                        <form id="formSearch" action="/Kmarket/seller/order/order.do" method="get">
			           		<input type="hidden" name="seller" value="${sessUser.company}"/>
				           <select name="search">
				                  <option value="search1">상품명</option>
				                  <option value="search2">주문번호</option>                               
				           </select>
				           <input type="text" name="search_text">
				           <button id="btnSearch">검색</button>
			           </form>
                    </div>
                    <p class="sort">
                        <a href="#" class="on">전체&nbsp;|</a>
                        <a href="#" class="off">입금대기&nbsp;|</a>
                        <a href="#" class="off">판매량 많은 순&nbsp;|</a>
                        <a href="#" class="off">판매금액 많은 순&nbsp;</a>
                    </p>
                    <table>
                        <tr>
                            <th>주문번호</th>
                            <th>상품사진</th>
                            <th>상품명</th>
                            <th>주문일자</th>
                            <th>입금상태</th>
                            <th>배송상태</th>
                        </tr>

                        <tr>
                            <td>1</td>
                            <td><img src="/Kmarket/seller/img/sample_thumb.jpg" alt="상품사진"></td>
                            <td>티셔츠</td>
                            <td>23-05-25</td>
                            <td>
                                <label><input type="checkbox">입금완료확인</label>
                            </td>
                            <td>
                                <select name="deliveryStatus">
                                    <option value="not">배송전</option>
                                    <option value="ing">배송중</option>
                                    <option value="success">배송완료</option>
                                </select>
                                <span>배송전</span>
                                <a href="#"><수정></a>
                            </td>
                        </tr>
                        <tr>
                            <td>1</td>
                            <td><img src="/seller/img/sample_thumb.jpg" alt="상품사진"></td>
                            <td>티셔츠</td>
                            <td>23-05-25</td>
                            <td>
                                <label><input type="checkbox">입금완료확인</label>
                            </td>
                            <td>
                                <select name="deliveryStatus">
                                    <option value="not">배송전</option>
                                    <option value="ing">배송중</option>
                                    <option value="success">배송완료</option>
                                </select>
                                <span>배송전</span>
                                <a href="#"><수정></a>
                            </td>
                        </tr>
                        <tr>
                            <td>1</td>
                            <td><img src="/seller/img/sample_thumb.jpg" alt="상품사진"></td>
                            <td>티셔츠</td>
                            <td>23-05-25</td>
                            <td>
                                <label><input type="checkbox">입금완료확인</label>
                            </td>
                            <td>
                                <select name="deliveryStatus">
                                    <option value="not">배송전</option>
                                    <option value="ing">배송중</option>
                                    <option value="success">배송완료</option>
                                </select>
                                <span>배송전</span>
                                <a href="#"><수정></a>
                            </td>
                        </tr>
                        
                    </table>

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
                    주문현황입니다. 고객의 입금을 확인하면 입금 확인 완료를 체크해주십시오. 
                </p>

                

                <!-- 주문현황 컨텐츠 끝 -->
            </section>
        </main>
<%@ include file="../_footer.jsp" %>
