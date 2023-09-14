package kr.co.Kmarket.dao.seller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.Kmarket.db.DBHelper;
import kr.co.Kmarket.dto.seller.Cate2DTO;

public class Cate2DAO extends DBHelper{
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	String sql = "";
	
	public void insertCate2(Cate2DTO dto) {}
	public Cate2DTO selectCate2(String cate1) {
		return null;
	}
	public List<Cate2DTO> selectCate2s(String cate1) {
		List<Cate2DTO> cate2s = new ArrayList<Cate2DTO>();
		conn = getConnection();
		try {
			sql= "SELECT * FROM `km_product_cate2` WHERE `cate1`=?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, cate1);
			rs = psmt.executeQuery();
			while(rs.next()) {
				Cate2DTO dto = new Cate2DTO();
				dto.setCate2(rs.getInt(1));
				dto.setC2Name(rs.getString(2));
				dto.setCate1(rs.getInt(3));
				cate2s.add(dto);
			}
			close();
		} catch (Exception e) {
			logger.error("selectCate2 error : "+e.getMessage());
		}
		return cate2s;
	}
	public void updateCate2(Cate2DTO dto) {}
	public void deleteCate2(String cate1) {}
}
