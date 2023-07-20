package shop.ipwebshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import shop.ipwebshop.models.entities.PhotoEntity;

public interface PhotoEntityRepository extends JpaRepository<PhotoEntity,Integer> {
}
