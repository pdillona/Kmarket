package kr.co.Kmarket.controller.admin.board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/admin/board/notice.do")
public class NoticeController extends HttpServlet{

	private static final long serialVersionUID = -8861991199426941590L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("/admin/board/notice.jsp");
		dispatcher.forward(req, resp);
	}
}
