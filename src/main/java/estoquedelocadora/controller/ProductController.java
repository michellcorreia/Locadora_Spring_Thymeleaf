package estoquedelocadora.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import estoquedelocadora.entity.Category;
import estoquedelocadora.entity.Product;
import estoquedelocadora.service.CategoryService;
import estoquedelocadora.service.PersonService;
import estoquedelocadora.service.ProductService;

@Controller
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@Autowired
	CategoryService categoryService;
	
	@Autowired
	PersonService personService;

	@GetMapping("/index")
	public String hello() {
		return "index";
	}
	
	@GetMapping("/addnew")
	public String addNewMovie(Model model) {
		Product emptyProduct = new Product();
		System.out.println(emptyProduct.getId());
		model.addAttribute("movie", emptyProduct);
		model.addAttribute("categories", categoryService.getAllCategories());
		return "product_add";
	}
	
	@PostMapping("/add_new/save")
	public String add(@ModelAttribute("movie") Product product) {
		//product.setCategory(cs.findById(product.getCategory_id()));
		productService.addMovie(product);
		return "redirect:/collection";
	}
	
	@GetMapping("/edit/{id}")
	public String update(@PathVariable Long id, Model model) {
		model.addAttribute("movie", productService.findById(id));
		model.addAttribute("categories", categoryService.getAllCategories());
		return "product_edit";
	}
	
	@PostMapping("/add_new/edit/{id}")
	public String edit(@PathVariable Long id, @ModelAttribute("movie") Product product) {
		Product temp = new Product();
		temp.setId(id);
		temp.setName(product.getName());
		temp.setCategory(product.getCategory());
		productService.addMovie(temp);
		return "redirect:/collection";
	}
	
	@GetMapping("/{id}")
	public String delete(@PathVariable Long id) {
		productService.removeMovie(productService.findById(id));
		return "redirect:/collection";
	}
	
	@GetMapping("/collection")
	public String getCollectionList(@ModelAttribute("emptyObject") Category category, Model model) {
		List<Product> list = new ArrayList<>();
		if(Objects.equals(category.getId(), 0L) || Objects.equals(category.getId(), null)) {
			list.addAll(productService.getAllMovies());
		}
		
		model.addAttribute("filtered", list);
		model.addAttribute("category", category.getName());
		model.addAttribute("movies", productService.getAllMovies());
		model.addAttribute("categories", categoryService.getAllCategories());
		return "product_list";
	}
	
	@PostMapping("/collection")
	public String filterByCategory(@ModelAttribute("emptyObject") Category category, Model model) {
		List<Product> list = new ArrayList<>();
		
		if(category.getId() == 0L || category.getId() == null) {
			list.addAll(productService.getAllMovies());
		}
		else {
			for(Product movie : productService.getAllMovies()) {
				
				if(movie.getCategory().getId() == category.getId()) {
					list.add(movie);
				}	
			}
		}
		
		model.addAttribute("filtered", list);
		model.addAttribute("category", category.getName());
		model.addAttribute("movies", productService.getAllMovies());
		model.addAttribute("categories", categoryService.getAllCategories());
		return "product_list";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
		
}
