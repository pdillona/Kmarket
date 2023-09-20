<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<!-- 
		날짜 : 2023/09/14
		이름 : 김무현
		내용 : include 작업
	 -->
<aside>
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
  </aside>
  
  