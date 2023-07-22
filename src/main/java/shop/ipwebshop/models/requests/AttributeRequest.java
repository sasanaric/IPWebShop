package shop.ipwebshop.models.requests;

import lombok.Data;

@Data
public class AttributeRequest {
    private String name;
    private Integer categoryId;
}
