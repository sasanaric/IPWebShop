package shop.ipwebshop.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import shop.ipwebshop.base.BaseEntity;

import java.util.Collection;

@Data
@Entity
@Table(name = "user", schema = "web_shop")
public class UserEntity implements BaseEntity<Integer> {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "first_name")
    private String firstName;
    @Basic
    @Column(name = "last_name")
    private String lastName;
    @Basic
    @Column(name = "username")
    private String username;
    @Basic
    @Column(name = "password")
    private String password;
    @Basic
    @Column(name = "city")
    private String city;
    @Basic
    @Column(name = "email")
    private String email;
    @Basic
    @Column(name = "role")
    private String role;
    @Basic
    @Column(name = "account_confirmed")
    private Boolean accountConfirmed;
    @Basic
    @Column(name = "pin")
    private String pin;

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private Collection<CommentEntity> comments;

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private Collection<MessageEntity> messages;

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private Collection<ProductEntity> products;

    public String getRole() {
        return role;
    }
}
