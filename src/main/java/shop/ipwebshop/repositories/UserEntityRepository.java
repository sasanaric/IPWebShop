package shop.ipwebshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import shop.ipwebshop.models.entities.UserEntity;

import java.util.Optional;

public interface UserEntityRepository extends JpaRepository<UserEntity,Integer> {
    Optional<UserEntity> findByUsername(String username);
}
