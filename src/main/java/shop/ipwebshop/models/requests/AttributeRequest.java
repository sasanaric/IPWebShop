package shop.ipwebshop.models.requests;

import lombok.Data;

@Data
public class AttributeRequest {
    private Integer id;
    private String name;
    private Integer categoryId;
}
