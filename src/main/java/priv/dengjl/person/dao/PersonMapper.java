package priv.dengjl.person.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import priv.dengjl.person.bean.Person;

@Repository
public interface PersonMapper {

	List<Person> listPersons();

	void addPerson(Person person);

	void deletePerson(Person person);

	Person getPerson(int id);

	void updatePerson(Person person);
}