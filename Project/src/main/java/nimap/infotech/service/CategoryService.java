package nimap.infotech.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import nimap.infotech.model.Category;

public interface CategoryService {
	public Category createCategory(Category category);
	public List<Category> getAllCategories();
	public Category getCategoryById(Long categoryId);
	public Category updateCategoryById(Category category,Long categoryId);
	public ResponseEntity<Category> deleteCategoryById(Long categoryId);
	
}
