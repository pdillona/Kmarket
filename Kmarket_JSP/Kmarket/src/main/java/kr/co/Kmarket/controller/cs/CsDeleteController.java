package kr.co.Kmarket.controller.cs;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.Kmarket.service.CsArticleService;

@WebServlet("/cs/delete.do")
public class CsDeleteController extends HttpServlet{

	private final CsArticleService service = CsArticleService.INSTANCE;
	private final Logger logger = LoggerFactory.getLogger(getClass());
	private static final long serialVersionUID = 4737195433797550951L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String aNo = req.getParameter("aNo");
		
		
		
		service.deleteArticle(aNo);
		
		
		resp.sendRedirect("/Kmarket/cs/qna.do");
	
	}
	
}
