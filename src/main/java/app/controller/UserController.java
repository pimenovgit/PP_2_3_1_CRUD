package app.controller;

import app.model.Users;
import app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;;


@Controller
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }


    @GetMapping(value = "/users")
    public String getUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "users";
    }
    @GetMapping(value = "/{id}")
    public String getUserId(@PathVariable("id") Long id, Model model) {
        model.addAttribute("user", userService.getUserId(id));
        return "showUser";
    }

    @GetMapping(value = "/create")
    public String newUser(Model model) {
        model.addAttribute("user", new Users());
        return "create";
    }

    @PostMapping()
    public String createUser(@ModelAttribute("user") Users user){
        userService.createUser(user);
        return "redirect:/users";
    }

    @GetMapping(value = "/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.removeUser(id);
        return "redirect:/users";
    }

    @GetMapping(value = "/update/{id}")
    public String updateUserForm(@PathVariable("id") Long id, Model model) {
        model.addAttribute("user", userService.updateUser(user);)
        return "/update";
    }

    @PostMapping("/update")
    public String updateUser(Users user) {
        userService.updateUser(user);
        return "redirect:/users";

    }

}
