package uz.pdp.shaftoli.service.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.pdp.shaftoli.entity.UserEntity;
import uz.pdp.shaftoli.repository.user.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;



    @Override
    public UserEntity add(UserEntity user) {
        return userRepository.save(user);
    }

    @Override
    public List<UserEntity> getAll() {
        return userRepository.getAll();
    }

    @Override
    public UserEntity getById() {
        return null;
    }

    @Override
    public void userValidation(String email) {
       // userRepository.changeValidated(email);
    }

    @Override
    public UserEntity signIn(String email, String password) {
        return userRepository.signIn(email,password);
    }

    @Override
    public UserEntity finById(UUID userId) {
        return userRepository.findById(userId);
    }

}
