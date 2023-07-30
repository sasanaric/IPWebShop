package shop.ipwebshop.models.requests;

import lombok.Data;
import java.math.BigDecimal;
import java.sql.Timestamp;


@Data
public class ProductRequest {
    private String title;
    private String description;
    private BigDecimal price;
    private String state;
    private Boolean sold = Boolean.FALSE;
    private Boolean deleted = Boolean.FALSE;
    private Timestamp postedTime;
    private Integer categoryId;
    private Integer userId;
}
