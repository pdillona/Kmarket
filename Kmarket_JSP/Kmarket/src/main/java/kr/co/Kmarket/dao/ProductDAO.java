package kr.co.Kmarket.dao;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.Kmarket.db.DBHelper;
import kr.co.Kmarket.dto.ProductDTO;
import kr.co.Kmarket.dto.SearchDTO;

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
		ProductDTO dto = null;
		sql= "SELECT DISTINCT a.*, b.`c1Name` , c.`c2Name` "
				+ "FROM `km_product` AS a "
				+ "JOIN `km_product_cate1` AS b "
				+ "ON a.`prodCate1`=b.`cate1` "
				+ "JOIN `km_product_cate2` AS c "
				+ "ON b.`cate1`=c.`cate1` AND a.`prodCate2`=c.cate2 "
				+ "WHERE `prodNo`=?";
		conn = getConnection();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, prodNo);
			rs = psmt.executeQuery();
			if(rs.next()) {
				dto = new ProductDTO();
				dto.setProdNo(rs.getInt(1));
				dto.setSeller(rs.getString(2));
				dto.setProdCate1(rs.getInt(3));
				dto.setProdCate2(rs.getInt(4));
				dto.setProdName(rs.getString(5));
				dto.setDescript(rs.getString(6));
				dto.setCompany(rs.getString(7));
				dto.setPrice(rs.getInt(8));
				dto.setDiscount(rs.getInt(9));
				dto.setPoint(rs.getInt(10));
				dto.setStock(rs.getInt(11));
				dto.setSold(rs.getInt(12));
				dto.setDelivery(rs.getInt(13));
				dto.setHit(rs.getInt(14));
				dto.setScore(rs.getInt(15));
				dto.setReview(rs.getInt(16));
				dto.setThumb1(rs.getString(17));
				dto.setNewThumb1(rs.getString(18));
				dto.setThumb2(rs.getString(19));
				dto.setNewThumb2(rs.getString(20));
				dto.setThumb3(rs.getString(21));
				dto.setNewThumb3(rs.getString(22));
				dto.setDetail(rs.getString(23));
				dto.setNewDetail(rs.getString(24));
				dto.setStatus(rs.getString(25));
				dto.setDuty(rs.getString(26));
				dto.setReceipt(rs.getString(27));
				dto.setBizType(rs.getString(28));
				dto.setOrigin(rs.getString(29));
				dto.setIp(rs.getString(30));
				dto.setRdate(rs.getString(31));
				dto.setEtc1(rs.getInt(32));
				dto.setEtc2(rs.getInt(33));
				dto.setEtc3(rs.getString(34));
				dto.setEtc4(rs.getString(35));
				dto.setEtc5(rs.getString(36));
				dto.setC1Name(rs.getString(37));
				dto.setC2Name(rs.getString(38));
			}
			close();
		} catch (Exception e) {
			logger.error("selectProduct : "+e.getMessage());
		}
		return dto;
	}
	public List<ProductDTO> selectProducts(int start, SearchDTO search) {
		List<ProductDTO> products = new ArrayList<ProductDTO>();
		sql = "SELECT * FROM `km_product` WHERE `seller`=? ORDER BY `prodNo` DESC LIMIT ?, 10";
		String sql_search1 =  "SELECT * FROM `km_product` "
							+ "WHERE `seller`=? AND `prodName` LIKE ? "
							+ "ORDER BY `prodNo` DESC "
							+ "LIMIT ?, 10";
		String sql_search2 =  "SELECT * FROM `km_product` "
							+ "WHERE `seller`=? AND `prodNo` LIKE ? "
							+ "ORDER BY `prodNo` DESC "
							+ "LIMIT ?, 10";
		conn = getConnection();
		try {
			if(search.getSearch() == null || search.getSearch().equals("")) {
				psmt = conn.prepareStatement(sql);
				psmt.setString(1, search.getSeller());
				psmt.setInt(2, start);
			}else {
				if(search.getSearch().equals("search1")) {
					psmt = conn.prepareStatement(sql_search1);
				}else if(search.getSearch().equals("search2")) {
					psmt = conn.prepareStatement(sql_search2);
				}
				psmt.setString(1, search.getSeller());
				psmt.setString(2, "%"+search.getSearch_text()+"%");
				psmt.setInt(3, start);
			}
			rs = psmt.executeQuery();
			while(rs.next()) {
				ProductDTO dto = new ProductDTO();
				dto.setProdNo(rs.getInt(1));
				dto.setSeller(rs.getString(2));
				dto.setProdCate1(rs.getInt(3));
				dto.setProdCate2(rs.getInt(4));
				dto.setProdName(rs.getString(5));
				dto.setDescript(rs.getString(6));
				dto.setCompany(rs.getString(7));
				dto.setPrice(rs.getInt(8));
				dto.setDiscount(rs.getInt(9));
				dto.setPoint(rs.getInt(10));
				dto.setStock(rs.getInt(11));
				dto.setSold(rs.getInt(12));
				dto.setDelivery(rs.getInt(13));
				dto.setHit(rs.getInt(14));
				dto.setScore(rs.getInt(15));
				dto.setReview(rs.getInt(16));
				dto.setThumb1(rs.getString(17));
				dto.setNewThumb1(rs.getString(18));
				dto.setThumb2(rs.getString(19));
				dto.setNewThumb2(rs.getString(20));
				dto.setThumb3(rs.getString(21));
				dto.setNewThumb3(rs.getString(22));
				dto.setDetail(rs.getString(23));
				dto.setNewDetail(rs.getString(24));
				dto.setStatus(rs.getString(25));
				dto.setDuty(rs.getString(26));
				dto.setReceipt(rs.getString(27));
				dto.setBizType(rs.getString(28));
				dto.setOrigin(rs.getString(29));
				dto.setIp(rs.getString(30));
				dto.setRdate(rs.getString(31));
				dto.setEtc1(rs.getInt(32));
				dto.setEtc2(rs.getInt(33));
				dto.setEtc3(rs.getString(34));
				dto.setEtc4(rs.getString(35));
				dto.setEtc5(rs.getString(36));
				products.add(dto);
			}
			close();
		} catch (Exception e) {
			logger.error("selectProducts error : "+e.getMessage());
		}
		return products;
	}
	public ProductDTO selectImages(String prodNo) {
		ProductDTO dto=null;
		sql = "SELECT `prodCate1`, `prodCate2`, `newThumb1`, `newThumb2`, `newThumb3`, `newDetail` FROM `km_product` WHERE `prodNo`=?";
		conn = getConnection();
		logger.debug("selectImages...");
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, prodNo);
			rs = psmt.executeQuery();
			if(rs.next()) {
				dto = new ProductDTO();
				dto.setProdCate1(rs.getInt(1));
				dto.setProdCate2(rs.getInt(2));
				dto.setNewThumb1(rs.getString(3));
				dto.setNewThumb2(rs.getString(4));
				dto.setNewThumb3(rs.getString(5));
				dto.setNewDetail(rs.getString(6));
			}
			logger.debug("dto : "+dto);
			close();
			logger.debug("selectImages...2");
		} catch (Exception e) {
			logger.error("selectImages error : "+e.getMessage());
		}
		return dto;
	}
	public int selectCountTotal(String search, String search_text) {
		int total = 0;
		sql = "SELECT COUNT(*) FROM `km_product`";
		String sql_search1 =  "SELECT COUNT(*) FROM `km_product` "
							+ "WHERE `prodName` LIKE ?";
		String sql_search2 =  "SELECT COUNT(*) FROM `km_product` "
							+ "WHERE `prodNo` LIKE ?";
		String sql_search3 =  "SELECT COUNT(*) FROM `km_product` "
							+ "WHERE `company` LIKE ?";
		String sql_search4 =  "SELECT COUNT(*) FROM `km_product` "
							+ "WHERE `seller` LIKE ?";
		conn = getConnection();
		try {
			if(search == null) {
				psmt = conn.prepareStatement(sql);
			}else {
				if(search.equals("search1")) {
					psmt = conn.prepareStatement(sql_search1);
				}else if(search.equals("search2")) {
					psmt = conn.prepareStatement(sql_search2);
				}else if(search.equals("search3")) {
					psmt = conn.prepareStatement(sql_search3);
				}else {
					psmt = conn.prepareStatement(sql_search4);
				}
				psmt.setString(1, "%"+search_text+"%");
			}
			rs = psmt.executeQuery();
			if(rs.next()) {
				total = rs.getInt(1);
			}
			close();
		} catch (Exception e) {
			logger.error("selectCountTotal : "+e.getMessage());
		}
		return total;
	}
	
	//무현 추가 베스트 상품
	
	public List<ProductDTO> selectProductsBest() {
		List<ProductDTO> products = new ArrayList<>();
		try {
			conn = getConnection();
			sql = "SELECT * FROM `km_product` WHERE `stock` > 0 ORDER BY `sold` DESC LIMIT 5";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				ProductDTO dto = new ProductDTO();
				dto.setProdNo(rs.getInt(1));
				dto.setSeller(rs.getString(2));
				dto.setProdCate1(rs.getInt(3));
				dto.setProdCate2(rs.getInt(4));
				dto.setProdName(rs.getString(5));
				dto.setDescript(rs.getString(6));
				dto.setCompany(rs.getString(7));
				dto.setPrice(rs.getInt(8));
				dto.setDiscount(rs.getInt(9));
				dto.setPoint(rs.getInt(10));
				dto.setStock(rs.getInt(11));
				dto.setSold(rs.getInt(12));
				dto.setDelivery(rs.getInt(13));
				dto.setHit(rs.getInt(14));
				dto.setScore(rs.getInt(15));
				dto.setReview(rs.getInt(16));
				dto.setThumb1(rs.getString(17));
				dto.setNewThumb1(rs.getString(18));
				dto.setThumb2(rs.getString(19));
				dto.setNewThumb2(rs.getString(20));
				dto.setThumb3(rs.getString(21));
				dto.setNewThumb3(rs.getString(22));
				dto.setDetail(rs.getString(23));
				dto.setNewDetail(rs.getString(24));
				dto.setStatus(rs.getString(25));
				dto.setDuty(rs.getString(26));
				dto.setReceipt(rs.getString(27));
				dto.setBizType(rs.getString(28));
				dto.setOrigin(rs.getString(29));
				dto.setIp(rs.getString(30));
				dto.setRdate(rs.getString(31));
				dto.setEtc1(rs.getInt(32));
				dto.setEtc2(rs.getInt(33));
				dto.setEtc3(rs.getString(34));
				dto.setEtc4(rs.getString(35));
				dto.setEtc5(rs.getString(36));
				products.add(dto);
				
			}
			close();
		} catch (Exception e) {
			logger.error("selectProductsbest : "+e.getMessage());
		}
		return products;
		
	}
	
	//무현 추가 히트상품 8건 조회
	
	public List<ProductDTO> selectProductsHit() {
		List<ProductDTO> products = new ArrayList<>();
		try {
			conn = getConnection();
			sql = "SELECT * FROM `km_product` WHERE `stock` > 0 ORDER BY `hit` DESC LIMIT 8";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				ProductDTO dto = new ProductDTO();
				dto.setProdNo(rs.getInt(1));
				dto.setSeller(rs.getString(2));
				dto.setProdCate1(rs.getInt(3));
				dto.setProdCate2(rs.getInt(4));
				dto.setProdName(rs.getString(5));
				dto.setDescript(rs.getString(6));
				dto.setCompany(rs.getString(7));
				dto.setPrice(rs.getInt(8));
				dto.setDiscount(rs.getInt(9));
				dto.setPoint(rs.getInt(10));
				dto.setStock(rs.getInt(11));
				dto.setSold(rs.getInt(12));
				dto.setDelivery(rs.getInt(13));
				dto.setHit(rs.getInt(14));
				dto.setScore(rs.getInt(15));
				dto.setReview(rs.getInt(16));
				dto.setThumb1(rs.getString(17));
				dto.setNewThumb1(rs.getString(18));
				dto.setThumb2(rs.getString(19));
				dto.setNewThumb2(rs.getString(20));
				dto.setThumb3(rs.getString(21));
				dto.setNewThumb3(rs.getString(22));
				dto.setDetail(rs.getString(23));
				dto.setNewDetail(rs.getString(24));
				dto.setStatus(rs.getString(25));
				dto.setDuty(rs.getString(26));
				dto.setReceipt(rs.getString(27));
				dto.setBizType(rs.getString(28));
				dto.setOrigin(rs.getString(29));
				dto.setIp(rs.getString(30));
				dto.setRdate(rs.getString(31));
				dto.setEtc1(rs.getInt(32));
				dto.setEtc2(rs.getInt(33));
				dto.setEtc3(rs.getString(34));
				dto.setEtc4(rs.getString(35));
				dto.setEtc5(rs.getString(36));
				products.add(dto);
				
			}
			close();
		} catch (Exception e) {
			logger.error("selectProductsbest : "+e.getMessage());
		}
		return products;
		
	}
	public void updateProduct(ProductDTO dto) {}
	public void deleteProduct(String prodNo) {
		sql = "DELETE FROM `km_product` WHERE `prodNo`=?";
		conn = getConnection();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, prodNo);
			psmt.executeUpdate();
			close();
		} catch (Exception e) {
			logger.error("deleteProduct error : "+e.getMessage());
		}
	}
	
}
