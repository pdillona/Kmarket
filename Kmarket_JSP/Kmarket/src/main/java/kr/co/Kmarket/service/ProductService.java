package kr.co.Kmarket.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.Kmarket.dao.ProductDAO;
import kr.co.Kmarket.dto.ProductDTO;

public class ProductService {
	private ProductDAO dao = new ProductDAO();
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public void insertProduct(ProductDTO dto) {
		dao.insertProduct(dto);
	}
	public ProductDTO selectProduct(String prodNo) {
		return dao.selectProduct(prodNo);
	}
	public List<ProductDTO> selectProducts(String seller, int start, String search, String search_text) {
		return dao.selectProducts(seller, start, search, search_text);
	}
	public ProductDTO selectImages(String prodNo) {
		logger.debug(prodNo);
		return dao.selectImages(prodNo);
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
	
	//추가 무현 베스트 상품 5개
	public List<ProductDTO> selectProductBest (){
		return dao.selectProductsBest();
	}
	
	//추가 무현 히트상품 8개 출력
	public List<ProductDTO> selectProductHit(){
		return dao.selectProductsHit();
	}
	
}
