package kr.co.Kmarket.controller.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.Kmarket.dao.member.TermsDAO;
import kr.co.Kmarket.dto.member.MemberDTO;
import kr.co.Kmarket.dto.member.TermsDTO;
import kr.co.Kmarket.service.member.MemberService;
import kr.co.Kmarket.service.member.TermsService;

@WebServlet("/member/signup.do")
public class SignUpController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	private TermsService service = new TermsService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String type = req.getParameter("type");
		
		req.setAttribute("type", type);
		logger.debug("type : " + type );
		
		TermsDTO dto = service.selectTerms();
		req.setAttribute("dto", dto);
		logger.debug("dto : " + dto );
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/member/signup.jsp");
		dispatcher.forward(req, resp);
	
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String type = req.getParameter("type");
        
        boolean agree1 = "on".equals(req.getParameter("agree1"));
        boolean agree2 = "on".equals(req.getParameter("agree2"));
        boolean agree3 = "on".equals(req.getParameter("agree3"));
        boolean agree4 = "on".equals(req.getParameter("agree4"));

        if (agree1 && agree2 && agree3) { // 필수 약관 동의 확인
            if (!"normal".equals(type) || agree4) { // 선택 약관 동의 확인 (seller인 경우는 선택)
                if ("normal".equals(type)) {
                    resp.sendRedirect("/Kmarket/member/register.do");
                } else if ("seller".equals(type)) {
                    resp.sendRedirect("/Kmarket/member/registerSeller.do");
                }
                return;
            }
        }

        // 필수 약관 중 하나라도 동의하지 않은 경우 또는 선택 약관을 선택하지 않은 경우
        String errorMessage = "모든 필수 약관에 동의해야 합니다.";
        resp.sendRedirect("/Kmarket/agreement.jsp?type=" + type + "&error=" + errorMessage);
	
	}
	
	
}
