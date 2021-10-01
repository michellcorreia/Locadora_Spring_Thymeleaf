package estoquedelocadora.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import estoquedelocadora.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
