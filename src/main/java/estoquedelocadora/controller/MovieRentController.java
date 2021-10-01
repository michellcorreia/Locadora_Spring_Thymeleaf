package estoquedelocadora.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import estoquedelocadora.service.CategoryService;
import estoquedelocadora.service.MovieRentService;
import estoquedelocadora.service.PersonService;
import estoquedelocadora.service.ProductService;

@Controller
public class MovieRentController {

	@Autowired
	ProductService productService;
	
	@Autowired
	CategoryService categoryService;
	
	@Autowired
	PersonService personService;
	
	@Autowired
	MovieRentService movieRentService;
	
	@GetMapping("/rentList")
	public String getMovieRentList(Model model) {
		model.addAttribute("rents", movieRentService.getAllMovieRents());
		return "rent_list";
	}
}
