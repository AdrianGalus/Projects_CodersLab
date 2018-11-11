package workshop6.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import workshop6.repository.TweetRepository;

@Controller
@RequestMapping("/home")
public class HomeController {

    @Autowired
    TweetRepository tweetRepository;

    @GetMapping("")
    public String home(Model model) {

        model.addAttribute("tweets", tweetRepository.findAll());
        return "index";
    }
}
