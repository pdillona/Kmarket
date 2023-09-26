<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%> 
<%@ include file="./_header.jsp" %>

<script>
    window.onload = function () {
        const cartTable = document.getElementById('cartTable');
        const checkboxes = document.querySelectorAll('input[type="checkbox"].checkboxproduct');
        const totalCount = document.getElementById('totalCount');
        const totalPrice = document.getElementById('totalPrice');
        const totalDiscount = document.getElementById('totalDiscount');
        const totalDelivery = document.getElementById('totalDelivery');
        const totalPoints = document.getElementById('totalPoints');
        const finalTotal = document.getElementById('finalTotal');
        const deleteButton = document.getElementById('deleteButton');
        const uid = "${sessUser.uid}"
        
        console.log(uid);
        

        checkboxes.forEach(checkbox => {
            checkbox.addEventListener('change', updateCart);
        });

        deleteButton.addEventListener('click', deleteSelectedProducts);

        function updateCart() {
            let selectedProducts = [];
            let totalCountValue = 0;
            let totalPriceValue = 0;
            let totalDiscountValue = 0;
            let totalDeliveryValue = 0;
            let totalPointsValue = 0;

            checkboxes.forEach(checkbox => {
                if (checkbox.checked) {
                    const row = checkbox.parentElement.parentElement;
                    const count = parseInt(row.querySelector('.count').textContent);
                    const originalPrice = parseFloat(row.querySelector('td:nth-child(4)').textContent);
                    const discountPercent = parseFloat(row.querySelector('td:nth-child(5)').textContent);
                    let delivery = parseFloat(row.querySelector('td:nth-child(7)').textContent);
                    const points = parseFloat(row.querySelector('td:nth-child(6)').textContent);
                    // 할인 금액 계산
                    const discountAmount = (originalPrice * discountPercent) / 100;

                    selectedProducts.push({
                        count: count,
                        originalPrice: originalPrice,
                        discountPercent: discountPercent,
                        discountAmount: discountAmount,
                        delivery: delivery,
                        points: points
                    });
                    console.log(delivery);
                    totalCountValue += count;
                    totalPriceValue += originalPrice * count;
                    totalDiscountValue += discountAmount * count;
                    if (isNaN(delivery)) {
                        delivery = 0;
                    }
                    totalDeliveryValue += delivery;
                    totalPointsValue += points * count;
                }
            });

            totalCount.textContent = totalCountValue;
            totalPrice.textContent = totalPriceValue;
            totalDiscount.textContent = totalDiscountValue;
            totalDelivery.textContent = totalDeliveryValue;
            totalPoints.textContent = totalPointsValue;
            finalTotal.textContent = (totalPriceValue - totalDiscountValue + totalDeliveryValue);
        }

        function deleteSelectedProducts() {
        	 let cartNo = ''; // 초기화

        	    const selectedCheckbox = document.querySelector('input[type="checkbox"].checkboxproduct:checked');

        	    if (selectedCheckbox) {
        	        // 선택된 체크박스에서 data-cart-no 속성을 읽어옴
        	        cartNo = selectedCheckbox.value;
        	        
        	        console.log(cartNo);

        	        // GET 요청을 수행하고 선택된 상품을 서버로 전송
        	        window.location.href = `/Kmarket/product/delete.do?cartNo=${cartNo}&uid=${sessUser.uid}`;
        	        
        	        
        	    }
        	}
    };
</script>

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
        <table id="cartTable">
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
              <td><input type="checkbox" name="" class="checkboxproduct" value="${carts.cartNo}"></td>
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
        <input type="button" name="del" id="deleteButton" value="선택삭제"/>

        <!-- 장바구니 전체합계 -->
                <div class="total">
                  <h2>전체합계</h2>
                  <table border="0">
                    <tr>
                      <td>상품수</td>
                      <td id="totalCount">0</td>
                    </tr>
                    <tr>
                      <td>상품금액</td>
                      <td id="totalPrice">0</td>
                    </tr>
                    <tr>
                      <td>할인금액</td>
                      <td id="totalDiscount">0</td>
                    </tr>
                    <tr>
                      <td>배송비</td>
                      <td id="totalDelivery">0</td>
                    </tr>              
                    <tr>
                      <td>포인트</td>
                      <td id="totalPoints">0</td>
                    </tr>
                    <tr>
                      <td>전체주문금액</td>
                      <td id="finalTotal">0</td>
                    </tr>
                  </table>
                  <input type="submit" name="" value="주문하기">    
                </div>

              </form>

            </section>
            <!-- 장바구니 페이지 끝 -->
</main>
<%@ include file="../_footer.jsp" %>   