package shop.ipwebshop.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import shop.ipwebshop.base.CrudController;
import shop.ipwebshop.base.CrudService;
import shop.ipwebshop.exceptions.NotFoundException;
import shop.ipwebshop.models.dto.Product;
import shop.ipwebshop.models.requests.ProductRequest;
import shop.ipwebshop.services.ProductService;
import shop.ipwebshop.services.UserService;

@RestController
@RequestMapping("/products")
public class ProductController extends CrudController<Integer, ProductRequest, Product> {
    private ProductService productService;
    private UserService userService;

    public ProductController(ProductService productService, UserService userService) {
        super(Product.class, productService);
        this.productService = productService;
        this.userService = userService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Product insert (@RequestBody ProductRequest productRequest) throws NotFoundException{
        productRequest.setUserId(userService.getCurrentUser().getId());
        return productService.insert(productRequest,Product.class);
    }

}
