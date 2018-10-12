package pl.adriangalus.projectscoderslab.workshop2;

import org.mindrot.jbcrypt.BCrypt;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class User {

    private int id;
    private String userName;
    private String email;
    private String password;
    private int userGroupId;

    public User() {}

    public User(String userName, String email, String password) {

        this.userName = userName;
        this.email = email;
        this.setPassword(password);
    }
    public int getId() {

        return id;
    }
    public void setUserName(String userName) {

        this.userName = userName;
    }
    public String getUserName() {

        return userName;
    }
    public void setEmail(String email) {

        this.email = email;
    }
    public String getEmail() {

        return email;
    }
    public void setPassword(String password) {

        this.password = BCrypt.hashpw(password, BCrypt.gensalt());
    }
    public void setUserGroupId(int userGroupId) {

        this.userGroupId = userGroupId;
    }
    public int getUserGroupId() {

        return userGroupId;
    }
    public void saveToDB(Connection conn) throws SQLException {

        if(this.id == 0) {
            String sql = "INSERT INTO users (username, email, password, user_group_id) VALUES (?, ?, ?, ?);";
            String[] generatedColumns = { "ID" };
            PreparedStatement preparedStatement = conn.prepareStatement(sql, generatedColumns);
            preparedStatement.setString(1, this.userName);
            preparedStatement.setString(2, this.email);
            preparedStatement.setString(3, this.password);
            preparedStatement.setInt(4, this.userGroupId);
            preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if(resultSet.next()) {
                this.id = resultSet.getInt(1);
            }
        }
        else {
            String sql = "UPDATE users SET username=?, email=?, password=?, user_group_id=? WHERE id=?;";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, this.userName);
            preparedStatement.setString(2, this.email);
            preparedStatement.setString(3, this.password);
            preparedStatement.setInt(4, this.userGroupId);
            preparedStatement.setInt(5, this.id);
            preparedStatement.executeUpdate();
        }
    }
    public void delete(Connection conn) throws SQLException{

        if(this.id != 0) {
            String sql = "DELETE FROM users WHERE id=?;";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, this.id);
            preparedStatement.executeUpdate();
            this.id = 0;
        }
    }
    public static User[] loadAllUsers(Connection conn) throws SQLException{

        ArrayList<User> users = new ArrayList<>();
        String sql = "SELECT * FROM users;";
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        while(resultSet.next()) {
            User loadedUser = loadDataFromDB(resultSet);
            users.add(loadedUser);
        }
        return convertListToArray(users);
    }
    public static User loadById(Connection conn, int id) throws SQLException{

        String sql = "SELECT * FROM users WHERE id= ?;";
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        if(resultSet.next()) {
            User loadedUser = loadDataFromDB(resultSet);
            return loadedUser;
        }
        return null;
    }
    public static User[] loadAllByGroupId(Connection conn, int id) throws SQLException {

        ArrayList<User> users = new ArrayList<>();
        String sql = "SELECT * FROM users WHERE user_group_id=?;";
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        while(resultSet.next()) {
            User loadedUser = loadDataFromDB(resultSet);
            users.add(loadedUser);
        }
        return convertListToArray(users);
    }
    private static User loadDataFromDB(ResultSet resultSet) throws SQLException {

        User loadedUser = new User();
        loadedUser.id = resultSet.getInt("id");
        loadedUser.userName = resultSet.getString("username");
        loadedUser.email = resultSet.getString("email");
        loadedUser.password = resultSet.getString("password");
        loadedUser.userGroupId = resultSet.getInt("user_group_id");
        return loadedUser;

    }
    private static User[] convertListToArray(List<User> users) {

        User[] uArray = new User[users.size()];
        uArray = users.toArray(uArray);
        return uArray;
    }
}
