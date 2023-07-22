package shop.ipwebshop.models.dto;

import lombok.Data;
import java.math.BigDecimal;


@Data
public class Product {
    private Integer id;
    private String title;
    private String description;
    private BigDecimal price;
    private String state;
    private Boolean sold;
    private Boolean deleted;
    private String categoryName;
    private Integer userId;
    private String userUsername;
}
