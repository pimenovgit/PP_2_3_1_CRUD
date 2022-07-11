package controller;

import model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import service.UserService;
import service.UserServiceImpl;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {
    private UserService userService;
    @Autowired
    public UserController(UserServiceImpl userService){
        this.userService = userService;
    }


    @GetMapping(value = "/")
    public String printWelcome(ModelMap model) {
        List<String> messages = new ArrayList<>();
        messages.add("Hello!");
        messages.add("Lets go");
        model.addAttribute("welcome", messages);
        return "welcome";
    }

    @GetMapping(value = "/users")
    public String getUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "users";
    }
}
