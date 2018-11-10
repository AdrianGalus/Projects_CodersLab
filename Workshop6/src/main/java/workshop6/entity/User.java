package workshop6.entity;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @NotBlank
    private String userName;
    @NotNull
    @NotBlank
    private String password;
    @NotNull
    @NotBlank
    private Boolean enabled;
    @Email
    private String email;


    public User() {}

    public User(String userName, String password, Boolean enabled, String email) {

        this.id = id;
        this.userName = userName;
        this.password = password;
        this.enabled = enabled;
        this.email = email;
    }
    public Long getId() {

        return id;
    }
    public void setId(Long id) {

        this.id = id;
    }
    public String getUserName() {

        return userName;
    }
    public void setUserName(String userName) {

        this.userName = userName;
    }
    public String getPassword() {

        return password;
    }
    public void setPassword(String password) {

        this.password = password;
    }
    public Boolean getEnabled() {

        return enabled;
    }
    public void setEnabled(Boolean enabled) {

        this.enabled = enabled;
    }
    public String getEmail() {

        return email;
    }
    public void setEmail(String email) {

        this.email = email;
    }
}
