package workshop6.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import workshop6.entity.Comment;
import workshop6.entity.Tweet;
import workshop6.entity.User;
import workshop6.repository.CommentRepository;
import workshop6.repository.TweetRepository;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/tweet")
public class TweetController {

    @Autowired
    TweetRepository tweetRepository;
    @Autowired
    CommentRepository commentRepository;

    @PostMapping("/create")
    public String create(@Valid Tweet tweet, BindingResult result, HttpSession session) {

        User user = (User)session.getAttribute("user");
        if(user == null || result.hasErrors()) {
            return "redirect:/home";
        }
        else {
            tweet.setUser(user);
            tweetRepository.save(tweet);
            return "redirect:/home";
        }
    }
    @GetMapping("/userTweets")
    public String showAllUsersTweets(HttpSession session, Model model) {

        User user = (User)session.getAttribute("user");
        if(user == null) {
            return "redirect:/home";
        }
        model.addAttribute("tweets", tweetRepository.findByUserId(user.getId()));
        return "userSite";
    }
    @GetMapping("/details/{id}")
    public String details(@PathVariable Long id, Model model) {

        model.addAttribute("tweet", tweetRepository.findOne(id));
        model.addAttribute("comments", commentRepository.findAllByTweetId(id));
        model.addAttribute("comment", new Comment());
        return "tweet";
    }
}
