package priv.dengjl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import priv.dengjl.entity.Person;
import priv.dengjl.mapper.PersonMapper;

@Service
public class PersonService {

	@Autowired
	private PersonMapper mapper;
	
	// 不分页查询
	public List<Person> listPerson() {
		return mapper.listPersons();
	}

	// 添加一个用户
	public void addPerson(Person person) {
		mapper.addPerson(person);
	}

	// 删除一个用户
	public void deletePerson(Person person) {
		mapper.deletePerson(person);
	}

	// 查询一个用户
	public Person getPerson(int id) {
		return mapper.getPerson(id);
	}

	// 更新一个用户
	public void updatePerson(Person person) {
		mapper.updatePerson(person);
	}
	
}
