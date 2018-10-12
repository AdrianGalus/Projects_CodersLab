package workshop2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Exercise {

    private int id;
    private String title;
    private String description;

    public Exercise() {}

    public Exercise(String title, String description) {

        this.title = title;
        this.description = description;
    }
    public int getId() {

        return id;
    }
    public void setTitle(String title) {

        this.title = title;
    }
    public String getTitle() {

        return title;
    }
    public void setDescription(String description) {

        this.description = description;
    }
    public String getDescription() {

        return description;
    }
    public void saveToDB(Connection conn) throws SQLException {

        if(this.id == 0) {
            String sql = "INSERT INTO exercise (title, description) VALUES (?, ?);";
            String[] generatedColumns = { "ID" };
            PreparedStatement preparedStatement = conn.prepareStatement(sql, generatedColumns);
            preparedStatement.setString(1, this.title);
            preparedStatement.setString(2, this.description);
            preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if(resultSet.next()) {
                this.id = resultSet.getInt(1);
            }
        }
        else {
            String sql = "UPDATE exercise SET title=?, description=? WHERE id=?;";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, this.title);
            preparedStatement.setString(2, this.description);
            preparedStatement.setInt(3, this.id);
            preparedStatement.executeUpdate();
        }
    }
    public void delete(Connection conn) throws SQLException {

        if(this.id != 0) {
            String sql = "DELETE FROM exercise WHERE id=?;";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, this.id);
            preparedStatement.executeUpdate();
            this.id = 0;
        }
    }
    public static Exercise[] loadAllExercises(Connection conn) throws SQLException {

        ArrayList<Exercise> exercises = new ArrayList<>();
        String sql = "SELECT * FROM exercise;";
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        while(resultSet.next()) {
            Exercise loadExercise = loadDataFromDB(resultSet);
            exercises.add(loadExercise);
        }
        Exercise[] uArray = new Exercise[exercises.size()];
        uArray = exercises.toArray(uArray);
        return uArray;
    }
    public static Exercise loadById(Connection conn, int id) throws SQLException {

        String sql = "SELECT * FROM exercise WHERE id = ?;";
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        if(resultSet.next()) {
            Exercise loadExercise = loadDataFromDB(resultSet);
            return loadExercise;
        }
        return null;
    }
    public static Exercise[] loadExercisesNotMadeByThisUser(Connection conn, int userId) throws SQLException {

        String sql = "SELECT exercise.id, exercise.title, exercise.description FROM exercise " +
                "WHERE exercise.id NOT IN (SELECT exercise.id FROM exercise " +
                "JOIN solution ON exercise.id = solution.exercise_id " +
                "JOIN users ON users.id = solution.users_id WHERE users.id = ?);";
        ArrayList<Exercise> loadedExercises = new ArrayList<>();
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setInt(1, userId);
        ResultSet resultSet = preparedStatement.executeQuery();
        while(resultSet.next()) {
            Exercise loadExercise = Exercise.loadDataFromDB(resultSet);
            loadedExercises.add(loadExercise);
        }
        return convertListToArray(loadedExercises);
    }
    static Exercise loadDataFromDB(ResultSet resultSet) throws  SQLException{

        Exercise loadExercise = new Exercise();
        loadExercise.id = resultSet.getInt("id");
        loadExercise.title = resultSet.getString("title");
        loadExercise.description = resultSet.getString("description");
        return loadExercise;
    }
    private static Exercise[] convertListToArray(List<Exercise> exercises) {

        Exercise[] uArray = new Exercise[exercises.size()];
        uArray = exercises.toArray(uArray);
        return uArray;
    }
}
