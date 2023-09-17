<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../_header.jsp" %>
<%@ include file="../_aside.jsp"%>
   <section id="seller-product-list">
       <nav>
           <h3>상품관리</h3>
           <p>
               HOME > 상품관리 > <strong>상품현황</strong>
           </p>
       </nav>
       <!-- 상품현황 컨텐츠 시작 -->                                
       <section>
           <div>
           <form action="/Kmarket/seller/product/list.do" method="get">
	           <select name="search">
	                  <option value="search1">상품명</option>
	                  <option value="search2">상품코드</option>
	                  <option value="search3">제조사</option>
	                  <option value="search4">판매자</option>                                    
	           </select>
	           <input type="text" name="search_text">
           </form>
           </div>
           <table>
               <tr>
                   <th><input type="checkbox" name="all"/></th>
                   <th>이미지</th>
                   <th>상품코드</th>
                   <th>상품명</th>
                   <th>판매가격</th>
                   <th>할인율</th>
                   <th>포인트</th>
                   <th>재고</th>
                   <th>판매자</th>
                   <th>조회</th>
                   <th>관리</th>
               </tr>
               <tr>
               <c:forEach var="product" items="${products}">
               	<td><input type="checkbox" name="chk"/></td>
                <td><img src="/Kmarket/thumb/${product.prodCate1}/${product.prodCate2}/${product.newThumb1}" class="thumb"></td>
                <td>${product.prodNo}</td>
                <td>${product.prodName}</td>
                <td>${product.getPriceComma}</td>
                <td>${product.discount}</td>
                <td>${product.point}</td>
                <td>${product.stock}</td>
                <td>${product.seller}</td>
                <td>${product.hit}</td>
                <td>
                    <a href="#">[삭제]</a>
                    <a href="#">[수정]</a>
                </td>
               </c:forEach>
               </tr>
           </table>

           
           <input class="btnDelete" type="button" value="선택삭제" />                          


           <div class="paging">
           	<c:if test="${pageGroupStart > 1}">
           		<span class="prev">
           			<a href="/Kmarket/seller/seller/product/list.do?pg=${pageGroupStart - 1}&search=${search}&search_text=${search_text}">
           			<&nbsp;이전
           			</a>
            	</span>
           	</c:if>
               <span class="num">
            <c:forEach var="i" begin="${pageGroupStart}" end="${pageGroupEnd}">
            	<a href="/Kmarket/seller/product/list.do?pg=${i}&search=${search}&search_text=${search_text}" class="${currentPage == i? 'on':'off'}">${i}</a>
            </c:forEach>
               </span>
            <c:if test="${pageGroupEnd < lastPageNum}">
	            <span class="next">
	                   <a href="/Kmarket/seller/product/list.do?pg=${pageGroupEnd + 1}&search=${search}&search_text=${search_text}">
	                   다음&nbsp;>
	                   </a>
	            </span>
            </c:if>
               
           </div>

       </section>                

       <p class="ico info">
           <strong>Tip!</strong>
           전자상거래 등에서의 상품 등의 정보제공에 관한 고시에 따라 총 35개 상품군에 대해 상품 특성 등을 양식에 따라 입력할 수 있습니다.
       </p>

       

       <!-- 상품현황 컨텐츠 끝 -->
    </section>
</main>
<%@ include file="../_footer.jsp" %>
