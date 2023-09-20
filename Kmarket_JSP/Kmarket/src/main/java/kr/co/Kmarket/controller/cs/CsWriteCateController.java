package kr.co.Kmarket.controller.cs;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.Kmarket.dto.cs.CsCateDetailDTO;
import kr.co.Kmarket.service.CsArticleService;

public class CsWriteCateController extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3935443053316299876L;
	private final Logger logger = LoggerFactory.getLogger(getClass());
	private final CsCateDetailDTO dto = new CsCateDetailDTO();
	private final CsArticleService service = CsArticleService.INSTANCE;
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String type = req.getParameter("type");	
		String cateDetail = req.getParameter("cateDetail");
		
		
		service.selectCsWriteCate(cateDetail);
		
	
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
	
	
}
