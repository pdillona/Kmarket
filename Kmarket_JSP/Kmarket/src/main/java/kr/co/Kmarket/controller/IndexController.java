package kr.co.Kmarket.controller;

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

import kr.co.Kmarket.dto.seller.Cate1DTO;
import kr.co.Kmarket.dto.seller.Cate2DTO;
import kr.co.Kmarket.service.seller.Cate1Service;
import kr.co.Kmarket.service.seller.Cate2Service;

/* 
	날짜 : 2023/09/15
	이름 : 김무현
	내용 : 카테고리 출력
*/

@WebServlet(value= {"","/index.do"})  // 체크 로그인 필터 임시로 막아놓음(web.xml)
public class IndexController extends HttpServlet{

	
	private static final long serialVersionUID = -8413698060204945933L;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	private Cate1Service Ct1Service = new Cate1Service();
	private Cate2Service Ct2Service = new Cate2Service();
	

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		List<Cate1DTO> cate1gory1 = Ct1Service.selectCate1sInt(1);
		List<Cate1DTO> cate1gory2 = Ct1Service.selectCate1sInt(2);
		
		logger.debug("cate1gory1 :" + cate1gory1);
		logger.debug("cate1gory2 :" + cate1gory2);
		
		List<Cate2DTO> cate2gory1 = Ct2Service.selectCate2sint(1);
		List<Cate2DTO> cate2gory2 = Ct2Service.selectCate2sint(2);
		
		logger.debug("cate2gory1 :" + cate2gory1);
		logger.debug("cate2gory2 :" + cate2gory2);
		
		
		req.setAttribute("cate1gory1", cate1gory1);
		req.setAttribute("cate1gory2", cate1gory2);
		
		req.setAttribute("cate2gory1", cate2gory1);
		req.setAttribute("cate2gory2", cate2gory2);
		
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/index.jsp");
		dispatcher.forward(req, resp);	
	}
}
