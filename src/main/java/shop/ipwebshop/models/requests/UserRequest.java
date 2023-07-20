package shop.ipwebshop.models.requests;

import lombok.Data;

@Data
public class UserRequest {
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String city;
    private String email;
    private String role;
//    private Boolean accountConfirmed;
}
