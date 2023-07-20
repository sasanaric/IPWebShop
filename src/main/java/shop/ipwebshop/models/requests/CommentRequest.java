package shop.ipwebshop.models.requests;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class CommentRequest {
    private Timestamp createdTime;
    private String text;
    private Integer productId;
    private Integer userId;
}
