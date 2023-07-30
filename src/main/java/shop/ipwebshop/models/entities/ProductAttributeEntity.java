package shop.ipwebshop.models.entities;

import jakarta.persistence.*;
import lombok.*;
import shop.ipwebshop.base.BaseEntity;

@Data
@Entity
@Table(name = "product_attribute", schema = "web_shop")
public class ProductAttributeEntity implements BaseEntity<Integer> {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "value")
    private String value;
    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id", nullable = false)
    private ProductEntity product;
    @ManyToOne
    @JoinColumn(name = "attribute_id", referencedColumnName = "id", nullable = false)
    private AttributeEntity attribute;

}
