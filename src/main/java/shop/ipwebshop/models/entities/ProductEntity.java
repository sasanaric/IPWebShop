package shop.ipwebshop.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import shop.ipwebshop.base.BaseEntity;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

@Data
@Entity
@Table(name = "product", schema = "web_shop")
@SQLDelete(sql = "UPDATE product SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
public class ProductEntity implements BaseEntity<Integer> {
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
    @Column(name = "state")
    private String state;
    @Basic
    @Column(name = "sold")
    private Boolean sold;
    @Basic
    @Column(name = "deleted")
    private Boolean deleted;
    @Basic
    @Column(name = "posted_time")
    private Timestamp postedTime;

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
