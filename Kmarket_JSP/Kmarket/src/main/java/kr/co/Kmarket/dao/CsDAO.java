package kr.co.Kmarket.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.Kmarket.db.DBHelper;
import kr.co.Kmarket.dto.CsArticleDTO;

public class CsDAO extends DBHelper{

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	private String SQL = "";
	private String aSQL = "";
	private CsArticleDTO dto = null;
	
	//FaqStart
	public int insertFaq(CsArticleDTO dto) {
		
		int no = 0;
		
		conn = getConnection();
		SQL = "INSERT INTO `km_cs_article` SET"
				+ "`cate`=?, "
				+ "`title`=?, "
				+ "`content`=?,"
				+ "`file`=?,"
				+ "`writer`=?,"
				+ "`regip`=?,"
				+ "`rdate`=NOW()";
		
		aSQL = "SELECT MAX(`no`) FROM `Article";
		
		try {
			
			dto = new CsArticleDTO();
			stmt = conn.createStatement();
			psmt = conn.prepareStatement(SQL);
			psmt.setString(1, dto.getCate());
			psmt.setString(2, dto.getTitle());
			psmt.setString(3, dto.getContent());
			psmt.setInt(4, dto.getFile());
			psmt.setString(5, dto.getWriter());
			psmt.setString(6, dto.getRegip());
			psmt.executeUpdate();
			rs = stmt.executeQuery(aSQL);
			conn.commit(); // 작업확정
			
			if(rs.next()) {
				
				no = rs.getInt(1);
			}
			close();
			
		} catch (Exception e) {
			logger.debug(e.getMessage());
		}
		return no;
	};
	
	//FaqEnd
	
	//QnaStart
	public int insertQna(CsArticleDTO dto) {
		
		int no = 0;
		
		conn = getConnection();
		SQL = "INSERT INTO `km_cs_article` SET"
				+ "`cate`=?, "
				+ "`title`=?, "
				+ "`content`=?,"
				+ "`file`=?,"
				+ "`writer`=?,"
				+ "`regip`=?,"
				+ "`rdate`=NOW()";
		
		aSQL = "SELECT MAX(`no`) FROM `Article";
		
		try {
			
			dto = new CsArticleDTO();
			stmt = conn.createStatement();
			psmt = conn.prepareStatement(SQL);
			psmt.setString(1, dto.getCate());
			psmt.setString(2, dto.getTitle());
			psmt.setString(3, dto.getContent());
			psmt.setInt(4, dto.getFile());
			psmt.setString(5, dto.getWriter());
			psmt.setString(6, dto.getRegip());
			psmt.executeUpdate();
			rs = stmt.executeQuery(aSQL);
			conn.commit(); // 작업확정
			
			if(rs.next()) {
				
				no = rs.getInt(1);
			}
			close();
			
		} catch (Exception e) {
			logger.debug(e.getMessage());
		}
		return no;
	};
	
	//QnaEnd
	
	//NoticeStart
	public int insertNotice(CsArticleDTO dto) {
		
		int no = 0;
		
		conn = getConnection();
		SQL = "INSERT INTO `km_cs_article` SET"
				+ "`cate`=?, "
				+ "`title`=?, "
				+ "`content`=?,"
				+ "`file`=?,"
				+ "`writer`=?,"
				+ "`regip`=?,"
				+ "`rdate`=NOW()";
		
		aSQL = "SELECT MAX(`no`) FROM `Article";
		
		try {
			
			dto = new CsArticleDTO();
			stmt = conn.createStatement();
			psmt = conn.prepareStatement(SQL);
			psmt.setString(1, dto.getCate());
			psmt.setString(2, dto.getTitle());
			psmt.setString(3, dto.getContent());
			psmt.setInt(4, dto.getFile());
			psmt.setString(5, dto.getWriter());
			psmt.setString(6, dto.getRegip());
			psmt.executeUpdate();
			rs = stmt.executeQuery(aSQL);
			conn.commit(); // 작업확정
			
			if(rs.next()) {
				
				no = rs.getInt(1);
			}
			close();
			
		} catch (Exception e) {
			logger.debug(e.getMessage());
		}
		return no;
	};
	
	//NoticeEnd
}
