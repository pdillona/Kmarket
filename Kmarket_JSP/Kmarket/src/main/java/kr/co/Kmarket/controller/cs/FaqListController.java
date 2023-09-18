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

import kr.co.Kmarket.dto.CsArticleDTO;
import kr.co.Kmarket.service.CsArticleService;


@WebServlet("/cs/faq.do")
public class FaqListController extends HttpServlet{


	private static final long serialVersionUID = 4872308842394693534L;
	private Logger logger = LoggerFactory.getLogger(this.getClass()); 
	private CsArticleService service = CsArticleService.INSTANCE;
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		String group = req.getParameter("group");
		String cate  = req.getParameter("cate");
		String pg    = req.getParameter("pg");
		

		
		
		
	
		
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/cs/faq/list.jsp");
		dispatcher.forward(req, resp);	
	
	}
	
	
	
	
}
