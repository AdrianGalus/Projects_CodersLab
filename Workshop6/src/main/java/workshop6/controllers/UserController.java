package workshop6.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import workshop6.entity.User;

@Controller
public class UserController {

    @GetMapping("/registration")
    public String registration(Model model) {

        model.addAttribute("user", new User());
        return "registration";
    }
}
