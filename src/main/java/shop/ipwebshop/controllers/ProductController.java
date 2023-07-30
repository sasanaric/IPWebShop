package shop.ipwebshop.controllers;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import shop.ipwebshop.base.CrudController;
import shop.ipwebshop.exceptions.NotFoundException;
import shop.ipwebshop.models.dto.Product;
import shop.ipwebshop.models.requests.ProductRequest;
import shop.ipwebshop.services.ProductService;
import shop.ipwebshop.services.UserService;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/products")
public class ProductController extends CrudController<Integer, ProductRequest, Product> {
    final private ProductService productService;
    final private UserService userService;

    public ProductController(ProductService productService, UserService userService) {
        super(Product.class, productService);
        this.productService = productService;
        this.userService = userService;
    }
    @GetMapping("/filter")
    public Page<Product> getProducts(
            @RequestParam int page,
            @RequestParam int size,
            @RequestParam(required = false) BigDecimal priceFrom,
            @RequestParam(required = false) BigDecimal priceTo,
            @RequestParam(required = false) String categoryName,
            @RequestParam(required = false) String state,
            @RequestParam(defaultValue = "desc") String direction,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(required = false) String search
    ) {
        Sort sort = Sort.by(Sort.Direction.fromString(direction), sortBy);
        Pageable pageable = PageRequest.of(page, size, sort);

        return productService.getFilteredProducts(
                priceFrom,
                priceTo,
                categoryName,
                state,
                pageable,
                search
        );
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Product insert (@RequestBody ProductRequest productRequest) throws NotFoundException{
        productRequest.setUserId(userService.getCurrentUser().getId());
        productRequest.setPostedTime(new Timestamp(System.currentTimeMillis()));
        return productService.insert(productRequest,Product.class);
    }

    @GetMapping("/buy/{id}")
    public Product buyProduct(@PathVariable Integer id) throws NotFoundException {
        return productService.buyProduct(id);
    }
}
