package estoquedelocadora.service;

import java.util.List;

import estoquedelocadora.entity.Person;

public interface PersonService {

	List<Person> getAllPersons();
	
	Person findById(Long id);
	
	void addPerson(Person person);
	
	void removePerson(Person person);
	
	void removePersonById(Long id);
	
}
