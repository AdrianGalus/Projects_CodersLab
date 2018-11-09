package workshop6.entity;

import java.time.LocalDateTime;

public class Tweet {

    private Long id;
    private User user;
    private String text;
    private LocalDateTime created;

    public Tweet() {

        this.created = LocalDateTime.now();
    }
    public Tweet(Long id, User user, String text) {

        this.id = id;
        this.user = user;
        this.text = text;
        this.created = LocalDateTime.now();
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
    public String getText() {

        return text;
    }
    public void setText(String text) {

        this.text = text;
    }
    public LocalDateTime getCreated() {

        return created;
    }
}
