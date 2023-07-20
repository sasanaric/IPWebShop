package shop.ipwebshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import shop.ipwebshop.models.entities.ProductAttributeEntity;

public interface ProductAttributeEntityRepository extends JpaRepository<ProductAttributeEntity,Integer> {
}
