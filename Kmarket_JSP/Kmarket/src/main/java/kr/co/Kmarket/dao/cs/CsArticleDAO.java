package kr.co.Kmarket.dao.cs;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.Kmarket.db.DBHelper;
import kr.co.Kmarket.dto.cs.CsArticleDTO;
import kr.co.Kmarket.dto.cs.CsCateDetailDTO;

public class CsArticleDAO extends DBHelper{

	
	private final Logger logger = LoggerFactory.getLogger(getClass());
	private final CsArticleDTO dto =  new CsArticleDTO();
	
	String SQL = "";
	String SQL2 = "";
	
	public int insertArticle(CsArticleDTO dto) {
		
		SQL = "INSERT INTO `km_cs_article` SET "
				+ "`group`=?, "
				+ "`cateDetail`=?, "
				+ "`title`=?, "
				+ "`content`=?, "
				+ "`file`=?, "
				+ "`writer`=?, "
				+ "`regip`=?, "
				+ "`type`=?, "
				+ "`uLevel`=?, "
				+ "`rdate`=NOW()";
		
		conn = getConnection();
		
		try {
			
			psmt = conn.prepareStatement(SQL);
			psmt.setString(1, dto.getGroup());
			psmt.setString(2, dto.getCateDetail());
			psmt.setString(3, dto.getTitle());
			psmt.setString(4, dto.getContent());
			psmt.setInt(5, dto.getFile());
			psmt.setString(6, dto.getWriter());
			psmt.setString(7, dto.getRegip());
			psmt.setInt(8, dto.getType());
			psmt.setInt(9, dto.getuLevel());
			psmt.executeUpdate();
	
			close();
		}catch(Exception e){
			logger.debug(e.getMessage());
		}
		
		
		return 0;
	}

	
	
	
	
	
	
	
//============qna================================================
	
    public List<CsArticleDTO> SelectQnaArticlesAll(String group, int start, String cateDetail) {
    	 
    	logger.debug("SelectQnaArticlesAll 그룹 스타트 체크: "+group,start);
    	logger.debug("SelectQnaArticlesAll 스타트 체크: "+ start);
    	conn = getConnection();
    	SQL = "SELECT DISTINCT * from `km_cs_article` AS a "
    			+ "JOIN `km_cs_cate_detail` AS c "
    			+ "ON a.`type` = c.`type` "
    			+ "WHERE a.`group` = ? AND  a.`type` >= 20 AND a.`cateDetail` = ? "
    			+ "ORDER BY `aNo` DESC "
    			+ "LIMIT ?, 10 ";
    	
    	List<CsArticleDTO> articles = new ArrayList<>();
    	
    	try {
			psmt = conn.prepareStatement(SQL);
			psmt.setString(1, group);
			psmt.setString(2, cateDetail);
			psmt.setInt(3, start);
			rs = psmt.executeQuery();
    		
			while(rs.next()) {
				CsArticleDTO dto = new CsArticleDTO();
				dto.setaNo(rs.getInt("aNo"));
				dto.setGroup(rs.getString("group"));
				dto.setCateDetail(rs.getString("cateDetail"));
				dto.setTitle(rs.getString("title"));
				dto.setWriter(rs.getString("writer"));
				dto.setRdate(rs.getString("rdate"));
				dto.setAeName(rs.getString("aeName"));
				dto.setuLevel(rs.getInt("uLevel"));
				dto.setType(rs.getInt("type"));
				dto.setdName(rs.getString("dName"));
				
				articles.add(dto);
			}
			close();
    		
		} catch (Exception e) {
			logger.debug("SelectQna: " + e.getMessage());
		}
    	
    	
    	logger.info("qnaSelects 아티클 찍었따 나와라 ㅡㅡ: "+ articles);
    	
    	return articles;
    }
	
	
	
	
	
	
	public CsArticleDTO selectArticle(String no) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<CsArticleDTO> selectArticles(String cate, int start) {
		// TODO Auto-generated method stub
		return null;
	}

	public void updateArticle(CsArticleDTO dto) {
		// TODO Auto-generated method stub
		
	}

	public void deleteArticle(String no) {
		// TODO Auto-generated method stub
		
	}

	public int selectCountTotal(String group, String type, String cateDetail) {

		int total = 0;
		
		SQL= "SELECT COUNT(*) FROM `km_cs_article` WHERE `group`=? AND `type` >= ? AND `cateDetail` = ?";
	
		
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(SQL);
			psmt.setString(1, group);
			psmt.setString(2, type);
			psmt.setString(3, cateDetail);
			rs = psmt.executeQuery();
			if(rs.next()) {
				total = rs.getInt(1);
			}
			close();			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		logger.debug("csarticleDAO selectTotalCout = "+total);
		
		return total;
	}

	public List<CsArticleDTO> selectComments(String parent) {
		// TODO Auto-generated method stub
		return null;
	}

	public CsArticleDTO insertComment(CsArticleDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	public int updateComment(String no, String content) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int deleteComment(String no) {
		// TODO Auto-generated method stub
		return 0;
	}

	
	
	public List<CsCateDetailDTO> selectCsWriteCate(String cateDetail){
		
		List<CsCateDetailDTO> cateList = new ArrayList<CsCateDetailDTO>();
		
		
		logger.debug("카테디테일 데이터!!!!!!!##@!#@!#@!   "+cateDetail);
		conn = getConnection();
		
		SQL = "SELECT * FROM `km_cs_cate_detail` WHERE `type`>=20 AND `aeName`=?";
		
		try {
		
			psmt = conn.prepareStatement(SQL);
			psmt.setString(1, cateDetail);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				CsCateDetailDTO dto = new CsCateDetailDTO();
				dto.setType(rs.getInt(1));
				dto.setdName(rs.getString(2));
				dto.setAeName(rs.getString(3));
				
				cateList.add(dto);
			}
			close();
			
		} catch (Exception e) {
			logger.debug("selectCsWriteCateDAO 에러~~~"+ e.getMessage());
		}
		
		
		
		logger.debug("selectCsWriteCateDAO cateList 정보~~~~~"+ cateList);
		
		
		return cateList; 
	}
	
	
	
	
}
