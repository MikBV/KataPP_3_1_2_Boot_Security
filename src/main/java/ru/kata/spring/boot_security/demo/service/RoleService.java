package ru.kata.spring.boot_security.demo.service;


import ru.kata.spring.boot_security.demo.entity.Role;

import java.util.Optional;

/**
 * Сервисный интерфейс для entity-класса Role
 * Чтобы разделить логику и реализацию
 */

public interface RoleService {
    Optional<Role> findRoleByRoleName(String roleName);
    Optional<Role> findRoleById(int id);
    void saveRole(Role role);
    void deleteRoleById(int id);
    void deleteRole(Role role);
    void updateRole(Role role);
}
