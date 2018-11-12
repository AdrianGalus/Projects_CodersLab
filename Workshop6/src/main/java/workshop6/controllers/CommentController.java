package workshop6.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import workshop6.entity.Comment;
import workshop6.entity.Tweet;
import workshop6.entity.User;
import workshop6.repository.CommentRepository;
import workshop6.repository.TweetRepository;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    CommentRepository commentRepository;
    @Autowired
    TweetRepository tweetRepository;

    @PostMapping("/create/{tweetId}")
    public String create(@Valid Comment comment, BindingResult result, HttpSession session,
                         @PathVariable Long tweetId, Model model) {
        User user = (User)session.getAttribute("user");
        Tweet tweet = tweetRepository.findOne(tweetId);
        model.addAttribute("tweet", tweet);
        model.addAttribute("comments", commentRepository.findAllByTweetId(tweetId));
        if(user == null || tweet == null || result.hasErrors()) {
            return "tweet";
        }
        else {
            comment.setUser(user);
            comment.setTweet(tweet);
            commentRepository.save(comment);
            model.addAttribute("comment", new Comment());
            return "redirect:/tweet/details/{tweetId}";
        }
    }

}
