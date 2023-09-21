package kr.co.Kmarket.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.Kmarket.dto.member.MemberDTO;
import kr.co.Kmarket.service.member.MemberService;


/*
 * 로그인 여부 체크 필터 작성
 * web.xml 필터 등록 및 해당 필터가 작동할 주소 매핑 작업
 * 
 * */

public class AutoLoginFilter implements Filter {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	private MemberService service = MemberService.getInstance();
	
	@Override
		public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
				throws IOException, ServletException {

				logger.info("");
				HttpSession session = ((HttpServletRequest)request).getSession();
				
				MemberDTO sessUser = (MemberDTO) session.getAttribute("sessUser");
				
				Cookie[] cookies  = ((HttpServletRequest)request).getCookies();
				
				if(cookies != null && sessUser == null) {
					for(Cookie cookie : cookies) {
						if(cookie.getName().equals("cid")) {
							MemberDTO dto = service.selectCookie(cookie.getValue());
							session.setAttribute("sessUser", dto);
							
							String id = cookie.getValue();
							session.setAttribute("sessid", id);
						}
					}
				}
				chain.doFilter(request, response);
				
			
		
		
		}
	
}
