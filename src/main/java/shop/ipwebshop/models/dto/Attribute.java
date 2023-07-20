package shop.ipwebshop.models.dto;

import lombok.Data;


@Data
public class Attribute {
    private Integer id;
    private String name;
    private Integer categoryId;
}
