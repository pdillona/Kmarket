package kr.co.Kmarket.controller.admin.board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/admin/board/faq.do")
public class FaqController extends HttpServlet{

	private static final long serialVersionUID = -2704444965502018380L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("/admin/board/faq.jsp");
		dispatcher.forward(req, resp);
	}
}
