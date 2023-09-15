package kr.co.Kmarket.dao;

import java.util.List;

import kr.co.Kmarket.db.DBHelper;
import kr.co.Kmarket.dto.CsArticleDTO;

public class CsArticleDAO extends DBHelper{

	String SQL = "";
	String SQL2 = "";
	
	public int insertArticle(CsArticleDTO dto) {
		int no = 0;
		
		try {
			
			SQL = "INSERT INTO `km_cs_article` SET "
					+ "`cate`=?, "
					+ "`cateDtail`=? "
					+ "`title`=?, "
					+ "`content`=?, "
					+ "`file`=?, "
					+ "`writer`=?, "
					+ "`regip`=?, "
					+ "`rdate`=NOW() ";
			
			SQL2 = "SELECT MAX(`no`) FROM `Article`";
			
			
			conn = getConnection();
			conn.setAutoCommit(false); // Transaction 시작
			
			stmt = conn.createStatement();
			psmt = conn.prepareStatement(SQL);
			psmt.setString(1, dto.getCate());
			psmt.setString(2, dto.getTitle());
			psmt.setString(3, dto.getContent());
			psmt.setInt(4, dto.getFile());
			psmt.setString(5, dto.getWriter());
			psmt.setString(6, dto.getRegip());
			psmt.executeUpdate();
			rs = stmt.executeQuery(SQL2);
			conn.commit(); // 작업확정
			
			if(rs.next()) {
				no = rs.getInt(1);
			}
			close();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return no;
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

	public int selectCountTotal(String cate) {
		// TODO Auto-generated method stub
		return 0;
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

	
	
	
	
	
	
}
