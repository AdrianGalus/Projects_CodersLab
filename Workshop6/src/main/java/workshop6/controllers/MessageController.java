package workshop6.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import workshop6.entity.Message;
import workshop6.entity.User;
import workshop6.repository.MessageRepository;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/message")
public class MessageController {

    @Autowired
    MessageRepository messageRepository;

    @GetMapping("/received")
    public String receivedMessages(Model model, HttpSession session) {

        User user = (User)session.getAttribute("user");
        if(user == null) {
            return "redirect:/home";
        }
        else {
            model.addAttribute("receivedMessages", messageRepository.findAllByReceiverId(user.getId()));
            return "receivedMessages";
        }
    }
    @GetMapping("/sended")
    public String sendedMessages(Model model, HttpSession session) {

        User user = (User)session.getAttribute("user");
        if(user == null) {
            return "redirect:/home";
        }
        else {
            model.addAttribute("sendedMessages", messageRepository.findAllBySenderId(user.getId()));
            return "sendedMessages";
        }
    }
    @GetMapping("/details/{id}")
    public String details(@PathVariable Long id, Model model) {

        Message message = messageRepository.findOne(id);
        model.addAttribute("message", message);
        message.setRead(true);
        messageRepository.save(message);
        return "message";
    }
}
