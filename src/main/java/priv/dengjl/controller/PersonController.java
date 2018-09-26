package priv.dengjl.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import priv.dengjl.entity.Person;


@Controller
@RequestMapping("/person")
public class PersonController {
	
	@RequestMapping(value = "/list")
	public String listPerson(Model model) {
		
		Person person = new Person();
		person.setName("张三");
		person.setBirthdate(new Date());
		
		model.addAttribute("person", person);
		return "person/list";
	}
}
