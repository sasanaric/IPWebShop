package shop.ipwebshop.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.util.List;

@Data
@Entity
@Table(name = "product", schema = "web_shop")
public class ProductEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "title")
    private String title;
    @Basic
    @Column(name = "description")
    private String description;
    @Basic
    @Column(name = "price")
    private BigDecimal price;
    @Basic
    @Column(name = "condition")
    private String condition;
    @Basic
    @Column(name = "sold")
    private Boolean sold;
    @Basic
    @Column(name = "deleted")
    private Boolean deleted;
    @Basic
    @Column(name = "category_id")
    private Integer categoryId;

    @OneToMany(mappedBy = "product")
    @JsonIgnore
    private List<CommentEntity> comments;

    @OneToMany(mappedBy = "product")
    @JsonIgnore
    private List<PhotoEntity> photos;

    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id", nullable = false)
    private CategoryEntity category;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    private UserEntity user;

    @OneToMany(mappedBy = "product")
    @JsonIgnore
    private List<ProductAttributeEntity> productAttributes;

}
