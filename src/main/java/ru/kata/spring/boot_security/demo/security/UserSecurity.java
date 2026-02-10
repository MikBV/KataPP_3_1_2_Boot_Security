package ru.kata.spring.boot_security.demo.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import ru.kata.spring.boot_security.demo.entity.Role;
import ru.kata.spring.boot_security.demo.entity.User;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Класс связанный с безопасностью, он отвечает за сопоставление Entity User c интерфейсом UserDetails
 */

public class UserSecurity implements UserDetails {
    private final User user;

    public UserSecurity(User user) {
        this.user = user;
    }

    /**
     * Переопределенный метод. Создаёт на базе SimpleGrantedAuthority и entity-класса Role коллекцию GrantedAuthority
     * @return коллекцию GrantedAuthority
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<Role> roles = user.getRoles();
        return roles.stream()
                .map(s -> new SimpleGrantedAuthority(s.getRoleName()))
                .collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return user.isEnabled();
    }
}
