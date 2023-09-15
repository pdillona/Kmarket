package kr.co.Kmarket.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.Kmarket.db.DBHelper;
import kr.co.Kmarket.dto.ProductDTO;

public class ProductDAO extends DBHelper{
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	String sql = "";
	
	public void insertProduct(ProductDTO dto) {
		conn = getConnection();
		try {
			sql = "INSERT INTO `km_product` SET "
					+ "`seller`=?, "
					+ "`prodCate1`=?, "
					+ "`prodCate2`=?, "
					+ "`prodName`=?, "
					+ "`descript`=?, "
					+ "`company`=?, "
					+ "`price`=?, "
					+ "`discount`=?, "
					+ "`point`=?, "
					+ "`stock`=?, "
					+ "`delivery`=?, "
					+ "`thumb1`=?, "
					+ "`newThumb1`=?, "
					+ "`thumb2`=?, "
					+ "`newThumb2`=?, "
					+ "`thumb3`=?, "
					+ "`newThumb3`=?, "
					+ "`detail`=?, "
					+ "`newDetail`=?, "
					+ "`status`=?, "
					+ "`duty`=?, "
					+ "`receipt`=?, "
					+ "`bizType`=?, "
					+ "`origin`=?, "
					+ "`ip`=?, "
					+ "`rdate`=NOW()";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getSeller());
			psmt.setInt(2, dto.getProdCate1());
			psmt.setInt(3, dto.getProdCate2());
			psmt.setString(4, dto.getProdName());
			psmt.setString(5, dto.getDescript());
			psmt.setString(6, dto.getCompany());
			psmt.setInt(7, dto.getPrice());
			psmt.setInt(8, dto.getDiscount());
			psmt.setInt(9, dto.getPoint());
			psmt.setInt(10, dto.getStock());
			psmt.setInt(11, dto.getDelivery());
			psmt.setString(12, dto.getThumb1());
			psmt.setString(13, dto.getNewThumb1());
			psmt.setString(14, dto.getThumb2());
			psmt.setString(15, dto.getNewThumb2());
			psmt.setString(16, dto.getThumb3());
			psmt.setString(17, dto.getNewThumb3());
			psmt.setString(18, dto.getDetail());
			psmt.setString(19, dto.getNewDetail());
			psmt.setString(20, dto.getStatus());
			psmt.setString(21, dto.getDuty());
			psmt.setString(22, dto.getReceipt());
			psmt.setString(23, dto.getBizType());
			psmt.setString(24, dto.getOrigin());
			psmt.setString(25, dto.getIp());
			psmt.executeUpdate();
			close();
		} catch (Exception e) {
			logger.error("insertProduct error : "+e.getMessage());
		}
	}
	public ProductDTO selectProduct(String prodNo) {
		return null;
	}
	public List<ProductDTO> selectProducts() {
		return null;
	}
	public void updateProduct(ProductDTO dto) {}
	public void deleteProduct(String prodNo) {}
	
}
