package shop.ipwebshop.services;

import shop.ipwebshop.base.CrudService;
import shop.ipwebshop.models.dto.ProductAttribute;

import java.util.List;

public interface ProductAttributeService extends CrudService<Integer> {
    List<ProductAttribute> getProductAttributesByProductId(Integer id);
}
