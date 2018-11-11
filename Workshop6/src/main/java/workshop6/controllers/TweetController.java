package workshop6.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import workshop6.entity.Tweet;
import workshop6.entity.User;
import workshop6.repository.TweetRepository;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;


@Controller
@RequestMapping("/tweet")
public class TweetController {

    @Autowired
    TweetRepository tweetRepository;

    @PostMapping("/create")
    public String create(@Valid Tweet tweet, BindingResult result, HttpSession session) {

        User user = (User)session.getAttribute("user");
        if(user == null) {
            return "redirect:/home";
        }
        tweet.setUser(user);
        if(result.hasErrors()) {
            return "redirect:/home";
        }
        else {
            tweetRepository.save(tweet);
            return "redirect:/home";
        }
    }
}
