package kr.co.Kmarket.controller.seller.product;

import java.io.File;
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

import com.oreilly.servlet.MultipartRequest;

import kr.co.Kmarket.dto.ProductDTO;
import kr.co.Kmarket.dto.seller.Cate1DTO;
import kr.co.Kmarket.dto.seller.Cate2DTO;
import kr.co.Kmarket.service.FileService;
import kr.co.Kmarket.service.ProductService;
import kr.co.Kmarket.service.seller.Cate1Service;
import kr.co.Kmarket.service.seller.Cate2Service;

@WebServlet("/seller/product/modify.do")
public class ModifyController extends HttpServlet{

	private static final long serialVersionUID = 1926866614940162382L;
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	private ProductService productService = new ProductService();
	private Cate1Service cate1Service = new Cate1Service();
	private Cate2Service cate2Service = new Cate2Service();
	private FileService fileService = new FileService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String prodNo = req.getParameter("prodNo");
		String cate1 = req.getParameter("cate1");
		String cate2 = req.getParameter("cate2");
		logger.debug("prodNo : "+prodNo);
		logger.debug("cate1 : "+cate1);
		logger.debug("cate2 : "+cate2);
		
		List<Cate1DTO> cate1s = cate1Service.selectCate1s();
		logger.debug("cates1 : "+cate1s);
		
		List<Cate2DTO> cate2s = cate2Service.selectCate2s(cate1);
		
		ProductDTO product = productService.selectProduct(prodNo);
		req.setAttribute("product", product);
		req.setAttribute("oriCate1", cate1);
		req.setAttribute("oriCate2", cate2);
		req.setAttribute("cate1s", cate1s);
		req.setAttribute("cate2s", cate2s);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/seller/product/modify.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String oriCate1 = req.getParameter("oriCate1");
		String oriCate2 = req.getParameter("oriCate2");
		logger.debug("oriCate1 : "+oriCate1);
		logger.debug("oriCate2 : "+oriCate2);
		
		// 수정 전 경로
		String fileUrl = "/thumb/"+oriCate1+"/"+oriCate2;
		logger.debug("fileUrl : "+fileUrl);
		String path = fileService.getPath(req, fileUrl);
		logger.debug("path : "+path);
		
		// 수정 전 경로에 파일 업로드
		MultipartRequest mr = fileService.uploadFile(req, path);
		
		String prodNo = mr.getParameter("prodNo");
		String prodCate1 = mr.getParameter("prodCate1");
		String prodCate2 = mr.getParameter("prodCate2");
		String prodName = mr.getParameter("prodName");
		String descript = mr.getParameter("descript");
		String company = mr.getParameter("company");
		String price = mr.getParameter("price");
		String discount = mr.getParameter("discount");
		String point = mr.getParameter("point");  
		String stock = mr.getParameter("stock");
		String delivery = mr.getParameter("delivery");
		String thumb1 = mr.getOriginalFileName("thumb1");
		String oriThumb1 = mr.getOriginalFileName("oriThumb1");
		String thumb2 = mr.getOriginalFileName("thumb2");
		String oriThumb2 = mr.getOriginalFileName("oriThumb2");
		String thumb3 = mr.getOriginalFileName("thumb3");
		String oriThumb3 = mr.getOriginalFileName("oriThumb3");
		String detail = mr.getOriginalFileName("detail");
		String oriDetail = mr.getOriginalFileName("oriDetail");
		String status = mr.getParameter("status");
		String duty = mr.getParameter("duty");
		String receipt = mr.getParameter("receipt");
		String bizType = mr.getParameter("bizType");
		String origin = mr.getParameter("origin");
		String ip = req.getRemoteAddr();

		logger.debug("prodNo : "+prodNo);
		logger.debug("prodCate1 : "+prodCate1);
		logger.debug("prodCate2 : "+prodCate2);
		logger.debug("prodName : "+prodName);
		logger.debug("descript : "+descript);
		logger.debug("company : "+company);
		logger.debug("price : "+price);
		logger.debug("discount : "+discount);
		logger.debug("point : "+point);
		logger.debug("stock : "+stock);
		logger.debug("delivery : "+delivery);
		logger.debug("thumb1 : "+thumb1);
		logger.debug("thumb2 : "+thumb2);
		logger.debug("thumb3 : "+thumb3);
		logger.debug("detail : "+detail);
		logger.debug("status : "+status);
		logger.debug("duty : "+duty);
		logger.debug("receipt : "+receipt);
		logger.debug("bizType : "+bizType);
		logger.debug("origin : "+origin);
		logger.debug("ip : "+ip);		
		
