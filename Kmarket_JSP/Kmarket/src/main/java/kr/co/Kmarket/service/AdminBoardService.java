package kr.co.Kmarket.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.Kmarket.dao.AdminBoardDAO;
import kr.co.Kmarket.dto.cs.CsArticleDTO;

public class AdminBoardService {

	private final Logger logger = LoggerFactory.getLogger(getClass());
	private final AdminBoardDAO dao = new AdminBoardDAO();
	
	
	
	public CsArticleDTO selectQna(String group,String cateDetail,String type) {
		
	
		dao.selectQna(group,cateDetail,type);
		
		
		return null;
	}
	
	
}
