package shop.ipwebshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import shop.ipwebshop.models.entities.CommentEntity;

public interface CommentEntityRepository extends JpaRepository<CommentEntity,Integer> {
}
