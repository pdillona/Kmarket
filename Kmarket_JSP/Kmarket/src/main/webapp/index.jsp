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
            <c:forEach var="cate1gory1" items="${cate1gory1}">
        		<li>
            	<a href="#">
                <i class="fas fa-tshirt"></i>${cate1gory1.c1Name}<i class="fas fa-angle-right"></i>
            	</a>
            	<ol>
                	<!-- 해당 카테고리에 속한 두 번째 카테고리 목록 -->
                	<c:forEach var="cate2gory1" items="${cate2gory1}">
                    <li><a href="#">${cate2gory1.c2Name}</a></li>
                	</c:forEach>
           	 	</ol>
        		</li>
    		</c:forEach>
            
           <!-- 두 번째 카테고리 그룹 -->
   		 <c:forEach var="cate1gory2" items="${cate1gory2}">
        	<li>
            <a href="#">
                <i class="fas fa-tshirt"></i>${cate1gory2.c1Name}<i class="fas fa-angle-right"></i>
            </a>
            <ol>
                <!-- 해당 카테고리에 속한 두 번째 카테고리 목록 -->
                <c:forEach var="cate2gory2" items="${cate2gory2}">
                <li><a href="#">${cate2gory2.c2Name}</a></li>
                </c:forEach>
            </ol>
       		</li>
    	</c:forEach>

    
	</ul>

    <!-- 베스트상품 배너 -->
    <article class="best">
      <h1><i class="fas fa-crown"></i>베스트상품</h1>
      <ol>
        <li>
          <a href="#">
            <div class="thumb">
              <i>1</i>
              <img src="https://via.placeholder.com/230" alt="item1" />
            </div>
            <h2>상품명</h2>
            <div class="org_price">
              <del>30,000</del>
              <span>10%</span>
            </div>
            <div class="dis_price">
              <ins>27,000</ins>
            </div>
          </a>
        </li>
        <li>
          <a href="#">
            <div class="thumb">
              <i>2</i>
              <img src="https://via.placeholder.com/50" alt="item1" />
            </div>
            <article>
              <h2>상품명</h2>
              <div class="org_price">
                <del>30,000</del>
                <span>10%</span>
              </div>
              <div class="dis_price">
                <ins>27,000</ins>
              </div>
            </article>
          </a>
        </li>
        <li>
          <a href="#">
            <div class="thumb">
              <i>3</i>
              <img src="https://via.placeholder.com/50" alt="item1" />
            </div>
            <article>
              <h2>상품명</h2>
              <div class="org_price">
                <del>30,000</del>
                <span>10%</span>
              </div>
              <div class="dis_price">
                <ins>27,000</ins>
              </div>
            </article>
          </a>
        </li>
        <li>
          <a href="#">
            <div class="thumb">
              <i>4</i>
              <img src="https://via.placeholder.com/50" alt="item1" />
            </div>
            <article>
              <h2>상품명</h2>
              <div class="org_price">
                <del>30,000</del>
                <span>10%</span>
              </div>
              <div class="dis_price">
                <ins>27,000</ins>
              </div>
            </article>
          </a>
        </li>
        <li>
          <a href="#">
            <div class="thumb">
              <i>5</i>
              <img src="https://via.placeholder.com/50" alt="item1" />
            </div>
            <article>
              <h2>상품명</h2>
              <div class="org_price">
                <del>30,000</del>
                <span>10%</span>
              </div>
              <div class="dis_price">
                <ins>27,000</ins>
              </div>
            </article>
          </a>
        </li>
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
      <article>
        <a href="#">
          <div class="thumb">
            <img src="https://via.placeholder.com/230x230" alt="t1" />
          </div>
          <h2>상품명</h2>
          <p>간단한 상품 설명</p>
          <div class="org_price">
            <del>30,000</del>
            <span>10%</span>
          </div>
          <div class="dis_price">
            <ins>27,000</ins>
            <span class="free">무료배송</span>
          </div>
        </a>
      </article>
      <article>
        <a href="#">
          <div class="thumb">
            <img src="https://via.placeholder.com/230x230" alt="t1" />
          </div>
          <h2>상품명</h2>
          <p>간단한 상품 설명</p>
          <div class="org_price">
            <del>30,000</del>
            <span>10%</span>
          </div>
          <div class="dis_price">
            <ins>27,000</ins>
            <span class="free">무료배송</span>
          </div>
        </a>
      </article>
      <article>
        <a href="#">
          <div class="thumb">
            <img src="https://via.placeholder.com/230x230" alt="t1" />
          </div>
          <h2>상품명</h2>
          <p>간단한 상품 설명</p>
          <div class="org_price">
            <del>30,000</del>
            <span>10%</span>
          </div>
          <div class="dis_price">
            <ins>27,000</ins>
            <span class="free">무료배송</span>
          </div>
        </a>
      </article>
      <article>
        <a href="#">
          <div class="thumb">
            <img src="https://via.placeholder.com/230x230" alt="t1" />
          </div>
          <h2>상품명</h2>
          <p>간단한 상품 설명</p>
          <div class="org_price">
            <del>30,000</del>
            <span>10%</span>
          </div>
          <div class="dis_price">
            <ins>27,000</ins>
            <span class="free">무료배송</span>
          </div>
        </a>
      </article>
      <article>
        <a href="#">
          <div class="thumb">
            <img src="https://via.placeholder.com/230x230" alt="t1" />
          </div>
          <h2>상품명</h2>
          <p>간단한 상품 설명</p>
          <div class="org_price">
            <del>30,000</del>
            <span>10%</span>
          </div>
          <div class="dis_price">
            <ins>27,000</ins>
            <span class="free">무료배송</span>
          </div>
        </a>
      </article>
      <article>
        <a href="#">
          <div class="thumb">
            <img src="https://via.placeholder.com/230x230" alt="t1" />
          </div>
          <h2>상품명</h2>
          <p>간단한 상품 설명</p>
          <div class="org_price">
            <del>30,000</del>
            <span>10%</span>
          </div>
          <div class="dis_price">
            <ins>27,000</ins>
            <span class="free">무료배송</span>
          </div>
        </a>
      </article>
      <article>
        <a href="#">
          <div class="thumb">
            <img src="https://via.placeholder.com/230x230" alt="t1" />
          </div>
          <h2>상품명</h2>
          <p>간단한 상품 설명</p>
          <div class="org_price">
            <del>30,000</del>
            <span>10%</span>
          </div>
          <div class="dis_price">
            <ins>27,000</ins>
            <span class="free">무료배송</span>
          </div>
        </a>
      </article>
      <article>
        <a href="#">
          <div class="thumb">
            <img src="https://via.placeholder.com/230x230" alt="t1" />
          </div>
          <h2>상품명</h2>
          <p>간단한 상품 설명</p>
          <div class="org_price">
            <del>30,000</del>
            <span>10%</span>
          </div>
          <div class="dis_price">
            <ins>27,000</ins>
            <span class="free">무료배송</span>
          </div>
        </a>
      </article>
    </section>
    <!-- 추천상품 영역 -->
    <section class="recommend">
      <h3><span>추천상품</span></h3>
      <article>
        <a href="#">
          <div class="thumb">
            <img src="https://via.placeholder.com/230x230" alt="t1" />
          </div>
          <h2>상품명</h2>
          <p>간단한 상품 설명</p>
          <div class="org_price">
            <del>30,000</del>
            <span>10%</span>
          </div>
          <div class="dis_price">
            <ins>27,000</ins>
            <span>배송비 2500</span>
          </div>
        </a>
      </article>
      <article>
        <a href="#">
          <div class="thumb">
            <img src="https://via.placeholder.com/230x230" alt="t1" />
          </div>
          <h2>상품명</h2>
          <p>간단한 상품 설명</p>
          <div class="org_price">
            <del>30,000</del>
            <span>10%</span>
          </div>
          <div class="dis_price">
            <ins>27,000</ins>
            <span>배송비 2500</span>
          </div>
        </a>
      </article>
      <article>
        <a href="#">
          <div class="thumb">
            <img src="https://via.placeholder.com/230x230" alt="t1" />
          </div>
          <h2>상품명</h2>
          <p>간단한 상품 설명</p>
          <div class="org_price">
            <del>30,000</del>
            <span>10%</span>
          </div>
          <div class="dis_price">
            <ins>27,000</ins>
            <span>배송비 2500</span>
          </div>
        </a>
      </article>
      <article>
        <a href="#">
          <div class="thumb">
            <img src="https://via.placeholder.com/230x230" alt="t1" />
          </div>
          <h2>상품명</h2>
          <p>간단한 상품 설명</p>
          <div class="org_price">
            <del>30,000</del>
            <span>10%</span>
          </div>
          <div class="dis_price">
            <ins>27,000</ins>
            <span>배송비 2500</span>
          </div>
        </a>
      </article>
      <article>
        <a href="#">
          <div class="thumb">
            <img src="https://via.placeholder.com/230x230" alt="t1" />
          </div>
          <h2>상품명</h2>
          <p>간단한 상품 설명</p>
          <div class="org_price">
            <del>30,000</del>
            <span>10%</span>
          </div>
          <div class="dis_price">
            <ins>27,000</ins>
            <span>배송비 2500</span>
          </div>
        </a>
      </article>
      <article>
        <a href="#">
          <div class="thumb">
            <img src="https://via.placeholder.com/230x230" alt="t1" />
          </div>
          <h2>상품명</h2>
          <p>간단한 상품 설명</p>
          <div class="org_price">
            <del>30,000</del>
            <span>10%</span>
          </div>
          <div class="dis_price">
            <ins>27,000</ins>
            <span>배송비 2500</span>
          </div>
        </a>
      </article>
      <article>
        <a href="#">
          <div class="thumb">
            <img src="https://via.placeholder.com/230x230" alt="t1" />
          </div>
          <h2>상품명</h2>
          <p>간단한 상품 설명</p>
          <div class="org_price">
            <del>30,000</del>
            <span>10%</span>
          </div>
          <div class="dis_price">
            <ins>27,000</ins>
            <span>배송비 2500</span>
          </div>
        </a>
      </article>
      <article>
        <a href="#">
          <div class="thumb">
            <img src="https://via.placeholder.com/230x230" alt="t1" />
          </div>
          <h2>상품명</h2>
          <p>간단한 상품 설명</p>
          <div class="org_price">
            <del>30,000</del>
            <span>10%</span>
          </div>
          <div class="dis_price">
            <ins>27,000</ins>
            <span>배송비 2500</span>
          </div>
        </a>
      </article>
    </section>
    <!-- 최신상품 영역 -->
    <section class="new">
      <h3><span>최신상품</span></h3>
      <article>
        <a href="#">
          <div class="thumb">
            <img src="https://via.placeholder.com/230x230" alt="t1" />
          </div>
          <h2>상품명</h2>
          <p>간단한 상품 설명</p>
          <div class="org_price">
            <del>30,000</del>
            <span>10%</span>
          </div>
          <div class="dis_price">
            <ins>27,000</ins>
            <span class="free">무료배송</span>
          </div>
        </a>
      </article>
      <article>
        <a href="#">
          <div class="thumb">
            <img src="https://via.placeholder.com/230x230" alt="t1" />
          </div>
          <h2>상품명</h2>
          <p>간단한 상품 설명</p>
          <div class="org_price">
            <del>30,000</del>
            <span>10%</span>
          </div>
          <div class="dis_price">
            <ins>27,000</ins>
            <span class="free">무료배송</span>
          </div>
        </a>
      </article>
      <article>
        <a href="#">
          <div class="thumb">
            <img src="https://via.placeholder.com/230x230" alt="t1" />
          </div>
          <h2>상품명</h2>
          <p>간단한 상품 설명</p>
          <div class="org_price">
            <del>30,000</del>
            <span>10%</span>
          </div>
          <div class="dis_price">
            <ins>27,000</ins>
            <span class="free">무료배송</span>
          </div>
        </a>
      </article>
      <article>
        <a href="#">
          <div class="thumb">
            <img src="https://via.placeholder.com/230x230" alt="t1" />
          </div>
          <h2>상품명</h2>
          <p>간단한 상품 설명</p>
          <div class="org_price">
            <del>30,000</del>
            <span>10%</span>
          </div>
          <div class="dis_price">
            <ins>27,000</ins>
            <span class="free">무료배송</span>
          </div>
        </a>
      </article>
      <article>
        <a href="#">
          <div class="thumb">
            <img src="https://via.placeholder.com/230x230" alt="t1" />
          </div>
          <h2>상품명</h2>
          <p>간단한 상품 설명</p>
          <div class="org_price">
            <del>30,000</del>
            <span>10%</span>
          </div>
          <div class="dis_price">
            <ins>27,000</ins>
            <span class="free">무료배송</span>
          </div>
        </a>
      </article>
      <article>
        <a href="#">
          <div class="thumb">
            <img src="https://via.placeholder.com/230x230" alt="t1" />
          </div>
          <h2>상품명</h2>
          <p>간단한 상품 설명</p>
          <div class="org_price">
            <del>30,000</del>
            <span>10%</span>
          </div>
          <div class="dis_price">
            <ins>27,000</ins>
            <span class="free">무료배송</span>
          </div>
        </a>
      </article>
      <article>
        <a href="#">
          <div class="thumb">
            <img src="https://via.placeholder.com/230x230" alt="t1" />
          </div>
          <h2>상품명</h2>
          <p>간단한 상품 설명</p>
          <div class="org_price">
            <del>30,000</del>
            <span>10%</span>
          </div>
          <div class="dis_price">
            <ins>27,000</ins>
            <span class="free">무료배송</span>
          </div>
        </a>
      </article>
      <article>
        <a href="#">
          <div class="thumb">
            <img src="https://via.placeholder.com/230x230" alt="t1" />
          </div>
          <h2>상품명</h2>
          <p>간단한 상품 설명</p>
          <div class="org_price">
            <del>30,000</del>
            <span>10%</span>
          </div>
          <div class="dis_price">
            <ins>27,000</ins>
            <span class="free">무료배송</span>
          </div>
        </a>
      </article>
    </section>
    <!-- 할인상품 영역 -->
    <section class="discount">
      <h3><span>할인상품</span></h3>
      <article>
        <a href="#">
          <div class="thumb">
            <img src="https://via.placeholder.com/230x230" alt="t1" />
          </div>
          <h2>상품명</h2>
          <p>간단한 상품 설명</p>
          <div class="org_price">
            <del>30,000</del>
            <span>10%</span>
          </div>
          <div class="dis_price">
            <ins>27,000</ins>
            <span class="free">무료배송</span>
          </div>
        </a>
      </article>
      <article>
        <a href="#">
          <div class="thumb">
            <img src="https://via.placeholder.com/230x230" alt="t1" />
          </div>
          <h2>상품명</h2>
          <p>간단한 상품 설명</p>
          <div class="org_price">
            <del>30,000</del>
            <span>10%</span>
          </div>
          <div class="dis_price">
            <ins>27,000</ins>
            <span class="free">무료배송</span>
          </div>
        </a>
      </article>
      <article>
        <a href="#">
          <div class="thumb">
            <img src="https://via.placeholder.com/230x230" alt="t1" />
          </div>
          <h2>상품명</h2>
          <p>간단한 상품 설명</p>
          <div class="org_price">
            <del>30,000</del>
            <span>10%</span>
          </div>
          <div class="dis_price">
            <ins>27,000</ins>
            <span class="free">무료배송</span>
          </div>
        </a>
      </article>
      <article>
        <a href="#">
          <div class="thumb">
            <img src="https://via.placeholder.com/230x230" alt="t1" />
          </div>
          <h2>상품명</h2>
          <p>간단한 상품 설명</p>
          <div class="org_price">
            <del>30,000</del>
            <span>10%</span>
          </div>
          <div class="dis_price">
            <ins>27,000</ins>
            <span class="free">무료배송</span>
          </div>
        </a>
      </article>
      <article>
        <a href="#">
          <div class="thumb">
            <img src="https://via.placeholder.com/230x230" alt="t1" />
          </div>
          <h2>상품명</h2>
          <p>간단한 상품 설명</p>
          <div class="org_price">
            <del>30,000</del>
            <span>10%</span>
          </div>
          <div class="dis_price">
            <ins>27,000</ins>
            <span class="free">무료배송</span>
          </div>
        </a>
      </article>
      <article>
        <a href="#">
          <div class="thumb">
            <img src="https://via.placeholder.com/230x230" alt="t1" />
          </div>
          <h2>상품명</h2>
          <p>간단한 상품 설명</p>
          <div class="org_price">
            <del>30,000</del>
            <span>10%</span>
          </div>
          <div class="dis_price">
            <ins>27,000</ins>
            <span class="free">무료배송</span>
          </div>
        </a>
      </article>
      <article>
        <a href="#">
          <div class="thumb">
            <img src="https://via.placeholder.com/230x230" alt="t1" />
          </div>
          <h2>상품명</h2>
          <p>간단한 상품 설명</p>
          <div class="org_price">
            <del>30,000</del>
            <span>10%</span>
          </div>
          <div class="dis_price">
            <ins>27,000</ins>
            <span class="free">무료배송</span>
          </div>
        </a>
      </article>
      <article>
        <a href="#">
          <div class="thumb">
            <img src="https://via.placeholder.com/230x230" alt="t1" />
          </div>
          <h2>상품명</h2>
          <p>간단한 상품 설명</p>
          <div class="org_price">
            <del>30,000</del>
            <span>10%</span>
          </div>
          <div class="dis_price">
            <ins>27,000</ins>
            <span class="free">무료배송</span>
          </div>
        </a>
      </article>
    </section>
  </section>
</main>
<%@ include file="./_footer.jsp" %>