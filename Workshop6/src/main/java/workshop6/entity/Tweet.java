package workshop6.entity;

import org.hibernate.validator.constraints.NotBlank;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
public class Tweet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @NotBlank
    private User user;
    @NotNull
    @NotBlank
    private String text;
    private final LocalDateTime created;

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
