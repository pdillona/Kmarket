package kr.co.Kmarket.controller.cs;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.oreilly.servlet.MultipartRequest;

import kr.co.Kmarket.dto.CsArticleDTO;
import kr.co.Kmarket.dto.FileDTO;
import kr.co.Kmarket.service.CsArticleService;
import kr.co.Kmarket.service.FileService;


@WebServlet("/cs/write.do")
public class CsWriteController extends HttpServlet{
	
	private static final long serialVersionUID = 1950905414750457227L;
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	private CsArticleService aService = CsArticleService.INSTANCE;
	private FileService fService = new FileService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		String group = req.getParameter("group");
		String cate = req.getParameter("cate");
		String cateDtail = req.getParameter("cateDtail");
		String writer = req.getParameter("writer");
		
		
		
		req.setAttribute("group", group);
		req.setAttribute("cate", cate);
		req.setAttribute("cateDetail", cateDtail);
		req.setAttribute("writer", writer);
		
		
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/cs/qna/write.jsp");
		dispatcher.forward(req, resp);	
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 파일 업로드
		String path = aService.getPath(req, "/upload");
		MultipartRequest mr = aService.uploadFile(req, path);
		
		// 폼 데이터 수신
		String group   = mr.getParameter("group");
		String cate   = mr.getParameter("cate");
		String cateDtail   = mr.getParameter("cateDtail");
		String title   = mr.getParameter("title");
		String content = mr.getParameter("content");
		String writer  = mr.getParameter("writer");
		String oriName   = mr.getOriginalFileName("file");
		String regip   = req.getRemoteAddr();
		
		logger.debug("title : " + title);
		logger.debug("content : " + content);
		logger.debug("writer : " + writer);
		logger.debug("oName : " + oriName);
		logger.debug("regip : " + regip);
				



		
		// 리다이렉트
		resp.sendRedirect("/Kmarket/cs/qna/list.do?group="+group+"&cate="+cate+"&cateDetail="+cateDtail);
	}
}
