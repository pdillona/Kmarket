<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../_header.jsp" %>
<%@ include file="../_aside.jsp"%>
<script>
$(function(){
	$('#btnSearch').click(function(){
		$('#formSearch').submit();
	});
	$('#ordComplete').click(function(e){
		e.preventDefault();
		if(confirm('입금완료 확인하셨습니까?(주문)')){
			$(this).submit();
		}
		});
	}
</script>
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
              <option value="search2">상품코드</option>
              <option value="search3">주문번호</option>                               
       </select>
       <input type="text" name="search_text">
       <button id="btnSearch">검색</button>
      </form>
            </div>
            <p class="sort">
                <a href="#" class="on">전체&nbsp;|</a>
                <a href="#" class="off">입금대기&nbsp;|</a>
                <a href="#" class="off">주문량 많은 순&nbsp;|</a>
            </p>
            <table>
                <tr>
                    <th>주문번호</th>
                    <th>상품사진</th>
                    <th>상품명</th>
                    <th>주문일자</th>
                    <th>입금상태</th>
                    <th>주문상태</th>
                    <th>배송상태</th>
                </tr>
				<c:forEach var="order" items="${orders}">
					<tr>
	                    <td>${order.ordNo}</td>
	                    <td><img src="/Kmarket/seller/img/${order.productDTO.newThumb1}" alt="${order.productDTO.prodName}"></td>
	                    <td>${order.productDTO.prodName}</td>
	                    <td>${order.ordDate}</td>
	                    <td>
							<c:choose>
								<c:when test="${order.ordComplete eq 1}">
									<span>입금완료</span>	
								</c:when>
								<c:otherwise>
									<a id="ordComplete" href="/Kmarket/seller/order/ordComplete.do?ord">입금대기</a>	
								</c:otherwise>
							</c:choose>
	                    </td>
	                    <td>
                            <c:choose>
                            	<c:when test="${order.ordStatus eq 'success'}">
                            		<span>구매확정</span>	
                            	</c:when>
                            	<c:when test="${order.ordStatus eq 'cancel'}">
                            		<span>취소</span>	
                            	</c:when>
                            	<c:when test="${order.ordStatus eq 'return'}">
                            		<span>교환</span>	
                            	</c:when>
                            	<c:when test="${order.ordStatus eq 'excheange'}">
                            		<span>반품</span>	
                            	</c:when>
                            	<c:otherwise>
                            		<span>교환</span>
                            	</c:otherwise>
                            </c:choose>
                        </td>
                        <td>
                        	<select name="ordStatus">
                               <option value="success">구매확정</option>
                               <option value="cancel">취소</option>
                               <option value="return">반품</option>
                               <option value="exchange">교환</option>
                             </select>
                        </td>
	                </tr>
				</c:forEach>
            </table>

            <div class="paging">
           	<c:if test="${pageGroupStart > 1}">
           		<span class="prev">
           			<a href="/Kmarket/seller/order/order.do?pg=${pageGroupStart - 1}&search=${search}&search_text=${search_text}&seller=${sessUser.company}">
           			<&nbsp;이전
           			</a>
            	</span>
           	</c:if>
               <span class="num">
            <c:forEach var="i" begin="${pageGroupStart}" end="${pageGroupEnd}">
            	<a href="/Kmarket/seller/order/order.do?pg=${i}&search=${search}&search_text=${search_text}&seller=${sessUser.company}" class="${currentPage == i? 'on':'off'}">${i}</a>
            </c:forEach>
               </span>
            <c:if test="${pageGroupEnd < lastPageNum}">
	            <span class="next">
	                   <a href="/Kmarket/seller/order/order.do?pg=${pageGroupEnd + 1}&search=${search}&search_text=${search_text}&seller=${sessUser.company}">
	                   다음&nbsp;>
	                   </a>
	            </span>
            </c:if>
               
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
