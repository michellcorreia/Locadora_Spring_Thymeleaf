package estoquedelocadora.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import estoquedelocadora.entity.Person;
import estoquedelocadora.repository.PersonRepository;
import estoquedelocadora.service.PersonService;

@Service
public class PersonServiceImpl implements PersonService{

	@Autowired
	PersonRepository personRepository;
	
	@Override
	public List<Person> getAllPersons() {
		return personRepository.findAll();
	}
	
	@Override
	public Person findById(Long id) {
		return personRepository.findById(id).get();
	}
	
	@Override
	public void addPerson(Person person) {
		personRepository.save(person);
	}
	
	@Override
	public void removePerson(Person person) {
		personRepository.delete(person);
	}
	
	@Override
	public void removePersonById(Long id) {
		personRepository.deleteById(id);
	}
	



	

}
