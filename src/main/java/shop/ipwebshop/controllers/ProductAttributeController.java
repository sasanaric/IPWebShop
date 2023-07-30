package shop.ipwebshop.controllers;

import org.springframework.web.bind.annotation.*;
import shop.ipwebshop.base.CrudController;
import shop.ipwebshop.base.CrudService;
import shop.ipwebshop.exceptions.NotFoundException;
import shop.ipwebshop.models.dto.ProductAttribute;
import shop.ipwebshop.models.requests.ProductAttributeRequest;
import shop.ipwebshop.services.ProductAttributeService;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/product-attribute")
public class ProductAttributeController extends CrudController<Integer, ProductAttributeRequest, ProductAttribute> {
    private final ProductAttributeService service;

    public ProductAttributeController(ProductAttributeService service) {
        super(ProductAttribute.class, service);
        this.service = service;
    }

    @GetMapping("/product/{id}")
    public List<ProductAttribute> getProductAttributes(@PathVariable Integer id){
        return service.getProductAttributesByProductId(id);
    }
}
