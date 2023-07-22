package shop.ipwebshop.models.requests;

import lombok.Data;
import java.math.BigDecimal;


@Data
public class ProductRequest {
    private String title;
    private String description;
    private BigDecimal price;
    private String state;
    private Boolean sold = Boolean.FALSE;
    private Boolean deleted = Boolean.FALSE;
    private Integer categoryId;
    private Integer userId;
}
