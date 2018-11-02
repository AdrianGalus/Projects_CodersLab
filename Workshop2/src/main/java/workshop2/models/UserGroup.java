package workshop2.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserGroup {

    private int id;
    private String name;

    public UserGroup() {}

    public UserGroup(String name) {

        this.name = name;
    }
    public int getId() {

        return id;
    }
    public void setId(int id) {

        this.id = id;
    }
    public void setName(String name) {

        this.name = name;
    }
    public String getName() {

        return name;
    }
    public void saveToDB(Connection conn) throws SQLException{

        if(this.id == 0) {
            String sql = "INSERT INTO user_group (name) VALUES (?);";
            String[] generatedColumns = { "ID" };
            PreparedStatement preparedStatement = conn.prepareStatement(sql, generatedColumns);
            preparedStatement.setString(1, this.name);
            preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if(resultSet.next()) {
                this.id = resultSet.getInt(1);
            }
        }
        else {
            String sql = "UPDATE user_group SET name=? WHERE id=?;";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, this.name);
            preparedStatement.setInt(2, this.id);
            preparedStatement.executeUpdate();
        }
    }
    public void delete(Connection conn) throws SQLException{

        if(this.id != 0) {
            String sql = "DELETE FROM user_group WHERE id=?;";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, this.id);
            preparedStatement.executeUpdate();
            this.id = 0;
        }
    }
    public static UserGroup[] loadAllGroups(Connection conn) throws SQLException {

        ArrayList<UserGroup> groups = new ArrayList<>();
        String sql = "SELECT * FROM user_group;";
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        while(resultSet.next()) {
            UserGroup loadGroup = new UserGroup();
            loadGroup.id = resultSet.getInt("id");
            loadGroup.name = resultSet.getString("name");
            groups.add(loadGroup);
        }
        UserGroup[] uArray = new UserGroup[groups.size()];
        uArray = groups.toArray(uArray);
        return uArray;
    }
}
