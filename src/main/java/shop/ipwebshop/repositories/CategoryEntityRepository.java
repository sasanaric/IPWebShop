package shop.ipwebshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import shop.ipwebshop.models.entities.CategoryEntity;

public interface CategoryEntityRepository extends JpaRepository<CategoryEntity,Integer> {
}
