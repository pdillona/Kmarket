<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../_header.jsp"%>
<%@ include file="../_aside.jsp"%>
<section id="admin-board-notice">
	<nav>
		<h3>고객문의</h3>
		<p>
			HOME > 게시판관리 > <strong>고객문의</strong>
		</p>
	</nav>
	<!-- 공지사항 컨텐츠 시작 -->
	<article>
		<nav>
			<h2 class="title">${dto.title}</h2>
			<p>
				<span>${dto.writer}</span> <span>${dto.rdate}</span> <br> <br>
				<br> <br> <a href="${ctxPath}/cs/delete.do?aNo=${dto.aNo}"
					class="btnWrite">글 삭제</a>
				<!-- 버튼사이즈 줄이기 -->
			</p>
		</nav>

		<div class="content">
			<p>
				${dto.content}<br> <br> <br>
			</p>
			<p>
				※ 피싱 관련 피해신고<br /> <br /> ▶ 경찰청 사이버수사국 (국번없이)182 :
				http://cyberbureau.police.go.kr<br /> ▶ KISA 인터넷침해대응센터 (국번없이)118 :
				http://www.krcert.or.kr<br /> 감사합니다.<br />
			</p>
			<br> <br> <br> <br>1px solid #e9e9e9
			<nav>
				<c:if test="${dto.file > 0}">
					<tr>
						<td>첨부파일</td>
						<td><a href="#">${dto.file}</a>&nbsp; <span>${article.fileDto.download}</span>회
							다운로드</td>
					</tr>
				</c:if>
			</nav>
		</div>
		<nav>
			<input type="text">

		</nav>

		<%-- 		<nav>
					<p>
						<span>${dto.writer}</span> <span>${dto.rdate}</span> <br> <br>
						<a href="${ctxPath}/cs/delete.do?aNo=${dto.aNo}" class="btnWrite">글 삭제</a>
						<!-- 버튼사이즈 줄이기 -->
						<br> <br> ${dto.content}
						<br> 
					</p>
				</nav> --%>
		<a href="./list.html" class="btnList">목록보기</a>
	</article>




	<!-- 공지사항 컨텐츠 끝 -->
</section>
</main>
<%@ include file="../_footer.jsp"%>
