package estoquedelocadora.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import estoquedelocadora.entity.Category;
import estoquedelocadora.service.CategoryService;
import estoquedelocadora.service.PersonService;
import estoquedelocadora.service.ProductService;

@Controller
public class CategoryController {
	
	@Autowired
	ProductService productService;
	
	@Autowired
	CategoryService categoryService;
	
	@Autowired
	PersonService personService;
	
	
	@GetMapping("/addnew/category")
	public String newCategory(Model model) {
		Category emptyCategory = new Category();
		model.addAttribute("emptyObject", emptyCategory);
		model.addAttribute("categories", categoryService.getAllCategories());
		return "category_add";
	}
	
	@PostMapping("/addnew/category")
	public String addCategory(@ModelAttribute("emptyObject") Category category) {
		categoryService.addCategory(category);
		return "redirect:/addnew/category";
	}
	
	@GetMapping("/category/edit/{id}")
	public String editCategory(@PathVariable Long id, Model model) {
		model.addAttribute("category", categoryService.findById(id));
		return "category_edit";
	}
	
	@PostMapping("/category/edit/{id}")
	public String saveCategory(@PathVariable Long id, @ModelAttribute ("category") Category category) {
		category.setId(id);
		categoryService.addCategory(category);
		return "redirect:/addnew/category";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteCategory(@PathVariable Long id) {
		categoryService.removeCategoryById(id);
		return "redirect:/addnew/category";
	}
	
}
