package shop.ipwebshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import shop.ipwebshop.models.entities.ProductAttributeEntity;

import java.util.List;

public interface ProductAttributeEntityRepository extends JpaRepository<ProductAttributeEntity,Integer> {
    List<ProductAttributeEntity> getAllByProductId(Integer id);
}
