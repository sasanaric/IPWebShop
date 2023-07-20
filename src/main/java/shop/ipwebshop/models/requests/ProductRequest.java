package shop.ipwebshop.models.requests;

import lombok.Data;
import java.math.BigDecimal;


@Data
public class ProductRequest {
    private String title;
    private String description;
    private BigDecimal price;
    private String condition;
    private Integer categoryId;
    private Integer userId;
}
