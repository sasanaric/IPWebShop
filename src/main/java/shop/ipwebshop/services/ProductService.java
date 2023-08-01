package shop.ipwebshop.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import shop.ipwebshop.base.CrudService;
import shop.ipwebshop.exceptions.NotFoundException;
import shop.ipwebshop.models.dto.Product;

import java.math.BigDecimal;
import java.util.List;

public interface ProductService extends CrudService<Integer> {
    Product buyProduct(Integer id) throws NotFoundException;
    Page<Product> getFilteredProducts(
            BigDecimal priceFrom,
            BigDecimal priceTo,
            String categoryName,
            String state,
            Pageable pageable,
            String search);

    Page<Product> getActiveProductsByUserId(Pageable pageable, Integer id);
    Page<Product> getSoldProductsByUserId(Pageable pageable, Integer id);
}
