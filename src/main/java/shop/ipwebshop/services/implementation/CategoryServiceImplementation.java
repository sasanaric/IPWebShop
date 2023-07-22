package shop.ipwebshop.services.implementation;

import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import shop.ipwebshop.base.CrudJpaService;
import shop.ipwebshop.models.entities.CategoryEntity;
import shop.ipwebshop.repositories.CategoryEntityRepository;
import shop.ipwebshop.services.CategoryService;

@Service
public class CategoryServiceImplementation extends CrudJpaService<CategoryEntity,Integer> implements CategoryService {
    private final CategoryEntityRepository repository;

    public CategoryServiceImplementation(ModelMapper modelMapper, CategoryEntityRepository repository) {
        super(repository, modelMapper, CategoryEntity.class);
        this.repository = repository;
    }
}
