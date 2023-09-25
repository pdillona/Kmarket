<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%> 
<%@ include file="./_header.jsp" %>

<main id="product">
	<!-- 
		날짜 : 2023/09/14
		이름 : 김무현
		내용 : include 작업
	 -->
            
<jsp:include page="../_aside.jsp"/>    

    <!-- 장바구니 페이지 시작 -->
    <section class="cart">
      
      <!-- 제목, 페이지 네비게이션 -->
     <nav>
        <h1>장바구니</h1>
        <p>
          HOME > <span>패션·의류·뷰티</span> > <strong>장바구니</strong>
        </p>
      </nav>
                    
      <form action="#">
        <!-- 장바구니 목록 -->
        <table>
          <thead>
            <tr>
              <th><input type="checkbox" name="all"></th>
              <th>상품명</th>
              <th>총수량</th>
              <th>판매가</th>
              <th>할인</th>
              <th>포인트</th>
              <th>배송비</th>
              <th>소계</th>
            </tr>
          </thead>
          <tbody>
            <tr class="empty">
              <td colspan="7">장바구니에 상품이 없습니다.</td>
            </tr>
            <c:forEach var="carts" items="${carts}">
            <tr>
              <td><input type="checkbox" name=""></td>
              <td>
                <article>
                  <a href="#"><img src="/Kmarket/thumb/${carts.prodCate1}/${carts.prodCate2}/${carts.thumb1}" alt="상품이미지"></a>
                  <div>
                    <h2><a href="#">${carts.prodName}</a></h2>
                    <p>${carts.descript}</p>
                  </div>
                </article>
              </td>
              <td class="count">${carts.count}</td>
              <td>${carts.price}</td>
              <td>${carts.discount}%</td>
              <td>${carts.point}</td>
              <td> <c:choose>
                	<c:when test="${carts.delivery == 0}">
                	 <span class="delivery">무료배송</span>
                	</c:when>
                	<c:otherwise>
                	<span class="delivery">${carts.delivery}원</span>
                	</c:otherwise>
                </c:choose></td>
              <td class="finalPrice"><fmt:formatNumber value="${carts.finalPrice}" pattern="#,###"/>원</td>
            </tr>
            </c:forEach>
            <tr>
          </tbody>
        </table>
        <input type="button" name="del" value="선택삭제">

        <!-- 장바구니 전체합계 -->
        <div class="total">
          <h2>전체합계</h2>
          <table border="0">
        <c:set var="totalProductPrice" value="0" />
		<c:set var="totalProductCount" value="0" />
		<c:set var="totalDiscount" value="0" />
		<c:set var="totalDelivery" value="0" />
		<c:set var="totalPoints" value="0" />
		<c:set var="alreadyCalculatedDelivery" value="false" />
		
		
		
		<c:forEach var="cart" items="${carts}">
		    <c:set var="subtotal" value="${cart.price * cart.count}" />
		    <c:set var="totalProductPrice" value="${totalProductPrice + subtotal}" />
		    <c:set var="totalProductCount" value="${totalProductCount + cart.count}" />
		    <c:set var="discountAmount" value="${cart.price * cart.count * cart.discount / 100}" />
		    <c:set var="totalDiscount" value="${totalDiscount + discountAmount}" />
		    <c:set var="totalPoints" value="${totalPoints + cart.point}" />
		    <c:if test="${not alreadyCalculatedDelivery}">
		    	<c:set var="totalDelivery" value="${totalDelivery + cart.delivery}" />
        		<c:set var="alreadyCalculatedDelivery" value="true" />
    		</c:if>
    		<c:set var="totalOrderAmount" value="${totalProductPrice - totalDiscount + totalDelivery}" />
		    <!-- 나머지 상품 정보 출력 코드 -->
		</c:forEach>
            <tr>
              <td>상품수</td>
              <td>${totalProductCount}</td>
            </tr>
            <tr>
              <td>상품금액</td>
              <td><fmt:formatNumber value="${totalProductPrice}" pattern="#,###" /></td>
            </tr>
            <tr>
              <td>할인금액</td>
              <td><fmt:formatNumber value="${totalDiscount}" pattern="#,###" /></td>
            </tr>
            <tr>
              <td>배송비</td>
              <td>
		        <c:choose>
		            <c:when test="${totalDelivery == 0}">
		                <span class="delivery">무료배송</span>
		            </c:when>
		            <c:otherwise>
		                <fmt:formatNumber value="${totalDelivery}" pattern="#,###" />원
		            </c:otherwise>
		        </c:choose>
		    </td>
            </tr>              
            <tr>
              <td>포인트</td>
              <td>${totalPoints}</td>
            </tr>
            <tr>
              <td>전체주문금액</td>
              <td><fmt:formatNumber value="${totalOrderAmount}" pattern="#,###" /></td>
            </tr>
          </table>
          <input type="submit" name="" value="주문하기">    
        </div>

      </form>

    </section>
    <!-- 장바구니 페이지 끝 -->
</main>
<%@ include file="../_footer.jsp" %>   