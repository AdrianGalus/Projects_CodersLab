package traveller.entity;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.mindrot.jbcrypt.BCrypt;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @NotBlank
    private String userName;
    @NotNull
    @NotBlank
    @Email
    @Column(unique = true)
    private String email;
    @NotNull
    @NotBlank
    private String password;

    public User() {}

    public User(String userName, String email, String password) {

        this.userName = userName;
        this.email = email;
        this.setPassword(password);
    }
    public Long getId() {

        return id;
    }
    public void setId(Long id) {

        if (this.id == null) {
            this.id = id;
        }
    }
    public String getUserName() {

        return userName;
    }
    public void setUserName(String userName) {

        this.userName = userName;
    }
    public String getEmail() {

        return email;
    }
    public void setEmail(String email) {

        this.email = email;
    }
    public String getPassword() {

        return password;
    }
    public void setPassword(String password) {

        this.password = password;
    }
    public void hashPassword() {

        this.password = BCrypt.hashpw(password, BCrypt.gensalt());
    }
}
