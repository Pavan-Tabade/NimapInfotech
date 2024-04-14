package nimap.infotech.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import nimap.infotech.model.Product;
import nimap.infotech.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductRepository productRepository;

	@Override
	public Product createProduct(Product product) {		
		Product newProduct=product;
		return this.productRepository.save(newProduct);
	}

	@Override
	public List<Product> getAllProducts() {
		List<Product> productList=this.productRepository.findAll();
		return productList;
	}

	@Override
	public Product getProductById(Long productId) {
		// TODO Auto-generated method stub
		return this.productRepository.findById(productId).orElseThrow(()->new RuntimeException("Product not found with id :"+productId));
	}

	@Override
	public Product updateProductById(Product product,Long productId) {
		Product existingProduct=this.productRepository.findById(productId).orElseThrow(()->new RuntimeException("Product not found with id :"+productId));
		existingProduct.setName(product.getName());
		existingProduct.setCategory(product.getCategory());
		return this.productRepository.save(existingProduct);
	}

	@Override
	public	ResponseEntity<Product> deleteProductById(Long productId) {
		// TODO Auto-generated method stub
		Product existingProduct=this.productRepository.findById(productId).orElseThrow(()->new RuntimeException("Product not found with id :"+productId));	
		this.productRepository.delete(existingProduct);
		return ResponseEntity.ok().build();
	}
	
	

}
