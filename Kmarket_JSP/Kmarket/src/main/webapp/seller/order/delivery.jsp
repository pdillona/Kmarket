<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../_header.jsp" %>
<%@ include file="../_aside.jsp"%>
            <section id="seller-order-delivery">
                <nav>
                    <h3>취소/반품/교환</h3>
                    <p>
                        HOME > 주문관리 > <strong>취소/반품/교환</strong>
                    </p>
                </nav>
                <!-- 취소/반품/교환 컨텐츠 시작 --> 
                <!-- ordNo, prodNo, ordUid, ordDate, ordStatus, ordComplete(수정불가) -->                               
                <!-- -->                               
                <section>
                    <div>
                        <form id="formSearch" action="/Kmarket/seller/product/list.do" method="get">
			           		<input type="hidden" name="seller" value="${sessUser.company}"/>
				           <select name="search">
				                  <option value="search1">상품명</option>
				                  <option value="search2">상품코드</option>                               
				           </select>
				           <input type="text" name="search_text">
				           <button id="btnSearch">검색</button>
           				</form>
                    </div>
                    <p class="sort">
                        <a href="#" class="on">전체&nbsp;|</a>
                        <a href="#" class="off">취소&nbsp;|</a>
                        <a href="#" class="off">반품&nbsp;|</a>
                        <a href="#" class="off">교환&nbsp;</a>
                    </p>
                    <table>
                        <tr>
                            <th>주문번호</th>
                            <th>상품번호</th>
                            <th>주문자</th>
                            <th>주문일자</th>
                            <th>주문상태</th>
                            <th>배송상태</th>
                            <th>입금상태</th>
                        </tr>
                        <tr>
                            <td>3238432</td>
                            <td>123458583</td>
                            <td>hong1234</td>
                            <td>23-05-25</td>
                            <td>
                                <c:choose>
		                        	<c:when test="${order.deliveryStatus ==  null || order.deliveryStatus eq 'yet'}">
		                        		<span>배송전</span>
		                        	</c:when>
		                        	<c:when test="${order.deliveryStatus eq 'ing'}">
		                        		<span>배송중</span>
		                        	</c:when>
		                        	<c:when test="${order.deliveryStatus eq 'success'}">
		                        		<span>배송완료</span>
		                        	</c:when>
		                        </c:choose>
                            </td>
                            <td>
                            	<select name="deliveryStatus">
		                            <option value="yet">배송전</option>
		                            <option value="ing">배송중</option>
		                            <option value="success">배송완료</option>
		                        </select>
                            </td>
                            <td>입금완료</td>
                        </tr>
                        <tr>
                            <td>3238432</td>
                            <td>123458583</td>
                            <td>hong1234</td>
                            <td>23-05-25</td>
                            <td>
                                <c:choose>
		                        	<c:when test="${order.deliveryStatus ==  null || order.deliveryStatus eq 'yet'}">
		                        		<span>배송전</span>
		                        	</c:when>
		                        	<c:when test="${order.deliveryStatus eq 'ing'}">
		                        		<span>배송중</span>
		                        	</c:when>
		                        	<c:when test="${order.deliveryStatus eq 'success'}">
		                        		<span>배송완료</span>
		                        	</c:when>
		                        </c:choose>
                            </td>
                            <td>
                            	<select name="deliveryStatus">
		                            <option value="yet">배송전</option>
		                            <option value="ing">배송중</option>
		                            <option value="success">배송완료</option>
		                        </select>
                            </td>
                            <td>입금완료</td>
                        </tr>
                        <tr>
                            <td>3238432</td>
                            <td>123458583</td>
                            <td>hong1234</td>
                            <td>23-05-25</td>
                            <td>
                                <c:choose>
		                        	<c:when test="${order.deliveryStatus ==  null || order.deliveryStatus eq 'yet'}">
		                        		<span>배송전</span>
		                        	</c:when>
		                        	<c:when test="${order.deliveryStatus eq 'ing'}">
		                        		<span>배송중</span>
		                        	</c:when>
		                        	<c:when test="${order.deliveryStatus eq 'success'}">
		                        		<span>배송완료</span>
		                        	</c:when>
		                        </c:choose>
                            </td>
                            <td>
                            	<select name="deliveryStatus">
		                            <option value="yet">배송전</option>
		                            <option value="ing">배송중</option>
		                            <option value="success">배송완료</option>
		                        </select>
                            </td>
                            <td>입금완료</td>
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
                    배송관리 페이지 입니다. 수정 버튼 클릭 시 주문 상태 수정이 가능합니다.
                </p>

                

                <!-- 배송관리 컨텐츠 끝 -->
            </section>
        </main>
<%@ include file="../_footer.jsp" %>
