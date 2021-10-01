package estoquedelocadora.service;

import java.util.List;

import estoquedelocadora.entity.Product;

public interface ProductService {

	List<Product> getAllMovies();
	
	Product findById(Long id);
	
	void addMovie(Product product);
	
	void removeMovie(Product product);
	
	void removeMovieById(Long id);
}
