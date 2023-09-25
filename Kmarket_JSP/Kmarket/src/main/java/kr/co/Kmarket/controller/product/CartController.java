package kr.co.Kmarket.controller.product;

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

import kr.co.Kmarket.dto.ProductCartDTO;
import kr.co.Kmarket.dto.ProductDTO;
import kr.co.Kmarket.dto.seller.Cate2DTO;
import kr.co.Kmarket.service.ProductService;
import kr.co.Kmarket.service.seller.Cate2Service;


/* 
	날짜 : 2023/09/14
	이름 : 김무현
	내용 : Controller 기본셋팅
*/
@WebServlet("/product/cart.do")
public class CartController extends HttpServlet{
	private static final long serialVersionUID = 1856428557393136872L;
	
	private Cate2Service Ct2Service = new Cate2Service();
	
	private ProductService pService = new ProductService();
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/product/cart.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	
	String prodCate1 = req.getParameter("prodCate1");
	String prodCate2 = req.getParameter("prodCate2");	
	String thumb1 = req.getParameter("thumb1");
	
	String cate1= req.getParameter("cate1");
	String cate2= req.getParameter("cate2");
	String prodNo= req.getParameter("prodNo");
	String uid =req.getParameter("uid");
	String pName = req.getParameter("pName");
	String pDescript = req.getParameter("pDescript");
	String price = req.getParameter("price");
	String discount = req.getParameter("discount");
	String point = req.getParameter("point");
	String delivery = req.getParameter("delivery");
	String total = req.getParameter("total");
	String finalPrice = req.getParameter("final");
	String count = req.getParameter("count2");
	
	
	logger.debug("thumb1 : " + thumb1);
	logger.debug("pName : " + pName);
	logger.debug("pDescript : " + pDescript);
	logger.debug("price : " + price);
	logger.debug("discount : " + discount);
	logger.debug("point : " + point);
	logger.debug("delivery : " + delivery);
	logger.debug("total : " + total);
	logger.debug("finalPrice : " + finalPrice);
	logger.debug("count : " + count);
	
	ProductCartDTO dto = new ProductCartDTO();
	dto.setUid(uid);
	dto.setProdNo(prodNo);
	dto.setCount(count);
	dto.setPrice(price);
	dto.setDiscount(discount);
	dto.setPoint(point);
	dto.setDelivery(delivery);
	dto.setFinalPrice(finalPrice);
	
	logger.debug(dto.toString());
	
	pService.insertProductCart(dto);
	
	
	
	//aside 카테고리
	
	List<List<Cate2DTO>> categories = Ct2Service.selectCategories();
						
	List<ProductDTO> productsaside = pService.selectProductBest();
		
	
	
	req.setAttribute("thumb1",thumb1);
	req.setAttribute("pName",pName);
	req.setAttribute("pDescript",pDescript);
	req.setAttribute("price",price);
	req.setAttribute("discount",discount);
	req.setAttribute("point",point);
	req.setAttribute("delivery",delivery);
	req.setAttribute("count",count);
	req.setAttribute("total",total);
	req.setAttribute("finalPrice",finalPrice);
	req.setAttribute("cate1", cate1);
	req.setAttribute("cate2", cate2);
	
	req.setAttribute("prodCate1", prodCate1);
	req.setAttribute("prodCate2", prodCate2);
	req.setAttribute("categories", categories);
	req.setAttribute("productsaside", productsaside);
	

	logger.debug("prodCate1 : " + prodCate1);
	logger.debug("prodCate2 : " + prodCate2);
	
	
	
	

	RequestDispatcher dispatcher = req.getRequestDispatcher("/product/cart.jsp");
	dispatcher.forward(req, resp);
	
	}

}
