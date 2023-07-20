package shop.ipwebshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import shop.ipwebshop.models.entities.ProductEntity;

public interface ProductEntityRepository extends JpaRepository<ProductEntity,Integer> {
}
