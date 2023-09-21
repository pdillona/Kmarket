package kr.co.Kmarket.controller.admin.store;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/admin/store/userSeller.do")
public class UserSeller extends HttpServlet{

	private static final long serialVersionUID = -8628424801201806093L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("/admin/store/userSeller.jsp");
		dispatcher.forward(req, resp);
	}
}
