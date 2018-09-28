package priv.dengjl.person.mapper;

import java.util.List;

import priv.dengjl.person.entity.Person;

public interface PersonMapper {

	List<Person> listPersons();

	void addPerson(Person person);

	void deletePerson(Person person);

	Person getPerson(int id);

	void updatePerson(Person person);
}