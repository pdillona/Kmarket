package kr.co.Kmarket.controller.seller.product;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.Kmarket.dto.ProductDTO;
import kr.co.Kmarket.service.ProductService;

@WebServlet("/seller/product/modify.do")
public class ModifyController extends HttpServlet{

	private static final long serialVersionUID = 1926866614940162382L;
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	private ProductService productService = new ProductService();
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String prodNo = req.getParameter("prodNo");
		logger.debug("prodNo : "+prodNo);
		
		ProductDTO product = productService.selectProduct(prodNo);
		req.setAttribute("product", product);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/seller/product/modify.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
}
