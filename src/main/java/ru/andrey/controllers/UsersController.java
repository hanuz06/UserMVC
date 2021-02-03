package ru.andrey.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.andrey.models.User;
import ru.andrey.service.UserService;

import java.util.List;

/**
 * @author Andrey Li
 */
@Controller
public class UsersController {
    private final UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String index(Model model){
        List<User> users = userService.listUsers();
        model.addAttribute("users", users);
        return "index";
    }

    @GetMapping("/users/{id}")
    public String showUser(@PathVariable("id") Long id, Model model){
        model.addAttribute("user", userService.getUser(id));
        return "showUser";
    }

    @GetMapping("/users/new")
    public String newUserForm(@ModelAttribute("user") User user){
        return "newUserForm";
    }

    @PostMapping("/users")
    public String addUser(@ModelAttribute("user") User user){
        if(user.getId()==null){
            userService.addUser(user);
        }else {
            userService.updateUser(user);
        }
        return "redirect:/";
    }

    @GetMapping("/users/{id}/edit")
    public String editUserForm(Model model, @PathVariable("id") Long id){
        model.addAttribute("user", userService.getUser(id));
        return "editUserForm";
    }

    @DeleteMapping("/users/{id}")
    public String deleteUser(@PathVariable("id") Long id){
        userService.deleteUser(id);
        return "redirect:/";
    }
}
