package kr.co.Kmarket.controller.member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.JsonObject;


@WebServlet("/user/checkEmail.do")
public class CheckBizRegNumController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String email = req.getParameter("email");
		logger.debug("email : " + email );
		
		
		
		JsonObject json = new JsonObject();
		
		PrintWriter writer = resp.getWriter();
		writer.print(json.toString());
		
	}
}
