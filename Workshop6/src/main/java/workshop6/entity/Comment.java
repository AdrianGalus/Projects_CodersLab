package workshop6.entity;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @NotBlank
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @NotNull
    @NotBlank
    @ManyToOne
    @JoinColumn(name = "tweet_id")
    private Tweet tweet;
    private LocalDateTime created;
    @NotNull
    @NotBlank
    private String text;

    public Comment() {

        this.created = LocalDateTime.now();
    }
    public Comment(Long id, User user, Tweet tweet, String text) {

        this.id = id;
        this.user = user;
        this.tweet = tweet;
        this.created = LocalDateTime.now();
        this.text = text;
    }
    public Long getId() {

        return id;
    }
    public void setId(Long id) {

        this.id = id;
    }
    public User getUser() {

        return user;
    }
    public void setUser(User user) {

        this.user = user;
    }
    public Tweet getTweet() {

        return tweet;
    }
    public void setTweet(Tweet tweet) {

        this.tweet = tweet;
    }
    public LocalDateTime getCreated() {

        return created;
    }
    public String getText() {

        return text;
    }
    public void setText(String text) {

        this.text = text;
    }
}
