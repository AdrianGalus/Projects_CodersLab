package pl.adriangalus.projectscoderslab.workshop2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Solution {

    private int id;
    private LocalDateTime created;
    private LocalDateTime updated;
    private String description;
    private int exerciseId;
    private int usersId;

    private static final String DATE_FORMAT = "uuuu-MM-dd HH:mm:ss";
    private static final DateTimeFormatter FORMAT = DateTimeFormatter.ofPattern(DATE_FORMAT);

    public Solution() {}

    public Solution(int exerciseId, int usersId) {

        this.created = LocalDateTime.now();
        this.exerciseId = exerciseId;
        this.usersId = usersId;
    }
    public int getId() {

        return id;
    }
    public String getCreated() {

        return created.format(FORMAT);
    }
    public void setCreated(LocalDateTime created) {

        this.created = created;
    }
    public String getUpdated() {

        return updated.format(FORMAT);
    }
    public void setUpdated(LocalDateTime updated) {

        this.updated = updated;
    }
    public String getDescription() {

        return description;
    }
    public void setDescription(String description) {

        this.description = description;
    }
    public int getExerciseId() {

        return exerciseId;
    }
    public void setExerciseId() {

        this.exerciseId = exerciseId;
    }
    public int getUsersId() {

        return usersId;
    }
    public void setUsersId(int id) {

        this.usersId = usersId;
    }
    public void saveToDB(Connection conn) throws SQLException {

        if(this.id == 0) {
            String sql = "INSERT INTO solution (created, exercise_id, users_id) VALUES (?, ?, ?);";
            String[] generatedColumns = { "ID" };
            PreparedStatement preparedStatement = conn.prepareStatement(sql, generatedColumns);
            preparedStatement.setString(1, this.created.toString());
            preparedStatement.setInt(2, this.exerciseId);
            preparedStatement.setInt(3, this.usersId);
            preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if(resultSet.next()) {
                this.id = resultSet.getInt(1);
            }
        }
        else {
            String sql = "UPDATE solution SET (updated=?, exercise_id=?, users_id=? WHERE id=?;";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            this.updated = LocalDateTime.now();
            preparedStatement.setString(1, this.updated.toString());
            preparedStatement.setInt(2, this.exerciseId);
            preparedStatement.setInt(3, this.usersId);
            preparedStatement.setInt(4, this.id);
            preparedStatement.executeUpdate();
        }
    }
    public void delete(Connection conn) throws SQLException {

        if(this.id != 0) {
            String sql = "DELETE FROM solution WHERE id=?;";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, this.id);
            preparedStatement.executeUpdate();
            this.id = 0;
        }
    }
    public static Solution[] loadAllSolutions(Connection conn) throws SQLException {

        ArrayList<Solution> solutions = new ArrayList<>();
        String sql = "SELECT * FROM solution;";
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        while(resultSet.next()) {
            Solution loadSolution = loadDataFromDB(resultSet);
            solutions.add(loadSolution);
        }
        return convertListToArray(solutions);
    }
    public static Solution loadById(Connection conn, int id) throws SQLException {

        String sql = "SELECT * FROM solution WHERE id=?;";
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        if(resultSet.next()) {
            Solution loadSolution = loadDataFromDB(resultSet);
            return loadSolution;
        }
        return null;
    }
    public static Solution[] loadAllByUserId(Connection conn, int id) throws SQLException {

        String sql = "SELECT * FROM solution WHERE users_id=?;";
        ArrayList<Solution> solutions = new ArrayList<>();
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        while(resultSet.next()) {
            Solution loadSolution = loadDataFromDB(resultSet);
            solutions.add(loadSolution);
        }
        return convertListToArray(solutions);
    }
    public static Solution[] loadAllByExerciseId(Connection conn, int id) throws SQLException {

        String sql = "SELECT * FROM solution WHERE exercise_id=?;";
        ArrayList<Solution> solutions = new ArrayList<>();
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        while(resultSet.next()) {
            Solution loadSolution = loadDataFromDB(resultSet);
            solutions.add(loadSolution);
        }
        return convertListToArray(solutions);
    }
    static Solution loadDataFromDB(ResultSet resultSet) throws  SQLException{

        Solution loadSolution = new Solution();
        loadSolution.id = resultSet.getInt("id");
        loadSolution.created = LocalDateTime.parse(resultSet.getString("created"), FORMAT);
        String maybeUpdated = resultSet.getString("updated");
        if(maybeUpdated != null) {
            loadSolution.updated = LocalDateTime.parse(maybeUpdated, FORMAT);
        }
        loadSolution.description = resultSet.getString("description");
        loadSolution.exerciseId = resultSet.getInt("exercise_id");
        loadSolution.usersId = resultSet.getInt("users_id");
        return loadSolution;
    }
    private static Solution[] convertListToArray(List<Solution> solutions) {

        Solution[] uArray = new Solution[solutions.size()];
        uArray = solutions.toArray(uArray);
        return uArray;
    }
}
