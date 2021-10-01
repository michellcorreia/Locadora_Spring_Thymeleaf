package estoquedelocadora.service;

import java.util.List;

import estoquedelocadora.entity.Category;

public interface CategoryService {

	List<Category> getAllCategories();
	
	Category findById(Long id);
	
	void addCategory(Category category);
	
	void removeCategory(Category movieRent);
	
	void removeCategoryById(Long id);
}
