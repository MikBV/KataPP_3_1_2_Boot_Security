package ru.kata.spring.boot_security.demo.entity;

import org.hibernate.validator.constraints.Range;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
public class User {
    /**
     * Поля
     */

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;

    @Column (nullable = false, unique = true)
    @NotBlank
    @Email
    @UniqueElements
    private String email;

    @Column (nullable = false)
    @NotBlank
    private String password;

    @Column (nullable = false)
    @NotBlank
    private String firstName;

    @Column (nullable = false)
    @NotBlank
    private String lastName;

    @Column (nullable = false)
    @Range(min = 5, max = 140)
    private int age;

    @Column (nullable = false)
    boolean enabled;

    @ManyToMany
    @JoinTable (name = "users-roles")
    private List<Role> roles;

    /**
     * Конструкторы
     */

    public User(int id, String email, String password, String firstName, String lastName, int age, List<Role> roles) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.roles = roles;
        this.enabled = true;
    }

    public User() {}

    /**
     * Гетеры и сетеры
     */

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public @NotBlank @Email @UniqueElements String getEmail() {
        return email;
    }

    public void setEmail(@NotBlank @Email @UniqueElements String email) {
        this.email = email;
    }

    public @NotBlank String getPassword() {
        return password;
    }

    public void setPassword(@NotBlank String password) {
        this.password = password;
    }

    public @NotBlank String getFirstName() {
        return firstName;
    }

    public void setFirstName(@NotBlank String firstName) {
        this.firstName = firstName;
    }

    public @NotBlank String getLastName() {
        return lastName;
    }

    public void setLastName(@NotBlank String lastName) {
        this.lastName = lastName;
    }

    @Range(min = 5, max = 140)
    public int getAge() {
        return age;
    }

    public void setAge(@Range(min = 5, max = 140) int age) {
        this.age = age;
    }

    public boolean isEnabled() {
        return enabled;
    }
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
