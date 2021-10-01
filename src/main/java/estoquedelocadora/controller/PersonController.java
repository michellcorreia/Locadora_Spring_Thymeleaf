package estoquedelocadora.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import estoquedelocadora.entity.Person;
import estoquedelocadora.service.CategoryService;
import estoquedelocadora.service.PersonService;
import estoquedelocadora.service.ProductService;

@Controller
public class PersonController {

	@Autowired
	ProductService productService;
	
	@Autowired
	CategoryService categoryService;
	
	@Autowired
	PersonService personService;
	
	@GetMapping("/clientList")
	public String getPersonList(Model model) {
		model.addAttribute("persons", personService.getAllPersons());
		return "client_list";
	}
	
	@GetMapping("/client/addNew")
	public String addNewPerson(Model model) {
		Person emptyPerson = new Person();
		model.addAttribute("emptyPerson", emptyPerson);
		return "client_add";
	}
	
	@PostMapping("/client/addNew/save")
	public String savePerson(@ModelAttribute ("emptyObject") Person person) {
		personService.addPerson(person);
		return "redirect:/clientList";
	}
	
	@GetMapping("/clientDelete/{id}")
	public String deletePerson(@PathVariable Long id) {
		personService.removePersonById(id);
		return "redirect:/clientList";
	}
	
	@GetMapping("/clientUpdate/{id}")
	public String updatePerson(@PathVariable Long id, Model model) {
		model.addAttribute("client", personService.findPersonById(id));
		return "client_update";
	}
	
	@PostMapping("/client/update/{id}")
	public String updateSave(@PathVariable Long id, @ModelAttribute ("client") Person person) {
		
		personService.addPerson(person);
		return "redirect:/clientList";
	}
	
}
