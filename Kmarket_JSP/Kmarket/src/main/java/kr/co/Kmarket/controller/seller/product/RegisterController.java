package kr.co.Kmarket.controller.seller.product;

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
import kr.co.Kmarket.service.seller.Cate1Service;

@WebServlet("/seller/product/register.do")
public class RegisterController extends HttpServlet{

	private static final long serialVersionUID = -946511949129250047L;
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	private Cate1Service cateService = new Cate1Service();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		List<Cate1DTO> cate1s = cateService.selectCate1s();

		req.setAttribute("cate1s", cate1s);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/seller/product/register.jsp");
		dispatcher.forward(req, resp);
	}
}
