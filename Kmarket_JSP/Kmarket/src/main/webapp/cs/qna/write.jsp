<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../_header.jsp" %>
      <section id="cs">
        <div class="qna">
          <nav>
            <div>
              <p>홈<span>></span>문의하기</p>
            </div>
          </nav>
          <section class="write">
            <aside>
              <h2>문의하기</h2>
              <ul>
                <li class="on"><a href="#">회원</a></li>
                <li><a href="#">쿠폰/이벤트</a></li>
                <li><a href="#">주문/결제</a></li>
                <li><a href="#">배송</a></li>
                <li><a href="#">취소/반품/교환</a></li>
                <li><a href="#">여행/숙박/항공</a></li>
                <li><a href="#">안전거래</a></li>
              </ul>
            </aside>
            <article>
              <form action="${ctxPath}/cs/write.do"  method="post" enctype="multipart/form-data">
                  <%-- <input type="hidden" name="writer" value="${sessUser.uid}"/> --%>
                  <input type="hidden" name="writer" value="wpdjvks"/>
				  <input type="hidden" name="group" value="${group}"/>
			      <input type="hidden" name="cate" value="${cate}"/>
			      <input type="hidden" name="cate" value="${cateDtail}"/>
                <table>
                  <tr>
                    <td>문의유형</td>
                    <td>
                      <select name="type">
                        <option value="0">선택</option>
                        <option>가입</option>
                        <option>탈퇴</option>
                        <option>회원정보</option>
                        <option>로그인</option>
                      </select>
                    </td>
                  </tr>
                  <tr>
                    <td>문의제목</td>                  
                    <td>
                      <input type="text" name="title" placeholder="제목을 입력하세요."/>
                    </td>
                  </tr>                
                  <tr>
                    <td>문의내용</td>                  
                    <td>
                      <textarea name="content" placeholder="내용을 입력하세요."></textarea>
                    </td>
                  </tr>
                </table>
                <div>
                  <a href="${ctxPath}/cs/qna.do?cate=qna&cateDeatil=member" class="btnList">취소하기</a>
<%--                   <a href="${ctxPath}/cs/list.do?cate=qna&cateDeatil=member" class="btnList">취소하기</a> --%>
                  <input type="submit" class="btnSubmit" value="등록하기"/>
                </div>
              </form>
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
          <p><img src="../images/footer_logo.png" alt="로고" /></p>
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
