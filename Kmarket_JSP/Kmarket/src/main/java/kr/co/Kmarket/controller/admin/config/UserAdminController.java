package kr.co.Kmarket.controller.admin.config;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/admin/config/userAdmin.do")
public class UserAdminController extends HttpServlet{

	private static final long serialVersionUID = -9046883985899912297L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("/admin/config/userAdmin.jsp");
		dispatcher.forward(req, resp);
	}
}
