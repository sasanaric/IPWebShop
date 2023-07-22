package shop.ipwebshop.services;

import shop.ipwebshop.base.CrudService;
import shop.ipwebshop.exceptions.NotFoundException;
import shop.ipwebshop.models.dto.Product;

public interface ProductService extends CrudService<Integer> {
    Product buyProduct(Integer id) throws NotFoundException;
}
