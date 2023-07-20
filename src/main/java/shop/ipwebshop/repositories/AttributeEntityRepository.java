package shop.ipwebshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import shop.ipwebshop.models.dto.Attribute;
import shop.ipwebshop.models.entities.AttributeEntity;

public interface AttributeEntityRepository extends JpaRepository<AttributeEntity,Integer> {
}
