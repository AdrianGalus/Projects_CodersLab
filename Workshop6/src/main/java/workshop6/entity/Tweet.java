package workshop6.entity;

import org.hibernate.validator.constraints.NotBlank;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tweets")
public class Tweet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @NotNull
    @NotBlank
    private String text;
    private LocalDateTime created;
    @OneToMany(mappedBy = "tweet")
    private List<Comment> comments = new ArrayList<>();

    public Tweet() {}

    public Tweet(String text) {

        this.user = new User();
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
    public List<Comment> getComments() {

        return comments;
    }
    public void setComments(List<Comment> comments) {

        this.comments = comments;
    }
    @Override
    public String toString() {
        return  user.getUserName() +
                ", created: " + created +
                ", text: '" + text + '\'';
    }
}
