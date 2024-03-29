package shop.ipwebshop.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import shop.ipwebshop.models.entities.ProductEntity;
import shop.ipwebshop.models.entities.UserEntity;

import java.math.BigDecimal;
import java.util.Optional;

public interface ProductEntityRepository extends JpaRepository<ProductEntity,Integer> {

@Query("SELECT p FROM ProductEntity p WHERE " +
        "(:priceFrom IS NULL OR p.price >= :priceFrom) " +
        "AND (:priceTo IS NULL OR p.price <= :priceTo) " +
        "AND (:categoryName IS NULL OR p.category.name = :categoryName) " +
        "AND (:state IS NULL OR p.state = :state) " +
        "AND (:search IS NULL OR p.title LIKE %:search%) " +
        "AND p.sold = false ")
Page<ProductEntity> filteredProducts(
        BigDecimal priceFrom, BigDecimal priceTo, String categoryName, String state, Pageable pageable, String search);

Page<ProductEntity> getProductEntityByUserIdAndSoldIsFalse(Pageable pageable, Integer id);
Page<ProductEntity> getProductEntityByUserIdAndSoldIsTrue(Pageable pageable, Integer id);

}
//    @Query("SELECT p FROM ProductEntity p WHERE (:priceFrom IS NULL OR p.price >= :priceFrom) " +
//            "AND (:priceTo IS NULL OR p.price <= :priceTo) " +
//            "AND (:categoryName IS NULL OR p.category.name = :categoryName) " +
//            "AND (:state IS NULL OR p.state = :state) " +
//            "AND (:search IS NULL OR p.title LIKE %:search%) " +
//            "ORDER BY :#{#sort}")
//    List<ProductEntity> filteredProducts(BigDecimal priceFrom, BigDecimal priceTo, String categoryName, String state, Sort sort, String search);