package workshop6.entity;

public class User {

    private Long id;
    private String userName;
    private String password;
    private Boolean enabled;
    private String email;

    public User() {}

    public User(Long id, String userName, String password, Boolean enabled, String email) {

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
