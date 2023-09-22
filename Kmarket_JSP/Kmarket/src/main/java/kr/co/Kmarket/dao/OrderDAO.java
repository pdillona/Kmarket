package kr.co.Kmarket.dao;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.Kmarket.db.DBHelper;
import kr.co.Kmarket.dto.OrderDTO;
import kr.co.Kmarket.dto.OrderItemDTO;
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
		sql = "SELECT a.`prodNo`, b.*, c.`newThumb1`, c.`prodName` "
			+ "FROM `km_product_order_item` AS a "
			+ "JOIN `km_product_order` AS b ON a.`ordNo`=b.`ordNo` "
			+ "JOIN `km_product` AS c ON a.`prodNo`= c.`prodNo` "
			+ "JOIN `km_member` AS d ON c.`seller`=d.uid "
			+ "WHERE d.`company`=? "
			+ "ORDER BY b.`ordNo` DESC LIMIT ?, 10";
		String sql_search1 =  "SELECT a.`prodNo`, b.*, c.`newThumb1`, c.`prodName` "
								+ "FROM `km_product_order_item` AS a "
								+ "JOIN `km_product_order` AS b ON a.`ordNo`=b.`ordNo` "
								+ "JOIN `km_product` AS c ON a.`prodNo`= c.`prodNo` "
								+ "JOIN `km_member` AS d ON c.`seller`=d.uid "
								+ "WHERE d.`company`=? AND c.`prodName` LIKE ? "
								+ "ORDER BY b.`ordNo` DESC LIMIT ?, 10";
		String sql_search2 =  "SELECT a.`prodNo`, b.*, c.`newThumb1`, c.`prodName` "
									+ "FROM `km_product_order_item` AS a "
									+ "JOIN `km_product_order` AS b ON a.`ordNo`=b.`ordNo` "
									+ "JOIN `km_product` AS c ON a.`prodNo`= c.`prodNo` "
									+ "JOIN `km_member` AS d ON c.`seller`=d.uid "
									+ "WHERE d.`company`=? AND a.`prodNo` LIKE ? "
									+ "ORDER BY b.`ordNo` DESC LIMIT ?, 10";
		String sql_search3 =  "SELECT a.`prodNo`, b.*, c.`newThumb1`, c.`prodName` "
									+ "FROM `km_product_order_item` AS a "
									+ "JOIN `km_product_order` AS b ON a.`ordNo`=b.`ordNo` "
									+ "JOIN `km_product` AS c ON a.`prodNo`= c.`prodNo` "
									+ "JOIN `km_member` AS d ON c.`seller`=d.uid "
									+ "WHERE d.`company`=? AND b.`ordNo` LIKE ? "
									+ "ORDER BY b.`ordNo` DESC LIMIT ?, 10";
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
				OrderDTO dto = new OrderDTO();
				OrderItemDTO orderItemDTO = new OrderItemDTO();
				ProductDTO productDTO = new ProductDTO();
				orderItemDTO.setProdNo(rs.getInt(1));
				dto.setOrdNo(rs.getInt(2));
				dto.setOrdUid(rs.getString(3));
				dto.setOrdCount(rs.getInt(4));
				dto.setOrdPrice(rs.getInt(5));
				dto.setOrdDiscount(rs.getInt(6));
				dto.setOrdDelivery(rs.getInt(7));
				dto.setSavePoint(rs.getInt(8));
				dto.setUsedPoint(rs.getInt(9));
				dto.setOrdTotPrice(rs.getInt(10));
				dto.setRecipName(rs.getString(11));
				dto.setRecipHp(rs.getString(12));
				dto.setRecipZip(rs.getString(13));
				dto.setRecipAddr1(rs.getString(14));
				dto.setRecipAddr2(rs.getString(15));
				dto.setOrdStatus(rs.getString(16));
				dto.setOrdPayment(rs.getInt(17));
				dto.setOrdComplete(rs.getInt(18));
				dto.setDeliveryStatus(rs.getString(19));
				dto.setOrdDate(rs.getString(20));
				productDTO.setNewThumb1(rs.getString(21));
				productDTO.setProdName(rs.getString(22));
				dto.setProductDTO(productDTO);
				dto.setOrderItemDTO(orderItemDTO);
				orders.add(dto);
			}
			close();
		} catch (Exception e) {
			logger.error("selectOrders error : "+e.getMessage());
		}
		return orders;
	}
	public void updateOrder (OrderDTO dto) {
		
	}
	public void deleteOrder (String ordNo) {
		
	}
	public int selectCountTotal(SearchDTO dto) {
		int total = 0;
		sql = "SELECT COUNT(*) "
				+ "FROM `km_product_order_item` AS a "
				+ "JOIN `km_product_order` AS b ON a.`ordNo`=b.`ordNo` "
				+ "JOIN `km_product` AS c ON a.`prodNo`= c.`prodNo` "
				+ "JOIN `km_member` AS d ON c.`seller`=d.uid "
				+ "WHERE d.`company`=? ";
		String sql_search1 =  "SELECT COUNT(*) "
									+ "FROM `km_product_order_item` AS a "
									+ "JOIN `km_product_order` AS b ON a.`ordNo`=b.`ordNo` "
									+ "JOIN `km_product` AS c ON a.`prodNo`= c.`prodNo` "
									+ "JOIN `km_member` AS d ON c.`seller`=d.uid "
									+ "WHERE d.`company`=? AND c.`prodName` LIKE ? ";
	
		String sql_search2 ="SELECT COUNT(*) "
									+ "FROM `km_product_order_item` AS a "
									+ "JOIN `km_product_order` AS b ON a.`ordNo`=b.`ordNo` "
									+ "JOIN `km_product` AS c ON a.`prodNo`= c.`prodNo` "
									+ "JOIN `km_member` AS d ON c.`seller`=d.uid "
									+ "WHERE d.`company`=? AND a.`prodNo` LIKE ? ";
		
		String sql_search3 = "SELECT COUNT(*)  "
									+ "FROM `km_product_order_item` AS a "
									+ "JOIN `km_product_order` AS b ON a.`ordNo`=b.`ordNo` "
									+ "JOIN `km_product` AS c ON a.`prodNo`= c.`prodNo` "
									+ "JOIN `km_member` AS d ON c.`seller`=d.uid "
									+ "WHERE d.`company`=? AND b.`ordNo` LIKE ? ";
		conn = getConnection();
		try {
			if(dto.getSearch() == null || dto.getSearch().equals("")) {
				psmt = conn.prepareStatement(sql);
				psmt.setString(1, dto.getCompany());
			}else {
				if(dto.getSearch().equals("search1")) {
					psmt = conn.prepareStatement(sql_search1);
				}else if(dto.getSearch().equals("search2")) {
					psmt = conn.prepareStatement(sql_search2);
				}else if(dto.getSearch().equals("search3")) {
					psmt = conn.prepareStatement(sql_search3);
				}
				psmt.setString(1, dto.getCompany());
				psmt.setString(2, "%"+dto.getSearch_text()+"%");
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
}
