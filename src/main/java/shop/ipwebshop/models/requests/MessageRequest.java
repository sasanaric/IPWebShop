package shop.ipwebshop.models.requests;
import lombok.Data;

@Data
public class MessageRequest {
    private String text;
//    private Boolean seen;
    private Integer userId;
}