		ProductDTO image = productService.selectImages(prodNo);
		
		/*
		 * String newThumb1; String newThumb2; String newThumb3; String newDetail;
		 * 
		 * 
		 * if(thumb1 != null) { // 파일 변경을 했을 때 newThumb1 = fileService.renameToFile(req,
		 * path, thumb1); }else { // 파일 변경을 안 했을 때 newThumb1 = image.getNewThumb1(); }
		 * if(thumb2 != null) { newThumb2 = fileService.renameToFile(req, path, thumb2);
		 * }else { newThumb2 = image.getNewThumb2(); } if(thumb3 != null) { newThumb3 =
		 * fileService.renameToFile(req, path, thumb3); }else { newThumb3 =
		 * image.getNewThumb3(); } if(detail != null) { newDetail =
		 * fileService.renameToFile(req, path, detail); }else { newDetail =
		 * image.getNewDetail(); }
		 * 
		 * // 파일변경을 하지 않고 카테고리 변경만 했을 때 if(!prodCate1.equals(oriCate1) ||
		 * !prodCate2.equals(oriCate2)) { //파일 이동 // 현재 파일 경로 path
		 * 
		 * // 변경 파일 경로 String newFilePath = "/thumb/"+prodCate1+"/"+prodCate2; String
		 * newPath = fileService.getPath(req, newFilePath);
		 * 
		 * File currentFileThumb1 = new File(path+"/"+newThumb1); File newFileThumb1 =
		 * new File(newPath+"/"+newThumb1);
		 * 
		 * File currentFileThumb2 = new File(path+"/"+newThumb2); File newFileThumb2 =
		 * new File(newPath+"/"+newThumb2);
		 * 
		 * File currentFileThumb3 = new File(path+"/"+newThumb3); File newFileThumb3 =
		 * new File(newPath+"/"+newThumb3);
		 * 
		 * File currentFileDetail = new File(path+"/"+newDetail); File newFileDetail =
		 * new File(newPath+"/"+newDetail);
		 * 
		 * // 파일 업로드 폴더 변경 currentFileThumb1.renameTo(newFileThumb1);
		 * currentFileThumb2.renameTo(newFileThumb2);
		 * currentFileThumb3.renameTo(newFileThumb3);
		 * currentFileDetail.renameTo(newFileDetail); }
		 * 
		 * // 수정 전 파일 File oriThumb1 = new File(path+"/"+image.getNewThumb1()); File
		 * oriThumb2 = new File(path+"/"+image.getNewThumb2()); File oriThumb3 = new
		 * File(path+"/"+image.getNewThumb3()); File oriDetail = new
		 * File(path+"/"+image.getNewDetail());
		 * 
		 * // 파일 수정 시 디렉토리에서 수정 전 파일 삭제 if(oriThumb1.exists() || oriThumb2.exists() ||
		 * oriThumb3.exists() || oriDetail.exists()) { logger.debug("here2");
		 * if(!newThumb1.equals(image.getNewThumb1())) { oriThumb1.delete(); }else
		 * if(!newThumb2.equals(image.getNewThumb2())){ oriThumb2.delete(); }else
		 * if(!newThumb3.equals(image.getNewThumb3())) { oriThumb3.delete(); }else
		 * if(!newDetail.equals(image.getNewDetail())){ oriDetail.delete(); } }
		 */
		
		ProductDTO dto = new ProductDTO();

		dto.setProdCate1(prodCate1);
		dto.setProdCate2(prodCate2);
		dto.setProdName(prodName);
		dto.setDescript(descript);
		dto.setCompany(company);
		dto.setPrice(price);
		dto.setDiscount(discount);
		dto.setPoint(point);
		dto.setStock(stock);
		dto.setDelivery(delivery);
		dto.setThumb1(thumb1);
		/*
		 * dto.setNewThumb1(newThumb1); dto.setThumb2(thumb2);
		 * dto.setNewThumb2(newThumb2); dto.setThumb3(thumb3);
		 * dto.setNewThumb3(newThumb3); dto.setDetail(detail);
		 * dto.setNewDetail(newDetail);
		 */
		dto.setStatus(status);
		dto.setDuty(duty);
		dto.setReceipt(receipt);
		dto.setBizType(bizType);
		dto.setOrigin(origin);
		dto.setIp(ip);
		logger.debug("dto : "+dto);
		
		productService.updateProduct(dto);
	}
}
