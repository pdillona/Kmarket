package kr.co.Kmarket.dao;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.Kmarket.db.DBHelper;
import kr.co.Kmarket.dto.OrderDTO;
import kr.co.Kmarket.dto.ProductDTO;
import kr.co.Kmarket.dto.SearchDTO;

public class OrderDAO extends DBHelper{
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	String sql;
	public void insertOrder (OrderDTO dto) {
		
	}
	public OrderDTO selectOrder (String ordNo) {
		return null;
	}
	public List<OrderDTO> selectOrders (int start, SearchDTO searchDTO) {
		List<OrderDTO> orders = new ArrayList<OrderDTO>();
		sql = "SELECT * FROM `km_product` AS a JOIN `km_member` AS b ON a.`seller`=b.`uid` WHERE b.`company`=? ORDER BY `prodNo` DESC LIMIT ?, 10";
		String sql_search1 =  "SELECT * FROM `km_product` "
							+ "AS a JOIN `km_member` AS b ON a.`seller`=b.`uid` "
							+ "WHERE b.`company`=? AND `prodName` LIKE ? "
							+ "ORDER BY `prodNo` DESC "
							+ "LIMIT ?, 10";
		String sql_search2 =  "SELECT * FROM `km_product` "
							+ "AS a JOIN `km_member` AS b ON a.`seller`=b.`uid` "
							+ "WHERE b.`company`=? AND `prodNo` LIKE ? "
							+ "ORDER BY `prodNo` DESC "
							+ "LIMIT ?, 10";
		String sql_search3 =  "SELECT * FROM `km_product` "
								+ "AS a JOIN `km_member` AS b ON a.`seller`=b.`uid` "
								+ "WHERE b.`company`=? AND b.`manager` LIKE ? "
								+ "ORDER BY `prodNo` DESC "
								+ "LIMIT ?, 10";
		conn = getConnection();
		try {
			if(searchDTO.getSearch() == null || searchDTO.getSearch().equals("")) {
				psmt = conn.prepareStatement(sql);
				psmt.setString(1, searchDTO.getCompany());
				psmt.setInt(2, start);
			}else {
				if(searchDTO.getSearch().equals("search1")) {
					psmt = conn.prepareStatement(sql_search1);
				}else if(searchDTO.getSearch().equals("search2")) {
					psmt = conn.prepareStatement(sql_search2);
				}else if(searchDTO.getSearch().equals("search3")) {
					psmt = conn.prepareStatement(sql_search3);
				}
				psmt.setString(1, searchDTO.getCompany());
				psmt.setString(2, "%"+searchDTO.getSearch_text()+"%");
				psmt.setInt(3, start);
			}
			rs = psmt.executeQuery();
			while(rs.next()) {
				/*
				 * ProductDTO dto = new ProductDTO(); dto.setProdNo(rs.getInt(1));
				 * dto.setSeller(rs.getString(2)); dto.setProdCate1(rs.getInt(3));
				 * dto.setProdCate2(rs.getInt(4)); dto.setProdName(rs.getString(5));
				 * dto.setDescript(rs.getString(6)); dto.setCompany(rs.getString(7));
				 * dto.setPrice(rs.getInt(8)); dto.setDiscount(rs.getInt(9));
				 * dto.setPoint(rs.getInt(10)); dto.setStock(rs.getInt(11));
				 * dto.setSold(rs.getInt(12)); dto.setDelivery(rs.getInt(13));
				 * dto.setHit(rs.getInt(14)); dto.setScore(rs.getInt(15));
				 * dto.setReview(rs.getInt(16)); dto.setThumb1(rs.getString(17));
				 * dto.setNewThumb1(rs.getString(18)); dto.setThumb2(rs.getString(19));
				 * dto.setNewThumb2(rs.getString(20)); dto.setThumb3(rs.getString(21));
				 * dto.setNewThumb3(rs.getString(22)); dto.setDetail(rs.getString(23));
				 * dto.setNewDetail(rs.getString(24)); dto.setStatus(rs.getString(25));
				 * dto.setDuty(rs.getString(26)); dto.setReceipt(rs.getString(27));
				 * dto.setBizType(rs.getString(28)); dto.setOrigin(rs.getString(29));
				 * dto.setIp(rs.getString(30)); dto.setRdate(rs.getString(31));
				 * dto.setEtc1(rs.getInt(32)); dto.setEtc2(rs.getInt(33));
				 * dto.setEtc3(rs.getString(34)); dto.setEtc4(rs.getString(35));
				 * dto.setEtc5(rs.getString(36)); orders.add(dto);
				 */
			}
			close();
		} catch (Exception e) {
			logger.error("selectProducts error : "+e.getMessage());
		}
		return orders;
	}
	public void updateOrder (OrderDTO dto) {
		
	}
	public void deleteOrder (String ordNo) {
		
	}
	public int selectCountTotal(SearchDTO dto) {
		return 0;
	}
}
