package traveller.entity;

import org.mindrot.jbcrypt.BCrypt;

public class User {

    private Long id;
    private String email;
    private String password;

    public User() {}

    public User(String email, String password) {

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
