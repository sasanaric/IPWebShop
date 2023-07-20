package shop.ipwebshop.models.dto;

import lombok.Data;

@Data
public class ProductAttribute {
    private Integer productId;
    private Integer attributeId;
    private String value;
}
