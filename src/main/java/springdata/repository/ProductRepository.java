package springdata.repository;

import org.springframework.data.repository.CrudRepository;
import springdata.model.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {

}
