package shop.ipwebshop.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import shop.ipwebshop.base.CrudController;
import shop.ipwebshop.base.CrudService;
import shop.ipwebshop.models.dto.Category;
import shop.ipwebshop.models.requests.CategoryRequest;
import shop.ipwebshop.services.CategoryService;

@RestController
@RequestMapping("/categories")
public class CategoryController extends CrudController<Integer, CategoryRequest, Category> {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        super(Category.class, categoryService);
        this.categoryService = categoryService;
    }

}
