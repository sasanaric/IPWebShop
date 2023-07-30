package shop.ipwebshop.services.implementation;

import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import shop.ipwebshop.base.CrudJpaService;
import shop.ipwebshop.models.dto.ProductAttribute;
import shop.ipwebshop.models.entities.ProductAttributeEntity;
import shop.ipwebshop.repositories.ProductAttributeEntityRepository;
import shop.ipwebshop.services.ProductAttributeService;

import java.util.List;

@Service
public class ProductAttributeServiceImplementation extends CrudJpaService<ProductAttributeEntity,Integer> implements ProductAttributeService {
    private final ProductAttributeEntityRepository repository;
    private final ModelMapper modelMapper;

    public ProductAttributeServiceImplementation(ProductAttributeEntityRepository repository, ModelMapper modelMapper) {
        super(repository, modelMapper,ProductAttributeEntity.class);
        this.repository = repository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<ProductAttribute> getProductAttributesByProductId(Integer id) {
        return repository
                .getAllByProductId(id)
                .stream()
                .map(e -> modelMapper.map(e,ProductAttribute.class))
                .toList();
    }
}
