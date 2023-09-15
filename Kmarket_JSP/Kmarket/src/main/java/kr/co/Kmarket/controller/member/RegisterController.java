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

import kr.co.Kmarket.dto.member.MemberDTO;
import kr.co.Kmarket.service.member.MemberService;

@WebServlet("/member/register.do")
public class RegisterController extends HttpServlet{

	private static final long serialVersionUID = 1L;

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	private MemberService service = MemberService.getInstance();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		RequestDispatcher dispatcher = req.getRequestDispatcher("/member/register.jsp");
		dispatcher.forward(req, resp);
	
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String uid = req.getParameter("uid");
		String pass1 = req.getParameter("pass1");
		String name = req.getParameter("name");
		String gender = req.getParameter("gender");
		String email = req.getParameter("email");
		String hp = req.getParameter("hp");
		String zip = req.getParameter("zip");
		String addr1 = req.getParameter("addr1");
		String addr2 = req.getParameter("addr2");
		String regip = req.getRemoteAddr();
		
		MemberDTO dto = new MemberDTO();
		dto.setUid(uid);
		dto.setPass(pass1);
		dto.setName(name);
		dto.setGender(gender);
		dto.setEmail(email);
		dto.setHp(hp);
		dto.setZip(zip);
		dto.setAddr1(addr1);
		dto.setAddr2(addr2);
		dto.setRegip(regip);
		
		service.insertMember(dto);
		
		resp.sendRedirect("/Kmarket/member/login.do");
	
	}
	
	
}
