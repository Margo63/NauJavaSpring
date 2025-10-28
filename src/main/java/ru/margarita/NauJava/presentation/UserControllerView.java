package ru.margarita.NauJava.presentation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.margarita.NauJava.data.repositories.UserRepository;
import ru.margarita.NauJava.entities.User;

/**
 * Класс для отображения списка пользователей
 *
 * @author Margarita
 * @version 2.0
 * @since 2025-10-27
 */
@Controller
@RequestMapping(value = "/custom/users/view", method = RequestMethod.GET)
public class UserControllerView {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/list")
    public String userListView(Model model){
        Iterable<User> products = userRepository.findAll();
        model.addAttribute("users",products);
        return "userList";
    }
}
