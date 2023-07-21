package shop.ipwebshop.models.entities;

import jakarta.persistence.*;
import lombok.*;
import shop.ipwebshop.base.BaseEntity;

@Data
@Entity
@Table(name = "photo", schema = "web_shop")
public class PhotoEntity implements BaseEntity<Integer> {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "photo_url")
    private String photoUrl;

    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id", nullable = false)
    private ProductEntity product;

}
