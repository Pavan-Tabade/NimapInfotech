package nimap.infotech.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import nimap.infotech.model.Product;

public interface ProductService {
	
	public Product createProduct(Product product);
	public List<Product> getAllProducts();
	public Product getProductById(Long productId);
	public Product updateProductById(Product product,Long productId);
	public ResponseEntity<Product> deleteProductById(Long productId);
	
}
