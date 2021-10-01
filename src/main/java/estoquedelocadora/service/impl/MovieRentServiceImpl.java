package estoquedelocadora.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import estoquedelocadora.entity.MovieRent;
import estoquedelocadora.repository.MovieRentRepository;
import estoquedelocadora.service.MovieRentService;

@Service
public class MovieRentServiceImpl implements MovieRentService{

	@Autowired
	MovieRentRepository movieRentRepository;
	
	@Override
	public List<MovieRent> getAllMovieRents() {
		return movieRentRepository.findAll();		
	}

	@Override
	public MovieRent findById(Long id) {
		return movieRentRepository.findById(id).get();
	}

	@Override
	public void addMovieRent(MovieRent movieRent) {
		movieRentRepository.save(movieRent);
	}

	@Override
	public void removeMovieRent(MovieRent movieRent) {
		movieRentRepository.delete(movieRent);	
	}

	@Override
	public void removeMovieRentById(Long id) {
		movieRentRepository.deleteById(id);
		
	}
}
