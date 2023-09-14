package kr.co.Kmarket.dao;

import java.util.ArrayList;
import java.util.List;

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
	
	
	//CommonStart(공통)
	
	
	public int selectCountTotal(String cate) {
		
		int total = 0;
		
		SQL = "SELECT COUNT(*) FROM `Article` WHERE `parent`=0 AND `cate`=?"; 
		
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(SQL);
			psmt.setString(1, cate);
			rs = psmt.executeQuery();
			if(rs.next()) {
				total = rs.getInt(1);
			}
			close();			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return total;
	}
	
	
	
	public List<CsArticleDTO> selectArticles(String cate, int start) {
		
		List<CsArticleDTO> articles = new ArrayList<>();
		
		SQL = "SELECT "
				+ "a.*,"
				+ "b.`nick` "
				+ "FROM `Article` AS a "
				+ "JOIN `User` AS b ON a.writer = b.uid "
				+ "WHERE `parent`=0 AND `cate`=? "
				+ "ORDER BY `no` DESC "
				+ "LIMIT ?, 10";
		
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(SQL);
			psmt.setString(1, cate);
			psmt.setInt(2, start);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				CsArticleDTO dto = new CsArticleDTO();
				dto.setAno(rs.getInt(1));
				dto.setParent(rs.getInt(2));
				dto.setCate(rs.getString(3));
				dto.setCatedetail(rs.getString(4));
				dto.setTitle(rs.getString(5));
				dto.setContent(rs.getString(6));
				dto.setFile(rs.getInt(7));
				dto.setWriter(rs.getString(9));
				dto.setRegip(rs.getString(10));
				dto.setRdate(rs.getString(11));
				
				articles.add(dto);
			}
			close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return articles;
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
