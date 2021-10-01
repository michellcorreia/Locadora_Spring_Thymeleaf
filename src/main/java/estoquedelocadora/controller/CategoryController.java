package estoquedelocadora.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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
	
}
