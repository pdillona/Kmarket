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
	
	private static CsDAO instance = new CsDAO();
	public static CsDAO getInstance() {
		return instance;
	}
	
	//FaqStart
	public int insertFaq(CsArticleDTO dto) {
		
		int no = 0;
		
		conn = getConnection();
		SQL = "INSERT INTO `km_cs_article` SET"
				+ "`cate`=?,"
				+ "`cateDetail`= ?, "
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
			psmt.setString(2, dto.getCatedetail());
			psmt.setString(3, dto.getTitle());
			psmt.setString(4, dto.getContent());
			psmt.setInt(5, dto.getFile());
			psmt.setString(6, dto.getWriter());
			psmt.setString(7, dto.getRegip());
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
	
	
	
	public int selectCountTotal(String cate) {
		return dao.selectCountTotal(cate);
	}
	
	//FaqEnd
	
	//QnaStart
	public int insertQna(CsArticleDTO dto) {
		
		int no = 0;
		
		conn = getConnection();
		SQL = "INSERT INTO `km_cs_article` SET"
				+ "`cate`=?,"
				+ "`cateDetail`= ?, "
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
			psmt.setString(2, dto.getCatedetail());
			psmt.setString(3, dto.getTitle());
			psmt.setString(4, dto.getContent());
			psmt.setInt(5, dto.getFile());
			psmt.setString(6, dto.getWriter());
			psmt.setString(7, dto.getRegip());
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
				+ "`cate`=?,"
				+ "`cateDetail`= ?, "
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
			psmt.setString(2, dto.getCatedetail());
			psmt.setString(3, dto.getTitle());
			psmt.setString(4, dto.getContent());
			psmt.setInt(5, dto.getFile());
			psmt.setString(6, dto.getWriter());
			psmt.setString(7, dto.getRegip());
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
