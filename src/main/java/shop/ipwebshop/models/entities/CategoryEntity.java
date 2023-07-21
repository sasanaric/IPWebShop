package shop.ipwebshop.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import shop.ipwebshop.base.BaseEntity;

import java.util.List;

@Data
@Entity
@Table(name = "category")
public class CategoryEntity implements BaseEntity<Integer> {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "category")
    @JsonIgnore
    private List<AttributeEntity> attributes;
    @OneToMany(mappedBy = "category")
    @JsonIgnore
    private List<ProductEntity> products;

}
