package workshop6.entity;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @NotBlank
    private String theme;
    @NotNull
    @NotBlank
    private String text;
    private Boolean read;
    @NotNull
    @NotBlank
    @ManyToOne
    @JoinColumn(name = "sender_id")
    private User sender;
    @NotNull
    @NotBlank
    @ManyToOne
    @JoinColumn(name = "receiver_id")
    private User receiver;

    public Message() {}

    public Message(@NotNull String theme, @NotNull String text, Boolean read, @NotNull User sender,
                   @NotNull User receiver) {

        this.theme = theme;
        this.text = text;
        this.read = read;
        this.sender = sender;
        this.receiver = receiver;
    }
    public Long getId() {

        return id;
    }
    public void setId(Long id) {

        this.id = id;
    }
    @NotNull
    public String getTheme() {

        return theme;
    }
    public void setTheme(@NotNull String theme) {

        this.theme = theme;
    }
    @NotNull
    public String getText() {

        return text;
    }
    public void setText(@NotNull String text) {

        this.text = text;
    }
    public Boolean getRead() {

        return read;
    }
    public void setRead(Boolean read) {

        this.read = read;
    }
    @NotNull
    public User getSender() {

        return sender;
    }
    public void setSender(@NotNull User sender) {

        this.sender = sender;
    }
    @NotNull
    public User getReceiver() {

        return receiver;
    }
    public void setReceiver(@NotNull User receiver) {

        this.receiver = receiver;
    }
}
