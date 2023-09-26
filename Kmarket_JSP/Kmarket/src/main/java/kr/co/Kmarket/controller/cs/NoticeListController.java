
package kr.co.Kmarket.controller.cs;

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

import kr.co.Kmarket.service.CsArticleService;


@WebServlet("/cs/notice.do")
public class NoticeListController extends HttpServlet {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	//private CsService service = CsService.instace;
	private static final long serialVersionUID = 4872308842394693534L;
	private CsArticleService service = CsArticleService.INSTANCE;
	

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String group = req.getParameter("group");
		String cate = req.getParameter("cate");
		String pg = req.getParameter("pg");

		// 현재 페이지 번호 int currentPage = service.getCurrentPage(pg);

		// 전체 게시물 갯수 int total = service.selectCountTotal(cate);

		// 마지막 페이지 번호 int lastPageNum = service.getLastPageNum(total);

		// 페이지 그룹 start, end 번호 int[] result =
		// service.getPageGroupNum(currentPage,lastPageNum);

		// 페이지 시작번호 int pageStartNum = service.getPageStartNum(total, currentPage);

		// 시작 인덱스 int start = service.getStartNum(currentPage);

		// 현재 페이지 게시물 조회 List<CsArticleDTO> articles =
		// service.selectArticles(cate,start);
		
		

		req.setAttribute("group", group);
		req.setAttribute("cate", cate);
		// req.setAttribute("articles", articles);
		// req.setAttribute("currentPage",currentPage);
		// //req.setAttribute("lastPageNum", lastPageNum);
		// req.setAttribute("pageGroupStart", result[0]);
		// req.setAttribute("pageGroupEnd", result[1]);
		// req.setAttribute("pageStartNum", pageStartNum+1);

		RequestDispatcher dispatcher = req.getRequestDispatcher("/cs/notice/list.jsp");
		dispatcher.forward(req, resp);

	}

}
