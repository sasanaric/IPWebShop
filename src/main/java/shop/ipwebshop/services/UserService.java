package shop.ipwebshop.services;

import shop.ipwebshop.base.CrudService;
import shop.ipwebshop.models.dto.User;

public interface UserService extends CrudService<Integer> {
    User getUserByUsername(String username);
    User getCurrentUser();
    String getCurrentRole();
    void updateUserPin(Integer userId, String newPin);
}
