package estoquedelocadora.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import estoquedelocadora.entity.MovieRent;

@Repository
public interface MovieRentRepository extends JpaRepository<MovieRent, Long> {

}
