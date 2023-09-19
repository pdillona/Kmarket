<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../_header.jsp" %>
	
      <section id="cs">
        <div class="qna">
          <nav>
            <div>
              <p>홈<span>></span>문의하기</p>
            </div>
          </nav>
          <section class="list">
     	<%@include file="../_aside.jsp" %>
            <article>
              <nav>
                <h1>${cateDetail}</h1>
                <h2>${cateDetail} 관련 문의 내용입니다.</h2>
              </nav>
              <c:choose>
              	  <c:when test="${not empty articles }">
		              <table>
		              	<tr>
		              		<td>제목</td>
		              		<td>글쓴이</td>
		              		<td>작성일</td>
		              	</tr>
		              	<c:forEach var="article" items="${articles}">
		                <tr>
		                  <td><a href="./view.html">[ ${article.dName}  ] ${article.title}  </a></td>
		                  <td>${article.writer}</td>
		                  <td>${article.rdate}</td>
		                </tr>
		               	</c:forEach> 
		              </table>
	              </c:when>
	              <c:when test="${empty articles }">
	              	  <table>
		                <tr>
		                  <td><a href="./view.html"> 게시글이 존재하지 않습니다.  </a></td>
		                  <td> </td>
		                  <td> </td>
		                </tr>
		              </table>
	              </c:when>
			 </c:choose>
		    <!-- 페이지 네비게이션 -->
		        <div class="page">
		        	<c:if test="${pageGroupStart > 1}">
		            	<a href="${ctxPath}/cs/qna.do?group=qna&cateDetail=${cateDetail}&type=20&pg=${pageGroupStart - 1}" class="prev">이전</a>
		            </c:if>
		            <c:forEach var="i" begin="${pageGroupStart}" end="${pageGroupEnd}">
		            	<a href="${ctxPath}/cs/qna.do?group=qna&cateDetail=${cateDetail}&type=20&pg=${i}&" class="num ${currentPage == i?'current':'off'}">${i}</a>
		            </c:forEach>
		            <c:if test="${pageGroupEnd < lastPageNum}">
		            	<a href="${ctxPath}/cs/qna.do?group=qna&cateDetail=${cateDetail}&type=20&pg=${pageGroupEnd + 1}" class="next">다음</a>
		            </c:if>
		        </div>

              <a href="${ctxPath}/cs/write.do?group=qna&type=${type}&cateDetail=${cateDetail}"  class="btnWrite">문의하기</a>
              <!-- uLevel  regip writer  도 나중에 넘겨야함-->
            </article>
          </section>
        </div>
      </section>

      <footer>
        <ul>
          <li><a href="#">회사소개</a></li>
          <li><a href="#">서비스이용약관</a></li>
          <li><a href="#">개인정보처리방침</a></li>
          <li><a href="#">전자금융거래약관</a></li>
        </ul>
        <div>
          <p><img src="./images/footer_logo.png" alt="로고" /></p>
          <p>
            <strong>(주)KMARKET</strong><br />
            부산시 강남구 테헤란로 152 (역삼동 강남파이낸스센터)<br />
            대표이사 : 홍길동<br />
            사업자등록번호 : 220-81-83676 사업자정보확인<br />
            통신판매업신고 : 강남 10630호 Fax : 02-589-8842
          </p>
          <p>
            <strong>고객센터</strong><br />
            Tel : 1234-5678 (평일 09:00~18:00)<br />
            스마일클럽/SVIP 전용 : 1522-5700 (365일 09:00~18:00)<br />
            경기도 부천시 원미구 부일로 223(상동) 투나빌딩 6층<br />
            Fax : 051-123-4567 | Mail : kmarket@kmarket.co.kr<br />
          </p>
        </div>
      </footer>
    </div>
  </body>
</html>
