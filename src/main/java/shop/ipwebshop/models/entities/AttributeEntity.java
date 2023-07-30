package shop.ipwebshop.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import shop.ipwebshop.base.BaseEntity;

import java.util.List;

@Data
@Entity
@Table(name = "attribute")
public class AttributeEntity implements BaseEntity<Integer> {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id", nullable = false)
    private CategoryEntity category;

    @OneToMany(mappedBy = "attribute")
    @JsonIgnore
    private List<ProductAttributeEntity> productAttributes;

}
