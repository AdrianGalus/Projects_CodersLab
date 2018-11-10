package workshop6.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import workshop6.entity.User;
import workshop6.repository.UserRepository;

import javax.validation.Valid;

@Controller
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/registration")
    public String registration(Model model) {

        model.addAttribute("user", new User());
        return "registration";
    }
    @PostMapping("/registration")
    public String registration(@Valid User user, BindingResult result) {

        if(result.hasErrors()) {
            return "registration";
        }
        else {
            userRepository.save(user);
            return "redirect:/";
        }
    }
}
