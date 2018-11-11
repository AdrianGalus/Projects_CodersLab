package workshop6.entity;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "messages")
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
    @NotNull
    @NotBlank
    @Column(name = "[read]")
    private Boolean read;
    @ManyToOne
    @JoinColumn(name = "sender_id")
    private User sender;
    @ManyToOne
    @JoinColumn(name = "receiver_id")
    private User receiver;

    public Message() {

        this.read = false;
    }
    public Message(@NotNull String theme, @NotNull String text, @NotNull User sender,
                   @NotNull User receiver) {

        this.theme = theme;
        this.text = text;
        this.read = false;
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
