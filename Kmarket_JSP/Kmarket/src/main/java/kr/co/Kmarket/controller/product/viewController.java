package kr.co.Kmarket.controller.product;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.Kmarket.dto.ProductDTO;
import kr.co.Kmarket.dto.seller.Cate2DTO;
import kr.co.Kmarket.service.ProductService;
import kr.co.Kmarket.service.seller.Cate2Service;

/* 
	날짜 : 2023/09/14
	이름 : 김무현
	내용 : Controller 기본셋팅
*/
@WebServlet("/product/view.do")
public class viewController extends HttpServlet{
	private static final long serialVersionUID = -8127962812518063520L;
	
	private Cate2Service Ct2Service = new Cate2Service();
	
	private ProductService pService = new ProductService();
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String prodNo= req.getParameter("prodNo");
		String prodCate1 = req.getParameter("prodCate1");
		String prodCate2 = req.getParameter("prodCate2");
		logger.debug("prodCate1 : " + prodCate1);
		logger.debug("prodCate2 : " + prodCate2);
		logger.debug("prodNo : " + prodNo);
		
		ProductDTO product = pService.selectProduct(prodNo);
		
		logger.debug(product.toString());
		
		
		//aside 카테고리
		
		List<List<Cate2DTO>> categories = Ct2Service.selectCategories();
				
		List<ProductDTO> productsaside = pService.selectProductBest();
		
		req.setAttribute("prodCate1", prodCate1);
		req.setAttribute("prodCate2", prodCate2);
		req.setAttribute("categories", categories);
		req.setAttribute("productsaside", productsaside);
		req.setAttribute("product", product);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/product/view.jsp");
		dispatcher.forward(req, resp);
	}

}
