package kr.co.Kmarket.controller.product;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* 
	날짜 : 2023/09/14
	이름 : 김무현
	내용 : Controller 기본셋팅
*/
@WebServlet("/product/order.do")
public class OrderController extends HttpServlet{
	private static final long serialVersionUID = 563678025604427289L;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("/product/order.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String thumb1 = req.getParameter("thumb1");
		String pName = req.getParameter("pName");
		String pDescript = req.getParameter("pDescript");
		String price = req.getParameter("price");
		String discount = req.getParameter("discount");
		String point = req.getParameter("point");
		String delivery = req.getParameter("delivery");
		String total = req.getParameter("total");
		String finalprice = req.getParameter("final");
		String count2 = req.getParameter("count2");
		
		logger.debug("thumb1 : " + thumb1);
		logger.debug("pName : " + pName);
		logger.debug("pDescript : " + pDescript);
		logger.debug("price : " + price);
		logger.debug("discount : " + discount);
		logger.debug("point : " + point);
		logger.debug("delivery : " + delivery);
		logger.debug("total : " + total);
		logger.debug("finalprice : " + finalprice);
		logger.debug("count2 : " + count2);
		
		}

}
