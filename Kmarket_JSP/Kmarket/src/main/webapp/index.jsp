<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<<<<<<< HEAD
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctxPath" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>index</title>
    <script src="https://kit.fontawesome.com/20962f3e4b.js" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="./css/common.css">
</head>
<body>
    <div id="bannerTop" class="on" style="background: #e4dfdf;">
      <article>
        <a href="#"><img src="./img/topBanner1.png"/></a>
        <button class="btnClose">close</button>
      </article>
    </div>
    <div id="wrapper">      
      <header>
        <div class="top">
          <div>
            <a href="./member/login.html">로그인</a>
            <a href="#">회원가입</a>
            <a href="#">마이페이지</a>
            <a href="#"
              ><i class="fa fa-shopping-cart" aria-hidden="true"></i
              >&nbsp;장바구니</a
            >
          </div>
        </div>
        <div class="logo">
          <div>
            <a href="#"><img src="./img/header_logo.png" alt="로고" /></a>
            <form action="#">
              <input type="text" name="search" />
              <button><i class="fa fa-search"></i></button>
            </form>
          </div>
        </div>
        <div class="menu">
          <div>
            <ul>
              <li><a href="#">히트상품</a></li>
              <li><a href="#">추천상품</a></li>
              <li><a href="#">최신상품</a></li>
              <li><a href="#">인기상품</a></li>
              <li><a href="#">할인상품</a></li>
            </ul>
            <ul>
              <li><a href="#">공지사항</a></li>
              <li><a href="#">자주묻는질문</a></li>
              <li><a href="#">문의하기</a></li>
              <li><a href="${ctxPath}/index.do">고객센터</a></li>
            </ul>
          </div>
        </div>
      </header>
=======
<%@ include file="./_header.jsp" %>

>>>>>>> 73e58183224c65fc25a197c67144a8a860a0828a
      <main>
        <!-- 카테고리/베스트 상품 영역 -->
        <aside>
          <!-- 카테고리 -->
          <ul class="category">
            <li><i class="fa fa-bars" aria-hidden="true"></i>카테고리</li>
            <li>
              <a href="#"
                ><i class="fas fa-tshirt"></i>패션·의류·뷰티<i
                  class="fas fa-angle-right"
                ></i
              ></a>
              <ol>
                <li><a href="#">남성의류</a></li>
                <li><a href="#">여성의류</a></li>
                <li><a href="#">잡화</a></li>
                <li><a href="#">뷰티</a></li>
              </ol>
            </li>
            <li>
              <a href="#"
                ><i class="fas fa-laptop"></i>가전·디지털<i
                  class="fas fa-angle-right"
                ></i
              ></a>
              <ol>
                <li><a href="#">노트북/PC</a></li>
                <li><a href="#">가전</a></li>
                <li><a href="#">휴대폰</a></li>
                <li><a href="#">기타</a></li>
              </ol>
            </li>
            <li>
              <a href="#"
                ><i class="fas fa-utensils"></i>식품·생필품<i
                  class="fas fa-angle-right"
                ></i
              ></a>
              <ol>
                <li><a href="#">신선식품</a></li>
                <li><a href="#">가공식품</a></li>
                <li><a href="#">건강식품</a></li>
                <li><a href="#">생필품</a></li>
              </ol>
            </li>
            <li>
              <a href="#"
                ><i class="fas fa-home"></i>홈·문구·취미<i
                  class="fas fa-angle-right"
                ></i
              ></a>
              <ol>
                <li><a href="#">가구/DIY</a></li>
                <li><a href="#">침구·커튼</a></li>
                <li><a href="#">생활용품</a></li>
                <li><a href="#">사무용품</a></li>
              </ol>
            </li>
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