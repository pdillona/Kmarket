package kr.co.Kmarket.controller.cs;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.oreilly.servlet.MultipartRequest;

import kr.co.Kmarket.dto.FileDTO;
import kr.co.Kmarket.dto.cs.CsArticleDTO;
import kr.co.Kmarket.dto.cs.CsCateDetailDTO;
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
		String type = req.getParameter("type");
		String cateDetail = req.getParameter("cateDetail");
		
		
		aService.selectCsWriteCate(cateDetail);
		
		req.setAttribute("group", group);
		req.setAttribute("type", type);
		req.setAttribute("cateDetail", cateDetail);
		
		
		
		
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
		String cateDetail   = mr.getParameter("cateDetail");
		String type   = mr.getParameter("type");
		String title   = mr.getParameter("title");
		String content = mr.getParameter("content");
		String writer  = mr.getParameter("writer");
		String uLevel  = mr.getParameter("uLevel");
		String oriName   = mr.getOriginalFileName("file");
		String regip   = req.getRemoteAddr();
		
		logger.debug("title : " + title);
		logger.debug("content : " + content);
		logger.debug("writer : " + writer);
		logger.debug("oName : " + oriName);
		logger.debug("regip : " + regip);
				
		//DTO생성
		CsArticleDTO dto = new CsArticleDTO();
		dto.setCateDetail(cateDetail);
		dto.setType(type);
		dto.setGroup(group);
		dto.setTitle(title);
		dto.setContent(content);
		dto.setFile(oriName);
		dto.setWriter(writer);
		dto.setRegip(regip);
		dto.setuLevel(Integer.parseInt(uLevel));

		//글 Insert
		int no = aService.insertArticle(dto);
		
		//파일명 수정 및 파일 Insert
		if(oriName != null) {
			
			String sName = aService.renameToFile(req, path, oriName);
			
			// 파일 Insert
			FileDTO fileDto = new FileDTO();
			fileDto.setAno(no);
			fileDto.setOriname(oriName);
			fileDto.setNewname(sName);
			
			fService.insertFile(fileDto);
			
			
		}
		

		
		// 리다이렉트
		resp.sendRedirect("/Kmarket/cs/qna/list.do?group="+group+"&cateDetail=all");
	}
}
