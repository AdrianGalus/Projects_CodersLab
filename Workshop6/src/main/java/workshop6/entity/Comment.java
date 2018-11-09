package workshop6.entity;

import java.time.LocalDateTime;

public class Comment {

    private Long id;
    private User user;
    private Tweet tweet;
    private LocalDateTime created;
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
