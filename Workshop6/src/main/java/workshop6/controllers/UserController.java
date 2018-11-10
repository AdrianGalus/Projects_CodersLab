package workshop6.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import workshop6.entity.User;
import workshop6.repository.UserRepository;
import javax.validation.Valid;

@Controller
@RequestMapping("/user")
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

        User loadUser = userRepository.findByEmail(user.getEmail());
        if(result.hasErrors() || loadUser != null) {
            return "registration";
        }
        else {
            user.hashPassword();
            userRepository.save(user);
            return "redirect:/home";
        }
    }
    @GetMapping("/login")
    public String login(Model model) {

        model.addAttribute("user", new User());
        return "login";
    }
    @PostMapping("/login")
    public String login(@Valid User user, BindingResult result) {

        if(result.hasErrors()) {
            return "/login";
        }
        User loadUser = userRepository.findByEmail(user.getEmail());
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        if(bCryptPasswordEncoder.matches(user.getPassword(), loadUser.getPassword())) {
            return "redirect:/home";
        }
        else {
            return "/login";
        }

    }
}
