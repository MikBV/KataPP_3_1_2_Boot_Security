package ru.kata.spring.boot_security.demo.init;

import org.springframework.stereotype.Component;
import ru.kata.spring.boot_security.demo.entity.Role;
import ru.kata.spring.boot_security.demo.entity.User;
import ru.kata.spring.boot_security.demo.repository.RoleRepository;
import ru.kata.spring.boot_security.demo.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс для создания двух пользователей в базе.
 */

@Component
public class InitialInit {
    public InitialInit(UserRepository userRepository, RoleRepository roleRepository) {
        Role roleUser = new Role("ROLE_USER");
        Role roleAdmin = new Role("ROLE_ADMIN");

        List<Role> rolesForUser = new ArrayList<>();
        rolesForUser.add(roleUser);
        List<Role> rolesForAdmin = new ArrayList<>(rolesForUser);
        rolesForAdmin.add(roleAdmin);

        User user = new User("user@user.com", "root", "User", "User",13, rolesForUser);
        User admin = new User("admin@ad.com", "123", "Admin", "Admin",55, rolesForAdmin);

        userRepository.save(user);
        userRepository.save(admin);

        roleRepository.save(roleUser);
        roleRepository.save(roleAdmin);
    }
}
