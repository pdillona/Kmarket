<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="./_header.jsp" %>
<main id="product">
	<!-- 
		날짜 : 2023/09/19
		이름 : 김무현
		내용 : 카테고리1별 리스트 출력
	 -->            
<jsp:include page="./_aside.jsp"/>
    
    <section class="list">              
      <jsp:include page="./_nav.jsp"/>
      <!-- 정렬 메뉴 -->
      <ul class="sort">
          <li><a href="/Kmarket/product/list.do?prodCate1=${prodCate1}&prodCate2=${prodCate2}&type=1" class="on">판매많은순</a></li>
          <li><a href="#">낮은가격순</a></li>
          <li><a href="#">높은가격순</a></li>
          <li><a href="#">평점높은순</a></li>
          <li><a href="#">후기많은순</a></li>
          <li><a href="#">최근등록순</a></li>
      </ul>

      <!-- 상품목록 -->
      <c:forEach var="products" items="${products}">                
      <table border="0">
        <tr>
          <td><a href="#" class="thumb"><img src="/Kmarket/thumb/${products.prodCate1}/${products.prodCate2}/${products.thumb1}" alt="상품이미지"/></a></td>
          <td>
            <h3 class="name">${products.prodName}</h3>
            <a href="#" class="desc">${products.descript}</a>
          </td>
          <td>
            <ul>
              <li>
	              	<ins class="dis-price">
					    <c:set var="discountedPrice" value="0" />
					    <c:choose>
					        <c:when test="${products.discount != 0}">
					            <c:set var="discountedPrice" value="${products.price - (products.price * (products.discount / 100))}"/>
					        </c:when>
					        <c:otherwise>
					            <c:set var="discountedPrice" value="${products.price}"/>
					        </c:otherwise>
					    </c:choose>
					    <fmt:formatNumber value="${discountedPrice}"/>
					</ins>
				</li>
              <li>
                <del class="org-price">${products.priceWithComma}</del>
                <span class="discount">${products.discount}%</span>
              </li>
              <li><span class="${products.delivery == 0 ? 'free-delivery' : ''}">배송비 ${products.delivery}</span></li>
            </ul>
          </td>
          <td>
            <h4 class="seller"><i class="fas fa-home"></i>&nbsp;${products.seller}</h4>
            <h5 class="badge power">판매자등급</h5>
            <h6 class="rating star1">상품평</h6>
          </td>
        </tr>
        
      </table>            
	</c:forEach> 
      <!-- 상품목록 페이지번호 -->
       <div class="paging">
           	<c:if test="${pageGroupStart > 1}">
           		<span class="prev">
           			<a href="/Kmarket/product/list.do?prodCate1=${prodCate1}&pg=${pageGroupStart - 1}">
           			<&nbsp;이전
           			</a>
            	</span>
           	</c:if>
               <span class="num">
            <c:forEach var="i" begin="${pageGroupStart}" end="${pageGroupEnd}">
            	<a href="/Kmarket/product/list.do?prodCate1=${prodCate1}&pg=${i}" class="${currentPage == i? 'on':'off'}">${i}</a>
            </c:forEach>
               </span>
            <c:if test="${pageGroupEnd < lastPageNum}">
	            <span class="next">
	                   <a href="/Kmarket/product/list.do?prodCate1=${prodCate1}&pg=${pageGroupEnd + 1}">
	                   다음&nbsp;>
	                   </a>
	            </span>
            </c:if>
               
           </div>

    </section>
</main>
<%@ include file="../_footer.jsp" %>     