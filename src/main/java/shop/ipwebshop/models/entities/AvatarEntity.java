package shop.ipwebshop.models.entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "avatar", schema = "web_shop", catalog = "")
public class AvatarEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "avatarUrl")
    private String avatarUrl;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AvatarEntity that = (AvatarEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(avatarUrl, that.avatarUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, avatarUrl);
    }
}
