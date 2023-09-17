package kr.co.Kmarket.service;

import java.util.List;

import kr.co.Kmarket.dao.ProductDAO;
import kr.co.Kmarket.dto.ProductDTO;

public class ProductService {
	private ProductDAO dao = new ProductDAO();
	
	public void insertProduct(ProductDTO dto) {
		dao.insertProduct(dto);
	}
	public ProductDTO selectProduct(String prodNo) {
		return dao.selectProduct(prodNo);
	}
	public List<ProductDTO> selectProducts(int start, String search, String search_text) {
		return dao.selectProducts(start, search, search_text);
	}
	public void updateProduct(ProductDTO dto) {
		dao.updateProduct(dto);
	}
	public void deleteProduct(String prodNo) {
		dao.deleteProduct(prodNo);
	}
	public int selectCountTotal(String search, String search_text) {
		return dao.selectCountTotal(search, search_text);
	}
	
}
