package shop.ipwebshop.models.dto;

import lombok.Data;

@Data
public class User {
    private Integer id;
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String city;
    private String email;
    private String role;
    private Boolean accountConfirmed;
    private String pin;
}
