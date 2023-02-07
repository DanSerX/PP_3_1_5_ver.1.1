package spring_b_s_rest.repository;

import org.springframework.data.repository.CrudRepository;
import spring_b_s_rest.model.User;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByEmail(String email);
}
