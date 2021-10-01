package estoquedelocadora.service;

import java.util.List;

import estoquedelocadora.entity.MovieRent;

public interface MovieRentService {

	List<MovieRent> getAllMovieRents();
	
	MovieRent findById(Long id);
	
	void addMovieRent(MovieRent movieRent);
	
	void removeMovieRent(MovieRent movieRent);
	
	void removeMovieRentById(Long id);
}
