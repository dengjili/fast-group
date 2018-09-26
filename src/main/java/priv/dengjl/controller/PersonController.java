package priv.dengjl.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import priv.dengjl.entity.Person;
import priv.dengjl.service.PersonService;

@Controller
@RequestMapping("/person")
public class PersonController {

	@Autowired
	private PersonService service;

	@RequestMapping(value = "/list")
	public String listPerson(Model model) {

		List<Person> listPerson = service.listPerson();
		model.addAttribute("persons", listPerson);

		return "person/list";
	}

	@RequestMapping(value = "/addPage")
	public String addPersonPage(Model model) {
		return "person/addPage";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addPerson(@ModelAttribute Person person, Model model) {

		service.addPerson(person);

		return "redirect:list";
	}
	
	@RequestMapping(value = "/delete")
	public String deletePerson(@ModelAttribute Person person, Model model) {

		service.deletePerson(person);

		return "redirect:list";
	}
	

	@RequestMapping(value = "/updatePage")
	public String updatePersonPage(@ModelAttribute Person person, Model model) {

		Person personDb = service.getPerson(person.getId());
		model.addAttribute("person", personDb);

		return "person/updatePage";
	}
	

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updatePerson(@ModelAttribute Person person, Model model) {

		service.updatePerson(person);

		return "redirect:list";
	}
	

	@RequestMapping(value = "/get")
	public String getPerson(@ModelAttribute Person person, Model model) {

		Person personDb = service.getPerson(person.getId());
		model.addAttribute("person", personDb);

		return "person/detail";
	}

	@InitBinder
	public void init(WebDataBinder binder) {
		binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
	}

}
