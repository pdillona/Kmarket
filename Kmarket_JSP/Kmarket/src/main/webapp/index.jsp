<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="./_header.jsp" %>
	<!-- 
		날짜 : 2023/09/15
		이름 : 김무현
		내용 : include 작업 및 배너 슬라이드작업 카테고리 출력
	 -->

<main>
        <!-- 카테고리/베스트 상품 영역 -->
        <aside>
          <!-- 카테고리 -->
          <ul class="category">     
          	<li><i class="fa fa-bars" aria-hidden="true"></i>카테고리</li>
          		<c:forEach var="cate2s" items="${categories}">
                 <li>
                        <a href="/Kmarket/product/list.do?prodCate1=${cate2s.get(0).cate1}">
                        <c:if test="${cate2s.get(0).cate1 == 10}"><i class="fas fa-tshirt"></i></c:if>                        
                        <c:if test="${cate2s.get(0).cate1 == 11}"><i class="fas fa-socks"></i></c:if>                        
                        <c:if test="${cate2s.get(0).cate1 == 12}"><i class="fas fa-child"></i></c:if>                        
                        <c:if test="${cate2s.get(0).cate1 == 13}"><i class="fas fa-utensils"></i></c:if>                        
                        <c:if test="${cate2s.get(0).cate1 == 14}"><i class="fas fa-home"></i></c:if>                        
                        <c:if test="${cate2s.get(0).cate1 == 15}"><i class="fas fa-laptop"></i></c:if>     	                   
                        <c:if test="${cate2s.get(0).cate1 == 16}"><i class="fas fa-medal"></i></c:if>                        
                        <c:if test="${cate2s.get(0).cate1 == 17}"><i class="fas fa-car"></i></c:if>                        
                        <c:if test="${cate2s.get(0).cate1 == 18}"><i class="fas fa-book"></i></c:if>                        
                        	${cate2s.get(0).c1Name}
                        </a>
                        <ol>
                        	<c:forEach var="cate2" items="${cate2s}">
                            	<li><a href="/Kmarket/product/list.do?prodCate1=${cate2s.get(0).cate1}&prodCate2=${cate2.cate2}">${cate2.c2Name}</a></li>
                            </c:forEach>
                        </ol>
        		</li>
               </c:forEach>
		</ul>

    <!-- 베스트상품 배너 -->
    <article class="best">
      <h1><i class="fas fa-crown"></i>베스트상품</h1>
      <ol>
      <c:forEach var="product" items="${products}" varStatus="loop">
        <li>
          <a href="#">
            <div class="thumb">
              <i>${loop.index + 1}</i>
              <img src="/Kmarket/thumb/${product.prodCate1}/${product.prodCate2}/${product.thumb1}" alt="상품 이미지">
            </div>
            <h2>${product.prodName}</h2>
            <div class="org_price">
              <del>${product.priceWithComma}</del>
              <span>${product.discount}%</span>
            </div>
            <div class="dis_price">
           	<ins>
			    <c:set var="discountedPrice" value="0" />
			    <c:choose>
			        <c:when test="${product.discount != 0}">
			            <c:set var="discountedPrice" value="${product.price - (product.price * (product.discount / 100))}"/>
			        </c:when>
			        <c:otherwise>
			            <c:set var="discountedPrice" value="${product.price}"/>
			        </c:otherwise>
			    </c:choose>
			    <fmt:formatNumber value="${discountedPrice}"/>
			</ins>
            </div>
          </a>
        </li>
        </c:forEach>
      </ol>
    </article>
  </aside>
  <section>
    <!-- 슬라이더 영역 -->
    <section class="slider">
      <ul>
        <li>
          <a href="#"
            ><img src="./img/slider_item1.jpg" alt="item1"
          /></a>
        </li>
        <li>
          <a href="#"
            ><img src="./img/slider_item2.jpg" alt="item2"
          /></a>
        </li>
        <li>
          <a href="#"
            ><img src="./img/slider_item3.jpg" alt="item3"
          /></a>
        </li>
        <li>
          <a href="#"
            ><img src="./img/slider_item4.jpg" alt="item4"
          /></a>
        </li>
        <li>
          <a href="#"
            ><img src="./img/slider_item5.jpg" alt="item5"
          /></a>
        </li>
      </ul>
    </section>
    <!-- 히트상품 영역 -->
    <section class="hit">
      <h3><span>히트상품</span></h3>
      <c:forEach var="productshit" items="${productshit}">
      <article>
        <a href="#">
          <div class="thumb">
            <img src="/Kmarket/thumb/${productshit.prodCate1}/${productshit.prodCate2}/${productshit.thumb2}" alt="상품이미지" />
          </div>
          <h2>${productshit.prodName}</h2>
          <p>${productshit.descript}</p>
          <div class="org_price">
            <del>${productshit.priceWithComma}</del>
            <span>${productshit.discount}%</span>
          </div>
          <div class="dis_price">
            <ins>
            <c:set var="discountedPrice" value="0" />
				<c:choose>
				    <c:when test="${productshit.discount != 0}">
				        <c:set var="discountedPrice" value="${productshit.price - (productshit.price * (productshit.discount / 100))}"/>
				    </c:when>
				    <c:otherwise>
				        <c:set var="discountedPrice" value="${productshit.price}" />
				    </c:otherwise>
				</c:choose>
				<fmt:formatNumber value="${discountedPrice}"/>
			</ins>
            <span class="${productshit.delivery == 0 ? 'free' : ''}">배송비 ${productshit.delivery}</span>
          </div>
        </a>
      </article>
      </c:forEach>
    </section>
    <!-- 추천상품 영역 -->
    <section class="recommend">
      <h3><span>추천상품</span></h3>
      <c:forEach var="productsScore" items="${productsScore}">
      <article>
        <a href="#">
          <div class="thumb">
            <img src="/Kmarket/thumb/${productsScore.prodCate1}/${productsScore.prodCate2}/${productsScore.thumb2}" alt="상품이미지" />
          </div>
          <h2>${productsScore.prodName}</h2>
          <p>${productsScore.descript}</p>
          <div class="org_price">
            <del>${productsScore.priceWithComma}</del>
            <span>${productsScore.discount}%</span>
          </div>
          <div class="dis_price">
            <ins>
            <c:set var="discountedPrice" value="0" />
				<c:choose>
				    <c:when test="${productsScore.discount != 0}">
				        <c:set var="discountedPrice" value="${productsScore.price - (productsScore.price * (productsScore.discount / 100))}"/>
				    </c:when>
				    <c:otherwise>
				        <c:set var="discountedPrice" value="${productsScore.price}" />
				    </c:otherwise>
				</c:choose>
				<fmt:formatNumber value="${discountedPrice}"/>
			</ins>
            <span class="${productsScore.delivery == 0 ? 'free' : ''}">배송비 ${productsScore.delivery}</span>
          </div>
        </a>
      </article>
      </c:forEach>
    </section>
    <!-- 최신상품 영역 -->
    <section class="new">
      <h3><span>최신상품</span></h3>
      <c:forEach var="productsRdate" items="${productsRdate}">
      <article>
        <a href="#">
          <div class="thumb">
            <img src="/Kmarket/thumb/${productsRdate.prodCate1}/${productsRdate.prodCate2}/${productsRdate.thumb2}" alt="상품이미지" />
          </div>
          <h2>${productsRdate.prodName}</h2>
          <p>${productsRdate.descript}</p>
          <div class="org_price">
            <del>${productsRdate.priceWithComma}</del>
            <span>${productsRdate.discount}%</span>
          </div>
          <div class="dis_price">
            <ins>
            <c:set var="discountedPrice" value="0" />
				<c:choose>
				    <c:when test="${productsRdate.discount != 0}">
				        <c:set var="discountedPrice" value="${productsRdate.price - (productsRdate.price * (productsRdate.discount / 100))}"/>
				    </c:when>
				    <c:otherwise>
				        <c:set var="discountedPrice" value="${productsRdate.price}" />
				    </c:otherwise>
				</c:choose>
				<fmt:formatNumber value="${discountedPrice}"/>
			</ins>
            <span class="${productsRdate.delivery == 0 ? 'free' : ''}">배송비 ${productsRdate.delivery}</span>
          </div>
        </a>
      </article>
      </c:forEach>
    </section>
    <!-- 할인상품 영역 -->
    <section class="discount">
      <h3><span>할인상품</span></h3>
     <c:forEach var="productsDiscount" items="${productsDiscount}">
      <article>
        <a href="#">
          <div class="thumb">
            <img src="/Kmarket/thumb/${productsDiscount.prodCate1}/${productsDiscount.prodCate2}/${productsDiscount.thumb2}" alt="상품이미지" />
          </div>
          <h2>${productsDiscount.prodName}</h2>
          <p>${productsDiscount.descript}</p>
          <div class="org_price">
            <del>${productsDiscount.priceWithComma}</del>
            <span>${productsDiscount.discount}%</span>
          </div>
          <div class="dis_price">
            <ins>
            <c:set var="discountedPrice" value="0" />
				<c:choose>
				    <c:when test="${productsDiscount.discount != 0}">
				        <c:set var="discountedPrice" value="${productsDiscount.price - (productsDiscount.price * (productsDiscount.discount / 100))}"/>
				    </c:when>
				    <c:otherwise>
				        <c:set var="discountedPrice" value="${productsDiscount.price}" />
				    </c:otherwise>
				</c:choose>
				<fmt:formatNumber value="${discountedPrice}"/>
			</ins>
            <span class="${productsDiscount.delivery == 0 ? 'free' : ''}">배송비 ${productsDiscount.delivery}</span>
          </div>
        </a>
      </article>
      </c:forEach>
    </section>
  </section>
</main>
<%@ include file="./_footer.jsp" %>