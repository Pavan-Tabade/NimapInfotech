package nimap.infotech.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import nimap.infotech.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
