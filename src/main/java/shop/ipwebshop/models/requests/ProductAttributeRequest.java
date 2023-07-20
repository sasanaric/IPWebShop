package shop.ipwebshop.models.requests;

import lombok.Data;

@Data
public class ProductAttributeRequest {
    private Integer productId;
    private Integer attributeId;
    private String value;
}
