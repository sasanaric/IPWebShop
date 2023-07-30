package shop.ipwebshop.models.dto;

import lombok.Data;
import java.math.BigDecimal;
import java.sql.Timestamp;


@Data
public class Product {
    private Integer id;
    private String title;
    private String description;
    private BigDecimal price;
    private String state;
    private Boolean sold;
    private Boolean deleted;
    private Timestamp postedTime;
    private String categoryName;
    private Integer userId;
    private String userUsername;

}
