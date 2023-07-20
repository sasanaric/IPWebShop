package shop.ipwebshop.models.entities;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name = "message", schema = "web_shop")
public class MessageEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "text")
    private String text;
    @Basic
    @Column(name = "seen")
    private Boolean seen;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    private UserEntity user;

}
