package ru.kata.spring.boot_security.demo.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.kata.spring.boot_security.demo.configs.SuccessUserHandler;
import ru.kata.spring.boot_security.demo.security.UserSecurity;

/**
 * Контроллер для маппинга страниц с ролью Юзер
 * TODO доделать авторизацию юзера
 */

@Controller
@RequestMapping(value = "/user")
public class UserController {
    @GetMapping("/mypage")
    public String index(Model model) {
//        UserSecurity currentUser = Authentication;
//        model.addAttribute("user", currentUser);
        return "user/mypage";
    }
}
