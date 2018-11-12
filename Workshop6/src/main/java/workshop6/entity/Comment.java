package workshop6.entity;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "comments")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "tweet_id")
    private Tweet tweet;
    private LocalDateTime created;
    @NotNull
    @NotBlank
    private String text;

    public Comment() {}

    public Comment(String text) {

        this.user = new User();
        this.tweet = new Tweet();
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
    @Override
    public String toString() {

        return user.getUserName() +
                ", created: " + created +
                ", text: '" + text + '\'';
    }
}
