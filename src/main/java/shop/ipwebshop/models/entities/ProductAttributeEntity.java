package shop.ipwebshop.models.entities;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name = "product_attribute", schema = "web_shop")
@IdClass(ProductAttributeEntityPK.class)
public class ProductAttributeEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "product_id")
    private Integer productId;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "attribute_id")
    private Integer attributeId;
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
