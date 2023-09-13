package kr.co.Kmarket.controller.seller.product;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/seller/product/list.do")
public class ListController extends HttpServlet{

	private static final long serialVersionUID = 7128712396351806024L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("/seller/product/list.jsp");
		dispatcher.forward(req, resp);
	}
}
