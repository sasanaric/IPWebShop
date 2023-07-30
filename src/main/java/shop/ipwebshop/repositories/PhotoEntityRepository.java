package shop.ipwebshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import shop.ipwebshop.models.entities.PhotoEntity;

import java.util.List;

public interface PhotoEntityRepository extends JpaRepository<PhotoEntity,Integer> {
    List<PhotoEntity> getAllByProductId(Integer id);
}
