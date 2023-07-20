package shop.ipwebshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import shop.ipwebshop.models.entities.MessageEntity;

public interface MessageEntityRepository extends JpaRepository<MessageEntity,Integer> {
}
