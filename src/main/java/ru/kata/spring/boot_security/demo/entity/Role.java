package ru.kata.spring.boot_security.demo.entity;

import com.sun.istack.NotNull;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;

@Entity
public class Role {

    /**
     * Поля
     */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    @NotNull
    private String roleName;

    @ManyToMany(mappedBy = "roles")
    private List<User> users;

    public Role(String roleName) {
        this.roleName = roleName;
    }

    public Role() {
    }

    /**
     * Геттеры и сеттеры
     */

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public List<User> getUsers() {
        return users;
    }

    /**
     * Кастомный метод для добавления роли. Из-за управляемой стороны связи, напрямую внести изменения нельзя. Они не
     * сохранятся. Поэтому мы добавляем роль конкретному пользователю
     * @param user - тот пользователь, которому нужно добавить текущую роль
     */
    public void addUser(User user) {
        this.users.add(user);
        user.getRoles().add(this);
    }

    /**
     * Кастомный метод для удаления роли. Из-за управляемой стороны связи, напрямую внести изменения нельзя. Они не
     * сохранятся. Поэтому мы удаляем роль у конкретного пользователя
     * @param user - тот пользователь, которому нужно удалить текущую роль
     */
    public void deleteUser(User user) {
        this.users.remove(user);
        user.getRoles().remove(this);
    }
}
