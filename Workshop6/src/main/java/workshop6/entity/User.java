package workshop6.entity;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.mindrot.jbcrypt.BCrypt;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @NotBlank
    private String userName;
    @NotNull
    @NotBlank
    private String password;
    private Boolean enabled;
    @Email
    @NotNull
    @NotBlank
    @Column(unique = true)
    private String email;
    @OneToMany(mappedBy = "user")
    private List<Tweet> tweets = new ArrayList<>();
    @OneToMany(mappedBy = "user")
    private List<Comment> comments = new ArrayList<>();
    @OneToMany(mappedBy = "receiver")
    private List<Message> receivedMessages = new ArrayList<>();
    @OneToMany(mappedBy = "sender")
    private List<Message> sendedMessages = new ArrayList<>();

    public User() {

        this.enabled = false;
    }
    public User(@NotNull String userName, @NotNull String password, String email) {

        this.userName = userName;
        this.setPassword(password);
        this.enabled = false;
        this.email = email;
    }
    public Long getId() {

        return id;
    }
    public void setId(Long id) {

        this.id = id;
    }
    @NotNull
    public String getUserName() {

        return userName;
    }
    public void setUserName(@NotNull String userName) {

        this.userName = userName;
    }
    @NotNull
    public String getPassword() {

        return password;
    }
    public void setPassword(@NotNull String password) {

        this.password = password;

    }
    public void hashPassword() {

        this.password = BCrypt.hashpw(password, BCrypt.gensalt());
    }
    public Boolean getEnabled() {

        return enabled;
    }
    public void setEnabled(Boolean enabled) {

        this.enabled = enabled;
    }
    public String getEmail() {

        return email;
    }
    public void setEmail(String email) {

        this.email = email;
    }
    public List<Tweet> getTweets() {

        return tweets;
    }
    public void setTweets(List<Tweet> tweets) {

        this.tweets = tweets;
    }
    public List<Comment> getComments() {

        return comments;
    }
    public void setComments(List<Comment> comments) {

        this.comments = comments;
    }
    public List<Message> getReceivedMessages() {

        return receivedMessages;
    }
    public void setReceivedMessages(List<Message> receivedMessages) {

        this.receivedMessages = receivedMessages;
    }
    public List<Message> getSendedMessages() {

        return sendedMessages;
    }
    public void setSendedMessages(List<Message> sendedMessages) {

        this.sendedMessages = sendedMessages;
    }
}
