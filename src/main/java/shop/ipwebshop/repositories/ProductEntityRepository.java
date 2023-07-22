package shop.ipwebshop.repositories;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import shop.ipwebshop.models.entities.ProductEntity;

public interface ProductEntityRepository extends JpaRepository<ProductEntity,Integer> {
}
