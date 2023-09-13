package kr.co.Kmarket.controller.seller.order;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/seller/order/order.do")
public class OrderController extends HttpServlet{

	private static final long serialVersionUID = 340526309103367617L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("/seller/order/order.jsp");
		dispatcher.forward(req, resp);
	}
}
