package shop.ipwebshop.services.implementation;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import shop.ipwebshop.base.CrudJpaService;
import shop.ipwebshop.exceptions.NotFoundException;
import shop.ipwebshop.models.dto.Product;
import shop.ipwebshop.models.entities.ProductEntity;
import shop.ipwebshop.repositories.ProductAttributeEntityRepository;
import shop.ipwebshop.repositories.ProductEntityRepository;
import shop.ipwebshop.services.ProductService;
import java.math.BigDecimal;

@Service
public class ProductServiceImplementation extends CrudJpaService<ProductEntity,Integer> implements ProductService {
    private final ProductEntityRepository repository;
    private final ModelMapper modelMapper;

    public ProductServiceImplementation(ModelMapper modelMapper, ProductEntityRepository repository) {
        super(repository, modelMapper, ProductEntity.class);
        this.repository = repository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Product buyProduct(Integer id) throws NotFoundException {
        ProductEntity product = repository.findById(id).orElseThrow(() -> new NotFoundException("Proizvod sa id " + id + " ne postoji."));
        product.setSold(true);
        product = repository.save(product);
        return getModelMapper().map(product, Product.class);
    }

    public Page<Product> getFilteredProducts(
            BigDecimal priceFrom,
            BigDecimal priceTo,
            String categoryName,
            String state,
            Pageable pageable,
            String search) {
        Page<ProductEntity> productEntitiesPage = repository.filteredProducts(priceFrom, priceTo, categoryName, state, pageable, search);
        return productEntitiesPage.map(entity -> modelMapper.map(entity, Product.class));
    }
}
