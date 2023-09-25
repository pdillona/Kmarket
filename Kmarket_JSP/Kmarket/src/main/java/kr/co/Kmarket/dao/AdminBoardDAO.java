package kr.co.Kmarket.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.Kmarket.db.DBHelper;
import kr.co.Kmarket.dto.cs.CsArticleDTO;

public class AdminBoardDAO extends DBHelper{

	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	private String SQL = "";
	
	public CsArticleDTO selectQna(String group,String cateDetail,String type) {
		
		SQL = "";
		
		conn = getConnection();
		
		try {
			
			psmt = conn.prepareStatement(SQL);
			psmt.setString(1, group);
			psmt.setString(2, cateDetail);
			psmt.setString(3, type);
			
			
			
			
		} catch (Exception e) {
			logger.debug(e.getMessage());
		}
		
		
		return null;
		
	}
	
	
	
	
	
}
