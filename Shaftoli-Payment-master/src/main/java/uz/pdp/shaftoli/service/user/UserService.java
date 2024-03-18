package uz.pdp.shaftoli.service.user;

import uz.pdp.shaftoli.entity.UserEntity;
import uz.pdp.shaftoli.service.BaseService;

import java.util.UUID;


public interface
UserService extends BaseService<UserEntity> {
    void userValidation(String email);
    UserEntity signIn(String email, String password);

    UserEntity finById(UUID userId);
}
