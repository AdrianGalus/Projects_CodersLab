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
    private final LocalDateTime created;
    @NotNull
    @NotBlank
    private String text;

    public Comment() {

        this.created = LocalDateTime.now();
    }
    public Comment(@NotNull User user, @NotNull Tweet tweet, @NotNull String text) {

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
    @NotNull
    public User getUser() {

        return user;
    }
    public void setUser(@NotNull User user) {

        this.user = user;
    }
    @NotNull
    public Tweet getTweet() {

        return tweet;
    }
    public void setTweet(@NotNull Tweet tweet) {

        this.tweet = tweet;
    }
    public LocalDateTime getCreated() {

        return created;
    }
    @NotNull
    public String getText() {

        return text;
    }
    public void setText(@NotNull String text) {

        this.text = text;
    }
}
