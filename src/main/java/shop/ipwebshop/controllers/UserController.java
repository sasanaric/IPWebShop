package shop.ipwebshop.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import shop.ipwebshop.base.CrudController;
import shop.ipwebshop.base.CrudService;
import shop.ipwebshop.models.dto.User;
import shop.ipwebshop.models.requests.UserRequest;
import shop.ipwebshop.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController extends CrudController<Integer, UserRequest, User> {
    private UserService userService;
    public UserController(UserService userService) {
        super(User.class, userService);
        this.userService = userService;
    }
}
