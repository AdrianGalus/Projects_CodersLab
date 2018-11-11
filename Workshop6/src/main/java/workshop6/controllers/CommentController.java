package workshop6.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    CommentRepository commentRepository;
    @Autowired
    TweetRepository tweetRepository;

    @PostMapping("/create/{id}")
    public String create(@Valid Comment comment, BindingResult result, HttpSession session,
                         @PathVariable Long id, Model model) {

        User user = (User)session.getAttribute("user");
        Tweet tweet = tweetRepository.findOne(id);
        if(user == null || tweet == null || result.hasErrors()) {
            return "redirect:/home";
        }
        else {
            comment.setUser(user);
            comment.setTweet(tweet);
            System.out.println(comment.toString());
            commentRepository.save(comment);
            model.addAttribute("tweet", tweet);
            model.addAttribute("comments", commentRepository.findAllByTweetId(id));
            model.addAttribute("comment", new Comment());
            return "redirect:/tweet/details/{id}";
        }
    }
}
