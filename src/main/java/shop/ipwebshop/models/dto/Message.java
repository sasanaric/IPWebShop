package shop.ipwebshop.models.dto;

import lombok.Data;

@Data
public class Message {
    private Integer id;
    private String text;
    private Boolean seen;
    private Integer userId;
}
