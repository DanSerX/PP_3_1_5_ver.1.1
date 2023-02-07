package spring_b_s_rest.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import spring_b_s_rest.model.User;

import java.util.Optional;

public interface UserService extends UserDetailsService {

    void createUser(User user);
    Iterable<User> getAllUsers();
    void updateUser(User user);
    void deleteUser(User user);
    Optional<User> getUserById(Long id);
    void deleteUserById(Long id);
    User getUserByEmail(String email);
}
