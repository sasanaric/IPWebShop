package shop.ipwebshop.services.implementation;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import shop.ipwebshop.base.CrudJpaService;
import shop.ipwebshop.models.entities.ProductEntity;
import shop.ipwebshop.repositories.ProductEntityRepository;
import shop.ipwebshop.services.ProductService;

@Service
public class ProductServiceImplementation extends CrudJpaService<ProductEntity,Integer> implements ProductService {
    private final ProductEntityRepository repository;

    public ProductServiceImplementation(ModelMapper modelMapper, ProductEntityRepository repository) {
        super(repository, modelMapper, ProductEntity.class);
        this.repository = repository;
    }
}
