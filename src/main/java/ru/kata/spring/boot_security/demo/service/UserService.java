package ru.kata.spring.boot_security.demo.service;

import ru.kata.spring.boot_security.demo.entity.User;

import java.util.List;
import java.util.Optional;

/**
 * Сервисный интерфейс для entity-класса User
 * Чтобы разделить логику и реализацию
 */

public interface UserService {
    Optional<User> findById(int id);
    Optional<User> findByEmail(String email);
    List<User> findAll();
    void deleteById(int id);
    void deleteByEmail(String email);
    void saveUser(User user);
    void updateUser(User user);
}
