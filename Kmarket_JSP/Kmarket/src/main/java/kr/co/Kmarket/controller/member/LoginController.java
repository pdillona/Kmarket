package kr.co.Kmarket.controller.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.Kmarket.dto.member.MemberDTO;
import kr.co.Kmarket.service.member.MemberService;

@WebServlet("/member/login.do")
public class LoginController extends HttpServlet{

	private static final long serialVersionUID = 1L;

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	private MemberService service = MemberService.getInstance();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String success = req.getParameter("success");
		logger.debug("success : " + success);
		
		req.setAttribute("success", success);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/member/login.jsp");
		dispatcher.forward(req, resp);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String uid = req.getParameter("uid");
		String pass = req.getParameter("pass");
		logger.debug("uid : " + uid);
		logger.debug("pass : " + pass);
		
		MemberDTO dto = service.selectMember(uid, pass);
		
	
		if (dto != null) {
			//현재 클라이언트 세션 구하기
			HttpSession session = req.getSession();
            //로그인 성공 시 세션에 사용자 정보를 저장
            session.setAttribute("sessUser", dto);
            
            //자동 로그인 쿠키 설정
            Cookie autoLoginCookie = new Cookie("autoLogin", "true");
            autoLoginCookie.setMaxAge(30 * 24 * 60 * 60); // 30일간 유효
            resp.addCookie(autoLoginCookie);

            
            //로그인 성공 후 메인 페이지로 리다이렉트
            resp.sendRedirect("/Kmarket/index.do");
        } else {
            //로그인 실패 시 
            resp.sendRedirect("/Kmarket/member/login.do?success=100");
        }
		
	
		
	}
	
	
}
