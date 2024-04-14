package nimap.infotech.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import nimap.infotech.model.Category;
import nimap.infotech.repository.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService{
	
	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public Category createCategory(Category category) {
		Category newCategory=category;
		return this.categoryRepository.save(newCategory);		
//		return category;
	}

	@Override
	public List<Category> getAllCategories() {
		List<Category> categoryList=this.categoryRepository.findAll();
		return categoryList;
	}

	@Override
	public Category getCategoryById(Long categoryId) {
//	 Optional<Category> getCateOptional=this.categoryRepository.findById(categoryId);
		return this.categoryRepository.findById(categoryId).orElseThrow(()->new RuntimeException("Category not found with id :"+categoryId));
	}

	@Override
	public Category updateCategoryById(Category category,Long categoryId) {
		Category existingCategory=this.categoryRepository.findById(categoryId).orElseThrow(()->new RuntimeException("Category not found with id :"+categoryId));
		existingCategory.setName(category.getName());
		return this.categoryRepository.save(existingCategory);
	}

	@Override
	public ResponseEntity<Category> deleteCategoryById(Long categoryId) {
		Category newCategory=this.categoryRepository.findById(categoryId).orElseThrow(()->new RuntimeException("Product not found with id :"+categoryId));	
		this.categoryRepository.delete(newCategory);
		System.out.println("chali gayi");
		return ResponseEntity.ok().build();
	}
	
	
}
