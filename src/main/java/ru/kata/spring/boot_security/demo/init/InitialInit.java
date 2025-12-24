package ru.kata.spring.boot_security.demo.init;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import ru.kata.spring.boot_security.demo.entity.Role;
import ru.kata.spring.boot_security.demo.entity.User;
import ru.kata.spring.boot_security.demo.repository.RoleRepository;
import ru.kata.spring.boot_security.demo.repository.UserRepository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * Класс для создания двух пользователей в базе.
 */

@Component
public class InitialInit {
    UserRepository userRepository;
    RoleRepository roleRepository;
    PasswordEncoder passwordEncoder;

    @Autowired
    public InitialInit(UserRepository userRepository, RoleRepository roleRepository, @Lazy PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostConstruct
    @Transactional
    public void init() {
        Role roleUser = new Role("ROLE_USER");
        Role roleAdmin = new Role("ROLE_ADMIN");

        List<Role> rolesForUser = new ArrayList<>();
        rolesForUser.add(roleUser);
        List<Role> rolesForAdmin = new ArrayList<>(rolesForUser);
        rolesForAdmin.add(roleAdmin);

        User user = new User( "user@user.com", passwordEncoder.encode("root"), "User", "User",13, rolesForUser);
        User admin = new User("admin@ad.com", passwordEncoder.encode("123"), "Admin", "Admin",55, rolesForAdmin);

        userRepository.save(user);
        //userRepository.save(admin); // I don't know why i can't save admin

        //roleRepository.save(roleUser);
        //roleRepository.save(roleAdmin);

    }

}
