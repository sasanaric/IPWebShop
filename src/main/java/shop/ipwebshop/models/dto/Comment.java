package shop.ipwebshop.models.dto;
import lombok.Data;

import java.sql.Timestamp;

@Data
public class Comment {
    private Integer id;
    private Timestamp createdTime;
    private String text;
    private Integer productId;
    private Integer userId;
    private String userUsername;
}
