package shop.ipwebshop.services.implementation;

import org.modelmapper.ModelMapper;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import shop.ipwebshop.base.CrudJpaService;
import shop.ipwebshop.exceptions.NotFoundException;
import shop.ipwebshop.models.dto.User;
import shop.ipwebshop.models.entities.UserEntity;
import shop.ipwebshop.repositories.UserEntityRepository;
import shop.ipwebshop.services.UserService;

@Service
public class UserServiceImplementation extends CrudJpaService<UserEntity,Integer> implements UserService {
    private final UserEntityRepository repository;

    public UserServiceImplementation(UserEntityRepository repository, ModelMapper modelMapper) {
        super(repository, modelMapper, UserEntity.class);
        this.repository = repository;
    }

    @Override
    public User getUserByUsername(String username){
        return getModelMapper().map(repository.findByUsername(username), User.class);
    }

    @Override
    public User getCurrentUser() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        return super.getModelMapper().map(repository.findByUsername(username),User.class);
    }

    @Override
    public String getCurrentRole() {
        User currentUser = getCurrentUser();
        return currentUser.getRole();
    }

    @Override
    public void updateUserPin(Integer userId, String newPin) {
        User user = getModelMapper().map(repository.findById(userId).orElseThrow(),User.class);

    }
}
