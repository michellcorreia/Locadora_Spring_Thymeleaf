package estoquedelocadora.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import estoquedelocadora.entity.Category;
import estoquedelocadora.repository.CategoryRepository;
import estoquedelocadora.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	CategoryRepository categoryRepository;
	
	@Override
	public List<Category> getAllCategories() {
		return categoryRepository.findAll();
	}

	@Override
	public Category findById(Long id) {
		return categoryRepository.findById(id).get();
	}

	@Override
	public void addCategory(Category category) {
		categoryRepository.save(category);	
	}
	
	@Override
	public void removeCategory(Category category) {
		categoryRepository.delete(category);
	}

	@Override
	public void removeCategoryById(Long id) {
		categoryRepository.deleteById(id);
		
	}

}
