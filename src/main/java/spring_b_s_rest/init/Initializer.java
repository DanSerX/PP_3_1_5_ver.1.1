package spring_b_s_rest.init;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import spring_b_s_rest.model.Role;
import spring_b_s_rest.model.User;
import spring_b_s_rest.repository.RoleRepository;
import spring_b_s_rest.repository.UserRepository;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

@Component
public class Initializer implements CommandLineRunner {

    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public Initializer(UserRepository userRepository, RoleRepository roleRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }
    @Transactional
    @Override
    public void run(String... args) throws RuntimeException {
        Role ROLE_ADMIN = new Role("ROLE_ADMIN");
        roleRepository.save(ROLE_ADMIN);
        Role ROLE_USER = new Role("ROLE_USER");
        roleRepository.save(ROLE_USER);
        User admin = new User("admin", "admin", 29, "777-88-99","admin@admin.com", passwordEncoder.encode("admin"), null);
        admin.setRoles(new HashSet<>(Arrays.asList(ROLE_ADMIN, ROLE_USER)));
        userRepository.save(admin);
        User user = new User("user", "user", 28, "777-88-77","user@user.com", passwordEncoder.encode("user"), null);
        user.setRoles(new HashSet<>(Collections.singletonList(ROLE_USER)));
        userRepository.save(user);
    }
}
