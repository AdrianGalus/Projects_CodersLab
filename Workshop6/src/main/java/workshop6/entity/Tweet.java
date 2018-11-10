package workshop6.entity;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Tweet {

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
    private String text;
    private final LocalDateTime created;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "tweet")
    private List<Comment> comments = new ArrayList<>();

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
