package spring_b_s_rest.repository;


import org.springframework.data.repository.CrudRepository;
import spring_b_s_rest.model.Role;

public interface RoleRepository extends CrudRepository<Role, Long> {
}
