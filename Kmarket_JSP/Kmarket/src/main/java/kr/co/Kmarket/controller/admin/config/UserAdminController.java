package kr.co.Kmarket.controller.admin.config;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.Kmarket.dto.SearchDTO;
import kr.co.Kmarket.dto.member.MemberDTO;
import kr.co.Kmarket.service.PageService;
import kr.co.Kmarket.service.member.MemberService;

@WebServlet("/admin/config/userAdmin.do")
public class UserAdminController extends HttpServlet{

	private static final long serialVersionUID = -9046883985899912297L;
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	private MemberService memberService = MemberService.getInstance();
	private PageService pageService = new PageService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String type = req.getParameter("type");
		String pg = req.getParameter("pg");
		String search = req.getParameter("search");
		String search_text = req.getParameter("search_text");

		logger.debug("type : "+type);
		logger.debug("pg : "+pg);
		logger.debug("search : "+search);
		logger.debug("search_text : "+search_text);
		
		SearchDTO searchDTO = new SearchDTO();
		searchDTO.setSearch(search);
		searchDTO.setSearch_text(search_text);
		searchDTO.setType(type);
		
		// 현재 페이지 계산
		int currentPage = pageService.getCurrentPage(pg);
		
		// Limit 시작값 계산
		int start = pageService.getStartNum(currentPage);
		
		// 전체 게시물 개수 조회
		int total = memberService.selectCountTotal(searchDTO);
		logger.debug("total : "+total);
		
		// 마지막 페이지 번호 계산
		int lastPageNum = pageService.getLastPageNum(total);
		
		// 페이지 그룹 계산
		int[] result = pageService.getPageGroupNum(currentPage, lastPageNum);
		
		// 페이지 시작번호 계산
		int pageStartNum = pageService.getPageStartNum(total, currentPage);
		
		List<MemberDTO> admins = memberService.selectMembers(start, searchDTO);
		
		req.setAttribute("admins", admins);
		req.setAttribute("currentPage", currentPage);
		req.setAttribute("lastPageNum", lastPageNum);
		req.setAttribute("pageGroupStart", result[0]);
		req.setAttribute("pageGroupEnd", result[1]);
		req.setAttribute("pageStartNum", pageStartNum+1);
		req.setAttribute("search", search);
		req.setAttribute("search_text", search_text);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/admin/config/userAdmin.jsp");
		dispatcher.forward(req, resp);
	}
}
