package estoquedelocadora.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import estoquedelocadora.entity.Product;
import estoquedelocadora.repository.ProductRepository;
import estoquedelocadora.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepository productRepository;

	@Override
	public List<Product> getAllMovies() {
		return productRepository.findAll();
	}

	@Override
	public void addMovie(Product product) {
		productRepository.save(product);
	}

	@Override
	public Product findById(Long id) {
		return productRepository.findById(id).get();
	}

	@Override
	public void removeMovie(Product product) {
		productRepository.delete(product);
	}

	@Override
	public void removeMovieById(Long id) {
		productRepository.deleteById(id);
	}
	
}
