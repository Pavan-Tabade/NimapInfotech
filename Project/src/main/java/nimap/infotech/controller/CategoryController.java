package nimap.infotech.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import nimap.infotech.model.Category;
import nimap.infotech.model.Product;
import nimap.infotech.repository.CategoryRepository;
import nimap.infotech.repository.ProductRepository;
import nimap.infotech.service.CategoryService;
import nimap.infotech.service.CategoryServiceImpl;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	//create new product
	@PostMapping
	public Category createCategory(@RequestBody Category category) {
//		Category newCategory=category;
//		return this.categoryRepository.save(category);
		return this.categoryService.createCategory(category);
	}
	
	//get all products
	@GetMapping()
	public List<Category> getAllProducts(){	
//		return this.categoryRepository.findAll();
		return this.categoryService.getAllCategories();
	}
	
	//get product by id
	@GetMapping("/{id}")
	public Category getProductById(@PathVariable(value="id") long productId) {
//		return this.categoryRepository.getById(productId);
		return this.categoryService.getCategoryById(productId);
	}
	
	//update product by id
	@PutMapping("/{id}")
	public Category updateCategoryById(@RequestBody Category category,@PathVariable(value ="id") long categoryId){
		return this.categoryService.updateCategoryById(category, categoryId);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Category> deleteCategoryById(@PathVariable(value = "id") long categoryId) {
		return this.categoryService.deleteCategoryById(categoryId);
	}

}
