package kr.co.Kmarket.controller.seller.product;
/*
 * 날짜 : 2023-09-14
 * 이름 : 최정민 
 * 내용 : 상품등록 화면구현 및 상품등록 controller
 */

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

import com.oreilly.servlet.MultipartRequest;

import kr.co.Kmarket.dto.seller.Cate1DTO;
import kr.co.Kmarket.service.FileService;
import kr.co.Kmarket.service.seller.Cate1Service;

@WebServlet("/seller/product/register.do")
public class RegisterController extends HttpServlet{

	private static final long serialVersionUID = -946511949129250047L;
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	private Cate1Service cateService = new Cate1Service();
	private FileService fileService = new FileService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		List<Cate1DTO> cate1s = cateService.selectCate1s();
		logger.debug("cates1 : "+cate1s);
		req.setAttribute("cate1s", cate1s);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/seller/product/register.jsp");
		dispatcher.forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = fileService.getPath(req, "/thumb");
		
		MultipartRequest mr = fileService.uploadFile(req, path);
		
		String seller = mr.getParameter("seller");
		String prodCate1 = mr.getParameter("prodCate1");
		String prodCate2 = mr.getParameter("prodCate2");
		String prodName = mr.getParameter("prodName");
		String descript = mr.getParameter("descript");
		String company = mr.getParameter("company");
		String price = mr.getParameter("price");
		String discount = mr.getParameter("discount");
		String point = mr.getParameter("point");  
		String stock = mr.getParameter("stock");
		String delivery = mr.getParameter("delivery");
		String thumb1 = mr.getParameter("thumb1");
		String thumb2 = mr.getParameter("thumb2");
		String thumb3 = mr.getParameter("thumb3");
		String detail = mr.getParameter("detail");
		String status = mr.getParameter("status");
		String duty = mr.getParameter("duty");
		String receipt = mr.getParameter("receipt");
		String bizType = mr.getParameter("bizType");
		String origin = mr.getParameter("origin");
		String ip = req.getRemoteAddr();
		
		logger.debug("seller : "+seller);
		logger.debug("prodCate1 : "+prodCate1);
		logger.debug("prodCate2 : "+prodCate2);
		logger.debug("prodName : "+prodName);
		logger.debug("descript : "+descript);
		logger.debug("company : "+company);
		logger.debug("price : "+price);
		logger.debug("discount : "+discount);
		logger.debug("point : "+point);
		logger.debug("stock : "+stock);
		logger.debug("delivery : "+delivery);
		logger.debug("thumb1 : "+thumb1);
		logger.debug("thumb2 : "+thumb2);
		logger.debug("thumb3 : "+thumb3);
		logger.debug("detail : "+detail);
		logger.debug("status : "+status);
		logger.debug("duty : "+duty);
		logger.debug("receipt : "+receipt);
		logger.debug("bizType : "+bizType);
		logger.debug("origin : "+origin);
		logger.debug("ip : "+ip);
		
		
		
	}
}
