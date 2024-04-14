package nimap.infotech.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.persistence.criteria.Path;
import nimap.infotech.model.Category;
import nimap.infotech.model.Product;
import nimap.infotech.repository.CategoryRepository;
import nimap.infotech.repository.ProductRepository;
import nimap.infotech.service.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {
	@Autowired
	private ProductService productService;
	
//	@PostMapping
//	public ResponseEntity<?> createProduct(@RequestBody Product product) {
//	    // Check if the Category is set for the Product
//	    if (product.getCategory() == null || product.getCategory().getId() == null) {
//	        return ResponseEntity.badRequest().body("Category is required for the Product");
//	    }
//	    
//	    // Retrieve the Category from the database
//	     optionalCategory =productService.getProductById(product.getCategory().getId());
////	    		CategoryRepository.findById(product.getCategory().getId());
////	    Optional<Category> optionalCategory = CategoryRepository.class.getDeclaredField(product.getCategory().getId());
//	    if (!optionalCategory.isPresent()) {
//	        return ResponseEntity.badRequest().body("Category with ID " + product.getCategory().getId() + " not found");
//	    }
//	    
//	    // Set the Category for the Product
//	    Category category = optionalCategory.get();
//	    product.setCategory(category);
//	    
//	    // Save the Product
//	    try {
//	        Product createdProduct = productService.createProduct(product);
//	        return ResponseEntity.ok().body(createdProduct);
//	    } catch (Exception e) {
//	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error creating Product: " + e.getMessage());
//	    }
//	}

	
	//create new product
	@PostMapping
	public Product createProduct(@RequestBody Product product) {
//		Product newProduct=product;
//		return this.productService.createProduct(newProduct);
		return this.productService.createProduct(product);
	}
	

	//get all products
	@GetMapping
	public List<Product> getAllProducts(){	
		return this.productService.getAllProducts();
	}
	
	//get product by id
	@GetMapping("/{id}")
	public Product getProductById(@PathVariable(value="id") long productId) {
		return this.productService.getProductById(productId);	
	}
	
	@PutMapping("/{id}")
	public Product updateProductById(@RequestBody Product product,@PathVariable(value = "id") long productId) {
		return this.productService.updateProductById(product,productId);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Product> deleteProductById(@PathVariable(value = "id") long productId) {
		return this.productService.deleteProductById(productId);
	}
	

	
}
