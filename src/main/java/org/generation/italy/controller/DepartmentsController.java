package org.generation.italy.controller;
import org.generation.italy.model.Departments;
import org.generation.italy.repository.DegreesRepository;
import org.generation.italy.repository.DepartmentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")

public class DepartmentsController {

	@Autowired
	private DepartmentsRepository repository;
	
	@Autowired
	private DegreesRepository repository1;
	
	@GetMapping
	public String departments(Model model) {
		model.addAttribute("departments", repository.findAll(Sort.by("name")));
		return "departments";
	}
	
	@GetMapping("/department/{id}")
	public String degrees(Model model, @PathVariable Integer id) {
		Departments d = repository.getById(id);
		model.addAttribute("departments", d);
		model.addAttribute("degrees", d.getDegrees());		
		
		return "detail";
	}
	
}
